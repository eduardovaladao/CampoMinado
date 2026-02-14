package dominio;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private int id;
    private String apelido;
    private String senha;
    private List<Jogo> jogos;
    
    public Jogador() {
    }

    public Jogador(int id, String apelido, String senha) {
        this.id = id;
        this.apelido = apelido;
        this.senha = senha;
        this.jogos = new ArrayList<>(); //criando lista//
    }

    public int getId(){ 
        return id; 
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getApelido(){ 
        return apelido; 
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    
    public String getSenha(){ 
        return senha; 
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void adicionarJogo(Jogo jogo){
        if (jogo != null) jogos.add(jogo);
    }

    public List<Jogo> getJogos(){
        //return List.copyOf(jogos);   //você retorna uma cópia imutável//
        return jogos;
    }

    public int getPontuacaoTotal() {
        int soma = 0;
        for (int i = 0; i < jogos.size(); i++){   //pega a pontuação de cada jogo que o jogador já jogou, e soma tudo, ex: 10 + 30 + 25. Pontuação total = 65//
            soma += jogos.get(i).getPontuacao();
        }
        return soma;
    }
}

