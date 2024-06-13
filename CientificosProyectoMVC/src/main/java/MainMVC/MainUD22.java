package MainMVC;

import ControladorMVC.ControladorUD22;
import ModeloMVC.ClienteAdminUD22;
import VistaMVC.VistaUD22;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainUD22 {

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            // Asegúrate de tener el MySQL Connector/J en el classpath
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/videos_cliente?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Conexión establecida");

            // Crear la tabla Clientes si no existe
            createTable(conexion);

            // Inicializar el administrador, la vista y el controlador
            ClienteAdminUD22 admin = new ClienteAdminUD22(conexion);
            VistaUD22 vista = new VistaUD22();
            new ControladorUD22(vista, admin);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    private static void createTable(Connection conexion) {
        Statement statement = null;
        try {
            // Crear un objeto Statement para ejecutar consultas SQL
            statement = conexion.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS Clientes (" +
                                    "id INT(11) NOT NULL AUTO_INCREMENT, " +
                                    "nombre VARCHAR(250) DEFAULT NULL, " +
                                    "apellido VARCHAR(250) DEFAULT NULL, " +
                                    "direccion VARCHAR(250) DEFAULT NULL, " +
                                    "dni INT(11) DEFAULT NULL, " +
                                    "fecha DATE DEFAULT NULL, " +
                                    "PRIMARY KEY (id))";
            statement.executeUpdate(createTableSQL);
            System.out.println("Tabla 'Clientes' creada o ya existe");

        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar el Statement: " + e.getMessage());
            }
        }
    }
}
