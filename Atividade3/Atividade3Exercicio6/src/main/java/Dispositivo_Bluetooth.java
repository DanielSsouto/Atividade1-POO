/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Dispositivo_Bluetooth implements Dispositivo {
    boolean status;
    int num_conectados;
    
    
    
    public void conectar_dispositivo(){
        
        num_conectados++;
    }
    
    @Override
    public void ligar() {
        this.status = true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desligar() {
        this.num_conectados=0;
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
       System.out.print("O dispositivo bluetooth foi calibrado!"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
