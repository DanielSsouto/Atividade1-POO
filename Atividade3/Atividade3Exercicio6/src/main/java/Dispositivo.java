/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public interface Dispositivo {
    
   abstract void ligar();
   abstract void desligar();
   abstract int checarStatus();
   abstract void calibrar();
   
}
