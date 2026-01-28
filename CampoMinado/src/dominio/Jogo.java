package dominio;

public class Jogo {
    private int id;
    private Campo campo;
    private Jogador jogador;
    private Tempo temporizador;
    private int pontuacao;

    public Jogo() {
    }

    public Jogo(int id, Campo campo, Jogador jogador, Tempo temporizador, int pontuacao) {
        this.id = id;
        this.campo = campo;
        this.jogador = jogador;
        this.temporizador = temporizador;
        this.pontuacao = pontuacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Tempo getTemporizador() {
        return temporizador;
    }

    public void setTemporizador(Tempo temporizador) {
        this.temporizador = temporizador;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return "Jogo{" + "id=" + id + ", campo=" + campo + ", jogador=" + jogador + ", temporizador=" + temporizador + ", pontuacao=" + pontuacao + '}';
    }
    
    
}
