package Modelo;

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
    private int padraoDeVelocidade; // [0-8]
    
    private void defineVelocicadeEAceleracao(){
        if(padraoDeVelocidade != 0 && padraoDeVelocidade != 1){
            velocidade_anterior = 1;
            aceleracao_anterior = 0;
        } else{
            velocidade_anterior = 3;
            aceleracao_anterior = 0;
        }
        
        return;    
    }
    
    public Carro(String sNomeImagePNG, boolean mortal, String umaCor, int linha, int coluna, int meuPadrao) {
        super(sNomeImagePNG, linha, coluna);
        cor = umaCor;
        padraoDeVelocidade = meuPadrao;
        defineVelocicadeEAceleracao();
        this.bMortal = true;
        
        return;
    }
    
    public boolean moveLeft() {
        boolean c = false;
        
        switch(padraoDeVelocidade){
            // velocidade constante
                case 0: 
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    break;
                case 1: // 2x mais rapido do que o azul
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                            this.pPosicao.getColuna() - (int) (velocidade_anterior*2)); 
                    break;
            // aceleracao constante
                case 2: 
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    if(velocidade_anterior <= 8)
                        velocidade_anterior = velocidade_anterior + aceleracao_anterior;
                    aceleracao_anterior = (float) 0.1;
                    break;
                case 3: // aceleracao 20 por cento maior do que o amarelo
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    if(velocidade_anterior <= 8)
                        velocidade_anterior = velocidade_anterior + aceleracao_anterior;
                    aceleracao_anterior = (float) (0.1*1.2);
                    break;
            // aceleracao variavel
                case 4: //linear
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    if(velocidade_anterior <= 8)
                        velocidade_anterior = velocidade_anterior + aceleracao_anterior;
                    aceleracao_anterior = (float) (this.pPosicao.getColuna()*0.01);
                    break;
                case 5: //quadratica
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    if(velocidade_anterior <= 8)
                        velocidade_anterior = velocidade_anterior + aceleracao_anterior;
                    aceleracao_anterior = (float) (Math.pow(this.pPosicao.getColuna(),2)*0.01);
                    break;
            // aceleracao senoidal
                case 6:
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    if (velocidade_anterior <= 8 || aceleracao_anterior <= 0)
                        velocidade_anterior += aceleracao_anterior;
                    aceleracao_anterior = (float) (Math.sin((Math.toRadians((191 - this.pPosicao.getColuna())%95)*360/95)));
                    break;
                case 7: // aceleracao 20 por cento maior do que do laranja
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    if (velocidade_anterior <= 8 || aceleracao_anterior <= 0)
                        velocidade_anterior += aceleracao_anterior;
                    aceleracao_anterior = (float) (Math.sin((Math.toRadians((191 - this.pPosicao.getColuna())%95)*360/95)));
                    break;
            // aceleracao aleatoria
                case 8:
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    if (velocidade_anterior <= 8 || aceleracao_anterior <= 0)
                        velocidade_anterior += aceleracao_anterior;
                    aceleracao_anterior = (float) (Math.random()*2-1);
        }
        
        return c;
    }

    public void autoDesenho() {
        super.autoDesenho();
        boolean soma_volta = false;
        
        /*Movo a direita, quando nao poder se mover ainda mais para a direita, pede para ser removido do jogo*/
        if(!this.moveLeft()){
            defineVelocicadeEAceleracao();
            setPosicao(pInicial.getLinha(), pInicial.getColuna());
        }  
            
        return;
    }
    
}
