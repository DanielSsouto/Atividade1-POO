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

/**
 *
 * @author Junio
 */
public class Galinha extends Elemento implements Serializable{
    private int vida;
    
    public Galinha(String sNomeImagePNG, int linha, int coluna) {
        super(sNomeImagePNG, linha, coluna);
        vida = 2;
    }
    
    public boolean decrementaVida(){
        if(vida == 0){
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
}
