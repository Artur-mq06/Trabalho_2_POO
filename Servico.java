public abstract class Servico implements Cobravel {
    private String codigo;
    private String descricao;

    public Servico(String codigo, String descricao) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: O código do serviço não pode ser vazio!");
        }
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: A descrição do serviço não pode ser vazia!");
        }
        
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public void exibirDados() {
        System.out.println("Serviço: " + codigo + ": " + descricao);
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: O código do serviço não pode ser vazio!");
        }
        this.codigo = codigo;
    }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: A descrição do serviço não pode ser vazia!");
        }
        this.descricao = descricao;
    }
}
