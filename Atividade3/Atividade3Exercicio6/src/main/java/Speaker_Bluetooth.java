/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Speaker_Bluetooth extends Dispositivo_Bluetooth{
    
    private int volume;
    
     Speaker_Bluetooth(){
       num_conectados = 1;
       
   }
    /**
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(int volume) {
        if(volume >=0 || volume <=100)
            this.volume = volume;
        else
            System.out.println("Volume fora do intervalo");
    }
    
   
   
  
}
