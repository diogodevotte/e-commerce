import java.time.LocalDate;

public class SistemaPedidos {
    public static void main(String[] args) throws Exception {
        
        Produto teclado = new Produto("Fortrek Teclado Gamer BLACK EAGLE", 119.90, 30, "202501", "Teclado Gamer" );
        Produto mousePad = new Produto("Mouse Pad Preto", 199.90, 50, "202502" , "Mouse Pad Preto");
        Produto mouse = new Produto("Mouse Dell sem fio - WM118", 149.90, 15, "202503", "Mouse Dell");

        //Falta alguns atributos no construtor;
        ClientePF cliente1 = new ClientePF("Diogo", "diogo@gmail.com", "123456789-8","64999622754");
        ClientePJ cliente2 = new ClientePJ("Diogo LTDA", "diogo@ltda.com", "987654321-2","62999374563");

        // Pode ser IPagamento, o Pedido só quer receber uma classe que implementa o método.
        PagamentoCartaoCredito pagamentoCartao = new PagamentoCartaoCredito();
        Pedido p1 = new Pedido(LocalDate.now(), cliente1,pagamentoCartao);
        PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();
        Pedido p2 = new Pedido(LocalDate.now(),cliente2,pagamentoBoleto);

        p1.adicionarItem(teclado,2);
        p1.adicionarItem(mouse, 1);
        p2.adicionarItem(teclado,1);
        p2.adicionarItem(mouse,1);
        p2.adicionarItem(mousePad, 2);

        p1.confirmarPedido();
        p2.confirmarPedido();

        System.out.println("#---------------------------------------#");
        System.out.println("Cliente: " + p1.getCliente().getNome());
        System.out.println("\nPRODUTOS:");
        for(ItemPedido item : p1.getItens()){
            System.out.println(item.getQuantidade() + " - "  + item.getProduto().getNome());
        }
        System.out.printf("\nTOTAL: %.2f\n", p1.calcularTotal());
        System.out.println("Pagamento processado: " + p1.getMetodoPagamento().processarPagamento(p1.calcularTotal()));
        System.out.println("Status do Pedido: " + p1.getStatusPedido());

        System.out.println("#---------------------------------------#");
        System.out.println("Cliente: " + p2.getCliente().getNome());
        System.out.println("\nPRODUTOS:");
        for(ItemPedido item : p2.getItens()){
            System.out.println(item.getQuantidade() + " - "  + item.getProduto().getNome());
        }
        System.out.printf("\nTOTAL: %.2f\n", p2.calcularTotal());
        System.out.println("Pagamento processado: " + p2.getMetodoPagamento().processarPagamento(p2.calcularTotal()));
        System.out.println("Status do Pedido: " + p2.getStatusPedido());
    }
}