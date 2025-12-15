// Classe que conecta o netbeens no mysql

package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.AppLogger;

public class ConnectFactory {

    public Connection getConnection() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            // Faz conexão
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/projetokura",
                    "root",
                    "MatheusLopes200209!"
            );

        } catch (ClassNotFoundException e) {
            AppLogger.error("Driver JDBC não encontrado", e);
            return null;

        } catch (SQLException e) {
            AppLogger.error("Erro de conexão com o banco de dados", e);
            return null;
}
    }
}
