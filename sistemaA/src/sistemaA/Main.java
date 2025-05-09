package sistemaA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;

    public Main() {
        this.alunos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
    }

    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Cadastrar disciplina");
            System.out.println("3. Listar alunos");
            System.out.println("4. Listar disciplinas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir o \n

            switch (opcao) {
                case 1:
                    cadastrarAluno(scanner);
                    break;
                case 2:
                    cadastrarDisciplina(scanner);
                    break;
                case 3:
                    listarAlunos();
                    break;
                case 4:
                    listarDisciplinas();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    public void cadastrarAluno(Scanner scanner) {
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Matrícula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        if (verificarAlunoDuplicado(matricula)) {
            System.out.println("Aluno com essa matrícula já existe.");
            return;
        }

        System.out.print("Curso: ");
        String curso = scanner.nextLine();

        System.out.print("Tipo (normal ou especial): ");
        String tipo = scanner.nextLine();

        System.out.print("Número de presenças: ");
        int presencas = scanner.nextInt();

        System.out.print("Semestres trancados: ");
        int semestresTrancados = scanner.nextInt();
        scanner.nextLine();

        List<String> disciplinas = new ArrayList<>();
        List<String> disciplinasTrancadas = new ArrayList<>();

        Aluno aluno;
        if (tipo.equalsIgnoreCase("especial")) {
            aluno = new AlunoEspecial(nome, matricula, curso, disciplinas, disciplinasTrancadas, tipo, presencas, semestresTrancados);
        } else {
            aluno = new AlunoNormal(nome, matricula, curso, disciplinas, disciplinasTrancadas, tipo, presencas, semestresTrancados);
        }

        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public boolean verificarAlunoDuplicado(int matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                return true;
            }
        }
        return false;
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("\n--- Lista de Alunos ---");
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    public void cadastrarDisciplina(Scanner scanner) {
        System.out.print("Nome da disciplina: ");
        String nome = scanner.nextLine();
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Carga horária: ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();

        List<String> preRequisitos = new ArrayList<>();
        Disciplina disciplina = new Disciplina(nome, codigo, cargaHoraria, preRequisitos);
        disciplinas.add(disciplina);
        System.out.println("Disciplina cadastrada com sucesso!");
    }

    public void listarDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
        } else {
            System.out.println("\n--- Lista de Disciplinas ---");
            for (Disciplina d : disciplinas) {
                System.out.println("Nome: " + d.getNome() + ", Código: " + d.getCodigo());
            }
        }
    }

    public static void main(String[] args) {
        Main sistema = new Main();
        sistema.menuPrincipal();

		
    }

	
}

