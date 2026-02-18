package dominio;

import java.io.Serializable;

public class Recorde implements Serializable, Comparable<Recorde> {

    private String nomeJog;
    private int tempo;

    public Recorde(String nome, int tempo) {
        this.nomeJog = nome;
        this.tempo = tempo;
    }
    

    public String getNome() { return nomeJog; }
    public int getTempo() { return tempo; }

    @Override
    public String toString() {
        return nomeJog + " - " + tempo + "s";
    }

    @Override
    public int compareTo(Recorde outro) {
        return Integer.compare(this.tempo, outro.tempo);
    }
}