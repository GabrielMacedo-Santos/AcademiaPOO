package GestaoPessoas;

/**
 * Classe abstrata que representa uma pessoa no sistema.
 */
public abstract class Pessoa {

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;

    /**
     * Construtor para inicializar os atributos de uma pessoa.
     *
     * @param nome     Nome da pessoa.
     * @param endereco Endereço da pessoa.
     * @param telefone Telefone da pessoa.
     * @param email    Email da pessoa.
     * @param cpf      CPF da pessoa.
     */
    public Pessoa(String nome, String endereco, String telefone, String email, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Exibe os dados da pessoa.
     */
    public abstract void exibirDados();

    @Override
    public String toString() {
        return "Nome: " + nome + "\nEndereço: " + endereco + "\nTelefone: " + telefone + "\nEmail: " + email;
    }
}
