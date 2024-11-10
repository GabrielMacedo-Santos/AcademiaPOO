package SistemaDaAcademia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pelo controle de entradas e saídas de clientes na catraca da academia.
 */
public class Catraca {
    private List<String> registros; // Lista para armazenar registros de entrada e saída

    /**
     * Construtor que inicializa a lista de registros.
     */
    public Catraca() {
        this.registros = new ArrayList<>();
    }

    /**
     * Registra a entrada de um cliente.
     *
     * @param idCliente ID do cliente que está entrando
     */
    public void registrarEntrada(int idCliente) {
        String registro = "Entrada - ID do Cliente: " + idCliente;
        registros.add(registro);
        System.out.println("Entrada registrada para o cliente com ID: " + idCliente);
    }

    /**
     * Registra a saída de um cliente.
     *
     * @param idCliente ID do cliente que está saindo
     */
    public void registrarSaida(int idCliente) {
        String registro = "Saída - ID do Cliente: " + idCliente;
        registros.add(registro);
        System.out.println("Saída registrada para o cliente com ID: " + idCliente);
    }

    /**
     * Exibe todos os registros de entradas e saídas.
     */
    public void exibirRegistros() {
        if (registros.isEmpty()) {
            System.out.println("Nenhum registro encontrado.");
        } else {
            System.out.println("Registros de Entradas e Saídas:");
            for (String registro : registros) {
                System.out.println(registro);
            }
        }
    }

    /**
     * Gerencia as entradas e saídas de clientes através de um menu interativo.
     *
     * @param scanner Objeto Scanner para entrada de dados do usuário
     */
    public void gerenciarCatraca(Scanner scanner) {
        System.out.println("\n=== Gerenciamento de Entradas e Saídas ===");
        System.out.println("1. Registrar Entrada");
        System.out.println("2. Registrar Saída");
        System.out.println("3. Exibir Registros");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        switch (opcao) {
            case 1:
                System.out.print("ID do Cliente: ");
                int idEntrada = scanner.nextInt();
                registrarEntrada(idEntrada);
                break;
            case 2:
                System.out.print("ID do Cliente: ");
                int idSaida = scanner.nextInt();
                registrarSaida(idSaida);
                break;
            case 3:
                exibirRegistros();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
