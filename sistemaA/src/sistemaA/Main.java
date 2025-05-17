package sistemaA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static SistemaAcademico sistema = new SistemaAcademico();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n==== SISTEMA ACADÊMICO ====");
            System.out.println("1. Cadastrar disciplina");
            System.out.println("2. Criar turma");
            System.out.println("3. Cadastrar aluno");
            System.out.println("4. Matricular aluno em turma");
            System.out.println("5. Listar alunos de uma turma");
            System.out.println("6. Lançar nota de avaliação");
            System.out.println("7. Registrar presença");
            System.out.println("8. Gerar boletim de um aluno");
            System.out.println("9. Gerar relatório por disciplina");
            System.out.println("10. Gerar relatório por turma");
            System.out.println("11. Gerar relatório por professor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarDisciplina();
                    break;
                case 2:
                    criarTurma();
                    break;
                case 3:
                    cadastrarAluno();
                    break;
                case 4:
                    matricularAlunoEmTurma();
                    break;
                case 5:
                    listarAlunosPorTurma();
                    break;
                case 6:
                    lancarNota();
                    break;
                case 7:
                    registrarPresenca();
                    break;
                case 8:
                    gerarBoletimAluno();
                    break;
                case 9:
                    Relatorio.gerarRelatorioPorDisciplina(sistema.getDisciplinas(), sistema.getAlunos());
                    break;
                case 10:
                    Relatorio.gerarRelatorioPorTurma(sistema.getTurmas());
                    break;
                case 11:
                    Relatorio.gerarRelatorioPorProfessor(sistema.getTurmas());
                    break;
                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void cadastrarDisciplina() {
        System.out.print("Código da disciplina: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome da disciplina: ");
        String nome = scanner.nextLine();
        sistema.adicionarDisciplina(new Disciplina(codigo, nome));
        System.out.println("Disciplina cadastrada.");
    }

    private static void criarTurma() {
        System.out.print("Código da turma: ");
        int codigoTurma = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Código da disciplina da turma: ");
        int codigoDisciplina = scanner.nextInt();
        scanner.nextLine();

        Disciplina disciplina = sistema.buscarDisciplinaPorCodigo(codigoDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        System.out.print("Professor responsável: ");
        String professor = scanner.nextLine();

        System.out.print("Horário (ex: 10 para 10h): ");
        int horario = scanner.nextInt();

        System.out.print("Capacidade máxima: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine();

        Turma turma = new Turma(codigoTurma, disciplina, professor, horario, capacidade);
        sistema.adicionarTurma(turma);
        System.out.println("Turma criada com sucesso.");
    }

    private static void cadastrarAluno() {
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Matrícula do aluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Curso do aluno: ");
        String curso = scanner.nextLine();

        System.out.print("Tipo do aluno (1 - Normal, 2 - Especial): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        List<Disciplina> disciplinasAluno = new ArrayList<>();
        List<Boolean> presencasAluno = new ArrayList<>();

        if (sistema.getDisciplinas().isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada no sistema. Cadastre uma disciplina antes.");
            return;
        }

        System.out.println("Disciplinas disponíveis:");
        List<Disciplina> disciplinas = sistema.getDisciplinas();
        for (int i = 0; i < disciplinas.size(); i++) {
            System.out.println((i + 1) + ". " + disciplinas.get(i).getNome());
        }

        System.out.println("Digite os números das disciplinas que o aluno vai cursar, separados por vírgula:");
        String input = scanner.nextLine();
        String[] partes = input.split(",");

        for (String parte : partes) {
            try {
                int indice = Integer.parseInt(parte.trim()) - 1;
                if (indice >= 0 && indice < disciplinas.size()) {
                    Disciplina disc = disciplinas.get(indice);
                    disciplinasAluno.add(disc);
                    presencasAluno.add(false);
                } else {
                    System.out.println("Número inválido ignorado: " + (indice + 1));
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida ignorada: " + parte);
            }
        }

        if (disciplinasAluno.isEmpty()) {
            System.out.println("Nenhuma disciplina válida selecionada. Cadastro cancelado.");
            return;
        }

        Aluno aluno;
        if (tipo == 1) {
            aluno = new AlunoNormal(nome, matricula, curso, disciplinasAluno, presencasAluno);
        } else if (tipo == 2) {
            aluno = new AlunoEspecial(nome, matricula, curso, disciplinasAluno, presencasAluno);
        } else {
            System.out.println("Tipo inválido! Cadastro cancelado.");
            return;
        }

        sistema.adicionarAluno(aluno);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    private static void matricularAlunoEmTurma() {
        System.out.print("Matrícula do aluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = sistema.buscarAlunoPorMatricula(matricula);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.print("Código da turma: ");
        int codigoTurma = scanner.nextInt();
        scanner.nextLine();

        Turma turma = sistema.buscarTurmaPorCodigo(codigoTurma);
        if (turma == null) {
            System.out.println("Turma não encontrada.");
            return;
        }

        boolean sucesso = turma.matricularAluno(aluno);
        if (sucesso) {
            System.out.println("Aluno matriculado na turma.");
        } else {
            System.out.println("Turma cheia. Matrícula não realizada.");
        }
    }

    private static void listarAlunosPorTurma() {
        System.out.print("Código da turma: ");
        int codigoTurma = scanner.nextInt();
        scanner.nextLine();

        Turma turma = sistema.buscarTurmaPorCodigo(codigoTurma);
        if (turma == null) {
            System.out.println("Turma não encontrada.");
            return;
        }

        System.out.println("\nAlunos da turma " + codigoTurma + ":");
        turma.listarAlunos();
    }

    private static void lancarNota() {
        System.out.print("Matrícula do aluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = sistema.buscarAlunoPorMatricula(matricula);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.print("Código da disciplina: ");
        int codigoDisciplina = scanner.nextInt();
        scanner.nextLine();

        Disciplina disciplina = sistema.buscarDisciplinaPorCodigo(codigoDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        if (!aluno.getDisciplinas().contains(disciplina)) {
            System.out.println("Aluno não está matriculado nessa disciplina.");
            return;
        }

        System.out.print("Nota da avaliação (0.0 a 10.0): ");
        double nota = scanner.nextDouble();
        scanner.nextLine();

        if (nota < 0.0 || nota > 10.0) {
            System.out.println("Nota inválida.");
            return;
        }

        aluno.lancarNota(disciplina, nota);
        System.out.println("Nota lançada com sucesso.");
    }

    private static void registrarPresenca() {
        System.out.print("Matrícula do aluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = sistema.buscarAlunoPorMatricula(matricula);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.print("Código da disciplina: ");
        int codigoDisciplina = scanner.nextInt();
        scanner.nextLine();

        Disciplina disciplina = sistema.buscarDisciplinaPorCodigo(codigoDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        if (!aluno.getDisciplinas().contains(disciplina)) {
            System.out.println("Aluno não está matriculado nessa disciplina.");
            return;
        }

        System.out.print("Aluno presente? (S/N): ");
        String presente = scanner.nextLine().toUpperCase();

        if (presente.equals("S")) {
            aluno.registrarPresenca(disciplina, true);
            System.out.println("Presença registrada.");
        } else if (presente.equals("N")) {
            aluno.registrarPresenca(disciplina, false);
            System.out.println("Falta registrada.");
        } else {
            System.out.println("Entrada inválida.");
        }
    }

    private static void gerarBoletimAluno() {
        System.out.print("Matrícula do aluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = sistema.buscarAlunoPorMatricula(matricula);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        aluno.gerarBoletim();
    }
}
