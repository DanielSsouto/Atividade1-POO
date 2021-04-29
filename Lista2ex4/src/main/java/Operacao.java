
import java.util.Date;
import java.util.Calendar;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Operacao {
    Usuario Usuario;
    char Operador;
    Calendar data;
    
    Operacao(Usuario _usuario, char _Operador){
        Usuario = _usuario;
        Operador = _Operador;
        data = Calendar.getInstance();
    }
    
    double operar(double a, double b){
        switch(Operador){
            case '+':
                return a+b;
                
            case '-':
                return a-b;
                
            case '*':
                return a*b;
                
            case '/':
                return a/b;
                
        }
        return 0;
    }
}
