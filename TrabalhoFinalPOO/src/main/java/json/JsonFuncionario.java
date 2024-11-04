package json;

import GestaoPessoas.Funcionario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonFuncionario {
    public static final String FUNCIONARIO_JSON_PATH = "src/main/java/json/Funcionario.json";

    public JsonFuncionario() {}

    public static void salvarFuncionario(List<Funcionario> novosFuncionarios) {
        List<Funcionario> funcionariosExistentes = carregar();
        funcionariosExistentes.addAll(novosFuncionarios);  // Adiciona novos funcionários à lista existente

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(funcionariosExistentes);

        try (FileWriter writer = new FileWriter(FUNCIONARIO_JSON_PATH)) {
            writer.write(json);
            System.out.println("Funcionários salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar funcionários!");
        }
    }

    public static List<Funcionario> carregar() {
        Gson gson = new Gson();
        List<Funcionario> funcionarios = new ArrayList<>();

        try (FileReader reader = new FileReader(FUNCIONARIO_JSON_PATH)) {
            Type funcionarioListType = new TypeToken<List<Funcionario>>() {}.getType();
            funcionarios = gson.fromJson(reader, funcionarioListType);
            System.out.println("Funcionários carregados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar funcionários!");
        }

        return funcionarios;
    }
}
