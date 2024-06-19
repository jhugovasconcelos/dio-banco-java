public class ContaCorrente extends Conta{
    public ContaCorrente(Cliente cliente){
        this.cliente = cliente;
        this.agencia = Conta.AGENCIA_UM;
        this.numero = SEQUENCIAL++;
        banco.addConta(this);
    }
    public ContaCorrente(){}
    public void imprimirExtrato(){
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirinfosComuns();
    }
}
