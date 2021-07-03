abstract class Calculadora {
    private Calculadora sucessor;
    
    Calculadora(Calculadora meuSucessor){
        sucessor = meuSucessor;
    }
    
    protected abstract boolean comportaNumero(double n);    
    protected abstract double[] calcula(double n);
    
    public double[] calcular(double n){
        if(this.comportaNumero(n))
           return this.calcula(n);
        else
            return this.sucessor.calcular(n);
    }
    
}
