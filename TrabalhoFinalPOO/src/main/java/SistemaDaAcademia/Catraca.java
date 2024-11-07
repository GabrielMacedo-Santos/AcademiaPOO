package SistemaDaAcademia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catraca {
    private List<String> registros; // Lista para armazenar registros de entrada e saída

    public Catraca() {
        this.registros = new ArrayList<>();
    }

    // Método para registrar a entrada de um cliente
    public void registrarEntrada(int idCliente) {
        String registro = "Entrada - ID do Cliente: " + idCliente;
        registros.add(registro);
        System.out.println("Entrada registrada para o cliente com ID: " + idCliente);
    }

    // Método para registrar a saída de um cliente
    public void registrarSaida(int idCliente) {
        String registro = "Saída - ID do Cliente: " + idCliente;
        registros.add(registro);
        System.out.println("Saída registrada para o cliente com ID: " + idCliente);
    }

    // Método para exibir todos os registros de entrada e saída
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

    // Método de gerenciamento de entradas e saídas
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
