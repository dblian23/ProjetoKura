package dao;

import connect.ConnectFactory;
import Model.Usuario;
import java.sql.*;
import java.time.LocalDate;
    

public class UsuarioDAO {

    public boolean cadastrar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email, senha, dataNascimento) VALUES (?, ?, ?, ?)";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
//            stmt.setString(4, usuario.getDataNascimento());
             LocalDate data = usuario.getDataNascimento();
            if (data != null) {
                stmt.setDate(4, Date.valueOf(data));
            } else {
                stmt.setNull(4, Types.DATE);
            }
            
            
            stmt.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
            return false;
        }
    }

    public Usuario login(String email, String senha) {

        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

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
            System.out.println("Erro no login: " + e.getMessage());
        }
        return null;
    }
}
