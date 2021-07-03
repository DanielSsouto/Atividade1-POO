
public abstract class DecoratorPlanta implements PlantaInterface {
    PlantaInterface planta;
    
    DecoratorPlanta(PlantaInterface umaPlanta){
        planta = umaPlanta;
    }
    
    public void adubar(String adubo){
        planta.adubar(adubo);
    }
    
    public int mostraSaude(){
        return planta.mostraSaude();
    }
}
