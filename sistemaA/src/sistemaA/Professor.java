package sistemaA;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private String cpf;
    private String email;
    private List<Turma> turmas;

    public Professor(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.turmas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void adicionarTurma(Turma turma) {
        if (!turmas.contains(turma)) {
            turmas.add(turma);
        }
    }

    public void listarTurmas() {
        System.out.println("Turmas do professor " + nome + ":");
        for (Turma turma : turmas) {
            System.out.println("- " + turma.getCodigo() + " (" + turma.getDisciplina().getNome() + ")");
        }
    }

    @Override
    public String toString() {
        return "Professor: " + nome + ", CPF: " + cpf + ", Email: " + email;
    }
}
