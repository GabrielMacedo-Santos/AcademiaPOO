package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import GestaoPessoas.Cliente;

public class JsonCliente {

    public static final String CLIENTE_JSON_PATH = "src/main/java/json/Cliente.json";

    public JsonCliente() {
    }

    public static void salvarClientes(List<Cliente> novosClientes) {
        List<Cliente> clientesExistentes = carregarClientes(); // Carrega clientes existentes do JSON
        clientesExistentes.addAll(novosClientes); // Adiciona novos clientes à lista existente

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(clientesExistentes);

        try (FileWriter writer = new FileWriter(CLIENTE_JSON_PATH)) {
            writer.write(json);
            System.out.println("Clientes salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar clientes!");
        }
    }

    public static List<Cliente> carregarClientes() {
        Gson gson = new Gson();
        List<Cliente> clientes = new ArrayList<>();

        try (FileReader reader = new FileReader(CLIENTE_JSON_PATH)) {
            Type clienteListType = new TypeToken<List<Cliente>>() {
            }.getType();
            clientes = gson.fromJson(reader, clienteListType);
            System.out.println("Clientes carregados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar clientes!");
        }

        return clientes;
    }
}
