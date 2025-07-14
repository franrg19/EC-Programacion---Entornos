public class Cliente {
    //Atributos
    private String nombre;
    private String dni;
    private String telefono;
    private String email;

    //Constructor
    public Cliente(String nombre, String email, String telefono, String dni) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.dni = dni;
    }

    //Getter y Setter

    public String getEmail() {
        return email;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email){
        this.email=email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Nombre='" + nombre + '\'' +
                ", Dni='" + dni + '\'' +
                ", Telefono='" + telefono + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }
}
