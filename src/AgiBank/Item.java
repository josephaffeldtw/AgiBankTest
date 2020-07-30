package AgiBank;

public class Item {

    private String id;
    private int quantidade;
    private double preco;

    public Item(String id, int quantidade, double preco) {
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double precoTotal(){
        return 0;
    }

}
