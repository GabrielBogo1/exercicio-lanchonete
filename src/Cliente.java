import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private List <Endereco> enderecos = new ArrayList<>();

    private List <Pedido> pedidos = new ArrayList<>();

    public List <Cliente> clientes = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);


    public Cliente(String nome, List<Endereco> enderecos) {
        this.nome = nome;
        this.enderecos = enderecos;
    }

    public Cliente() {}

    public void cadastrarCliente (){

        System.out.println("\nPara fazer um pedido, insira os dados abaixo:\n");

        System.out.println("Nome completo: ");
        String nome = scanner.next();

        System.out.println("Digite sua rua: ");
        String rua = scanner.next();

        System.out.println("Digite seu bairro: ");
        String bairro = scanner.next();

        System.out.println("Digite o número da casa: ");
        int numCasa = scanner.nextInt();

        Cliente novoCliente = new Cliente(nome,enderecos);
        clientes.add(novoCliente);


       Endereco novoEndereco = new Endereco(rua,bairro,numCasa);
       enderecos.add(novoEndereco);

        String nomePedido = "";
        int pedidoOpcao;
do {
        System.out.println("Digite o nº do seu pedido: ");
        System.out.println("O cardápio de hoje é: ");
        System.out.println("1 - Pizza de calabresa");
        System.out.println("2 - X-Burguer");
        System.out.println("3 - Batata-frita");

        pedidoOpcao = scanner.nextInt();



    switch (pedidoOpcao) {
        case 1:
            nomePedido = "Pizza de Calabresa";
            System.out.println("O seu pedido de Pizza de calabresa foi realizado!");
            break;

        case 2:
            nomePedido = "X-Burguer";
            System.out.println("O seu pedido de X-Burguer foi realizado!");
            break;

        case 3:
            nomePedido = "Batata-frita";
            System.out.println("O seu pedido de Batata-Frita foi realizado!");
            break;

        default:
            System.out.println("Digite uma opção válida");
            break;
    }
}while (pedidoOpcao > 3);

        System.out.println("Por último, digite o nº do pedido: ");
        int numPedido = scanner.nextInt();

        System.out.println("Pedido realizado com sucesso, muito obrigado!");

        Pedido pedido = new Pedido(nomePedido,numPedido,true,false);
        pedidos.add(pedido);
    }

    public void exibirDadosCliente (List<Cliente>clientes, List <Endereco> enderecos, List<Pedido> pedidos, Pedido pedido) {
        for (int i = 0; i < clientes.size(); i++){
            System.out.println("Nome: " + clientes.get(i).getNome());
            System.out.println("Rua: " + enderecos.get(i).getRua());
            System.out.println("Bairro: " + enderecos.get(i).getBairro());
            System.out.println("Nº casa: " + enderecos.get(i).getNumero());

            System.out.println("Nº pedido: " + pedidos.get(i).getNumPedido());
            System.out.println("Descrição do pedido: " + pedidos.get(i).getNomePedido());

            if (pedidos.get(i).isFinalizado()){
                System.out.println("Status: Finalizado");
            }

            System.out.println("");


        }
        finalizarPedido(pedidos, pedido);
    }

    public void finalizarPedido (List<Pedido> pedidos, Pedido pedido){
        int opcao;

        System.out.println("Deseja finalizar algum pedido? - 1 para sim 2 para não");
        opcao = scanner.nextInt();


        switch (opcao) {
            case 1:
                System.out.println("Digite o número do pedido que deseja finalizar");
                int numeroFinalizar = scanner.nextInt();
                for (int i = 0; i < pedidos.size(); i++) {
                    if (numeroFinalizar == pedidos.get(i).getNumPedido()) {
                        System.out.println("Pedido " + pedidos.get(i).getNumPedido() + " finalizado!");
                        pedidos.get(i).setFinalizado(true);
                    }
                }
        }


    }

    public void quantidadePedidos (List <Pedido> pedidos){
        System.out.println("A quantidade total de pedidos é de: " + pedidos.size());
    }

    public void pedidosFinalizados(List<Pedido> pedidos, List <Cliente> clientes) {
        boolean verificaFinalizados = false;

        System.out.println("Pedidos finalizados: ");

        for (int i =0; i< pedidos.size(); i++) {
            if (pedidos.get(i).isFinalizado()) {
                System.out.println("Pedido nº: " + pedidos.get(i).getNumPedido());
                System.out.println("Descrição do pedido: " + pedidos.get(i).getNomePedido());
                System.out.println("Nome do cliente: " + clientes.get(i).getNome());
                verificaFinalizados = true;

                System.out.println("");
                System.out.println("teste");
                System.out.println("tesntad");
            }
        }

        if (!verificaFinalizados) {
            System.out.println("\nSem pedidos finalizados!\n");
        }
    }


    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    private void setEnderecos() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
