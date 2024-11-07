package GestaoPessoas;

import java.util.List;

public class Cliente extends Pessoa {

    private String plano;
    private double saldoDevedor;
    private int idCliente;

    public Cliente(String nome, String endereco, String telefone, String email, String cpf, String plano) {
        super(nome, endereco, telefone, email, cpf);
        this.plano = plano;
        this.saldoDevedor = 0;
        this.idCliente = gerarNovoIdCliente();
    }

    // Método para gerar um novo ID único para o cliente
    private static int gerarNovoIdCliente() {
        List<Cliente> clientes = json.JsonCliente.carregarClientes();

        // Encontrar o maior ID existente na lista de clientes
        int maxId = clientes.stream()
                .mapToInt(Cliente::getIdCliente)
                .max()
                .orElse(0); // Se a lista estiver vazia, começa do 0

        return maxId + 1; // Retorna o próximo ID único
    }

    // Getters e Setters
    public int getIdCliente() {
        return this.idCliente;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public double getSaldoDevedor() {
        return saldoDevedor;
    }

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
