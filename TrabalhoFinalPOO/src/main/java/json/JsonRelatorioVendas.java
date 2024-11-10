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

/**
 * Classe responsável por manipular os dados de vendas em formato JSON.
 * Esta classe permite salvar e carregar o relatório de vendas para e a partir de um arquivo JSON.
 */
public class JsonRelatorioVendas {

    private static final String RELATORIO_VENDAS_JSON_PATH = "src/main/java/json/RelatorioVendas.json";

    /**
     * Salva a lista de vendas no arquivo JSON.
     * 
     * @param vendas Lista de vendas a serem salvas.
     */
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

    /**
     * Carrega a lista de vendas a partir de um arquivo JSON.
     * 
     * @return Lista de vendas carregada do arquivo JSON.
     */
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
