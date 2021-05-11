/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Teclado implements Dispositivo {

    /**
     * @return the modelo_teclado
     */
    
    boolean status;
    private String modelo_teclado;
    
    
    Teclado(String _modelo){
    this.modelo_teclado= _modelo;
  
    }
    
    public String getModelo_teclado() {
        return modelo_teclado;
    }

    /**
     * @param modelo_teclado the modelo_teclado to set
     */
    public void setModelo_teclado(String modelo_teclado) {
        this.modelo_teclado = modelo_teclado;
    }
    
     @Override
    public void ligar() {
        this.status = true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desligar() {
        
        this.status = false;
    }

    @Override
    public int checarStatus() {
        
        if(status)
            return 1;
        else
            return 0;
    }

    @Override
    public void calibrar() {
       System.out.print("O dispositivo do teclado foi calibrado!"); //To change body of generated methods, choose Tools | Templates.
    }
}
