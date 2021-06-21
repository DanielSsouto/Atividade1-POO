
package Modelo;

import Auxiliar.Consts;
import static Auxiliar.Consts.TIMER_DISPARO;
import java.util.ArrayList;

public class Fase {
    private int faseAtual;
    private int dificuldade;
    public Galinha hHero;
    public ArrayList<Elemento> eElementos = null;
    private ArrayList<Carro> cCarros = null;
    
    private void declaraElementos(){
        if(eElementos != null)
            eElementos.clear();
        Carro aux;
        eElementos = new ArrayList(15);
        cCarros = new ArrayList(11);
        hHero = new Galinha("galinha.png", 0, 4*TIMER_DISPARO);
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
            aux = new Carro("carro_"+cor + ".png", true, cor, k,coluna,padrao[dificuldade][10-k],direcao);
            eElementos.add(aux);
            cCarros.add(aux);
            k--;
        }
        return;
    }
    public int vidaGalinha(){
            return hHero.vida;
    }
    public Fase(int dif){
        dificuldade = dif;
        faseAtual = 0;
        declaraElementos();
    
    }
    
    // aumenta a velocidade dos carrinhos
    private void mudaCarrinhos(){
        for(Carro aux : cCarros)
            aux.aumentaVelocidade();
    
    }
    
    private void piscaCarrinhos(){
       for(Carro aux : cCarros){
          
           aux.piscar = true;
           aux.intervalo_piscada[0] = Math.random()*2*Consts.RES;
           double auxiliar = Math.min(4, 2*Consts.RES - aux.intervalo_piscada[0]);
           aux.intervalo_piscada[1] = auxiliar + aux.intervalo_piscada[0];
           
           System.out.println("intervalo de piscada:" + String.valueOf(aux.intervalo_piscada[0])+"  "+String.valueOf(aux.intervalo_piscada[1]) );
        }
       
    }
    
    public void incrementaFase(){
        faseAtual++;
        hHero.setPosicao(hHero.pInicial.getLinha(), hHero.pInicial.getColuna());
        if(faseAtual == 10) // a cada dez fases, uma nova dificuldade eh criada
            mudaCarrinhos();
        if(faseAtual == 20)
            piscaCarrinhos();
        
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
        cCarros.clear();
        faseAtual = 0;
        declaraElementos();
    }
}
