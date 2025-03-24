package Punto23D;

// Clase Miembro
class Miembro {
    private String nombre;
    private int edad;
    private String genero;
    private String cedula;
    private String telefono;
    private TipoMembresia tipoMembresia;

    public Miembro(String nombre, int edad, String genero, String cedula, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.cedula = cedula;
        this.telefono = telefono;
        this.tipoMembresia = TipoMembresia.MENSUAL; // Por defecto
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoMembresia getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(TipoMembresia tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    @Override
    public String toString() {
        return "Miembro: " + nombre + " (Edad: " + edad + ", Teléfono: " + telefono + ")";
    }
}
