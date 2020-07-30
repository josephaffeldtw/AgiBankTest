package Test;

import AgiBank.Item;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @org.junit.Test
    public void precoTotal() {
        Item it = new Item("1", 2, 3.0);
        assertEquals(6.0, it.precoTotal(), 0.0001 );
    }
}