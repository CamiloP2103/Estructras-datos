
package Interfaz;
/**
 *
 * @author Juan Peña
 * @author Camilo Prieto
 * @author Rodrigo Bueno
 */
/**
 * Clase que contiene la implementaxción de la interfaz.
 */
import Estructuras.Stack;
import Estructuras.Cola;
import Estructuras.Lista;
import Estructuras.Maleta;
import Cosas.ObjetoSimple;
import java.util.Scanner;

/**
 * Clase principal que implementa la interfaz de usuario para interactuar con
 * las estructuras de datos Pila, Cola, Lista y Maleta.
 */
public class InterfazApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("SISTEMA DE ESTRUCTURAS DE DATOS");
        System.out.println("-------------------------------");

        boolean salir = false;
        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerEntero();

            switch (opcion) {
                case 1:
                    menuPila();
                    break;
                case 2:
                    menuCola();
                    break;
                case 3:
                    menuLista();
                    break;
                case 4:
                    menuMaleta();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
        }

        System.out.println("\n¡Gracias por usar el sistema!");
        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\nMENU PRINCIPAL");
        System.out.println("1. Trabajar con Pilas");
        System.out.println("2. Trabajar con Colas");
        System.out.println("3. Trabajar con Listas");
        System.out.println("4. Trabajar con Maletas");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    
    /**
     * ejecuta el menú de opciones para manipular la pila.
     * Se usa un bucle `do-while` para permitir que el usuario interactúe hasta que decida salir.
     */
    
    private static void menuPila() {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>(4); // Pila con capacidad inicial 1

        int opcion;

        do {
            System.out.println("\n--- Menu de Pila ---");
            System.out.println("1. Agregar elemento (push)");
            System.out.println("2. Eliminar elemento (pop)");
            System.out.println("3. Ver elemento superior (peek)");
            System.out.println("4. Ver tamaño de la pila");
            System.out.println("5. Verificar si está vacía");
            System.out.println("6. Mostrar todos los elementos");
            System.out.println("7. Insertar en una posición específica");
            System.out.println("8. Eliminar en una posición específica");
            System.out.println("9. Salir\n");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento: ");
                    String elemento = scanner.nextLine();
                    stack.push(elemento);
                    System.out.println("Elemento agregado.");
                    break;

                case 2:
                    String eliminado = stack.pop();
                    if (eliminado != null) {
                        System.out.println("Elemento eliminado: " + eliminado);
                    }
                    break;

                case 3:
                    String cima = stack.peek();
                    if (cima != null) {
                        System.out.println("Elemento en la cima: " + cima);
                    }
                    break;

                case 4:
                    System.out.println("Tamaño actual: " + stack.size());
                    break;

                case 5:
                    System.out.println(stack.isEmpty() ? "La pila está vacía" : "La pila tiene elementos");
                    break;

                case 6:
                    if (stack.isEmpty()) {
                        System.out.println("La pila está vacía.");
                    } else {
                        System.out.println("Elementos en la pila:");
                        int index = stack.size();
                        for (String item : stack) {
                            System.out.println(index-- + ") " + item);
                        }
                    }
                    break;

                case 7:
                    System.out.print("Ingrese la posición: ");
                    int posInsert = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el elemento: ");
                    String newItem = scanner.nextLine();
                    stack.insertAt(posInsert, newItem);
                    break;

                case 8:
                    System.out.print("Ingrese la posición a eliminar: ");
                    int posRemove = scanner.nextInt();
                    stack.removeAt(posRemove);
                    break;

                case 9:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 9);

        scanner.close();
        
    }
    
    /**
     * ejecuta el menú de opciones para manipular la cola.
     * Se usa un bucle `do-while` para permitir que el usuario interactúe hasta que decida salir.
     */
    
    private static void menuCola() {
        System.out.print("\nIngrese capacidad inicial de la cola: ");
        int capacidad = leerEntero();
        Cola<ObjetoSimple> cola = new Cola<>(capacidad);

        boolean volver = false;
        while (!volver) {
            System.out.println("\nMENU COLA");
            System.out.println("1. Encolar elemento");
            System.out.println("2. Desencolar elemento");
            System.out.println("3. Mirar frente");
            System.out.println("4. Verificar si esta vacia");
            System.out.println("5. Mostrar tamano");
            System.out.println("6. Mostrar contenido");
            System.out.println("7. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            int opcion = leerEntero();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del objeto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese referencia: ");
                    String referencia = scanner.nextLine();
                    cola.encolar(new ObjetoSimple(nombre, referencia));
                    System.out.println("Elemento encolado correctamente.");
                    break;
                case 2:
                    ObjetoSimple objDesencolado = cola.desencolar();
                    if (objDesencolado != null) {
                        System.out.println("Elemento desencolado: " + objDesencolado);
                    }
                    break;
                case 3:
                    ObjetoSimple frente = cola.mirar();
                    if (frente != null) {
                        System.out.println("Elemento en el frente: " + frente);
                    }
                    break;
                case 4:
                    System.out.println("La cola esta vacia: " + cola.estaVacia());
                    break;
                case 5:
                    System.out.println("Tamano de la cola: " + cola.cantidad());
                    System.out.println("Capacidad actual: " + cola.tamano());
                    break;
                case 6:
                    mostrarContenidoCola(cola);
                    break;
                case 7:
                    volver = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
        }
    }
    
    /**
     * muestra el contenido de la cola.
     */
    
    private static void mostrarContenidoCola(Cola<ObjetoSimple> cola) {
        System.out.println("\nCONTENIDO DE LA COLA (Desde el frente):");
        Cola<ObjetoSimple> colaTemp = new Cola<>(cola.cantidad());
        int contador = 1;

        while (!cola.estaVacia()) {
            ObjetoSimple obj = cola.desencolar();
            System.out.println(contador++ + ". " + obj);
            colaTemp.encolar(obj);
        }

        while (!colaTemp.estaVacia()) {
            cola.encolar(colaTemp.desencolar());
        }

        if (contador == 1) {
            System.out.println("La cola esta vacia");
        }
    }
    
    /**
     * ejecuta el menú de opciones para manipular la lista.
     * Se usa un bucle `do-while` para permitir que el usuario interactúe hasta que decida salir.
     */
    
    private static void menuLista() {
        System.out.print("\nIngrese capacidad inicial de la lista: ");
        int capacidad = leerEntero();
        Lista<ObjetoSimple> lista = new Lista<>(capacidad);

        boolean volver = false;
        while (!volver) {
            System.out.println("\nMENU LISTA");
            System.out.println("1. Agregar al final");
            System.out.println("2. Agregar al inicio");
            System.out.println("3. Insertar en posicion");
            System.out.println("4. Eliminar de posicion");
            System.out.println("5. Obtener de posicion");
            System.out.println("6. Mostrar contenido");
            System.out.println("7. Verificar si esta vacia");
            System.out.println("8. Mostrar tamano");
            System.out.println("9. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            int opcion = leerEntero();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del objeto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese referencia: ");
                    String referencia = scanner.nextLine();
                    lista.agregarAlFinal(new ObjetoSimple(nombre, referencia));
                    System.out.println("Elemento agregado correctamente.");
                    break;
                case 2:
                    System.out.print("Ingrese nombre del objeto: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese referencia: ");
                    referencia = scanner.nextLine();
                    lista.agregarAlInicio(new ObjetoSimple(nombre, referencia));
                    System.out.println("Elemento agregado al inicio correctamente.");
                    break;
                case 3:
                    System.out.print("Ingrese posicion para insertar: ");
                    int pos = leerEntero();
                    System.out.print("Ingrese nombre del objeto: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese referencia: ");
                    referencia = scanner.nextLine();
                    if (lista.insertarEn(pos, new ObjetoSimple(nombre, referencia))) {
                        System.out.println("Elemento insertado correctamente.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese posicion para eliminar: ");
                    pos = leerEntero();
                    ObjetoSimple objEliminado = lista.eliminarDe(pos);
                    if (objEliminado != null) {
                        System.out.println("Elemento eliminado: " + objEliminado);
                    }
                    break;
                case 5:
                    System.out.print("Ingrese posicion para consultar: ");
                    pos = leerEntero();
                    ObjetoSimple objConsultado = lista.obtenerDe(pos);
                    if (objConsultado != null) {
                        System.out.println("Elemento en posicion " + pos + ": " + objConsultado);
                    }
                    break;
                case 6:
                    lista.mostrarContenido();
                    break;
                case 7:
                    System.out.println("La lista esta vacia: " + lista.estaVacia());
                    break;
                case 8:
                    System.out.println("Tamano de la lista: " + lista.tamano());
                    System.out.println("Capacidad actual: " + lista.capacidadActual());
                    break;
                case 9:
                    volver = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
        }
    }
       
    /**
     * ejecuta el menú de opciones para manipular la maleta.
     * Se usa un bucle `do-while` para permitir que el usuario interactúe hasta que decida salir.
     */
    
    private static void menuMaleta() {
        System.out.print("\nIngrese capacidad inicial de la maleta: ");
        int capacidad = leerEntero();
        Maleta<ObjetoSimple> maleta = new Maleta<>(capacidad);

        boolean volver = false;
        while (!volver) {
            System.out.println("\nMENU MALETA");
            System.out.println("1. Agregar objeto");
            System.out.println("2. Mostrar contenido");
            System.out.println("3. Verificar si esta vacia");
            System.out.println("4. Mostrar tamano");
            System.out.println("5. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            int opcion = leerEntero();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del objeto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese referencia: ");
                    String referencia = scanner.nextLine();
                    maleta.agregar(new ObjetoSimple(nombre, referencia));
                    System.out.println("Objeto agregado a la maleta correctamente.");
                    break;
                case 2:
                    System.out.println("\nCONTENIDO DE LA MALETA:");
                    int contador = 1;
                    for (ObjetoSimple obj : maleta) {
                        System.out.println(contador++ + ". " + obj);
                    }
                    if (contador == 1) {
                        System.out.println("La maleta esta vacia");
                    }
                    break;
                case 3:
                    System.out.println("La maleta esta vacia: " + maleta.estaVacia());
                    break;
                case 4:
                    System.out.println("Cantidad de objetos en la maleta: " + maleta.tamano());
                    System.out.println("Capacidad actual: " + maleta.capacidadActual());
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
        }
    }

    private static int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada invalida. Ingrese un numero entero: ");
            }
        }
    }
}