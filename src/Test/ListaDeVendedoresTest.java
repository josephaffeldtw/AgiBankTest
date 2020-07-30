package Test;

import AgiBank.ListaDeVendedores;
import AgiBank.Vendedor;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListaDeVendedoresTest {

    @Test
    public void quantidadeDeVendedores() {
        ListaDeVendedores lv = new ListaDeVendedores();
        Vendedor vendedor1 = new Vendedor("01", "Jose", 2000);
        Vendedor vendedor2 = new Vendedor("02", "Josue", 3000);
        Vendedor vendedor3 = new Vendedor("03", "Josi", 4000);
        lv.adicionaVendedorNaLista(vendedor1);
        lv.adicionaVendedorNaLista(vendedor2);
        lv.adicionaVendedorNaLista(vendedor3);

        assertEquals(3, lv.quantidadeDeVendedores());
    }

    @Test
    public void adicionaVendedorNaLista() {
        ListaDeVendedores lv = new ListaDeVendedores();
        Vendedor vendedor1 = new Vendedor("01", "Jose", 2000);
        assertEquals(true, lv.adicionaVendedorNaLista(vendedor1));
    }

    @Test
    public void adicionaVendedorExistenteNaLista() {
        ListaDeVendedores lv = new ListaDeVendedores();
        Vendedor vendedor1 = new Vendedor("01", "Jose", 2000);
        lv.adicionaVendedorNaLista(vendedor1);
        Vendedor vendedor2 = new Vendedor("01", "Jose", 2000);
        assertEquals(false, lv.adicionaVendedorNaLista(vendedor2));
    }

    @Test
    public void buscaVendedorPeloNome() {
        ListaDeVendedores lv = new ListaDeVendedores();
        Vendedor vendedor1 = new Vendedor("01", "Jose", 2000);
        lv.adicionaVendedorNaLista(vendedor1);
        assertEquals(vendedor1, lv.buscaVendedorPeloNome("Jose"));
    }

    @Test
    public void buscaVendedorQueNaoExistePeloNome() {
        ListaDeVendedores lv = new ListaDeVendedores();
        assertNull(lv.buscaVendedorPeloNome("Jose"));
    }

    @Test
    public void buscaVendedorPeloCPF() {
        ListaDeVendedores lv = new ListaDeVendedores();
        Vendedor vendedor1 = new Vendedor("01", "Jose", 2000);
        lv.adicionaVendedorNaLista(vendedor1);
        assertEquals(vendedor1, lv.buscaVendedorPeloCPF("01"));
    }

    @Test
    public void buscaVendedorQueNaoExistePeloCPF() {
        ListaDeVendedores lv = new ListaDeVendedores();
        assertNull(lv.buscaVendedorPeloCPF("01"));
    }
}