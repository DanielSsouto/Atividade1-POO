
public class CalculaMaiorQue3 extends Calculadora{
    public CalculaMaiorQue3() {
        super(null);
    }
    
    protected boolean comportaNumero(double n){
        return true;
    }    
    
    protected double[] calcula(double n){
        System.out.println("CalculaMaiorQue3 estah trabalhando...");
        double[] a = {Math.sqrt(n), Math.pow(n, 2)};
        return a;
    }
}
