package AgiBank;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaDeVendedores {

    private ArrayList<Vendedor> vendedores;
    private final static Logger looger = Logger.getLogger(ListaDeVendedores.class.getName());

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
            looger.log(Level.WARNING, "CPFjá existente, não é possível criar dois vendedores com o mesmo CNPJ");
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

    public boolean existeVendedores() {
        return (vendedores.size() > 0) ? true : false;
    }

    public Vendedor vendedorQueMenosVendeu(){
        double valor = 0;
        Vendedor vendedor = null;

        if(existeVendedores()){
            if (vendedores.size() == 1) {
                return vendedores.get(0);
            } else {
                valor = vendedores.get(0).getTotalDeLucroGerado();
                vendedor = vendedores.get(0);

                for (int i = 1; i < vendedores.size(); i++) {
                    if (vendedores.get(i).getTotalDeLucroGerado() < valor) {
                        valor = vendedores.get(i).getTotalDeLucroGerado();
                        vendedor = vendedores.get(i);
                    }
                }
            }
        }
        return vendedor;
    }
}
