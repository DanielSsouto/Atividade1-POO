
public class DriverDeVideo {
    private boolean ligado;
    private float brilho;
     
    DriverDeVideo(){
        ligado = false;
        brilho = 0;
    }
    
    public void ligaDispositivo(){
        if(ligado) 
            ligado = false;
        else 
            ligado = true;
    }
    
    public boolean verificaStatus(){
        if(ligado)
            System.out.println("O driver de video esta ligado \n");
        else
            System.out.println("O driver de video nao esta ligado \n");
        
        return ligado;
    } 
    
    //Se NovoBrilho for positivo, entao atribuimos NovoBrilho a brilho
    //Se NovoBrilho eh negativo, entao atribuimos brilho-NovoBrilho a brilho
    public void alteraBrilhoDeExibicao(float NovoBrilho){
        if (ligado)
            if(NovoBrilho >= 0 && NovoBrilho <= 10){
                brilho = NovoBrilho;
                System.out.println("Brilho:" + NovoBrilho+ "\n");
            
            } else if(NovoBrilho <= 0 && NovoBrilho >= -brilho){
                brilho += NovoBrilho;
                System.out.println("Brilho:" + brilho + "\n");
            }else
                System.out.println("Brilho invalido \n");
        else 
            System.out.println("Driver desligado \n");
    }
    
    public void executaTeste(){
        if(verificaStatus()){
            System.out.println("Testanto brilho... \n");
            alteraBrilhoDeExibicao(5);
            alteraBrilhoDeExibicao(5);}
        else{
            System.out.println("Ligando Driver...\n");
            ligaDispositivo();
            System.out.println("Testanto brilho... \n");
            alteraBrilhoDeExibicao(5);
            alteraBrilhoDeExibicao(-5);
            System.out.println("Desligando Driver...\n");
            ligaDispositivo();
        }
        
    }
}
