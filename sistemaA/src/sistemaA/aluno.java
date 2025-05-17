package sistemaA;
import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private int matricula;
    private String curso;
    private List<String> disciplinas;
    private List<String> disciplinasTrancadas;
    private String tipo;
    private int semestreTrancado;
    private int presencas;
    private List<Avaliacao> avaliacoes;

    public Aluno(String nome, int matricula, String curso, List<String> disciplinas, List<String> disciplinasTrancadas, String tipo, int presencas, int semestresTrancados) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.disciplinas = disciplinas != null ? disciplinas : new ArrayList<>();
        this.disciplinasTrancadas = disciplinasTrancadas != null ? disciplinasTrancadas : new ArrayList<>();
        this.tipo = tipo;
        this.semestreTrancado = semestresTrancados;
        this.presencas = presencas;
        this.avaliacoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public List<String> getDisciplinas() {
        return disciplinas;
    }

    public String getTipo() {
        return tipo;
    }

    public int getSemestreTrancado() {
        return semestreTrancado;
    }

    public int getPresencas() {
        return presencas;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void adicionarDisciplina(String disciplina) {
        disciplinas.add(disciplina);
    }

    public void adicionarDisciplinaTrancada(String disciplina) {
        disciplinasTrancadas.add(disciplina);
    }

    public void removerDisciplinaTrancada(String disciplina) {
        disciplinasTrancadas.remove(disciplina);
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public void setTipo(String tipo) {
        if (tipo.equalsIgnoreCase("normal") || tipo.equalsIgnoreCase("especial")) {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("Tipo de aluno inválido");
        }
    }

    public boolean trancarDisciplina(String disciplina) {
        if (disciplinas.contains(disciplina)) {
            disciplinas.remove(disciplina);
            disciplinasTrancadas.add(disciplina);
            return true;
        }
        return false;
    }

    public boolean retomarDisciplina(String disciplina) {
        if (disciplinasTrancadas.contains(disciplina)) {
            disciplinasTrancadas.remove(disciplina);
            disciplinas.add(disciplina);
            return true;
        }
        return false;
    }

    public void trancarMatricula() {
        this.semestreTrancado++;
        System.out.println("Matrícula trancada. Total de semestres trancados: " + semestreTrancado);
    }

    public void retomarMatricula() {
        if (semestreTrancado > 0) {
            this.semestreTrancado = 0;
            System.out.println("Matrícula retomada.");
        } else {
            System.out.println("A matrícula não estava trancada.");
        }
    }

    public boolean isMatriculaTrancada() {
        return semestreTrancado > 0;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Matrícula: " + matricula + ", Curso: " + curso + ", Tipo: " + tipo + ", Presenças: " + presencas;
    }
}
