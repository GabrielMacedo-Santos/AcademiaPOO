package SistemaDaAcademia;

import GestaoPessoas.Administrador;
import GestaoPessoas.Cliente;
import Loja.GerenciarVenda;
import Loja.LanchoneteEstoque;
import Loja.Produto;
import json.JsonCliente;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import GestaoPessoas.ClienteComparatorNome;
import GestaoPessoas.Funcionario;

/**
 * Classe que representa o sistema da Academia, com funcionalidades para 
 * gerenciar funcionários, agendamentos, clientes, vendas, estoque, catraca
 * e balanço financeiro. Essa classe foi transformada em Singleton, garantindo
 * que haja apenas uma instância da classe em toda a aplicação.
 */
public class Academia {

    private static Academia instancia;  // Instância única da classe
    private Scanner scanner;
    private Administrador administrador;
    private GerenciadorDeAgendamentos gerenciadorDeAgendamentos;
    private Catraca catraca;
    private BalancoFinanceiro balancoFinanceiro;
    private GerenciarVenda gerenciarVenda;

    /**
     * Construtor da classe Academia.
     * O construtor é privado para evitar a criação de instâncias diretamente.
     */
    private Academia() {
        this.scanner = new Scanner(System.in);
        this.administrador = new Administrador("admin", "senha123", "Administrador Geral", "Rua A, 123", "9999-9999", "admin@academia.com", "123.456.789-00");
        this.gerenciadorDeAgendamentos = new GerenciadorDeAgendamentos();
        this.catraca = new Catraca();
        this.balancoFinanceiro = new BalancoFinanceiro();
        this.gerenciarVenda = new GerenciarVenda(new LanchoneteEstoque());
    }

    /**
     * Método público que retorna a instância única da classe Academia.
     * Se a instância ainda não foi criada, ela será criada neste método.
     *
     * @return A instância única de Academia.
     */
    public static Academia getInstancia() {
        if (instancia == null) {
            instancia = new Academia();
        }
        return instancia;
    }

