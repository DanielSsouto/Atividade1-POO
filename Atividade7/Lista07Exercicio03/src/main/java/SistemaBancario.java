

public class SistemaBancario implements Runnable{    
    Cliente cliente1;
    
    SistemaBancario(Cliente c){
        cliente1 = c;
    }
    
    @Override
    public void run() {
        int i = 0;
        while(i != 1000){
            cliente1.deposita(100);
            cliente1.saca_10();
            i++;
        }
        
        return;
    }
    
}