package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import Loja.Produto;

/**
 * Classe responsável por manipular os dados dos produtos em formato JSON.
 * Esta classe permite salvar os produtos para um arquivo JSON.
 */
public class JsonProduto {
    public static final String CLIENTE_JSON_PATH = "src/main/java/json/Produto.json";

    /**
     * Construtor da classe JsonProduto.
     */
    public JsonProduto() {}

    /**
     * Salva a lista de produtos no arquivo JSON.
     * 
     * @param produto Lista de produtos a serem salvos.
     */
    public static void salvarClientes(List<Produto> produto) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(produto);

        try (FileWriter writer = new FileWriter(CLIENTE_JSON_PATH)) {
            writer.write(json);
            System.out.println("Clientes salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar clientes!");
        }
    }
}
