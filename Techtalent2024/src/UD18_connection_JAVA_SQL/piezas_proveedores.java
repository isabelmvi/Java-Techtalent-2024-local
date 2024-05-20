package UD18_connection_JAVA_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class piezas_proveedores {
    public static void main(String[] args) {
        Connection conexion = null;
        Statement statement = null;

        try {
            // Establecer la conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useTimezone=true&serverTimezone=UTC", "root", "");

            // Crear base de datos y seleccionarla
            statement = conexion.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS piezas_proveedores");
            statement.executeUpdate("USE piezas_proveedores");

            // Crear tabla piezas
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS piezas(" +
                    "Codigo INT NOT NULL," +
                    "Nombre VARCHAR(100)," +
                    "PRIMARY KEY(Codigo)" +
                    ")");
            System.out.println("Tabla piezas creada OK");

            // Insertar datos en la tabla piezas
            statement.executeUpdate("INSERT IGNORE INTO piezas (Codigo, Nombre) VALUES " +
                    "(1, 'Tornillo')," +
                    "(2, 'Tuerca')," +
                    "(3, 'Arandela')," +
                    "(4, 'Perno')," +
                    "(5, 'Abrazadera')," +
                    "(6, 'Remache')," +
                    "(7, 'Varilla')," +
                    "(8, 'Espárrago')," +
                    "(9, 'Pasador')," +
                    "(10, 'Clip')");
            System.out.println("Datos en tabla piezas insertados OK");

            // Crear tabla proveedores
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS proveedores(" +
                    "id CHAR(4)," +
                    "Nombre VARCHAR(100)," +
                    "PRIMARY KEY(id)" +
                    ")");
            System.out.println("Tabla proveedores creada OK");

            // Insertar datos en la tabla proveedores
            statement.executeUpdate("INSERT IGNORE INTO proveedores (id, Nombre) VALUES " +
                    "('001', 'Proveedor A')," +
                    "('002', 'Proveedor B')," +
                    "('003', 'Proveedor C')," +
                    "('004', 'Proveedor D')," +
                    "('005', 'Proveedor E')," +
                    "('006', 'Proveedor F')," +
                    "('007', 'Proveedor G')," +
                    "('008', 'Proveedor H')," +
                    "('009', 'Proveedor I')," +
                    "('010', 'Proveedor J')");

            // Crear tabla suministra
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS suministra(" +
                    "CodigoPieza INT," +
                    "idProveedor CHAR(4)," +
                    "Precio INT NOT NULL," +
                    "FOREIGN KEY (CodigoPieza) REFERENCES piezas(Codigo)," +
                    "FOREIGN KEY (idProveedor) REFERENCES proveedores(id)" +
                    ")");

            // Insertar datos en la tabla suministra
            statement.executeUpdate("INSERT INTO suministra (CodigoPieza, idProveedor, Precio) VALUES " +
                    "(1, '001', 10)," +
                    "(2, '002', 15)," +
                    "(3, '003', 8)," +
                    "(4, '004', 12)," +
                    "(5, '005', 20)," +
                    "(6, '006', 7)," +
                    "(7, '007', 9)," +
                    "(8, '008', 14)," +
                    "(9, '009', 11)," +
                    "(10, '010', 18)");

            System.out.println("Operaciones realizadas correctamente.");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error al realizar las operaciones.");
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
