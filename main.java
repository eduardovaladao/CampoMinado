package dominio;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static Scanner s = new Scanner(System.in);
    static ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
    public static void main(String args[]){
        
        
        int escolha = 0;
        String nome, senha;
        System.out.println("--- BEM VINDO AO CAMPO MINADO ---");
        do{
            System.out.println("------------------");
            System.out.println("Escolha:");
            System.out.println("1- Criar novo usuario");
            System.out.println("2- Fazer login");
            System.out.println("3- Sair do programa");
            System.out.println("------------------");
            
            try{
                escolha  = Integer.parseInt(s.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Digite uma opcao valida!");
                continue; //verificar!
            }
            
            switch(escolha){
                case 1:
                    cadastrarUsuario();
                    return;
                case 2:
                    try{
                        Jogador jogadorLogado = realizarLogin();
                        menuUsuario(jogadorLogado);
                    } catch (Exception e){
                        System.out.println("Falha no login!" + e.getMessage());
                    }
                    return;
                case 3:
                    System.out.println("Encerrando programa...");
                    return;
                default:
                    System.out.println("Opcao invalida!");
            }
        }while(escolha!=3);
    }
    
    public static void cadastrarUsuario(){
        
        System.out.println("--- Cadastro ---");
        System.out.print("Digite o nome: ");
        String nome = s.nextLine();
        
        System.out.print("Digite uma senha: ");
        String senha = s.nextLine();
        
        if(nomeDisponivel(nome) == false){
            jogadores.add(new Jogador(nome, senha)); //adiciona na lista de jogadores
            System.out.println("Jogador criado!");   
        }    
    }
    
    public static Jogador realizarLogin() throws Exception{
        System.out.println("------------------");
        System.out.println("--- Login ---");
        System.out.print("Usuario: ");
        String nome = s.nextLine();
        System.out.print("Senha: ");
        String senha = s.nextLine();
        
        for(Jogador j : jogadores){
            if(j.getApelido().equals(nome)){ //se achar o nome na lista
                if(j.verificaSenha(senha)){ //se a senha bater
                    return j; //retorna o objeto
                }
                else{
                    throw new Exception ("Senha incorreta!"); //se a senha nao bater
                }
            }
        }
        throw new Exception ("Usuario nao encontrado!");
    }
    
    public static boolean nomeDisponivel(String nome){ //verificar se o jogador existe ou nao
        for(Jogador j : jogadores)
            if(j.getApelido().equals(nome)) 
                return false;//encontrou, nome nao disponivel
        
        return true;  //se nao achou na lista, nome disponivel
    }
    
    public static void menuUsuario(Jogador j){
        System.out.println("--------------------");
        System.out.println("Seja bem vindo, " + j.getApelido().toUpperCase() + "!");
        System.out.println("--------------------");
    }

}

