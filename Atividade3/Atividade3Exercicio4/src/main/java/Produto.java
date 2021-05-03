
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
    }
    
    void mudaDescricao(String NovaDescricao){
        Descricao = NovaDescricao;
    }
    
    void mostraPreco(){
        System.out.println("Preco unitario "+PrecoUnitario+"\n");
    }
    
    void mostraDescricao(){
        System.out.println("Produto"+
                            "\nDescricao: "+Descricao+
                            "\nQuantidade em estoque: "+QuantidadeEmEstoque+
                            "\nPreco unitario: "+PrecoUnitario+"\n");
    }
    
    void guardarNoEstoque(int Quantidade){
        QuantidadeEmEstoque += Quantidade;
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


