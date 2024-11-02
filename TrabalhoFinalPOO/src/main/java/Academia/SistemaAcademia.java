package Academia;

import GestaoPessoas.Cliente;
import GestaoPessoas.Funcionario;
import json.JsonCliente;
import json.JsonFuncionario;

import java.util.ArrayList;
import java.util.List;

public class SistemaAcademia {

    public static void main(String[] args) {
        // Criação de alguns clientes de exemplo
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("João Silva", "Rua A", "12345678", "joao@example.com", "111.111.111-11", "Premium"));
        clientes.add(new Cliente("Maria Oliveira", "Rua B", "87654321", "maria@example.com", "222.222.222-22", "Basic"));

        // Salvar os clientes no arquivo JSON
        JsonCliente.salvarClientes(clientes);
        
        // Criação de alguns funcionarios de exemplo
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Gabriel", "teste", "123", "teste@email.com", "123", "1", "Adm"));
        funcionarios.add(new Funcionario("Luis", "teste", "123", "teste@email.com", "123", "1", "professor"));

        // Salvar os clientes no arquivo JSON
        JsonFuncionario.salvarFuncionario(funcionarios);
    }
}
