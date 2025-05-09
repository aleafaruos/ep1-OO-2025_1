package sistemaA;
import java.util.List;

public class AlunoEspecial extends Aluno {
    public AlunoEspecial(String nome, int matricula, String curso, List<String> disciplinas,List<String>disciplinasTrancadas,String tipo,int presencas,int semestreTrancado){
        super(nome, matricula, curso, disciplinas, disciplinasTrancadas, tipo, presencas, semestreTrancado);
    }

    @Override
    public void adicionarDisciplina(String disciplina) {
        if(getDisciplinas().size() < 2) { 
            getDisciplinas().add(disciplina);
        } else {
            System.out.println("Limite de disciplinas a ser cursadas atingido!");
        }
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Matrícula: " + getMatricula() + ", Curso: " + getCurso() + ", Tipo: " + getTipo();
    }


}