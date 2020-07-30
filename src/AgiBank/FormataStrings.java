package AgiBank;

import java.text.NumberFormat;
import java.util.Locale;

public class FormataStrings {

    /*CPF e CNPJ não podem ser formatados pois estão vindo com padrões maiores que o normal*/
    public String formataParaMoedaReal(Double valor){
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat dinheiroBR = NumberFormat.getCurrencyInstance(localeBR);
        return dinheiroBR.format(valor);
    }

}
