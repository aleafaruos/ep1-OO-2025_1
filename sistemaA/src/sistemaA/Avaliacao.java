package sistemaA;

public class Avaliacao {
    private Disciplina disciplina;
    private String nomeAvaliacao;
    private double nota;

    public Avaliacao(Disciplina disciplina, String nomeAvaliacao, double nota) {
        this.disciplina = disciplina;
        this.nomeAvaliacao = nomeAvaliacao;
        this.nota = nota;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public String getNomeAvaliacao() {
        return nomeAvaliacao;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
