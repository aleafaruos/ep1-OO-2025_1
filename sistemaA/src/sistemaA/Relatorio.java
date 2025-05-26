package sistemaA;

import java.util.List;

public class Relatorio {

    public static void gerarRelatorioPorTurma(Turma turma) {
        System.out.println("=== Relatório da Turma: " + turma.getCodigo() + " ===");

        List<Aluno> alunos = turma.getAlunosMatriculados();
        int totalAulas = turma.getTotalAulas();

        for (Aluno aluno : alunos) {
            
            double media = aluno.calcularMediaPorDisciplina(turma.getDisciplina().getCodigo());
            int presencas = turma.getPresencas(aluno.getMatricula());
            double frequencia = (totalAulas > 0) ? (presencas * 100.0) / totalAulas : 0.0;
            String situacao = "Indefinido";
            try {
                situacao = obterSituacao(media, frequencia);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.printf("Aluno: %s | Média: %.2f | Frequência: %.2f%% | Situação: %s\n",
                    aluno.getNome(), media, frequencia, situacao);
        }

        System.out.println("======================================");
    }

    public static double calcularMedia(Aluno aluno, Turma turma) {
        List<Avaliacao> avaliacoes = aluno.getAvaliacoes();
        double p1 = 0, p2 = 0, p3 = 0, l = 0, s = 0;

        for (Avaliacao a : avaliacoes) {
            if (!a.getDisciplina().equals(turma.getDisciplina())) continue;

            switch (a.getNomeAvaliacao()) {
                case "P1": p1 = a.getNota(); break;
                case "P2": p2 = a.getNota(); break;
                case "P3": p3 = a.getNota(); break;
                case "L": l = a.getNota(); break;
                case "S": s = a.getNota(); break;
            }
        }

        if (turma.getTipoAvaliacao() == 1) {
            return (p1 + p2 + p3 + l + s) / 5;
        } else {
            return (p1 + p2 + p3 + l) / 4;
        }
    }

    public static double calcularFrequencia(Aluno aluno, int totalAulas) {
        int presencas = aluno.getPresencas();
        return (presencas * 100.0) / totalAulas;
    }

    public static String obterSituacao(double media, double frequencia) {
        if (media >= 6.0 && frequencia >= 75.0) {
            return "Aprovado";
        } else if (frequencia < 75.0) {
            return "Reprovado por frequência";
        } else {
            return "Reprovado por nota";
        }
    }

    public static void gerarRelatorioPorDisciplina(List<Disciplina> disciplinas, List<Aluno> alunos) {
        for (Disciplina d : disciplinas) {
            System.out.println("Relatório da disciplina: " + d.getNome());
            int aprovados = 0;
            int reprovados = 0;
            double somaNotas = 0;
            int totalAlunos = 0;

            for (Aluno a : alunos) {
                if (a.getDisciplinas().contains(d.getCodigo())) {
                    totalAlunos++;
                    double media = a.calcularMediaPorDisciplina(d.getCodigo());
                    if (media >= 6.0) {
                        aprovados++;
                    } else {
                        reprovados++;
                    }
                    somaNotas += media;
                }
            }

            double mediaGeral = totalAlunos > 0 ? somaNotas / totalAlunos : 0;
            System.out.printf("Alunos: %d | Aprovados: %d | Reprovados: %d | Média: %.2f\n",
                    totalAlunos, aprovados, reprovados, mediaGeral);
        }
    }

    public static void gerarRelatorioPorProfessor(List<Turma> turmas) {
        System.out.println("Relatório por professor:");
        for (Turma turma : turmas) {
            System.out.println("Professor: " + turma.getProfessor().getNome() + " | Turma: " + turma.getCodigo());
        }
    }
}
