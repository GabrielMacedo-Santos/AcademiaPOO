package GestaoPessoas;

public abstract class Pessoa {
    // Atributos
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;


    // Construtor
    public Pessoa(String nome, String endereco, String telefone, String email, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    // Métodos Getters
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

    // Métodos Setters
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

    public abstract void exibirDados();

    @Override
    public String toString() {
        return "Nome: " + nome + "\nEndereço: " + endereco + "\nTelefone: " + telefone + "\nEmail: " + email;
    }

    public boolean logar(String usuario, String senha) {
        return false;
    }
}
