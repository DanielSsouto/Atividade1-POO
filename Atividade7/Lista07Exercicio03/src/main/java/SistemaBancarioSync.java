
public class SistemaBancarioSync implements Runnable{
    ClienteSync cliente1;
    
    SistemaBancarioSync(ClienteSync c){
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
    
    public int mostraSaldo(){
        return cliente1.mostraSaldo();
    }
}
