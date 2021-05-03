import java.util.ArrayList; 
        
public class Personagem {
    private String Nome;
    private String NomeVidaReal;
    private float Vida;
    private ArrayList<Superpoder> Poderes;
    
    Personagem(String NovoNome, String NovoNomeReal){
        Nome = NovoNome;
        NomeVidaReal = NovoNomeReal;
        Vida = 100;
        Poderes = new ArrayList();
        
        return;
    }
    
    public String mostraNome(){
        return Nome;
    }
    
    public String mostraNomeVidaReal(){
        return NomeVidaReal;
    }
    public float mostraVida(){
        return Vida;
    }
    
    public void mostraTotalPoder(){
        if(Poderes.size() > 0){    
            System.out.println("Este personagem possui os poderes:");
            for(int i = 0; i <= Poderes.size(); i++){
                System.out.println("Poder" + (i+1) +
                                   "\nCategoria:"+Poderes.get(i).mostraCategoria() +
                                   "\nNome: "+Poderes.get(i).mostraNome());
            }
            
            return;
        
        } else{
            System.out.println("Nenhum Superpoder ;-;");
            return;
        }
        
    }
    
    public void adicionaSuperpoder(Superpoder NovoPoder){
        
        Poderes.add(NovoPoder);
        return;
    }
    
    // Saberemos que o objeto nao foi encontrado, se aux.Intensidade for nulo
    private Superpoder achaPoder(String Nome){ 
        int i = 0;
        Superpoder aux = new Superpoder(0,"");
        
        while(Poderes.get(i).mostraNome() != Nome && i < Poderes.size() - 1)
            i++;
        
        if(Poderes.get(i).mostraNome() == Nome)
            return(Poderes.get(i));
        else
            return aux;
    }
    private void receberAtaque(float ataque){
        if (Vida != 0)
            Vida -= ataque;
        return;
    }
    //Intensidade deve ser passada como um numero de 0 a 1
    public void atacar(float intensidade, String Golpe, Personagem Inimigo){
        if(Inimigo.mostraVida() != 0){
            
            if( (double) (0.5) < Math.random() && 0 < intensidade && intensidade < 1){ //Se o personagem assertar o golpe, descontamos vida do inimigo
                
                float aux = achaPoder(Golpe).mostraCategoria();
                
                if(aux != 0){ //Se achamos o Superpoder, realizamos o ataque
                    if (Inimigo.mostraVida() < intensidade*100){
                        Vida = 0;
                        System.out.println(Inimigo.mostraNome()+" foi derrotado por "+ Nome);
                        return;
                
                    } else{
                        Inimigo.receberAtaque(intensidade*100);
                        System.out.println(Nome+" tirou "+intensidade*100 +" pontos de vida de "+Inimigo.mostraNome()+"\n");
                        System.out.println(Inimigo.mostraNome()+" agora tem "+Inimigo.mostraVida()+" pontos de vida\n");
                        return;
                    }
                } else{
                    System.out.println("Esse poder nao foi cadastrado, ou foi escrito de maneira diferente\n"
                                        + "Confira todos os poderes do seu personagem com o metodo mostraTodosPoderes\n");
                    return;
                } 
            
            }else{
                System.out.println("O golpe falhou miseravelmente!!!(Ou voce foi safadinho e tentou passar um valor maior do que 1 para a intensidade)\n");
                return;
            }
        }
        
        return;
    }
}
