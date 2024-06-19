import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class Banco {
    private final String nome = "Banco Java";
    private ArrayList<Conta> contaList = new ArrayList<Conta>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private static Banco instance;
    private Banco(){}

    public String getNome() {return nome;}
    public static Banco getInstance(){
        if (instance == null) {
            instance = new Banco();
        }
        return instance;
    }

    public ArrayList<Conta> getContaList() {return contaList;}
    public ArrayList<Cliente> getClientes() {return clientes;}
    public void addConta(Conta ... contas){
        List<Conta> asList = Arrays.asList(contas);
        this.contaList.addAll(asList);
    }
    public void addCliente(Cliente ... clientes){
        List<Cliente> asList = Arrays.asList(clientes);
        this.clientes.addAll(asList);
    }

    public Conta getSingleConta(int numero) throws ContaInexistenteException {
        Optional<Conta> opt = Optional.of(
                contaList.stream().
                filter(c -> c.getNumero() == numero).
                toList().get(0)
        );
        return opt.orElseThrow(() -> new ContaInexistenteException("A conta não existe no banco"));
    }
    public Cliente getSingleCliente(String cpf) throws ClienteInexistenteException{
        Optional<Cliente> opt = Optional.of(clientes.stream().
                filter(c -> c.getCpf() == cpf).
                toList().get(0));
        return opt.orElseThrow(() -> new ClienteInexistenteException("O cliente não está cadastrado no banco"));
    }

}
