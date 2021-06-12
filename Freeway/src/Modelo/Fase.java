
package Modelo;

import java.util.ArrayList;

public class Fase {
    private int faseAtual;
    private int dificuldade;
    public Galinha hHero;
    public ArrayList<Elemento> eElementos = null;
    
    private void declaraElementos(){
        if(eElementos != null)
            eElementos.clear();
        
        eElementos = new ArrayList(100);
        hHero = new Galinha("galinha.png", 0, 32); 
        eElementos.add(hHero);
        
        if (dificuldade == 0){ // 3 tipos de carros apenas
            eElementos.add(new Carro("carro_amarelo.png", true, "amarelo", 10, 185, 0 + (int)(faseAtual/10)));
            eElementos.add(new Carro("carro_laranja.png", true, "laranja", 9, 185, 2 + (int)(faseAtual/10)));
            eElementos.add(new Carro("carro_azul.png", true, "azul", 8, 185, 4 + (int)(faseAtual/10)));
            eElementos.add(new Carro("carro_amarelo.png", true, "amarelo", 7, 185, 2 + (int)(faseAtual/10)));
            eElementos.add(new Carro("carro_laranja.png", true, "laranja", 6, 185, 0 + (int)(faseAtual/10)));
            eElementos.add(new Carro("carro_azul.png", true, "azul", 5, 185, 4 + (int)(faseAtual/10)));
            eElementos.add(new Carro("carro_amarelo.png", true, "amarelo", 4, 185, 0 + (int)(faseAtual/10)));
            eElementos.add(new Carro("carro_laranja.png", true, "laranja", 3, 185, 2 + (int)(faseAtual/10)));
            eElementos.add(new Carro("carro_azul.png", true, "azul", 2, 185, 4 + (int)(faseAtual/10)));
            eElementos.add(new Carro("carro_azul.png", true, "azul", 1, 185, 0 + (int)(faseAtual/10)));
        } else if(dificuldade == 1){ // 5 tipos de carros
        
        
        } else if(dificuldade == 2){ // todos os tipos de carros
        
        
        }
        
        return;
    }
    
    public Fase(int dif){
        dificuldade = dif;
        faseAtual = 0;
        declaraElementos();
    
    }
    
    public void incrementaFase(){
        faseAtual++;
        declaraElementos();
        
        return;
    } 
    
    public int mostraDificuldade(){
        return dificuldade;
    }
    
    public int mostraFase(){
        return faseAtual;
    }
}(faseAtual%10)
