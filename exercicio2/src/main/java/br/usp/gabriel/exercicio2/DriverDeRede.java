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
public class DriverDeRede extends DriverGenerico {
    private boolean ligado;
    
    DriverDeRede(){
        ligado = false;
    }
    
    public void ligaDispositivo(){
        if(ligado) 
            ligado = false;
        else 
            ligado = true;
    }
     
    public boolean verificaStatus(){
        if(ligado)
            System.out.println("O driver de rede esta ligado \n");
        else
            System.out.println("O driver de rede nao esta ligado \n");
        
        return ligado;
    }
    
    public void enviaPacoteDeDados(){
       if (ligado)
           System.out.println("Enviando seu pacote... Pacote enviado! \n");
       else 
           System.out.println("Driver desligado \n");
    }
    
    public void executaTeste(){
        if(verificaStatus())
            enviaPacoteDeDados();
        else{
            System.out.println("Ligando Driver...\n");
            ligaDispositivo();
            enviaPacoteDeDados();
            System.out.println("Desligando Driver...\n");
            ligaDispositivo();
        }
    }
}