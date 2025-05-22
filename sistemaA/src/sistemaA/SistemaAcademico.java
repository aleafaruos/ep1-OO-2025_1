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

    public boolean cadastrarTurma(Turma turma) {
        for (Turma t : turmas) {
            if (t.getCodigo().equalsIgnoreCase(turma.getCodigo())) {
                System.out.println("Turma com código " + turma.getCodigo() + " já existe.");
                return false;
            }
        }
        turmas.add(turma);
        System.out.println("Turma cadastrada: " + turma.getCodigo());
        return true;
    }

    public Aluno buscarAlunoPorMatricula(int matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula() == matricula) {
                return a;
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

    public boolean matricularAlunoEmTurma(int matriculaAluno, String codigoTurma) {
        Aluno aluno = buscarAlunoPorMatricula(matriculaAluno);
        Turma turma = buscarTurmaPorCodigo(codigoTurma);

        if (aluno == null) {
            System.out.println("Aluno com matrícula " + matriculaAluno + " não encontrado.");
            return false;
        }
        if (turma == null) {
            System.out.println("Turma com código " + codigoTurma + " não encontrada.");
            return false;
        }

        if (turma.getAlunosMatriculados().contains(aluno)) {
            System.out.println("Aluno já está matriculado na turma " + codigoTurma);
            return false;
        }

        if (aluno.isMatriculaTrancada()) {
            System.out.println("Aluno está com matrícula trancada e não pode ser matriculado.");
            return false;
        }

        turma.adicionarAluno(aluno);
        aluno.adicionarDisciplina(turma.getDisciplina().getCodigo());
        System.out.println("Aluno matriculado com sucesso na turma " + codigoTurma);
        return true;
    }

    public boolean registrarPresenca(int matriculaAluno, String codigoTurma) {
        Turma turma = buscarTurmaPorCodigo(codigoTurma);
        if (turma == null) {
            System.out.println("Turma com código " + codigoTurma + " não encontrada.");
            return false;
        }
        List<Aluno> alunosMatriculados = turma.getAlunosMatriculados();
        for (Aluno aluno : alunosMatriculados) {
            if (aluno.getMatricula() == matriculaAluno) {
                turma.registrarPresenca(matriculaAluno);
                System.out.println("Presença registrada para o aluno " + aluno.getNome() + " na turma " + codigoTurma);
                return true;
            }
        }
        System.out.println("Aluno com matrícula " + matriculaAluno + " não está matriculado na turma " + codigoTurma);
        return false;
    }

    public double consultarFrequencia(int matriculaAluno, String codigoTurma, int totalAulas) {
        Turma turma = buscarTurmaPorCodigo(codigoTurma);
        if (turma == null) {
            System.out.println("Turma com código " + codigoTurma + " não encontrada.");
            return 0;
        }
        double frequencia = turma.calcularFrequencia(matriculaAluno, totalAulas);
        System.out.println("Frequência do aluno " + matriculaAluno + " na turma " + codigoTurma + ": " + frequencia + "%");
        return frequencia;
    }

    public boolean lancarNota(int matriculaAluno, String codigoTurma, double nota, String tipoAvaliacao) {
        Turma turma = buscarTurmaPorCodigo(codigoTurma);
        if (turma == null) {
            System.out.println("Turma com código " + codigoTurma + " não encontrada.");
            return false;
        }
        Aluno aluno = buscarAlunoPorMatricula(matriculaAluno);
        if (aluno == null) {
            System.out.println("Aluno com matrícula " + matriculaAluno + " não encontrado.");
            return false;
        }
        if (!turma.getAlunosMatriculados().contains(aluno)) {
            System.out.println("Aluno não está matriculado na turma " + codigoTurma);
            return false;
        }
        Avaliacao avaliacao = new Avaliacao(tipoAvaliacao, nota);
        aluno.adicionarAvaliacao(avaliacao);
        System.out.println("Nota lançada: " + nota + " para o aluno " + aluno.getNome() + " na turma " + codigoTurma);
        return true;
    }

    public void listarDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }
        for (Disciplina d : disciplinas) {
            System.out.println("Código: " + d.getCodigo() + ", Nome: " + d.getNome());
        }
    }

    public void listarTurmas() {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }
        for (Turma t : turmas) {
            System.out.println("Código: " + t.getCodigo() + ", Disciplina: " + t.getDisciplina().getNome());
        }
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
