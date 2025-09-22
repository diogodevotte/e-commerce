public class PagamentoBoleto implements IPagamento{
    private String codigoBarras;

    @Override
    public boolean processarPagamento(double valor) {
        if(valor < 1000){
            return true;
        } else {
            return false;
        }
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
}