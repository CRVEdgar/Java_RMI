package application;

import interfaces.AlunoService;
import model.Aluno;

import java.rmi.Naming;
import java.util.List;
public class AlunoServiceClient {

    public static void main(String[] args) {

        try {

            AlunoService alunoService = (AlunoService) Naming.lookup("//localhost/AlunoService");
            Aluno aluno = alunoService.getAluno("2019SI008");
            System.out.println("Aluno encontrado:" );
            System.out.println(aluno);

            System.out.println("\n Lista de alunos:");

            List<Aluno> alunos = alunoService.getAlunos();
            for (Aluno a : alunos) {
                System.out.println(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
