import java.util.ArrayList;
import java.util.Arrays;

public class testaAtividade {

    public static void main(String[] args) {
        TimeFutebol[] timesCampeonato = {new TimeFutebol("Sao Paulo", 5, 3, 1, 10, 6, 3, 4),
                                        new TimeFutebol("Palmeiras", 7, 2, 0, 16, 3, 4, 10),
                                        new TimeFutebol("Botafogo", 5, 3, 1, 10, 6, 3, 4), 
                                        new TimeFutebol("Flamengo", 7, 2, 0, 16, 3, 5, 11),
                                        new TimeFutebol("Gremio", 7, 2, 0, 16, 3, 5, 11)};
        
        System.out.println(timesCampeonato[0].mostraNome()+" "+timesCampeonato[0].mostraPontuacao()+"\n");
        System.out.println(timesCampeonato[1].mostraNome()+" "+timesCampeonato[1].mostraPontuacao()+"\n");
        System.out.println(timesCampeonato[2].mostraNome()+" "+timesCampeonato[2].mostraPontuacao()+"\n");
        System.out.println(timesCampeonato[3].mostraNome()+" "+timesCampeonato[3].mostraPontuacao()+"\n");
        System.out.println(timesCampeonato[4].mostraNome()+" "+timesCampeonato[4].mostraPontuacao()+"\n");
        
        Arrays.sort(timesCampeonato);
        
        System.out.println(timesCampeonato[0].mostraNome()+" "+timesCampeonato[0].mostraPontuacao()+"\n");
        System.out.println(timesCampeonato[1].mostraNome()+" "+timesCampeonato[1].mostraPontuacao()+"\n");
        System.out.println(timesCampeonato[2].mostraNome()+" "+timesCampeonato[2].mostraPontuacao()+"\n");
        System.out.println(timesCampeonato[3].mostraNome()+" "+timesCampeonato[3].mostraPontuacao()+"\n");
        System.out.println(timesCampeonato[4].mostraNome()+" "+timesCampeonato[4].mostraPontuacao()+"\n");
        
        return;
    }
    
}
