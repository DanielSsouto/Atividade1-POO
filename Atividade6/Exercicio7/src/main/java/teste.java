
import java.io.File;
import java.util.ArrayList;


public class teste {

    public static void main(String[] args) {
        EditorDeArquivos diretorio = new EditorDeArquivos("./src/main/java/musicas", ".mp3");
        
        diretorio.mostraArquivos();
        
        System.out.println("Removendo Inteiros\n");
        diretorio.removeInteiros();
        
        System.out.println("Removendo os hifens\n");
        diretorio.removeCaracter("-");
        
        System.out.println("Adicionando Numeracao\n");
        diretorio.adicionaNumeracao();
        
        diretorio.mostraArquivos();
        
    }
    
}
