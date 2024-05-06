public class Desenvolvedor extends Funcionario implements Trabalhavel {
    private String[] tecnologias;

    public Desenvolvedor(String nome, String matricula, String[] tecnologias) {
        super(nome, matricula);
        this.tecnologias = tecnologias;
    }

    @Override
    public double calcularSalario() {
        // Salário base + bônus por tecnologias dominadas
        return 3000 + tecnologias.length * 500;
    }

    @Override
    public void trabalhar() {
        System.out.println("Desenvolvedor " + getNome() + " está desenvolvendo utilizando as tecnologias: ");
        for (String tecnologia : tecnologias) {
            System.out.println(tecnologia);
        }
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Desenvolvedor " + getNome() + " está relatando o progresso do desenvolvimento");
    }
} 
