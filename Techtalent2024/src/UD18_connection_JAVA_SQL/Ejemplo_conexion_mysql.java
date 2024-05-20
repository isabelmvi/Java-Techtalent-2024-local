package UD18_connection_JAVA_SQL;

import java.sql.*;

public class Ejemplo_conexion_mysql {

    public static void main(String[] args) {
        Connection conexion = null; // Declara la conexión fuera del try

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Server Connected");

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("No se ha podido conectar con mi base de datos");
            ex.printStackTrace();
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
