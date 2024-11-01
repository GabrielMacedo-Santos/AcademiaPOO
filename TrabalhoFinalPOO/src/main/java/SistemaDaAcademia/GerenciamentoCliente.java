package SistemaDaAcademia;

import GestãoPessoas.Cliente;

public interface GerenciamentoCliente {

    // Métodos para gerenciamento de clientes
    void adicionarCliente(Cliente cliente);
    void removerCliente(String cpf);
    void editarCliente(Cliente clienteEditado);

    
}
