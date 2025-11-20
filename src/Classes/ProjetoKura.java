package Classes;

import connect.ConnectFactory;
import java.sql.Connection;

public class ProjetoKura {
    public static void main(String[] args) {
        try {
            ConnectFactory factory = new ConnectFactory();
            Connection conn = factory.getConnection();

            if (conn != null) {
                System.out.println("Conectado com sucesso!");
                conn.close(); // Fecha a conexão após o teste
            } else {
                System.out.println("Conexão retornou nula.");
            }

        } catch (Exception e) {
            System.out.println("Programa não conectado: " + e.getMessage());
        }
    }  
}