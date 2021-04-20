/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.usp.gabriel.exercicio2;

/**
 *
 * @author gabriel
 */
public class DriverGenerico {
    private boolean ligado;
    
    DriverGenerico(){
        ligado = false;
    }
    
    public void ligaDispositivo(){
        ligado = true;
    }
    
    public boolean verificaStatus(){
        if(ligado)
            System.out.println("O driver esta ligado");
        else
            System.out.println("O driver nao esta ligado");
        
        return ligado;
    } 
    
    public void executaTeste(){
        // nao entendi o que esse metodo deveria fazer
    }


}


