/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Scanner_Bluetooth extends Dispositivo_Bluetooth {
     private String diretorio_do_arquivo;
     
     Scanner_Bluetooth(String _diretorio){
         this.diretorio_do_arquivo = _diretorio;
     }
     
    /**
     * @return the diretorio_do_arquivo
     */
    public String getDiretorio_do_arquivo() {
        return diretorio_do_arquivo;
    }

    /**
     * @param diretorio_do_arquivo the diretorio_do_arquivo to set
     */
    public void setDiretorio_do_arquivo(String diretorio_do_arquivo) {
        this.diretorio_do_arquivo = diretorio_do_arquivo;
    }
    
    
   
}
