package dao;

import connect.ConnectFactory;
import Model.Usuario;
import java.sql.*;
import java.time.LocalDate;
import java.sql.Date;
import util.AppLogger;


public class UsuarioDAO implements UsuarioDAOInterface {

    @Override
    public boolean cadastrar(Usuario usuario) {

        String sql = "INSERT INTO usuario (nome, email, senha, dataNascimento) VALUES (?, ?, ?, ?)";

        Connection conn = ConnectFactory.getConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());

            LocalDate data = usuario.getDataNascimento();
            if (data != null) {
                stmt.setDate(4, java.sql.Date.valueOf(data));
            } else {
                stmt.setNull(4, java.sql.Types.DATE);
            }

            stmt.execute();
            return true;

        } catch (SQLException e) {
            AppLogger.error("Erro ao cadastrar usuário", e);
            return false;
        }
    }
    
    @Override
    public Usuario login(String email, String senha) {

        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

        Connection conn = ConnectFactory.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Usuario u = new Usuario();

//                u.setId(rs.getInt("id"));
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
//                u.setDataNascimento(rs.getString("dataNascimento"));
                Date dataSql = rs.getDate("dataNascimento");
                if (dataSql != null) {
                    u.setDataNascimento(dataSql.toLocalDate());
                }                
                return u;
            }

        } catch (SQLException e) {
    AppLogger.error("Erro no login do usuário", e);
}
        return null;
    }
    
    //Editar as informações do usuario
    @Override
    public boolean editar(Usuario usuario) {

        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, dataNascimento = ? WHERE idUsuario = ?";

        Connection conn = ConnectFactory.getConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());

            if (usuario.getDataNascimento() != null) {
                stmt.setDate(4, java.sql.Date.valueOf(usuario.getDataNascimento()));
            } else {
                stmt.setNull(4, java.sql.Types.DATE);
            }

            stmt.setInt(5, usuario.getIdUsuario());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            AppLogger.error("Erro ao editar usuário", e);
            return false;
        }
    }
    
    
    // Excluir conta
    @Override
    public boolean excluir(int idUsuario) {

        String sql = "DELETE FROM usuario WHERE idUsuario = ?";

        Connection conn = ConnectFactory.getConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            AppLogger.error("Erro ao excluir usuário", e);
            return false;
        }
    }
    
}
