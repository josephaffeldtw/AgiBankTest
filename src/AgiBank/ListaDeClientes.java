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
        return true;
    }

    public Cliente buscaClientePeloCNPJ(String cnpj) {
        return null;
    }

    public Cliente buscarClientePeloNome(String nome) {
        return null;
    }


}
