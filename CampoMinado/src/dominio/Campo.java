package dominio;

public class Campo {
    private int escolha;
    private Celula[][] tabuleiro;
    private int tamanho;
    private int qntBombas;
    private int totaldecasas;
    private double percentual;
        
    public Campo(int escolha){
        this.escolha=escolha;

        if(escolha==1){
            tamanho = 5;
            totaldecasas = tamanho*tamanho;
            percentual = 0.10;
            qntBombas = Math.max(1,(int)Math.ceil(totaldecasas*percentual)); 
            //a linha acima exige que o num minimo de bombas seja 1, e arredonda o percentual*qntcasas para cima
            //ex, se essa conta resultar em 0.5, o num de bombas sera = 1.
            //ex2, 49 casas, 12% x 49 = 5.88, arredonda para 6 
        }
        if(escolha==2){
            tamanho = 7;
            totaldecasas = tamanho*tamanho;
            percentual = 0.12;
            qntBombas = Math.max(1,(int)Math.ceil(totaldecasas*percentual)); 
        }
        if(escolha==3){
            tamanho = 8;
            totaldecasas = tamanho*tamanho;
            percentual = 0.14;
            qntBombas = Math.max(1,(int)Math.ceil(totaldecasas*percentual)); 
        }
        if(escolha==4){
            tamanho = 10;
            totaldecasas = tamanho*tamanho;
            percentual = 0.16;
            qntBombas = Math.max(1,(int)Math.ceil(totaldecasas*percentual)); 
        }
    }
    
    public int getTamanho(){
        return tamanho;
    }
    
    public int getQntBombas(){
        return qntBombas;
    }
    
    public int getEscolha(){
        return escolha;
    }
    
    public double getPercentual(){
        return percentual;
    }
    
    public int getTotalDeCasas(){
        return totaldecasas;
    }

    public Celula[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Celula[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    public boolean condicaoDeExistencia(int x, int y) { // é bem auto explicativo
        return x >= 0 && x < tamanho && y >= 0 && y < tamanho;
    }
    
    public void colocarBombas(int x, int y){ // x e y são o quadrado em branco do inicio
        int bombasColocadas = 0;
        while(bombasColocadas < qntBombas){
            int i = (int) (Math.random() * tamanho); 
            int j = (int) (Math.random() * tamanho); 

            //na logica antiga, nao era permitido colocar bombas na linha e coluna do primeiro click, mas logica do jogo nao deve-se colocar bomba apenas na posicao [x][y] do click
            //se m[i][j] == 0 (nao bomba) && NAO for i==x && j==y 
            
            if (!tabuleiro[i][j].temBomba() && (i!=x || j!=y)) {
                tabuleiro[i][j].setBomba(true);
                bombasColocadas++;
            }
        }
    }
    
    /*
    Math.random = 0.0 a 1.0 (aleatoriamente) * tamanho e depois transforma para int
    a linha acima mostra que uma posicao [i][j] esta sendo escolhida aleatoriamente
    se o num sorteado for:
    i =0.5 * 9(ex de tamanho) = 4.5 = 4
    j = 0.3 * 9 = 2.7 = 2
    posicao [4][2]
    */
    
    
    public void exibirCampo(){
        for(int i=0; i<tamanho;i++){
            for(int j=0; j<tamanho; j++){
                System.out.print(tabuleiro[i][j].getMinasAdjacentes() + " ");
            }
            System.out.println();
        }
    }
    
    public void revelarCelulas(){
        System.out.println("Tabuleiro [i][j]: ");
        for(int i=0; i<tamanho; i++){
            for(int j=0; j<tamanho; j++){
                System.out.print("[" + String.format("%02d", i) +"] [" +
                        String.format("%02d", j) + "]");
            }
        }
    } 
    
    /*String format = monta strings formatadas
    String.format("%02d", i) = %d(inteiro / 2=largura minima / 0= preenche com 0 a esquerda
    ex = String.format("%02d", 3);   // "03"
    ex2 = String.format("%02d", 12);  // "12"
    */
    
    public void criarCampo() {
        tabuleiro = new Celula[tamanho][tamanho];
        int cont = 0; // id de cadacelula
        for(int i=0; i<tamanho; i++){
            for(int j=0; j<tamanho; j++){
                tabuleiro[i][j] = new Celula(cont++, false, false, false, 0);
            }
        }
    }
    
    public void calcularNumeros() { //nome melhor: calcularMinasAdjacentes / calcularMinasEmVolta
        for(int i=0; i<tamanho; i++){
            for(int j=0; j<tamanho; j++){
                if (!tabuleiro[i][j].temBomba()) {
                    int numero = 0;
                    // linha superior do lado esquerdo até a linha inferior da coluna mais a direita
                    for (int x = i - 1; x <= i + 1; x++) {
                        for (int y = j - 1; y <= j + 1; y++) {
                            if (condicaoDeExistencia(x, y) // condicao de posicao dentro do tabuleiro
                                && !tabuleiro[x][y].temBomba()) { // se for mina, o numero da celula mapeada em questão aumenta
                                numero++;
                            }
                        }
                    }
                    
                    tabuleiro[i][j].setMinasAdjacentes(numero);
                }
            }
        }
    }
    
    public void abrirEmCascata(int x, int y) {
        //estava aqui
        if (condicaoDeExistencia(x, y)) { //validacao da posicao inicial (garante que x e y existem na matriz)
            Celula c = this.tabuleiro[x][y]; //troquei de lugar, agora so pega-se a posicao atual do tabuleiro, se for uma posicao valida
            
            c.revelar(); //revela a celula atual uma vez
            
            for (int i = x - 1; i <= x + 1; i++) { //percorre os vizinhos (cima, baixo, esquerda, direita e diagonais)
                for (int j = y - 1; j <= y + 1; j++) {
                    
                    if (condicaoDeExistencia(x, y)){ //validando as celulas vizinhas - sempre que i e j estao dentro da matriz/tabuleiro
                        
                        if (!this.tabuleiro[i][j].isRevelada() && !this.tabuleiro[i][j].estaMarcada() //nao foi revelada, nao esta marcada, nao e mina e trem 0 minas adijacentes
                            && !this.tabuleiro[i][j].temBomba() && this.tabuleiro[i][j].getMinasAdjacentes() == 0) {
                            abrirEmCascata(i,j); //chamada recursiva (espalha a abertura, apenas para celulas com num==0, as minas sao bloqueadas)
                        }
                    }
                }
            }
        }
    } 
}

