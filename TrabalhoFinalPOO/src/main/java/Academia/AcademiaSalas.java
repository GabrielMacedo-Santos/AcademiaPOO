
package Academia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AcademiaSalas {

    // Enum para representar os tipos de aulas
    public enum TipoSala {
        SPINNING,
        MUSCULACAO,
        FIT_DANCE,
        PILATES
    }

    // Classe estática interna para armazenar informações de cada sala
    public static class Sala {
        private final TipoSala tipoSala;
        private final int capacidadeMaxima;

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

    // Lista estática das salas da academia
    private static final List<Sala> salas = new ArrayList<>();

    // Bloco estático para inicializar as salas
    static {
        salas.add(new Sala(TipoSala.SPINNING, 20));
        salas.add(new Sala(TipoSala.MUSCULACAO, 30));
        salas.add(new Sala(TipoSala.FIT_DANCE, 25));
        salas.add(new Sala(TipoSala.PILATES, 15));
    }

    // Método para acessar as salas
    public static List<Sala> getSalas() {
        return Collections.unmodifiableList(salas); // Retorna uma lista não modificável
    }

    // Método para exibir informações de todas as salas
    public static void exibirSalas() {
        System.out.println("Informações das Salas:");
        for (Sala sala : salas) {
            System.out.println(sala);
        }
    }
}
