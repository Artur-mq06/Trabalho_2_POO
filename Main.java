public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- INICIANDO TESTES DO SISTEMA ---");

        Hospede cliente = new Hospede("João da Silva", 30, "123.456.789-00");
        System.out.println("Hóspede criado: " + cliente.getNome());

        QuartoPadrao quarto = new QuartoPadrao("Q-101", 2, 150.0);
        
        Chale chale = new Chale("C-001", 4, 300.0, 50.0, 100.0); 

        Refeicao janta = new Refeicao("Serviço-01", "Jantar Completo", 85.50);
        
        Passeio trilha = new Passeio("Serviço-02", "Trilha na Cachoeira", 40.0, 2); 
        
        AndarACavalo cavalo = new AndarACavalo("Serviço-03", "Passeio a Cavalo", 25.0, 4); 

        Reserva reservaTeste = new Reserva("RES-999", cliente, chale, 2, 3);

        reservaTeste.adicionarServico(janta);
        reservaTeste.adicionarServico(trilha);
        reservaTeste.adicionarServico(cavalo);

        System.out.println("\n--- EXTRATO DE TESTE ---");
        System.out.println("Reserva: " + reservaTeste.getCodigo());
        System.out.println("Acomodação: " + reservaTeste.getAcomodacao().getCodigo());
        
        System.out.println("Valor total apenas das diárias: R$ " + chale.calcPrecTotal(3));

        System.out.println("Valor total da Reserva (Diárias + Serviços): R$ " + reservaTeste.calcularPrecoTotal());
        System.out.println("-----------------------------------");
    }
}