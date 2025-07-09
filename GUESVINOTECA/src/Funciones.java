import java.util.InputMismatchException;
import java.util.Scanner;

public class Funciones {
    static Scanner sc = new Scanner(System.in);

    //PRECARGAR DATOS DE PRUEBA
    public static void precargarDatos (){
        GestorTiendaVinos.clientes.add(new Cliente("Fran Rebollo","fran@email.com","654987321","76751415s"));
        GestorTiendaVinos.clientes.add(new Cliente("Adrian Lopez","adrian@email.com","636456987","76645623F"));
        GestorTiendaVinos.clientes.add(new Cliente("Laura Granados","Laura@email.com","656896321","76645623R"));
        GestorTiendaVinos.vinos.add (new Vino("castillo Miraflores","Blanco",19.50,5));
        GestorTiendaVinos.vinos.add (new Vino("Protos","Rioja",11.50,3));
        GestorTiendaVinos.vinos.add (new Vino("Cune","Ribera",9.50,7));
        System.out.println("Datos de prueba cargados correctamente. ");

        System.out.println("---Lista de Clientes ---");
        for (Cliente cliente: GestorTiendaVinos.clientes){
            System.out.println(cliente);
        }
        System.out.println("--- Lista de vinos ___");
        for (Vino vino: GestorTiendaVinos.vinos){
            System.out.println(vino);
        }
    }
    // MENU PRINCIPAL
    public static void menuPrincipal (){
        System.out.println("--- MENU PRINCIPAL DE LA APP ---");
        System.out.println("1.Gestión de clientes");
        System.out.println("2.Gestión de vinos");
        System.out.println("3.Gestión de pedidos");
        System.out.println("4.Salir");
        System.out.println("Tienes que elegir una opción");
    }

    //METO-DO CON MANEJO DE EXCEPCIONES PARA OBTENER ENTRADA USUARIO DEL MENU
    public static int obtenerOpcionMenu (){
        int opcion = -1;
        try {
            opcion=sc.nextInt();
        }catch (InputMismatchException error){
            System.out.println("⚠️ Error de entrada, por favor ingrese un numero para seleccionar una opción");
            sc.nextLine();
        }return opcion;
    }

