
public class NewMain {
    
    public static void main(String[] args) {
        /* 
        Realizamos, duas vezes, 1000 depositos de 100 reais, e 1000 saques de 10 reais.
        Logo, o valor correto do saldo final eh 180000
        */
        Cliente carlao = new Cliente();
        Thread cliente = new Thread(new SistemaBancario(carlao));
        Thread banco = new Thread(new SistemaBancario(carlao));
        
        banco.start();
        cliente.start();
        
        try{
            banco.join();
            cliente.join();
        } catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        
        ClienteSync judite = new ClienteSync();
        Thread cliente_sync = new Thread(new SistemaBancarioSync(judite));
        Thread banco_sync = new Thread(new SistemaBancarioSync(judite));
        
        banco_sync.start();
        cliente_sync.start();
        
        try{
            banco_sync.join();
            cliente_sync.join();
        } catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("\n\nSaldo Carlao:"+carlao.mostraSaldo());
        System.out.println("Saldo Judite:"+judite.mostraSaldo());
        
        return;
    }
    
}
