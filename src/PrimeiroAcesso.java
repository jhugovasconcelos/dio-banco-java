import java.util.Optional;
import java.util.Scanner;

public class PrimeiroAcesso {
    private Banco banco = Banco.getInstance();
    public void novoAcesso(){

        System.out.printf("--------------------------------%n");
        System.out.println("Bem vindo ao " + banco.getNome() + "!");
        System.out.printf("--------------------------------%n");
        System.out.println("""
                Escolha uma das opções abaixo:
                1) Novo Cliente
                2) Nova Conta
                3) Sair
                """);
        Scanner teclado = new Scanner(System.in);
        int escolha = teclado.nextInt();
        switch (escolha) {
            case 1:
                System.out.println("Opção Novo Cliente");
                System.out.println("Digite o nome do Cliente");
                String nome = teclado.next();
                System.out.println("Agora, digite o CPF");
                String cpf = teclado.next();
                Cliente cliente = new Cliente(cpf, nome);
                System.out.println("Cliente " + cliente.getNome() + " criado com sucesso!\n");
                proximaTela();
                break;
            case 2:
                System.out.println("Opção Nova Conta");
                System.out.println("Já possui cadastro de cliente?\n1) Sim\n2) Não");
                int possuiCadastro = teclado.nextInt();
                switch (possuiCadastro){
                    case 1:
                    System.out.println("Informe o CPF do cliente");
                    String cpf1 = teclado.next();
                    try {
                        Cliente cliente1 = banco.getSingleCliente(cpf1);
                        ContaCorrente conta1 = new ContaCorrente(cliente1);
                        System.out.println("Conta n° " + conta1.getNumero() + " criada com sucesso!");
                        proximaTela();
                    } catch (ClienteInexistenteException e) {
                        System.out.println(e.getMessage());
                        novoAcesso();
                    }
                    break;
                    case 2:
                    System.out.println("Digite o nome do Cliente");
                    String nome2 = teclado.next();
                    System.out.println("Agora, digite o CPF");
                    String cpf2 = teclado.next();
                    Cliente cliente2 = new Cliente(cpf2, nome2);
                    System.out.println("Cliente " + cliente2.getNome() + " criado com sucesso!\n");
                    ContaCorrente conta2 = new ContaCorrente(cliente2);
                    System.out.println("Conta n° " + conta2.getNumero() + " criada com sucesso!");
                    proximaTela();
                    default:
                    System.out.println("Será criada uma nova conta padrão");
                    ContaCorrente conta3 = new ContaCorrente();
                    System.out.println("Conta n° " + conta3.getNumero() + " criada com sucesso!");
                    proximaTela();
                }
                break;
            case 3:
                System.out.println("Saindo do acesso");
                break;
            default:
                System.out.println("Por favor, selecione um número da lista");
                novoAcesso();
        }
    }
    public void proximaTela(){
        System.out.println("""
                Escolha uma das opções abaixo:
                1) Ir para o Caixa Automático
                2) Voltar para o menu anterior
                3) Sair
                """);
        Scanner teclado = new Scanner(System.in);
        int escolha = teclado.nextInt();
        switch (escolha) {
            case 1:
                CaixaAutomatico caixa = new CaixaAutomatico();
                System.out.println("Digite o número da conta");
                int contaNum = teclado.nextInt();
                try {
                    Conta contaAchada = banco.getSingleConta(contaNum);
                    caixa.novaSessao(contaAchada);
                } catch (ContaInexistenteException e) {
                    System.out.println(e.getMessage());
                    proximaTela();
                }
                break;
            case 2:
                novoAcesso();
                break;
            case 3:
                break;
            default:
                System.out.println("Por favor selecione uma das opções do menu");
                proximaTela();
        }
    }
}
