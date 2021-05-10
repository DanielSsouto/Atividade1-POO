import java.util.Date;

public class ProdutoPerecivel extends Produto {
    private Date DataDeValidade = new Date();
    
    ProdutoPerecivel(int NovoCodigo, float NovoPreco, String NovaDescricao, int NovaQuantidade, Date NovaData){
        super(NovoCodigo, NovoPreco, NovaDescricao, NovaQuantidade);
        DataDeValidade = NovaData;
        
        return;
    }
    
    void mostraDataDeValidade(){
        System.out.println("Data de Validade: "+DataDeValidade+"\n");
        
        return;
    }
    
    void retirarDoEstoque(int Quantidade, Date DataAtual){
        if( (DataAtual.getTime() - DataDeValidade.getTime())/3600 <= 30 * 24 * 60)
            retirarDoEstoque(QuantidadeEmEstoque);
        else
            retirarDoEstoque(Quantidade);
        
        return;
    }
    
    boolean chamaGuardarNoEstoque(int Quantidade){
        if(QuantidadeEmEstoque != 0)
            return false;
        else{
            guardarNoEstoque(Quantidade);
            return true;
        }
    }
     
}
