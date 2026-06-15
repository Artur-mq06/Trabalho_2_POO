import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pousada {
    
    private List<Hospede> hospedes;
    private List<Acomodacao> acomodacoes;
    private List<Servico> servicos;
    private List<Reserva> reservas;

    public Pousada() {
        this.hospedes = new ArrayList<>();
        this.acomodacoes = new ArrayList<>();
        this.servicos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void cadastrarHospede(Hospede hospede) {
        this.hospedes.add(hospede);
    }

    public void salvarHospedesNoArquivo() {
        try {
            FileWriter arqGravacao = new FileWriter("hospedes.txt");
            BufferedWriter gravador = new BufferedWriter(arqGravacao);

            for (Hospede h : hospedes) {
                String linha = h.getNome() + ";" + h.getIdade() + ";" + h.getCpf();
                gravador.write(linha);
                gravador.newLine();
            }

            gravador.close();
            System.out.println("Dados dos hóspedes salvos com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public List<Hospede> getHospedes() { return hospedes; }
    public List<Acomodacao> getAcomodacoes() { return acomodacoes; }
    public List<Servico> getServicos() { return servicos; }
    public List<Reserva> getReservas() { return reservas; }


    public void salvarReservasNoArquivo() {
        try {
            FileWriter arqGravacao = new FileWriter("reservas.txt");
            BufferedWriter gravador = new BufferedWriter(arqGravacao);

            for (Reserva r : reservas) {
                String linha = r.getCodigo() + ";" + 
                               r.getHospedeResponsavel().getCpf() + ";" + 
                               r.getAcomodacao().getCodigo() + ";" + 
                               r.getQuantidadeHospedes() + ";" + 
                               r.getQuantidadeDias();
                gravador.write(linha);
                gravador.newLine();
            }

            gravador.close();
            System.out.println("Dados das reservas salvos com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar reservas: " + e.getMessage());
        }
    }

    public void lerAcomodacoesDoArquivo() {
        try {
            FileReader arqLeitura = new FileReader("acomodacoes.txt");
            BufferedReader leitor = new BufferedReader(arqLeitura);

            String linha = leitor.readLine();
            
            while (linha != null) {
                String[] dados = linha.split(";");
                
                String tipo = dados[0];
                String codigo = dados[1];
                int capacidade = Integer.parseInt(dados[2]);
                double precoBase = Double.parseDouble(dados[3]);

                if (tipo.equals("QuartoPadrao")) {
                    acomodacoes.add(new QuartoPadrao(codigo, capacidade, precoBase));
                } 
                else if (tipo.equals("Chale")) {
                    double taxaAquecimento = Double.parseDouble(dados[4]);
                    double taxaLimp = Double.parseDouble(dados[5]);
                    acomodacoes.add(new Chale(codigo, capacidade, precoBase, taxaAquecimento, taxaLimp));
                }
                else if (tipo.equals("SuiteRomantica")) {
                    double taxaLimpMassiva = Double.parseDouble(dados[4]);
                    double taxaFrigobar = Double.parseDouble(dados[5]);
                    acomodacoes.add(new SuiteRomantica(codigo, capacidade, precoBase, taxaLimpMassiva, taxaFrigobar));
                }

                linha = leitor.readLine();
            }

            leitor.close();
            System.out.println("Acomodações carregadas com sucesso!");

        } catch (Exception e) {

            System.out.println("Aviso: Não foi possível carregar acomodacoes.txt ou arquivo inexistente.");
        }
    }

    public void lerServicosDoArquivo() {
        try {
            FileReader arqLeitura = new FileReader("servicos.txt");
            BufferedReader leitor = new BufferedReader(arqLeitura);

            String linha = leitor.readLine();
            
            while (linha != null) {
                String[] dados = linha.split(";");
                
                String tipo = dados[0];
                String codigo = dados[1];
                String descricao = dados[2];

                if (tipo.equals("Refeicao")) {
                    double preco = Double.parseDouble(dados[3]);
                    servicos.add(new Refeicao(codigo, descricao, preco));
                } 
                else if (tipo.equals("Passeio")) {
                    double precoBase = Double.parseDouble(dados[3]);
                    int maxPessoas = Integer.parseInt(dados[4]);
                    servicos.add(new Passeio(codigo, descricao, precoBase, maxPessoas));
                }
                else if (tipo.equals("AndarACavalo")) {
                    double preco15Min = Double.parseDouble(dados[3]);
                    int qtdSessoes = Integer.parseInt(dados[4]);
                    servicos.add(new AndarACavalo(codigo, descricao, preco15Min, qtdSessoes));
                }

                linha = leitor.readLine();
            }

            leitor.close();
            System.out.println("Serviços carregados com sucesso!");

        } catch (Exception e) {
            System.out.println("Aviso: Não foi possível carregar servicos.txt ou arquivo inexistente.");
        }
    }
}