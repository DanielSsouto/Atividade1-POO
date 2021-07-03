
public class Main {
    public static void main(String args[]){
        Calculadora calc = new CalculaMultiplos2(new CalculaMultiplos3( new CalculaMaiorQue3()));
        double[][] aux = {{0, 0}, {0, 0}, {0, 0}};
        
        System.out.println("Calculando para os numeros 10, 27, e 55");
        aux[0] = calc.calcular(10);
        aux[1] = calc.calcular(27);
        aux[2] = calc.calcular(55);
        System.out.println("10: "+aux[0][0]+", "+aux[0][1]+"\n"+
                            "27: "+aux[1][0]+", "+aux[1][1]+"\n"+
                            "55: "+aux[2][0]+", "+aux[2][1]);
    }
}
