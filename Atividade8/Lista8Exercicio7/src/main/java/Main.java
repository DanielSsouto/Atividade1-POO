
public class Main {

    public static void main(String[] args) {
        Divida dividaCarlao = new Juros(new DividaNoBanco(100)); // divida com juros de 10%
        Divida dividaBerenice = new JurosComAcrescimo(new DividaNoBanco(150));
        Divida dividaCris = new JurosComDesconto(new DividaNoBanco((float) 378.90));
        
        System.out.println("Pagando a divida do Carlao");
        System.out.println("Divida atual = "+dividaCarlao.mostrarDivida());
        while(dividaCarlao.mostrarDivida()!= 0)
            dividaCarlao.pagarDivida(10);
        System.out.println("Divida paga! Divida atual = "+dividaCarlao.mostrarDivida());
        
        System.out.println("Pagando a divida da Berenice");
        System.out.println("Divida atual = "+dividaBerenice.mostrarDivida());
        while(dividaBerenice.mostrarDivida()!= 0)
            dividaBerenice.pagarDivida(10);
        System.out.println("Divida paga! Divida atual = "+dividaBerenice.mostrarDivida());
        
        System.out.println("Pagando a divida de Cris");
        System.out.println("Divida atual = "+dividaCris.mostrarDivida());
        while(dividaCris.mostrarDivida()!= 0)
            dividaCris.pagarDivida(10);
        System.out.println("Divida paga! Divida atual = "+dividaCris.mostrarDivida());
    }
    
}
