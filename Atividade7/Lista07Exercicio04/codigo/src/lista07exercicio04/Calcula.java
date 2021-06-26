
package lista07exercicio04;

import java.util.Random;

public class Calcula {
    
    public void calcula_raiz(double operacoes){
        Random r = new Random();
        for(int i = 0; i <= operacoes; i++)
            Math.sqrt(r.nextDouble());
        
        return;
    }
    
    public void contagem(double operacoes){
        int j = 0;
        Random r = new Random();
        for(int i = 0; i <= operacoes; i++)
            j+= r.nextDouble();
        
        return;
    }
    
    public void calcula_dificil(double operacoes){
        int j = 0;
        Random r = new Random();
        for(int i = 0; i <= operacoes; i++)
            j += Math.pow(Math.cos(Math.sqrt(r.nextDouble())) - 1, 2);
        
        return;
    }
}
