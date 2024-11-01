package GestãoPessoas;

import Academia.Agenda;
import Loja.Produto;
import SistemaDaAcademia.GerenciamentoUsuario;
import SistemaDaAcademia.GerenciadorDeAgendamentos;
import java.util.ArrayList;
import java.util.Calendar;

public class Funcionario extends Pessoa implements GerenciamentoUsuario {

    private String idFuncionario;
    private String cargo;
    private ArrayList<Cliente> clientes;

    public Funcionario(String nome, String endereco, String telefone, String email, String cpf, String idFuncionario, String cargo) {
        super(nome, endereco, telefone, email, cpf);
        this.idFuncionario = idFuncionario;
        this.cargo = cargo;
        this.clientes = new ArrayList<>(); // Inicializa a lista de clientes
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    // Implementação dos métodos da interface GerenciamentoUsuario
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
           
            System.out.println("Cliente " + cpf + " editado com sucesso.");
        } else {
            System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        }
    }

    @Override
    public void atualizarInformacoes(String nome, String endereco, String telefone, String email) {
        setNome(nome);
        setEndereco(endereco);
        setTelefone(telefone);
        setEmail(email);
        System.out.println("Informações do funcionário atualizadas com sucesso.");
    }

    @Override
    public void definirPermissao(String permissao) {
        // Lógica para definir permissão (se necessário)
        System.out.println("Permissão definida como: " + permissao);
    }

    @Override
    public void definirPlanoOuCargo(String planoOuCargo) {
        // Definindo o plano para clientes ou cargo para funcionários
        this.cargo = planoOuCargo; // Para Funcionários
        System.out.println("Cargo definido como: " + planoOuCargo);
    }

    @Override
    public void listarUsuarios() {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome() + " - CPF: " + cliente.getCpf());
        }
    }

    @Override
    public void exibirHistorico() {
        // Implementar lógica para exibir o histórico do cliente
        System.out.println("Histórico do Cliente:");
        // Aqui você pode implementar a lógica para exibir informações específicas do histórico
    }

    private Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
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

            agendamento.cancelarAgendamento(dataCancelamento); // Supondo que este método aceite uma String
            System.out.println("Cancelamento realizado com sucesso para a data: " + dataAula);
        } else {
            System.out.println("Nenhum agendamento encontrado para a data: " + dataAula);
        }
    }

    @Override
    public void exibirDados() {
        System.out.println(super.toString() + "\nID Funcionário: " + idFuncionario + "\nCargo: " + cargo);
    }
}
