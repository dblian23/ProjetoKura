package controller;

import dao.TarefaDAO;
import java.time.LocalDate;
import model.Tarefa;
import java.util.ArrayList;

public class TarefaController {

    TarefaDAO dao = new TarefaDAO();

    public boolean criarTarefa(String titulo, String descricao, String materia, String prioridade, String dataEntrega, int usuarioId) {

        Tarefa t = new Tarefa(
            titulo,
            descricao,
            materia,
            prioridade,
            LocalDate.now().toString(),
            dataEntrega,
            usuarioId
        );

        return dao.salvar(t);
    }

    public ArrayList<Tarefa> listar(int usuarioId) {
        return dao.listar(usuarioId);
    }
}
