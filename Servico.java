public abstract class Servico implements Cobravel {
    private String codigo;
    private String descricao;

    public Servico(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public void exibirDados() {
        System.out.println("Serviço [" + codigo + "]: " + descricao);
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
