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
public class Polinomio {
    int grau;
    ArrayList<Termo> poli;

    Polinomio(int grau_){
       grau=grau_;
       poli = new ArrayList<Termo>();
       Termo termo_aux;
       for(int i=0; i<=grau; i++){
             termo_aux = new Termo(0, i);
             poli.add(termo_aux);
       }
       
   }
    
    public void Add(int n, float valor_){
        if(n>grau){
            System.out.println("Grau do termo excede o do polinomio");
        
        }else{
            poli.get(n).coeficiente= poli.get(n).coeficiente + valor_;

        }
        
    }
    
    public void Mostra(){
        System.out.print("P(x)=");
        
        for(int i=0; i<=grau; i++){
            if(i==0){
                System.out.print(String.valueOf(poli.get(i).coeficiente));
            }else{
            System.out.print("+"+String.valueOf(poli.get(i).coeficiente)+"x^"+String.valueOf(i));
            }
        }
        System.out.println("\n");
    }
    
    public void Calcula(float valor_){
        
        float resultado=0;
        System.out.print("P("+String.valueOf(valor_)+")=");
        
        for(int i=0; i<=grau; i++){
            resultado+=Math.pow(i, valor_)*poli.get(i).coeficiente;
            }
        System.out.print(String.valueOf(resultado));
        }
}

