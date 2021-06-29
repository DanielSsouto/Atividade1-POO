
package lista07exercicio04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.Random;

public class Lista07Exercicio04 {
    
    public static void main(String[] args) {
        Calcula c = new Calcula();
        long inicio; 
        long[] transcorrido_normal = new long[3];
        long[] transcorrido_thread = new long[3];
        int nNucleos = Runtime.getRuntime().availableProcessors();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int ordem;
        int i, j; // contadores
        
        System.out.println("Digite a ordem do numero de operacoes que devemos fazer");
        try{
            ordem = Integer.parseInt(reader.readLine());
        } catch(IOException e){
            ordem = 7; // para garantir que 'ordem' sera inicializada
            System.out.println(e.getMessage());
        }
        
        // Calculando sem threads  
        inicio = System.nanoTime();
        c.calcula_raiz(Math.pow(10, ordem));
        transcorrido_normal[0] = System.nanoTime() - inicio;
        
        inicio = System.nanoTime();
        c.contagem(Math.pow(10, ordem));
        transcorrido_normal[1] = System.nanoTime() - inicio;
        
        inicio = System.nanoTime();
        c.calcula_dificil(Math.pow(10, ordem));
        transcorrido_normal[2] = System.nanoTime() - inicio;
        
        // Calculando com threads
        ArrayList<Thread> calc = new ArrayList(nNucleos);
        
        for(j = 1; j <= 3; j++){ // j = 1 -> raiz; j = 2 -> contagem; j = 3 -> dificil
            for(i = 0; i < nNucleos; i++) // inicializa as threads
                calc.add(new Thread(new Calculos(Math.pow(10, ordem)/nNucleos, j)));
        
            inicio = System.nanoTime();
            for(i = 0; i < nNucleos; i++) // comeca o calulo
                calc.get(i).start();
            for(i = 0; i < nNucleos; i++) // espera o calculo terminar
                try{
                    calc.get(i).join();
                } catch(InterruptedException e){
                    System.out.println(e.getMessage());
                }
            transcorrido_thread[j -1] = System.nanoTime() - inicio;
            
            calc.clear();
        }
        
        // Imprimindo resultados
        System.out.println("Tempo transcorrido:\n");
        System.out.println("Execucao serial:"+(transcorrido_normal[0]*Math.pow(10, -9))+" "+
                (transcorrido_normal[1]*Math.pow(10, -9))+" "+(transcorrido_normal[2]*Math.pow(10, -9))+"\n");
        System.out.println("Execucao serial:"+(transcorrido_thread[0]*Math.pow(10, -9))+" "+
                (transcorrido_thread[1]*Math.pow(10, -9))+" "+(transcorrido_thread[2]*Math.pow(10, -9))+"\n");
        
        return;
    }
    
   
}
