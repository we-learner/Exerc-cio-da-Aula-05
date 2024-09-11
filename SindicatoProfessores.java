import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sindicato sindicato = new Sindicato();

        boolean continuar = true;

        while (continuar) {
            System.out.println();
            Professor professor = new Professor();

            System.out.println("""
                            [1] Adicionar professor
                            [2] Ver total arrecadado
                            [3] Quantidade de mestres
                            [4] Sair""");
            int opcaoUsuario = scanner.nextInt();

            switch (opcaoUsuario) {
                case 1:
                    professor.receberDados();
                    sindicato.adicionarProfessores(professor);
                    System.out.println("Professor adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("O total arrecadado pelo sindicato é: " + sindicato.calculaTotalArrecadado());
                    break;
                case 3:
                    System.out.println("O total de professores que são mestres é: " + sindicato.contarMestres());
                    break;
                case 4:
                    System.out.println("Saindo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

        scanner.close();
    }
}

class Professor {
    private String nome;
    private String cpf;
    private String titulacao;
    private double salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void receberDados() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome: ");
        setNome(scanner.nextLine());

        System.out.println("Informe o cpf: ");
        setCpf(scanner.nextLine());

        System.out.println("Informe a titulação (Especialista, Mestre, Doutor): ");
        setTitulacao(scanner.nextLine());

        System.out.println("Informe o salário: ");
        setSalario(scanner.nextDouble());
    }

    public double calculaContribuicao() {
        switch (titulacao.toLowerCase()) {
            case "especialista":
                return (salario * 1.2) / 100;
            case "mestre":
                return (salario * 1.4) / 100;
            case "doutor":
                return (salario * 1.6) / 100;
            default:
                return 0;
        }
    }
}

class Sindicato {
    private final List<Professor> professores = new ArrayList<>();

    public void adicionarProfessores(Professor professor) {
        professores.add(professor);
    }

    public double calculaTotalArrecadado() {
        return professores.stream()
                .mapToDouble(Professor::calculaContribuicao)
                .sum();
    }

    public int contarMestres() {
        return (int) professores.stream()
                .filter(professor -> professor.getTitulacao().equalsIgnoreCase("Mestre"))
                .count();
    }
}
