package AgiBank;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private final static Logger looger = Logger.getLogger(Main.class.getName());
    private boolean valida = false;

    public static void main(String[] args) throws IOException, InterruptedException {
        Input in= new Input();
        ProcessaDados pd = new ProcessaDados();

        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get(System.getProperty("user.home").concat("/data/in"));
        path.register(watchService,StandardWatchEventKinds.ENTRY_CREATE);


        File arq[] = path.toFile().listFiles();
        for(int i=0; i< arq.length;i++){
            in.leArquivo(arq[i]);
        }
        pd.montaListaDeObjetos(in.getArquivosLidos());

        looger.log(Level.INFO, "Aguardando Entrada de Arquivos...");
        while(true){
            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    String arquivo = path + "/" + event.context().toString();
                    if (arquivo.endsWith(".dat")) {
                        File file = new File(arquivo);
                        in.leArquivo(file);
                        pd.montaListaDeObjetos(in.getArquivosLidos());
                    }
                }
                key.reset();
            }
        }

}
}
