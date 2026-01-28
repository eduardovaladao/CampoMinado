package dominio;


public abstract class Celula {
    protected int id;
    protected int[] coordenadas;
    protected boolean revelada;
    protected boolean marcacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(int[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public boolean isRevelada() {
        return revelada;
    }

    public void setRevelada(boolean revelada) {
        this.revelada = revelada;
    }

    public boolean isMarcacao() {
        return marcacao;
    }

    public void setMarcacao(boolean marcacao) {
        this.marcacao = marcacao;
    }

    @Override
    public String toString() {
        return "Celula{" + "id=" + id + ", coordenadas=" + coordenadas + ", revelada=" + revelada + ", marcacao=" + marcacao + '}';
    }
    
    public abstract boolean revelar();
}
