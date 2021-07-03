
public abstract class DecoradorDivida implements Divida {
    Divida umaDivida;
    
    DecoradorDivida(Divida minhaDivida){
        umaDivida = minhaDivida;
    }
    
    public void pagarDivida(float decrementa) {
        umaDivida.pagarDivida(decrementa);
    }
    
    public float mostrarDivida(){
        return umaDivida.mostrarDivida();
    }
}
