public abstract class Conta implements Iconta {

    private static final int AGENCIA_PADRAO = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
protected Cliente cliente;




    private static  int SEQUENCIAL = 1;

    public  Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
if (saldo >= valor){
    saldo -= valor;
}else {
    System.out.println("Saldo insuficiente para saque.");
}
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
if (saldo >= valor){
    this.sacar(valor);
    contaDestino.depositar(valor);
} else {
    System.out.println("Saldo insuficiente para saque.");
}
    }

    protected void imprimirInfosComuns() {
        System.out.println("Titular: "+ this.cliente.getNome());
        System.out.println("Agência: "+ this.agencia );
        System.out.println("Numero: "+ this.numero );
        System.out.println("Saldo: "+ this.saldo );
    }
}
