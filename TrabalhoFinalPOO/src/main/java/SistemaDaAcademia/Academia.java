package SistemaDaAcademia;

import GestaoPessoas.Administrador;
import GestaoPessoas.Funcionario;
import SistemaDaAcademia.GerenciadorDeAgendamentos;
import java.util.Scanner;

public class Academia {

    private static Scanner scanner = new Scanner(System.in);
    private static Administrador administrador;
    private static GerenciadorDeAgendamentos gerenciadorDeAgendamentos = new GerenciadorDeAgendamentos();

    public static void main(String[] args) {
        // Inicialização de um administrador padrão para testar as funcionalidades
        administrador = new Administrador("admin", "senha123", "Administrador Geral", "Rua A, 123", "9999-9999", "admin@academia.com", "123.456.789-00");

        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcaoMenu();
            executarOpcao(opcao);
        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
    }

    private static void exibirMenu() {
        System.out.println("\n=== Sistema de Gerenciamento da Academia ===");
        System.out.println("1. Adicionar Funcionário");
        System.out.println("2. Editar Funcionário");
        System.out.println("3. Remover Funcionário");
        System.out.println("4. Listar Funcionários");
        System.out.println("5. Gerenciar Agendamentos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcaoMenu() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
            return -1;
        }
    }

    private static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarFuncionario();
                break;
            case 2:
                editarFuncionario();
                break;
            case 3:
                removerFuncionario();
                break;
            case 4:
                listarFuncionarios();
                break;
            case 5:
                gerenciarAgendamentos();
                break;
            case 0:
                System.out.println("Saindo do sistema...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void adicionarFuncionario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        Funcionario novoFuncionario = new Funcionario("usuario" + nome, "senha123", nome, endereco, telefone, email, cpf, cargo);
        administrador.adicionarFuncionario(novoFuncionario);
    }

    private static void editarFuncionario() {
        System.out.print("ID do Funcionário a ser editado: ");
        String idFuncionario = scanner.nextLine();

        System.out.print("Novo Nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo Endereço: ");
        String novoEndereco = scanner.nextLine();
        System.out.print("Novo Telefone: ");
        String novoTelefone = scanner.nextLine();
        System.out.print("Novo Email: ");
        String novoEmail = scanner.nextLine();
        System.out.print("Novo Cargo: ");
        String novoCargo = scanner.nextLine();

        administrador.editarFuncionario(idFuncionario, novoNome, novoEndereco, novoTelefone, novoEmail, novoCargo);
    }

    private static void removerFuncionario() {
        System.out.print("ID do Funcionário a ser removido: ");
        String idFuncionario = scanner.nextLine();
        administrador.removerFuncionario(idFuncionario);
    }

    private static void listarFuncionarios() {
        administrador.listarFuncionarios();
    }

    private static void gerenciarAgendamentos() {
        gerenciadorDeAgendamentos.gerenciarAgendamentos(scanner);
    }
}
