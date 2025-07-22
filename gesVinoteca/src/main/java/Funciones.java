import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Funciones que contiene todos los métodos estáticos relacionados con
 * la gestión de clientes, vinos y pedidos para una tienda de vinos.
 * Utiliza la clase GestorTiendaVinos como fuente de datos central.
 *
 * Esta clase incluye lógica para:
 * - Cargar datos de prueba.
 * - Mostrar menús.
 * - Manejar clientes (alta, baja, modificación, búsqueda, listado).
 * - Manejar vinos (alta, baja, modificación, búsqueda, listado).
 * - Gestionar ventas (realizar, mostrar por cliente, mostrar importes).
 *
 * Autor: Fran Rebollo
 */


public class Funciones {
    static Scanner sc = new Scanner(System.in);

    /**
     * Precarga algunos clientes y vinos en el sistema para realizar pruebas.
     * También muestra por consola los clientes y vinos cargados.
     */

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
        System.out.println("--- Lista de vinos ---");
        for (Vino vino: GestorTiendaVinos.vinos){
            System.out.println(vino);
        }
    }

    /**
     * Muestra el menú principal de la aplicación por consola.
     */
    public static void menuPrincipal (){
        System.out.println("--- MENU PRINCIPAL DE LA APP ---");
        System.out.println("1.Gestión de clientes");
        System.out.println("2.Gestión de vinos");
        System.out.println("3.Gestión de pedidos");
        System.out.println("4.Salir");
        System.out.println("Tienes que elegir una opción");
    }

    /**
     * Solicita al usuario una opción del menú y maneja posibles errores de entrada.
     *
     * @return La opción seleccionada como entero, o -1 si hubo error.
     */


    public static int obtenerOpcionMenu (){
        int opcion = -1;
        try {
            opcion=sc.nextInt();
        }catch (InputMismatchException error){
            System.out.println("⚠️ Error de entrada, por favor ingrese un numero para seleccionar una opción");
        }finally {
            sc.nextLine();
        }return opcion;
    }


    /**
     * Muestra el menú de gestión de clientes y ejecuta la acción correspondiente
     * según la opción seleccionada.
     */


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

    /**
     * Solicita datos al usuario y da de alta un nuevo cliente en la lista.
     */

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

        GestorTiendaVinos.clientes.add(new Cliente(nombre,email,telefono,dni));
        System.out.println("¡ Cliente añadido con exito !");
    }

    /**
     * Busca un cliente por su DNI en la lista de clientes.
     *
     * @param dni DNI del cliente a buscar.
     * @return Objeto Cliente si lo encuentra, o null si no.
     */

    public static Cliente buscarCliente (String dni){
        for (Cliente c : GestorTiendaVinos.clientes){
            if (c.getDni().equalsIgnoreCase(dni)){
                return c;
            }
        }return null;
    }

    /**
     * Elimina un cliente de la lista según su DNI.
     */

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

    /**
     * Permite modificar los datos de un cliente existente, dejando sin cambios los campos vacíos.
     */

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

            System.out.println("ingrese el nuevo nombre (actual: " + clienteAModificar.getNombre() + "):");
            String nuevoNombre= sc.nextLine();
            if (!nuevoNombre.trim().isEmpty()){
                clienteAModificar.setNombre(nuevoNombre);
            }

            System.out.println("Introduce el nuevo telefono (actual: " + clienteAModificar.getTelefono() + ")");
            String nuevoTelefono =sc.nextLine();
            if (!nuevoTelefono.trim().isEmpty()){
                clienteAModificar.setTelefono(nuevoTelefono);
            }


            System.out.println("Introduce el nuevo email (actual: " + clienteAModificar.getEmail());
            String nuevoEmail=sc.nextLine();
            clienteAModificar.setEmail(nuevoEmail);
            System.out.println("Cliente modificado exitosamente.");
        }else {
            System.out.println("Error: cliente no encontrado con DNI: "+ dni);
        }

    }

    /**
     * Solicita un DNI al usuario y muestra los datos del cliente si existe.
     */

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
            System.out.println("Cliente encontrado " + clienteEncontrado);
        }else {
            System.out.println("Cliente no encontrado con DNI " + dni);
        }
    }

    /**
     * Muestra un listado de todos los clientes registrados.
     */

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

    /**
     * Muestra el menú de gestión de vinos y ejecuta acciones como alta, baja, modificación o listado.
     */
    public static void gestionVinos (){
        int opcion;
        do {
            System.out.println("\n ---GESTION VINOS---");
            System.out.println("1. Alta Producto");
            System.out.println("2. Baja Producto");
            System.out.println("3. Busqueda por tipo");
            System.out.println("4. Modificación de precio");
            System.out.println("5. Modificación de Stock");
            System.out.println("6. Listado de productos");
            System.out.println("7. Volver al menu principal");
            System.out.println("-- Elige una opción valida");
            opcion=obtenerOpcionMenu();

            switch (opcion){
                case 1: altaProducto ();break;
                case 2: bajaProducto ();break;
                case 3: busquedaProducto ();break;
                case 4: modificarPrecioProducto ();break;
                case 5: modificarStockProducto ();break;
                case 6: listadoProducto ();break;
                case 7: ;break;
            }
        }while (opcion !=7);
    }

    /**
     * Da de alta un nuevo vino solicitando los datos al usuario.
     */

    public static void altaProducto () {
        System.out.println("\n-- ALTA DE VINO--");

        System.out.println("ingrese el nombre del vino");
        String nombre = sc.nextLine();
        System.out.println("Ingresa el tipo de vino (blanco,tinto,rosado,espumoso");
        String tipo = sc.nextLine();

        System.out.println("Ingresa el precio");
        double precio = 0;
        try {
            precio = sc.nextDouble();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Por favor introduce un numero");
        }

        System.out.println("Ingresa la cantidad");
        int cantidad = 0;
        try {
            cantidad = sc.nextInt();
            sc.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Por favor introduce un numero");
            sc.nextLine();
        }

        GestorTiendaVinos.vinos.add(new Vino(nombre, tipo, precio, cantidad));
        System.out.println("¡Producto añadido con éxito");
    }

    /**
     * Muestra el listado de todos los vinos disponibles.
     */

    public static  void listadoProducto (){
        if (GestorTiendaVinos.vinos.isEmpty()){
            System.out.println("Error, no hay ningun vino para mostrar");
            return;
        }
        System.out.println("---Listado de vinos disponibles---");
        for (int i = 0; i < GestorTiendaVinos.vinos.size(); i++) {
            System.out.println((i+1) + ". " + GestorTiendaVinos.vinos.get(i));
        }
    }

    /**
     * Elimina un vino de la lista según su nombre exacto.
     */

    public static void bajaProducto (){
        System.out.println("\n ---BAJA DE VINO---");
        if (GestorTiendaVinos.vinos.isEmpty()){
            System.out.println("No hay vino para eliminar");
            return;
        }

        listadoProducto();
        System.out.println("Ingresa el nombre exacto del vino a dar de baja");
        String nombreVino = sc.nextLine();
        Vino vinoaborrar=buscarVinoPorNombreExacto(nombreVino);
        if (vinoaborrar !=null){
            GestorTiendaVinos.vinos.remove(vinoaborrar);
            System.out.println("Vino borrado correctamente");
        }else {
            System.out.println("Error vino no encontrado con el nombre: " + nombreVino);
        }


    }
    /**
     * Busca un vino por su nombre exacto (ignorando mayúsculas).
     *
     * @param nombre Nombre del vino.
     * @return Objeto Vino si lo encuentra, o null si no.
     */

    public static Vino buscarVinoPorNombreExacto (String nombre){
        for (Vino vino : GestorTiendaVinos.vinos) {
            if (vino.getNombre().equalsIgnoreCase(nombre)){
                return vino;
            };
        }return null;
    }

    /**
     * Realiza una búsqueda de vinos por nombre o tipo.
     */

    public static void busquedaProducto (){
        if (GestorTiendaVinos.vinos.isEmpty()){
            System.out.println("No hay vinos para mostrar");
            return;
        }
        System.out.println("introduce texto de busqueda (nombre o tipo");
        String busqueda = sc.nextLine().toLowerCase();
        boolean encontrado = false;
        for (Vino vino : GestorTiendaVinos.vinos){
            if (vino.getNombre().toLowerCase().contains(busqueda) || vino.getTipo().toLowerCase().contains(busqueda)){
                System.out.println(vino);
                encontrado=true;
            }
        }
        if (!encontrado){
            System.out.println("no se encontraron vinos con el criterio de busqueda");
        }
    }

    /**
     * Permite modificar el precio de un vino existente introduciendo su nombre.
     */

    public static void modificarPrecioProducto (){
        System.out.println("\n MODIFICAR PRECIO VINO");
        if (GestorTiendaVinos.vinos.isEmpty()){
            System.out.println("La lista de vino esta vacia, añade primero un vino");
            return;
        }
        listadoProducto();

        System.out.println("Escribe el nombre del vino para cambiar el precio");
        String nombreVino = sc.nextLine();

        Vino vinoAModificar = buscarVinoPorNombreExacto(nombreVino);
        if (vinoAModificar == null){
            System.out.println("Este vino no existe");
            return;
        }
        System.out.println("Precio del vino actual: " + vinoAModificar.getPrecio() + "€");
        System.out.println("Escribe el nuevo precio o -1 para cancelar");

        try {
            String iputTeclado = sc.nextLine();
            double nuevoPrecio = Double.parseDouble(iputTeclado);


            if (nuevoPrecio == -1){
                System.out.println("Precio no modificado");
            }else if (nuevoPrecio < 0){
                System.out.println("El precio no puede ser negativo. No se ha realizado ningun cambio");
            }else{
                vinoAModificar.setPrecio(nuevoPrecio);
                System.out.println("Precio del vino " + vinoAModificar.getNombre() + " actualizado a: "  + nuevoPrecio + "€");
            }
        }catch (NumberFormatException e){
            System.out.println("Error el precio tiene que ser un valor numerico.");
        }
    }

    /**
     * Permite modificar el stock de un vino existente introduciendo su nombre.
     */

    public static void modificarStockProducto () {
        System.out.println("\n MODIFICAR STOCK PRODUCTO");
        if (GestorTiendaVinos.vinos.isEmpty()){
            System.out.println("Error, no hay producto para modificar");
            return;
        }

        listadoProducto();
        System.out.println("Escribe el nombre del vino que quieres modificar el stock");
        String nombreVino =sc.nextLine();

        Vino vinoAModificarStock = buscarVinoPorNombreExacto(nombreVino);
        if (vinoAModificarStock == null){
            System.out.println("El nombre del vino no existe, prueba otra vez.");
            return;
        }

        System.out.println("Stock del vino actual " + vinoAModificarStock.getStock() + " Unidades.");
        System.out.println("Introduce el nuevo stock  o -1 para cancelar");

        try {
            int inputNuevaCantidad = sc.nextInt();

            if (inputNuevaCantidad == -1){
                System.out.println("Stock no modificado");
            } else if (inputNuevaCantidad < 0) {
                System.out.println("La cantidad no puede ser negativa");
            }else {
                vinoAModificarStock.setStock(inputNuevaCantidad);
                System.out.println("Stock del vino " + vinoAModificarStock.getNombre() + " actualizado a: " + inputNuevaCantidad + " unidades." );
            }
        }catch (InputMismatchException e){
            System.out.println("Tienes que introducir un valor numerico.");
        }

    }

    /**
     * Muestra el menú de gestión de pedidos (ventas) y ejecuta la acción correspondiente.
     */
    public static void gestionPedidos (){
        int opcion = -1;

        do {
            System.out.println("\n ---GESTION DE LOS PEDIDOS---");
            System.out.println("1. Realizar una venta");
            System.out.println("2. Mostrar ventas realizadas");
            System.out.println("3. Mostrar ventas por cliente");
            System.out.println("4. Mostrar importe total de cada venta");
            System.out.println("5. Liquidación de todas las ventas");
            System.out.println("6. Salir");
            opcion=obtenerOpcionMenu();

            switch (opcion){
                case 1: realizarVenta ();break;
                case 2: mostrarVentas ();break;
                case 3: mostrarVentasCliente ();break;
                case 4: mostrarImporteVentas ();break;
                case 5: liquidacionVentas ();break;
                case 6: return;
                default:
                    System.out.println("Opcion no valida, intentelo de nuevo");
            }
        }while (opcion!=6);
    }

    /**
     * Permite realizar una nueva venta seleccionando un cliente y productos con cantidades.
     * Verifica el stock y actualiza la cantidad disponible.
     */

    public static void realizarVenta () {
        System.out.println("\n--REALIZAR UNA VENTA--");
        if (GestorTiendaVinos.clientes.isEmpty()){
            System.out.println("Error no hay cliente registrado");
            return;
        }
        if (GestorTiendaVinos.vinos.isEmpty()){
            System.out.println("Error, no hay vinos registrados para vender");
            return;
        }

            System.out.println("Selecciona un cliente para realizar una venta");
            listarClientes();
            System.out.println("Ingrese DNI del cliente");
            String dniCliente = sc.nextLine();
            Cliente clienteSeleccionado =buscarCliente(dniCliente);

            if (clienteSeleccionado == null){
                System.out.println("Error venta cancelada");
                return;
            }

            Pedido nuevoPedido = new Pedido(clienteSeleccionado);

            while (true){
                listadoProducto();
                System.out.println("Elige el numero de vino (0 para terminar): ");
                int opcionVino = obtenerOpcionMenu();

                if (opcionVino == 0)break;

                if (opcionVino < 1 || opcionVino > GestorTiendaVinos.vinos.size()){
                    System.out.println("Numero de vino no valido");
                    continue;
                }
                Vino vinoSeleccionado =GestorTiendaVinos.vinos.get(opcionVino-1);
                System.out.println("Cantidad (stock: " + vinoSeleccionado.getStock() + "): ");
                int cantidad = -1;

                try {
                    cantidad =sc.nextInt();
                    if (cantidad < 0){
                        System.out.println("la cantidad no puede ser negativa");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Error: Por favor ingrese un numero entero para la cantidad");
                }finally {
                    sc.nextLine();
                }
                if (cantidad > 0){
                    if (vinoSeleccionado.getStock() >= cantidad){
                        nuevoPedido.añadirProducto(vinoSeleccionado,cantidad);
                        vinoSeleccionado.decrementarStock(cantidad);
                        System.out.println(cantidad + " de " + vinoSeleccionado.getNombre() + " añadido a la venta");
                    }else {
                        System.out.println("Stock insuficiente para: " + vinoSeleccionado.getNombre() + " solo quedan " + vinoSeleccionado.getStock() + " unidades");
                    }
                }
            }if (nuevoPedido.getLineasDeVenta().isEmpty()){
            System.out.println("Venta cancelada no se añadieron vinos");
        }else {
            GestorTiendaVinos.pedidos.add(nuevoPedido);
            System.out.println("Venta realizada con exito");
        }


    }

    /**
     * Muestra todas las ventas realizadas hasta el momento.
     */
    public static void mostrarVentas (){
        System.out.println("\n --TODAS LAS VENTAS REALIZADAS--");

        if (GestorTiendaVinos.pedidos.isEmpty()){
            System.out.println("No se ha realizado ningun pedido");
            return;
        }
        for (Pedido p : GestorTiendaVinos.pedidos){
            System.out.println(p);
            System.out.println("_x_x_x_x_x_x_x");
        }
    }

    /**
     * Muestra todas las ventas realizadas por un cliente específico introduciendo su DNI.
     */
    public static void mostrarVentasCliente (){
        System.out.println("\n--VENTAS POR CLIENTE--");
        if (GestorTiendaVinos.clientes.isEmpty()){
            System.out.println("No hay clientes registrados");
            return;
        }
        if (GestorTiendaVinos.pedidos.isEmpty()){
            System.out.println("No hay pedidos registrados");
            return;
        }

        listarClientes();
        System.out.println("ingrese el Dni del cliente para buscar");
        String dni = sc.nextLine();
        Cliente clienteABuscar =buscarCliente(dni);

        if (clienteABuscar != null){
            boolean tieneVentas = false;
            System.out.println("\n Ventas de. " + clienteABuscar.getNombre());
            for (Pedido pedido : GestorTiendaVinos.pedidos){
                if (pedido.getCliente().getDni().equalsIgnoreCase(dni)){
                    System.out.println(pedido);
                    tieneVentas=true;
                }
            }if (!tieneVentas){
                System.out.println("El cliente " + clienteABuscar.getNombre() + "no tiene ventas realizadas");
            }
        }else {
            System.out.println("Error, cliente no encontrado con dni " + dni);
        }

    }

    /**
     * Muestra el importe total de cada venta registrada en el sistema.
     */

    public static void mostrarImporteVentas (){
        System.out.println("\n -- IMPORTE TOTAL DE CADA VENTA--");

        if(GestorTiendaVinos.pedidos.isEmpty()){
            System.out.println("Error no se ha realizado ninguna venta");
            return;
        }
        for (Pedido pedido : GestorTiendaVinos.pedidos){
            System.out.println("Venta de " + pedido.getCliente().getNombre() + " en "  + pedido.getFecha() + ": " + String.format("%.2f",pedido.getTotalVenta()) + "€");
        }
    }

    /**
     * Muestra la liquidación total: suma del importe de todas las ventas realizadas hasta ahora.
     */
    public static void liquidacionVentas (){
        System.out.println("---LIQUIDACION DE VENTAS TOTALES ---");

        if (GestorTiendaVinos.pedidos.isEmpty()){
            System.out.println("Error no se ha realizado ninguna venta");
            return;
        }

        double totalVentas =0;
        for (Pedido p : GestorTiendaVinos.pedidos){
            totalVentas +=p.getTotalVenta();
        }
        System.out.println("La liquidación total de las ventas es: " + String.format("%.2f",totalVentas) + "€");

    }

}
