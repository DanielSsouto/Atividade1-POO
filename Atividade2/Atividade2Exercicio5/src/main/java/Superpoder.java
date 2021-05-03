
public class Superpoder {
    private int Categoria;
    private String Nome;
    
    Superpoder(int NovaCategoria, String NovoNome){
        Nome = NovoNome;
        if (NovaCategoria == 0)
            Categoria = 1;
        else
            Categoria = NovaCategoria;
        
        return;
    }
    
    public int mostraCategoria(){
        return Categoria;
    }
    
    public String mostraNome(){
        return Nome;
    }
    
}
