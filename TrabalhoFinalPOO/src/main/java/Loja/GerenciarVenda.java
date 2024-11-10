package Loja;

import java.util.ArrayList;

/**
 * Classe responsável por gerenciar vendas no sistema.
 */
public class GerenciarVenda {
    private Estoque estoque;
    private ArrayList<Venda> historicoVendas;

    /**
     * Construtor da classe GerenciarVenda.
     * 
     * @param estoque Estoque de produtos.
     */
    public GerenciarVenda(Estoque estoque) {
        this.estoque = estoque;
        this.historicoVendas = new ArrayList<>();
    }

    /**
     * Realiza uma venda de um produto.
     * 
     * @param nomeProduto Nome do produto a ser vendido.
     * @param quantidade Quantidade a ser vendida.
     */
    public void realizarVenda(String nomeProduto, int quantidade) {
        Produto produto = estoque.buscarProduto(nomeProduto);
        
        if (produto != null && estoque.verificarDisponibilidade(nomeProduto, quantidade)) {
            estoque.reduzirEstoque(nomeProduto, quantidade);
            Venda venda = new Venda(produto, quantidade);
            historicoVendas.add(venda);
            System.out.println("Venda realizada com sucesso: " + venda);
        } else {
            System.out.println("Venda não realizada. Produto indisponível ou quantidade insuficiente.");
        }
    }

    /**
     * Lista o histórico de vendas realizadas.
     */
    public void listarVendas() {
        if (historicoVendas.isEmpty()) {
            System.out.println("Nenhuma venda realizada até o momento.");
        } else {
            System.out.println("Histórico de Vendas:");
            for (Venda venda : historicoVendas) {
                System.out.println(venda);
            }
        }
    }

    /**
     * Calcula o valor total das vendas realizadas.
     * 
     * @return Valor total das vendas.
     */
    public double calcularTotalVendas() {
        double total = 0;
        for (Venda venda : historicoVendas) {
            total += venda.getValorTotal();
        }
        return total;
    }

    /**
     * Getter para o estoque associado a GerenciarVenda.
     * 
     * @return Estoque de produtos.
     */
    public Estoque getEstoque() {
        return estoque;
    }
}
