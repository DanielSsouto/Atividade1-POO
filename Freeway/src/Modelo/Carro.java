package Modelo;

import static Auxiliar.Consts.TIMER_DISPARO;
import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.*;
import Auxiliar.Posicao;


public class Carro extends Elemento implements Serializable{
    private String cor; 
    private float velocidade_anterior;
    private float aceleracao_anterior;
    private boolean brecar;
    private int padraoDeVelocidade; // [0-8]
    private int sentido;
    private int dif;
    
    private void defineVelocicadeEAceleracao(){
        switch(padraoDeVelocidade){
            // velocidade constante
                case 0: // devagar
                    velocidade_anterior = (float) (30*(2*Math.random()+1))/TIMER_DISPARO;
                    aceleracao_anterior = 0;
                    break;
                case 1: // rapido
                    velocidade_anterior = (float) (120*(2*Math.random()+1))/TIMER_DISPARO;
                    aceleracao_anterior = 0;
                    break;
                    
                // aceleracao constante
                case 2:
                    velocidade_anterior = (float) (30)/TIMER_DISPARO;
                    aceleracao_anterior = (float) 1.5/TIMER_DISPARO;
                    break;
                case 3: 
                    velocidade_anterior = (float) (30)/TIMER_DISPARO;
                    aceleracao_anterior = (float) 3/TIMER_DISPARO;
                    break;
                    
            // aceleracao variavel
                case 4: //linear
                    velocidade_anterior = (float) (30)/TIMER_DISPARO;
                    aceleracao_anterior = (float) 0.1/TIMER_DISPARO;
                    break;
                case 5: //quadratica
                    velocidade_anterior = (float) 30/TIMER_DISPARO;
                    aceleracao_anterior = (float) 0.1/TIMER_DISPARO;
                    break;
            // aceleracao senoidal
                case 6:
                    velocidade_anterior = (float) (30)/TIMER_DISPARO;
                    aceleracao_anterior = (float) 0;
                    break;
                case 7:
                    velocidade_anterior = (float) (30)/TIMER_DISPARO;
                    aceleracao_anterior = (float) 0;
                    break;
                    
            // aceleracao aleatoria
                case 8:
                    velocidade_anterior = (float) (30)/TIMER_DISPARO;
                    aceleracao_anterior = (float) 3/TIMER_DISPARO;
        }
        
        return;    
    }
    
    public Carro(String sNomeImagePNG, boolean mortal, String umaCor, int linha, int coluna, int meuPadrao, int meuSentido) {
        super(sNomeImagePNG, linha, coluna);
        cor = umaCor;
        padraoDeVelocidade = meuPadrao;
        defineVelocicadeEAceleracao();
        this.bMortal = true;
        brecar = false;
        sentido = meuSentido;
        dif = 1;
        
        return;
    }
    
    public boolean move() {
        boolean c = false;
        switch(padraoDeVelocidade){
                // velocidade constante
                case 0: // devagar
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() + dif*sentido*((int) velocidade_anterior));
                    break;
                    
                case 1: // rapido
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                            this.pPosicao.getColuna() + dif*sentido*((int) velocidade_anterior)); 
                    break;
                    
