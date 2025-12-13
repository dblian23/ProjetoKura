package test;


import dao.TarefaDAO;


import Model.Tarefa;
import Model.Usuario;
import dao.TarefaDAO;
import java.time.LocalDate;


public class TesteTarefa {

    public static void main(String[] args) {

        Usuario u = new Usuario();
        u.setIdUsuario(8); // ID que EXISTE no banco

        Tarefa t = new Tarefa();
        t.setTitulo("Trabalho de POO");
        t.setDescricao("Implementar DAO");
        t.setMateria("Programação");
        t.setPrioridade("Alta");
        t.setDataEntrega(LocalDate.of(2025, 12, 20));
        t.setUsuario(u);

        TarefaDAO dao = new TarefaDAO();

        if (dao.criar(t)) {
            System.out.println("Tarefa inserida com sucesso!");
        } else {
            System.out.println("Erro ao inserir tarefa.");
        }
        
    }
    
}


