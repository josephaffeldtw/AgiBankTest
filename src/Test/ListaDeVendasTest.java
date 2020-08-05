package Test;

import AgiBank.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListaDeVendasTest {

    @Test
    public void quantidadeDeVendas() {
        ListaDeVendas lv = new ListaDeVendas();
        ArrayList<Item> itens = new ArrayList<Item>();
        Item it1 = new Item("1", 2, 3.0);
        Item it2 = new Item("2", 3, 3.0);
        Item it3 = new Item("3", 4, 3.0);
        itens.add(it1);
        itens.add(it2);
        itens.add(it3);
        Vendedor vendedor = new Vendedor("02", "Jose", 2000);
        Venda venda = new Venda("01", itens, vendedor);
        lv.adicionaVendaNaLista(venda);

        itens.clear();

        it1 = new Item("1", 5, 5.0);
        it2 = new Item("2", 4, 4.0);
        it3 = new Item("3", 3, 3.0);
        itens.add(it1);
        itens.add(it2);
        itens.add(it3);
        Vendedor vendedor2 = new Vendedor("03", "Joao", 3000);
        Venda venda2 = new Venda("02", itens, vendedor2);
        lv.adicionaVendaNaLista(venda2);

        assertEquals(2, lv.quantidadeDeVendas());
    }

    @Test
    public void adicionaVendaNaLista() {
        ListaDeVendas lv = new ListaDeVendas();
        ArrayList<Item> itens = new ArrayList<Item>();
        Item it1 = new Item("1", 2, 3.0);
        Item it2 = new Item("2", 3, 3.0);
        Item it3 = new Item("3", 4, 3.0);
        itens.add(it1);
        itens.add(it2);
        itens.add(it3);
        Vendedor vendedor = new Vendedor("02", "Jose", 2000);
        Venda venda = new Venda("01", itens, vendedor);

        assertEquals(true, lv.adicionaVendaNaLista(venda));
    }

    @Test
    public void adicionaVendaExistenteNaLista() {
        ListaDeVendas lv = new ListaDeVendas();
        ArrayList<Item> itens = new ArrayList<Item>();
        Item it1 = new Item("1", 2, 3.0);
        Item it2 = new Item("2", 3, 3.0);
        Item it3 = new Item("3", 4, 3.0);
        itens.add(it1);
        itens.add(it2);
        itens.add(it3);
        Vendedor vendedor = new Vendedor("02", "Jose", 2000);
        Venda venda = new Venda("01", itens, vendedor);
        lv.adicionaVendaNaLista(venda);
        Venda venda2 = new Venda ("01", itens, vendedor);

        assertEquals(false, lv.adicionaVendaNaLista(venda2));
    }

    @Test
    public void buscaVendaPelaIdSale() {
        ListaDeVendas lv = new ListaDeVendas();
        ArrayList<Item> itens = new ArrayList<Item>();
        Item it1 = new Item("1", 2, 3.0);
        Item it2 = new Item("2", 3, 3.0);
        Item it3 = new Item("3", 4, 3.0);
        itens.add(it1);
        itens.add(it2);
        itens.add(it3);
        Vendedor vendedor = new Vendedor("02", "Jose", 2000);
        Venda venda = new Venda("01", itens, vendedor);
        lv.adicionaVendaNaLista(venda);

        assertEquals(venda, lv.buscaVendaPelaIdSale("01"));
    }

    @Test
    public void buscaVendaNaoExistentePelaIdSale() {
        ListaDeVendas lv = new ListaDeVendas();
        assertNull(lv.buscaVendaPelaIdSale("01"));
    }

    @Test
    public void criaListaDeItens() {
        ListaDeVendas lv = new ListaDeVendas();
        ArrayList<Item> itens = new ArrayList<Item>();
        Item it1 = new Item("1", 2, 3.0);
        Item it2 = new Item("2", 3, 3.0);
        Item it3 = new Item("3", 4, 3.0);
        itens.add(it1);
        itens.add(it2);
        itens.add(it3);

        String str = "[1-2-3.0,2-3-3.0,3-4-3.0]";
        assertEquals(itens.toString(), lv.criaListaDeItens(str).toString());
    }

    @Test
    public void criaItemDaVenda() {
        ListaDeVendas lv = new ListaDeVendas();
        Item item = new Item("1", 2, 3.02);
        String str = "1-2-3.02";
        assertEquals(item.getId(), lv.criaItemDaVenda(str).getId());
    }

    @Test
    public void existeVenda() {
        ListaDeVendas lv = new ListaDeVendas();
        ArrayList<Item> itens = new ArrayList<Item>();
        Item it1 = new Item("1", 2, 3.0);
        Item it2 = new Item("2", 3, 3.0);
        Item it3 = new Item("3", 4, 3.0);
        itens.add(it1);
        itens.add(it2);
        itens.add(it3);
        Vendedor vendedor = new Vendedor("02", "Jose", 2000);
        Venda venda = new Venda("01", itens, vendedor);
        lv.adicionaVendaNaLista(venda);

        assertEquals(true, lv.existeVenda());
    }

    @Test
    public void vendaMaisCara() {
        ListaDeVendas lv = new ListaDeVendas();
        ArrayList<Item> itens = new ArrayList<Item>();
        Item it1 = new Item("1", 2, 3.0);
        Item it2 = new Item("2", 3, 3.0);
        Item it3 = new Item("3", 4, 3.0);
        itens.add(it1);
        itens.add(it2);
        itens.add(it3);
        Vendedor vendedor = new Vendedor("02", "Jose", 2000);
        Venda venda = new Venda("01", itens, vendedor);
        lv.adicionaVendaNaLista(venda);

        ArrayList<Item> itens2 = new ArrayList<Item>();

        it1 = new Item("1", 5, 5.0);
        it2 = new Item("2", 4, 4.0);
        it3 = new Item("3", 3, 3.0);
        itens2.add(it1);
        itens2.add(it2);
        itens2.add(it3);
        Vendedor vendedor2 = new Vendedor("03", "Joao", 3000);
        Venda venda2 = new Venda("02", itens2, vendedor2);
        lv.adicionaVendaNaLista(venda2);

        assertEquals(venda2, lv.vendaMaisCara());
    }

    @Test
    public void piorVenda() {
        ListaDeVendas lv = new ListaDeVendas();
        ArrayList<Item> itens = new ArrayList<Item>();
        Item it1 = new Item("1", 2, 3.0);
        Item it2 = new Item("2", 3, 3.0);
        Item it3 = new Item("3", 4, 3.0);
        itens.add(it1);
        itens.add(it2);
        itens.add(it3);
        Vendedor vendedor = new Vendedor("02", "Jose", 2000);
        Venda venda = new Venda("01", itens, vendedor);
        lv.adicionaVendaNaLista(venda);

        ArrayList<Item> itens2 = new ArrayList<Item>();

        it1 = new Item("1", 5, 5.0);
        it2 = new Item("2", 4, 4.0);
        it3 = new Item("3", 3, 3.0);
        itens2.add(it1);
        itens2.add(it2);
        itens2.add(it3);
        Vendedor vendedor2 = new Vendedor("03", "Joao", 3000);
        Venda venda2 = new Venda("02", itens2, vendedor2);
        lv.adicionaVendaNaLista(venda2);

        assertEquals(vendedor, lv.piorVenda());
    }
}