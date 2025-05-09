package sistemaA;
import java.util.List;

public class AlunoNormal extends Aluno{
    private String receberNotas;


    public AlunoNormal(String nome, int matricula, String curso, List<String>disciplinas, List<String>disciplinasTrancadas,String tipo, int presencas, int semestresTrancados){
        super(nome,matricula,curso,disciplinas,disciplinasTrancadas,tipo,presencas,semestresTrancados);
        this.receberNotas="";
    }

    public String getReceberNotas(){
        return receberNotas;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Matrícula: " + getMatricula() + ", Curso: " + getCurso() + ", Tipo: " + getTipo();
    }

}