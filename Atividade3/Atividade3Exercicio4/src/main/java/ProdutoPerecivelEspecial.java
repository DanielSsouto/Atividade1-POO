
import java.util.Date;


public class ProdutoPerecivelEspecial extends ProdutoPerecivel{
    
    ProdutoPerecivelEspecial(int NovoCodigo, float NovoPreco, String NovaDescricao, int NovaQuantidade, Date NovaData){
        super(NovoCodigo, NovoPreco, NovaDescricao, NovaQuantidade, NovaData);
        
        return;
    }
    
    void mostraNotaDeControle(){
        System.out.println("Nota de Controle:");
        mostraDescricao();
        mostraDataDeValidade();
        System.out.println("Codigo: "+Codigo);
        
        return;
    }
   
}
