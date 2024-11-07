package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import Loja.Produto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonEstoque {

    private static final String ESTOQUE_JSON_PATH = "src/main/java/json/Estoque.json";

    public static void salvarEstoque(List<Produto> produtos) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(produtos);

        try (FileWriter writer = new FileWriter(ESTOQUE_JSON_PATH)) {
            writer.write(json);
            System.out.println("Produtos do estoque salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar produtos do estoque!");
        }
    }

    public static List<Produto> carregarEstoque() {
        Gson gson = new Gson();
        List<Produto> produtos = new ArrayList<>();

        try (FileReader reader = new FileReader(ESTOQUE_JSON_PATH)) {
            Type produtoListType = new TypeToken<List<Produto>>() {}.getType();
            produtos = gson.fromJson(reader, produtoListType);
            System.out.println("Produtos do estoque carregados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar produtos do estoque!");
        }

        return produtos;
    }
}
