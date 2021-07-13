package Modelo;

import Auxiliar.Consts;
import static Auxiliar.Consts.TIMER_DISPARO;
import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.*;
import Auxiliar.Posicao;


public abstract class Carro extends Elemento implements Serializable{
    protected String cor; 
    protected float velocidade_anterior;
    protected float aceleracao_anterior;
    protected boolean brecar;
    protected int padraoDeVelocidade; // [0-8]
    protected int sentido;
    protected int dif; // padrao de dificuldade atual
    protected boolean piscar;
    protected boolean piscando;
    public double intervalo_piscada[] = {0.0,0.0};
    
    protected abstract void defineVelocicadeEAceleracao();
    
    public Carro(String sNomeImagePNG, boolean mortal, String umaCor, int linha, int coluna, int meuPadrao, int meuSentido) {
        super(sNomeImagePNG, linha, coluna);
        cor = umaCor;
        padraoDeVelocidade = meuPadrao;
        defineVelocicadeEAceleracao();
        this.bMortal = true;
        brecar = false;
        sentido = meuSentido;
        dif = 1;
        piscar = false;
        piscando = false;
        
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

            case 3:
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
                aceleracao_anterior += (float) (2*Math.sin(7*velocidade_anterior/TIMER_DISPARO)/TIMER_DISPARO);
                break;

            case 7:
                c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                            this.pPosicao.getColuna() + dif*sentido*((int) velocidade_anterior)); 
                velocidade_anterior += aceleracao_anterior;
                aceleracao_anterior += (float) (2*Math.sin(9*velocidade_anterior/TIMER_DISPARO)/TIMER_DISPARO);
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
                break;
                    
        }
        
        return c;
    }

    public void autoDesenho() {
        //Faz os caros piscarem se estiverem dentro de certo intervalo
        if(piscar){
            if(this.pPosicao.getColuna()>=intervalo_piscada[0] && this.pPosicao.getColuna()<=intervalo_piscada[1] ) {    
                piscando = true; 

            }
            else
                piscando = false;
        }  
        
        if(!piscando){
   
            super.autoDesenho();
        }
        
        /*Movo. Quando nao poder se mover ainda mais, pede para ser removido do jogo*/
        if(!this.move()){
           
            setPosicao(pInicial.getLinha(), pInicial.getColuna());
            //define um novo intervalo de piscada
            if(piscar){                
                intervalo_piscada[0] = Math.random()*2*Consts.RES*TIMER_DISPARO;
                double auxiliar = Math.min(2*TIMER_DISPARO, 2*Consts.RES*TIMER_DISPARO - intervalo_piscada[0]);
                intervalo_piscada[1] = auxiliar + intervalo_piscada[0];
            }
            
        }  
    
        return;
    }
    
    public void aumentaVelocidade(){
        dif++; // a variavel dif define a velocidade; mais dificil == mais rapido
    }
    
}
