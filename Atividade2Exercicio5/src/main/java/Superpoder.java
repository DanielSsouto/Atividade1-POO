
public class Superpoder {
    private int Intensidade;
    private String Nome;
    
    Superpoder(int NovaIntensidade, String NovoNome){
        Nome = NovoNome;
        if(NovaIntensidade == 0)
            Intensidade = NovaIntensidade+1;
        
        return;
    }
    
    public int mostraForca(){
        return Intensidade;
    }
    
    public String mostraNome(){
        return Nome;
    }
    
}
