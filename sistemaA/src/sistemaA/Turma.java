package sistemaA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Turma {
    private String codigo;
    private Disciplina disciplina;
    private List<Aluno> alunosMatriculados;
    private Map<Integer, Integer> presencas;

    public Turma(String codigo, Disciplina disciplina) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.alunosMatriculados = new ArrayList<>();
        this.presencas = new HashMap<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void adicionarAluno(Aluno aluno) {
        if (!alunosMatriculados.contains(aluno)) {
            alunosMatriculados.add(aluno);
            presencas.put(aluno.getMatricula(), 0);
        }
    }

    public void registrarPresenca(int matriculaAluno) {
        if (presencas.containsKey(matriculaAluno)) {
            int presencasAtuais = presencas.get(matriculaAluno);
            presencas.put(matriculaAluno, presencasAtuais + 1);
        }
    }

    public int getPresencas(int matriculaAluno) {
        return presencas.getOrDefault(matriculaAluno, 0);
    }

    public double calcularFrequencia(int matriculaAluno, int totalAulas) {
        int presencasAluno = getPresencas(matriculaAluno);
        if (totalAulas == 0) return 0;
        return ((double) presencasAluno / totalAulas) * 100;
    }

    public void listarAlunos() {
        if (alunosMatriculados.isEmpty()) {
            System.out.println("Nenhum aluno matriculado nesta turma.");
        } else {
            System.out.println("Alunos matriculados na turma " + codigo + ":");
            for (Aluno aluno : alunosMatriculados) {
                System.out.println(aluno);
            }
        }
    }
}
