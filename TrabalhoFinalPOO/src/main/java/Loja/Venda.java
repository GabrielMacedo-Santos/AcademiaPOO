package Loja;

public class Venda {
    private Produto produto;
    private int quantidadeVendida;
    private double valorTotal;

    public Venda(Produto produto, int quantidadeVendida) {
        this.produto = produto;
        this.quantidadeVendida = quantidadeVendida;
        this.valorTotal = produto.getPreco() * quantidadeVendida;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Produto: " + produto.getNome() + ", Quantidade: " + quantidadeVendida + ", Valor Total: R$" + valorTotal;
    }
}
