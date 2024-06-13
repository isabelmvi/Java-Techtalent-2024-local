package ModeloMVC;

import java.util.Date;

public class ClienteUD22 {
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private int dni;
    private Date fecha;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    @Override
    public String toString() {
        return "Cliente" + "\n" +
                "Id: " + id + "\n" +
                "Nombre: " + nombre + '\'' + "\n" +
                "Apellido: " + apellido + '\'' + "\n" +
                "Direccion: " + direccion + '\'' + "\n" +
                "DNI: " + dni + "\n" +
                "Fecha de nacimiento: " + fecha + "\n";
                }
    }