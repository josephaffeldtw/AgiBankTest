package AgiBank;

public class Vendedor {

    private static final String id = "001";
    private String cpf;
    private String nome;
    private double salario;

    public Vendedor(String cpf, String nome, double salario) {
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
    }

    public static String getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        FormataStrings fs = new FormataStrings();
        return "\nCPF: " + this.cpf +
                "\nNome: " + this.nome +
                "\nSalário: " + fs.formataParaMoedaReal(this.salario);
    }
}
