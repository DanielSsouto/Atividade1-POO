/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Impressora implements Dispositivo{
    
    boolean status;
    private int capacidade;
  
    Impressora(int _capacidade){
        this.capacidade = _capacidade;
        
    }
    
    public void imprimir(int quantidade){
        this.capacidade = this.capacidade - quantidade;
        
        System.out.print("Imprimindo " + String.valueOf(quantidade) +" folhas, Capacidade de impressao "+ String.valueOf(this.capacidade));
    }
    
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * @param capacidade the capacidade to set
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
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
       System.out.print("O dispositivo Impressora foi calibrado!"); //To change body of generated methods, choose Tools | Templates.
    }
}
