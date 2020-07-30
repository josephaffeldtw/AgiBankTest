package AgiBank;

import java.util.ArrayList;

public class ListaDeClientes {

    private ArrayList<Cliente> clientes;

    public ListaDeClientes() {
        this.clientes = new ArrayList<Cliente>();
    }

    public ArrayList<Cliente> getListaDeClientes() {
        return this.clientes;
    }

    public int quantidadeDeClientes(){
        return this.clientes.size();
    }

    public boolean adicionaClienteNaLista(Cliente cliente) {
        System.out.println(cliente.toString());
        if (buscaClientePeloCNPJ(cliente.getCnpj()) != null) {
            return false;
        } else {
            clientes.add(cliente);
        }
        return true;
    }

    public Cliente buscaClientePeloCNPJ(String cnpj) {
        for (Cliente cliente : clientes) {
            if (cliente.getCnpj().equals(cnpj)) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente buscarClientePeloNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }
}
