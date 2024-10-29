package Academia;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Agenda {
    private LocalDate data;
    private boolean vagaDisponivel;
    private double valorAgendamento;

    public Agenda(String data, boolean vagaDisponivel, double valorAgendamento) {
        this.data = LocalDate.parse(data);
        this.vagaDisponivel = vagaDisponivel;
        this.valorAgendamento = valorAgendamento;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValorAgendamento() {
        return valorAgendamento;
    }

    public boolean verificarVagas() {
        return vagaDisponivel;
    }

    public void realizarAgendamento() {
        if (vagaDisponivel) {
            System.out.println("Agendamento realizado para " + data);
            vagaDisponivel = false;
        } else {
            System.out.println("Sem vagas disponíveis para " + data);
        }
    }

    public void cancelarAgendamento(String dataCancelamento) {
        LocalDate dataCancel = LocalDate.parse(dataCancelamento);
        if (isDentroTresDiasUteis(dataCancel)) {
            System.out.println("50% do valor do agendamento foi retido. Valor retido: R$ " + (valorAgendamento * 0.5));
        } else {
            System.out.println("Agendamento cancelado. Valor total devolvido.");
        }
        vagaDisponivel = true;
    }

    public boolean isDentroTresDiasUteis(LocalDate dataCancelamento) {
        LocalDate dataLimite = data;
        int diasUteis = 0;

        while (diasUteis < 3) {
            dataLimite = dataLimite.minusDays(1);

            // Contar apenas dias úteis (segunda a sexta)
            if (dataLimite.getDayOfWeek() != DayOfWeek.SATURDAY && dataLimite.getDayOfWeek() != DayOfWeek.SUNDAY) {
                diasUteis++;
            }
        }

        // Verificar se a data de cancelamento é após o limite de três dias úteis antes do agendamento
        return !dataCancelamento.isBefore(dataLimite);
    }

    @Override
    public String toString() {
        return "Agendamento para " + data + ", valor: R$ " + valorAgendamento;
    }
}
