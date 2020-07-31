package AgiBank;

import java.util.ArrayList;

public class ProcessaDados {

    private ListaDeVendedores vendedores;
    private ListaDeClientes clientes;
    private ListaDeVendas vendas;

    public ProcessaDados() {
        this.vendedores = new ListaDeVendedores();
        this.clientes = new ListaDeClientes();
        this.vendas = new ListaDeVendas();
    }

    public void montaListaDeObjetos(ArrayList<String> dados){
        String[] s;
        Vendedor vendedor;
        Cliente cliente;
        Venda venda;

        for (String dado : dados) {
            s = dado.split("ç");

            switch (s[0]) {
                case "001":
                    double salario = Double.parseDouble(s[3]);
                    vendedor = new Vendedor(s[1], s[2], salario);
                    vendedores.adicionaVendedorNaLista(vendedor);
                    break;

                case "002":
                    cliente = new Cliente(s[1], s[2], s[3]);
                    clientes.adicionaClienteNaLista(cliente);
                    break;

                case "003":
                    vendedor = vendedores.buscaVendedorPeloNome(s[3]);
                    venda = new Venda(s[1], vendas.criaListaDeItens(s[2]), vendedor);
                    vendas.adicionaVendaNaLista(venda);
                    break;

                default:
                    break;
            }
        }
    }

    public String criaSaida(){
        return "\nQuantidade de Clientes: " + this.clientes.quantidadeDeClientes() +
                "\nQuantidade de Vendedores: " + this.vendedores.quantidadeDeVendedores() +
                "\nID venda mais cara: " + this.vendas.vendaMaisCara().getIdSale() +
                "\nPior Vendedor: " + this.vendas.piorVendedor().getNome();
    }

    public ListaDeVendas getListaDeVendas(){
        return this.vendas;
    }

    public ListaDeVendedores getListaDeVendedores(){
        return this.vendedores;
    }

    public ListaDeClientes getListaDeClientes(){
        return this.clientes;
    }
}
