package GestãoPessoas;

public abstract class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
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