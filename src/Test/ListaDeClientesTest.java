package Test;

import AgiBank.Cliente;
import AgiBank.ListaDeClientes;
import AgiBank.ListaDeVendedores;
import AgiBank.Vendedor;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListaDeClientesTest {

    @Test
    public void quantidadeDeClientes() {
        ListaDeClientes lc = new ListaDeClientes();
        Cliente cliente1 = new Cliente("01", "Joao", "Rural");
        Cliente cliente2 = new Cliente("02", "Jose", "TI");
        Cliente cliente3 = new Cliente("03", "Lucas", "Marketing");

        lc.adicionaClienteNaLista(cliente1);
        lc.adicionaClienteNaLista(cliente2);
        lc.adicionaClienteNaLista(cliente3);

        assertEquals(3, lc.quantidadeDeClientes());
    }

    public void quantidadeDeClientesAdicionandoExistente() {
        ListaDeClientes lc = new ListaDeClientes();
        Cliente cliente1 = new Cliente("01", "Joao", "Rural");
        Cliente cliente2 = new Cliente("02", "Jose", "TI");
        Cliente cliente3 = new Cliente("03", "Lucas", "Marketing");
        Cliente cliente4 = new Cliente("03", "Lucas", "Marketing");

        lc.adicionaClienteNaLista(cliente1);
        lc.adicionaClienteNaLista(cliente2);
        lc.adicionaClienteNaLista(cliente3);
        lc.adicionaClienteNaLista(cliente4);

        assertEquals(3, lc.quantidadeDeClientes());
    }

    @Test
    public void adicionaClienteNaLista() {
        ListaDeClientes lc = new ListaDeClientes();
        Cliente cliente1 = new Cliente("01", "Joao", "Rural");
        assertEquals(true, lc.adicionaClienteNaLista(cliente1));
    }

    @Test
    public void adicionaClienteJaExistenteNaLista() {
        ListaDeClientes lc = new ListaDeClientes();
        Cliente cliente1 = new Cliente("01", "Joao", "Rural");
        Cliente cliente2 = new Cliente("01", "Joao", "Rural");
        lc.adicionaClienteNaLista(cliente1);
        assertEquals(false, lc.adicionaClienteNaLista(cliente2));
    }

    @Test
    public void buscaClientePeloCNPJ() {
        ListaDeClientes lc = new ListaDeClientes();
        Cliente cliente1 = new Cliente("01", "Joao", "Rural");
        lc.adicionaClienteNaLista(cliente1);
        assertEquals(cliente1, lc.buscaClientePeloCNPJ("01"));
    }

    @Test
    public void buscaClienteQueNaoExistePeloCNPJ() {
        ListaDeClientes lc = new ListaDeClientes();
        assertNull(lc.buscaClientePeloCNPJ("01"));
    }

    @Test
    public void buscarClientePeloNome() {
        ListaDeClientes lc = new ListaDeClientes();
        Cliente cliente1 = new Cliente("02", "José", "Rural");
        lc.adicionaClienteNaLista(cliente1);
        assertEquals(cliente1, lc.buscarClientePeloNome("José"));
    }

    @Test
    public void buscarClienteQueNaoExistePeloNome() {
        ListaDeClientes lc = new ListaDeClientes();
        assertNull(lc.buscarClientePeloNome("José"));
    }
}