import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private static int SEQUENCIAL = 1;
    public Cliente(){
        this.nome = String.format("Undefined%d",SEQUENCIAL);
        this.cpf = "000.000.000-00";
        SEQUENCIAL++;

    }
    public String getNome() {return nome;}
    public String getCpf() {return cpf;}

    @Override
    public String toString() {
        return "Cliente{" +
                "'nome': " + getNome() +
                ", 'cpf':" + getCpf() +
                '}';
    }

    public Cliente(String cpf, String nome){
        this.nome = nome;
        this.cpf = cpf;
    }
}
