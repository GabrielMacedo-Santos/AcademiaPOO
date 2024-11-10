package Academia;

import java.util.Calendar;

/**
 * Classe que representa a agenda de uma aula.
 */
public class Agenda {
    private Calendar data;
    private boolean vagaDisponivel;
    private double valorAgendamento;

    /**
     * Construtor da classe Agenda.
     *
     * @param dataStr          Data do agendamento no formato "yyyy-MM-dd".
     * @param vagaDisponivel   Indica se há vagas disponíveis para a aula.
     * @param valorAgendamento Valor do agendamento da aula.
     */
    public Agenda(String dataStr, boolean vagaDisponivel, double valorAgendamento) {
        this.data = Calendar.getInstance();
        String[] partesData = dataStr.split("-");
        int ano = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]) - 1;
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
            int diaSemana = dataComparada.get(Calendar.DAY_OF_WEEK);
            if (diaSemana != Calendar.SATURDAY && diaSemana != Calendar.SUNDAY) {
                diasUteis++;
            }
        }
        return !data.after(dataComparada);
    }

    @Override
    public String toString() {
        return "Agendamento para " + data.getTime() + ", valor: R$ " + valorAgendamento;
    }
}
