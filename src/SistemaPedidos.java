import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaPedidos {
    public static void main(String[] args) throws Exception {
        
        Produto teclado = new Produto("Fortrek Teclado Gamer BLACK EAGLE", 50);
        Produto mousePad = new Produto("Mouse Pad Preto", 200);
        Produto mouse = new Produto("Mouse Dell sem fio - WM118", 150);

        ItemPedido itemTeclado = new ItemPedido(teclado, 1);
        ItemPedido itemMousePad = new ItemPedido(mousePad, 2);
        ItemPedido itemMouse = new ItemPedido(mouse, 1);

        ItemPedido[] itens = new ItemPedido[3];
        // Aponta para o espaço da memória dos itens;
        itens[0] = itemTeclado;
        itens[1] = itemMousePad;
        itens[2] = itemMouse;

        ClientePF cliente1 = new ClientePF("Diogo", "diogo@gmail.com", "1234");
        ClientePJ cliente2 = new ClientePJ("Diogo LTDA", "diogo@ltda.com", "4321");

        PagamentoCartaoCredito pagamentoCartao = new PagamentoCartaoCredito();
        Pedido p1 = new Pedido(12345,LocalDate.now(),"Disponível", cliente1,pagamentoCartao);

        PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();
        Pedido p2 = new Pedido(54321,LocalDate.now(),"Disponível",cliente2,pagamentoBoleto);
        // Pode ser IPagamento, o Pedido só quer receber uma classe que implementa o método.

        p1.adicionarItem(itemMouse);
        p1.adicionarItem(itemMousePad);


        p2.adicionarItem(itemTeclado);
        p2.adicionarItem(itemMouse);
        p2.adicionarItem(itemMousePad);

        System.out.println("#---------------------------------------#");
        System.out.println("Cliente: " + cliente1.getNome());

        List<String> nomes = new ArrayList<>();
        for(String nomeItem : nomes){
            System.out.println(nomeItem);
        }

        System.out.printf("TOTAL: %.2f\n", p1.calcularTotal());

        // System.out.println("#---------------------------------------#");
        // System.out.println("Cliente: " + cliente2.getNome());
        // for(int i=0;i<3;i++){
        //     System.out.println("Item: " + p2.getNomeItem(i) + " | Quantidade: " + p2.getQuantidadeItem(i));
        // }
        // System.out.printf("TOTAL: %.2f\n", p2.calcularTotal());

    }
}