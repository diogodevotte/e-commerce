import java.time.LocalDate;
import java.util.List;

public class SistemaPedidos {
    public static void main(String[] args) throws Exception {
        
        Produto teclado = new Produto("Fortrek Teclado Gamer BLACK EAGLE", 50);
        Produto mousePad = new Produto("Mouse Pad Preto", 200);
        Produto mouse = new Produto("Mouse Dell sem fio - WM118", 150);

        ItemPedido itemTeclado = new ItemPedido(teclado, 2);
        ItemPedido itemMousePad = new ItemPedido(mousePad, 7);
        ItemPedido itemMouse = new ItemPedido(mouse, 1);

        ClientePF cliente1 = new ClientePF("Diogo", "diogo@gmail.com", "1234");
        ClientePJ cliente2 = new ClientePJ("Diogo LTDA", "diogo@ltda.com", "4321");

        PagamentoCartaoCredito pagamentoCartao = new PagamentoCartaoCredito();
        Pedido p1 = new Pedido(12345,LocalDate.now(),"Disponível", cliente1,pagamentoCartao);

        PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();
        Pedido p2 = new Pedido(54321,LocalDate.now(),"Disponível",cliente2,pagamentoBoleto);
        // Pode ser IPagamento, o Pedido só quer receber uma classe que implementa o método.

        p1.adicionarItem(itemMouse);


        p2.adicionarItem(itemTeclado);
        p2.adicionarItem(itemMousePad);

        // p1.setStatusPedido(StatusPedido.PENDENTE);

        System.out.println("#---------------------------------------#");
        System.out.println("Cliente: " + cliente1.getNome());
        List<String> nomeitens = p1.nomeItens();
        System.out.println("PRODUTOS:");
        for(String nome : nomeitens){
            System.out.println(nome);
        }
        System.out.printf("TOTAL: %.2f\n", p1.calcularTotal());
        System.out.println("Pagamento processado: " + p1.getMetodoPagamento().processarPagamento(p1.calcularTotal()));
        nomeitens.clear();

        System.out.println("#---------------------------------------#");
        System.out.println("Cliente: " + cliente2.getNome());
        nomeitens = p2.nomeItens();
        System.out.println("PRODUTOS:");
        for(String nome : nomeitens){
            System.out.println(nome);
        }
        System.out.printf("TOTAL: %.2f\n", p2.calcularTotal());
        System.out.println("Pagamento processado: " + p2.getMetodoPagamento().processarPagamento(p2.calcularTotal()));

    }
}