    /**
     * Inicia o sistema e exibe o menu principal.
     */
    public void iniciarSistema() {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = lerOpcaoMenu();
            executarOpcao(opcao);
        } while (opcao != 0);
        System.out.println("Sistema encerrado.");
    }

    /**
     * Exibe o menu principal para o usuário escolher a opção desejada.
     */
    private void exibirMenuPrincipal() {
        System.out.println("\n=== Sistema de Gerenciamento da Academia ===");
        System.out.println("1. Gerenciar Funcionários");
        System.out.println("2. Gerenciar Agendamentos");
        System.out.println("3. Gerenciar Clientes");
        System.out.println("4. Gerenciar Vendas e Estoque");
        System.out.println("5. Gerenciar Catraca");
        System.out.println("6. Gerenciar Balanço Financeiro");
        System.out.println("7. Testes para Questões 15-17");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    /**
     * Lê a opção escolhida pelo usuário no menu.
     *
     * @return A opção escolhida pelo usuário.
     */
    private int lerOpcaoMenu() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer após a leitura do número
            return opcao;
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
            scanner.nextLine(); // Limpa o buffer caso haja erro de leitura
            return -1;
        }
    }

    /**
     * Executa a ação correspondente à opção escolhida pelo usuário.
     *
     * @param opcao A opção escolhida pelo usuário.
     */
    private void executarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> gerenciarFuncionarios();
            case 2 -> gerenciarAgendamentos();
            case 3 -> gerenciarClientes();
            case 4 -> gerenciarVendas();
            case 5 -> gerenciarCatraca();
            case 6 -> gerenciarBalancoFinanceiro();
            case 7 -> executarTestes();
            case 0 -> System.out.println("Saindo do sistema...");
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }

    // Métodos de gerenciamento de funcionários

    /**
     * Exibe o menu de gerenciamento de funcionários e executa as ações correspondentes.
     */
    private void gerenciarFuncionarios() {
        int opcao;
        do {
            System.out.println("\n=== Gerenciamento de Funcionários ===");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Editar Funcionário");
            System.out.println("3. Remover Funcionário");
            System.out.println("4. Listar Funcionários");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
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

    /**
     * Adiciona um novo funcionário.
     */
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

    /**
     * Edita um funcionário existente.
     */
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

    /**
     * Remove um funcionário.
     */
    private void removerFuncionario() {
        System.out.print("ID do Funcionário a ser removido: ");
        String idFuncionario = scanner.nextLine();
        administrador.removerFuncionario(idFuncionario);
    }

    // Métodos de gerenciamento de clientes

    /**
     * Exibe o menu de gerenciamento de clientes e executa as ações correspondentes.
     */
    private void gerenciarClientes() {
        int opcao;
        do {
            System.out.println("\n=== Gerenciamento de Clientes ===");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Remover Cliente");
            System.out.println("3. Listar Clientes");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = lerOpcaoMenu();

            switch (opcao) {
                case 1 -> adicionarCliente();
                case 2 -> removerCliente();
                case 3 -> listarClientes();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    /**
     * Adiciona um novo cliente.
     */
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
        JsonCliente.salvarCliente(novoCliente);
    }

    /**
     * Remove um cliente.
     */
    private void removerCliente() {
        System.out.print("CPF do Cliente a ser removido: ");
        String cpf = scanner.nextLine();
        JsonCliente.removerCliente(cpf);
    }

    /**
     * Lista todos os clientes cadastrados.
     */
    private void listarClientes() {
        JsonCliente.carregarClientes().forEach(cliente -> System.out.println(cliente));
    }

    // Métodos de gerenciamento de agendamentos, catraca e balanço financeiro

    /**
     * Gerencia os agendamentos de aulas ou atividades.
     */
    private void gerenciarAgendamentos() {
        gerenciadorDeAgendamentos.gerenciarAgendamentos(scanner);
    }

    /**
     * Gerencia a catraca de acesso à academia.
     */
    private void gerenciarCatraca() {
        catraca.gerenciarCatraca(scanner);
    }

    /**
     * Gerencia o balanço financeiro da academia.
     */
    private void gerenciarBalancoFinanceiro() {
        balancoFinanceiro.gerenciarBalanco(scanner);
    }

    // Métodos de gerenciamento de vendas e estoque

    /**
     * Exibe o menu de gerenciamento de vendas e estoque e executa as ações correspondentes.
     */
    private void gerenciarVendas() {
        int opcao;
        do {
            System.out.println("\n=== Gerenciamento de Vendas e Estoque ===");
            System.out.println("1. Realizar Venda");
            System.out.println("2. Listar Vendas");
            System.out.println("3. Adicionar Produto ao Estoque");
            System.out.println("4. Remover Produto do Estoque");
            System.out.println("5. Listar Produtos no Estoque");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = lerOpcaoMenu();

            switch (opcao) {
                case 1 -> realizarVenda();
                case 2 -> listarVendas();
                case 3 -> adicionarProdutoAoEstoque();
                case 4 -> removerProdutoDoEstoque();
                case 5 -> listarProdutosNoEstoque();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    /**
     * Realiza uma venda de produto.
     */
    private void realizarVenda() {
        System.out.print("Nome do Produto: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = Integer.parseInt(scanner.nextLine());
        gerenciarVenda.realizarVenda(nomeProduto, quantidade);
    }

    /**
     * Lista todas as vendas realizadas.
     */
    private void listarVendas() {
        gerenciarVenda.listarVendas();
    }

    /**
     * Adiciona um produto ao estoque.
     */
    private void adicionarProdutoAoEstoque() {
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço do Produto: ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Quantidade: ");
        int quantidade = Integer.parseInt(scanner.nextLine());

        Produto produto = new Produto(nome, preco, quantidade);
        gerenciarVenda.getEstoque().adicionarProduto(produto);
    }

    /**
     * Remove um produto do estoque.
     */
    private void removerProdutoDoEstoque() {
        System.out.print("Nome do Produto a ser removido: ");
        String nomeProduto = scanner.nextLine();
        gerenciarVenda.getEstoque().removerProduto(nomeProduto);
    }

    /**
     * Lista todos os produtos no estoque.
     */
    private void listarProdutosNoEstoque() {
        gerenciarVenda.getEstoque().listarProdutos();
    }

    // Métodos para testes das questões 15-17

    /**
     * Exibe o menu de testes para as questões 15-17 e executa as ações correspondentes.
     */
    private void executarTestes() {
        System.out.println("\n=== Testes para Questões 15-17 ===");
        System.out.println("1. Testar Iterator e foreach (Questão 15)");
        System.out.println("2. Testar Comparator e Collections.sort (Questão 16)");
        System.out.println("3. Testar método find e binarySearch (Questão 17)");
        System.out.print("Escolha uma opção: ");
        int opcao = lerOpcaoMenu();

        switch (opcao) {
            case 1 -> testarIteratorEForeach();
            case 2 -> testarComparatorESort();
            case 3 -> testarFindEBinarySearch();
            default -> System.out.println("Opção inválida.");
        }
    }

    /**
     * Testa o uso de Iterator e foreach para percorrer a lista de clientes.
     */
    private void testarIteratorEForeach() {
        System.out.println("\n=== Teste do Iterator e foreach ===");

        List<Cliente> clientes = JsonCliente.carregarClientes();
        if (clientes == null || clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado para teste.");
            return;
        }

        Iterator<Cliente> iterator = clientes.iterator();
        System.out.println("Percorrendo clientes com Iterator:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Percorrendo clientes com foreach:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    /**
     * Testa o uso de Comparator e Collections.sort para ordenar a lista de clientes.
     */
    private void testarComparatorESort() {
        System.out.println("\n=== Teste do Comparator e Collections.sort ===");

        List<Cliente> clientes = JsonCliente.carregarClientes();
        if (clientes == null || clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado para teste.");
            return;
        }

        System.out.println("Ordenando clientes por nome:");
        Collections.sort(clientes, new ClienteComparatorNome());
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    /**
     * Testa o uso do método find e binarySearch para encontrar um cliente na lista.
     */
    private void testarFindEBinarySearch() {
        System.out.println("\n=== Teste do método find e binarySearch ===");

        List<Cliente> clientes = JsonCliente.carregarClientes();
        if (clientes == null || clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado para teste.");
            return;
        }

        Cliente clienteProcurado = clientes.get(0);

        Cliente clienteEncontrado = findCliente(clientes, clienteProcurado);
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado com método find: " + clienteEncontrado);
        } else {
            System.out.println("Cliente não encontrado com método find.");
        }

        int index = Collections.binarySearch(clientes, clienteProcurado, new ClienteComparatorNome());
        if (index >= 0) {
            System.out.println("Cliente encontrado com binarySearch: " + clientes.get(index));
        } else {
            System.out.println("Cliente não encontrado com binarySearch.");
        }
    }

    /**
     * Método auxiliar para encontrar um cliente na lista usando um loop.
     *
     * @param clientes Lista de clientes a ser percorrida.
     * @param clienteProcurado Cliente a ser encontrado.
     * @return O cliente encontrado ou null caso não seja encontrado.
     */
    private Cliente findCliente(List<Cliente> clientes, Cliente clienteProcurado) {
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (new ClienteComparatorNome().compare(cliente, clienteProcurado) == 0) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Método principal que inicializa o sistema da academia.
     */
    public static void main(String[] args) {
        Academia.getInstancia().iniciarSistema();
    }
}
