import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Representa un pedido realizado por un cliente en la tienda de vinos.
 * <p>
 * Contiene información sobre el cliente que realiza el pedido,
 * los vinos adquiridos con sus cantidades, la fecha del pedido y
 * el total de la venta calculado.
 * </p>
 *
 * @author Fran Rebollo
 * @version 1.0
 */
public class Pedido {

    /**
     * Cliente que realiza el pedido.
     */
    private Cliente cliente;

    /**
     * Lista de vinos incluidos en el pedido.
     */
    private ArrayList<Vino> lineasDeVenta;


    /**
     * Fecha en la que se realiza el pedido.
     */
    private LocalDate fecha;

    /**
     * Importe total acumulado del pedido.
     */
    private double totalVenta;

    /**
     * Constructor que crea un nuevo pedido para un cliente dado.
     * Inicializa la lista de vinos vacía, establece la fecha actual
     * y el total de la venta a cero.
     *
     * @param cliente Cliente que realiza el pedido.
     */
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.lineasDeVenta = new ArrayList<>();
        this.fecha = LocalDate.now();
        this.totalVenta = 0.0;
    }

    /**
     * Añade un vino y su cantidad al pedido.
     * Suma el importe correspondiente al total de la venta.
     *
     * @param vino     Vino que se añade al pedido.
     * @param cantidad Cantidad del vino a añadir.
     */
    public void añadirProducto(Vino vino, int cantidad) {
        this.lineasDeVenta.add(vino);
        this.totalVenta += vino.getPrecio() * cantidad;
        // Nota: Se debería añadir también la cantidad a la lista cantidades si se gestiona.
    }

    /**
     * Obtiene el cliente asociado al pedido.
     *
     * @return Cliente que hizo el pedido.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Obtiene la lista de vinos que forman parte del pedido.
     *
     * @return Lista de vinos.
     */
    public ArrayList<Vino> getLineasDeVenta() {
        return lineasDeVenta;
    }

    /**
     * Obtiene la fecha en que se realizó el pedido.
     *
     * @return Fecha del pedido.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Obtiene el total acumulado del pedido.
     *
     * @return Importe total de la venta.
     */
    public double getTotalVenta() {
        return totalVenta;
    }

    /**
     * Devuelve una representación en texto del pedido, mostrando
     * cliente, vinos, fecha y total.
     *
     * @return Cadena con la información del pedido.
     */
    @Override
    public String toString() {
        return "Pedido{" +
                "cliente=" + cliente +
                ", lineasDeVenta=" + lineasDeVenta +
                ", fecha=" + fecha +
                ", totalVenta=" + totalVenta +
                '}';
    }
}
