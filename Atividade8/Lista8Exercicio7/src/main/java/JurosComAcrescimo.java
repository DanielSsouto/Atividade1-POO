
public class JurosComAcrescimo extends DecoradorDivida {
    
    public JurosComAcrescimo(Divida minhaDivida) {
        super(minhaDivida);
        // acrescenta taxa e juros
        super.umaDivida.pagarDivida((float) -10); 
        super.umaDivida.pagarDivida((float) (-super.umaDivida.mostrarDivida()*0.1));
    }
    
    public void pagarDivida(float decrementa) {
        super.umaDivida.pagarDivida((float) (decrementa)); 
        
        return;
    }
    
    
}
