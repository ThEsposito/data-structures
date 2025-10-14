package E_linked_lists.aula1;

import E_linked_lists.LinkedList;
import E_linked_lists.Node;

public class Turma {
    private LinkedList<Aluno> alunos;
    public void adicionarAluno(Aluno aluno){
        alunos.addLast(aluno);
    }

    public void imprimeLista() {
        int n = alunos.getSize();

        for(int i=0; i<n; i++){
            System.out.println(alunos.get(i).getData());
        }
    }

    public double calculaMediaTurma() {
        double acumulator = 0;

        Node<Aluno> pAnda = alunos.getHead();

        while(pAnda != null){
            acumulator += pAnda.getData().calcularMedia();
            pAnda = pAnda.getNext();
        }

        return acumulator/alunos.getSize();
        // for(int i=0; i < alunos.getSize(); i++){
        //     acumulator += alunos.get(i).getData().calcularMedia();
        // }

        // return acumulator/alunos.getSize();
    }
}
