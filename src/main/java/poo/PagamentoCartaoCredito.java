package poo;

import java.time.LocalDate;

public class PagamentoCartaoCredito implements IPagamento{
    private String numeroCartao;
    private String nomeTitular;
    private LocalDate dataValidade;
    private StatusPagamento statusPagamento;

    @Override
    public boolean processarPagamento(double valor) {
        if(valor < 5000){
            this.setStatusPagamento(StatusPagamento.APROVADO);
            return true;
        } else {
            this.setStatusPagamento(StatusPagamento.RECUSADO);
            return false;
        }
    }

    public String getNumeroCartao() {
        return this.numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public StatusPagamento getStatus() {
        return this.statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public String getNomeTitular() {
        return this.nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public LocalDate getDataValidade() {
        return this.dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}