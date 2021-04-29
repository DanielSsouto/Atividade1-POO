
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
public class Foto {
   private String Endereco;
   private Calendar data;

    Foto(String _endereco){
        Endereco = _endereco;
        data = Calendar.getInstance();
    
    }
    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Enderco) {
        this.Endereco = Enderco;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
   
}
