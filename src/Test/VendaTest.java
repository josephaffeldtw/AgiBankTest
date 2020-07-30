package Test;

import AgiBank.Item;
import AgiBank.Venda;
import AgiBank.Vendedor;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class VendaTest {

    @org.junit.Test
    public void valorTotalDaVenda() {
        ArrayList<Item> itens = new ArrayList<Item>();
        Item it1 = new Item("1", 2, 3.0);
        Item it2 = new Item("2", 3, 3.0);
        Item it3 = new Item("3", 4, 3.0);
        itens.add(it1);
        itens.add(it2);
        itens.add(it3);

        Vendedor vendedor = new Vendedor("02", "Jose", 2000);

        Venda venda = new Venda("03", itens, vendedor);

        assertEquals(27, venda.valorTotalDaVenda(), 0.00001);
    }
}