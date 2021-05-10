
public class Produto {
    protected int Codigo;
    protected float PrecoUnitario;
    protected String Descricao = new String();
    protected int QuantidadeEmEstoque;
    
    Produto(int NovoCodigo, float NovoPreco, String NovaDescricao, int NovaQuantidade){
        Codigo = NovoCodigo;
        PrecoUnitario = NovoPreco;
        Descricao = NovaDescricao;
        QuantidadeEmEstoque = NovaQuantidade;
    
        return;
    }
    
    void mudaPreco(float NovoPreco){
        PrecoUnitario = NovoPreco;
        
        return;
    }
    
    void mudaDescricao(String NovaDescricao){
        Descricao = NovaDescricao;
        
        return;
    }
    
    void mostraPreco(){
        System.out.println("Preco unitario "+PrecoUnitario+"\n");
        
        return;
    }
    
    void mostraDescricao(){
        System.out.println("Produto"+
                            "\nDescricao: "+Descricao+
                            "\nQuantidade em estoque: "+QuantidadeEmEstoque+
                            "\nPreco unitario: "+PrecoUnitario+"\n");
        
        return;
    }
    
    void guardarNoEstoque(int Quantidade){
        QuantidadeEmEstoque += Quantidade;
        
        return;
    }
    
    int retirarDoEstoque(int Quantidade){
        int QuantidadeRetirada;
        
        if(Quantidade > QuantidadeEmEstoque)
            QuantidadeRetirada = QuantidadeEmEstoque;
        else
            QuantidadeRetirada = Quantidade;
        
        QuantidadeEmEstoque -= QuantidadeRetirada;
        
        return QuantidadeRetirada;
    }
    
}   


