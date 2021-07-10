
public class main {
    public static void main(String args[]){
        NumeroComplexo[] complexos = new NumeroComplexo[10];
        
        for(int i = 0; i < 10; i++)
            complexos[i] = new NumeroComplexo((int) (Math.random()*100), (int) (Math.random()*100));
        
        System.out.println("Nosso vetor de numeros complexos antes da ordenacao:\n");
        for(int i = 0; i < 10; i++)
            System.out.println(i+": "+complexos[i].mostraRe()+"+ i"+complexos[i].mostraIm()+
                                ", Modulo: "+complexos[i].mostraModulo());
        
        OrdenaInsercao poeOrdemNaCasa = new OrdenaInsercao();
        poeOrdemNaCasa.<NumeroComplexo>ordenaInsercao(complexos);
        
        System.out.println("Nosso vetor de numeros complexos apos a ordenacao:\n");
        for(int i = 0; i < 10; i++)
            System.out.println(i+": "+complexos[i].mostraRe()+"+ i"+complexos[i].mostraIm()+
                                ", Modulo: "+complexos[i].mostraModulo());
            
    }  
}
