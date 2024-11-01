package Academia;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Agenda {
    private Calendar data;
    private boolean vagaDisponivel;
    private double valorAgendamento;

    public Agenda(String dataStr, boolean vagaDisponivel, double valorAgendamento) {
        this.data = Calendar.getInstance();
        String[] partesData = dataStr.split("-"); // Supondo formato "yyyy-MM-dd"
        int ano = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]) - 1; // Calendar usa meses baseados em 0 (Janeiro = 0)
        int dia = Integer.parseInt(partesData[2]);
        this.data.set(ano, mes, dia);

        this.vagaDisponivel = vagaDisponivel;
        this.valorAgendamento = valorAgendamento;
    }

    public Calendar getData() {
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
            System.out.println("Agendamento realizado para " + data.getTime());
            vagaDisponivel = false;
        } else {
            System.out.println("Sem vagas disponíveis para " + data.getTime());
        }
    }

    public void cancelarAgendamento(String dataCancelamentoStr) {
        Calendar dataCancelamento = Calendar.getInstance();
        String[] partesCancelamento = dataCancelamentoStr.split("-");
        dataCancelamento.set(
            Integer.parseInt(partesCancelamento[0]),
            Integer.parseInt(partesCancelamento[1]) - 1,
            Integer.parseInt(partesCancelamento[2])
        );

        if (isDentroTresDiasUteis(dataCancelamento)) {
            System.out.println("50% do valor do agendamento foi retido. Valor retido: R$ " + valorAgendamento * 0.5);
        } else {
            System.out.println("Agendamento cancelado. Valor total devolvido.");
        }
        vagaDisponivel = true;
    }

    public boolean isDentroTresDiasUteis(Calendar dataCancelamento) {
        Calendar dataComparada = (Calendar) dataCancelamento.clone();
        int diasUteis = 0;

        while (diasUteis < 3) {
            dataComparada.add(Calendar.DAY_OF_MONTH, 1);

            // Verifica se o dia é útil (segunda a sexta-feira)
            int diaSemana = dataComparada.get(Calendar.DAY_OF_WEEK);
            if (diaSemana != Calendar.SATURDAY && diaSemana != Calendar.SUNDAY) {
                diasUteis++;
            }
        }

        // Verifica se a data original do agendamento é antes da data calculada
        return !data.after(dataComparada);
    }

    @Override
    public String toString() {
        return "Agendamento para " + data.getTime() + ", valor: R$ " + valorAgendamento;
    }
}
