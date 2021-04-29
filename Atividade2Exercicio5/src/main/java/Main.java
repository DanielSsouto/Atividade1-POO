import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SuperHeroi Aang = new SuperHeroi("Avatar Aang", "Aang");
        Vilao Ozai = new Vilao("Senhor do Fogo", "Ozai", 0);
        ArrayList TodosPoderes = new ArrayList<Superpoder>();
        Superpoder aux;
        
        for (int i = 0; i<= 3; i++){
            aux = new Superpoder(1, "Fogo "+(i+1));
            TodosPoderes.add(aux);
            Aang.adicionaSuperpoder(aux);
            Ozai.adicionaSuperpoder(aux);
        }
        
        for (int i = 0; i<= 3; i++){
            aux = new Superpoder(2, "Ar "+(i+1));
            TodosPoderes.add(aux);
            Aang.adicionaSuperpoder(aux);
        }
        
        float j = 0;
        do{
            j++;
            if (j == 100){
                System.out.println("Essa batalha ja foi longe demais");
                return;
            }
            
            if (Ozai.mostraVida() == 0){
                System.out.println(Aang.mostraNome()+" ganhou essa batalha");
                return;
            }
            
            System.out.println("Rodada de: "+Ozai.mostraNome());
            Ozai.atacar(j/100, "Fogo 1", Aang);
            
            if (Aang.mostraVida() == 0){
                System.out.println(Ozai.mostraNome()+" ganhou essa batalha");
                return;
            }
            
            System.out.println("\nRodada de: "+Aang.mostraNome());
            Aang.atacar(j/100, "Ar 1", Ozai);
            
        }while(Aang.mostraVida() != 0 && Ozai.mostraVida() != 0);
        
       
    }
}
