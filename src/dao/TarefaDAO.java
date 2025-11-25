package dao;

import connect.ConnectFactory;
import model.Tarefa;

import java.sql.*;
import java.util.ArrayList;

public class TarefaDAO {

    public boolean salvar(Tarefa tarefa) {
        String sql = "INSERT INTO tarefa (titulo, descricao, materia, prioridade, dataCriacao, dataEntrega, usuarioId)"
                   + " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getMateria());
            stmt.setString(4, tarefa.getPrioridade());
            stmt.setString(5, tarefa.getDataCriacao());
            stmt.setString(6, tarefa.getDataEntrega());
            stmt.setInt(7, tarefa.getUsuarioId());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao salvar tarefa: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Tarefa> listar(int usuarioId) {
        ArrayList<Tarefa> lista = new ArrayList<>();
        String sql = "SELECT * FROM tarefa WHERE usuarioId = ?";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Tarefa t = new Tarefa();
//                t.setId(rs.getInt("id"));
                t.setTitulo(rs.getString("titulo"));
                t.setDescricao(rs.getString("descricao"));
                t.setMateria(rs.getString("materia"));
                t.setPrioridade(rs.getString("prioridade"));
                t.setDataCriacao(rs.getString("dataCriacao"));
                t.setDataEntrega(rs.getString("dataEntrega"));
                t.setUsuarioId(usuarioId);

                lista.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar tarefas: " + e.getMessage());
        }
        return lista;
    }
}
