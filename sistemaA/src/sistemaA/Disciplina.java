package sistemaA;
import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private String codigo;
    private int cargaHoraria;
    private List<String> preRequisitos;


    public Disciplina(String nome, String codigo, int cargaHoraria,List<String> preRequisitos){
        this.nome="";
        this.codigo="";
        this.cargaHoraria=0;
        this.preRequisitos=new ArrayList<String>();
}

    public String getNome(){
        return nome;
}

    public String getCodigo(){
        return codigo;
}

    public int getCargaHoraria(){
        return cargaHoraria;
}

    public List<String> getpreRequisitos(){
        return preRequisitos;

}

    public void adicionarPreRequisito(String disciplina){
        preRequisitos.add(disciplina);
    }

    public void removerPreRequisitos(String disciplina){
        preRequisitos.remove(disciplina);
    }

    public boolean verificarPreRequisitos(List<String> disciplinasMatriculadas) {
        return disciplinasMatriculadas.containsAll(preRequisitos);
    }
    
}