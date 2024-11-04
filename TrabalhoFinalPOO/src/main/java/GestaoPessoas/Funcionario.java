package GestaoPessoas;

import Loja.Produto;
import SistemaDaAcademia.GerenciadorDeAgendamentos;
import java.util.Calendar;
import Academia.Agenda;
import java.util.List;
import json.JsonFuncionario;

public class Funcionario extends Pessoa {

    private String idFuncionario;
    private String cargo;
    private int id;

    public Funcionario(String nome, String endereco, String telefone, String email, String cpf, String idFuncionario, String cargo) {
        super(nome, endereco, telefone, email, cpf);
        this.idFuncionario = idFuncionario;
        this.cargo = cargo;
         this.id = gerarNovoIdFuncionario();
    }

    private static int gerarNovoIdFuncionario() {
        List<Funcionario> funcionarios = JsonFuncionario.carregar();
        return funcionarios.size() + 1;
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

    @Override
    public void exibirDados() {
        System.out.println(super.toString() + "\nID Funcionário: " + idFuncionario + "\nCargo: " + cargo);
    }
}
