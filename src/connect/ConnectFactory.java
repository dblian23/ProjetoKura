// Classe que conecta o netbeens no mysql

package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectFactory {

    public Connection getConnection() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            // Faz conexão
            return DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/projetokuramysql",
                    "root",
                    "Manu@02139786"
            );

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado:\n" + e.getMessage());
            return null;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco:\n" + e.getMessage());
            return null;
        }
    }
}
