package E_linked_lists.aula1;

public class Aluno {
    private double nota1, nota2;
    private String nome;

    public Aluno(String nome, double nota1, double nota2){
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nome = nome;
    }

    public double calcularMedia(){
        return (nota1+nota2)/2;
    }

    public String toString() {
        return "Nome: " + nome + ", Nota1: " + nota1 + ", Nota2: " + nota2; 
    }
}
