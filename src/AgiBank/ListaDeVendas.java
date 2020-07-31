package AgiBank;

import java.util.ArrayList;

public class ListaDeVendas {

    private ArrayList<Venda> vendas;

    public ListaDeVendas() {
        this.vendas = new ArrayList<Venda>();
    }

    public ArrayList<Venda> getListaDeVendas() {
        return this.vendas;
    }

    public int quantidadeDeVendas() {
        return this.vendas.size();
    }

    public boolean adicionaVendaNaLista(Venda venda) {
        if (buscaVendaPelaIdSale(venda.getIdSale()) != null) {
            return false;
        } else {
            vendas.add(venda);
        }
        return true;
    }

    public Venda buscaVendaPelaIdSale(String id) {
        for (Venda venda : vendas) {
            if (venda.getIdSale().equals(id)) {
                return venda;
            }
        }
        return null;
    }

    public ArrayList<Item> criaListaDeItens(String itens) {
        ArrayList<Item> listaDeItens = new ArrayList<Item>();
        String[] subString = itens.substring(1, itens.length() - 1).split(",");
        for (int i = 0; i < subString.length; i++) {
            listaDeItens.add(criaItemDaVenda(subString[i]));
        }
        return listaDeItens;
    }

    public Item criaItemDaVenda(String item) {
        String[] str = item.split("-");
        int quantidade = Integer.parseInt(str[1]);
        double preco = Double.parseDouble(str[2]);
        Item it = new Item(str[0], quantidade, preco);
        return it;
    }

    public boolean existeVenda() {
        return (vendas.size() > 0) ? true : false;
    }

    public Venda vendaMaisCara() {
        double maiorVenda = 0;
        Venda v = null;
        if (existeVenda()) {
            for (Venda venda : vendas) {
                if (venda.valorTotalDaVenda() > maiorVenda) {
                    maiorVenda = venda.valorTotalDaVenda();
                    v = venda;
                }
            }
        }
        return v;
    }

    public Vendedor piorVendedor() {
        double menorVenda;
        Vendedor vendedor = null;
        if (existeVenda()) {
            if (vendas.size() == 1) {
                return vendas.get(0).getVendedor();
            } else {
                menorVenda = vendas.get(0).valorTotalDaVenda();
                vendedor = vendas.get(0).getVendedor();
                for (int i = 1; i < vendas.size(); i++) {
                    if (vendas.get(i).valorTotalDaVenda() < menorVenda) {
                        menorVenda = vendas.get(i).valorTotalDaVenda();
                        vendedor = vendas.get(i).getVendedor();
                    }
                }
            }
        }
        return vendedor;
    }

}
