package Loja;

import java.util.ArrayList;

public class Estoque {
    private ArrayList<Produto> produtos;

    public Estoque() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto " + produto.getNome() + " adicionado ao estoque.");
    }

    public void removerProduto(String nomeProduto) {
        Produto produto = buscarProduto(nomeProduto);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto " + nomeProduto + " removido do estoque.");
        } else {
            System.out.println("Produto " + nomeProduto + " não encontrado no estoque.");
        }
    }

    public Produto buscarProduto(String nomeProduto) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return produto;
            }
        }
        System.out.println("Produto " + nomeProduto + " não encontrado no estoque.");
        return null;
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            System.out.println("Produtos no estoque:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    public boolean verificarDisponibilidade(String nomeProduto, int quantidade) {
        Produto produto = buscarProduto(nomeProduto);
        if (produto != null && produto.getQuantidade() >= quantidade) {
            return true;
        } else {
            System.out.println("Produto " + nomeProduto + " com quantidade insuficiente no estoque.");
            return false;
        }
    }

    public void reduzirEstoque(String nomeProduto, int quantidade) {
        Produto produto = buscarProduto(nomeProduto);
        if (produto != null) {
            produto.reduzirQuantidade(quantidade);
            System.out.println("Quantidade atualizada para o produto " + produto.getNome() + ": " + produto.getQuantidade());
        }
    }
}
