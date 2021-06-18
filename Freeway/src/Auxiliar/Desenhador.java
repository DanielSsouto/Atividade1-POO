package Auxiliar;

import static Auxiliar.Consts.TIMER_DISPARO;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.ImageIcon;
import Controler.Tela;

/**
 *
 * @author junio
 */
public class Desenhador implements Serializable {
    static Tela tCenarioOndeSeDesenha;
    public static void setCenario(Tela umTCenarioOndeDesenhar) {
        tCenarioOndeSeDesenha = umTCenarioOndeDesenhar;
    }

    public static Tela getTelaDoJogo() {
        return tCenarioOndeSeDesenha;
    }
    
    public static void desenhar(ImageIcon iImage, int iColuna, int iLinha) {
        // na horazontal, avancar uma coluna siginifica andar 1/150 de celula
        // na vertical, avancar uma linha significa andar 1 celula
        iImage.paintIcon(tCenarioOndeSeDesenha,getGraphicsDaTela(),iColuna * Consts.CELL_SIDE/TIMER_DISPARO, iLinha * Consts.CELL_SIDE);
    }
    
    /*private, entao eh usaddo soh aqui dentro*/
    private static Graphics getGraphicsDaTela() {
        return tCenarioOndeSeDesenha.getGraphicsBuffer();
    }
    

}
