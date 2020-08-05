package Test;

import AgiBank.Input;
import org.junit.Test;
import java.io.File;

import static org.junit.Assert.*;

public class InputTest {

    @Test
    public void leArquivo() {
        Input in = new Input();
        File arq = new File("/home/joseph/data/in/arquivo2.dat");
        assertEquals(true, in.leArquivo(arq));
    }

    @Test
    public void naoLeArquivos() {
        Input in = new Input();
        File arq = new File("/home/joseph/data/in/Joseph.txt");
        assertEquals(false, in.leArquivo(arq));
    }

    @Test
    public void arquivoValido() {
        Input in = new Input();
        File arquivo = new File("/home/joseph/data/in/arquivo1.dat");
        assertEquals(true, in.arquivoValido(arquivo));
    }

    @Test
    public void arquivoInvalido() {
        Input in = new Input();
        File arquivo = new File("/home/joseph/data/in/Joseph.txt");
        assertEquals(false, in.arquivoValido(arquivo));
    }

}