package dominio;

import java.io.Serializable;

public class CelulaBonus extends Celula implements Serializable {

    public CelulaBonus() {
        super();
    }

    public CelulaBonus(int id, boolean revelada, boolean marcacao, boolean temBomba, int minasAdjacentes) {
        super(id, revelada, marcacao, temBomba, minasAdjacentes);
    }

     
    //Varre o tabuleiro e marca a primeira bomba encontrada que ainda não esteja marcada.*/
    public void executarBonus(Celula[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {// Se a célula tem bomba e o jogador ainda não a marcou
                if (tabuleiro[i][j].temBomba() && !tabuleiro[i][j].estaMarcada()) {
                    tabuleiro[i][j].setMarcacao(true);
                    System.out.println("\n[BÔNUS] Uma mina foi detectada e marcada para você em [" + (i+1) + "," + (j+1) + "]!");
                    return; // Encerra após marcar a primeira}}}
                }
                else System.out.println("\n[BÔNUS] Nenhuma bomba disponível para marcação.");
            }
        }
    }
}          