// Classe JsonFuncionario
package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import GestaoPessoas.Funcionario;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonFuncionario {

    private static final String FUNCIONARIO_JSON_PATH = "src/main/java/json/Funcionario.json";
    private static final Logger LOGGER = Logger.getLogger(JsonFuncionario.class.getName());

    // Método para salvar uma lista de funcionários
    public static synchronized void salvarFuncionarios(List<Funcionario> funcionarios) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(funcionarios);

        try (FileWriter writer = new FileWriter(FUNCIONARIO_JSON_PATH)) {
            writer.write(json);
            LOGGER.log(Level.INFO, "Funcionários salvos com sucesso!");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar funcionários!", e);
        }
    }

    // Método para carregar todos os funcionários do arquivo JSON
    public static List<Funcionario> carregarFuncionarios() {
        Gson gson = new Gson();
        List<Funcionario> funcionarios = new ArrayList<>();

        try (FileReader reader = new FileReader(FUNCIONARIO_JSON_PATH)) {
            Type funcionarioListType = new TypeToken<List<Funcionario>>() {}.getType();
            funcionarios = gson.fromJson(reader, funcionarioListType);

            if (funcionarios == null) {
                funcionarios = new ArrayList<>();
            }
            LOGGER.log(Level.INFO, "Funcionários carregados com sucesso!");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao carregar funcionários!", e);
        }

        return funcionarios;
    }

    // Método para salvar um único funcionário
    public static synchronized void salvarFuncionario(Funcionario funcionario) {
        List<Funcionario> funcionariosExistentes = carregarFuncionarios();

        // Verifica se o funcionário já existe e atualiza, se necessário
        boolean funcionarioExiste = false;
        for (int i = 0; i < funcionariosExistentes.size(); i++) {
            if (funcionariosExistentes.get(i).getIdFuncionario().equals(funcionario.getIdFuncionario())) {
                funcionariosExistentes.set(i, funcionario); // Atualiza os dados do funcionário existente
                funcionarioExiste = true;
                break;
            }
        }

        // Caso não exista, adiciona o novo funcionário
        if (!funcionarioExiste) {
            funcionariosExistentes.add(funcionario);
        }

        // Salva a lista atualizada no arquivo JSON
        salvarFuncionarios(funcionariosExistentes);
        LOGGER.log(Level.INFO, "Funcionário com ID " + funcionario.getIdFuncionario() + " salvo com sucesso!");
    }

    // Método para remover um funcionário do JSON
    public static synchronized void removerFuncionario(String idFuncionario) {
        List<Funcionario> funcionarios = carregarFuncionarios();

        // Tenta remover o funcionário da lista
        boolean removed = funcionarios.removeIf(funcionario -> funcionario.getIdFuncionario().equals(idFuncionario));

        // Verifica se a remoção foi bem-sucedida e salva a lista atualizada no JSON
        if (removed) {
            salvarFuncionarios(funcionarios);
            LOGGER.log(Level.INFO, "Funcionário com ID " + idFuncionario + " removido com sucesso!");
        } else {
            LOGGER.log(Level.WARNING, "Funcionário com ID " + idFuncionario + " não encontrado.");
        }
    }
}
