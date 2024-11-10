package SistemaDaAcademia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pelo gerenciamento do balanço financeiro, contendo receitas e despesas.
 */
public class BalancoFinanceiro {
    private List<String> receitas; // Lista de receitas
    private List<String> despesas; // Lista de despesas

    /**
     * Construtor que inicializa as listas de receitas e despesas.
     */
    public BalancoFinanceiro() {
        this.receitas = new ArrayList<>();
        this.despesas = new ArrayList<>();
    }

    /**
     * Adiciona uma receita ao balanço financeiro.
     *
     * @param valor Valor da receita
     * @param descricao Descrição da receita
     */
    public void adicionarReceita(double valor, String descricao) {
        String receita = "Receita - Descrição: " + descricao + ", Valor: " + valor;
        receitas.add(receita);
        System.out.println("Receita adicionada: " + descricao + " - Valor: R$ " + valor);
    }

    /**
     * Adiciona uma despesa ao balanço financeiro.
     *
     * @param valor Valor da despesa
     * @param descricao Descrição da despesa
     */
    public void adicionarDespesa(double valor, String descricao) {
        String despesa = "Despesa - Descrição: " + descricao + ", Valor: " + valor;
        despesas.add(despesa);
        System.out.println("Despesa adicionada: " + descricao + " - Valor: R$ " + valor);
    }

    /**
     * Gera o balanço mensal, somando as receitas e despesas e exibindo o saldo.
     */
    public void gerarBalancoMensal() {
        double totalReceitas = receitas.stream()
                                       .mapToDouble(r -> Double.parseDouble(r.split(", Valor: ")[1]))
                                       .sum();
        double totalDespesas = despesas.stream()
                                       .mapToDouble(d -> Double.parseDouble(d.split(", Valor: ")[1]))
                                       .sum();
        double saldo = totalReceitas - totalDespesas;

        System.out.println("Balanço Mensal Gerado:");
        System.out.println("Total de Receitas: R$ " + totalReceitas);
        System.out.println("Total de Despesas: R$ " + totalDespesas);
        System.out.println("Saldo: R$ " + saldo);
    }

    /**
     * Gerencia o balanço financeiro através de um menu interativo.
     *
     * @param scanner Objeto Scanner para entrada de dados do usuário
     */
    public void gerenciarBalanco(Scanner scanner) {
        System.out.println("\n=== Gerenciamento do Balanço Financeiro ===");
        System.out.println("1. Adicionar Receita");
        System.out.println("2. Adicionar Despesa");
        System.out.println("3. Gerar Balanço Mensal");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        switch (opcao) {
            case 1:
                System.out.print("Descrição da Receita: ");
                String descricaoReceita = scanner.nextLine();
                System.out.print("Valor da Receita: ");
                double valorReceita = scanner.nextDouble();
                adicionarReceita(valorReceita, descricaoReceita);
                break;
            case 2:
                System.out.print("Descrição da Despesa: ");
                String descricaoDespesa = scanner.nextLine();
                System.out.print("Valor da Despesa: ");
                double valorDespesa = scanner.nextDouble();
                adicionarDespesa(valorDespesa, descricaoDespesa);
                break;
            case 3:
                gerarBalancoMensal();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
