/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Carro implements PegadaDeCarbono {
 //quantidade de carbono gasta por km
    private float combustivel_km;
    private float kms_rodados_mes;
    private String marca_carro;
    
    Carro(float _combustivel, String _marca){
        this.combustivel_km = _combustivel;
        this.marca_carro = _marca;
    }
    
    
    public float combustivel_mesal(){
        return this.kms_rodados_mes*this.combustivel_km;
    }
    /**
     * @return the combustivel_km
     */
    public float getCombustivel_km() {
        return combustivel_km;
    }

    /**
     * @param combustivel_km the combustivel_km to set
     */
    public void setCombustivel_km(float combustivel_km) {
        this.combustivel_km = combustivel_km;
    }

    /**
     * @return the kms_rodados_mes
     */
    public float getKms_rodados_mes() {
        return kms_rodados_mes;
    }

    /**
     * @param kms_rodados_mes the kms_rodados_mes to set
     */
    public void setKms_rodados_mes(float kms_rodados_mes) {
        this.kms_rodados_mes = kms_rodados_mes;
    }

    /**
     * @return the marca_carro
     */
    public String getMarca_carro() {
        return marca_carro;
    }

    /**
     * @param marca_carro the marca_carro to set
     */
    public void setMarca_carro(String marca_carro) {
        this.marca_carro = marca_carro;
    }

    @Override
    public float PegadaDeCarbono() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}
