package dominio;

public class CelulaVazia extends Celula{
    private int minasAdjacentes;
    
    public CelulaVazia() {
    }
    
    public int minasAdjacentes() {
        return minasAdjacentes;
    }
    
    public void setMinasAdjacentes(int minasAdjacentes) {
        this.minasAdjacentes = minasAdjacentes;
    }
    
    public boolean revelar() {
        revelada = true;
        return false;
    }
}
