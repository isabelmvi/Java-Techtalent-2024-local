package UD18_connection_JAVA_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class grandes_almacenes {

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            // Establecer la conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useTimezone=true&serverTimezone=UTC", "root", "");

            // Crear la base de datos "grandes_almacenes" si no existe
            Statement statement = conexion.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS grandes_almacenes DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci");
            System.out.println("Base de datos 'grandes_almacenes' creada correctamente");

            // Usar la base de datos "grandes_almacenes"
            statement.executeUpdate("USE grandes_almacenes");
            System.out.println("Usando la base de datos 'grandes_almacenes'");

            // Crear tabla "cajeros"
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS cajeros (" +
                    "Codigo INT NOT NULL PRIMARY KEY," +
                    "NomApels VARCHAR(255)" +
                    ")");
            System.out.println("Tabla 'cajeros' creada correctamente");

            // Insertar datos en la tabla "cajeros"
            statement.executeUpdate("INSERT IGNORE INTO cajeros (Codigo, NomApels) VALUES " +
                    "(1, 'Juan Perez'), " +
                    "(2, 'Maria Rodriguez'), " +
                    "(3, 'Luis Garcia'), " +
                    "(4, 'Ana Martinez'), " +
                    "(5, 'Pedro Sanchez'), " +
                    "(6, 'Laura Gomez'), " +
                    "(7, 'Carlos Fernandez'), " +
                    "(8, 'Sara Lopez'), " +
                    "(9, 'Pablo Diaz'), " +
                    "(10, 'Elena Ruiz')");
            System.out.println("Datos insertados en la tabla 'cajeros' correctamente");

            // Crear tabla "maquinas_registradoras"
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS maquinas_registradoras (" +
                    "Codigo INT NOT NULL PRIMARY KEY," +
                    "Piso INT" +
                    ")");
            System.out.println("Tabla 'maquinas_registradoras' creada correctamente");

            // Insertar datos en la tabla "maquinas_registradoras"
            statement.executeUpdate("INSERT IGNORE INTO maquinas_registradoras (Codigo, Piso) VALUES " +
                    "(101, 1), " +
                    "(102, 1), " +
                    "(103, 2), " +
                    "(104, 2), " +
                    "(105, 3), " +
                    "(106, 3), " +
                    "(107, 4), " +
                    "(108, 4), " +
                    "(109, 5), " +
                    "(110, 5)");
            System.out.println("Datos insertados en la tabla 'maquinas_registradoras' correctamente");

            // Crear tabla "productos"
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS productos (" +
                    "Codigo INT NOT NULL PRIMARY KEY," +
                    "Nombre VARCHAR(100) DEFAULT NULL," +
                    "Precio INT DEFAULT NULL" +
                    ")");
            System.out.println("Tabla 'productos' creada correctamente");

            // Insertar datos en la tabla "productos"
            statement.executeUpdate("INSERT IGNORE INTO productos (Codigo, Nombre, Precio) VALUES " +
                    "(1001, 'Camiseta', 20), " +
                    "(1002, 'Pantalón', 30), " +
                    "(1003, 'Zapatos', 50), " +
                    "(1004, 'Bufanda', 15), " +
                    "(1005, 'Sombrero', 25), " +
                    "(1006, 'Gorra', 10), " +
                    "(1007, 'Calcetines', 5), " +
                    "(1008, 'Guantes', 8), " +
                    "(1009, 'Chaqueta', 40), " +
                    "(1010, 'Falda', 25)");
            System.out.println("Datos insertados en la tabla 'productos' correctamente");

            // Crear tabla "venta"
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS venta (" +
                    "Cajero INT," +
                    "Maquina INT," +
                    "Producto INT," +
                    "FOREIGN KEY (Cajero) REFERENCES cajeros(Codigo)," +
                    "FOREIGN KEY (Maquina) REFERENCES maquinas_registradoras(Codigo)," +
                    "FOREIGN KEY (Producto) REFERENCES productos(Codigo)" +
                    ")");
            System.out.println("Tabla 'venta' creada correctamente");

            // Insertar datos en la tabla "venta"
            statement.executeUpdate("INSERT IGNORE INTO venta (Cajero, Maquina, Producto) VALUES " +
                    "(1, 101, 1001), " +
                    "(2, 102, 1002), " +
                    "(3, 103, 1003), " +
                    "(4, 104, 1004), " +
                    "(5, 105, 1005), " +
                    "(6, 106, 1006), " +
                    "(7, 107, 1007), " +
                    "(8, 108, 1008), " +
                    "(9, 109, 1009), " +
                    "(10, 110, 1010)");
            System.out.println("Datos insertados en la tabla 'venta' correctamente");

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la ejecución de las consultas SQL.");
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
