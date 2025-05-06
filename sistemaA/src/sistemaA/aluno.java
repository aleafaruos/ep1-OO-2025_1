package io.github.jiangdequan;
import java.util.ArrayList;
import java.util.List;

public class aluno {
    private String nome;
    private int idade;
    private String curso;
    private List<String>disciplinas;
    private List<String>disciplinasTrancadas;
    private String tipo;
    private int semestreTrancado;
    private int presencas;


    public aluno(String nome, int idade, String curso,List<String>disciplinas,List<String>disciplinasTrancadas,String tipo, int presencas, int semestresTrancados){
        this.nome="";
        this.idade=0;
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


    public int getdade(){
        return idade;
    }

    public String getCurso(){
        return curso;
    }

    public void adicionarDisciplinas(String disciplina){
        disciplinas.add(disciplina);
    }

    public void adicionarDisciplinaTrancada(String disciplina) {
        this.disciplinasTrancadas.add(disciplina);
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