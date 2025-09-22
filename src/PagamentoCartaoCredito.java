public class PagamentoCartaoCredito implements IPagamento{
    private String numeroCartao;

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean processarPagamento(double valor) {
        if(valor < 200){
            return true;
        } else {
            return false;
        }
    }

}
