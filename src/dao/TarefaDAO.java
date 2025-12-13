package dao;

import connect.ConnectFactory;
import Model.Tarefa;
import Model.Usuario;
import java.time.LocalDate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    private Connection conn;

    public TarefaDAO() {
        this.conn = new ConnectFactory().getConnection();
    }

    // Criar tarefa
    public boolean criar(Tarefa t) {
        String sql = "INSERT INTO tarefa (titulo, descricao, materia, prioridade, dataEntrega, idUsuario) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, t.getTitulo());
            stmt.setString(2, t.getDescricao());
            stmt.setString(3, t.getMateria());
            stmt.setString(4, t.getPrioridade());
 //           stmt.setString(5, t.getDataEntrega());
            stmt.setDate(5, Date.valueOf(t.getDataEntrega()));
            stmt.setInt(6, t.getUsuario().getIdUsuario());

            stmt.execute();
            stmt.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Editar tarefa
    public boolean editar(Tarefa t) {
        String sql = "UPDATE tarefa SET titulo=?, descricao=?, materia=?, prioridade=?, dataEntrega=? WHERE idTarefa=?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, t.getTitulo());
            stmt.setString(2, t.getDescricao());
            stmt.setString(3, t.getMateria());
            stmt.setString(4, t.getPrioridade());
            stmt.setDate(5, Date.valueOf(t.getDataEntrega())); 
            stmt.setInt(6, t.getIdTarefa());

            stmt.executeUpdate();
            stmt.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Excluir tarefa
    public boolean excluir(int idTarefa) {
        String sql = "DELETE FROM tarefa WHERE idTarefa = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idTarefa);

            stmt.executeUpdate();
            stmt.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Listar tarefas por usuário
    public List<Tarefa> listarPorUsuario(Usuario usuario) {

        List<Tarefa> lista = new ArrayList<>();
        String sql = "SELECT * FROM tarefa WHERE idUsuario = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuario.getIdUsuario());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Tarefa t = new Tarefa();
                t.setIdTarefa(rs.getInt("idTarefa"));
                t.setTitulo(rs.getString("titulo"));
                t.setDescricao(rs.getString("descricao"));
                t.setMateria(rs.getString("materia"));
                t.setPrioridade(rs.getString("prioridade"));
                t.setDataEntrega(rs.getDate("dataEntrega").toLocalDate());

                t.setUsuario(usuario); // associa o usuário dono da tarefa

                lista.add(t);
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
