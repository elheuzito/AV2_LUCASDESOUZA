package q2_LucasRangel;

import java.io.*;
import java.util.Scanner;

public class loginSenha {
    private String login;
    private String senha;
    private String caminho = "C:\\Users\\PICHAU\\Desktop\\AV2_POO\\src\\q2_LucasRangel\\database.txt";
    private File arquivo = new File(caminho);

    public void criarConta(Scanner scanner) throws IOException {
        System.out.println("Cadastre o seu usuário:");
        this.login = scanner.nextLine();
        System.out.println("Digite a senha:");
        this.senha = scanner.nextLine();

        try (FileWriter adicionar = new FileWriter(arquivo, true);
             BufferedWriter bufferEscrita = new BufferedWriter(adicionar)) {
            bufferEscrita.write(login + "\n");
            bufferEscrita.write(senha + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar a conta: " + e.getMessage());
        }
    }

    public String fazerLogin(Scanner scanner) {
        System.out.println("Faça o login, digite o usuário:");
        String loginCheck = scanner.nextLine();
        System.out.println("Digite sua senha:");
        String senhaCheck = scanner.nextLine();

        String linha;
        boolean loginEncontrado = false;
        try (FileReader input = new FileReader(caminho);
             BufferedReader reader = new BufferedReader(input)) {
            while ((linha = reader.readLine()) != null) {
                if (linha.equals(loginCheck)) {
                    loginEncontrado = true;
                } else if (loginEncontrado && linha.equals(senhaCheck)) {
                    return "Login efetuado com sucesso";
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao efetuar o login: " + e.getMessage());
        }

        return "Falha ao efetuar o login. Usuário ou senha incorretos.";
    }

    public static void main(String[] args) {
        loginSenha user = new loginSenha();
        Scanner scanner = new Scanner(System.in);

        try {
            user.criarConta(scanner);
            String resultadoLogin = user.fazerLogin(scanner);
            System.out.println(resultadoLogin);
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}