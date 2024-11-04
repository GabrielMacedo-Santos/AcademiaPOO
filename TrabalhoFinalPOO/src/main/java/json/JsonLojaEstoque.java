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

public class JsonLojaEstoque {
    public static final String JSON_PATH = "src/main/java/json/LojaEstoque.json";

    public static void salvarProdutos(List<Produto> produtos) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(JSON_PATH)) {
            gson.toJson(produtos, writer);
            System.out.println("Produtos da loja salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar produtos da loja!");
        }
    }

    public static List<Produto> carregarProdutos() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(JSON_PATH)) {
            Type produtoListType = new TypeToken<List<Produto>>() {}.getType();
            return gson.fromJson(reader, produtoListType);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar produtos da loja!");
            return new ArrayList<>();
        }
    }
}
