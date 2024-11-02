package SistemaDaAcademia;

import GestaoPessoas.Funcionario;

public interface GerenciamentoFuncionario {
    void adicionarFuncionario(Funcionario funcionario);
    void removerFuncionario(String idFuncionario);
    void editarFuncionario(String idFuncionario, String novoNome, String novoEndereco, String novoTelefone, String novoEmail, String novoCargo);
    void listarFuncionarios();
}
