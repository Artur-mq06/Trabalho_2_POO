public class Hospede {
    private String nome;
    private int idade;
    private String cpf;

    public Hospede(String nome, int idade, String cpf) {
        if (idade < 0) {
            throw new IllegalArgumentException("Erro: A idade do hóspede não pode ser negativa!");
        }
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Erro: A idade do hóspede não pode ser negativa!");
        }
        this.idade = idade;
    }

    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
}
