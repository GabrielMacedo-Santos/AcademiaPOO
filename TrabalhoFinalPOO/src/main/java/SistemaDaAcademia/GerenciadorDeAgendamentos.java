package SistemaDaAcademia;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeAgendamentos {
    // Lista para armazenar os agendamentos
    private List<Agendamento> agendamentos;

    public GerenciadorDeAgendamentos() {
        this.agendamentos = new ArrayList<>();
    }

    // Classe interna para representar um agendamento
    public static class Agendamento {
        String data; // formato yyyy-MM-dd
        double valor;
        String cpfCliente;

        public Agendamento(String data, double valor, String cpfCliente) {
            this.data = data;
            this.valor = valor;
            this.cpfCliente = cpfCliente;
        }

        public String getData() {
            return data;
        }

        public double getValorAgendamento() {
            return valor;
        }

        public String getCpfCliente() {
            return cpfCliente;
        }

        @Override
        public String toString() {
            return "Data: " + data + ", Valor: R$ " + valor + ", CPF do Cliente: " + cpfCliente;
        }
    }

    // Método para adicionar um agendamento
    public void adicionarAgendamento(String data, double valor, String cpfCliente) {
        Agendamento agendamento = new Agendamento(data, valor, cpfCliente);
        agendamentos.add(agendamento);
        System.out.println("Agendamento em " + data + " no valor de R$ " + valor + " para o cliente " + cpfCliente + " adicionado.");
    }

    // Método para listar todos os agendamentos
    public void listarAgendamentos() {
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento registrado.");
        } else {
            System.out.println("Lista de Agendamentos:");
            for (Agendamento agendamento : agendamentos) {
                System.out.println(agendamento);
            }
        }
    }

    // Método para buscar um agendamento específico por data e CPF do cliente
    public Agendamento buscarAgendamentoPorDataECpf(String data, String cpfCliente) {
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getData().equals(data) && agendamento.getCpfCliente().equals(cpfCliente)) {
                return agendamento;
            }
        }
        return null;
    }

    // Método para cancelar um agendamento
    public boolean cancelarAgendamento(Agendamento agendamento) {
        if (agendamentos.remove(agendamento)) {
            System.out.println("Agendamento cancelado com sucesso.");
            return true;
        } else {
            System.out.println("Erro ao cancelar o agendamento. Agendamento não encontrado.");
            return false;
        }
    }

    // Método para verificar se o cancelamento está dentro de três dias úteis da data do agendamento
    public boolean isDentroTresDiasUteis(LocalDate dataCancelamento, LocalDate dataAgendamento) {
        long diferencaDias = ChronoUnit.DAYS.between(dataCancelamento, dataAgendamento);
        return diferencaDias <= 3 && diferencaDias >= 0;
    }

    // Método de gerenciamento de agendamentos
    public void gerenciarAgendamentos(Scanner scanner) {
        System.out.println("\n=== Gerenciamento de Agendamentos ===");
        System.out.println("1. Adicionar Agendamento");
        System.out.println("2. Listar Agendamentos");
        System.out.println("3. Cancelar Agendamento");
        System.out.print("Escolha uma opção: ");

        int opcao = -1;

        try {
            opcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida. Por favor, insira um número.");
            return; // Retorna ao menu principal se a opção não for um número
        }

        switch (opcao) {
            case 1:
                try {
                    System.out.print("Digite a data do agendamento (yyyy-MM-dd): ");
                    String data = scanner.nextLine();
                    LocalDate.parse(data); // Valida se a data está no formato correto

                    System.out.print("Digite o valor do agendamento: ");
                    double valor = Double.parseDouble(scanner.nextLine());

                    System.out.print("Digite o CPF do Cliente: ");
                    String cpfCliente = scanner.nextLine();

                    adicionarAgendamento(data, valor, cpfCliente);
                } catch (Exception e) {
                    System.out.println("Erro ao adicionar agendamento. Verifique as informações inseridas.");
                }
                break;
            case 2:
                listarAgendamentos();
                break;
            case 3:
                System.out.print("Digite a data do agendamento (yyyy-MM-dd) que deseja cancelar: ");
                String dataCancelamento = scanner.nextLine();
                System.out.print("Digite o CPF do Cliente: ");
                String cpfClienteCancelamento = scanner.nextLine();

                Agendamento agendamento = buscarAgendamentoPorDataECpf(dataCancelamento, cpfClienteCancelamento);
                if (agendamento != null) {
                    cancelarAgendamento(agendamento);
                } else {
                    System.out.println("Nenhum agendamento encontrado com a data e CPF fornecidos.");
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
