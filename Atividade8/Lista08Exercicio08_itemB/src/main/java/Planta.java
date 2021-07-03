
public class Planta implements PlantaInterface {
    private String nome;
    private int idade;
    private int saude; // nivel de saude da planta
    
    Planta(String umNome, int umaIdade, int umaSaude){
        nome = umNome;
        idade = umaIdade;
        saude = umaSaude;
        
        return;
    }
    
    public void adubar(String adubo){
        if(adubo.contains("789"))
            saude = 0; // a planta morre com esse tipo de adubo
        else
            saude++;
    }
    
    public int mostraSaude(){
        return saude;
    }
    
}
