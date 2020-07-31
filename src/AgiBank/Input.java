package AgiBank;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;

public class Input {

    ArrayList<String> arquivosLidos;

    public Input(){
        this.arquivosLidos = new ArrayList<String>();
    }

    public boolean leArquivo(File file) {
        if(arquivoValido(file)){
            try {
                FileReader fr = new FileReader(file);
                BufferedReader leArquivo = new BufferedReader(fr);
                String linha = leArquivo.readLine();

                while (linha != null) {
                    arquivosLidos.add(linha);
                    linha = leArquivo.readLine();
                }
                return true;
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean arquivoValido(File arquivo) {
        return arquivo.getName().endsWith(".dat");
    }

    public ArrayList<String> getArquivosLidos(){
        return this.arquivosLidos;
    }

}
