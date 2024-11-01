package GestãoPessoas;

import Loja.Estoque;
import Loja.Produto;
import java.util.ArrayList;

public class Administrador extends Funcionario {

    private Estoque estoque;

    public Administrador(String nome, String endereco, String telefone, String email, String cpf, String idFuncionario, String cargo) {
        super(nome, endereco, telefone, email, cpf, idFuncionario, cargo);
        this.estoque = new Estoque();
    }

    // Métodos para gerenciar produtos
    public void adicionarProduto(Produto produto) {
        estoque.adicionarProduto(produto);
    }

    public void removerProduto(String nomeProduto) {
        estoque.removerProduto(nomeProduto);
    }

    public void listarProdutos() {
        estoque.listarProdutos();
    }

    public void verificarEstoqueProduto(String nomeProduto) {
        Produto produto = estoque.buscarProduto(nomeProduto);
        if (produto != null && produto.verificarEstoque()) {
            System.out.println("Produto " + nomeProduto + " está disponível em estoque.");
        } else {
            System.out.println("Produto " + nomeProduto + " não está disponível.");
        }

    }

    @Override
    public void exibirDados() {
        super.exibirDados(); // Chama o método da superclasse
        System.out.println("Gerenciador de Funcionários e Clientes.");
    }
}
