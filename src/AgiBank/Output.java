package AgiBank;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Output {
    private final static Logger looger = Logger.getLogger(Output.class.getName());

    public boolean geraSaida(String saida) throws IOException {
        boolean gerouSaida = false;
        String caminho = System.getProperty("user.home").concat("/data/out/");
        String nome = "analise.dat";
        File f = new File(caminho);
        if(!f.exists()){
            looger.log(Level.INFO, "Criando diretório e arquivo...");
            criaArquivo(caminho, nome);
            looger.log(Level.INFO, "Arquivo Criado");
        }
        if(saida != null){
            try{
                FileWriter fw = new FileWriter(caminho+nome);
                fw.write(saida);
                fw.close();
                gerouSaida = true;
                looger.log(Level.INFO, "Gerou saida em: " +caminho+nome);
            }catch (Exception e){
                looger.log(Level.WARNING, "Não gerou saída " +e.getMessage());
                System.out.println(e.getMessage());
            }
        }
        return gerouSaida;
    }

    public void criaArquivo(String caminho, String arq) throws IOException {
        File f = new File(caminho);
        f.mkdirs();
        f = new File(caminho+arq);
        f.createNewFile();
    }

}
