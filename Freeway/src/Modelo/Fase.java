
package Modelo;

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
        
        if (dificuldade == 0){ // 3 tipos de carros apenas
            aux = new Carro("carro_amarelo.png", true, "amarelo", 10, 0, 0, 1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_laranja.png", true, "laranja", 9, 0, 5, 1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_azul.png", true, "azul", 8, 0, 4, 1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_marrom.png", true, "marrom", 7, 0, 2, 1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_rosa.png", true, "rosa", 6, 0, 0, 1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_verde_claro.png", true, "verde_claro", 5, TIMER_DISPARO*23, 4, -1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_vermelho_claro.png", true, "vermelho_claro", 4, TIMER_DISPARO*23, 0, -1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_vermelho_esc.png", true, "vermelho_esc", 3, TIMER_DISPARO*23, 2, -1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_azul.png", true, "azul", 2, TIMER_DISPARO*23, 4, -1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_verde_claro.png", true, "verde_claro", 1, TIMER_DISPARO*23, 0, -1);
            eElementos.add(aux);
            cCarros.add(aux);
        
        } else if(dificuldade == 1){ // 5 tipos de carros
            aux = new Carro("carro_amarelo.png", true, "amarelo", 10, 0, 0, 1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_laranja.png", true, "laranja", 9, 0, 1, 1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_azul.png", true, "azul", 8, 0, 2, 1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_marrom.png", true, "marrom", 7, 0, 5, 1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_rosa.png", true, "rosa", 6, 0, 0, 1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_verde_claro.png", true, "verde_claro", 5, TIMER_DISPARO*23, 4, -1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_vermelho_claro.png", true, "vermelho_claro", 4, TIMER_DISPARO*23, 0, -1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_vermelho_esc.png", true, "vermelho_esc", 3, TIMER_DISPARO*23, 2, -1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_azul.png", true, "azul", 2, TIMER_DISPARO*23, 4, -1);
            eElementos.add(aux);
            cCarros.add(aux);
            
            aux = new Carro("carro_verde_claro.png", true, "verde_claro", 1, TIMER_DISPARO*23, 0, -1);
            eElementos.add(aux);
            cCarros.add(aux);
            
        } else if(dificuldade == 2){ // todos os tipos de carros
            //comentei pq estou com preguica de codar isso
            /*eElementos.add(new Carro("carro_amarelo.png", true, "amarelo", 10, 0, 4, 1));
            eElementos.add(new Carro("carro_laranja.png", true, "laranja", 9, 0, 5, 1));
            eElementos.add(new Carro("carro_azul.png", true, "azul", 8, 0, 0, 1));
            eElementos.add(new Carro("carro_marrom.png", true, "marrom", 7, 0, 2, 1));
            eElementos.add(new Carro("carro_rosa.png", true, "rosa", 6, 0, 1, 1));
            eElementos.add(new Carro("carro_verde_claro.png", true, "verde_claro", 5, TIMER_DISPARO*23, 8, -1));
            eElementos.add(new Carro("carro_vermelho_claro.png", true, "vermelho_claro", 4, TIMER_DISPARO*23, 8, -1));
            eElementos.add(new Carro("carro_vermelho_esc.png", true, "vermelho_esc", 3, TIMER_DISPARO*23, 2, -1));
            eElementos.add(new Carro("carro_azul.png", true, "azul", 2, TIMER_DISPARO*23, 1, -1));
            eElementos.add(new Carro("carro_verde_claro.png", true, "verde_claro", 1, TIMER_DISPARO*23, 0, -1));*/}
        return;
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
