package dominio;


public class ImprimeCronometro implements interfaceCronometro{
    //classe feita APENAS para imprimir a cada 1 segundo na tela
    @Override
    public void aCadaSegundo(long seg){
        System.out.println("Tempo: " + seg + "s");
    }
}
