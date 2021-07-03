
public class ProxyPlanta {
    Planta minhaPlanta;
    
    ProxyPlanta(String umNome, int umaIdade, int umaSaude){
        minhaPlanta = new Planta(umNome, umaIdade, umaSaude);
        
        return;
    }
    
    public void adubar(String adubo){
        if(adubo.contains("789"))
            throw new Error("ADUBO PERIGOSO, JARDINEIRO DESATENTO");
        else
            minhaPlanta.adubar(adubo);
            
        return;
    }
    
    public int mostraSaude(){
       return minhaPlanta.mostraSaude();
    }
}
