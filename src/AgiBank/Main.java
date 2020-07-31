package AgiBank;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Input in= new Input();
        ProcessaDados pd = new ProcessaDados();

        File diretorio = new File("/home/joseph/data/in");
        File arquivos[] = diretorio.listFiles();

        for(int i = 0; i < arquivos.length; i++){
            in.leArquivo(arquivos[i]);
        }

        pd.montaListaDeObjetos(in.getArquivosLidos());
    }
}
