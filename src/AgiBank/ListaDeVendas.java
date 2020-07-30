package AgiBank;

import java.util.ArrayList;

public class ListaDeVendas {

    private ArrayList<Venda> vendas;

    public ListaDeVendas() {
        this.vendas = new ArrayList<Venda>();
    }

    public ArrayList<Venda> getVendas() {
        return this.vendas;
    }

    public int quantidadeDeVendas() {
        return this.vendas.size();
    }

    public boolean adicionaVendaNaLista(Venda venda) {
        return true;
    }

    public boolean buscaVendaPelaIdSale(String id) {
        return false;
    }

    public ArrayList<Item> criaListaDeItens(String itens) {
        return null;
    }

    public Item criaItemDaVenda(String item) {
        return null;
    }

    public boolean existeVenda() {
        return true;
    }

    public Venda vendaMaisCara() {
        return null;
    }

    public Vendedor piorVendedor() {
        return null;
    }

}
