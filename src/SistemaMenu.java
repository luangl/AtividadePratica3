import java.util.ArrayList;
import java.util.Scanner;

public class SistemaMenu {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void executar() {
        int opcao;
        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    removerFuncionario();
                    break;
                case 3:
                    listarFuncionarios();
                    break;
                case 4:
                    buscarFuncionario();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n----Sistema de Gerenciamento de Funcionários----");
        System.out.println("1. Adicionar Funcionário");
        System.out.println("2. Remover Funcionário");
        System.out.println("3. Listar Funcionários");
        System.out.println("4. Buscar Funcionário");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void adicionarFuncionario() {
        System.out.println("\n### Adicionar Funcionário ###");
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a matrícula do funcionário: ");
        String matricula = scanner.nextLine();
    
        System.out.println("Escolha o tipo de funcionário:");
        System.out.println("1. Gerente");
        System.out.println("2. Desenvolvedor");
        System.out.println("3. Estagiário");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); 
    
        switch (opcao) {
            case 1:
                System.out.print("Digite o bônus anual do gerente: ");
                double bonusAnual = scanner.nextDouble();
                scanner.nextLine(); 
                System.out.print("Digite a equipe do gerente: ");
                String equipe = scanner.nextLine();
                
                Gerente gerente = new Gerente(nome, matricula, bonusAnual, equipe);
                gerente.trabalhar();
                gerente.relatarProgresso();
                funcionarios.add(gerente);
                break;
            case 2:
                System.out.print("Digite as tecnologias que o desenvolvedor domina (separadas por vírgula): ");
                String[] tecnologias = scanner.nextLine().split(",");
                Desenvolvedor desenvolvedor = new Desenvolvedor(nome, matricula, tecnologias);
                desenvolvedor.trabalhar();
                desenvolvedor.relatarProgresso();
                funcionarios.add(desenvolvedor);
                break;
                case 3:
                System.out.print("Digite as horas de trabalho do estagiário: ");
                int horasTrabalho = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Digite o salário por hora do estagiário: ");
                double salarioHora = scanner.nextDouble();
                scanner.nextLine(); 
                System.out.print("Digite o nome do supervisor do estagiário: ");
                String supervisor = scanner.nextLine();
                Estagiario estagiario = new Estagiario(nome, matricula, horasTrabalho, supervisor, salarioHora);
                estagiario.trabalhar();
                estagiario.relatarProgresso();
                funcionarios.add(estagiario);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
    

    private void removerFuncionario() {
        System.out.println("\n### Remover Funcionário ###");
        System.out.print("Digite a matrícula do funcionário a ser removido: ");
        String matricula = scanner.nextLine();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula().equals(matricula)) {
                funcionarios.remove(funcionario);
                System.out.println("Funcionário removido com sucesso.");
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    private void listarFuncionarios() {
        System.out.println("\n### Listagem de Funcionários ###");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    private void buscarFuncionario() {
        System.out.println("\n### Buscar Funcionário ###");
        System.out.println("Escolha o critério de busca:");
        System.out.println("1. Por nome");
        System.out.println("2. Por matrícula");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); 
    
        switch (opcao) {
            case 1:
                System.out.print("Digite o nome do funcionário: ");
                String nome = scanner.nextLine();
                for (Funcionario funcionario : funcionarios) {
                    if (funcionario.getNome().equals(nome)) {
                        System.out.println("Funcionário encontrado: " + funcionario);
                        if (funcionario instanceof Desenvolvedor) {
                            ((Desenvolvedor) funcionario).trabalhar();
                            ((Desenvolvedor) funcionario).relatarProgresso();
                        } else if (funcionario instanceof Estagiario) {
                            ((Estagiario) funcionario).trabalhar();
                            ((Estagiario) funcionario).relatarProgresso();
                        } else if (funcionario instanceof Gerente) {
                            ((Gerente) funcionario).trabalhar();
                            ((Gerente) funcionario).relatarProgresso();
                        }
                        return;
                    }
                }
                System.out.println("Funcionário não encontrado.");
                break;
            case 2:
                System.out.print("Digite a matrícula do funcionário: ");
                String matricula = scanner.nextLine();
                for (Funcionario funcionario : funcionarios) {
                    if (funcionario.getMatricula().equals(matricula)) {
                        System.out.println("Funcionário encontrado: " + funcionario);
                        if (funcionario instanceof Desenvolvedor) {
                            ((Desenvolvedor) funcionario).trabalhar();
                            ((Desenvolvedor) funcionario).relatarProgresso();
                        } else if (funcionario instanceof Estagiario) {
                            ((Estagiario) funcionario).trabalhar();
                            ((Estagiario) funcionario).relatarProgresso();
                        } else if (funcionario instanceof Gerente) {
                            ((Gerente) funcionario).trabalhar();
                            ((Gerente) funcionario).relatarProgresso();
                        }
                        return;
                    }
                }
                System.out.println("Funcionário não encontrado.");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}   