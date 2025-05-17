package sistemaA;

import java.util.ArrayList;
import java.util.List;

public class SistemaAcademico {
    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;
    private List<Turma> turmas;

    public SistemaAcademico() {
        alunos = new ArrayList<>();
        disciplinas = new ArrayList<>();
        turmas = new ArrayList<>();
    }

    public boolean cadastrarAluno(Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getMatricula() == aluno.getMatricula()) {
                System.out.println("Aluno com matrícula " + aluno.getMatricula() + " já existe.");
                return false;
            }
        }
        alunos.add(aluno);
        System.out.println("Aluno cadastrado: " + aluno.getNome());
        return true;
    }

    public boolean cadastrarDisciplina(Disciplina disciplina) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equalsIgnoreCase(disciplina.getCodigo())) {
                System.out.println("Disciplina com código " + disciplina.getCodigo() + " já existe.");
                return false;
            }
        }
        disciplinas.add(disciplina);
        System.out.println("Disciplina cadastrada: " + disciplina.getNome());
        return true;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

}
