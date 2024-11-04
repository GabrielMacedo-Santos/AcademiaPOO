package Loja;

import java.util.ArrayList;

public class GerenciarVenda {
    private Estoque estoque;
    private ArrayList<Venda> historicoVendas;

    public GerenciarVenda(Estoque estoque) {
        this.estoque = estoque;
        this.historicoVendas = new ArrayList<>();
    }

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

    public double calcularTotalVendas() {
        double total = 0;
        for (Venda venda : historicoVendas) {
            total += venda.getValorTotal();
        }
        return total;
    }
}
