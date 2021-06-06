
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;


public class EditorDeArquivos {
    private File diretorio;
    private String extensao;
    
    EditorDeArquivos(String novoDiretorio, String novaExtensao){
        diretorio = new File(novoDiretorio);
        extensao = novaExtensao;
        
        return;
    }
    
    private boolean verificaExtensao(String nome){
        if(nome.length() - extensao.length() > 0) // se o nome do arquivo eh capaz de conter alguma extensao de mesmo tamanho
            return (nome.substring(nome.length() - extensao.length(), nome.length()).contains(extensao)); // se a extentao eh a mesma
        else
            return false;
    }
    
    public void mostraArquivos(){
       String[] arquivos = diretorio.list();
        
       if(arquivos.length > 0){
           System.out.println("Arquivos do diretorio "+diretorio.getName()+":\n");
          
            int i = 0;
            for(String arquivo : arquivos)
                if(verificaExtensao(arquivo))
                    System.out.println((i++)+": "+arquivo+"\n");
        } else
            System.out.println("O diretorio "+diretorio.getName()+" esta vazio\n");
        
        return;
    }      
    
    public ArrayList<File> ordenaArquivosPorTamanho(){
        ArrayList<File> ordenado = new ArrayList();
        
        for(File aux : diretorio.listFiles())
            if(verificaExtensao(aux.getName()))
                ordenado.add(aux);
            
        Collections.sort(ordenado, new ComparaArquivosPorTamanho());
        
        return ordenado;
    }
    
    public void removeCaracter(String c){
        String nomeSemExtensao;
        File aux;
        int i = 0, j = 0;

        for(String arquivo : diretorio.list())
            if(verificaExtensao(arquivo))
                try{
                    nomeSemExtensao = arquivo.substring(0, arquivo.length()-extensao.length()); 
                    aux = new File(diretorio, arquivo);
                    aux.renameTo(new File(diretorio, nomeSemExtensao.replace(c, "")+extensao));
                    
                } catch(NullPointerException e){
                    System.out.println("NULL Nao foi possivel renomear o arquivo: "+ arquivo);
                    
                } catch(SecurityException e){
                    System.out.println("SECURITY Nao foi possivel renomear o arquivo: "+ arquivo);
                    
                } 
        
        return;
    }
    
    public void removeInteiros(){
        String nomeSemExtensao;
        File aux;
        
        for(String arquivo: diretorio.list()) 
            if(verificaExtensao(arquivo))
                try{
                    nomeSemExtensao = arquivo.replace(extensao, "");
                    aux = new File(diretorio, arquivo);
                    aux.renameTo(new File(diretorio, nomeSemExtensao.replaceAll("[0-9]","")+extensao));
                    
                } catch(NullPointerException e){
                    System.out.println("NULL Nao foi possivel renomear o arquivo: "+ arquivo);

                } catch(SecurityException e){
                    System.out.println("SECURITY Nao foi possivel renomear o arquivo: "+ arquivo);
                } 

        return;
    }
    
    public void adicionaNumeracao(){
        String arquivo;
        String zeros = "000";
        File aux;
        ArrayList<File> ordenado = new ArrayList();
        ordenado = ordenaArquivosPorTamanho(); // garante que a numeracao eh coerente com a ordenacao
        int i, ordem;
        
        for(i = 0; i <= ordenado.size() - 1; i++) {
            arquivo = ordenado.get(i).getName();
            System.out.println(arquivo);
            if(verificaExtensao(arquivo))
                try{
                    //determina quantas casas nao nulas a numeracao do arquivo atual deve ter
                    ordem = 1;
                    while((i+1)/Math.pow(10, ordem) > 1 && ordem <= 4){ 
                        ordem++;
                        zeros = zeros.substring(0, zeros.length() - 1);
                    }
                    
                    aux = new File(diretorio, arquivo);
                    if(ordem <= 4)
                        aux.renameTo(new File(diretorio, zeros+Integer.toString(i+1)+arquivo));
                    else // se temos mais do que 9999 arquivos, adicionamos o numero sem 0's na sua frente
                       aux.renameTo(new File(diretorio, Integer.toString(i)+arquivo));
                    
                } catch(NullPointerException e){
                    System.out.println("NULL Nao foi possivel renomear o arquivo: "+ arquivo);
                    
                } catch(SecurityException e){
                    System.out.println("SECURITY Nao foi possivel renomear o arquivo: "+ arquivo);
                    
                }
        }
        
        return;
    }
    
}

