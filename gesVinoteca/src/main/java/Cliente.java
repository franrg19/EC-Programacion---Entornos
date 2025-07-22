/**
 * Representa un cliente de la tienda de vinos.
 * <p>
 * Contiene información básica del cliente como nombre, DNI, teléfono y email.
 * Permite acceder y modificar estos datos mediante getters y setters.
 *
 * @author Fran Rebollo
 * @version 1.0
 */
public class Cliente {

    private String nombre;
    private String dni;
    private String telefono;
    private String email;

    /**
     * Constructor que inicializa un nuevo cliente con los datos proporcionados.
     *
     * @param nombre   Nombre completo del cliente.
     * @param email    Dirección de correo electrónico del cliente.
     * @param telefono Número de teléfono del cliente.
     * @param dni      Documento Nacional de Identidad del cliente.
     */
    public Cliente(String nombre, String email, String telefono, String dni) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.dni = dni;
    }

    /**
     * Obtiene la dirección de correo electrónico del cliente.
     *
     * @return Email del cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtiene el DNI del cliente.
     *
     * @return DNI del cliente.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     *
     * @return Teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Obtiene el nombre completo del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre completo del cliente.
     *
     * @param nombre Nuevo nombre para el cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Modifica el número de teléfono del cliente.
     *
     * @param telefono Nuevo teléfono para el cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Modifica la dirección de correo electrónico del cliente.
     *
     * @param email Nuevo email para el cliente.
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Devuelve una representación en formato texto del cliente,
     * mostrando todos sus atributos.
     *
     * @return Cadena con los datos del cliente.
     */
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
