
import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
  
  private String nome;
  private LocalDate dataNasc;
  private double altura;
  
  public Pessoa(String nome, LocalDate dataNasc, double altura){
    this.nome = nome;
    this.dataNasc = dataNasc;
    this.altura = altura;
  }
  
  public String getNome(){
    return nome;
  }
  public void setNome (String nome){
    this.nome = nome;
  }
  public LocalDate getDataNasc(){
    return dataNasc;
  }
  public void setdataNasc(LocalDate dataNasc){
    this.dataNasc = dataNasc;
  }
  public double getAltura(){
    return altura;
  }
  public void setAltura(double altura){
    this.altura = altura;
  }
  
  public int calcularIdade(){
    return Period.between(dataNasc, LocalDate.now()).getYears();
  }
  
  public void imprimirDados(){
    System.out.println("\nNome: " +nome);
    System.out.println("Data de nascimento: " +dataNasc);
    System.out.println("Altura: " +altura);
    System.out.println("Idade: " +calcularIdade());

  }

    public static void main(String[] args) {
      Pessoa P1 = new Pessoa("Samantha", LocalDate.of(2003,5,12), 1.60);
      P1.imprimirDados();
      Pessoa P2 = new Pessoa("Maria", LocalDate.of(2000,3, 20), 1.65);
      P2.imprimirDados();
  }
}