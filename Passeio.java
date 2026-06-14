public class Passeio extends Servico {
    private double precoBase;
    private int qtdMaximaPessoas;

    public Passeio(String codigo, String descricao, double precoBase, int qtdMaximaPessoas) {
        super(codigo, descricao);
        this.precoBase = precoBase;
        this.qtdMaximaPessoas = qtdMaximaPessoas;
    }

    @Override
    public double calcPrecoTotal() {
        return precoBase * qtdMaximaPessoas;
    }
}