                 // aceleracao constante
                case 2: 
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() + dif*sentido*((int) velocidade_anterior)); 
                   if(brecar){
                        velocidade_anterior = velocidade_anterior - aceleracao_anterior;
                        if(velocidade_anterior <= 30/TIMER_DISPARO)
                            brecar = false;
                    } else if(velocidade_anterior <= 120/TIMER_DISPARO){
                        velocidade_anterior += aceleracao_anterior;
                    } else
                        brecar = true;
                    break;
                    
                case 3: // aceleracao 20 por cento maior do que o amarelo
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() + dif*sentido*((int) velocidade_anterior)); 
                    
                    if(brecar){
                        velocidade_anterior = velocidade_anterior - aceleracao_anterior;
                        if(velocidade_anterior <= 30/TIMER_DISPARO)
                            brecar = false;
                    } else if(velocidade_anterior <= 180/TIMER_DISPARO){
                        velocidade_anterior += aceleracao_anterior;
                    } else
                        brecar = true;
                    
                    break;
                    
                // aceleracao variavel
                case 4: //linear
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() + dif*sentido*((int) velocidade_anterior)); 
                    if(brecar){
                        velocidade_anterior -= aceleracao_anterior;
                        aceleracao_anterior += (float) (0.1/TIMER_DISPARO);
                        if(velocidade_anterior <= 60/TIMER_DISPARO){
                            brecar = false;
                            aceleracao_anterior = (float) 0.1;
                        }
                    } else if(velocidade_anterior <= 120/TIMER_DISPARO){
                        velocidade_anterior += aceleracao_anterior;
                        aceleracao_anterior += (float) (0.1/TIMER_DISPARO);
                    } else{
                        brecar = true;
                        aceleracao_anterior = (float) 0.1;
                    } 
                    break;
                
                case 5: //quadratica
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() + dif*sentido*((int) velocidade_anterior)); 
                    
                    if(brecar){
                        velocidade_anterior -= aceleracao_anterior;
                        aceleracao_anterior += 2*aceleracao_anterior/TIMER_DISPARO;
                        if(velocidade_anterior <= 60/TIMER_DISPARO){
                            brecar = false;
                            aceleracao_anterior = (float) 0.1;
                        }
                    } else if(velocidade_anterior <= 180/TIMER_DISPARO){
                        velocidade_anterior += aceleracao_anterior;
                        aceleracao_anterior += 2*aceleracao_anterior/TIMER_DISPARO;
                    } else{
                        brecar = true;
                        aceleracao_anterior = (float) 0.1;
                    }
                    
                    break;
            
                // aceleracao senoidal
                case 6: // se a aceleracao tem variacao senoidal, entao ela eh o cosseno da posicao atual
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() + dif*sentido*((int) velocidade_anterior)); 
                    
                    velocidade_anterior += aceleracao_anterior;
                    aceleracao_anterior = (float) (2*Math.sin(Math.toRadians((24*TIMER_DISPARO - this.getPosicao().getColuna()%(12*TIMER_DISPARO))*360/(12*TIMER_DISPARO)))/TIMER_DISPARO);
                    break;
                    
                case 7:
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() + dif*sentido*((int) velocidade_anterior)); 
                    velocidade_anterior += aceleracao_anterior;
                    aceleracao_anterior = (float) (8*Math.sin(Math.toRadians((24*TIMER_DISPARO - this.getPosicao().getColuna()%(12*TIMER_DISPARO))*360/(12*TIMER_DISPARO)))/TIMER_DISPARO);
                    break;
                // aceleracao aleatoria
                case 8:
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() + dif*sentido*((int) velocidade_anterior)); 
                    if(brecar){
                        velocidade_anterior -= aceleracao_anterior;
                        aceleracao_anterior += (float) (Math.random()*3/TIMER_DISPARO);
                        if(velocidade_anterior <= 60/TIMER_DISPARO){
                            brecar = false;
                            aceleracao_anterior = (float) 0.1;
                        }
                    } else if(velocidade_anterior <= 180/TIMER_DISPARO){
                        velocidade_anterior += aceleracao_anterior;
                        aceleracao_anterior += aceleracao_anterior += (float) (Math.random()*3/TIMER_DISPARO);
                    } else{
                        brecar = true;
                        aceleracao_anterior = (float) 0.1;
                    }
                    
        }
        
        return c;
    }

    public void autoDesenho() {
        super.autoDesenho();
        boolean soma_volta = false;
        
        /*Movo a direita, quando nao poder se mover ainda mais para a direita, pede para ser removido do jogo*/
        if(!this.move()){
            setPosicao(pInicial.getLinha(), pInicial.getColuna());
        }  
            
        return;
    }
    
    public void aumentaVelocidade(){
        dif++;
    }
    
}
