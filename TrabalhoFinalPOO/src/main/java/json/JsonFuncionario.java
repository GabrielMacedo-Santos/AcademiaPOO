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

/**
 * Classe responsável por manipular dados de funcionários em formato JSON.
 * Contém métodos para salvar, carregar, atualizar e remover funcionários.
 */
public class JsonFuncionario {

    private static final String FUNCIONARIO_JSON_PATH = "src/main/java/json/Funcionario.json";
    private static final Logger LOGGER = Logger.getLogger(JsonFuncionario.class.getName());

    /**
     * Salva uma lista de funcionários no arquivo JSON.
     * 
     * @param funcionarios Lista de funcionários a ser salva.
     */
    public static void salvarFuncionarios(List<Funcionario> funcionarios) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(funcionarios);

        try (FileWriter writer = new FileWriter(FUNCIONARIO_JSON_PATH)) {
            writer.write(json);
            LOGGER.log(Level.INFO, "Funcionários salvos com sucesso!");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar funcionários!", e);
        }
    }

    /**
     * Carrega todos os funcionários a partir do arquivo JSON.
     * 
     * @return Lista de funcionários carregados.
     */
    public static List<Funcionario> carregarFuncionarios() {
        Gson gson = new Gson();
        List<Funcionario> funcionarios = new ArrayList<>();

        try (FileReader reader = new FileReader(FUNCIONARIO_JSON_PATH)) {
            Type funcionarioListType = new TypeToken<List<Funcionario>>() {}.getType();
            funcionarios = gson.fromJson(reader, funcionarioListType);
            LOGGER.log(Level.INFO, "Funcionários carregados com sucesso!");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao carregar funcionários!", e);
        }

        return funcionarios;
    }

    /**
     * Salva um único funcionário no arquivo JSON.
     * 
     * @param funcionario Funcionario a ser salvo.
     */
    public static void salvarFuncionario(Funcionario funcionario) {
        List<Funcionario> funcionariosExistentes = carregarFuncionarios();

        // Verifica se o funcionário já existe para evitar duplicidade
        boolean funcionarioExiste = false;
        for (int i = 0; i < funcionariosExistentes.size(); i++) {
            Funcionario f = funcionariosExistentes.get(i);
            if (f.getCpf().equals(funcionario.getCpf())) {
                // Atualiza os dados do funcionário existente
                funcionariosExistentes.set(i, funcionario);
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
    }

    /**
     * Remove um funcionário da lista pelo CPF.
     * 
     * @param cpf CPF do funcionário a ser removido.
     */
    public static void removerFuncionario(String cpf) {
        List<Funcionario> funcionariosExistentes = carregarFuncionarios();

        // Encontra e remove o funcionário pelo CPF
        Funcionario funcionarioParaRemover = null;
        for (Funcionario funcionario : funcionariosExistentes) {
            if (funcionario.getCpf().equals(cpf)) {
                funcionarioParaRemover = funcionario;
                break;
            }
        }

        if (funcionarioParaRemover != null) {
            funcionariosExistentes.remove(funcionarioParaRemover);
            LOGGER.log(Level.INFO, "Funcionário com CPF {0} removido com sucesso.", cpf);
        } else {
            LOGGER.log(Level.WARNING, "Funcionário com CPF {0} não encontrado.", cpf);
        }

        // Salva a lista atualizada no arquivo JSON
        salvarFuncionarios(funcionariosExistentes);
    }
}
