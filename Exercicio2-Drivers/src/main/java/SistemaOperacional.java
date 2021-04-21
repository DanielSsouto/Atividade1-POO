
public class SistemaOperacional {
    DriverDeImpressao MinhaImpressora;
    DriverDeRede MinhaRede;
    DriverDeVideo MeuVideo;
    
    SistemaOperacional(){
        MinhaImpressora = new DriverDeImpressao();
        MinhaRede = new DriverDeRede();
        MeuVideo = new DriverDeVideo();
    }
    
    public void executaTeste(){
        System.out.println("Testando Impressora:\n");
        MinhaImpressora.executaTeste();
        System.out.println("Testando rede:\n");
        MinhaRede.executaTeste();
        System.out.println("Testando video:\n");
        MeuVideo.executaTeste();
    }
    
    
}
