package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import GestaoPessoas.Cliente;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por manipular dados de clientes em formato JSON.
 * Contém métodos para salvar, carregar, atualizar, remover e buscar clientes.
 */
public class JsonCliente {

    private static final String CLIENTE_JSON_PATH = "src/main/java/json/Cliente.json";

    /**
     * Salva uma lista de clientes no arquivo JSON.
     * 
     * @param clientes Lista de clientes a ser salva.
     */
    public static void salvarClientes(List<Cliente> clientes) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(clientes);

        try (FileWriter writer = new FileWriter(CLIENTE_JSON_PATH)) {
            writer.write(json);
            System.out.println("Clientes salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar clientes!");
        }
    }

    /**
     * Carrega todos os clientes a partir do arquivo JSON.
     * 
     * @return Lista de clientes carregados.
     */
    public static List<Cliente> carregarClientes() {
        Gson gson = new Gson();
        List<Cliente> clientes = new ArrayList<>();

        try (FileReader reader = new FileReader(CLIENTE_JSON_PATH)) {
            Type clienteListType = new TypeToken<List<Cliente>>() {}.getType();
            clientes = gson.fromJson(reader, clienteListType);
            System.out.println("Clientes carregados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar clientes!");
        }

        return clientes;
    }

    /**
     * Salva um único cliente no arquivo JSON, atualizando se o cliente já existir.
     * 
     * @param cliente Cliente a ser salvo.
     */
    public static void salvarCliente(Cliente cliente) {
        List<Cliente> clientesExistentes = carregarClientes();

        // Verifica se o cliente já existe para evitar duplicidade
        boolean clienteExiste = false;
        for (int i = 0; i < clientesExistentes.size(); i++) {
            Cliente c = clientesExistentes.get(i);
            if (c.getCpf().equals(cliente.getCpf())) {
                // Atualiza os dados do cliente existente
                clientesExistentes.set(i, cliente);
                clienteExiste = true;
                break;
            }
        }

        // Caso não exista, adiciona o novo cliente
        if (!clienteExiste) {
            clientesExistentes.add(cliente);
        }

        // Salva a lista atualizada no arquivo JSON
        salvarClientes(clientesExistentes);
    }

    /**
     * Remove um cliente da lista pelo CPF.
     * 
     * @param cpf CPF do cliente a ser removido.
     */
    public static void removerCliente(String cpf) {
        List<Cliente> clientesExistentes = carregarClientes();

        // Encontra e remove o cliente pelo CPF
        Cliente clienteParaRemover = null;
        for (Cliente cliente : clientesExistentes) {
            if (cliente.getCpf().equals(cpf)) {
                clienteParaRemover = cliente;
                break;
            }
        }

        if (clienteParaRemover != null) {
            clientesExistentes.remove(clienteParaRemover);
            System.out.println("Cliente com CPF " + cpf + " removido com sucesso.");
        } else {
            System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        }

        // Salva a lista atualizada no arquivo JSON
        salvarClientes(clientesExistentes);
    }

    /**
     * Busca um cliente pelo CPF.
     * 
     * @param cpf CPF do cliente a ser buscado.
     * @return Cliente encontrado ou null se não encontrado.
     */
    public static Cliente buscarCliente(String cpf) {
        List<Cliente> clientesExistentes = carregarClientes();

        for (Cliente cliente : clientesExistentes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        return null;
    }
}
