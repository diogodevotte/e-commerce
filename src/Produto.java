public class Produto {
    protected String nome;
    protected double preco;
    protected int estoque;
    protected String id;
    protected String descricao;
    
    public Produto(String nome, double preco, int estoque, String id, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.id = id;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void adicionarEstoque(int quantidade){
        if(quantidade > 0){
            setEstoque(getEstoque() + quantidade);
        }
    }

}