import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SuperHeroi Aang = new SuperHeroi("Avatar Aang", "Aang");
        Vilao Ozai = new Vilao("Senhor do Fogo", "Ozai", 0);
        ArrayList TodosPoderes = new ArrayList<Superpoder>();
        Superpoder aux;
        
        for (int i = 0; i<= 3; i++){
            aux = new Superpoder(i+1, "Fogo "+(i+1));
            TodosPoderes.add(aux);
            //Aang.adicionaSuperpoder(aux);
            Ozai.adicionaSuperpoder(aux);
        }
        
        for (int i = 0; i<= 3; i++){
            aux = new Superpoder(i+1, "Ar "+(i+1));
            TodosPoderes.add(aux);
            Aang.adicionaSuperpoder(aux);
        }
        
        float intensidade = (float) (0.3);
        int j = 1;
        do{
            System.out.println("Rodada de: "+Ozai.mostraNome());
            Ozai.atacar(intensidade, "Fogo 1", Aang);
            System.out.println("\nRodada de: "+Aang.mostraNome());
            Aang.atacar(intensidade, "Ar 1", Ozai);
            j++;
            if (j == 100){
                System.out.println("Essa batalha ja foi longe demais");
                return;
            }
        }while(Aang.mostraVida() != 0 && Ozai.mostraVida() != 0);

    }
}
