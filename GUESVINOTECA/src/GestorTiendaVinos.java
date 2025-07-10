import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorTiendaVinos {
    static ArrayList <Cliente> clientes = new ArrayList<>();
    static ArrayList <Vino> vinos = new ArrayList<>();
    static ArrayList <Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        Funciones.precargarDatos(); // Descomentar para realizar la precarga de datos

        Scanner sc =new Scanner(System.in);
        int opcion;
        do {
            Funciones.menuPrincipal();
            try {
                opcion=sc.nextInt();
            }catch (InputMismatchException error){
                System.out.println("⚠️ Introduce un indice válido, por favor. ");
                sc.nextLine();
                opcion=-1;
            }
            switch (opcion){
                case 1: Funciones.gestionClientes();
                break;
                case 2: Funciones.gestionVinos ();
                break;
               case 3: Funciones.gestionPedidos ();
                break;
                case 4:
                    System.out.println("Saliendo de la aplicación. ¡ Hasta pronto ! ");

            }
        }while(opcion!=4);
        sc.close();

        }
    }

