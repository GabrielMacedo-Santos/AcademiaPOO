package SistemaDaAcademia;

import GestãoPessoas.Cliente;
import GestãoPessoas.Funcionario;

public interface GerenciamentoUsuario {

    // Métodos para gerenciamento de clientes
    void adicionarCliente(Cliente cliente);
    void removerCliente(String cpf);
    void editarCliente(Cliente clienteEditado);

    // Métodos para gerenciamento de funcionários
    void adicionarFuncionario(Funcionario funcionario);
    void removerFuncionario(String cpf);
    void editarFuncionario(Funcionario funcionarioEditado);
}
