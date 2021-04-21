
import java.util.ArrayList;

public class Polinomio {
    int grau;
    ArrayList<Termo> MeuPolinomio;

    Polinomio(int grauDoPolinomio) {
        grau = grauDoPolinomio;
        MeuPolinomio = new ArrayList<Termo>();
        
        Termo termo_aux;
        for (int i = 0; i <= grau; i++) {
            termo_aux = new Termo(0, i);
            MeuPolinomio.add(termo_aux);
        }
    }

    public void Add(int n, float valor) {
        if (n > grau)
            System.out.println("Grau do termo excede o do polinomio");
        else
            MeuPolinomio.get(n).coeficiente = MeuPolinomio.get(n).coeficiente + valor;
    }

    public void Mostra() {
        System.out.print("P(x)=");

        for (int i = 0; i <= grau; i++) {
            if (i == 0) {
                System.out.print(String.valueOf(MeuPolinomio.get(i).coeficiente));
            } else {
                System.out.print("+" + String.valueOf(MeuPolinomio.get(i).coeficiente) + "x^" + String.valueOf(i));
            }
        }
        
        System.out.println("\n");
    }

    public void Calcula(float valor_) {
        float resultado = 0;

        for (int i = 0; i <= grau; i++) {
            resultado += Math.pow(valor_, i) * MeuPolinomio.get(i).coeficiente;
        }
        
        System.out.print("P(" + String.valueOf(valor_) + ")=");
        System.out.print(String.valueOf(resultado));
    }
}
