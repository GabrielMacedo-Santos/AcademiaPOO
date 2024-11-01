package GestãoPessoas;

import SistemaDaAcademia.GerenciamentoFuncionario;
import java.util.ArrayList;

public class Administrador extends Funcionario implements GerenciamentoFuncionario {
    private ArrayList<Funcionario> funcionarios;

    public Administrador(String nome, String endereco, String telefone, String email, String cpf, String idFuncionario, String cargo) {
        super(nome, endereco, telefone, email, cpf, idFuncionario, cargo);
        funcionarios = new ArrayList<>();
    }

    @Override
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário " + funcionario.getNome() + " adicionado.");
    }

    @Override
    public void removerFuncionario(String idFuncionario) {
        Funcionario funcionario = buscarFuncionario(idFuncionario);
        if (funcionario != null) {
            funcionarios.remove(funcionario);
            System.out.println("Funcionário " + funcionario.getNome() + " removido.");
        } else {
            System.out.println("Funcionário com ID " + idFuncionario + " não encontrado.");
        }
    }

    @Override
    public void editarFuncionario(String idFuncionario, String novoNome, String novoEndereco, String novoTelefone, String novoEmail, String novoCargo) {
        Funcionario funcionario = buscarFuncionario(idFuncionario);
        if (funcionario != null) {
            funcionario.setNome(novoNome);
            funcionario.setEndereco(novoEndereco);
            funcionario.setTelefone(novoTelefone);
            funcionario.setEmail(novoEmail);
            funcionario.setCargo(novoCargo); // Supondo que Funcionario tenha um método setCargo
            System.out.println("Funcionário " + idFuncionario + " editado com sucesso.");
        } else {
            System.out.println("Funcionário com ID " + idFuncionario + " não encontrado.");
        }
    }

    @Override
    public void listarFuncionarios() {
        System.out.println("Lista de Funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + " - ID: " + funcionario.getIdFuncionario());
        }
    }

    private Funcionario buscarFuncionario(String idFuncionario) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getIdFuncionario().equals(idFuncionario)) {
                return funcionario;
            }
        }
        return null;
    }
}
