
package Modelo;

public class CarroFactory {
    public Carro retornaCarro(String sNomeImagePNG, boolean mortal, String umaCor, int linha, int coluna, int meuPadrao, int meuSentido){
        if(meuPadrao % 2 == 0 && meuPadrao != 8)
            return new CarroLento(sNomeImagePNG, mortal, umaCor, linha, coluna, meuPadrao, meuSentido);
        else
            return new CarroRapido(sNomeImagePNG, mortal, umaCor, linha, coluna, meuPadrao, meuSentido);
    }
}
