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

public class JsonAgendamento {

    private static final String AGENDAMENTO_JSON_PATH = "src/main/java/json/Agendamento.json";

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
