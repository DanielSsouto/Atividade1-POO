
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class EditorDeArquivos {
    File diretorio;
    String extensao; // so iremos considerar os arquivos dessa extensao no diretorio
    ArrayList<File> arquivos;
    
    EditorDeArquivos(String novoDiretorio, String novaExtensao){
        diretorio = new File(novoDiretorio);
        extensao = novaExtensao;
        arquivos = new ArrayList();
        
        for(String arquivo : diretorio.list())
            if(arquivo.length() - extensao.length() > 0) // se o nome do arquivo eh capaz de conter alguma extensao de mesmo tamanho
                if(arquivo.substring(arquivo.length() - extensao.length(), arquivo.length()).contains(extensao)) // se a extentao eh a mesma
                    arquivos.add(new File(diretorio, arquivo)); // adicionamos a a lista de arquivos do diretorio
        
        return;
    }
    
    public void mostraArquivos(){
        if(!arquivos.isEmpty()){
            System.out.println("Arquivos do diretorio "+diretorio.getName()+":\n");
            int i = 0;
            for(File arquivo:arquivos)
                System.out.println((i++)+": "+arquivo.getName()+"\n");
        } else
            System.out.println("O diretorio "+diretorio.getName()+" esta vazio\n");
        
        return;
    }      
    
    public void ordenaArquivosPorTamanho(){   
        Collections.sort(arquivos, new ComparaArquivosPorTamanho());
    }
    
    public void removeCaracter(char c){ // c deve ser uma string de apenas um caracter
        String nomeSemExtensao = "";
        String novoNome = "";
        int i = 0;
        int j = 0;
        File novo;
        
        for(i = 0; i< arquivos.size(); i++) 
            try{
                nomeSemExtensao = arquivos.get(i).getName().substring(0, arquivos.get(i).getName().length()-extensao.length()); 
                
                novoNome = "";
                for(j = 0; j <= nomeSemExtensao.length() - 1; j++)
                    if(nomeSemExtensao.charAt(j) == c) //substitui c por uma string vazia
                        novoNome += "";
                    else
                        novoNome += nomeSemExtensao.charAt(j);
               
                System.out.println(arquivos.get(i).renameTo(new File(diretorio, novoNome+extensao)));
                
            } catch(NullPointerException e){
                System.out.println("NULL Nao foi possivel renomear o arquivo: "+ arquivos.get(i).getName());
            
            } catch(SecurityException e){
                System.out.println("SECURITY Nao foi possivel renomear o arquivo: "+ arquivos.get(i).getName());
            } 
        
        return;
    }
    
    public void removeInteiros(){
        String nomeSemExtensao;
     
        for(int i = 0; i< arquivos.size(); i++) 
            try{
                nomeSemExtensao = arquivos.get(i).getName().replace(extensao, "");
                
                if(nomeSemExtensao.replaceAll("[0-9]","") != nomeSemExtensao)
                    System.out.println(arquivos.get(i).renameTo(new File(diretorio, nomeSemExtensao.replaceAll("[0-9]","")+extensao)));
                
            } catch(NullPointerException e){
                System.out.println("NULL Nao foi possivel renomear o arquivo: "+ arquivos.get(i).getName());
            } catch(SecurityException e){
                System.out.println("SECURITY Nao foi possivel renomear o arquivo: "+ arquivos.get(i).getName());
            } 
        
        return;
    }
    
    public void adicionaNumeracao(){
        String nomeSemExtensao;
        int ordem = 1;
        String zeros = "000";
        
        this.ordenaArquivosPorTamanho(); // garante que a numeracao serah do maior para o menor
        
        for(int i = 0; i < arquivos.size(); i++) 
            try{
                ordem = 1;
                while((i+1)/Math.pow(10, ordem) > 1 && ordem <= 4){ //determina quantas casas nao nulas a numeracao do arquivo atual deve ter
                    ordem++;
                    zeros = zeros.substring(0, zeros.length() - 1);
                }
                System.out.println(arquivos.get(i).getName());
                System.out.println(zeros+Integer.toString(i+1)+arquivos.get(i).getName());
                
                if(ordem <= 4)
                    System.out.println(arquivos.get(i).renameTo(new File(diretorio, zeros+Integer.toString(i+1)+arquivos.get(i).getName())));
                else // se temos mais do que 10 000 arquivos, adicionamos o numero sem 0's na sua frente
                    System.out.println(arquivos.get(i).renameTo(new File(diretorio, Integer.toString(i+1)+arquivos.get(i).getName())));
            
            } catch(NullPointerException e){
                System.out.println("NULL Nao foi possivel renomear o arquivo: "+ arquivos.get(i).getName());
            } catch(SecurityException e){
                System.out.println("SECURITY Nao foi possivel renomear o arquivo: "+ arquivos.get(i).getName());
            } 
        
        return;
    }
    
}

