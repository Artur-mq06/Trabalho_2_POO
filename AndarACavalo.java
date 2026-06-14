public class AndarACavalo extends Servico {
    private double preco15Min;
    private int quantidadeSessoes;

    public AndarACavalo(String codigo, String descricao, double preco15Min, int quantidadeSessoes){
        super(codigo, descricao);

        this.preco15Min = preco15Min;
        this.quantidadeSessoes = quantidadeSessoes;
    }

     @Override
    public double calcPrecoTotal() {
        return preco15Min * quantidadeSessoes;
    }
}