package dominio;

import java.util.List;

public class Ranking {
    private List<Jogo> jogos;

    public Ranking() {
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    @Override
    public String toString() {
        return "Ranking{" + "jogos=" + jogos + '}';
    }
    
    public void ordenar() {
        
    }
    
    public String listagem() {
        
    }
    
    
}
