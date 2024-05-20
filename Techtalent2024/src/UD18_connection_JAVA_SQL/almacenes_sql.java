package UD18_connection_JAVA_SQL;

import java.sql.*;

public class almacenes_sql {

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            // Establecer la conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Conectado bien");
            Statement statement = conexion.createStatement();
            System.out.println("Statement ok");

            // Crear base de datos y usarla
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS almacenes");
            statement.executeUpdate("USE almacenes");

            // Crear tabla almacenes
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS almacenes (" +
                    "Codigo INT NOT NULL PRIMARY KEY," +
                    "Lugar VARCHAR(100)," +
                    "Capacidad INT NOT NULL" +
                    ")");
            System.out.println("Tabla almacenes creada ok");

            // Crear tabla cajas
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS cajas (" +
                    "NumReferencia CHAR(5) NOT NULL PRIMARY KEY," +
                    "Contenido VARCHAR(100)," +
                    "Valor INT NOT NULL," +
                    "Almacen INT NOT NULL," +
                    "FOREIGN KEY (Almacen) REFERENCES almacenes(Codigo)" +
                    ")");
            System.out.println("Tabla cajas creada ok");

            // Insertar datos en la tabla almacenes si no existen
            statement.executeUpdate("INSERT IGNORE INTO almacenes (Codigo, Lugar, Capacidad) VALUES (1, 'Almacén A', 100)");
            statement.executeUpdate("INSERT IGNORE INTO almacenes (Codigo, Lugar, Capacidad) VALUES (2, 'Almacén B', 150)");
            statement.executeUpdate("INSERT IGNORE INTO almacenes (Codigo, Lugar, Capacidad) VALUES (3, 'Almacén C', 200)");
            statement.executeUpdate("INSERT IGNORE INTO almacenes (Codigo, Lugar, Capacidad) VALUES (4, 'Almacén D', 120)");
            statement.executeUpdate("INSERT IGNORE INTO almacenes (Codigo, Lugar, Capacidad) VALUES (5, 'Almacén E', 180)");
            statement.executeUpdate("INSERT IGNORE INTO almacenes (Codigo, Lugar, Capacidad) VALUES (6, 'Almacén F', 220)");
            statement.executeUpdate("INSERT IGNORE INTO almacenes (Codigo, Lugar, Capacidad) VALUES (7, 'Almacén G', 130)");
            statement.executeUpdate("INSERT IGNORE INTO almacenes (Codigo, Lugar, Capacidad) VALUES (8, 'Almacén H', 190)");
            statement.executeUpdate("INSERT IGNORE INTO almacenes (Codigo, Lugar, Capacidad) VALUES (9, 'Almacén I', 170)");
            statement.executeUpdate("INSERT IGNORE INTO almacenes (Codigo, Lugar, Capacidad) VALUES (10, 'Almacén J', 210)");
            System.out.println("Datos insertados en la tabla almacenes ok");

            // Insertar datos en la tabla cajas si no existen
            statement.executeUpdate("INSERT IGNORE INTO cajas (NumReferencia, Contenido, Valor, Almacen) VALUES ('A1234', 'Libros', 50, 1)");
            statement.executeUpdate("INSERT IGNORE INTO cajas (NumReferencia, Contenido, Valor, Almacen) VALUES ('B5678', 'Ropa', 100, 2)");
            statement.executeUpdate("INSERT IGNORE INTO cajas (NumReferencia, Contenido, Valor, Almacen) VALUES ('C9101', 'Electrodomésticos', 200, 3)");
            statement.executeUpdate("INSERT IGNORE INTO cajas (NumReferencia, Contenido, Valor, Almacen) VALUES ('D1213', 'Juguetes', 80, 4)");
            statement.executeUpdate("INSERT IGNORE INTO cajas (NumReferencia, Contenido, Valor, Almacen) VALUES ('E1516', 'Herramientas', 120, 5)");
            statement.executeUpdate("INSERT IGNORE INTO cajas (NumReferencia, Contenido, Valor, Almacen) VALUES ('F1819', 'Electrónica', 150, 6)");
            statement.executeUpdate("INSERT IGNORE INTO cajas (NumReferencia, Contenido, Valor, Almacen) VALUES ('G2122', 'Muebles', 300, 7)");
            statement.executeUpdate("INSERT IGNORE INTO cajas (NumReferencia, Contenido, Valor, Almacen) VALUES ('H2425', 'Comida', 70, 8)");
            statement.executeUpdate("INSERT IGNORE INTO cajas (NumReferencia, Contenido, Valor, Almacen) VALUES ('I2728', 'Artículos deportivos', 90, 9)");
            statement.executeUpdate("INSERT IGNORE INTO cajas (NumReferencia, Contenido, Valor, Almacen) VALUES ('J3031', 'Productos de limpieza', 60, 10)");
            System.out.println("Datos insertados en la tabla cajas ok");

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
