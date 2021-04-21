
public class DriverDeRede {
    private boolean ligado;
    
    DriverDeRede(){
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
            System.out.println("O driver de rede esta ligado \n");
        else
            System.out.println("O driver de rede nao esta ligado \n");
        
        return ligado;
    }
    
    public void enviaPacoteDeDados(){
       if (ligado)
           System.out.println("Enviando seu pacote... Pacote enviado! \n");
       else 
           System.out.println("Driver desligado \n");
    }
    
    public void executaTeste(){
        if(verificaStatus())
            enviaPacoteDeDados();
        else{
            System.out.println("Ligando Driver...\n");
            ligaDispositivo();
            enviaPacoteDeDados();
            System.out.println("Desligando Driver...\n");
            ligaDispositivo();
        }
    }
}