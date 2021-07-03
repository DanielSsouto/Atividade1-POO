
public class DividaNoBanco implements Divida {
    float divida;
    
    DividaNoBanco(float valor){
        divida = valor;
    }
    
    public void pagarDivida(float decrementa) {
        divida -= decrementa;
        if(divida < 0)
            divida = 0;
        return;
        
    }
    
    public float mostrarDivida(){
      
        return divida;
    }
}
