
package Modelo;

import Auxiliar.Consts;
import static Auxiliar.Consts.TIMER_DISPARO;

public class CarroLento extends Carro {
    public CarroLento(String sNomeImagePNG, boolean mortal, String umaCor, int linha, int coluna, int meuPadrao, int meuSentido) {
        super(sNomeImagePNG, mortal, umaCor, linha, coluna, meuPadrao, meuSentido);
        return;
    }
    
    protected void defineVelocicadeEAceleracao(){
        switch(padraoDeVelocidade){
            // velocidade constante
            case 0: // devagar
                velocidade_anterior = (float) (30*(2*Math.random()+1))/TIMER_DISPARO;
                aceleracao_anterior = 0;
                break;

            // aceleracao constante
            case 2:
                velocidade_anterior = (float) (30)/TIMER_DISPARO;
                aceleracao_anterior = (float) 1.5/TIMER_DISPARO;
                break;
            // aceleracao variavel
            case 4: //linear
                velocidade_anterior = (float) (30)/TIMER_DISPARO;
                aceleracao_anterior = (float) 0.1/TIMER_DISPARO;
                break;
            
            // aceleracao senoidal
            case 6:
                velocidade_anterior = (float) 30/TIMER_DISPARO;
                aceleracao_anterior = (float) 0;
                break;
        }
        
        return;    
    }
}

