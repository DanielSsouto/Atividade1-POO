
public class CalculaMultiplos3 extends Calculadora {
    public CalculaMultiplos3(Calculadora meuSucessor) {
        super(meuSucessor);
    }
    
    protected boolean comportaNumero(double n){
        if(n % 3 == 0)
            return true;
        else
            return false;
    }    
    
    protected double[] calcula(double n){
        System.out.println("CalculaMultiplos3 estah trabalhando...");
        double[] a = {Math.sqrt(n), Math.pow(n, 2)};
        return a;
    }
}
