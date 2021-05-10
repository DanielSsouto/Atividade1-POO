
public class ProdutoNaoPerecivel extends Produto {
    int Garantia;
    
    ProdutoNaoPerecivel(int NovoCodigo, float NovoPreco, String NovaDescricao, int NovaQuantidade, int NovaGarantia){
        super(NovoCodigo, NovoPreco, NovaDescricao, NovaQuantidade);
        Garantia = NovaGarantia;
        
        return;
    }   
    
    void mostraGarantia(){
        System.out.println("Tempo de garantia apos a venda: "+Garantia);
        
        return;
    }
    
}
