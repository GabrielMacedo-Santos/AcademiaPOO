package GestaoPessoas;

import java.util.List;

/**
 * Classe que representa um cliente no sistema.
 */
public class Cliente extends Pessoa {

    private String plano;
    private double saldoDevedor;
    private int idCliente;

    /**
     * Construtor para inicializar os atributos de um cliente.
     *
     * @param nome     Nome do cliente.
     * @param endereco Endereço do cliente.
     * @param telefone Telefone do cliente.
     * @param email    Email do cliente.
     * @param cpf      CPF do cliente.
     * @param plano    Plano do cliente.
     */
    public Cliente(String nome, String endereco, String telefone, String email, String cpf, String plano) {
        super(nome, endereco, telefone, email, cpf);
        this.plano = plano;
        this.saldoDevedor = 0;
        this.idCliente = gerarNovoIdCliente();
    }

    /**
     * Método para gerar um novo ID único para o cliente.
     *
     * @return Novo ID único.
     */
    private static int gerarNovoIdCliente() {
        List<Cliente> clientes = json.JsonCliente.carregarClientes();
        return clientes.stream()
                .mapToInt(Cliente::getIdCliente)
                .max()
                .orElse(0) + 1;
    }

    /**
     * Obtém o ID do cliente.
     *
     * @return ID do cliente.
     */
    public int getIdCliente() {
        return this.idCliente;
    }

    /**
     * Obtém o plano do cliente.
     *
     * @return Plano do cliente.
     */
    public String getPlano() {
        return plano;
    }

    /**
     * Define o plano do cliente.
     *
     * @param plano Novo plano do cliente.
     */
    public void setPlano(String plano) {
        this.plano = plano;
    }

    /**
     * Obtém o saldo devedor do cliente.
     *
     * @return Saldo devedor do cliente.
     */
    public double getSaldoDevedor() {
        return saldoDevedor;
    }

    /**
     * Define o saldo devedor do cliente.
     *
     * @param saldoDevedor Novo saldo devedor.
     */
    public void setSaldoDevedor(double saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }

    @Override
    public void exibirDados() {
        System.out.println("ID Cliente: " + idCliente);
        System.out.println("Nome: " + super.getNome());
        System.out.println("Endereço: " + super.getEndereco());
        System.out.println("Telefone: " + super.getTelefone());
        System.out.println("Email: " + super.getEmail());
        System.out.println("CPF: " + super.getCpf());
        System.out.println("Plano: " + plano);
        System.out.println("Saldo Devedor: R$ " + saldoDevedor);
    }
}
