
public class Vilao extends Personagem {
    private int AnosDePrisao;
    
    Vilao(String Nome, String NomeReal, int TempoXilindroh){
        super(Nome, NomeReal);
        
        if (TempoXilindroh < 0)
            AnosDePrisao = 0;
        else
            AnosDePrisao = TempoXilindroh;
        
        return;
    }
    
    public int mostraAnosDePrisao(){
        return AnosDePrisao;
    }
}

