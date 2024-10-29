package GestãoPessoas;

import SistemaDaAcademia.GerenciadorDeAgendamentos;
import Academia.Agenda;
import java.time.LocalDate;

public class Cliente extends Pessoa {

    private String plano;
    private double saldoDevedor;

    public Cliente(String nome, String endereco, String telefone, String email, String cpf, String plano) {
        super(nome, endereco, telefone, email, cpf);
        this.plano = plano;
        this.saldoDevedor = 0;
    }

    public void realizarAgendamento(GerenciadorDeAgendamentos gerenciador, String data, double valorAgendamento) {
        gerenciador.adicionarAgendamento(data, valorAgendamento);
        this.saldoDevedor += valorAgendamento;
    }

    public void cancelarReserva(GerenciadorDeAgendamentos gerenciador, String dataCancelamento, String dataAula) {
    LocalDate dataCancelamentoLocal = LocalDate.parse(dataCancelamento);
    LocalDate dataAulaLocal = LocalDate.parse(dataAula);

    Agenda agendamento = gerenciador.buscarAgendamento(dataAulaLocal.toString());
    if (agendamento != null) {
        boolean dentroTresDiasUteis;
        dentroTresDiasUteis = agendamento.isDentroTresDiasUteis(dataCancelamentoLocal.toString());
        double valorRetido = dentroTresDiasUteis ? agendamento.getValorAgendamento() * 0.5 : agendamento.getValorAgendamento();
        agendamento.cancelarAgendamento(dataCancelamentoLocal.toString());
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
