package SistemaDaAcademia;

import GestaoPessoas.Administrador;
import GestaoPessoas.Cliente;
import GestaoPessoas.Funcionario;
import Loja.GerenciarVenda;
import Loja.Produto;
import Loja.LanchoneteEstoque;  // Importando conforme o tipo correto para Estoque
import SistemaDaAcademia.Catraca;
import SistemaDaAcademia.BalancoFinanceiro;
import SistemaDaAcademia.GerenciadorDeAgendamentos;
import json.JsonCliente; // Importa para uso com clientes
import java.util.Scanner;

public class Academia {

    private Scanner scanner;
    private Administrador administrador;
    private GerenciadorDeAgendamentos gerenciadorDeAgendamentos;
    private Catraca catraca;
    private BalancoFinanceiro balancoFinanceiro;
    private GerenciarVenda gerenciarVenda;

    public Academia() {
        this.scanner = new Scanner(System.in);
        this.administrador = new Administrador("admin", "senha123", "Administrador Geral", "Rua A, 123", "9999-9999", "admin@academia.com", "123.456.789-00");
        this.gerenciadorDeAgendamentos = new GerenciadorDeAgendamentos();
        this.catraca = new Catraca();
        this.balancoFinanceiro = new BalancoFinanceiro();
        this.gerenciarVenda = new GerenciarVenda(new LanchoneteEstoque()); // LanchoneteEstoque extendendo Estoque
    }

    public void iniciarSistema() {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = lerOpcaoMenu();
            executarOpcao(opcao);
        } while (opcao != 0);
        System.out.println("Sistema encerrado.");
    }

    private void exibirMenuPrincipal() {
        System.out.println("\n=== Sistema de Gerenciamento da Academia ===");
        System.out.println("1. Gerenciar Funcionários");
        System.out.println("2. Gerenciar Agendamentos");
        System.out.println("3. Gerenciar Clientes");
        System.out.println("4. Gerenciar Vendas");
        System.out.println("5. Gerenciar Catraca");
        System.out.println("6. Gerenciar Balanço Financeiro");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private int lerOpcaoMenu() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
            return -1;
        }
    }

    private void executarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> gerenciarFuncionarios();
            case 2 -> gerenciarAgendamentos();
            case 3 -> gerenciarClientes();
            case 4 -> gerenciarVendas();
            case 5 -> gerenciarCatraca();
            case 6 -> gerenciarBalancoFinanceiro();
            case 0 -> System.out.println("Saindo do sistema...");
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }

    // Métodos para cada funcionalidade
    private void gerenciarFuncionarios() {
        int opcao;
        do {
            System.out.println("\n=== Gerenciamento de Funcionários ===");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Editar Funcionário");
            System.out.println("3. Remover Funcionário");
            System.out.println("4. Listar Funcionários");
            System.out.println("0. Voltar");
            opcao = lerOpcaoMenu();

            switch (opcao) {
                case 1 -> adicionarFuncionario();
                case 2 -> editarFuncionario();
                case 3 -> removerFuncionario();
                case 4 -> administrador.listarFuncionarios();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarFuncionario() {
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

    private void editarFuncionario() {
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

    private void removerFuncionario() {
        System.out.print("ID do Funcionário a ser removido: ");
        String idFuncionario = scanner.nextLine();
        administrador.removerFuncionario(idFuncionario);
    }

    private void gerenciarAgendamentos() {
        gerenciadorDeAgendamentos.gerenciarAgendamentos(scanner);
    }

    private void gerenciarClientes() {
        System.out.println("\n=== Gerenciamento de Clientes ===");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Remover Cliente");
        System.out.println("3. Listar Clientes");
        System.out.print("Escolha uma opção: ");

        int opcao = lerOpcaoMenu();
        switch (opcao) {
            case 1 -> adicionarCliente();
            case 2 -> removerCliente();
            case 3 -> listarClientes();
            default -> System.out.println("Opção inválida.");
        }
    }

    private void adicionarCliente() {
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
        System.out.print("Plano: ");
        String plano = scanner.nextLine();

        Cliente novoCliente = new Cliente(nome, endereco, telefone, email, cpf, plano);
        JsonCliente.salvarCliente(novoCliente); // Salvando cliente no JSON
    }

    private void removerCliente() {
        System.out.print("CPF do Cliente a ser removido: ");
        String cpf = scanner.nextLine();
        JsonCliente.removerCliente(cpf); // Remoção usando JSON
    }

    private void listarClientes() {
        JsonCliente.carregarClientes().forEach(cliente -> System.out.println(cliente));
    }

    private void gerenciarVendas() {
        System.out.println("\n=== Gerenciamento de Vendas ===");
        gerenciarVenda.listarVendas();
    }

    private void gerenciarCatraca() {
        catraca.gerenciarCatraca(scanner);
    }

    private void gerenciarBalancoFinanceiro() {
        balancoFinanceiro.gerenciarBalanco(scanner);
    }

    public static void main(String[] args) {
        new Academia().iniciarSistema();
    }
}
