
import java.io.File;
import java.util.Comparator;

public class ComparaArquivosPorTamanho implements Comparator<File>{
    @Override
    public int compare(File arquivo1, File arquivo2) {
        if (arquivo1.length() - arquivo2.length() > 0)
            return 1;
        else if (arquivo1.length() - arquivo2.length() == 0)
            return 0;
        else
            return -1;
    }
}