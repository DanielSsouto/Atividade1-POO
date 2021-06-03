/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
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
        
        ContaCorrente conta = new ContaCorrente("Jorge", 5000, 1000);
        
        try{
        conta.Depositar(-50);
    }catch(ValorForaDosLimites e){
        System.out.println(String.valueOf(e.getMessage()));
    }
    
    try{
        conta.Depositar(50);
        conta.Sacar(10000);
    }catch(ValorForaDosLimites e){
        System.out.println(String.valueOf(e.getMessage()));
    }
}
}
