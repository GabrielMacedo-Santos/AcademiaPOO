package SistemaDaAcademia;

import GestaoPessoas.Cliente;
import Loja.Produto;

/**
 * Classe que gerencia os contadores de instâncias de Cliente e Produto.
 */
public class Sistema {

    private static int contadorClientesEncapsulado = 0;
    protected static int contadorClientesProtected = 0;
    private static int contadorProdutos = 0;

    /**
     * Obtém o contador de clientes encapsulado.
     * 
     * @return o número de clientes
     */
    public static int getContadorClientesEncapsulado() {
        return contadorClientesEncapsulado;
    }

    /**
     * Incrementa o contador de clientes encapsulado.
     */
    public static void incrementarContadorClientesEncapsulado() {
        contadorClientesEncapsulado++;
    }

    /**
     * Obtém o contador de clientes com acesso protected.
     * 
     * @return o número de clientes
     */
    public static int getContadorClientesProtected() {
        return contadorClientesProtected;
    }

    /**
     * Incrementa o contador de clientes com acesso protected.
     */
    public static void incrementarContadorClientesProtected() {
        contadorClientesProtected++;
    }

    /**
     * Obtém o contador de produtos.
     * 
     * @return o número de produtos
     */
    public static int getContadorProdutos() {
        return contadorProdutos;
    }

    /**
     * Incrementa o contador de produtos.
     */
    public static void incrementarContadorProdutos() {
        contadorProdutos++;
    }

    /**
     * Retorna a quantidade total de instâncias de Cliente e Produto.
     * 
     * @return uma string com os contadores formatados
     */
    public static String getTotalInstancias() {
        return "Clientes (Encapsulado): " + contadorClientesEncapsulado + 
               "\nClientes (Protected): " + contadorClientesProtected +
               "\nProdutos: " + contadorProdutos;
    }
}
