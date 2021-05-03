
import java.util.ArrayList;
import java.util.Date;

public class Estoque {
    private ArrayList<Produto> ProdutosEmEstoque;
    private int NumeroDeProdutos;
    
    Estoque(){
        ProdutosEmEstoque = new ArrayList<Produto>();
        NumeroDeProdutos = 0;
    }
    
    Produto consultarProduto(int UmCodigo){
        if (NumeroDeProdutos == 0){
            return null;
        }
        
        int i = 0;
        
        while(i < NumeroDeProdutos && UmCodigo != ProdutosEmEstoque.get(i).Codigo){
            i++;
        }
        
        if(i < NumeroDeProdutos)
            return ProdutosEmEstoque.get(i);
        else
            return null;
    }
    
    void cadastrarProduto(Produto ProdutoACadastrar){
        if( consultarProduto(ProdutoACadastrar.Codigo) == null){
            ProdutosEmEstoque.add(ProdutoACadastrar);
            NumeroDeProdutos++;
            System.out.println("Cadastro concluido!\n");
        } else
            System.out.println("Produto jah cadastrado!\n");
        
        return;
    }
    
    
    void retirarProdutoDoEstoque(int UmCodigo){
        Produto ProdutoARemover = consultarProduto(UmCodigo);
        
        if(ProdutoARemover != null){
            ProdutosEmEstoque.remove(ProdutoARemover);
            NumeroDeProdutos--;
        } else
            System.out.println("Produto nao cadastrado!\n");
        
        return;
    }
    
    void mostraTotal (){
        int i = 0;
        float soma = 0;
        
        while(i < NumeroDeProdutos){
            soma += ProdutosEmEstoque.get(i).PrecoUnitario * ProdutosEmEstoque.get(i).QuantidadeEmEstoque;
            i++;
        }
        System.out.println("O valor total das mercadorias em estoque eh: "+soma+"\n");
    }
    
    void mostraEstoque(){
        if (NumeroDeProdutos == 0){
            System.out.println("Estoque vazio");
            return;
        }
        int i = 0;
        
        while(i < NumeroDeProdutos){
            ProdutosEmEstoque.get(i).mostraDescricao();
            i++;
        }
        
        return;
    }

}
