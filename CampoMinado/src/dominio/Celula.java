package dominio;


public abstract class Celula {
    protected int id;
    protected boolean revelada;
    protected boolean marcacao;
    //protected boolean temBomba;
    // provavelmente essa será a maior alteração até agora

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Celula{" + "id=" + id + ", revelada=" + revelada + ", marcacao=" + marcacao + '}';
    }
    
    public abstract boolean revelar();
}

