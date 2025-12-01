package controller;

import dao.TarefaDAO;
import Model.Tarefa;
import Model.Usuario;
import java.util.List;

public class TarefaController {

    private TarefaDAO dao;

    public TarefaController() {
        this.dao = new TarefaDAO();
    }

    public boolean criar(Tarefa t) {
        return dao.criar(t);
    }

    public List<Tarefa> listarPorUsuario(Usuario u) {
        return dao.listarPorUsuario(u);
    }
}
