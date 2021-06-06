
import java.io.File;


public class teste {

    public static void main(String[] args) {
        EditorDeArquivos diretorio = new EditorDeArquivos("./src/main/java", ".mp3");
        
        diretorio.mostraArquivos();
        diretorio.ordenaArquivosPorTamanho();
        diretorio.mostraArquivos();
        
        System.out.println("Removendo Inteiros\n");
        diretorio.removeInteiros();
        
        System.out.println("Removendo os hifens\n");
        diretorio.removeCaracter('-');
        
        System.out.println("Adicionando Numeracao\n");
        diretorio.adicionaNumeracao();
        
        diretorio.mostraArquivos();
        
    }
    
}
