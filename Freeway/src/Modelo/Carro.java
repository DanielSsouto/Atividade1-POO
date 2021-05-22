package Modelo;

import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

/**
 *
 * @author junio
 */
public class Carro extends Elemento implements Serializable{
            
    public Carro(String sNomeImagePNG, boolean mortal) {
        super(sNomeImagePNG);
        this.bMortal = true;
    }

    public void autoDesenho() {
        super.autoDesenho();
        /*Movo a direita, quando nao poder se mover ainda mais para a direita, pede para ser removido do jogo*/
        if(!this.moveLeft())
            this.setPosicao(10, 10);
    }
    
}
