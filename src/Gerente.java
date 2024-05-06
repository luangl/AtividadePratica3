public class Gerente extends Funcionario implements Trabalhavel {
    private double bonusAnual;
    private String equipe;

    public Gerente(String nome, String matricula, double bonusAnual, String equipe) {
        super(nome, matricula);
        this.bonusAnual = bonusAnual;
        this.equipe = equipe;
    }

    @Override
    public double calcularSalario() {
        return 5000 + bonusAnual;
    }

    @Override
    public void trabalhar() {
        System.out.println("Gerente " + getNome() + " está gerenciando a equipe " + equipe);
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Gerente " + getNome() + " está relatando o progresso da equipe " + equipe);
    }
}