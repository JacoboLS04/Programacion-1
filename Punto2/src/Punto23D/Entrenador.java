package Punto23D;

class Entrenador {
    private String nombre;
    private String especialidad;
    private String correo;
    private int telefono;

    public Entrenador(String nombre, String especialidad, String correo, int telefono) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Entrenador: " + nombre + " (Especialidad: " + especialidad + ")";
    }
}
