package AgiBank;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaDeClientes {

    private ArrayList<Cliente> clientes;
    private final static Logger looger = Logger.getLogger(ListaDeClientes.class.getName());

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
        if (buscaClientePeloCNPJ(cliente.getCnpj()) != null) {
            looger.log(Level.WARNING, "CNPJ já existente, não é possível criar dois clientes com o mesmo CNPJ");
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
