package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import Academia.Agenda;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por salvar e carregar agendamentos em formato JSON.
 */
public class JsonAgendamento {

    /**
     * Caminho para o arquivo JSON de agendamentos.
     */
    private static final String AGENDAMENTO_JSON_PATH = "src/main/java/json/Agendamento.json";

    /**
     * Salva uma lista de agendamentos no arquivo JSON.
     * 
     * @param agendamentos Lista de agendamentos a serem salvos.
     */
    public static void salvarAgendamentos(List<Agenda> agendamentos) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(agendamentos);

        try (FileWriter writer = new FileWriter(AGENDAMENTO_JSON_PATH)) {
            writer.write(json);
            System.out.println("Agendamentos salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar agendamentos!");
        }
    }

    /**
     * Carrega a lista de agendamentos a partir do arquivo JSON.
     * 
     * @return Lista de agendamentos carregados.
     */
    public static List<Agenda> carregarAgendamentos() {
        Gson gson = new Gson();
        List<Agenda> agendamentos = new ArrayList<>();

        try (FileReader reader = new FileReader(AGENDAMENTO_JSON_PATH)) {
            Type agendamentoListType = new TypeToken<List<Agenda>>() {}.getType();
            agendamentos = gson.fromJson(reader, agendamentoListType);
            System.out.println("Agendamentos carregados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar agendamentos!");
        }

        return agendamentos;
    }
}
