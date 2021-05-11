
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Dispositivo> dispositivos= new ArrayList<Dispositivo>();
        Video monitor = new Video("1920x720");
        dispositivos.add(monitor);
        Impressora impressora = new Impressora(1000);
        dispositivos.add(impressora);
        Mouse mouse = new Mouse();
        dispositivos.add(mouse);
        Speaker_Bluetooth speaker = new Speaker_Bluetooth();
        dispositivos.add(speaker);
        Liga_dispositivos(dispositivos);
        
        impressora.imprimir(10);
        speaker.setVolume(20);
        
        Calibra_dispositivos(dispositivos);
        
        desliga_dispositivos(dispositivos);
        
    }
    
    static void Calibra_dispositivos(ArrayList<Dispositivo> dispositivos){
        for(int i = 0; i<dispositivos.size(); i++)
            dispositivos.get(i).calibrar();
    }
     static void Liga_dispositivos(ArrayList<Dispositivo> dispositivos){
        for(int i = 0; i<dispositivos.size(); i++)
            dispositivos.get(i).ligar();
    }
    
    static void desliga_dispositivos(ArrayList<Dispositivo> dispositivos){
        for(int i = 0; i<dispositivos.size(); i++)
            dispositivos.get(i).desligar();
    }
}
