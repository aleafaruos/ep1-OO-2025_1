package sistemaA;
import java.util.List;
import java.util.ArrayList; 

public class Turma {
    private int codigodeTurma;
    private Disciplina disciplina;
    private String professor;
    private int horario;
    private int capacidadeMaxima;
    private List<Aluno>alunos;



    public Turma(){
        this.codigodeTurma=0;
        this.disciplina=null;
        this.professor="";
        this.horario=0;
        this.capacidadeMaxima=0;
        this.alunos = new ArrayList<>();
    }

    public int getCodigodeTurma(){
        return codigodeTurma;
    }

    public Disciplina getDisciplina(){
        return disciplina;
    }

    public String getProfessor(){
        return professor;
    }

    public int getHorario(){
        return horario;
    }

    public int getCapacidadeMaxima(){
        return capacidadeMaxima;
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
        
        if (alunos.contains(aluno)){
            alunos.remove(aluno);
            System.out.println("aluno removido"); 
            return true;  
            
        }
         else {
            System.out.println("Aluno não encontrado");
            return false;  
        }
    }

    public boolean verificarVagas() {
        return alunos.size() < capacidadeMaxima;
    }

}