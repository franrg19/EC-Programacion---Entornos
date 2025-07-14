public class Vino {
    //Atributos
    private String nombre;
    private String tipo;  // Tinto,Blanco,Rosado,Espumoso
    private double precio;
    private int stock;

    //Constructor
    public Vino(String nombre,String tipo,double precio,int stock) {
        this.precio = precio;
        this.tipo = tipo;
        this.nombre = nombre;
        this.stock = stock;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    public int getStock (){
        return stock;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStock(int stock){
        this.stock=stock;
    }


    //Metodo para decrementar el stock
    public void decrementarStock(int cantidad){
        if (this.stock >= cantidad){
            this.stock -= cantidad;
        }else {
            System.out.println("No hay suficiente stock de: " + this.nombre + ".");
        }
    }

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
