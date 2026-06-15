public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- INICIANDO SISTEMA DA POUSADA ---");
        
        // 1. Instanciando a Pousada (Isso cria as listas vazias)
        Pousada pousadaOasis = new Pousada();

        // 2. Mandando a pousada ler os arquivos txt que você criou
        pousadaOasis.lerAcomodacoesDoArquivo();
        pousadaOasis.lerServicosDoArquivo();

        // 3. Imprimindo para ver se os dados realmente foram parar dentro das listas
        System.out.println("\n--- ACOMODAÇÕES CARREGADAS ---");
        for (Acomodacao a : pousadaOasis.getAcomodacoes()) {
            // Chama o método que você criou lá na classe Acomodacao
            a.exibirDadosBasicos(); 
        }

        System.out.println("\n--- SERVIÇOS CARREGADOS ---");
        for (Servico s : pousadaOasis.getServicos()) {
            // Chama o método que você criou lá na classe Servico
            s.exibirDados(); 
        }
    }
}