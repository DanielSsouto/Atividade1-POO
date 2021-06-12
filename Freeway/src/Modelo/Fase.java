
package Modelo;

import java.util.ArrayList;

public class Fase {
    private int faseAtual;
    private int dificuldade;
    public Galinha hHero;
    private Carro CarroAzul, CarroAmarelo, CarroVerdeClaro, CarroLaranja;
    public ArrayList<Elemento> eElementos;
    
    private void declaraElementos(){
        eElementos = new ArrayList(100);
        hHero = new Galinha("galinha.png", 14, 1); /* https://www.online-image-editor.com/ */
        //hHero.setPosicao(14, 1);
        eElementos.add(hHero);
        
        if (dificuldade == 0){ // 3 tipos de carros apenas
           
        } else if(dificuldade == 1){ // 5 tipos de carros
        
        
        } else if(dificuldade == 2){ // todos os tipos de carros
        
        
        }
        
        CarroAmarelo = new Carro("carro_amarelo.png", true, "amarelo", 9, 185);
        eElementos.add(CarroAmarelo);
        CarroLaranja = new Carro("carro_laranja.png", true, "laranja", 1, 185);
        eElementos.add(CarroLaranja);
        CarroAzul = new Carro("carro_azul.png", true, "azul", 10, 185);
        //CarroAzul.setPosicao(10, 185);
        eElementos.add(CarroAzul);
        
        return;
    }
    
    public Fase(int dif){
        dificuldade = dif;
        declaraElementos();
    
    }
    
    public int mostraDificuldade(){
        return dificuldade;
    }
    
    public int mostraFase(){
        return faseAtual;
    }
}
