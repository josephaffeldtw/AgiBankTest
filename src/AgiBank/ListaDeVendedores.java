package AgiBank;

import java.util.ArrayList;

public class ListaDeVendedores {

    private ArrayList<Vendedor> vendedores;

    public ListaDeVendedores() {
        this.vendedores = new ArrayList<Vendedor>();
    }

    public ArrayList<Vendedor> getListaDeVendedores() {
        return this.vendedores;
    }

    public int quantidadeDeVendedores(){
        return this.vendedores.size();
    }

    public boolean adicionaVendedorNaLista(Vendedor vendedor) {
        return true;
    }

    public Vendedor buscaVendedorPeloNome(String nome) {
        return null;
    }

    public Vendedor buscaVendedorPeloCPF(String cpf) {
        return null;
    }
}
