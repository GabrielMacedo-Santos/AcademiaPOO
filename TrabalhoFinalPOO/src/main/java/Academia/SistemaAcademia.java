package Academia;

import GestaoPessoas.Administrador;
import GestaoPessoas.Cliente;
import GestaoPessoas.Funcionario;
import json.JsonCliente;
import json.JsonFuncionario;
import json.JsonAdministrador;

import java.util.ArrayList;
import java.util.List;

public class SistemaAcademia {

    public static void main(String[] args) {
        // Criação de alguns clientes de exemplo
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("João Silva", "Rua A", "12345678", "joao@example.com", "111.111.111-11", "Premium"));
        clientes.add(new Cliente("Maria Souza", "Rua B", "87654321", "maria@example.com", "222.222.222-22", "Standard"));

        // Salvar os clientes no arquivo JSON
        JsonCliente.salvarClientes(clientes);

        // Carregar e exibir clientes salvos no JSON
        List<Cliente> clientesCarregados = JsonCliente.carregarClientes();
        System.out.println("Clientes carregados:");
        for (Cliente cliente : clientesCarregados) {
            System.out.println(cliente);
        }

        // Criação de alguns funcionários de exemplo
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Gabriel", "Endereço Func 1", "123", "gabriel@email.com", "12345678900", "1", "Instrutor"));
        funcionarios.add(new Funcionario("Ana", "Endereço Func 2", "456", "ana@email.com", "09876543211", "2", "Recepcionista"));

        // Salvar os funcionários no arquivo JSON
        JsonFuncionario.salvarFuncionario(funcionarios);

        // Carregar e exibir funcionários salvos no JSON
        List<Funcionario> funcionariosCarregados = JsonFuncionario.carregar();
        System.out.println("\nFuncionários carregados:");
        for (Funcionario funcionario : funcionariosCarregados) {
            System.out.println(funcionario);
        }

        // Criação de alguns administradores de exemplo
        List<Administrador> administradores = new ArrayList<>();
        administradores.add(new Administrador("Luis", "Endereço Adm 1", "789", "luis@email.com", "12345678900", "3", "Adm"));
        administradores.add(new Administrador("Pedro", "Endereço Adm 2", "012", "pedro@email.com", "11223344556", "4", "Adm"));

        // Salvar os administradores no arquivo JSON
        JsonAdministrador.salvarAdministradores(administradores);

        // Carregar e exibir administradores salvos no JSON
        List<Administrador> administradoresCarregados = JsonAdministrador.carregar();
        System.out.println("\nAdministradores carregados:");
        for (Administrador administrador : administradoresCarregados) {
            System.out.println(administrador);
        }
    }
}
