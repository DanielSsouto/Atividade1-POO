
package Modelo;

import Auxiliar.Consts;
import java.util.ArrayList;

public class ObservadorCarros{
    ArrayList<Carro> carros;
    
    ObservadorCarros(ArrayList<Carro> c){
        carros = c;
    }
    
    public void update(int fase){
        if(fase == 10) // a cada dez fases, uma nova dificuldade eh adicionada
            mudaCarrinhos();
        else if(fase == 20)
            piscaCarrinhos();
        else if(fase == -1)
            carros.clear();
        
        return;
    }
    
    // aumenta a velocidade dos carrinhos
    private void mudaCarrinhos(){
        for(Carro aux : carros)
            aux.aumentaVelocidade();
    }
    
    private void piscaCarrinhos(){
       for(Carro aux : carros){
           aux.piscar = true;
           aux.intervalo_piscada[0] = Math.random()*2*Consts.RES;
           double auxiliar = Math.min(4, 2*Consts.RES - aux.intervalo_piscada[0]);
           aux.intervalo_piscada[1] = auxiliar + aux.intervalo_piscada[0];
           
           System.out.println("intervalo de piscada:" + String.valueOf(aux.intervalo_piscada[0])+"  "+String.valueOf(aux.intervalo_piscada[1]) );
        }
       
    }
}

