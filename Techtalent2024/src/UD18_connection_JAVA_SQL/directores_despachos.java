package UD18_connection_JAVA_SQL;

import java.sql.*;

public class directores_despachos {

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
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS directores_despachos");
            statement.executeUpdate("USE directores_despachos");

            // Crear tabla despachos
            String createDespachosTableQuery = "CREATE TABLE IF NOT EXISTS despachos (" +
                                                "num INT NOT NULL," + 
                                                "Capacidad INT NOT NULL," +
                                                "PRIMARY KEY (num)" +
                                                ")";
            statement.executeUpdate(createDespachosTableQuery);
            System.out.println("Tabla despachos creada o ya existente");

            // Insertar datos en la tabla despachos
            String insertDespachosQuery = "INSERT IGNORE INTO despachos (num, Capacidad) VALUES " +
                                           "('1', 5)," +
                                           "('2', 4)," +
                                           "('3', 6)," +
                                           "('4', 3)," +
                                           "('5', 7)," +
                                           "('6', 5)," +
                                           "('7', 4)," +
                                           "('8', 6)," +
                                           "('9', 3)," +
                                           "('10', 8)";
            statement.executeUpdate(insertDespachosQuery);
            System.out.println("Datos insertados en la tabla despachos");

            // Crear tabla directores
            String createDirectoresTableQuery = "CREATE TABLE IF NOT EXISTS directores (" +
                                                 "DNI VARCHAR(9) NOT NULL," +
                                                 "NomApels VARCHAR(255) DEFAULT NULL," +
                                                 "DNIJefe VARCHAR(9) DEFAULT NULL," +
                                                 "despacho VARCHAR(50) NOT NULL," + // Cambio de INT a VARCHAR
                                                 "PRIMARY KEY (DNI)," +
                                                 "KEY DNIJefe (DNIJefe)," +
                                                 "KEY despacho (despacho)," +
                                                 "CONSTRAINT directores_ibfk_1 FOREIGN KEY (DNIJefe) REFERENCES directores (DNI) ON DELETE CASCADE ON UPDATE CASCADE," +
                                                 "CONSTRAINT directores_ibfk_2 FOREIGN KEY (despacho) REFERENCES despachos (num) ON DELETE CASCADE ON UPDATE CASCADE" +
                                                 ")";
            statement.executeUpdate(createDirectoresTableQuery);
            System.out.println("Tabla directores creada o ya existente");

            // Insertar datos en la tabla directores
            String insertDirectoresQuery = "INSERT IGNORE INTO directores (DNI, NomApels, DNIJefe, despacho) VALUES " +
                                            "('123456789', 'Juan Pérez', NULL, 'D001')," +
                                            "('987654321', 'María López', '123456789', 'D002')," +
                                            "('234567890', 'Pedro Martínez', '123456789', 'D003')," +
                                            "('345678901', 'Ana García', '987654321', 'D004')," +
                                            "('456789012', 'Carlos Sánchez', '987654321', 'D005')," +
                                            "('567890123', 'Laura Rodríguez', '234567890', 'D006')," +
                                            "('678901234', 'David Fernández', '234567890', 'D007')," +
                                            "('789012345', 'Sofía Ruiz', '234567890', 'D008')," +
                                            "('890123456', 'Elena Gómez', '345678901', 'D009')," +
                                            "('901234567', 'Javier Díaz', '345678901', 'D010')";
            statement.executeUpdate(insertDirectoresQuery);
            System.out.println("Datos insertados en la tabla directores");

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error al conectar a la base de datos o ejecutar la consulta.");
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
