public abstract class Conta {
    protected static final int AGENCIA_UM = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;

    protected Cliente cliente;
    static Banco banco = Banco.getInstance();

    protected static int SEQUENCIAL = 1;
    public Conta(){
        this.agencia = Conta.AGENCIA_UM;
        this.numero = SEQUENCIAL++;
        banco.addConta(this);
    }
    public int getAgencia() {return agencia;}

    public int getNumero() {return numero;}

    public double getSaldo() {return saldo;}

    public void sacar(double valor){saldo -= valor;}

    public void depositar(double valor){saldo += valor;}

    public void transferir(double valor, Conta contaDestino){
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirinfosComuns() {
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Numero: %d", numero));
        System.out.println(String.format("Numero: %s", cliente));
        System.out.println(String.format("Saldo: %.2f", saldo));
    }
}
