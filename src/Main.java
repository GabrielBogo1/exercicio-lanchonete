import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        Pedido pedido = new Pedido();

//        List<Cliente> clientes = new ArrayList<>();
//        List<Endereco> enderecos = new ArrayList<>();
//        List<Pedido> pedidos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n== Olá! Seja bem-vindo(a) à lanchonete Bigodon's ==");
        System.out.println("Insira uma das opções abaixo: \n");

        int opcao = 0;
        do {
            System.out.println("1 - Realizar um pedido");
            System.out.println("2 - Exibir quantidade de pedidos");
            System.out.println("3 - Exibir pedidos encerrados");
            System.out.println("4 - Exibir pedidos em atendimento");
            System.out.println("5 - Exibir clientes e pedidos/Alterar status do pedido");
            System.out.println("6 - Sair\n");
            System.out.print("Digite a opção: "); opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cliente.cadastrarCliente();
                    break;

                case 2:
                    cliente.quantidadePedidos(cliente.getPedidos());
                    break;

                case 3:
                    cliente.pedidosFinalizados(cliente.getPedidos(), cliente.clientes);
                    break;

                case 4:
                    cliente.pedidosEmProducao(cliente.getPedidos(),cliente.clientes);
                    break;

                case 5:
                    cliente.exibirDadosCliente(cliente.clientes, cliente.getEnderecos(),cliente.getPedidos(),pedido);
                    break;

                case 6:
                    System.exit(1);
                    break;

                default:
                    System.out.println("Opção inválida, digite um valor de 1 até 6");
                    break;
            }
        } while (opcao != 6);
    }
}
