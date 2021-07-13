
package Modelo;

import Auxiliar.Consts;
import static Auxiliar.Consts.TIMER_DISPARO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Fase implements Runnable {
    private int faseAtual;
    private int dificuldade;
    public ArrayList<Elemento> eElementos;
    public Galinha hHero;
    private ObservadorCarros observaCarros;
    private CarroFactory fabricaCarros = new CarroFactory();
    
    private void declaraElementos(){
        if(eElementos != null)
            eElementos.clear();
        Carro aux;
        eElementos = new ArrayList(15);
        ArrayList<Carro> cCarros = new ArrayList(11); //auxliar
        hHero = Galinha.instanciar("galinha.png", 0, 4*TIMER_DISPARO);
        eElementos.add(hHero);
  
        String cores[] = {"amarelo", "laranja", "azul", "marrom", "rosa", "verde_claro","vermelho_claro", "vermelho_esc", "azul", "verde_claro" };
        //padrao de corportamento da dificuldade 0,1 e 2
        int padrao[][] = {{6,7,4,2,0,4,0,2,4,0}, {0,1,2,5,0,4,0,2,4,0}, {4,5,0,2,1,8,8,2,1,0} };
        int k = 10;
        int coluna=0;
        int direcao = 1;
        
        //cria cada um dos carros a partir de sua cor e padrao    
        for(String cor : cores){
            //muda os carros de lado a partir da 5 pista
            if(k<=5){
                coluna = TIMER_DISPARO*23;
                direcao = -1;
            }
            aux = fabricaCarros.retornaCarro("carro_"+cor + ".png", true, cor, k,coluna,padrao[dificuldade][10-k],direcao);
            eElementos.add(aux);
            cCarros.add(aux);
            k--;
        }
        
        observaCarros = new ObservadorCarros(cCarros);
        
        return;
    }
    
    public Fase(int dif){
        dificuldade = dif;
        faseAtual = 0;
        declaraElementos();
    
    }
    
    public int vidaGalinha(){
        return hHero.vida;
    }
    
    public void incrementaFase(){
        faseAtual++;
        hHero.setPosicao(hHero.pInicial.getLinha(), hHero.pInicial.getColuna());
        observaCarros.update(faseAtual);
        
        return;
    } 
    
    public int mostraDificuldade(){
        return dificuldade;
    }
    
    public int mostraFase(){
        return faseAtual;
    }
    
    public void restart(){
        eElementos.clear();
        faseAtual = 0;
        hHero.matarGalinha();
        declaraElementos();
        observaCarros.update(-1);
    }
    
    // dono == 1 -> o save foi feito pelo player; dono == 0 -> save automatico
    public void save(int dono){
        File save;
        if(dono == 0)
            save = new File("."+File.separator+"saves"+File.separator+"player_save.zip");
        else
            save = new File("."+File.separator+"saves"+File.separator+"automatic_save.zip");
        
        if(save.exists())
            save.delete();
        
        try {
            save.createNewFile();
            FileOutputStream canoOut = new FileOutputStream(save);
            GZIPOutputStream compactador = new GZIPOutputStream(canoOut);
            ObjectOutputStream serializador = new ObjectOutputStream(compactador);
            
            serializador.writeObject(eElementos);
            serializador.writeObject(new Integer(faseAtual));
            serializador.flush();
            
            serializador.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        return;
    }
    
    public void retornaAoSave(int dono){
        File save;
        if(dono == 0)
            save = new File("."+File.separator+"saves"+File.separator+"player_save.zip");
        else
            save = new File("."+File.separator+"saves"+File.separator+"automatic_save.zip");
        
        if(save.exists())
            try{
                FileInputStream canoIn = new FileInputStream(save);
                GZIPInputStream descompactador = new GZIPInputStream(canoIn);
                ObjectInputStream deserializador = new ObjectInputStream(descompactador);
                
                // recuperando elemetos da tela
                eElementos.clear();
                eElementos = (ArrayList) deserializador.readObject();
                hHero = (Galinha) eElementos.get(0);
                hHero.setPosicao(hHero.pInicial.getLinha(), hHero.pInicial.getColuna());
                ArrayList<Carro> cCarros = new ArrayList(11); //auxliar
                for(int i = 1; i < eElementos.size(); i++)
                    cCarros.add((Carro) eElementos.get(i));
                observaCarros.update(-1);
                observaCarros = new ObservadorCarros(cCarros);
                
                Integer aux = (Integer) deserializador.readObject();
                faseAtual = aux.intValue();
                    
            }catch(IOException e){
                System.out.println(e.getMessage());
            } catch(ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
    }

    @Override
    public void run() {
        TimerTask redesenhar = new TimerTask() {
            public void run() {
                save(1);
                System.out.println("Save Automatico feito!");
            }
        };  
        
        int periodo = 20; // em segundos
        /* // estou tendo um problema com o metodo parseInt
        try{
            File p = new File("."+File.separator+"intervalo_de_salvamento.txt");
            FileInputStream cano = new FileInputStream(p);
            InputStreamReader filtro = new InputStreamReader(cano);
            char[] umPeriodo = new char[100];
            filtro.read(umPeriodo);
            periodo = Integer.parseInt(new String(umPeriodo));
        } catch(FileNotFoundException e){
            System.out.println("O arquivo de tempo foi excluido!");
        } catch(IOException e){
                System.out.println(e.getMessage());
        }*/
        
        Timer timer = new Timer();
        timer.schedule(redesenhar, 0, periodo*1000);
    }
}
