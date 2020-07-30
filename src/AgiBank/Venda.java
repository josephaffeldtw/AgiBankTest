package AgiBank;

import java.util.ArrayList;

public class Venda {

    private static final String id = "003";
    private String idSale;
    private ArrayList<Item> itens;
    private Vendedor vendedor;

    public Venda(String idSale, ArrayList<Item> itens, Vendedor vendedor) {
        this.idSale = idSale;
        this.itens = itens;
        this.vendedor = vendedor;
    }

    public static String getId() {
        return id;
    }

    public String getIdSale() {
        return idSale;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setIdSale(String idSale) {
        this.idSale = idSale;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public double valorTotalDaVenda(){
        double valor = 0;
        for(Item it : itens){
            valor = valor + it.precoTotal();
        }
        return valor;
    }

    @Override
    public String toString() {
        return "\nIDVenda: " + this.idSale +
                "\nItens: " + this.itens +
                "\nVendedor: " + this.vendedor.getNome();
    }

}
