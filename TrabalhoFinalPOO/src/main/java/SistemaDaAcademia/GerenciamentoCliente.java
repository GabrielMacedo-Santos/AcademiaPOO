package SistemaDaAcademia;

import GestaoPessoas.Cliente;

/**
 * Interface para gerenciar clientes na academia.
 */
public interface GerenciamentoCliente {

    /**
     * Adiciona um cliente ao sistema.
     * 
     * @param cliente o cliente a ser adicionado
     */
    void adicionarCliente(Cliente cliente);

    /**
     * Remove um cliente do sistema com base no CPF.
     * 
     * @param cpf o CPF do cliente a ser removido
     */
    void removerCliente(String cpf);

    /**
     * Edita as informações de um cliente com base no CPF.
     * 
     * @param cpf         o CPF do cliente a ser editado
     * @param novoNome    o novo nome do cliente
     * @param novoEndereco o novo endereço do cliente
     * @param novoTelefone o novo telefone do cliente
     * @param novoEmail    o novo e-mail do cliente
     * @param novoPlano    o novo plano do cliente
     */
    void editarCliente(String cpf, String novoNome, String novoEndereco, String novoTelefone, String novoEmail, String novoPlano);

    /**
     * Lista todos os clientes cadastrados no sistema.
     */
    void listarClientes();
}
