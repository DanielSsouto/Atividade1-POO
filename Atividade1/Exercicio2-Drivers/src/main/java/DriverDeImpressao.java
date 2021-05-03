
public class DriverDeImpressao {
    private boolean ligado;
    
    DriverDeImpressao(){
        ligado = false;
    }
    
    public void ligaDispositivo(){
        if(ligado) 
            ligado = false;
        else 
            ligado = true;
    }
    
    public boolean verificaStatus(){
        if(ligado)
            System.out.println("O driver esta ligado\n");
        else
            System.out.println("O driver nao esta ligado\n");
        
        return ligado;
    } 

    public void imprimePaginas (String MinhaImpressao){
        if(ligado)
            System.out.println("Sua impressao é: "+ MinhaImpressao + "\n");
    }
    
    public void executaTeste(){
        if (verificaStatus())
            imprimePaginas("Teste, Teste");
        else{
            System.out.println("Ligando Driver...\n");
            ligaDispositivo();
            imprimePaginas("Teste, Teste");
            System.out.println("Desligando Driver...\n");
            ligaDispositivo();
        }
    }
}
