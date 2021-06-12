package Modelo;

import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.*;
import Auxiliar.Posicao;

/**
 *
 * @author junio
 */
public class Carro extends Elemento implements Serializable{
    private String cor; 
    float velocidade_anterior;
    float aceleracao_anterior;
    
    public Carro(String sNomeImagePNG, boolean mortal, String umaCor, int linha, int coluna) {
        super(sNomeImagePNG, linha, coluna);
        cor = umaCor;
        velocidade_anterior = (float) 1.5; //menor velocidade possivel
        aceleracao_anterior = 0; // menor aceleracao possivel
        this.bMortal = true;
    }
    
    public boolean moveLeft() {
        boolean c = false;
        
        switch(cor){
            // velocidade constante
                case "azul": 
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    break;
                case "vermelho_claro": // 20 por cento mais rapido do que o azul
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                            this.pPosicao.getColuna() - (int) (velocidade_anterior*1.2)); 
                    break;
            // aceleracao constante
                case "amarelo": 
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    if(velocidade_anterior <= 8)
                        velocidade_anterior = velocidade_anterior + aceleracao_anterior;
                    aceleracao_anterior = (float) 0.1;
                    break;
                case "vermelho_esc": // aceleracao 20 por cento maior do que o amarelo
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    if(velocidade_anterior <= 8)
                        velocidade_anterior = velocidade_anterior + aceleracao_anterior;
                    aceleracao_anterior = (float) (0.1*1.2);
                    break;
            // aceleracao variavel
                case "verde_claro": //linear
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    if(velocidade_anterior <= 8)
                        velocidade_anterior = velocidade_anterior + aceleracao_anterior;
                    aceleracao_anterior = (float) (this.pPosicao.getColuna()*0.01);
                    break;
                case "verde_esc": //quadratica
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    if(velocidade_anterior <= 8)
                        velocidade_anterior = velocidade_anterior + aceleracao_anterior;
                    aceleracao_anterior = (float) (Math.pow(this.pPosicao.getColuna(),2)*0.01);
                    break;
            // aceleracao senoidal
                case "laranja":
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    if (velocidade_anterior <= 8 || aceleracao_anterior <= 0)
                        velocidade_anterior += aceleracao_anterior;
                    aceleracao_anterior = (float) (Math.sin((Math.toRadians((191 - this.pPosicao.getColuna())%95)*360/95)));
                    break;
                case "rosa": // aceleracao 20 por cento maior do que do laranja
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    if (velocidade_anterior <= 8 || aceleracao_anterior <= 0)
                        velocidade_anterior += aceleracao_anterior;
                    aceleracao_anterior = (float) (1.2*Math.sin((Math.toRadians((191 - this.pPosicao.getColuna())%95)*360/95)));
                    break;
            // aceleracao aleatoria
                case "marrom":
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - (int) velocidade_anterior);
                    if (velocidade_anterior <= 8 || aceleracao_anterior <= 0)
                        velocidade_anterior += aceleracao_anterior;
                    aceleracao_anterior = (float) (Math.random()%2+1);
        }
        return c;
    }

    public void autoDesenho() {
        super.autoDesenho();
        boolean soma_volta = false;
        
        /*Movo a direita, quando nao poder se mover ainda mais para a direita, pede para ser removido do jogo*/
        if(!this.moveLeft()){
        /*    
            switch (cor){
                    case "amarelo":
                        velocidade_anterior = 0;
                        aceleracao_anterior = 0;
                        break;
                    case "vermelho_esc":
                        velocidade_anterior = 0;
                        aceleracao_anterior = 0;
                        break;
                    case "verde_claro":
                        velocidade_anterior = 0;
                        aceleracao_anterior = 0;
                        break;
                    case "verde_esc":
                        velocidade_anterior = 0;
                        aceleracao_anterior = 0;
                        break;
                    case "marrom":
                        velocidade_anterior = 0;
                        aceleracao_anterior = 0;
                        break;
                    case "laranja":
                        velocidade_anterior = 1;
                        aceleracao_anterior = 0;
                        break;
                    case "rosa":
                        velocidade_anterior = 1;
                        aceleracao_anterior = 0;
                        break;
                    
            }*/
            velocidade_anterior = 0;
            aceleracao_anterior = 0;
            setPosicao(pInicial.getLinha(), pInicial.getColuna());
        }  
            
            return;
    }
    
}
