package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe responsável por manipular dados de contagem (clientes e produtos) em formato JSON.
 * Contém métodos para salvar e carregar contagens de clientes e produtos.
 */
public class JsonContagem {
    private static final String JSON_PATH = "src/main/java/json/Contagem.json";

    /**
     * Salva a contagem de clientes e produtos no arquivo JSON.
     * 
     * @param contadorClientes Contador de clientes.
     * @param contadorProdutos Contador de produtos.
     */
    public static void salvarContagem(int contadorClientes, int contadorProdutos) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Contagem contagem = new Contagem(contadorClientes, contadorProdutos);

        try (FileWriter writer = new FileWriter(JSON_PATH)) {
            gson.toJson(contagem, writer);
            System.out.println("Contagem salva com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar contagem!");
        }
    }

    /**
     * Carrega a contagem de clientes e produtos a partir do arquivo JSON.
     * 
     * @return Contagem carregada ou uma contagem com valores padrão caso ocorra erro.
     */
    public static Contagem carregarContagem() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(JSON_PATH)) {
            return gson.fromJson(reader, Contagem.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar contagem!");
            return new Contagem(0, 0);
        }
    }

    /**
     * Classe interna para armazenar a contagem de clientes e produtos.
     */
    private static class Contagem {
        private int contadorClientes;
        private int contadorProdutos;

        public Contagem(int contadorClientes, int contadorProdutos) {
            this.contadorClientes = contadorClientes;
            this.contadorProdutos = contadorProdutos;
        }

        public int getContadorClientes() {
            return contadorClientes;
        }

        public int getContadorProdutos() {
            return contadorProdutos;
        }
    }
}
