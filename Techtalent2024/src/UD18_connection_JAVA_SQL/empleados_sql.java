package UD18_connection_JAVA_SQL;

import java.sql.*;

public class empleados_sql {

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            // Establecer la conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda_informatica?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Conectado bien");
            Statement statement = conexion.createStatement();
            System.out.println("Statement ok");

            // Eliminar las tablas si ya existen
            statement.executeUpdate("DROP TABLE IF EXISTS empleados");
            statement.executeUpdate("DROP TABLE IF EXISTS departamentos");

            // Crear tabla departamentos
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS departamentos (" +
                    "Codigo VARCHAR(10) NOT NULL PRIMARY KEY," +
                    "Nombre VARCHAR(100)," +
                    "Presupuesto INT" +
                    ")");
            System.out.println("Tabla departamentos creada ok");

            // Crear tabla empleados
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS empleados (" +
                    "DNI VARCHAR(9) NOT NULL PRIMARY KEY," +
                    "Codigo VARCHAR(10)," +
                    "Nombre VARCHAR(100)," +
                    "Apellidos VARCHAR(255)," +
                    "Departamento VARCHAR(10) NOT NULL," +
                    "FOREIGN KEY (Departamento) REFERENCES departamentos(Codigo)" +
                    ")");
            System.out.println("Tabla empleados creada ok");

            // Insertar datos en la tabla departamentos
            statement.executeUpdate("INSERT INTO departamentos (Codigo, Nombre, Presupuesto) VALUES ('DEP001', 'Ventas', 10000)");
            statement.executeUpdate("INSERT INTO departamentos (Codigo, Nombre, Presupuesto) VALUES ('DEP002', 'Recursos Humanos', 15000)");
            statement.executeUpdate("INSERT INTO departamentos (Codigo, Nombre, Presupuesto) VALUES ('DEP003', 'Marketing', 20000)");
            statement.executeUpdate("INSERT INTO departamentos (Codigo, Nombre, Presupuesto) VALUES ('DEP004', 'Desarrollo', 12000)");
            statement.executeUpdate("INSERT INTO departamentos (Codigo, Nombre, Presupuesto) VALUES ('DEP005', 'Finanzas', 18000)");
            statement.executeUpdate("INSERT INTO departamentos (Codigo, Nombre, Presupuesto) VALUES ('DEP006', 'Producción', 22000)");
            statement.executeUpdate("INSERT INTO departamentos (Codigo, Nombre, Presupuesto) VALUES ('DEP007', 'Logística', 13000)");
            statement.executeUpdate("INSERT INTO departamentos (Codigo, Nombre, Presupuesto) VALUES ('DEP008', 'Calidad', 19000)");
            statement.executeUpdate("INSERT INTO departamentos (Codigo, Nombre, Presupuesto) VALUES ('DEP009', 'Tecnología', 17000)");
            statement.executeUpdate("INSERT INTO departamentos (Codigo, Nombre, Presupuesto) VALUES ('DEP010', 'Administración', 21000)");
            System.out.println("Datos insertados en la tabla departamentos ok");
            
            // Insertar datos en la tabla empleados
            statement.executeUpdate("INSERT INTO empleados (DNI, Codigo, Nombre, Apellidos, Departamento) VALUES " +
                    "('11111111A', 'Emp001', 'Juan', 'González', 'DEP001'), " +
                    "('22222222B', 'Emp002', 'María', 'Martínez', 'DEP002'), " +
                    "('33333333C', 'Emp003', 'Antonio', 'Rodríguez', 'DEP003'), " +
                    "('44444444D', 'Emp004', 'Carmen', 'Pérez', 'DEP004'), " +
                    "('55555555E', 'Emp005', 'José', 'López', 'DEP005'), " +
                    "('66666666F', 'Emp006', 'Ana', 'Sánchez', 'DEP006'), " +
                    "('77777777G', 'Emp007', 'Manuel', 'Gómez', 'DEP007'), " +
                    "('88888888H', 'Emp008', 'Laura', 'Díaz', 'DEP008'), " +
                    "('99999999I', 'Emp009', 'Miguel', 'Fernández', 'DEP009'), " +
                    "('10101010J', 'Emp010', 'Elena', 'Ruiz', 'DEP010')");
            System.out.println("Datos insertados en la tabla empleados ok");

            // Consultas
            ResultSet resultSet = statement.executeQuery("SELECT Apellidos FROM empleados");
            while (resultSet.next()) {
                System.out.println("Apellidos: " + resultSet.getString("Apellidos"));
            }
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
