package Classes;

import java.time.LocalDate;
import java.util.Scanner;

public class Tarefa {
    private String titulo;
    private String materia;
    private String descricao;
    private LocalDate dataEntrega;
    private Prioridade prioridade; 
    private boolean concluida; // indica se foi concluida ou não
    private boolean ativa; // indica se foi excluída do sistema

    // Construtor
    public Tarefa(String titulo, String materia, String descricao, LocalDate dataEntrega, Prioridade prioridade) {
        this.titulo = titulo;
        this.materia = materia;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.prioridade = prioridade;
        this.concluida = false;
        this.ativa = true;
    }

    // Criar nova tarefa
    public static Tarefa criarNovaTarefa() {
        Scanner sc = new Scanner(System.in);

        //System.out.print("Título: ");
        String titulo = sc.nextLine();

        //System.out.print("Matéria: ");
        String materia = sc.nextLine();

        //System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        //System.out.print("Data de entrega (AAAA-MM-DD): ");
        LocalDate dataEntrega = LocalDate.parse(sc.nextLine());

        // Acredito que não é assi  que faz para aparecer como menu suspenso, mas fiz para testar se funciona.
        System.out.println("Escolha a prioridade:");
        System.out.println("1 - Alta");
        System.out.println("2 - Média");
        System.out.println("3 - Baixa");
        int opc = Integer.parseInt(sc.nextLine());

        Prioridade prioridade = switch (opc) {
            case 1 -> Prioridade.Alta;
            case 2 -> Prioridade.Media;
            case 3 -> Prioridade.Baixa;
            default -> Prioridade.Media;
        };

        //System.out.println("Tarefa criada com sucesso!\n");
        return new Tarefa(titulo, materia, descricao, dataEntrega, prioridade);
    }

    // Excluir tarefa
    public void excluirTarefa() {
        this.ativa = false;
        System.out.println("Tarefa excluída do sistema: " + this.titulo);
    }

    // Marcar ou desmarcar conclusão
    public void marcarComoConcluida(boolean status) {
        if (!ativa) {
            System.out.println("Esta tarefa foi excluída e não pode ser alterada.");
            return;
        }
        this.concluida = status;
        //System.out.println(status ? "Tarefa concluída." : "Tarefa reaberta.");
    }

    // Alterar tarefa
    public void alterarTarefa() {
        if (!ativa) {
            System.out.println("Esta tarefa foi excluída e não pode ser alterada.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        //System.out.println("\nAlterar tarefa");
        //System.out.println("Pressione ENTER para manter o valor atual ou digite 'cancelar' para desistir.");

        String novoTitulo = this.titulo;
        String novaMateria = this.materia;
        String novaDescricao = this.descricao;
        LocalDate novaDataEntrega = this.dataEntrega;
        Prioridade novaPrioridade = this.prioridade;

        // Título
        System.out.print("Título atual (" + this.titulo + "): ");
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("cancelar")) return;
        if (!input.isEmpty()) novoTitulo = input;

        // Matéria
        System.out.print("Matéria atual (" + this.materia + "): ");
        input = sc.nextLine();
        if (input.equalsIgnoreCase("cancelar")) return;
        if (!input.isEmpty()) novaMateria = input;

        // Descrição
        System.out.print("Descrição atual (" + this.descricao + "): ");
        input = sc.nextLine();
        if (input.equalsIgnoreCase("cancelar")) return;
        if (!input.isEmpty()) novaDescricao = input;

        // Data de entrega
        System.out.print("Data de entrega atual (" + this.dataEntrega + "): ");
        input = sc.nextLine();
        if (input.equalsIgnoreCase("cancelar")) return;
        if (!input.isEmpty()) novaDataEntrega = LocalDate.parse(input);

        // Prioridade
        System.out.println("Prioridade atual (" + this.prioridade + "): ");
        System.out.println("1 - Alta | 2 - Média | 3 - Baixa");
        input = sc.nextLine();
        if (input.equalsIgnoreCase("cancelar")) return;
        if (!input.isEmpty()) {
            int opc = Integer.parseInt(input);
            novaPrioridade = switch (opc) {
                case 1 -> Prioridade.Alta;
                case 2 -> Prioridade.Media;
                case 3 -> Prioridade.Baixa;
                default -> novaPrioridade;
            };
        }

        // Confirmar alterações
        this.titulo = novoTitulo;
        this.materia = novaMateria;
        this.descricao = novaDescricao;
        this.dataEntrega = novaDataEntrega;
        this.prioridade = novaPrioridade;

        //System.out.println("Alterações salvas com sucesso!\n");
    }

    @Override
    public String toString() {
        if (!ativa) return "(Tarefa excluída do sistema)";
        return "Tarefa {" +
                "\n  Título: " + titulo +
                "\n  Matéria: " + materia +
                "\n  Descrição: " + descricao +
                "\n  Data de Entrega: " + dataEntrega +
                "\n  Prioridade: " + prioridade +
                "\n  Concluída: " + (concluida ? "Sim" : "Não") +
                "\n}";
    }
}