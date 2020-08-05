package AgiBank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcessaDados {

    private final static Logger looger = Logger.getLogger(ProcessaDados.class.getName());
    private ListaDeVendedores vendedores;
    private ListaDeClientes clientes;
    private ListaDeVendas vendas;

    public ProcessaDados(ListaDeVendedores vendedores, ListaDeClientes clientes, ListaDeVendas vendas) {
        this.vendedores = vendedores;
        this.clientes = clientes;
        this.vendas = vendas;
    }

    public void montaListaDeObjetos(ArrayList<String> dados) throws IOException {
        String[] s;
        Vendedor vendedor;
        Cliente cliente;
        Venda venda;

        for (String dado : dados) {
            s = dado.split("ç");

            if(s.length == 4){
                switch (s[0]) {
                    case "001":
                        double salario = Double.parseDouble(s[3]);
                        vendedor = new Vendedor(s[1], s[2], salario);
                        vendedores.adicionaVendedorNaLista(vendedor);
//                        looger.log(Level.INFO, "Criou vendedor " + vendedor.getNome() + " e adicionou na lista. ");
                        break;

                    case "002":
                        cliente = new Cliente(s[1], s[2], s[3]);
                        clientes.adicionaClienteNaLista(cliente);
//                        looger.log(Level.INFO, "Criou cliente " + cliente.getNome()+ " e adicionou na lista. ");

                        break;

                    case "003":
                        if( vendedores.buscaVendedorPeloNome(s[3]) != null ){
                            vendedor = vendedores.buscaVendedorPeloNome(s[3]);
                            venda = new Venda(s[1], vendas.criaListaDeItens(s[2]), vendedor);
                            vendas.adicionaVendaNaLista(venda);
//                        looger.log(Level.INFO, "Criou venda" + venda.getIdSale() + " e adicionou na lista. ");
                        }else{
                            looger.log(Level.INFO, "Vendedor não existe impossível criar venda");
                        }

                        break;

                    default:
                        break;
                }
            }
            else{
                looger.log(Level.WARNING, "Linha do arquivo de dados está em formato errado, não foi lida: ");
            }
        }
    }

    public String criaSaida(){
        looger.log(Level.INFO, "Criando saida...");
        return "Quantidade de Clientes: " + this.clientes.quantidadeDeClientes() +
                "\nQuantidade de Vendedores: " + this.vendedores.quantidadeDeVendedores() +
                "\nID venda mais cara: " + this.vendas.vendaMaisCara().toString() +
                "\nPior Vendedor: " + this.vendas.piorVendedor().toString();
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
