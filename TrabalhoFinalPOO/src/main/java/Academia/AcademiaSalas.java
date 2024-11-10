package Academia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe que representa as salas da academia.
 */
public class AcademiaSalas {

    /**
     * Enum para representar os tipos de aulas.
     */
    public enum TipoSala {
        SPINNING,
        MUSCULACAO,
        FIT_DANCE,
        PILATES
    }

    /**
     * Classe estática interna para armazenar informações de cada sala.
     */
    public static class Sala {
        private final TipoSala tipoSala;
        private final int capacidadeMaxima;

        /**
         * Construtor da classe Sala.
         *
         * @param tipoSala        O tipo de sala (SPINNING, MUSCULACAO, FIT_DANCE, PILATES).
         * @param capacidadeMaxima A capacidade máxima de alunos na sala.
         */
        public Sala(TipoSala tipoSala, int capacidadeMaxima) {
            this.tipoSala = tipoSala;
            this.capacidadeMaxima = capacidadeMaxima;
        }

        public TipoSala getTipoSala() {
            return tipoSala;
        }

        public int getCapacidadeMaxima() {
            return capacidadeMaxima;
        }

        @Override
        public String toString() {
            return "Sala: " + tipoSala + ", Capacidade Máxima: " + capacidadeMaxima;
        }
    }

    private static final List<Sala> salas = new ArrayList<>();

    static {
        salas.add(new Sala(TipoSala.SPINNING, 20));
        salas.add(new Sala(TipoSala.MUSCULACAO, 30));
        salas.add(new Sala(TipoSala.FIT_DANCE, 25));
        salas.add(new Sala(TipoSala.PILATES, 15));
    }

    /**
     * Retorna a lista de salas disponíveis.
     *
     * @return Uma lista imutável de salas.
     */
    public static List<Sala> getSalas() {
        return Collections.unmodifiableList(salas);
    }

    /**
     * Exibe informações de todas as salas disponíveis.
     */
    public static void exibirSalas() {
        System.out.println("Informações das Salas:");
        for (Sala sala : salas) {
            System.out.println(sala);
        }
    }
}
