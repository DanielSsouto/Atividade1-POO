
public class JurosComDesconto extends DecoradorDivida { //juros de 1 por cento
    JurosComDesconto(Divida minhaDivida) {
        super(minhaDivida);
        super.umaDivida.pagarDivida((float) (-super.umaDivida.mostrarDivida()*0.01));
    }

    public void pagarDivida(float decrementa) {
        super.umaDivida.pagarDivida((float) (decrementa));
        
        return;
    }
}
