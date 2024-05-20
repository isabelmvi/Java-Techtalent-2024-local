package UD18_connection_JAVA_SQL;

import java.sql.*;

public class peliculasysalas_sql {

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
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS peliculasysalas");
            statement.executeUpdate("USE peliculasysalas");

            // Crear tabla peliculas
            String createPeliculasTableQuery = "CREATE TABLE IF NOT EXISTS peliculas (" +
                                                "Codigo INT NOT NULL AUTO_INCREMENT," +
                                                "Nombre VARCHAR(100) DEFAULT NULL," +
                                                "CalificacionEdad INT DEFAULT NULL," +
                                                "PRIMARY KEY (Codigo)" +
                                                ")";
            statement.executeUpdate(createPeliculasTableQuery);
            System.out.println("Tabla peliculas creada o ya existente");

            // Crear tabla salas
            String createSalasTableQuery = "CREATE TABLE IF NOT EXISTS salas (" +
                                            "Codigo INT NOT NULL AUTO_INCREMENT," +
                                            "Nombre VARCHAR(100) DEFAULT NULL," +
                                            "Pelicula INT DEFAULT NULL," +
                                            "PRIMARY KEY (Codigo)," +
                                            "KEY Pelicula (Pelicula)," +
                                            "CONSTRAINT salas_ibfk_1 FOREIGN KEY (Pelicula) REFERENCES peliculas (Codigo)" +
                                            ")";
            statement.executeUpdate(createSalasTableQuery);
            System.out.println("Tabla salas creada o ya existente");

            // Insertar datos en la tabla peliculas
            String insertPeliculasQuery = "INSERT INTO peliculas (Nombre, CalificacionEdad) VALUES " +
                                           "('Titanic', 13)," +
                                           "('The Shawshank Redemption', 16)," +
                                           "('The Godfather', 18)," +
                                           "('Forrest Gump', 12)," +
                                           "('Pulp Fiction', 18)," +
                                           "('The Matrix', 16)," +
                                           "('Inception', 13)," +
                                           "('The Silence of the Lambs', 18)," +
                                           "('The Lion King', 0)," +
                                           "('The Dark Knight', 16)";
            statement.executeUpdate(insertPeliculasQuery);
            System.out.println("Datos insertados en la tabla peliculas");

            // Insertar datos en la tabla salas
            String insertSalasQuery = "INSERT INTO salas (Nombre, Pelicula) VALUES " +
                                       "('Sala 1', 1)," +
                                       "('Sala 2', 2)," +
                                       "('Sala 3', 3)," +
                                       "('Sala 4', 4)," +
                                       "('Sala 5', 5)," +
                                       "('Sala 6', 6)," +
                                       "('Sala 7', 7)," +
                                       "('Sala 8', 8)," +
                                       "('Sala 9', 9)," +
                                       "('Sala 10', 10)";
            statement.executeUpdate(insertSalasQuery);
            System.out.println("Datos insertados en la tabla salas");

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
