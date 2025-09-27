import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private LocalDate data;
    private String status;
    private List<ItemPedido> itens;
    private Cliente cliente;
    private IPagamento metodoPagamento;
    private StatusPedido statusPedido;

    public Pedido(int numero, LocalDate data, String status,Cliente cliente, IPagamento metodoPagamento) {
        this.numero = numero;
        this.data = data;
        this.status = status;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.metodoPagamento = metodoPagamento;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public void setMetodoPagamento(IPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void adicionarItem(ItemPedido item){
        this.itens.add(item);
    }

    public double calcularTotal(){
        double total = 0;
        for(ItemPedido item : this.itens){
            total += item.getSubTotal();
        }
        return total;
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<String> nomeItens() {
        List<String> nomes = new ArrayList<>();
        for(ItemPedido item : this.itens){
            nomes.add(item.getProduto().getNome());
        }
        return nomes;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public IPagamento getMetodoPagamento() {
        return metodoPagamento;
    }


}