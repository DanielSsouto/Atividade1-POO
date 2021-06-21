package Controler;

import static Auxiliar.Consts.TIMER_DISPARO;
import static Auxiliar.Consts.TOTAL_DE_FASES;
import Modelo.Elemento;
import Modelo.Galinha;
import Auxiliar.Posicao;
import Modelo.Fase;
import java.util.ArrayList;

/**
 *
 * @author junio
 */
public class ControleDeJogo {
    public void desenhaTudo(ArrayList<Elemento> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }
    
    public boolean processaTudo(Fase faseAtual){ //true, se o heroi chegou no fim da rua
        ArrayList<Elemento> e = faseAtual.eElementos;
        Galinha hHero = (Galinha)e.get(0); /*O heroi (protagonista) eh sempre o primeiro do array*/        
        Elemento eTemp;
        /*Processa todos os demais em relacao ao heroi*/
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            /*Verifica se o heroi se sobrepoe ao i-ésimo elemento*/
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao()))
                if(!hHero.decrementaVida()){ // se o heroi morreu
                    faseAtual.restart();
                }
        }
        
        // se o heroi atravessou a rua
        if(hHero.getPosicao().estaNaMesmaPosicao(new Posicao(11,4*TIMER_DISPARO))) 
            return true;
        else
            return false;
    } 
    
    public boolean ehPosicaoValida(ArrayList<Elemento> e, Posicao p){
        Elemento eTemp;
        /*Validacao da posicao de todos os elementos com relacao a Posicao p*/
        for(int i = 1; i < e.size(); i++){ /*Olha todos os elementos*/
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            if(!eTemp.isbTransponivel())
                if(eTemp.getPosicao().estaNaMesmaPosicao(p))
                    return false; /*A posicao p é invalida, pois ha um elemento (i-esimo eTemp) intransponivel lá*/
        }
        
        return true;
    }
}
