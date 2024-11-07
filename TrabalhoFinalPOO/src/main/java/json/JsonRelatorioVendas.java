package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import Loja.Venda;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonRelatorioVendas {

    private static final String RELATORIO_VENDAS_JSON_PATH = "src/main/java/json/RelatorioVendas.json";

    public static void salvarVendas(List<Venda> vendas) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(vendas);

        try (FileWriter writer = new FileWriter(RELATORIO_VENDAS_JSON_PATH)) {
            writer.write(json);
            System.out.println("Relatório de vendas salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar relatório de vendas!");
        }
    }

    public static List<Venda> carregarVendas() {
        Gson gson = new Gson();
        List<Venda> vendas = new ArrayList<>();

        try (FileReader reader = new FileReader(RELATORIO_VENDAS_JSON_PATH)) {
            Type vendaListType = new TypeToken<List<Venda>>() {}.getType();
            vendas = gson.fromJson(reader, vendaListType);
            System.out.println("Vendas carregadas com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar relatório de vendas!");
        }

        return vendas;
    }
}
