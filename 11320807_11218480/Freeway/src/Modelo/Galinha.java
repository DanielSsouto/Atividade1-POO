package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Galinha extends Elemento implements Serializable{
    private static Galinha instancia = null;
    public int vida;
    
    private Galinha(String sNomeImagePNG, int linha, int coluna) {
        super(sNomeImagePNG, linha, coluna);
        vida = 3;
    }
    
    public static Galinha instanciar(String sNomeImagePNG, int linha, int coluna){
        if(instancia == null)
            instancia = new Galinha(sNomeImagePNG, linha, coluna);
        return instancia;
    }
    
    public boolean decrementaVida(){
        if(vida == 1){
            setPosicao(pInicial.getLinha(), pInicial.getColuna());
            return false;
        }else
            vida--;
        
        setPosicao(pInicial.getLinha(), pInicial.getColuna());
        
        return true;
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
    public void matarGalinha(){
        instancia = null;
        return;
    }
}
