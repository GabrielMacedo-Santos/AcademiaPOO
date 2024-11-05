package SistemaDaAcademia;
import GestaoPessoas.Cliente;

public interface GerenciamentoCliente {

    // Método para adicionar um cliente
    void adicionarCliente(Cliente cliente);

    // Método para remover um cliente pelo CPF
    void removerCliente(String cpf);

    // Método para editar um cliente usando o CPF e novas informações
    void editarCliente(String cpf, String novoNome, String novoEndereco, String novoTelefone, String novoEmail, String novoPlano);

    // Método para listar todos os clientes
    void listarClientes();
}
