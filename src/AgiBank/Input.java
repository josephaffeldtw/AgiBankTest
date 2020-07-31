package AgiBank;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.*;

public class Input {

    private final static Logger looger = Logger.getLogger(Input.class.getName());
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
                looger.log(Level.INFO, "Arquivo lido");
                return true;
            } catch (FileNotFoundException e) {
                System.out.println("Erro: " + e.getMessage());
                looger.log(Level.WARNING, "Arquivo Não foi lido: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage());
                looger.log(Level.WARNING, "Arquivo Não foi lido: " + e.getMessage());
            }
        }
        looger.log(Level.INFO, "Arquivo não tem o formato .dat");
        return false;
    }

    public boolean arquivoValido(File arquivo) {
        return arquivo.getName().endsWith(".dat");
    }

    public ArrayList<String> getArquivosLidos(){
        return this.arquivosLidos;
    }

}
