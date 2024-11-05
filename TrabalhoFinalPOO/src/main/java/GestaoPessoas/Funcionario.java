package GestaoPessoas;

import Loja.Produto;
import SistemaDaAcademia.GerenciadorDeAgendamentos;
import java.util.ArrayList;
import java.util.Calendar;
import Academia.Agenda;
import SistemaDaAcademia.GerenciamentoCliente;
import java.util.List;
import json.JsonFuncionario;

public class Funcionario extends Pessoa implements GerenciamentoCliente {

    private String idFuncionario;
    private String cargo;
    private int id;
    private List<Cliente> clientes;

    public Funcionario(String nome, String endereco, String telefone, String email, String cpf, String idFuncionario, String cargo) {
        super(nome, endereco, telefone, email, cpf);
        this.idFuncionario = idFuncionario;
        this.cargo = cargo;
        this.id = gerarNovoIdFuncionario();
        this.clientes = new ArrayList<>();
    }

    private static int gerarNovoIdFuncionario() {
        List<Funcionario> funcionarios = JsonFuncionario.carregar();
        if (funcionarios.isEmpty()) {
            return 1;
        } else {
            int lastId = funcionarios.get(funcionarios.size() - 1).id;
            return lastId + 1;
        }
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void verificarEstoqueProduto(Produto produto) {
        if (produto.verificarEstoque()) {
            System.out.println("Produto disponível em estoque.");
        } else {
            System.out.println("Produto indisponível.");
        }
    }

    public void cancelarAgendamento(GerenciadorDeAgendamentos gerenciador, String dataCancelamento, String dataAula) {
        Agenda agendamento = gerenciador.buscarAgendamento(dataAula);
        if (agendamento != null) {
            Calendar dataCancelamentoCalendar = Calendar.getInstance();
            String[] partesDataCancelamento = dataCancelamento.split("-");
            dataCancelamentoCalendar.set(
                Integer.parseInt(partesDataCancelamento[0]),
                Integer.parseInt(partesDataCancelamento[1]) - 1,
                Integer.parseInt(partesDataCancelamento[2])
            );

            agendamento.cancelarAgendamento(dataCancelamento);
            System.out.println("Cancelamento realizado com sucesso para a data: " + dataAula);
        } else {
            System.out.println("Nenhum agendamento encontrado para a data: " + dataAula);
        }
    }

    // Implementação dos métodos de GerenciamentoCliente
    @Override
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " adicionado.");
    }

    @Override
    public void removerCliente(String cpf) {
        Cliente cliente = buscarCliente(cpf);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente " + cliente.getNome() + " removido.");
        } else {
            System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        }
    }

    @Override
    public void editarCliente(String cpf, String novoNome, String novoEndereco, String novoTelefone, String novoEmail, String novoPlano) {
        Cliente cliente = buscarCliente(cpf);
        if (cliente != null) {
            cliente.setNome(novoNome);
            cliente.setEndereco(novoEndereco);
            cliente.setTelefone(novoTelefone);
            cliente.setEmail(novoEmail);
            cliente.setPlano(novoPlano);
            System.out.println("Cliente " + cpf + " editado com sucesso.");
        } else {
            System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        }
    }

    @Override
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
            }
        }
    }

    private Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

     @Override
    public void exibirDados() {
        System.out.println(super.toString() +
            "\nID Funcionário: " + idFuncionario +
            "\nCargo: " + cargo +
            "\nID: " + id);
    }
}
