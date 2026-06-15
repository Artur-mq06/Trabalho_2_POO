public abstract class Acomodacao{
    private String codigo;
    private int capacidadeMaxima;
    private double precoBaseDiaria;

    public Acomodacao(String codigo, int capacidadeMaxima, double precoBaseDiaria) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: O código da acomodação não pode ser vazio!");
        }
        if (precoBaseDiaria < 0) {
            throw new IllegalArgumentException("Erro: O preço base da diária não pode ser negativo!");
        }
        
        this.codigo = codigo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.precoBaseDiaria = precoBaseDiaria;
    }

    public void exibirDadosBasicos(){
        System.out.println("Código: " + codigo + " / Capacidade: " + capacidadeMaxima + " / Preço base da diária: R$" + precoBaseDiaria);
    }
    public abstract double calcPrecTotal(int quatidadeDias);

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: O código da acomodação não pode ser vazio!");
        }
        this.codigo = codigo;
    }

    public int getCapacidadeMaxima() { return capacidadeMaxima; }
    public void setCapacidadeMaxima(int capacidadeMaxima) { this.capacidadeMaxima = capacidadeMaxima; }

    public double getPrecoBaseDiaria() { return precoBaseDiaria; }
    public void setPrecoBaseDiaria(double precoBaseDiaria) {
        if (precoBaseDiaria < 0) {
            throw new IllegalArgumentException("Erro: O preço base da diária não pode ser negativo!");
        }
        this.precoBaseDiaria = precoBaseDiaria;
    }
}