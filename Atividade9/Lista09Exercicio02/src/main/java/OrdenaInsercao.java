
public class OrdenaInsercao {
    public <T extends Comparable> void ordenaInsercao(T[] NaoOrdenado){
        int i, j; // contadores
        boolean aux; // guarda resultado do teste
        T temp; // auxiliar
        
        for(i = 1; i < NaoOrdenado.length; i++){
            temp = NaoOrdenado[i];
            j = i - 1;
            while(j>= 0 && NaoOrdenado[j].compareTo(temp) > 0){
                NaoOrdenado[j + 1] = NaoOrdenado[j];
                j--;
            }
            NaoOrdenado[j+1] = temp;
        }
    }
}
