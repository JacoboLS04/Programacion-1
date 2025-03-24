package Punto2;

class Cliente {
    private String nombres;
    private String apellidos;
    private String identificacion;
    private String telefono;
    private String email;

    public Cliente(String nombres, String apellidos, String identificacion, String telefono, String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters y setters
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getIdentificacion() { return identificacion; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Cliente{" + "nombres='" + nombres + "', apellidos='" + apellidos +
                "', identificacion='" + identificacion + "'}";
    }
}
