package ControladorMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import ModeloMVC.ClienteUD22;
import ModeloMVC.ClienteAdminUD22;
import ModeloMVC.ClienteAdminUD22;
import VistaMVC.VistaUD22;
import VistaMVC.VistaUD22;

public class ControladorUD22 {
    private VistaUD22 vista;
    private ClienteAdminUD22 admin;

    public ControladorUD22(VistaUD22 vista, ClienteAdminUD22 admin) {
        this.vista = vista;
        this.admin = admin;

        this.vista.addInsertListener(new InsertarListener());
        this.vista.addListListener(new ListarListener());
        this.vista.addUpdateListener(new ActualizarListener());
        this.vista.addDeleteListener(new BorrarListener());
    }

    class InsertarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = vista.getNombre();
            String apellido = vista.getApellido();
            String direccion = vista.getDireccion();
            int dni = vista.getDni();
            Date fecha = vista.getFecha();

            ClienteUD22 cliente = new ClienteUD22();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDireccion(direccion);
            cliente.setDni(dni);
            cliente.setFecha(fecha);

            admin.InsertarCliente(cliente);
            vista.showMessage("Cliente aÃ±adido correctamente!");
        }
    }

    class ListarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                vista.displayClientes(admin.ListarClientes());
            } catch (SQLException ex) {
                vista.showError("Error al listar clientes: " + ex.getMessage());
            }
        }
    }

    class ActualizarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = vista.getId();
            String nombre = vista.getNombre();
            String apellido = vista.getApellido();
            String direccion = vista.getDireccion();
            int dni = vista.getDni();
            Date fecha = vista.getFecha();

            ClienteUD22 cliente = new ClienteUD22();
            cliente.setId(id);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDireccion(direccion);
            cliente.setDni(dni);
            cliente.setFecha(fecha);

            try {
                admin.ActualizarCliente(cliente);
                vista.showMessage("Cliente actualizado correctamente!");
            } catch (SQLException ex) {
                vista.showError("Error al actualizar cliente: " + ex.getMessage());
            }
        }
    }

    class BorrarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = vista.getId();

            admin.BorrarCliente(id);
			vista.showMessage("Cliente eliminado correctamente!");
        }
    }
}