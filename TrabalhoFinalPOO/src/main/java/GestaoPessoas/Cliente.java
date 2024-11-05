package GestaoPessoas;

import SistemaDaAcademia.GerenciadorDeAgendamentos;
import Academia.Agenda;
import java.util.Calendar;
import json.JsonCliente;
import java.util.List;
public class Cliente extends Pessoa {

    private String plano;
    private double saldoDevedor;
    private int id;

    public Cliente(String nome, String endereco, String telefone, String email, String cpf, String plano) {
        super(nome, endereco, telefone, email, cpf);
        this.plano = plano;
        this.saldoDevedor = 0;
        this.id = gerarNovoIdCliente();
    }

    private static int gerarNovoIdCliente() {
        List<Cliente> clientes = JsonCliente.carregarClientes();

        // Encontrar o maior ID existente na lista de clientes
        int maxId = clientes.stream()
                .mapToInt(Cliente::getId)
                .max()
                .orElse(0); // Se a lista estiver vazia, começa do 0

        return maxId + 1; // Retorna o próximo ID único
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getPlano() {
        return plano;
    }

    public double getSaldoDevedor() {
        return saldoDevedor;
    }

    @Override
    public String getCpf() {
        return super.getCpf(); // Retorna o CPF da superclasse
    }

    // Setters
    public void setPlano(String plano) {
        this.plano = plano;
    }

    public void setSaldoDevedor(double saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }

    public void setNome(String nome) {
        super.setNome(nome);
    }

    public void setEndereco(String endereco) {
        super.setEndereco(endereco);
    }

    public void setTelefone(String telefone) {
        super.setTelefone(telefone);
    }

    public void setEmail(String email) {
        super.setEmail(email);
    }

    public void realizarAgendamento(GerenciadorDeAgendamentos gerenciador, String data, double valorAgendamento) {
        gerenciador.adicionarAgendamento(data, valorAgendamento);
        this.saldoDevedor += valorAgendamento;
    }

    public void cancelarReserva(GerenciadorDeAgendamentos gerenciador, String dataCancelamento, String dataAula) {
        Agenda agendamento = gerenciador.buscarAgendamento(dataAula);
        if (agendamento != null) {
            Calendar dataCancelamentoCalendar = Calendar.getInstance();
            String[] partesDataCancelamento = dataCancelamento.split("-");
            dataCancelamentoCalendar.set(
                    Integer.parseInt(partesDataCancelamento[0]),
                    Integer.parseInt(partesDataCancelamento[1]) - 1,
                    Integer.parseInt(partesDataCancelamento[2])
            );

            boolean dentroTresDiasUteis = agendamento.isDentroTresDiasUteis(dataCancelamentoCalendar);
            double valorRetido = dentroTresDiasUteis ? agendamento.getValorAgendamento() * 0.5 : agendamento.getValorAgendamento();
            agendamento.cancelarAgendamento(dataCancelamento);
            this.saldoDevedor -= valorRetido;
            System.out.println("Cancelamento realizado. Valor retido: R$ " + valorRetido);
        } else {
            System.out.println("Nenhum agendamento encontrado para a data: " + dataAula);
        }
    }

    public void realizarPagamento(double valor) {
        this.saldoDevedor -= valor;
        System.out.println("Pagamento de R$ " + valor + " realizado. Saldo devedor atualizado: R$ " + saldoDevedor);
    }

    @Override
    public void exibirDados() {
        System.out.println(super.toString() + "\nPlano: " + plano + "\nSaldo Devedor: " + saldoDevedor);
    }
}
