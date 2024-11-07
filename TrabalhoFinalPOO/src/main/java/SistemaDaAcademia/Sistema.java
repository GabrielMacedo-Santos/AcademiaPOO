package SistemaDaAcademia;

import GestaoPessoas.Cliente;
import Loja.Produto;

public class Sistema {
    
    // Variável com encapsulamento private e métodos get/set
    private static int contadorClientesEncapsulado = 0;
    
    // Variável com acesso protected
    protected static int contadorClientesProtected = 0;

    // Contador de produtos
    private static int contadorProdutos = 0;

    // Métodos de contagem encapsulados
    public static int getContadorClientesEncapsulado() {
        return contadorClientesEncapsulado;
    }

    public static void incrementarContadorClientesEncapsulado() {
        contadorClientesEncapsulado++;
    }

    // Métodos de contagem com acesso protected
    public static int getContadorClientesProtected() {
        return contadorClientesProtected;
    }

    public static void incrementarContadorClientesProtected() {
        contadorClientesProtected++;
    }

    // Métodos de contagem de produtos
    public static int getContadorProdutos() {
        return contadorProdutos;
    }

    public static void incrementarContadorProdutos() {
        contadorProdutos++;
    }

    // Método para retornar a quantidade total de instâncias de Cliente e Produto
    public static String getTotalInstancias() {
        return "Clientes (Encapsulado): " + contadorClientesEncapsulado + 
               "\nClientes (Protected): " + contadorClientesProtected +
               "\nProdutos: " + contadorProdutos;
    }
}
