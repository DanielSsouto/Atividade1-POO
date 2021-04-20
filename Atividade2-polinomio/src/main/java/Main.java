import java.util.Scanner;

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
        Polinomio polinom;
        int grau;
        int menu;
        float aux;
        Scanner ler = new Scanner(System.in);      
        
        System.out.println("Atividade 2 - Polinomio \n\n"
                + "Qual o grau do seu polinomio? \n");
        
        grau = ler.nextInt();
        polinom = new Polinomio(grau);
        polinom.Mostra();
        
        do{
            System.out.println("\n O que você deseja fazer? \n"
                    + "  Digite 1 para somar valor a algum coeficiente \n"
                    + "  Digite 2 para ver o polinomio \n"
                    + "  Digite 3 para calcular o polinomio em um ponto \n"
                    + "  Digite 4 para sair do programa \n");
            menu = ler.nextInt();
            
            switch(menu){
                    case 1:
                        System.out.println("\n Digite o valor a ser somado no coeficiente \n");
                        aux = ler.nextFloat();
                        System.out.println("\n Digite o grau do coeficiente \n");
                        grau = ler.nextInt();
                        polinom.Add(grau, aux);
                        polinom.Mostra();
                        break;
                    case 2:
                        polinom.Mostra();
                        break;
                    case 3:                     
                        System.out.println("\n Digite o valor a ser calculado \n");
                        aux = ler.nextFloat();
                        polinom.Calcula(aux);
                        break;
                    case 4:
                        break;

            }       
        }while(menu != 4);
        
    }
    
}
