/**
 * Representa un vino disponible en la tienda.
 * <p>
 * Contiene información sobre el nombre, tipo, precio y stock disponible del vino.
 * Permite modificar estos datos y gestionar la cantidad disponible.
 * </p>
 *
 * @author Fran Rebollo
 * @version 1.0
 */
public class Vino {

    private String nombre;

    /**
     * Tipo de vino (por ejemplo: Tinto, Blanco, Rosado, Espumoso).
     */
    private String tipo;
    private double precio;
    private int stock;

    /**
     * Constructor que inicializa un vino con sus datos básicos.
     *
     * @param nombre Nombre del vino.
     * @param tipo   Tipo de vino (Tinto, Blanco, Rosado, Espumoso).
     * @param precio Precio unitario del vino.
     * @param stock  Cantidad disponible en stock.
     */
    public Vino(String nombre, String tipo, double precio, int stock) {
        this.precio = precio;
        this.tipo = tipo;
        this.nombre = nombre;
        this.stock = stock;
    }

    /**
     * Obtiene el nombre del vino.
     *
     * @return Nombre del vino.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio del vino.
     *
     * @return Precio unitario del vino.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Obtiene el tipo de vino.
     *
     * @return Tipo de vino (Tinto, Blanco, Rosado, Espumoso).
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene la cantidad disponible en stock.
     *
     * @return Stock disponible.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece un nuevo precio para el vino.
     *
     * @param precio Nuevo precio unitario.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Establece un nuevo tipo para el vino.
     *
     * @param tipo Nuevo tipo (Tinto, Blanco, Rosado, Espumoso).
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Establece un nuevo nombre para el vino.
     *
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece una nueva cantidad de stock disponible.
     *
     * @param stock Nueva cantidad en stock.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Decrementa el stock del vino en una cantidad determinada.
     * <p>
     * Si la cantidad a decrementar es mayor que el stock disponible,
     * muestra un mensaje indicando que no hay suficiente stock.
     *
     * @param cantidad Cantidad a decrementar del stock.
     */
    public void decrementarStock(int cantidad) {
        if (this.stock >= cantidad) {
            this.stock -= cantidad;
        } else {
            System.out.println("No hay suficiente stock de: " + this.nombre + ".");
        }
    }

    /**
     * Devuelve una representación en formato texto del vino,
     * mostrando sus atributos principales.
     *
     * @return Cadena con los datos del vino.
     */
    @Override
    public String toString() {
        return "Vino{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio + "€" +
                ", stock=" + stock +
                '}';
    }
}
