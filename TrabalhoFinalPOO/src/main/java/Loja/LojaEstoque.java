package Loja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LojaEstoque {
    private List<Produto> produtos; // Lista para armazenar produtos no estoque

    public LojaEstoque() {
        this.produtos = new ArrayList<>();
    }

    // Método para adicionar um produto ao estoque
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto " + produto.getNome() + " adicionado ao estoque.");
    }

    // Método para remover um produto do estoque
    public void removerProduto(String nomeProduto) {
        Produto produtoEncontrado = null;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                produtoEncontrado = produto;
                break;
            }
        }
        if (produtoEncontrado != null) {
            produtos.remove(produtoEncontrado);
            System.out.println("Produto " + nomeProduto + " removido do estoque.");
        } else {
            System.out.println("Produto " + nomeProduto + " não encontrado no estoque.");
        }
    }

    // Método para listar todos os produtos no estoque
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto no estoque.");
        } else {
            System.out.println("Lista de Produtos no Estoque:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    // Método de gerenciamento do estoque
    public void gerenciarEstoque(Scanner scanner) {
        System.out.println("\n=== Gerenciamento de Estoque ===");
        System.out.println("1. Adicionar Produto");
        System.out.println("2. Remover Produto");
        System.out.println("3. Listar Produtos");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        switch (opcao) {
            case 1:
                System.out.print("Nome do Produto: ");
                String nome = scanner.nextLine();
                System.out.print("Preço do Produto: ");
                double preco = scanner.nextDouble();
                System.out.print("Quantidade em Estoque: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                Produto produto = new Produto(nome, preco, quantidade);
                adicionarProduto(produto);
                break;
            case 2:
                System.out.print("Nome do Produto a remover: ");
                String nomeProduto = scanner.nextLine();
                removerProduto(nomeProduto);
                break;
            case 3:
                listarProdutos();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
