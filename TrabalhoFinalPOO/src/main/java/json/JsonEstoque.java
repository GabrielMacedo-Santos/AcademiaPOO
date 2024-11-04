package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import Loja.Estoque;

public class JsonEstoque {
public static final String CLIENTE_JSON_PATH = "src/main/java/json/Produto.json";

    public JsonEstoque() {}

    public static void salvarClientes(List<Estoque> estoque) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(estoque);

        try (FileWriter writer = new FileWriter(CLIENTE_JSON_PATH)) {
            writer.write(json);
            System.out.println("Clientes salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar clientes!");
        }
    }
}
