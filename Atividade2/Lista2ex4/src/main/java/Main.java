
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<Usuario> Usuarios;
        ArrayList<Operacao> Operacoes;
        
        Usuarios = new ArrayList<Usuario>();
        Foto foto = new Foto("C://desktop/foto.png");
        Usuario user = new Usuario("Daniel", 18);
        user.setFoto(foto);
        Usuarios.add(user);
        System.out.println("Registrado usuário: "+ user.getNome());
        foto = new Foto("C://desktop/foto2.png");
        user = new Usuario("Gabriel", 20);
        user.setFoto(foto);
        Usuarios.add(user);
        System.out.println("Registrado usuário: "+ user.getNome());
        
        Operacoes = new ArrayList<Operacao>();
        System.out.println("Registrado operacao de + para o usuario: "+ Usuarios.get(0).getNome());
        Operacao operacao = new Operacao( Usuarios.get(0), '+');
        System.out.println("Operando 4.8 e 7.8:");
        System.out.println(String.valueOf(operacao.operar(4.8, 7.8)));
        Operacoes.add(operacao);
        
        System.out.println("Registrado operacao de * para o usuario: "+ Usuarios.get(1).getNome());
        operacao = new Operacao( Usuarios.get(1), '*');
        System.out.println("Operando 6.0 e 7.0:");
        System.out.println(String.valueOf(operacao.operar(6.0, 7.0)));
        Operacoes.add(operacao);
        
        System.out.println("Usuario:"+Operacoes.get(0).Usuario.getNome()+ " realizou uma operacao de "
                            + String.valueOf(Operacoes.get(0).Operador)+ " na data " + Operacoes.get(0).data.getTime());
        
        System.out.println("Usuario:"+Operacoes.get(1).Usuario.getNome()+ " realizou uma operacao de "
                            + String.valueOf(Operacoes.get(1).Operador)+ " na data " + Operacoes.get(1).data.getTime());
        
    }
    
    
}
