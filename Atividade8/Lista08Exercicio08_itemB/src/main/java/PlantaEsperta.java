
public class PlantaEsperta extends DecoratorPlanta {
    
    PlantaEsperta(PlantaInterface umaPlanta){
        super(umaPlanta);
        
        return;
    }
    
    public void adubar(String adubo){
        if(adubo.contains("789"))
            throw new Error("ADUBO PERIGOSO, JARDINEIRO DESATENTO");
        else
            super.adubar(adubo);
            
        return;
    }
    
    public int mostraSaude(){
       return super.planta.mostraSaude();
    }
}
