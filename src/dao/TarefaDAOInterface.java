package dao;

import Model.Tarefa;
import Model.Usuario;
import java.util.List;

public interface TarefaDAOInterface {

    boolean criar(Tarefa tarefa);

    boolean editar(Tarefa tarefa);

    boolean excluir(int idTarefa);

    List<Tarefa> listarPorUsuario(Usuario usuario);
}
