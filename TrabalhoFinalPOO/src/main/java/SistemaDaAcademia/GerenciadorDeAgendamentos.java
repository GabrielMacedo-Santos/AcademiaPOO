package SistemaDaAcademia;

import Academia.Agenda;
import java.time.LocalDate;
import java.util.ArrayList;

public class GerenciadorDeAgendamentos {
    private ArrayList<Agenda> agendamentos;

    public GerenciadorDeAgendamentos() {
        agendamentos = new ArrayList<>();
    }

    public void adicionarAgendamento(String data, double valorAgendamento) {
        Agenda agendamento = new Agenda(data, true, valorAgendamento);
        agendamento.realizarAgendamento();
        agendamentos.add(agendamento);
    }

    public boolean cancelarAgendamento(String dataCancelamento, LocalDate dataAula) {
        for (Agenda agendamento : agendamentos) {
            if (agendamento.getData().equals(dataAula)) {
                agendamento.cancelarAgendamento(dataCancelamento);
                return true;  // Cancelamento bem-sucedido
            }
        }
        System.out.println("Nenhum agendamento encontrado para a data: " + dataAula);
        return false;  // Cancelamento falhou
    }

    public Agenda buscarAgendamento(String dataAula) {
        LocalDate data = LocalDate.parse(dataAula);
        for (Agenda agendamento : agendamentos) {
            if (agendamento.getData().equals(data)) {
                return agendamento;
            }
        }
        return null;  // Nenhum agendamento encontrado para a data especificada
    }
}
