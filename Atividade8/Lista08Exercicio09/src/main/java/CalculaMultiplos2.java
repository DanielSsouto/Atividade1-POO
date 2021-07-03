
public class CalculaMultiplos2 extends Calculadora{
    public CalculaMultiplos2(Calculadora meuSucessor) {
        super(meuSucessor);
    }
    
    protected boolean comportaNumero(double n){
        if(n % 2 == 0)
            return true;
        else
            return false;
    }    
    
    protected double[] calcula(double n){
        System.out.println("CalculaMultiplos2 estah trabalhando...");
        double[] a = {Math.sqrt(n), Math.pow(n, 2)};
        return a;
    }
}
