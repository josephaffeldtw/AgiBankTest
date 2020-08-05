package Test;

import AgiBank.*;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProcessaDadosTest {

    @Test
    public void montaObjetoCliente() throws IOException {
        ListaDeVendedores vendedores = new ListaDeVendedores();
        ListaDeClientes clientes = new ListaDeClientes();
        ListaDeVendas vendas = new ListaDeVendas();
        ProcessaDados pd = new ProcessaDados(vendedores, clientes, vendas);
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("001ç1234567891234çPedroç50000");
        dados.add("002ç1234123412312331çJamilçRural");
        dados.add("002ç2345675434544345çJose da SilvaçRural");
        dados.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");

        pd.montaListaDeObjetos(dados);

        assertEquals(2, pd.getListaDeClientes().quantidadeDeClientes());
    }

    @Test
    public void montaObjetoVendedor() throws IOException {
        ListaDeVendedores vendedores = new ListaDeVendedores();
        ListaDeClientes clientes = new ListaDeClientes();
        ListaDeVendas vendas = new ListaDeVendas();
        ProcessaDados pd = new ProcessaDados(vendedores, clientes, vendas);
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("001ç9876543216542çPauloç50000");
        dados.add("001ç1234567891234çPedroç50000");
        dados.add("001ç7894562354651çPedroç50000");
        dados.add("002ç1234123412312331çJamilçRural");
        dados.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");
        pd.montaListaDeObjetos(dados);

        assertEquals(3, pd.getListaDeVendedores().quantidadeDeVendedores());
    }

    @Test
    public void montaObjetoVendas() throws IOException {
        ListaDeVendedores vendedores = new ListaDeVendedores();
        ListaDeClientes clientes = new ListaDeClientes();
        ListaDeVendas vendas = new ListaDeVendas();
        ProcessaDados pd = new ProcessaDados(vendedores, clientes, vendas);
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("001ç1234567891234çPedroç50000");
        dados.add("002ç2345675434544345çJose da SilvaçRural");
        dados.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");

        ArrayList<Item> itens = new ArrayList<Item>();
        Item it1 = new Item("1", 2, 3.0);
        Item it2 = new Item("2", 3, 3.0);
        Item it3 = new Item("3", 4, 3.0);
        itens.add(it1);
        itens.add(it2);
        itens.add(it3);
        Vendedor vendedor = new Vendedor("02", "Jose", 2000);
        Venda venda = new Venda("01", itens, vendedor);

        pd.montaListaDeObjetos(dados);

        assertEquals(1, pd.getListaDeVendas().quantidadeDeVendas());
    }

    @Test
    public void criaSaida() throws IOException {
        ListaDeVendedores vendedores = new ListaDeVendedores();
        ListaDeClientes clientes = new ListaDeClientes();
        ListaDeVendas vendas = new ListaDeVendas();
        ProcessaDados pd = new ProcessaDados(vendedores, clientes, vendas);
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("001ç1234567891234çPedroç50000");
        dados.add("001ç3245678865434çPauloç40000.99");
        dados.add("002ç2345675434544345çJose da SilvaçRural");
        dados.add("002ç2345675433444345çEduardo PereiraçRural");
        dados.add("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro");
        dados.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");

        pd.montaListaDeObjetos(dados);

        String str = "Quantidade de Clientes: 2" +
                "\nQuantidade de Vendedores: 2" +
                "\nID venda mais cara: 10" +
                "\nPior Vendedor: Paulo";
        assertEquals(str, pd.criaSaida());
    }
}