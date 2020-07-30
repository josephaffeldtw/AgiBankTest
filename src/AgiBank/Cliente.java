package AgiBank;

public class Cliente {

    private static final String id = "002";
    private String cnpj;
    private String nome;
    private String area;

    public Cliente(String cnpj, String nome, String area) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.area = area;
    }

    public static String getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getArea() {
        return area;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
