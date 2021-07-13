
package Modelo;

import Auxiliar.Consts;
import static Auxiliar.Consts.TIMER_DISPARO;

public class CarroRapido extends Carro{
    public CarroRapido(String sNomeImagePNG, boolean mortal, String umaCor, int linha, int coluna, int meuPadrao, int meuSentido) {
        super(sNomeImagePNG, mortal, umaCor, linha, coluna, meuPadrao, meuSentido);
        
        return;
    }
    
    protected void defineVelocicadeEAceleracao(){
        switch(padraoDeVelocidade){
            // velocidade constante
            case 1:
                velocidade_anterior = (float) (120*(2*Math.random()+1))/TIMER_DISPARO;
                aceleracao_anterior = 0;
                break;

            // aceleracao constante
            case 3: 
                velocidade_anterior = (float) (30)/TIMER_DISPARO;
                aceleracao_anterior = (float) 3/TIMER_DISPARO;
                break;

            // aceleracao variavel
            case 5: //quadratica
                velocidade_anterior = (float) 30/TIMER_DISPARO;
                aceleracao_anterior = (float) 0.1/TIMER_DISPARO;
                break;
            // aceleracao senoidal
            case 7:
                velocidade_anterior = (float) 30/TIMER_DISPARO;
                aceleracao_anterior = (float) 0;
                break;

            // aceleracao aleatoria
            case 8:
                velocidade_anterior = (float) (30)/TIMER_DISPARO;
                aceleracao_anterior = (float) 3/TIMER_DISPARO;
        }
        
        return;    
    }
}
