package Loja;

import java.util.ArrayList;

/**
 * Classe abstrata responsável por gerenciar o estoque de produtos.
 */
public abstract class Estoque {
    protected ArrayList<Produto> produtos;

    /**
     * Construtor da classe Estoque.
     */
    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    /**
     * Adiciona um produto ao estoque.
     * 
     * @param produto Produto a ser adicionado.
     */
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto " + produto.getNome() + " adicionado ao estoque.");
    }

    /**
     * Remove um produto do estoque pelo nome.
     * 
     * @param nomeProduto Nome do produto a ser removido.
     */
    public void removerProduto(String nomeProduto) {
        Produto produto = buscarProduto(nomeProduto);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto " + nomeProduto + " removido do estoque.");
        } else {
            System.out.println("Produto " + nomeProduto + " não encontrado no estoque.");
        }
    }

    /**
     * Busca um produto no estoque pelo nome.
     * 
     * @param nomeProduto Nome do produto a ser buscado.
     * @return Produto encontrado ou null caso não encontrado.
     */
    public Produto buscarProduto(String nomeProduto) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return produto;
            }
        }
        System.out.println("Produto " + nomeProduto + " não encontrado no estoque.");
        return null;
    }

    /**
     * Lista todos os produtos disponíveis no estoque.
     */
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

    /**
     * Verifica se há disponibilidade de um produto com a quantidade desejada.
     * 
     * @param nomeProduto Nome do produto a ser verificado.
     * @param quantidade Quantidade desejada.
     * @return true se disponível, false caso contrário.
     */
    public boolean verificarDisponibilidade(String nomeProduto, int quantidade) {
        Produto produto = buscarProduto(nomeProduto);
        return produto != null && produto.getQuantidade() >= quantidade;
    }

    /**
     * Reduz a quantidade de um produto no estoque.
     * 
     * @param nomeProduto Nome do produto a ser reduzido.
     * @param quantidade Quantidade a ser reduzida.
     */
    public void reduzirEstoque(String nomeProduto, int quantidade) {
        Produto produto = buscarProduto(nomeProduto);
        if (produto != null) {
            produto.reduzirQuantidade(quantidade);
        }
    }
}
