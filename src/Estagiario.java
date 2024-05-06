public class Estagiario extends Funcionario implements Trabalhavel {
    private int horasTrabalho;
    private double salarioHora;
    private String supervisor;

    public Estagiario(String nome, String matricula, int horasTrabalho, String supervisor, double salarioHora) {
        super(nome, matricula);
        this.horasTrabalho = horasTrabalho;
        this.salarioHora = salarioHora;
        this.supervisor = supervisor;
    }

    @Override
    public double calcularSalario() {
        // Calcula o salário multiplicando as horas trabalhadas pelo salário por hora
        return horasTrabalho * salarioHora;
    }

    @Override
    public void trabalhar() {
        System.out.println("Estagiário " + getNome() + " está trabalhando sob supervisão de " + supervisor);
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Estagiário " + getNome() + " está relatando o progresso do trabalho");
    }
}
