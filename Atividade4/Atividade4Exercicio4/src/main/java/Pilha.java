
public class Pilha {
    private int tamanhoMaximo; 
    private int posicaoAtual; // Posicao do ultimo elemento NO ARRAY
    private int[] itens;
    
    Pilha(int oTamanhoMaximo){
        tamanhoMaximo = oTamanhoMaximo;
        posicaoAtual = -1; // Pilha Vazia
        itens = new int[tamanhoMaximo];
        
        return;
    }
    
    public void Push(int novo) throws PilhaCheia{
        if (posicaoAtual == tamanhoMaximo - 1)
            throw new PilhaCheia();
        
        posicaoAtual ++;
        itens[posicaoAtual] = novo;
        
        return;
    }
    
    public int Pop() throws PilhaVazia{
        if(posicaoAtual == -1)
            throw new PilhaVazia();
        
        posicaoAtual--;
        return(itens[posicaoAtual + 1]);
    }
}
