import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();



        System.out.println("Bem-vindo ao Banco Julinhou's!");
        System.out.print("Por favor, insira seu nome: ");

        String nome = sc.nextLine();
        System.out.print("Por favor, insira o número da agência: ");
        int agencia = sc.nextInt();
        sc .nextLine();


Conta conta = banco.buscarContaPorNomeEAgencia(nome,agencia);



if (conta == null){
    System.out.println("Novo cliente detectado. Criando uma nova conta.");
    Cliente cliente = new Cliente();
    cliente.setNome(nome);
    conta = new ContaCorrente(cliente);
    banco.adicionarConta(conta);
}

boolean continuar = true;
while (continuar){
    System.out.println("\nSelecione uma operação:");
    System.out.println("1. Depositar");
    System.out.println("2. Sacar");
    System.out.println("3. Transferir");
    System.out.println("4. Imprimir Extrato");
    System.out.println("5. Sair");
    int opcao = sc.nextInt();

    switch (opcao){
        case 1:
            System.out.println("Digite o valor a depositar: ");
            double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
            break;
        case 2:
            System.out.print("Digite o valor a sacar: ");
            double valorSaque = sc.nextDouble();
            conta.sacar(valorSaque);
            break;
        case 3:
            System.out.print("Digite o valor a transferir: ");
            double valorTransferencia = sc.nextDouble();
            System.out.print("Digite o nome do destinatário: ");
            sc.nextLine(); // Consumir a nova linha
            String nomeDestinatario = sc.nextLine();
            Conta contaDestino = banco.buscarContaPorNomeEAgencia(nomeDestinatario, agencia);
            if (contaDestino != null){
                conta.transferir(valorTransferencia,contaDestino);
            } else {
                System.out.println("Conta destino não encontrada.");
            }
            break;
        case 4:
            conta.imprimirExtrato();
            break;
        case 5:
            continuar = false;
            break;
        default:
            System.out.println("Opção inválida.");
    }

}
    }
}
