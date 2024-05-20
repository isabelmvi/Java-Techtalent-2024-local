package UD18_connection_JAVA_SQL;

import java.sql.*;

public class tienda_informatica_sql {

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            // Establecer la conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda_informatica?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Connectado bien");
            // Insertar registros en la tabla de fabricantes
            Statement statement = conexion.createStatement();
            System.out.println("Satement ok");
            statement.executeUpdate("INSERT INTO fabricantes (Nombre) VALUES ('Fabricante 1')");
            statement.executeUpdate("INSERT INTO fabricantes (Nombre) VALUES ('Fabricante 2')");
            statement.executeUpdate("INSERT INTO fabricantes (Nombre) VALUES ('Fabricante 3')");
            statement.executeUpdate("INSERT INTO fabricantes (Nombre) VALUES ('Fabricante 4')");
            statement.executeUpdate("INSERT INTO fabricantes (Nombre) VALUES ('Fabricante 5')");
            System.out.println("insertado ok de fabricantes");
            // Insertar registros en la tabla de artículos
            statement.executeUpdate("INSERT INTO articulos (Nombre, Precio, Fabricante) VALUES ('Artículo 1', 100, 1)");
            statement.executeUpdate("INSERT INTO articulos (Nombre, Precio, Fabricante) VALUES ('Artículo 2', 200, 2)");
            statement.executeUpdate("INSERT INTO articulos (Nombre, Precio, Fabricante) VALUES ('Artículo 3', 150, 3)");
            statement.executeUpdate("INSERT INTO articulos (Nombre, Precio, Fabricante) VALUES ('Artículo 4', 180, 4)");
            statement.executeUpdate("INSERT INTO articulos (Nombre, Precio, Fabricante) VALUES ('Artículo 5', 120, 5)");

            System.out.println("Registros creados exitosamente.");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error al crear los registros.");
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
