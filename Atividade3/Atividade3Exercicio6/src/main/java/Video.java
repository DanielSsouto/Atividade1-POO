/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Video implements Dispositivo {

    /**
     * @return the resolucao_video
     */
    
    
    boolean status;
    private String resolucao_video;
    
    Video(String _resolucao){
        this.resolucao_video = _resolucao;
    }
    
    public String getResolucao_video() {
        return resolucao_video;
    }

    /**
     * @param resolucao_video the resolucao_video to set
     */
    public void setResolucao_video(String resolucao_video) {
        this.resolucao_video = resolucao_video;
    }
    
    @Override
    public void ligar() {
       status = true;
       //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public void desligar() {
        status = false; //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public int checarStatus() {
        if(status)
            return 1;
        else
            return 0;
        //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public void calibrar() {
         System.out.print("O dispositivo de video foi calibrado!"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
