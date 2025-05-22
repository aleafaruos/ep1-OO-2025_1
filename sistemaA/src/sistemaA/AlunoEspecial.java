package sistemaA;

import java.util.List;

public class AlunoEspecial extends Aluno {

    public AlunoEspecial(String nome, int matricula, String curso, List<String> disciplinas, List<String> disciplinasTrancadas,
                         String tipo, int presencas, int semestreTrancado) {
        super(nome, matricula, curso, disciplinas, disciplinasTrancadas, tipo, presencas, semestreTrancado);
    }

    @Override
    public void adicionarDisciplina(String disciplina) {
        if (getDisciplinas().size() < 2) {
            super.adicionarDisciplina(disciplina);
        } else {
            System.out.println("Aluno especial não pode ter mais de 2 disciplinas.");
        }
    }
}
