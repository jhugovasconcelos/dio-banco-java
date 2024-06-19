import java.util.*;

public class CaixaAutomatico {
    private final List<Integer> sessaoInicial = List.of(1);
    private ArrayList<Integer> sessoes = new ArrayList<>(sessaoInicial);

    public void novaSessao(Conta conta) {
        // Iniciando a sessão
        int sessao = sessoes.get(0);
        Banco banco = Banco.getInstance();
        System.out.printf("--------------------------------%n");
        System.out.println("Bem vindo ao " + banco.getNome() + "!" + "\nNúmero da sessão: " + Math.abs(sessao));
        System.out.printf("--------------------------------%n");
        sessao ++;
        sessoes.add(0, sessao);

        // Mostrando as opções
        PrimeiroAcesso acesso = new PrimeiroAcesso();
        Scanner teclado = new Scanner(System.in);
        System.out.println("""
                Escolha uma das opções abaixo:
                1) Saque
                2) Depósito
                3) Transferência
                4) Sair
                """);
        int escolha = teclado.nextInt();
        switch (escolha){
            case 1:
                System.out.println("Opção Saque");
                System.out.println("Digite o valor: ");
                double valorSaque = teclado.nextDouble();
                conta.sacar(valorSaque);
                acesso.proximaTela();
                break;
            case 2:
                System.out.println("Opção Depósito");
                System.out.println("Digite o valor: ");
                double valorDeposito = teclado.nextDouble();
                conta.depositar(valorDeposito);
                acesso.proximaTela();
                break;
            case 3:
                System.out.println("Opção Transferência");
                System.out.println();
                System.out.println("Digite o número da conta para transferir");
                int contaNum = teclado.nextInt();
                System.out.println("Agora, digite o valor da transferência");
                double valor = teclado.nextDouble();
            try {
                Conta contaTransferir = banco.getSingleConta(contaNum);
                conta.transferir(valor, contaTransferir);
                acesso.proximaTela();
            } catch (ContaInexistenteException e) {
                System.out.println(e.getMessage());
            }
                break;
            case 4:
                System.out.println("Saindo da sessão");
                break;
            default:
                System.out.println("Número desconhecido, retornando ao menu anterior");
                acesso.proximaTela();
        }

    }

}
