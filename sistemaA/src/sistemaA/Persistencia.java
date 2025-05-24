package sistemaA;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {
    private static final Gson gson = new Gson();
    private static final String ALUNOS_FILE = "alunos.json";
    private static final String PROFESSORES_FILE = "professores.json";
    private static final String DISCIPLINAS_FILE = "disciplinas.json";
    private static final String TURMAS_FILE = "turmas.json";
    private static final String AVALIACOES_FILE = "avaliacoes.json";

    public static void salvarAlunos(List<Aluno> alunos) {
        salvarLista(alunos, ALUNOS_FILE);
    }

    public static List<Aluno> carregarAlunos() {
        Type tipo = new TypeToken<ArrayList<Aluno>>(){}.getType();
        return carregarLista(ALUNOS_FILE, tipo);
    }

    public static void salvarProfessores(List<Professor> professores) {
        salvarLista(professores, PROFESSORES_FILE);
    }

    public static List<Professor> carregarProfessores() {
        Type tipo = new TypeToken<ArrayList<Professor>>(){}.getType();
        return carregarLista(PROFESSORES_FILE, tipo);
    }

    public static void salvarDisciplinas(List<Disciplina> disciplinas) {
        salvarLista(disciplinas, DISCIPLINAS_FILE);
    }

    public static List<Disciplina> carregarDisciplinas() {
        Type tipo = new TypeToken<ArrayList<Disciplina>>(){}.getType();
        return carregarLista(DISCIPLINAS_FILE, tipo);
    }

    public static void salvarTurmas(List<Turma> turmas) {
        salvarLista(turmas, TURMAS_FILE);
    }

    public static List<Turma> carregarTurmas() {
        Type tipo = new TypeToken<ArrayList<Turma>>(){}.getType();
        return carregarLista(TURMAS_FILE, tipo);
    }

    public static void salvarAvaliacoes(List<Avaliacao> avaliacoes) {
        salvarLista(avaliacoes, AVALIACOES_FILE);
    }

    public static List<Avaliacao> carregarAvaliacoes() {
        Type tipo = new TypeToken<ArrayList<Avaliacao>>(){}.getType();
        return carregarLista(AVALIACOES_FILE, tipo);
    }

    private static <T> void salvarLista(List<T> lista, String arquivo) {
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + arquivo + " - " + e.getMessage());
        }
    }

    private static <T> List<T> carregarLista(String arquivo, Type tipo) {
        try (FileReader reader = new FileReader(arquivo)) {
            List<T> lista = gson.fromJson(reader, tipo);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void salvarSistema(SistemaAcademico sistema) {
        salvarAlunos(sistema.getAlunos());
        salvarDisciplinas(sistema.getDisciplinas());
        salvarTurmas(sistema.getTurmas());
    }

    public static void carregarSistema(SistemaAcademico sistema) {
        sistema.getAlunos().clear();
        sistema.getAlunos().addAll(carregarAlunos());
        sistema.getDisciplinas().clear();
        sistema.getDisciplinas().addAll(carregarDisciplinas());
        sistema.getTurmas().clear();
        sistema.getTurmas().addAll(carregarTurmas());
    }
}
