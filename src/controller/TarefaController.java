package controller;

import dao.TarefaDAOInterface;
import dao.TarefaDAO;
import Model.Tarefa;
import Model.Usuario;
import java.util.List;

public class TarefaController {

    private TarefaDAOInterface dao;

    public TarefaController() {
        this.dao = new TarefaDAO();
    }

    public boolean criar(Tarefa t) {
        return dao.criar(t);
    }

    public boolean editar(Tarefa t) {
        return dao.editar(t);
    }

    public boolean excluir(int idTarefa) {
        return dao.excluir(idTarefa);
    }

    public List<Tarefa> listarPorUsuario(Usuario u) {
        return dao.listarPorUsuario(u);
    }
}
