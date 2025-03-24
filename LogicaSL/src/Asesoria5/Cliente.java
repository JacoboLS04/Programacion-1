package Asesoria5;

public class Cliente {
    private String nombres;
    private String apellidos;
    private String identificacion;
    private String telefono;
    private String email;

    // Constructor
    public Cliente(String nombres, String apellidos, String identificacion, String telefono, String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters y setters
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Cliente: " + nombres + " " + apellidos + " (ID: " + identificacion + ")";
    }
}
