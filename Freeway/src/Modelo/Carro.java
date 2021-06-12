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
    int velocidade_anterior;
    int aceleracao_anterior;
    
    public Carro(String sNomeImagePNG, boolean mortal, String umaCor, int linha, int coluna) {
        super(sNomeImagePNG, linha, coluna);
        cor = umaCor;
        velocidade_anterior = 1; //menor velocidade possivel
        aceleracao_anterior = 0; // menor aceleracao possivel
        this.bMortal = true;
    }
    
    public boolean moveLeft() {
        boolean c = false;
        
        switch(cor){
                case "azul": // velocidade constante
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - velocidade_anterior);
                    break;
                case "amarelo": // aceleracao constante
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - velocidade_anterior);
                    if(velocidade_anterior <= 8)
                        velocidade_anterior = velocidade_anterior + aceleracao_anterior;
                    aceleracao_anterior = 1;
                    break;
                case "vermelho_claro":
                    this.setPosicao(10, 10);
                    break;
                case "vermelho_esc":
                    this.setPosicao(10, 10);
                    break;
                case "verde_claro": 
                    this.setPosicao(10, 10);
                    break;
                case "verde_esc":
                    this.setPosicao(10, 10);
                    break;
                case "marrom":
                    this.setPosicao(10, 10);
                    break;
                case "rosa":
                    this.setPosicao(10, 10);
                    break;
                case "laranja":
                    c = this.pPosicao.setPosicao(this.pPosicao.getLinha(), 
                                                this.pPosicao.getColuna() - velocidade_anterior);
                    if (velocidade_anterior <= 8 || aceleracao_anterior <= 0)
                        velocidade_anterior += aceleracao_anterior;
                    aceleracao_anterior = (int) (1.2*Math.sin(Math.toRadians((191 - this.pPosicao.getColuna())*360/191)));
                    break;
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
                    case "azul": 
                        //this.setPosicao(10, 185);
                        break;
                    case "amarelo":
                        //this.setPosicao(9, 185);
                        velocidade_anterior = 0;
                        aceleracao_anterior = 0;
                        break;
                    case "vermelho_claro":
                        //this.setPosicao(10, 10);
                        break;
                    case "vermelho_esc":
                        //this.setPosicao(10, 10);
                        break;
                    case "verde_claro": 
                        //this.setPosicao(10, 10);
                        break;
                    case "verde_esc":
                        //this.setPosicao(10, 10);
                        break;
                    case "marrom":
                        //this.setPosicao(10, 10);
                        break;
                    case "rosa":
                        //this.setPosicao(10, 10);
                        break;
                    case "laranja":
                        //this.setPosicao(1, 185);
                        velocidade_anterior = 1;
                        aceleracao_anterior = 0;
                        break;
            }*/
            setPosicao(pInicial.getLinha(), pInicial.getColuna());
        }  
            
            return;
    }
    
}
