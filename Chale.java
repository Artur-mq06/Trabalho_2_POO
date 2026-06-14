public class Chale extends Acomodacao{
    private double taxaAquecimento;
    private double taxaLimpeza;

    public Chale(String codigo, int capacidadeMaxima, double precoBaseDiaria, double taxaAqueciemento, double taxaLimpeza){
        super(codigo, capacidadeMaxima, precoBaseDiaria);

        this.taxaAquecimento = taxaAqueciemento;
        this.taxaLimpeza = taxaLimpeza;
    }

    @Override
    public double calcPrecTotal(int quantidadeDias){
        return (getPrecoBaseDiaria() * quantidadeDias) + (taxaAquecimento * quantidadeDias) + taxaLimpeza;
    }
}
