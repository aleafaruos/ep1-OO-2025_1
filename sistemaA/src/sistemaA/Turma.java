package sistemaA;
import java.util.List;
import java.util.ArrayList; 

public class Turma {
    private int codigodeTurma;
    private Disciplina disciplina;
    private String professor;
    private int horario;
    private int capacidadeMaxima;
    private List<Aluno> alunos;

    public Turma() {
        this.codigodeTurma = 0;
        this.disciplina = null;
        this.professor = "";
        this.horario = 0;
        this.capacidadeMaxima = 0;
        this.alunos = new ArrayList<>();
    }

    public Turma(int codigodeTurma, Disciplina disciplina, String professor, int horario, int capacidadeMaxima) {
        this.codigodeTurma = codigodeTurma;
        this.disciplina = disciplina;
        this.professor = professor;
        this.horario = horario;
        this.capacidadeMaxima = capacidadeMaxima;
        this.alunos = new ArrayList<>();
    }

    public int getCodigodeTurma() {
        return codigodeTurma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public String getProfessor() {
        return professor;
    }

    public int getHorario() {
        return horario;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public boolean matricularAluno(Aluno aluno) {
        if (alunos.size() < capacidadeMaxima) {
            alunos.add(aluno);
            return true; 
        } else {
            return false;
        }
    }

    public boolean removerAluno(Aluno aluno) {
        if (alunos.contains(aluno)) {
            alunos.remove(aluno);
            System.out.println("Aluno removido"); 
            return true;  
        } else {
            System.out.println("Aluno não encontrado");
            return false;  
        }
    }

    public boolean verificarVagas() {
        return alunos.size() < capacidadeMaxima;
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno matriculado nesta turma.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println("RA: " + aluno.getRa() + " | Nome: " + aluno.getNome());
            }
        }
    }
}
