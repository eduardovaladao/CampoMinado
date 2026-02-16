import dominio.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static Scanner s = new Scanner(System.in);
    static ArrayList<Jogador> jogadores = new ArrayList<>();
    static ArrayList<Jogo> jogos = new ArrayList<>();
    
    static int id_jogo = 0 + 1; // no luga do zero, vamos puxar um arquivo
    
    public static void main(String[] args) {
        
        // criacao do jogo/jogador
        
        System.out.println("--- Criar novo jogo! ---");      
        
        System.out.println("Selecione uma dificuldade:");
        
        int dificuldade = s.nextInt();
        s.nextLine();
        
        Jogo jogo = new Jogo(id_jogo, new Jogador(), dificuldade);
        jogo.getCampo().criarCampo();
        
        int qntdDeLances = 0;
        boolean condicao = false;
        
        do {
            exibirCampo(jogo.getCampo());
            System.out.println("\nTabuleiro [" + jogo.getCampo().getTamanho() + "x" + jogo.getCampo().getTamanho() + "]\n");
            System.out.println("Revelar: [1]\nMarcar: [2]");
            System.out.println("Dar lance: (coordenadas [x, y] e ação [1 ou 2])");


            int x = (s.nextInt() - 1); // abicissa
            int y = (s.nextInt() - 1); // ordenada

            int a = s.nextInt(); // revelar ou marcar

            if (qntdDeLances == 0) {
                jogo.getCampo().colocarBombas(x, y); // primeiro clique está seguro
                jogo.getCampo().calcularMinasAdjacentes(); // vem primeiro
            }
            
            if (a == 1) {
                condicao = jogo.condicaoDeFinal(jogo.verificarLance(x, y));
                
                if (condicao) {
                    jogo.getCampo().revelarTodasAsBombas();
                    exibirCampo(jogo.getCampo());             
                }
            }
            
            jogo.lance(x, y, a);
            
            qntdDeLances++;
        } while (!condicao);
        
        s.close();
        return;
    }
    
    public static void exibirCampo(Campo c){
        System.out.println();
        int tamanho = c.getTamanho();
        Celula[][] tabuleiro = c.getTabuleiro();
        
        for(int i=0; i<tamanho; i++){
            for(int j=0; j<tamanho; j++){
                if (!tabuleiro[i][j].isRevelada()) {
                    if (tabuleiro[i][j].estaMarcada()) {
                        System.out.print("P"); // célual marcada
                    } else {
                        System.out.print("#"); // mina escondida
                    }
                } else {
                    if (!tabuleiro[i][j].temBomba())
                        System.out.print(tabuleiro[i][j].getMinasAdjacentes());
                    else System.out.print("*");
                }

                if (j != tamanho - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

