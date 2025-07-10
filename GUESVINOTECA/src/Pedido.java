import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    //Atributos
    private Cliente cliente;
    private ArrayList<Vino> lineasDeVenta;
    private ArrayList<Integer> cantidades;
    private LocalDate fecha;
    private double totalVenta;

    //Constructor
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.lineasDeVenta = new ArrayList<>();
        this.fecha=LocalDate.now();
        this.totalVenta = 0.0;
    }



    //Metodo para añadir vino
    public void añadirProducto(Vino vino, int cantidad){
        this.lineasDeVenta.add(vino);
        this.totalVenta += vino.getPrecio() * cantidad;
    }

    //Getters

    public Cliente getCliente() {
        return cliente;
    }
    public ArrayList<Vino> getLineasDeVenta() {
        return lineasDeVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

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


