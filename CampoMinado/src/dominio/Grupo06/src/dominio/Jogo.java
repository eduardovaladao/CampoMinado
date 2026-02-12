package dominio;

public class Jogo {

    private int id;
    private Campo campo;
    private Jogador jogador;
    private int pontuacao;
    private int dificuldade;

    public Jogo() {
    }

    public Jogo(int id, Campo campo, Jogador jogador, int dificuldade) {
        this.id = id;
        this.campo = new Campo(dificuldade);
        this.dificuldade = dificuldade;
        this.jogador = jogador;
        this.pontuacao = 0;
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

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return "Jogo{" + "id=" + id + ", campo=" + campo + ", jogador=" + jogador + ", pontuacao=" + pontuacao + ", dificuldade=" + dificuldade + '}';
    }

    public int lance(int x, int y, int escolha) {
        int res = 0;
        switch (escolha) {
            case 1 -> {
                if (!this.getCampo().getTabuleiro()[x][y].isRevelada()) { //se a celula nao foi revelada
                    this.getCampo().getTabuleiro()[x][y].revelar();
                    
                    if (this.getCampo().getTabuleiro()[x][y].temBomba()) {
                        res = 1;
                    }
                }
            }
            case 2 -> {
                if (!this.getCampo().getTabuleiro()[x][y].estaMarcada()) {
                    this.getCampo().getTabuleiro()[x][y].setMarcacao(true);
                }
            }  
        }
        return res; // retorna 1 se revelar e tiver bomba
    }
    
    public boolean condicaoDeVitoria(int condicao) {
        boolean res = false;
        if (condicao == 1) {
            System.out.println("Fim de jogo!");
            res = false;
        } else if (condicao == 0) {
            
            int tamanho = this.getCampo().getTamanho();
            int bombas = this.getCampo().getQntBombas();
            
            int soma = 0;
            int total = (tamanho * tamanho) - bombas;
            
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    if (!this.getCampo().getTabuleiro()[i][j].temBomba() && this.getCampo().getTabuleiro()[i][j].isRevelada()) {
                        soma++;
                    }
                }
            }
            
            if (soma == total) {
                System.out.println("Vitória");
                res = true;
            }
        }
        return res;
    }

    
}

