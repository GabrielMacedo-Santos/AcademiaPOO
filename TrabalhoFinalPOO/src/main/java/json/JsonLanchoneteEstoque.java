package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import Loja.Produto;
import com.google.gson.reflect.TypeToken;

/**
 * Classe responsável por manipular os dados dos produtos da lanchonete em formato JSON.
 * Esta classe permite salvar e carregar os produtos da lanchonete para e a partir de um arquivo JSON.
 */
public class JsonLanchoneteEstoque {
    public static final String JSON_PATH = "src/main/java/json/LanchoneteEstoque.json";

    /**
     * Salva a lista de produtos no arquivo JSON.
     * 
     * @param produtos Lista de produtos a serem salvos.
     */
    public static void salvarProdutos(List<Produto> produtos) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(JSON_PATH)) {
            gson.toJson(produtos, writer);
            System.out.println("Produtos da lanchonete salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar produtos da lanchonete!");
        }
    }

    /**
     * Carrega a lista de produtos a partir de um arquivo JSON.
     * 
     * @return Lista de produtos carregada do arquivo JSON.
     */
    public static List<Produto> carregarProdutos() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(JSON_PATH)) {
            Type produtoListType = new TypeToken<List<Produto>>() {}.getType();
            return gson.fromJson(reader, produtoListType);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar produtos da lanchonete!");
            return new ArrayList<>();
        }
    }
}
