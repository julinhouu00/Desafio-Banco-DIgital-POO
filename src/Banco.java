import java.util.*;
import java.util.stream.Collectors;

public class Banco {
   private String nome;
   private Map<String, Conta> contas = new HashMap<>();

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

public void adicionarConta(Conta conta){
      String key = gerarChave(conta.getCliente().getNome(),conta.getAgencia());
      contas.put(key, conta);
}

public  Conta buscarContaPorNomeEAgencia (String nome, int agencia){
      String key = gerarChave(nome, agencia);
      return contas.get(key);
}
private  String gerarChave(String nome, int agencia){
       return  nome + "_" + agencia;
}

public Collection<Conta> getContas(){
       return  Collections.unmodifiableCollection(contas.values());
}

    public List<Conta> filtrarContasPorSaldo(double saldoMinimo) {
        return contas.values().stream()
                .filter(conta -> conta.getSaldo() > 0)
                .collect(Collectors.toList());
    }
}