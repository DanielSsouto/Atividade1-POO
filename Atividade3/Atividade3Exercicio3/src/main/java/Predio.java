/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Predio implements PegadaDeCarbono{

  
    
    private int num_pessoas;
    private float kwh_per_capta;
    private float kwh_total;
    
    Predio(int _pessoas,float  _kwh_per_capta){
        this.num_pessoas = _pessoas;
        this.kwh_per_capta=_kwh_per_capta;
        this.kwh_total = _pessoas*_kwh_per_capta;
    }
    
    public void novos_moradores(int n_moradores){
        setNum_pessoas(getNum_pessoas()+n_moradores);
        setKwh_total(getKwh_total()+n_moradores*getNum_pessoas());
        
    }
   
    /**
     * @return the num_pessoas
     */
    public int getNum_pessoas() {
        return num_pessoas;
    }

    /**
     * @param num_pessoas the num_pessoas to set
     */
    public void setNum_pessoas(int num_pessoas) {
        this.num_pessoas = num_pessoas;
    }

    /**
     * @return the kwh_per_capta
     */
    public float getKwh_per_capta() {
        return kwh_per_capta;
    }

    /**
     * @param kwh_per_capta the kwh_per_capta to set
     */
    public void setKwh_per_capta(float kwh_per_capta) {
        
        this.kwh_per_capta = kwh_per_capta;
        setKwh_total(this.kwh_per_capta*this.num_pessoas);
    }

      /**
     * @return the kwh_total
     */
    public float getKwh_total() {
        return kwh_total;
    }

    /**
     * @param kwh_total the kwh_total to set
     */
    public void setKwh_total(float kwh_total) {
        this.kwh_total = kwh_total;
    }

    @Override
    public float PegadaDeCarbono() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
