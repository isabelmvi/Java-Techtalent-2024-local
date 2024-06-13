
package ModeloMVC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ClienteAdminUD22 {
    private Connection dbcConnection;

    public ClienteAdminUD22(Connection connection) {
        this.dbcConnection = connection;
    }

    public boolean InsertarCliente(ClienteUD22 cliente) {
        String sql = "INSERT INTO clientes (nombre, apellido, direccion, dni, fecha) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = dbcConnection.prepareStatement(sql);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getDireccion());
            statement.setInt(4, cliente.getDni());
            statement.setDate(5, new java.sql.Date(cliente.getFecha().getTime()));
            boolean rowInserted = statement.executeUpdate() > 0;
            statement.close();
            return rowInserted;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ClienteUD22> ListarClientes() throws SQLException {
        List<ClienteUD22> listCliente = new ArrayList<>();

        String sql = "SELECT * FROM clientes";

        Statement statement = dbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String direccion = resultSet.getString("direccion");
            int dni = resultSet.getInt("dni");
            Date fecha = resultSet.getDate("fecha");

            ClienteUD22 cliente = new ClienteUD22();
            cliente.setId(id);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDireccion(direccion);
            cliente.setDni(dni);
            cliente.setFecha(fecha);

            listCliente.add(cliente);
        }

        resultSet.close();
        statement.close();

        return listCliente;
    }

    public boolean ActualizarCliente(ClienteUD22 cliente) throws SQLException {
        String sql = "UPDATE clientes SET nombre = ?, apellido = ?, direccion = ?, dni = ?, fecha = ? WHERE id = ?";

        PreparedStatement statement = dbcConnection.prepareStatement(sql);
        statement.setString(1, cliente.getNombre());
        statement.setString(2, cliente.getApellido());
        statement.setString(3, cliente.getDireccion());
        statement.setInt(4, cliente.getDni());
        statement.setDate(5, new java.sql.Date(cliente.getFecha().getTime()));
        statement.setInt(6, cliente.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        return rowUpdated;
    }

    public void BorrarCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try {
            PreparedStatement statement = dbcConnection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
