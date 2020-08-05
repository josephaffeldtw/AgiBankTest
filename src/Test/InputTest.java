package Test;

import AgiBank.Input;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class InputTest {

    @Test
    public void leArquivo() throws IOException {
        Input in = new Input();
        File dir = new File("/home/joseph/data/in/");
        String arq = "arquivoTeste.dat";
        dir.mkdirs();
        dir= new File(dir+arq);
        dir.createNewFile();
        assertEquals(true, in.leArquivo(dir));
    }

    @Test
    public void naoLeArquivos() throws IOException {
        Input in = new Input();
        File arq = new File("/home/joseph/data/in/Joseph.txt");
        assertEquals(false, in.leArquivo(arq));
    }

    @Test
    public void arquivoValido() {
        Input in = new Input();
        File arquivo = new File("/home/joseph/data/in/arquivoTeste.dat");
        assertEquals(true, in.arquivoValido(arquivo));
    }

    @Test
    public void arquivoInvalido() {
        Input in = new Input();
        File arquivo = new File("/home/joseph/data/in/Joseph.txt");
        assertEquals(false, in.arquivoValido(arquivo));
    }

}