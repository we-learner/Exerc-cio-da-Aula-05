import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Aluno{
    private String matricula;
    private double nota;
    
    public Aluno(String matricula, double nota){
        this.matricula = matricula;
        this.nota = nota;
    }
    
    public String getMatricula(){
        return matricula;
    }
    
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    
    public double getNota(){
        return nota;
    }
    
    public void setNota(double nota){
        this.nota = nota;
    }
    
    public String obterConceito(){
        if (nota >= 9){
            return "A";
        }else if (nota >= 7){
            return "B";
        }else if (nota >= 5){
            return "C";
        }else{
            return "D";
        }
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();
        String resposta;
        
        do{
            System.out.println("Digite a Matricula do aluno: ");
            String matricula = scanner.nextLine();
        
            System.out.println("Digite a Nota: ");
            double nota = scanner.nextDouble();
            scanner.nextLine();
            
            Aluno aluno = new Aluno(matricula, nota);
            alunos.add(aluno);
        
            System.out.print("Deseja informar outro aluno? (s/n): ");
            resposta = scanner.nextLine();

        } while (resposta.equalsIgnoreCase("s"));
        
        System.out.println("\nConceitos finais dos alunos:");
        for (Aluno aluno : alunos) {
            System.out.println("Aluno: " + aluno.getMatricula() + " - Conceito: " + aluno.obterConceito());
        }
        
        scanner.close();
    }
}
