public class Refeicao extends Servico {
    private double precoRefeicao;

    public Refeicao(String codigo, String descricao, double precoRefeicao) {
        super(codigo, descricao);
        this.precoRefeicao = precoRefeicao;
    }

    @Override
    public double calcPrecoTotal() {
        return precoRefeicao;
    }
}