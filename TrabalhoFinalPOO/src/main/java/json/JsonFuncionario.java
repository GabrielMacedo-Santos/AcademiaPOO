package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import GestaoPessoas.Funcionario;

public class JsonFuncionario {
public static final String FUNCIONARIO_JSON_PATH = "src/main/java/json/Funcionario.json";

    public JsonFuncionario() {}

    public static void salvarFuncionario(List<Funcionario> funcionario) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(funcionario);

        try (FileWriter writer = new FileWriter(FUNCIONARIO_JSON_PATH)) {
            writer.write(json);
            System.out.println("Clientes salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar clientes!");
        }
    }
}
