package AgiBank;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private final static Logger looger = Logger.getLogger(Main.class.getName());
    private static boolean valida = false;

    public static void main(String[] args) throws IOException, InterruptedException {
        ListaDeVendedores vendedores = new ListaDeVendedores();
        ListaDeClientes clientes = new ListaDeClientes();
        ListaDeVendas vendas = new ListaDeVendas();
        Input in= new Input();
        Output out = new Output();
        ProcessaDados pd = new ProcessaDados(vendedores, clientes, vendas);

        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get(System.getProperty("user.home").concat("/data/in"));

        if(leuAPrimeiraVez()){
            if(!verificaDiretorio(path)){
                File arq[] = path.toFile().listFiles();
                if(arq.length>0){
                    for(int i=0; i< arq.length;i++){
                        in.leArquivo(arq[i]);
                    }
                    pd.montaListaDeObjetos(in.getArquivosLidos());
                    out.geraSaida(pd.criaSaida());
                }
            }
        }

        path.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        looger.log(Level.INFO, "Aguardando Entrada de Arquivos...");
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
            out.geraSaida(pd.criaSaida());
            key.reset();
        }

    }

    public static boolean leuAPrimeiraVez(){
        if(!valida){
            valida = true;
            return true;
        }
        return false;
    }

    public static boolean verificaDiretorio(Path caminho) throws IOException {
        File f = new File(caminho.toString());
        if(!f.exists()){
            f.mkdirs();
            return true;
        }
        return false;
    }
}
