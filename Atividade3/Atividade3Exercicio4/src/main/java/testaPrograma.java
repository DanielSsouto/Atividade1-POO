
import java.util.Date;


public class testaPrograma {

    public static void main(String[] args) {
        Date hoje = new Date();
        ProdutoPerecivel Alface = new ProdutoPerecivel(0000, (float) 2.5, "Maco de Alface Saborosa", 30, hoje);
        ProdutoPerecivelEspecial Miojo = new ProdutoPerecivelEspecial(1000, (float) 5.0, "Miojo De Legumes (nao coma isso)", 20, hoje);
        ProdutoNaoPerecivel GarrafaoDeVinho = new ProdutoNaoPerecivel(1100, (float) 80.0, "Garrafao de Vinho de 5 litros", 100, 1);
        Estoque EstoqueLojaDoPedrinho = new Estoque();
    
        EstoqueLojaDoPedrinho.cadastrarProduto(Alface);
        EstoqueLojaDoPedrinho.cadastrarProduto(Miojo);
        EstoqueLojaDoPedrinho.cadastrarProduto(GarrafaoDeVinho);
        
        Produto aux = EstoqueLojaDoPedrinho.consultarProduto(9999);
        if(aux == null)
            System.out.println("A funcao consultarProduto passou no primeiro teste\n");
        
        aux = EstoqueLojaDoPedrinho.consultarProduto(0000);
        if(aux == Alface)
            System.out.println("A funcao consultarProduto passou no segundo teste\n");
        
        EstoqueLojaDoPedrinho.mostraEstoque();
        EstoqueLojaDoPedrinho.mostraTotal();
        
        System.out.println("Testando as funcoes especificas da classe ProdutoPerecivel");
        Alface.mostraDataDeValidade();
        Alface.retirarDoEstoque(5, hoje);
        Alface.mostraDescricao();
        Alface.chamaGuardarNoEstoque(100);
        Alface.mostraDescricao();
        
        System.out.println("Testando as funcoes especificas da classe ProdutoNaoPerecivel\n");
        GarrafaoDeVinho.mostraGarantia();
        
        System.out.println("Testando as funcoes especificas da classe ProdutoPerecivelEspecial\n");
        Miojo.mostraNotaDeControle();
        
        EstoqueLojaDoPedrinho.retirarProdutoDoEstoque(0000);
        EstoqueLojaDoPedrinho.retirarProdutoDoEstoque(1000);
        EstoqueLojaDoPedrinho.retirarProdutoDoEstoque(1100);
        
        EstoqueLojaDoPedrinho.mostraEstoque();
        EstoqueLojaDoPedrinho.mostraTotal();
        
        return;
    }
    
}
