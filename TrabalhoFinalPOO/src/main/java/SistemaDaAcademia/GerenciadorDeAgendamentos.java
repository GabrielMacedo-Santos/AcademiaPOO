package SistemaDaAcademia;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pelo gerenciamento de agendamentos.
 * Permite adicionar, listar, buscar e cancelar agendamentos.
 */
public class GerenciadorDeAgendamentos {
    
    // Lista para armazenar os agendamentos
    private List<Agendamento> agendamentos;

    /**
     * Construtor da classe GerenciadorDeAgendamentos.
     * Inicializa a lista de agendamentos.
     */
    public GerenciadorDeAgendamentos() {
        this.agendamentos = new ArrayList<>();
    }

    /**
     * Classe interna para representar um agendamento.
     * Um agendamento possui uma data, um valor e o CPF do cliente.
     */
    public static class Agendamento {
        String data; // formato yyyy-MM-dd
        double valor;
        String cpfCliente;

        /**
         * Construtor da classe Agendamento.
         * 
         * @param data A data do agendamento no formato yyyy-MM-dd.
         * @param valor O valor do agendamento.
         * @param cpfCliente O CPF do cliente que fez o agendamento.
         */
        public Agendamento(String data, double valor, String cpfCliente) {
            this.data = data;
            this.valor = valor;
            this.cpfCliente = cpfCliente;
        }

        /**
         * Obtém a data do agendamento.
         * 
         * @return A data do agendamento.
         */
        public String getData() {
            return data;
        }

        /**
         * Obtém o valor do agendamento.
         * 
         * @return O valor do agendamento.
         */
        public double getValorAgendamento() {
            return valor;
        }

        /**
         * Obtém o CPF do cliente.
         * 
         * @return O CPF do cliente.
         */
        public String getCpfCliente() {
            return cpfCliente;
        }

        /**
         * Retorna uma representação em String do agendamento.
         * 
         * @return Uma string com os detalhes do agendamento.
         */
        @Override
        public String toString() {
            return "Data: " + data + ", Valor: R$ " + valor + ", CPF do Cliente: " + cpfCliente;
        }
    }

    /**
     * Adiciona um agendamento à lista de agendamentos.
     * 
     * @param data A data do agendamento no formato yyyy-MM-dd.
     * @param valor O valor do agendamento.
     * @param cpfCliente O CPF do cliente que fez o agendamento.
     */
    public void adicionarAgendamento(String data, double valor, String cpfCliente) {
        Agendamento agendamento = new Agendamento(data, valor, cpfCliente);
        agendamentos.add(agendamento);
        System.out.println("Agendamento em " + data + " no valor de R$ " + valor + " para o cliente " + cpfCliente + " adicionado.");
    }

    /**
     * Lista todos os agendamentos registrados.
     * Caso não existam agendamentos, exibe uma mensagem informando isso.
     */
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

    /**
     * Busca um agendamento específico pelo CPF do cliente e pela data do agendamento.
     * 
     * @param data A data do agendamento no formato yyyy-MM-dd.
     * @param cpfCliente O CPF do cliente.
     * @return O agendamento correspondente ou null caso não seja encontrado.
     */
    public Agendamento buscarAgendamentoPorDataECpf(String data, String cpfCliente) {
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getData().equals(data) && agendamento.getCpfCliente().equals(cpfCliente)) {
                return agendamento;
            }
        }
        return null;
    }

    /**
     * Cancela um agendamento.
     * 
     * @param agendamento O agendamento a ser cancelado.
     * @return true se o agendamento foi cancelado com sucesso, false caso contrário.
     */
    public boolean cancelarAgendamento(Agendamento agendamento) {
        if (agendamentos.remove(agendamento)) {
            System.out.println("Agendamento cancelado com sucesso.");
            return true;
        } else {
            System.out.println("Erro ao cancelar o agendamento. Agendamento não encontrado.");
            return false;
        }
    }

    /**
     * Verifica se o cancelamento está dentro de três dias úteis da data do agendamento.
     * 
     * @param dataCancelamento A data do cancelamento.
     * @param dataAgendamento A data do agendamento.
     * @return true se o cancelamento estiver dentro de três dias úteis, false caso contrário.
     */
    public boolean isDentroTresDiasUteis(LocalDate dataCancelamento, LocalDate dataAgendamento) {
        long diferencaDias = ChronoUnit.DAYS.between(dataCancelamento, dataAgendamento);
        return diferencaDias <= 3 && diferencaDias >= 0;
    }

    /**
     * Método de gerenciamento de agendamentos. Exibe um menu de opções para o usuário,
     * permitindo adicionar, listar, ou cancelar agendamentos.
     * 
     * @param scanner O objeto Scanner utilizado para ler a entrada do usuário.
     */
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
