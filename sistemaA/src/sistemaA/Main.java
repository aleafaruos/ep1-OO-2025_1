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
                    cadastrarDisciplina(sistema, scanner);
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
                    for (Turma turma : sistema.getTurmas()) {
                        Relatorio.gerarRelatorioPorTurma(turma);
                    }
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

    public static void cadastrarDisciplina(SistemaAcademico sistema, Scanner scanner) {
        System.out.print("Nome da disciplina: ");
        String nome = scanner.nextLine();

        System.out.print("Código da disciplina: ");
        String codigo = scanner.nextLine();

        int cargaHoraria = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Carga horária da disciplina (em horas): ");
            String entrada = scanner.nextLine().replaceAll("[^\\d]", ""); 
            try {
                cargaHoraria = Integer.parseInt(entrada);
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite apenas números para a carga horária (ex: 60).");
            }
        }

        List<String> preRequisitos = new ArrayList<>();
        System.out.print("A disciplina possui pré-requisitos? (s/n): ");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            boolean adicionando = true;
            while (adicionando) {
                System.out.print("Digite o código do pré-requisito: ");
                String pre = scanner.nextLine();
                preRequisitos.add(pre);

                System.out.print("Deseja adicionar outro pré-requisito? (s/n): ");
                String continuar = scanner.nextLine();
                if (!continuar.equalsIgnoreCase("s")) {
                    adicionando = false;
                }
            }
        }

        Disciplina disciplina = new Disciplina(nome, codigo, cargaHoraria, preRequisitos);
        sistema.cadastrarDisciplina(disciplina);
        System.out.println("Disciplina cadastrada com sucesso.");
    }

    private static void criarTurma() {
        System.out.print("Código da turma: ");
        String codigoTurma = scanner.nextLine();

        System.out.print("Código da disciplina da turma: ");
        String codigoDisciplina = scanner.nextLine();

        Disciplina disciplina = sistema.buscarDisciplinaPorCodigo(codigoDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        System.out.print("Nome do professor responsável: ");
        String nomeProfessor = scanner.nextLine();
        System.out.print("CPF do professor: ");
        String cpfProfessor = scanner.nextLine();
        System.out.print("Email do professor: ");
        String emailProfessor = scanner.nextLine();
        Professor professor = new Professor(nomeProfessor, cpfProfessor, emailProfessor);

        System.out.print("Capacidade máxima: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine();

        Turma turma = new Turma(codigoTurma, disciplina, professor, capacidade);
        sistema.cadastrarTurma(turma);
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

        List<Disciplina> disciplinasDisponiveis = sistema.getDisciplinas();
        if (disciplinasDisponiveis.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada no sistema. Cadastre uma disciplina antes.");
            return;
        }

        System.out.println("Disciplinas disponíveis:");
        for (Disciplina d : disciplinasDisponiveis) {
            System.out.println("- Código: " + d.getCodigo() + " | Nome: " + d.getNome());
        }

        System.out.println("Digite os códigos das disciplinas que o aluno vai cursar, separados por vírgula:");
        String input = scanner.nextLine();
        String[] partes = input.split(",");
        List<String> disciplinasAluno = new ArrayList<>();
        for (String parte : partes) {
            String codigo = parte.trim();
            Disciplina disc = sistema.buscarDisciplinaPorCodigo(codigo);
            if (disc != null) {
                disciplinasAluno.add(disc.getCodigo());
            } else {
                System.out.println("Código de disciplina inválido ignorado: " + codigo);
            }
        }

        if (disciplinasAluno.isEmpty()) {
            System.out.println("Nenhuma disciplina válida selecionada. Cadastro cancelado.");
            return;
        }

        List<String> disciplinasTrancadas = new ArrayList<>();
        String tipoAluno = (tipo == 1) ? "normal" : (tipo == 2) ? "especial" : "";
        if (tipoAluno.isEmpty()) {
            System.out.println("Tipo inválido! Cadastro cancelado.");
            return;
        }

        Aluno aluno;
        if (tipo == 1) {
            aluno = new AlunoNormal(nome, matricula, curso, disciplinasAluno, disciplinasTrancadas, tipoAluno, 0, 0, true);
        } else {
            aluno = new AlunoEspecial(nome, matricula, curso, disciplinasAluno, disciplinasTrancadas, tipoAluno, 0, 0);
        }

        sistema.cadastrarAluno(aluno);
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
        String codigoTurma = scanner.nextLine();

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
        String codigoTurma = scanner.nextLine();

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

        System.out.print("Código da disciplina da turma: ");
        String codigoDisciplina = scanner.nextLine();

        Disciplina disciplina = sistema.buscarDisciplinaPorCodigo(codigoDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        System.out.print("Nome da avaliação: ");
        String nomeAvaliacao = scanner.nextLine();

        System.out.print("Nota da avaliação: ");
        double nota = scanner.nextDouble();
        scanner.nextLine(); 

        Avaliacao avaliacao = new Avaliacao(disciplina, nomeAvaliacao, nota);
        aluno.adicionarAvaliacao(avaliacao);
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
        String codigoDisciplina = scanner.nextLine();

        Disciplina disciplina = sistema.buscarDisciplinaPorCodigo(codigoDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        System.out.print("Aluno presente? (s/n): ");
        String presenca = scanner.nextLine();

        boolean presente = presenca.equalsIgnoreCase("s");
      
        if (presente) {
            try {
                java.lang.reflect.Field f = aluno.getClass().getSuperclass().getDeclaredField("presencas");
                f.setAccessible(true);
                int valorAtual = f.getInt(aluno);
                f.setInt(aluno, valorAtual + 1);
            } catch (Exception e) {
                System.out.println("Erro ao registrar presença: " + e.getMessage());
                return;
            }
        }
        System.out.println("Presença registrada.");
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

        aluno.exibirBoletim();
    }
}
