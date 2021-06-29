
package lista07exercicio04;

import java.util.Random;

public class Calculos implements Runnable {
    private double operacoes;
    private int tipo; // indica qual operacao sera feita
    private Calcula calculadora;
    
    Calculos(double ops, int meuTipo){
        operacoes = ops;
        tipo = meuTipo;
        calculadora = new Calcula();
    }
    
    @Override
    public void run() {
        if(tipo == 1)
            calculadora.calcula_raiz(operacoes);
        else if(tipo == 2)
            calculadora.contagem(operacoes);
        else
            calculadora.calcula_dificil(operacoes);
        
        return;
    }
    
}
