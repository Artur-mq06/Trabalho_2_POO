public class Hospede {
    private String nome;
    private int idade;
    private String cpf;

    public Hospede(String nome, int idade, String cpf) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: O nome do hóspede não pode ser vazio!");
        }
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: O CPF não pode ser vazio!");
        }
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
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: O nome do hóspede não pode ser vazio!");
        }
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
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: O CPF não pode ser vazio!");
        }
        this.cpf = cpf;
    }
}
