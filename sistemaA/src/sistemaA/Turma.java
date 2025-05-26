package sistemaA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Turma {
    private String codigo;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunosMatriculados;
    private Map<Integer, Integer> presencas;
    private int capacidade;
    private int totalAulas;
    private int tipoAvaliacao;

    public Turma(String codigo, Disciplina disciplina, Professor professor, int capacidade) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.capacidade = capacidade;
        this.alunosMatriculados = new ArrayList<>();
        this.presencas = new HashMap<>();
        this.totalAulas = 0;
        this.tipoAvaliacao = 1;
        if (professor != null) {
            professor.adicionarTurma(this);
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getTotalAulas() {
        return totalAulas;
    }

    public void setTotalAulas(int totalAulas) {
        this.totalAulas = totalAulas;
    }

    public int getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(int tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public boolean matricularAluno(Aluno aluno) {
        if (alunosMatriculados.size() >= capacidade) {
            return false;
        }
        if (!alunosMatriculados.contains(aluno)) {
            alunosMatriculados.add(aluno);
            presencas.put(aluno.getMatricula(), 0);
            return true;
        }
        return false;
    }

    public void registrarPresenca(int matriculaAluno) {
        if (presencas.containsKey(matriculaAluno)) {
            presencas.put(matriculaAluno, presencas.get(matriculaAluno) + 1);
            totalAulas++; 
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
        System.out.println("Alunos matriculados na turma " + codigo + ":");
        if (professor != null) {
            System.out.println("Professor responsável: " + professor.getNome());
        }
        if (alunosMatriculados.isEmpty()) {
            System.out.println("Nenhum aluno matriculado nesta turma.");
        } else {
            for (Aluno aluno : alunosMatriculados) {
                System.out.println(aluno);
            }
        }
    }
}
