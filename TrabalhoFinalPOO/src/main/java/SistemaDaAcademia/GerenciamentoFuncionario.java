package SistemaDaAcademia;

import GestaoPessoas.Funcionario;

/**
 * Interface responsável por definir os métodos de gerenciamento de funcionários na academia.
 * Implementações dessa interface devem fornecer funcionalidades para adicionar, remover, editar e listar funcionários.
 */
public interface GerenciamentoFuncionario {
    
    /**
     * Adiciona um novo funcionário.
     * 
     * @param funcionario O funcionário a ser adicionado.
     */
    void adicionarFuncionario(Funcionario funcionario);

    /**
     * Remove um funcionário com o identificador fornecido.
     * 
     * @param idFuncionario O identificador do funcionário a ser removido.
     */
    void removerFuncionario(String idFuncionario);

    /**
     * Edita as informações de um funcionário com o identificador fornecido.
     * 
     * @param idFuncionario O identificador do funcionário a ser editado.
     * @param novoNome O novo nome do funcionário.
     * @param novoEndereco O novo endereço do funcionário.
     * @param novoTelefone O novo telefone do funcionário.
     * @param novoEmail O novo e-mail do funcionário.
     * @param novoCargo O novo cargo do funcionário.
     */
    void editarFuncionario(String idFuncionario, String novoNome, String novoEndereco, String novoTelefone, String novoEmail, String novoCargo);

    /**
     * Lista todos os funcionários cadastrados.
     */
    void listarFuncionarios();
}
