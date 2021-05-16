
public class Teste {

    public static void main(String[] args) {
        Pilha minhaPilha = new Pilha(20);
        int i;
        
        for(i = 0; i <= 21; i = i + 1){
            try{            
                minhaPilha.Push(i);
            } catch(PilhaCheia erro){
                System.err.println("Pilha cheia!");
                break;
            }
        }
        
        for(i = 0; i<= 21; i = i + 1){
            try{
                System.out.println("Elemento "+(20 - i)+": "+minhaPilha.Pop());
            } catch(PilhaVazia erro){
                System.err.println("Pilha vazia!");
                break;
            }
        }
        
        return;
    }
    
}
