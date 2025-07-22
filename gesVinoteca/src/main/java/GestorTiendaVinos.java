import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase principal del programa de gestión de una tienda de vinos.
 * <p>
 * Permite gestionar clientes, vinos y pedidos mediante un menú interactivo
 * en consola. Dispone de opciones para navegar entre distintas gestiones
 * y salir de la aplicación.
 *
 * @author Fran Rebollo
 * @version 1.0
 */
public class GestorTiendaVinos {

    /**
     * Lista que almacena los clientes registrados en la tienda de vinos.
     */
    static ArrayList<Cliente> clientes = new ArrayList<>();

    /**
     * Lista que almacena los vinos disponibles en la tienda.
     */
    static ArrayList<Vino> vinos = new ArrayList<>();

    /**
     * Lista que almacena los pedidos realizados por los clientes.
     */
    static ArrayList<Pedido> pedidos = new ArrayList<>();

    /**
     * Método principal que inicia la ejecución de la aplicación.
     * <p>
     * Muestra un menú principal que permite al usuario gestionar clientes,
     * vinos y pedidos, o salir de la aplicación.
     * <p>
     * También permite la precarga opcional de datos de ejemplo.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Precarga de datos opcional
        Funciones.precargarDatos(); // Descomentar para realizar la precarga de datos

        Scanner sc = new Scanner(System.in);
        int opcion;

        // Bucle principal de la aplicación
        do {
            Funciones.menuPrincipal();

            // Gestión de posibles errores al introducir una opción
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException error) {
                System.out.println("⚠️ Introduce un índice válido, por favor.");
                sc.nextLine(); // Limpia el buffer
                opcion = -1;
            }

            // Menú de opciones según la elección del usuario
            switch (opcion) {
                case 1:
                    Funciones.gestionClientes();
                    break;
                case 2:
                    Funciones.gestionVinos();
                    break;
                case 3:
                    Funciones.gestionPedidos();
                    break;
                case 4:
                    System.out.println("Saliendo de la aplicación. ¡Hasta pronto!");
                    break;
                default:
                    // No se hace nada para opciones inválidas
                    break;
            }
        } while (opcion != 4);

        sc.close();
    }
}
