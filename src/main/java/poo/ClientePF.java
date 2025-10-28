package poo;

import java.time.LocalDate;

public class ClientePF extends Cliente{
    private String cpf;
    private LocalDate dataNascimento;

    public ClientePF(String nome, String email,String cpf, String telefone) {
        super(nome,email,telefone);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String getIdentificadorUnico() {
        return cpf;
    }

}