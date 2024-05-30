package UD18_connection_JAVA_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class investigadores_facultad {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            // Establecer la conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useTimezone=true&serverTimezone=UTC", "root", "");

            // Crear la base de datos
            Statement statement = conexion.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS investigadores_facultad");
            statement.executeUpdate("USE investigadores_facultad");

            // Crear tabla facultad
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS facultad (" +
                    "Codigo INT NOT NULL," +
                    "Nombre VARCHAR(100) DEFAULT NULL," +
                    "PRIMARY KEY (Codigo)" +
                    ")");
            System.out.println("Tabla facultad creada");

            // Insertar datos en la tabla facultad
            statement.executeUpdate("INSERT IGNORE INTO facultad (Codigo, Nombre) VALUES " +
                    "(1, 'Facultad de Ciencias'), " +
                    "(2, 'Facultad de Ingeniería'), " +
                    "(3, 'Facultad de Medicina'), " +
                    "(4, 'Facultad de Artes'), " +
                    "(5, 'Facultad de Derecho'), " +
                    "(6, 'Facultad de Economía'), " +
                    "(7, 'Facultad de Educación'), " +
                    "(8, 'Facultad de Psicología'), " +
                    "(9, 'Facultad de Comunicación'), " +
                    "(10, 'Facultad de Veterinaria')");
            System.out.println("Datos insertados en la tabla facultad");

            // Crear tabla equipos
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS equipos (" +
                    "NumSerie CHAR(4) NOT NULL," +
                    "Nombre VARCHAR(100) DEFAULT NULL," +
                    "Facultad INT NOT NULL," +
                    "FOREIGN KEY (Facultad) REFERENCES facultad(Codigo)" +
                    ")");
            System.out.println("Tabla equipos creada");

            // Insertar datos en la tabla equipos
            statement.executeUpdate("INSERT IGNORE INTO equipos (NumSerie, Nombre, Facultad) VALUES " +
                    "('1234', 'Equipo A', 1), " +
                    "('5678', 'Equipo B', 2), " +
                    "('9101', 'Equipo C', 3), " +
                    "('2345', 'Equipo D', 1), " +
                    "('6789', 'Equipo E', 2), " +
                    "('1011', 'Equipo F', 3), " +
                    "('3456', 'Equipo G', 1), " +
                    "('7890', 'Equipo H', 2), " +
                    "('1112', 'Equipo I', 3), " +
                    "('4567', 'Equipo J', 1)");
            System.out.println("Datos insertados en la tabla equipos");

            // Crear tabla investigadores
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS investigadores (" +
                    "DNI VARCHAR(9) NOT NULL," +
                    "NomApels VARCHAR(255) DEFAULT NULL," +
                    "Facultad INT DEFAULT NULL" +
                    ")");
            System.out.println("Tabla investigadores creada");

            // Insertar datos en la tabla investigadores
            statement.executeUpdate("INSERT IGNORE INTO investigadores (DNI, NomApels, Facultad) VALUES " +
                    "('123456789', 'Juan Pérez', 1), " +
                    "('987654321', 'María Gómez', 2), " +
                    "('567890123', 'Pedro Martínez', 3), " +
                    "('321098765', 'Ana López', 1), " +
                    "('135792468', 'Luis García', 2), " +
                    "('246801357', 'Laura Rodríguez', 3), " +
                    "('111222333', 'Carlos Sánchez', 1), " +
                    "('444555666', 'Elena Fernández', 2), " +
                    "('777888999', 'Sofía Díaz', 3), " +
                    "('888999000', 'David Ruiz', 1)");
            System.out.println("Datos insertados en la tabla investigadores");

            // Crear tabla reserva
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS reserva (" +
                    "DNI VARCHAR(9) DEFAULT NULL," +
                    "NumSerie CHAR(4) DEFAULT NULL," +
                    "Comienzo DATE DEFAULT '2024-05-04'," +
                    "Fin DATE DEFAULT '2025-05-03'" +
                    ")");
            System.out.println("Tabla reserva creada");

            // Insertar datos en la tabla reserva
            statement.executeUpdate("INSERT IGNORE INTO reserva (DNI, NumSerie, Comienzo, Fin) VALUES " +
                    "('123456789', '1234', '2024-05-04', '2025-05-03'), " +
                    "('987654321', '5678', '2024-05-05', '2025-05-04'), " +
                    "('567890123', '9101', '2024-05-06', '2025-05-05'), " +
                    "('321098765', '2345', '2024-05-07', '2025-05-06'), " +
                    "('135792468', '6789', '2024-05-08', '2025-05-07'), " +
                    "('246801357', '1011', '2024-05-09', '2025-05-08'), " +
                    "('111222333', '3456', '2024-05-10', '2025-05-09'), " +
                    "('444555666', '7890', '2024-05-11', '2025-05-10'), " +
                    "('777888999', '1112', '2024-05-12', '2025-05-11'), " +
                    "('888999000', '4567', '2024-05-13', '2025-05-12')");
            System.out.println("Datos insertados en la tabla reserva");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
