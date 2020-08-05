package Test;

import AgiBank.*;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
    public void quantidadeDeVendedoresAdicionandoExistente() {
        ListaDeVendedores lv = new ListaDeVendedores();
        Vendedor vendedor1 = new Vendedor("01", "Jose", 2000);
        Vendedor vendedor2 = new Vendedor("02", "Josue", 3000);
        Vendedor vendedor3 = new Vendedor("03", "Josi", 4000);
        Vendedor vendedor4 = new Vendedor("03", "Josi", 4000);
        lv.adicionaVendedorNaLista(vendedor1);
        lv.adicionaVendedorNaLista(vendedor2);
        lv.adicionaVendedorNaLista(vendedor3);
        lv.adicionaVendedorNaLista(vendedor4);

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

    @Test
    public void piorVendedor() throws IOException {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("001ç1234567891234çPedroç50000");
        dados.add("001ç3245678865434çPauloç40000.99");
        dados.add("002ç2345675434544345çJose da SilvaçRural");
        dados.add("002ç2345675433444345çEduardo PereiraçRural");
        dados.add("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPaulo");
        dados.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPedro");
        dados.add("003ç02ç[1-34-10,2-33-1.50,3-40-0.10]çPedro");
        dados.add("003ç18ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");
        ListaDeVendas lv = new ListaDeVendas();
        ListaDeVendedores lve = new ListaDeVendedores();
        ListaDeClientes lc = new ListaDeClientes();
        ProcessaDados pd = new ProcessaDados(lve, lc, lv);
        pd.montaListaDeObjetos(dados);

        Vendedor vendedor = new Vendedor("1234567891234", "Pedro",50000);

        assertEquals(vendedor.getCpf(), lve.vendedorQueMenosVendeu().getCpf());
    }
}