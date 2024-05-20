package UD18_connection_JAVA_SQL;

import java.sql.*;

public class cientificos_proyecto {

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            // Establecer la conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Conexión establecida");

            // Crear base de datos
            Statement statement = conexion.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS cientificos_proyecto");
            statement.executeUpdate("USE cientificos_proyecto");
            System.out.println("Base de datos creada y seleccionada correctamente");

            // Crear tabla cientificos
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS cientificos(" +
                    "DNI VARCHAR(9) NOT NULL," +
                    "PRIMARY KEY (DNI)," +
                    "NomApels VARCHAR(255)" +
                    ")");
            System.out.println("Tabla cientificos creada correctamente");

            // Insertar datos en la tabla cientificos
            statement.executeUpdate("INSERT IGNORE INTO cientificos (DNI, NomApels) VALUES " +
                    "('123456789', 'Juan Pérez')," +
                    "('987654321', 'María García')," +
                    "('456789123', 'Pedro López')," +
                    "('789123456', 'Ana Martínez')," +
                    "('321654987', 'Carlos Sánchez')," +
                    "('654987321', 'Laura Rodríguez')," +
                    "('147258369', 'David Fernández')," +
                    "('258369147', 'Sofía Ruiz')," +
                    "('369147258', 'Pablo Gómez')," +
                    "('741852963', 'Elena Díaz')");
            System.out.println("Datos insertados en la tabla cientificos");

            // Crear tabla proyecto
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS proyecto(" +
                    "id CHAR(4) NOT NULL," +
                    "PRIMARY KEY(id)," +
                    "Nombre VARCHAR(255)," +
                    "Horas INT NOT NULL" +
                    ")");
            System.out.println("Tabla proyecto creada correctamente");

            // Insertar datos en la tabla proyecto
            statement.executeUpdate("INSERT IGNORE INTO proyecto (id, Nombre, Horas) VALUES " +
                    "('P001', 'Proyecto A', 100)," +
                    "('P002', 'Proyecto B', 150)," +
                    "('P003', 'Proyecto C', 200)," +
                    "('P004', 'Proyecto D', 120)," +
                    "('P005', 'Proyecto E', 180)," +
                    "('P006', 'Proyecto F', 90)," +
                    "('P007', 'Proyecto G', 140)," +
                    "('P008', 'Proyecto H', 170)," +
                    "('P009', 'Proyecto I', 130)," +
                    "('P010', 'Proyecto J', 160)");
            System.out.println("Datos insertados en la tabla proyecto");

            // Crear tabla asignado_a
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS asignado_a(" +
                    "Cientifico VARCHAR(8) NOT NULL," +
                    "FOREIGN KEY(Cientifico) REFERENCES cientificos(DNI)," +
                    "Proyecto CHAR(4) NOT NULL," +
                    "FOREIGN KEY(Proyecto) REFERENCES proyecto(id)" +
                    ")");
            System.out.println("Tabla asignado_a creada correctamente");

            // Insertar datos en la tabla asignado_a
            statement.executeUpdate("INSERT INTO asignado_a (Cientifico, Proyecto) VALUES " +
                    "('12345678', 'P001')," +
                    "('98765432', 'P002')," +
                    "('45678912', 'P003')," +
                    "('78912345', 'P004')," +
                    "('32165498', 'P005')," +
                    "('65498732', 'P006')," +
                    "('14725836', 'P007')," +
                    "('25836914', 'P008')," +
                    "('36914725', 'P009')," +
                    "('74185296', 'P010')");
            System.out.println("Datos insertados en la tabla asignado_a");

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la base de datos.");
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
