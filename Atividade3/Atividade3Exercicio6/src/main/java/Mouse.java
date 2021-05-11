/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Mouse implements Dispositivo{

    /**
     * @return the positionX
     */
   
    
    boolean status;
    private int positionX;
    private int positionY;
    
    public void setNovaPosicao(int X, int Y){
        
        this.positionX = X;
        this.positionY = Y;
    }
     public int getPositionX() {
        return positionX;
    }

    /**
     * @param positionX the positionX to set
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * @return the positionY
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * @param positionY the positionY to set
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
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
       System.out.print("O dispositivo mouse foi calibrado!"); //To change body of generated methods, choose Tools | Templates.
    }
}
