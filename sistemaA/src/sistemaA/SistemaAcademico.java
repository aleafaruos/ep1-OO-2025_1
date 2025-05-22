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

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void cadastrarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void cadastrarTurma(Turma turma) {
        turmas.add(turma);
    }

    public Aluno buscarAlunoPorMatricula(int matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                return aluno;
            }
        }
        return null;
    }

    public Disciplina buscarDisciplinaPorCodigo(String codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equalsIgnoreCase(codigo)) {
                return d;
            }
        }
        return null;
    }

    public Turma buscarTurmaPorCodigo(String codigo) {
        for (Turma t : turmas) {
            if (t.getCodigo().equalsIgnoreCase(codigo)) {
                return t;
            }
        }
        return null;
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
