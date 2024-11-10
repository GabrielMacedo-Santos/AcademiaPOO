package Loja;

/**
 * Classe que representa um produto no estoque.
 */
public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    /**
     * Construtor da classe Produto.
     * 
     * @param nome Nome do produto.
     * @param preco Preço do produto.
     * @param quantidade Quantidade disponível do produto.
     */
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    /**
     * Obtém o nome do produto.
     * 
     * @return Nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     * 
     * @param nome Novo nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o preço do produto.
     * 
     * @return Preço do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do produto.
     * 
     * @param preco Novo preço do produto.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Obtém a quantidade disponível do produto.
     * 
     * @return Quantidade disponível.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade disponível do produto.
     * 
     * @param quantidade Nova quantidade disponível.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Reduz a quantidade disponível do produto.
     * 
     * @param quantidade Quantidade a ser reduzida.
     */
    public void reduzirQuantidade(int quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
            System.out.println("Quantidade reduzida. Estoque atualizado.");
        } else {
            System.out.println("Quantidade insuficiente em estoque.");
        }
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", preço=" + preco + ", quantidade=" + quantidade + "]";
    }
}
