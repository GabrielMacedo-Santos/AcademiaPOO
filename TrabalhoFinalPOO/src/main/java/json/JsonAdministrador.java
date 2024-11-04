package json;

import GestaoPessoas.Administrador;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonAdministrador {
    public static final String JSON_PATH = "src/main/java/json/Administrador.json";

    public JsonAdministrador() {}

    public static void salvarAdministradores(List<Administrador> novosAdministradores) {
        List<Administrador> administradoresExistentes = carregar();
        administradoresExistentes.addAll(novosAdministradores); // Adiciona novos administradores

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(administradoresExistentes);

        try (FileWriter writer = new FileWriter(JSON_PATH)) {
            writer.write(json);
            System.out.println("Administradores salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar administradores!");
        }
    }

    public static List<Administrador> carregar() {
        Gson gson = new Gson();
        List<Administrador> administradores = new ArrayList<>();

        try (FileReader reader = new FileReader(JSON_PATH)) {
            Type administradorListType = new TypeToken<List<Administrador>>() {}.getType();
            administradores = gson.fromJson(reader, administradorListType);
            System.out.println("Administradores carregados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar administradores!");
        }

        return administradores;
    }
}
