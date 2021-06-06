
import java.io.File;
import java.util.Comparator;

public class ComparaArquivosPorTamanho implements Comparator<File>{
    @Override
    public int compare(File arquivo1, File arquivo2) {
        return (int) (arquivo1.getTotalSpace() - arquivo2.getTotalSpace());    
    }
}