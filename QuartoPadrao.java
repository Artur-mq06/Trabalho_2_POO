public class QuartoPadrao extends Acomodacao{

    public QuartoPadrao(String codigo, int capacidadeMaxima, double precoBaseDiaria){
        super(codigo, capacidadeMaxima, precoBaseDiaria);
    }

    @Override
    public double calcPrecTotal(int quantidadeDias){
        return getPrecoBaseDiaria() * quantidadeDias;
    }
}
