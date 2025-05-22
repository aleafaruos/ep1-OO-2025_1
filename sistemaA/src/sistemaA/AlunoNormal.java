package sistemaA;

import java.util.List;

public class AlunoNormal extends Aluno {
    private boolean receberNotas;

    public AlunoNormal(String nome, int matricula, String curso, List<String> disciplinas, List<String> disciplinasTrancadas,
                       String tipo, int presencas, int semestreTrancado, boolean receberNotas) {
        super(nome, matricula, curso, disciplinas, disciplinasTrancadas, tipo, presencas, semestreTrancado);
        this.receberNotas = receberNotas;
    }

    public boolean isReceberNotas() {
        return receberNotas;
    }

    public void setReceberNotas(boolean receberNotas) {
        this.receberNotas = receberNotas;
    }

    @Override
    public void adicionarDisciplina(String disciplina) {
        if (!getDisciplinas().contains(disciplina)) {
            super.adicionarDisciplina(disciplina);
        }
    }
}
