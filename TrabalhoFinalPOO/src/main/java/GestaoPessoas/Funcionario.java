package GestaoPessoas;

import Autenticacao.Usuario;
import SistemaDaAcademia.GerenciadorDeAgendamentos;
import SistemaDaAcademia.GerenciadorDeAgendamentos.Agendamento;
import json.JsonCliente;
import json.JsonFuncionario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Funcionario extends Usuario {

    private static int contadorIdFuncionario = 0; // Contador para gerar IDs únicos
    private String idFuncionario;
    private String cargo;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;

    /**
     * Classe abstrata que representa uma pessoa no sistema.
     */
    public abstract class Pessoa {

        private String nome;
        private String endereco;
        private String telefone;
        private String email;
        private String cpf;

        /**
         * Construtor para inicializar os atributos de uma pessoa.
         *
         * @param nome Nome da pessoa.
         * @param endereco Endereço da pessoa.
         * @param telefone Telefone da pessoa.
         * @param email Email da pessoa.
         * @param cpf CPF da pessoa.
         */
        public Pessoa(String nome, String endereco, String telefone, String email, String cpf) {
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
            this.email = email;
            this.cpf = cpf;
        }

        public String getNome() {
            return nome;
        }

        public String getEndereco() {
            return endereco;
        }

        public String getTelefone() {
            return telefone;
        }

        public String getEmail() {
            return email;
        }

        public String getCpf() {
            return cpf;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setCPF(String cpf) {
            this.cpf = cpf;
        }

        /**
         * Exibe os dados da pessoa.
         */
        public abstract void exibirDados();

        @Override
        public String toString() {
            return "Nome: " + nome + "\nEndereço: " + endereco + "\nTelefone: " + telefone + "\nEmail: " + email;
        }
    }

    public Funcionario(String usuario, String senha, String nome, String endereco, String telefone, String email, String cpf, String cargo) {
        super(usuario, senha);
        this.idFuncionario = gerarNovoIdFuncionario();
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.cargo = cargo;

        JsonFuncionario.salvarFuncionario(this); // Salva o novo funcionário ao criá-lo
    }

     /**
     * Gera um novo ID único para cada funcionário.
     *
     * @return Novo ID único.
     */
    private static String gerarNovoIdFuncionario() {
        contadorIdFuncionario++;
        return "FUNC-" + contadorIdFuncionario;
    }

    // Getters e setters corrigidos
    public String getIdFuncionario() {
        return idFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
        JsonFuncionario.salvarFuncionario(this); // Salva automaticamente após alterar o cargo
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        JsonFuncionario.salvarFuncionario(this); // Salva automaticamente após alterar o nome
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
        JsonFuncionario.salvarFuncionario(this); // Salva automaticamente após alterar o endereço
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
        JsonFuncionario.salvarFuncionario(this); // Salva automaticamente após alterar o telefone
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        JsonFuncionario.salvarFuncionario(this); // Salva automaticamente após alterar o email
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
        JsonFuncionario.salvarFuncionario(this); // Salva automaticamente após alterar o CPF
    }

    // Método para cancelar uma reserva
    public void cancelarReserva(GerenciadorDeAgendamentos gerenciador, String dataCancelamento, String dataAula, String cpfCliente) {
        Agendamento agendamento = gerenciador.buscarAgendamentoPorDataECpf(dataAula, cpfCliente);
        if (agendamento != null) {
            LocalDate dataCancelamentoLocalDate = LocalDate.parse(dataCancelamento, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate dataAulaLocalDate = LocalDate.parse(dataAula, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            boolean dentroTresDiasUteis = gerenciador.isDentroTresDiasUteis(dataCancelamentoLocalDate, dataAulaLocalDate);
            double valorRetido = dentroTresDiasUteis ? agendamento.getValorAgendamento() * 0.5 : agendamento.getValorAgendamento();
            gerenciador.cancelarAgendamento(agendamento);

            Cliente cliente = buscarCliente(cpfCliente);
            if (cliente != null) {
                cliente.setSaldoDevedor(cliente.getSaldoDevedor() - valorRetido);
                JsonCliente.salvarCliente(cliente); // Salva cliente atualizado
                System.out.println("Cancelamento realizado para o cliente " + cliente.getNome() + ". Valor retido: R$ " + valorRetido + ". Saldo devedor atualizado: R$ " + cliente.getSaldoDevedor());
            } else {
                System.out.println("Erro: Cliente não encontrado. Não foi possível atualizar o saldo.");
            }
        } else {
            System.out.println("Nenhum agendamento encontrado para a data: " + dataAula + " e CPF: " + cpfCliente);
        }
    }

    // Método para buscar cliente pelo CPF usando persistência em JSON
    private Cliente buscarCliente(String cpfCliente) {
        List<Cliente> clientes = JsonCliente.carregarClientes(); // Carrega clientes do arquivo JSON
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpfCliente)) {
                return cliente;
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }
}
