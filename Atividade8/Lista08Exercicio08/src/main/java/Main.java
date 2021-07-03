/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Main {
    public static void main(String[] args) {
        //Sem Proxy
        Planta castanheira = new Planta("Castanheira", 10, 9);
        
        System.out.println("Adubando a castanheira. Saude atual:"+ castanheira.mostraSaude());
        castanheira.adubar("Potassio_100");
        System.out.println("Adubada! Saude atual: "+castanheira.mostraSaude());
        
        System.out.println("Adubando a castanheira. Saude atual:"+ castanheira.mostraSaude());
        castanheira.adubar("Veneno_789");
        System.out.println("Adubada! Saude atual: "+castanheira.mostraSaude());
        
        //Com Proxy
        ProxyPlanta samambaia = new ProxyPlanta("samambaia", 10, 9);
        
        System.out.println("Adubando a samambaia. Saude atual:"+ samambaia.mostraSaude());
        samambaia.adubar("Potassio_100");
        System.out.println("Adubada! Saude atual: "+samambaia.mostraSaude());
        
        System.out.println("Adubando a samambaia. Saude atual:"+ samambaia.mostraSaude());
        try{
            samambaia.adubar("Veneno_789");
        } catch(Error e){
            System.out.println(e.getMessage());
        }
        System.out.println("Adubada! Saude atual: "+samambaia.mostraSaude());
    }
    
}
