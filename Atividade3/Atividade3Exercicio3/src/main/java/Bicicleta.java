/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Bicicleta implements PegadaDeCarbono {
    
    private String marca_bicicleta;
    private Float kms_rodados;
    Bicicleta(String _marca_bicicleta){
        this.marca_bicicleta = _marca_bicicleta;
    }
    /**
     * @return the marca_bicicleta
     */
    public String getMarca_bicicleta() {
        return marca_bicicleta;
    }

    /**
     * @param marca_bicicleta the marca_bicicleta to set
     */
    public void setMarca_bicicleta(String marca_bicicleta) {
        this.marca_bicicleta = marca_bicicleta;
    }

    /**
     * @return the kms_rodados
     */
    public Float getKms_rodados() {
        return kms_rodados;
    }

    /**
     * @param kms_rodados the kms_rodados to set
     */
    public void setKms_rodados(Float kms_rodados) {
        this.kms_rodados = kms_rodados;
    }

    @Override
    public float PegadaDeCarbono() {
        
        System.out.print("A pegada de carbono da bicicleta é:0");
        return 0 ; //To change body of generated methods, choose Tools | Templates.
    }
    
    
  
}
