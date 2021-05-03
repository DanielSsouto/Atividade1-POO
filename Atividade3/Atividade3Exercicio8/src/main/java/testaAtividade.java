import java.util.ArrayList;
import java.util.Arrays;

public class testaAtividade {

    public static void main(String[] args) {
        TimeFutebol[] timesCampeonato = {new TimeFutebol(5, 3, 1, 10, 6, 3, 4),
                                        new TimeFutebol(7, 2, 0, 16, 3, 4, 10),
                                        new TimeFutebol(5, 3, 1, 10, 6, 3, 4)};
        
        System.out.println("Pontuacao do time 1: "+timesCampeonato[0].mostraPontuacao()+"\n");
        System.out.println("Pontuacao do time 2: "+timesCampeonato[1].mostraPontuacao()+"\n");
        System.out.println("Pontuacao do time 3: "+timesCampeonato[2].mostraPontuacao()+"\n");
        
        Arrays.sort(timesCampeonato);
        
        System.out.println("Pontuacao do time 1: "+timesCampeonato[0].mostraPontuacao()+"\n");
        System.out.println("Pontuacao do time 2: "+timesCampeonato[1].mostraPontuacao()+"\n");
        System.out.println("Pontuacao do time 3: "+timesCampeonato[2].mostraPontuacao()+"\n");
        
        return;
    }
    
}
