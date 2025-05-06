package sistemaA;
import java.util.ArrayList;
import java.util.List;

public class aluno {
    private String nome;
    private int matricula;
    private String curso;
    private List<String>disciplinas;
    private List<String>disciplinasTrancadas;
    private String tipo;
    private int semestreTrancado;
    private int presencas;


    public aluno(String nome, int matricula, String curso,List<String>disciplinas,List<String>disciplinasTrancadas,String tipo, int presencas, int semestresTrancados){
        this.nome="";
        this.matricula=0;
        this.curso="";
        this.disciplinas = new ArrayList<>();
        this.disciplinasTrancadas=new ArrayList<>();
        this.tipo="";
        this.semestreTrancado=0;
        this.presencas=0;
    }

    public String getNome(){
        return nome;
    }


    public int getMatricula(){
        return matricula;
    }

    public String getCurso(){
        return curso;
    }

    public List<String> getDisciplinas() {
        return disciplinas;
    }    

    public void adicionarDisciplina(String disciplina) {
        disciplinas.add(disciplina);
    }
    
    public void adicionarDisciplinaTrancada(String disciplinasTrancadas) {
        this.disciplinasTrancadas.add(disciplinasTrancadas);
    }
    
    public String getTipo(){
        return tipo;
    }

    public int getSemestreTrancado(){
        return semestreTrancado;
    }

    public int presencas(){
        return presencas;
    }

}