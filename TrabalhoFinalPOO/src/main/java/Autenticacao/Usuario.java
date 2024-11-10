package Autenticacao;

/**
 * Classe abstrata para representar um usuário do sistema.
 */
public abstract class Usuario {
    private String usuario;
    private String senha;

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public boolean autenticar(String usuario, String senha) {
        return this.usuario.equals(usuario) && this.senha.equals(senha);
    }

    public boolean alterarSenha(String senhaAtual, String novaSenha) {
        if (this.senha.equals(senhaAtual)) {
            this.senha = novaSenha;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario='" + usuario + '\'' + '}';
    }
}
