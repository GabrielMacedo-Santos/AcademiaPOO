package SistemaDaAcademia;
import GestãoPessoas.Cliente;
public interface GerenciamentoUsuario {

    // Método para exibir os dados do usuário
    void exibirDados();

    // Método para atualizar informações básicas do usuário
    void atualizarInformacoes(String nome, String endereco, String telefone, String email);

    // Método para definir permissões e funções do usuário, aplicável a Administrador e Funcionario
    void definirPermissao(String permissao);

    // Método para definir o plano ou cargo do usuário, aplicável a Cliente e Funcionario
    void definirPlanoOuCargo(String planoOuCargo);

    // Método para listar todos os usuários cadastrados (apenas aplicável ao Administrador)
    void listarUsuarios();

    // Método para exibir o histórico de atividades do usuário (reservas, pagamentos, etc.)
    void exibirHistorico();

    // Métodos exclusivos para o Administrador para gerenciar clientes
    void adicionarCliente(Cliente cliente);
    void removerCliente(String cpf);
    void editarCliente(String cpf, String novoNome, String novoEndereco, String novoTelefone, String novoEmail, String novoPlano);
}
