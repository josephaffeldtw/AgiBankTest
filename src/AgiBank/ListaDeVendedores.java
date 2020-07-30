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
        if (buscaVendedorPeloCPF(vendedor.getCpf()) != null) {
            return false;
        } else {
            vendedores.add(vendedor);
        }
        return true;
    }

    public Vendedor buscaVendedorPeloNome(String nome) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNome().equals(nome)) {
                return vendedor;
            }
        }
        return null;
    }

    public Vendedor buscaVendedorPeloCPF(String cpf) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getCpf().equals(cpf)) {
                return vendedor;
            }
        }
        return null;
    }
}
