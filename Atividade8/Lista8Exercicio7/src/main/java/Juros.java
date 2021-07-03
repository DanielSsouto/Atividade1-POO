
public class Juros extends DecoradorDivida { // juros 10 por cento
    
    Juros(Divida minhaDivida) {
        super(minhaDivida);
        super.umaDivida.pagarDivida((float) (-super.umaDivida.mostrarDivida()*0.1));
    }

    public void pagarDivida(float decrementa) {
        super.umaDivida.pagarDivida((float) (decrementa));
        
        return;
    }
    
}
