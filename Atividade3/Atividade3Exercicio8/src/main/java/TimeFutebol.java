
public class TimeFutebol implements Comparable<TimeFutebol> {
    int vitorias;
    int derrotas;
    int empates;
    int golsMarcados;
    int golsSofridos;
    int cartoesAmarelos;
    int cartoesVermelhos;
    
    TimeFutebol(int numVitorias, int numDerrotas, int numEmpates, int numGols, int numGolsSofridos, int numAmarelos, int numVermelhos){
        vitorias = numVitorias;
        derrotas = numDerrotas;
        empates = numEmpates;
        golsMarcados = numGols;
        golsSofridos = numGolsSofridos;
        cartoesAmarelos = numAmarelos;
        cartoesVermelhos = numVermelhos;
        
        return;
    }
    
    public int mostraPontuacao(){
        return 3*vitorias + empates;
    }
    
    public int compareTo(TimeFutebol time){
        if(this.vitorias == time.vitorias){
            if(this.golsMarcados - this.golsSofridos == time.golsMarcados - time.golsSofridos){
                if(this.golsMarcados == time.golsMarcados){
                    if(this.cartoesVermelhos == time.cartoesVermelhos){
                        if(this.cartoesAmarelos == time.cartoesAmarelos){
                            if(Math.random() > (double) 0.5)
                                return 1;
                            else 
                                return -1;
                        }else{
                            if(this.cartoesAmarelos > time.cartoesAmarelos)
                                return 1;
                            else
                                return -1;
                        }
                    }else{
                        if(this.cartoesVermelhos > time.cartoesVermelhos)
                            return 1;
                        else
                            return -1;
                    }
                }else{
                    if(this.golsMarcados > time.golsMarcados)
                        return 1;
                    else
                        return -1;
                }
            }else{
                if (this.golsMarcados - this.golsSofridos == time.golsMarcados - time.golsSofridos)
                   return 1;
                else
                    return -1;
            }
        }else{
            if(this.vitorias > time.vitorias)
                return 1;
            else
                return -1;
        }
    }

    
}