    //GESTIÓN DE CLIENTES
    public static void gestionClientes (){
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE CLIENTES ---");
            System.out.println("1. Alta Cliente");
            System.out.println("2. Baja Cliente");
            System.out.println("3. Modificación Cliente");
            System.out.println("4. Busqueda por Dni");
            System.out.println("5. Generar un listado Clientes");
            System.out.println("6. Volver al menu principal");
            System.out.println("-- Elige una opción --");
            opcion=obtenerOpcionMenu();

            switch (opcion){
                case 1: altaCliente ();break;
                case 2: bajaCliente ();break;
                case 3: modificarCliente ();break;
                case 4: buscarClientePorDni ();break;
                case 5: listarClientes ();break;
                case 6:break;
            }
        }while (opcion!=6);

    }

    public static void altaCliente (){
        System.out.println("\n --ALTA DE CLIENTE--");
        System.out.println("Ingrese el nombre: ");
        String nombre =sc.nextLine();
        System.out.println("Ingrese el DNI: ");
        String dni =sc.nextLine();
        System.out.println("Ingrese el telefono: ");
        String telefono =sc.nextLine();
        System.out.println("Ingrese el email: ");
        String email =sc.nextLine();

        GestorTiendaVinos.clientes.add(new Cliente(nombre,telefono,email,dni));
        System.out.println("¡ Cliente añadido con exito !");
    }

    public static Cliente buscarCliente (String dni){
        for (Cliente c : GestorTiendaVinos.clientes){
            if (c.getDni().equalsIgnoreCase(dni)){
                return c;
            }
        }return null;
    }

    public static void bajaCliente (){
        System.out.println("\n --BAJA DE CLIENTE--");
        if (GestorTiendaVinos.clientes.isEmpty()){
            System.out.println("No hay clientes para dar de baja");
            return;
        }
        System.out.println("Ingrese el DNI del cliente a dar de baja");
        String dni = sc.nextLine();
        Cliente clienteABorrar = buscarCliente(dni);
        if (clienteABorrar != null){
            GestorTiendaVinos.clientes.remove(clienteABorrar);
            System.out.println("Cliente borrado de forma exitosa");
        }else {
            System.out.println("Error: Cliente no encontrado con DNI: " + dni);
        }
    }
    public static void modificarCliente (){
        if (GestorTiendaVinos.clientes.isEmpty()){
            System.out.println("No hay clientes para modificar");
            return;
        }
        System.out.println("ingrese el dni del cliente a modificar.");
        String dni =sc.nextLine();
        Cliente clienteAModificar = buscarCliente(dni);
        if (clienteAModificar != null){

            System.out.println("Deja en blanco si no quiere cambiar el valor");

            System.out.println("ingrese el nuevo nombre");
            String nuevoNombre= sc.nextLine();
            clienteAModificar.setNombre(nuevoNombre);

            System.out.println("Introduce el nuevo telefono");
            String nuevoTelefono =sc.nextLine();
            clienteAModificar.setTelefono(nuevoTelefono);

            System.out.println("Introduce el nuevo email: ");
            String nuevoEmail=sc.nextLine();
            clienteAModificar.setEmail(nuevoEmail);
            System.out.println("Cliente modificado exitosamente.");
        }else {
            System.out.println("Error: cliente no encontrado con DNI: "+ dni);
        }

    }

    public static void buscarClientePorDni (){
        System.out.println("\n --BUSQUEDA DE CLIENTE POR DNI--");
        if (GestorTiendaVinos.clientes.isEmpty()){
            System.out.println("No hay clientes para buscar");
            return;
        }
        System.out.println("Ingrese el Dni del cliente a buscar: ");
        String dni = sc.nextLine();
        Cliente clienteEncontrado = buscarCliente(dni);
        if (clienteEncontrado !=null){
            System.out.println("Cliente encontrado" + clienteEncontrado);
        }else {
            System.out.println("Cliente no encontrado con DNI " + dni);
        }
    }

    public static void listarClientes (){
        System.out.println("\n --LISTADO DE CLIENTES--");
        if (GestorTiendaVinos.clientes.isEmpty()){
            System.out.println("No hay clientes para buscar");
            return;
        }
        for (Cliente c : GestorTiendaVinos.clientes){
            System.out.println(c);
        }
    }


    //GESTION PRODUCTO VINO

    public static void gestionVinos (){
        int opcion;
        do {
            System.out.println("\n ---GESTION VINOS---");
            System.out.println("1. Alta Producto");
            System.out.println("2. Baja Producto");
            System.out.println("3. Busqueda por tipo");
            System.out.println("4. Modificación de precio");
            System.out.println("5. Listado de productos");
            System.out.println("-- Elige una opción valida");
            opcion=obtenerOpcionMenu();

            switch (opcion){
                case 1: altaProducto ();break;
                case 2: bajaProducto ();break;
                case 3: busquedaProducto ();break;
                case 4: modificarPrecioProducto ();break;
                case 5: listadoProducto ();break;
                case 6: break;
            }
        }while (opcion !=5);
    }

    public static void altaProducto (){
        System.out.println("\n-- ALTA DE VINO--");
        System.out.println("ingrese el nombre del vino");
        String nombre = sc.nextLine();
        System.out.println("Ingresa el tipo de vino (blanco,tinto,rosado,espumoso");
        String tipo = sc.nextLine();
        System.out.println("Ingresa el precio");
        double precio = sc.nextDouble();
        System.out.println("Ingresa la cantidad");
        int cantidad = sc.nextInt();

        GestorTiendaVinos.vinos.add(new Vino(nombre,tipo,precio,cantidad));
        System.out.println("¡Producto añadido con éxito");
    }

    public static void bajaProducto (){
        System.out.println("\n ---BAJA DE VINO---");
        if (GestorTiendaVinos.vinos.isEmpty()){
            System.out.println("No hay vino para eliminar");
            return;
        }
        System.out.println("Ingresa el nombre exacto del vino a dar de baja");


    }

    public static Vino buscarVinoPorNombreExacto (String nombre){
        for (Vino vino : GestorTiendaVinos.vinos) {
            if (vino.getNombre().equalsIgnoreCase(nombre)){
                return vino;
            };
        }return null;
    }

}
