package Loja;

/**
 * Classe que representa uma venda realizada no sistema.
 */
public class Venda {
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    /**
     * Construtor da classe Venda.
     * 
     * @param produto Produto vendido.
     * @param quantidade Quantidade vendida.
     */
    public Venda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = produto.getPreco() * quantidade;
    }

    /**
     * Obtém o produto vendido.
     * 
     * @return Produto vendido.
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Define o produto vendido.
     * 
     * @param produto Novo produto vendido.
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * Obtém a quantidade vendida.
     * 
     * @return Quantidade vendida.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade vendida.
     * 
     * @param quantidade Nova quantidade vendida.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Obtém o valor total da venda.
     * 
     * @return Valor total da venda.
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * Define o valor total da venda.
     * 
     * @param valorTotal Novo valor total da venda.
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Venda [produto=" + produto.getNome() + ", quantidade=" + quantidade + ", valor total=" + valorTotal + "]";
    }
}
