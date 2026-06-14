public abstract class Acomodacao{
    private String codigo;
    private int capacidadeMaxima;
    private double precoBaseDiaria;

    public Acomodacao(String codigo, int capacidadeMaxima, double precoBaseDiaria) {
        this.codigo = codigo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.precoBaseDiaria = precoBaseDiaria;
    }

    public void exibirDadosBasicos(){
        System.out.println("Código: " + codigo + " / Capacidade: " + capacidadeMaxima + " / Preço base da diária: R$" + precoBaseDiaria);
    }
    public abstract double calcPrecTotal(int quatidadeDias);

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public int getCapacidadeMaxima() { return capacidadeMaxima; }
    public void setCapacidadeMaxima(int capacidadeMaxima) { this.capacidadeMaxima = capacidadeMaxima; }

    public double getPrecoBaseDiaria() { return precoBaseDiaria; }
    public void setPrecoBaseDiaria(double precoBaseDiaria) { this.precoBaseDiaria = precoBaseDiaria; }
}