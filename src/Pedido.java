import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private LocalDate data;
    private List<ItemPedido> itens;
    private Cliente cliente;
    private IPagamento metodoPagamento;
    private StatusPedido statusPedido;

    public Pedido(LocalDate data,Cliente cliente, IPagamento metodoPagamento) {
        this.data = data;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.metodoPagamento = metodoPagamento;
        this.statusPedido = StatusPedido.PENDENTE;
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
    
    public IPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
    
    public List<ItemPedido> getItens() {
        return itens;
    }

    public double calcularTotal(){
        double total = 0;
        for(ItemPedido item : this.itens){
            total += item.getSubTotal();
        }
        return total;
    }

    public void adicionarItem(Produto produto, int quantidade){
        for(ItemPedido item : this.itens){
            if(item.getProduto().equals(produto)){
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }
        ItemPedido novoItem = new ItemPedido(produto, quantidade);
        this.itens.add(novoItem);
    }

    public void removerItem(ItemPedido item){
        this.itens.remove(item);
    }

    public double aplicarDesconto(double desconto){
        double valor = this.calcularTotal() * (1-desconto);
        return valor;
    }

    public boolean confirmarPedido(){
        if(this.statusPedido != StatusPedido.PENDENTE){
            return false;
        } else if(this.metodoPagamento == null){
            return false;
        } else {
            boolean control = this.metodoPagamento.processarPagamento(this.calcularTotal());
            if(control){
                this.statusPedido = StatusPedido.PROCESSANDO;
                return control;
            } else {
                this.statusPedido = StatusPedido.PENDENTE;
                return control;
            }
        }
    }
}