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
import GestaoPessoas.Administrador;

public class JsonAdministrador {
public static final String JSON_PATH = "src/main/java/json/Administrador.json";

    public JsonAdministrador() {}

    public static void salvarAdministradores(List<Administrador> administrador) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(administrador);

        try (FileWriter writer = new FileWriter(JSON_PATH)) {
            writer.write(json);
            System.out.println("Clientes salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar clientes!");
        }
    }
    public static List<Administrador> carregar() {
        Gson gson = new Gson();
        List<Administrador> dados = new ArrayList<>();

        try (FileReader reader = new FileReader(JSON_PATH)) {
            Type clienteListType = new TypeToken<List<Administrador>>() {}.getType();
            dados = gson.fromJson(reader, clienteListType);
            System.out.println("Clientes carregados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar clientes!");
        }

        return dados;
    }
}
