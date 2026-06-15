import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pousada pousadaOasis = new Pousada();

        System.out.println("Iniciando o sistema...");
        pousadaOasis.lerAcomodacoesDoArquivo();
        pousadaOasis.lerServicosDoArquivo();

        int opcao = 0;

        while (opcao != 14) {
            System.out.println("\n=== MENU POUSADA OÁSIS DO OESTE ===");
            System.out.println("1. Cadastrar um hóspede");
            System.out.println("2. Exibir dados de um hóspede");
            System.out.println("3. Exibir dados de todos os hóspedes");
            System.out.println("4. Exibir dados de uma acomodação");
            System.out.println("5. Exibir dados de todas as acomodações");
            System.out.println("6. Exibir dados de um serviço");
            System.out.println("7. Exibir dados de todos os serviços");
            System.out.println("8. Cadastrar uma reserva");
            System.out.println("9. Adicionar serviço a uma reserva");
            System.out.println("10. Exibir dados de uma reserva");
            System.out.println("11. Exibir dados de todas as reservas");
            System.out.println("12. Exibir extrato de uma reserva");
            System.out.println("13. Salvar os dados (hóspedes e reservas)");
            System.out.println("14. Sair do sistema");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Nome do Hóspede: ");
                        String nome = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        
                        Hospede novoHospede = new Hospede(nome, idade, cpf);
                        pousadaOasis.cadastrarHospede(novoHospede);
                        System.out.println("Hóspede cadastrado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Digite o CPF do hóspede: ");
                        String buscaCpf = scanner.nextLine();
                        boolean achouHospede = false;
                        for (Hospede h : pousadaOasis.getHospedes()) {
                            if (h.getCpf().equals(buscaCpf)) {
                                System.out.println("Hóspede: " + h.getNome() + " | Idade: " + h.getIdade());
                                achouHospede = true;
                                break;
                            }
                        }
                        if (!achouHospede) System.out.println("Hóspede não encontrado!");
                        break;

                    case 3:
                        System.out.println("\n--- LISTA DE HÓSPEDES ---");
                        for (Hospede h : pousadaOasis.getHospedes()) {
                            System.out.println("- " + h.getNome() + " (CPF: " + h.getCpf() + ")");
                        }
                        break;

                    case 4:
                        System.out.print("Digite o código da acomodação: ");
                        String buscaCodAcom = scanner.nextLine();
                        boolean achouAcom = false;
                        for (Acomodacao a : pousadaOasis.getAcomodacoes()) {
                            if (a.getCodigo().equals(buscaCodAcom)) {
                                a.exibirDadosBasicos();
                                achouAcom = true;
                                break;
                            }
                        }
                        if (!achouAcom) System.out.println("Acomodação não encontrada!");
                        break;

                    case 5:
                        System.out.println("\n--- LISTA DE ACOMODAÇÕES ---");
                        for (Acomodacao a : pousadaOasis.getAcomodacoes()) {
                            a.exibirDadosBasicos();
                        }
                        break;

                    case 6:
                        System.out.print("Digite o código do serviço: ");
                        String buscaCodServ = scanner.nextLine();
                        boolean achouServ = false;
                        for (Servico s : pousadaOasis.getServicos()) {
                            if (s.getCodigo().equals(buscaCodServ)) {
                                s.exibirDados();
                                achouServ = true;
                                break;
                            }
                        }
                        if (!achouServ) System.out.println("Serviço não encontrado!");
                        break;

                    case 7:
                        System.out.println("\n--- LISTA DE SERVIÇOS ---");
                        for (Servico s : pousadaOasis.getServicos()) {
                            s.exibirDados();
                        }
                        break;

                    case 8:
                        System.out.println("\n--- CADASTRAR RESERVA ---");
                        System.out.print("Código da Reserva: ");
                        String codReserva = scanner.nextLine();
                        
                        System.out.print("CPF do Hóspede Responsável: ");
                        String cpfResp = scanner.nextLine();
                        Hospede hospedeResp = null;
                        for (Hospede h : pousadaOasis.getHospedes()) {
                            if (h.getCpf().equals(cpfResp)) hospedeResp = h;
                        }
                        
                        if (hospedeResp == null) {
                            System.out.println("Erro: Hóspede não encontrado. Cadastre o hóspede primeiro!");
                            break;
                        }

                        System.out.print("Código da Acomodação: ");
                        String codAcomReserv = scanner.nextLine();
                        Acomodacao acomReserv = null;
                        for (Acomodacao a : pousadaOasis.getAcomodacoes()) {
                            if (a.getCodigo().equals(codAcomReserv)) acomReserv = a;
                        }

                        if (acomReserv == null) {
                            System.out.println("Erro: Acomodação não encontrada!");
                            break;
                        }

                        System.out.print("Quantidade de Hóspedes: ");
                        int qtdHospedes = scanner.nextInt();
                        System.out.print("Quantidade de Dias: ");
                        int qtdDias = scanner.nextInt();
                        scanner.nextLine();

                        Reserva novaReserva = new Reserva(codReserva, hospedeResp, acomReserv, qtdHospedes, qtdDias);
                        pousadaOasis.getReservas().add(novaReserva);
                        System.out.println("Reserva cadastrada com sucesso!");
                        break;

                    case 9:
                        System.out.print("Código da Reserva: ");
                        String buscaRes = scanner.nextLine();
                        Reserva resEncontrada = null;
                        for (Reserva r : pousadaOasis.getReservas()) {
                            if (r.getCodigo().equals(buscaRes)) resEncontrada = r;
                        }

                        if (resEncontrada == null) {
                            System.out.println("Reserva não encontrada!");
                            break;
                        }

                        System.out.print("Código do Serviço: ");
                        String buscaSrv = scanner.nextLine();
                        Servico srvEncontrado = null;
                        for (Servico s : pousadaOasis.getServicos()) {
                            if (s.getCodigo().equals(buscaSrv)) srvEncontrado = s;
                        }

                        if (srvEncontrado == null) {
                            System.out.println("Serviço não encontrado!");
                            break;
                        }

                        resEncontrada.adicionarServico(srvEncontrado);
                        System.out.println("Serviço adicionado à reserva com sucesso!");
                        break;

                    case 10:
                        System.out.print("Digite o código da reserva: ");
                        String codExibirRes = scanner.nextLine();
                        boolean achouRes = false;
                        for (Reserva r : pousadaOasis.getReservas()) {
                            if (r.getCodigo().equals(codExibirRes)) {
                                System.out.println("Reserva: " + r.getCodigo() + " | Responsável: " + r.getHospedeResponsavel().getNome());
                                System.out.println("Acomodação: " + r.getAcomodacao().getCodigo() + " | Dias: " + r.getQuantidadeDias());
                                System.out.println("Serviços Contratados: " + r.getServicosContratados().size());
                                achouRes = true;
                                break;
                            }
                        }
                        if (!achouRes) System.out.println("Reserva não encontrada!");
                        break;

                    case 11:
                        System.out.println("\n--- LISTA DE RESERVAS ---");
                        for (Reserva r : pousadaOasis.getReservas()) {
                            System.out.println("- Reserva: " + r.getCodigo() + " | Cliente: " + r.getHospedeResponsavel().getNome());
                        }
                        break;

                    case 12:
                        System.out.print("Digite o código da reserva para o extrato: ");
                        String codExtrato = scanner.nextLine();
                        Reserva resExtrato = null;
                        for (Reserva r : pousadaOasis.getReservas()) {
                            if (r.getCodigo().equals(codExtrato)) resExtrato = r;
                        }

                        if (resExtrato == null) {
                            System.out.println("Reserva não encontrada!");
                            break;
                        }

                        System.out.println("\n=== EXTRATO DA RESERVA [" + resExtrato.getCodigo() + "] ===");
                        System.out.println("Cliente: " + resExtrato.getHospedeResponsavel().getNome());
                        
                        double totalAcom = resExtrato.getAcomodacao().calcPrecTotal(resExtrato.getQuantidadeDias());
                        System.out.println("Valor total das Diárias: R$ " + totalAcom);
                        
                        if (!resExtrato.getServicosContratados().isEmpty()) {
                            System.out.println("Serviços Adicionais:");
                            for (Servico s : resExtrato.getServicosContratados()) {
                                System.out.println("  - " + s.getDescricao() + ": R$ " + s.calcPrecoTotal());
                            }
                        } else {
                            System.out.println("Nenhum serviço adicional contratado.");
                        }

                        System.out.println("---------------------------------");
                        System.out.println("TOTAL GERAL: R$ " + resExtrato.calcularPrecoTotal());
                        System.out.println("=================================");
                        break;

                    case 13:
                        System.out.println("Salvando dados...");
                        pousadaOasis.salvarHospedesNoArquivo();
                        pousadaOasis.salvarReservasNoArquivo();
                        break;

                    case 14:
                        System.out.println("Encerrando o sistema Pousada Oásis do Oeste. Até logo!");
                        break;

                    default:
                        System.out.println("Opção inválida! Escolha um número de 1 a 14.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("\n[ERRO DE DIGITAÇÃO]: Você digitou texto onde deveria ser um número!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\n[ERRO DE VALIDAÇÃO]: " + e.getMessage());
            }
        }
        scanner.close(); 
    }
}