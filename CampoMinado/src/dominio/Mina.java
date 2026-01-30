package dominio;

public class Mina extends Celula{
    public Mina() {
    }
    
    public boolean explodir() {
        return true;
    }
    
    public boolean revelar() {
        revelada = true;
        System.out.println("BOOM!!!");
        return true;
    }
}
