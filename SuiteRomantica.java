public class SuiteRomantica extends Acomodacao{
    private double taxaLimpezaMassiva;
    private double taxaFrigobar;

    public SuiteRomantica(String codigo, int capacidadeMaxima, double precoBaseDiaria, double taxaLimpezaMassiva, double taxaFrigobar){
        super(codigo, capacidadeMaxima, precoBaseDiaria);

        this.taxaLimpezaMassiva = taxaLimpezaMassiva;
        this.taxaFrigobar = taxaFrigobar;
    }

    @Override
    public double calcPrecTotal(int quantidadeDias){
        return (getPrecoBaseDiaria() * quantidadeDias) + (taxaLimpezaMassiva * quantidadeDias) + taxaFrigobar;
    }
}