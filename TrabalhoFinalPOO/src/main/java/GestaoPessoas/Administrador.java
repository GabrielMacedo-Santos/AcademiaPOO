package GestaoPessoas;

import json.JsonFuncionario;
import java.util.List;

/**
 * Classe que representa um Administrador, responsável por gerenciar funcionários.
 */
public class Administrador extends Funcionario {

    public Administrador(String usuario, String senha, String nome, String endereco, String telefone, String email, String cpf) {
        super(usuario, senha, nome, endereco, telefone, email, cpf, "Administrador");
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        JsonFuncionario.salvarFuncionario(funcionario);
        System.out.println("Funcionário " + funcionario.getNome() + " adicionado.");
    }

    public void removerFuncionario(String idFuncionario) {
        JsonFuncionario.removerFuncionario(idFuncionario);
    }

    public void editarFuncionario(String idFuncionario, String novoNome, String novoEndereco, String novoTelefone, String novoEmail, String novoCargo) {
        List<Funcionario> funcionarios = JsonFuncionario.carregarFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getIdFuncionario().equals(idFuncionario)) {
                funcionario.setNome(novoNome);
                funcionario.setEndereco(novoEndereco);
                funcionario.setTelefone(novoTelefone);
                funcionario.setEmail(novoEmail);
                funcionario.setCargo(novoCargo);
                JsonFuncionario.salvarFuncionario(funcionario);
                System.out.println("Funcionário com ID " + idFuncionario + " editado com sucesso.");
                return;
            }
        }
        System.out.println("Funcionário com ID " + idFuncionario + " não encontrado.");
    }

    public void listarFuncionarios() {
        List<Funcionario> funcionarios = JsonFuncionario.carregarFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário encontrado.");
        } else {
            System.out.println("\n=== Lista de Funcionários ===");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("Nome: " + funcionario.getNome() + ", ID: " + funcionario.getIdFuncionario() + ", Cargo: " + funcionario.getCargo());
            }
        }
    }
}
