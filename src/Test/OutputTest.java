package Test;

import AgiBank.Output;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class OutputTest {

    @Test
    public void geraSaida() throws IOException {
        Output out = new Output();
        String str = "oi";
        assertEquals(true, out.geraSaida(str));
    }
}