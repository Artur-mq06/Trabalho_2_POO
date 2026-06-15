import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String codigo;
    private Hospede hospedeResponsavel;
    private Acomodacao acomodacao;
    private int quantidadeHospedes;
    private int quantidadeDias;
    private List<Servico> servicosContratados;

    public Reserva(String codigo, Hospede hospedeResponsavel, Acomodacao acomodacao, int quantidadeHospedes, int quantidadeDias) {
        if (quantidadeHospedes > acomodacao.getCapacidadeMaxima()) {
            throw new IllegalArgumentException("Erro: A quantidade de hóspedes excede a capacidade máxima da acomodação!");
        }
        this.codigo = codigo;
        this.hospedeResponsavel = hospedeResponsavel;
        this.acomodacao = acomodacao;
        this.quantidadeHospedes = quantidadeHospedes;
        this.quantidadeDias = quantidadeDias;
        this.servicosContratados = new ArrayList<>();
    }

    public void adicionarServico(Servico servico) {
        this.servicosContratados.add(servico);
    }

    public double calcularPrecoTotal() {
        double totalAcomodacao = acomodacao.calcPrecTotal(this.quantidadeDias);
        
        double totalServicos = 0;
        for (Servico s : servicosContratados) {
            totalServicos += s.calcPrecoTotal();
        }
        
        return totalAcomodacao + totalServicos;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Hospede getHospedeResponsavel() { return hospedeResponsavel; }
    public void setHospedeResponsavel(Hospede hospedeResponsavel) { this.hospedeResponsavel = hospedeResponsavel; }

    public Acomodacao getAcomodacao() { return acomodacao; }
    public void setAcomodacao(Acomodacao acomodacao) { this.acomodacao = acomodacao; }

    public int getQuantidadeHospedes() { return quantidadeHospedes; }
    public void setQuantidadeHospedes(int quantidadeHospedes) {
        if (quantidadeHospedes > this.acomodacao.getCapacidadeMaxima()) {
            throw new IllegalArgumentException("Erro: A quantidade de hóspedes excede a capacidade máxima da acomodação!");
        }
        this.quantidadeHospedes = quantidadeHospedes;
    }

    public int getQuantidadeDias() { return quantidadeDias; }
    public void setQuantidadeDias(int quantidadeDias) { this.quantidadeDias = quantidadeDias; }

    public List<Servico> getServicosContratados() { return servicosContratados; }
}