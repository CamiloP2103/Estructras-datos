/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Juan Peña
 * @author Camilo Prieto
 * @author Rodrigo Bueno
 */
/**
 * Paquete que contiene la implementación de la estructura de datos Cola.
 */
import java.util.Iterator;

/**
 * Implementación de una cola genérica en Java siguiendo la filosofía FIFO (Primero en Entrar, Primero en Salir).
 * La cola se redimensiona automáticamente cuando alcanza su capacidad máxima.
 *
 * @param <Item> Tipo de elementos que almacenará la cola.
 * 
 * @author Juan Peña
 * @author Camilo Prieto
 * @author Rodrigo Bueno
 */
public class Cola<Item> implements Iterable<Item> {
    private Item[] a;   // Arreglo para almacenar los elementos
    private int ini;         // Índice del primer elemento
    private int fin;      // Índice del último elemento
    private int count;       // Número de elementos en la cola
    private int tamano;      // Capacidad actual del arreglo

    /**
     * Constructor que inicializa la cola con una capacidad dada.
     *
     * @param capacidadInicial Capacidad inicial de la cola
     */
    public Cola(int capacidadInicial) {
        tamano = capacidadInicial;
        a = (Item[]) new Object[tamano];
        ini = 0;
        fin = -1;
        count = 0;
    }

    /**
     * Redimensiona el arreglo interno de la cola.
     *
     * @param nuevaCapacidad Nueva capacidad del arreglo
     */
    private void redimensionar(int nuevaCapacidad) {
        Item[] temporal = (Item[]) new Object[nuevaCapacidad];
        
        // Copia los elementos manteniendo el orden FIFO
        for (int i = 0; i < count; i++) {
            temporal[i] = a[(ini + i) % tamano];
        }
        
        a = temporal;
        tamano = nuevaCapacidad;
        ini = 0;
        fin = count;
    }

    /**
     * Agrega un elemento al final de la cola (encolar).
     * Si la cola está llena, su tamaño se duplica automáticamente.
     *
     * @param elemento Elemento a agregar
     */
    public void encolar(Item elemento) {
        if (count == tamano) {
            redimensionar(2 * tamano); // Duplica la capacidad si es necesario
        }
        
        fin = (fin + 1) % tamano; // Avanza finalCola circularmente
        a[fin] = elemento;
        count++;
    }

    /**
     * Extrae y devuelve el elemento al frente de la cola (desencolar).
     *
     * @return Elemento al frente de la cola
     */
    public Item desencolar() {
        if (estaVacia()) {
            System.out.println("Advertencia: La cola esta vacia.");
            return null;
        }
        
        Item elemento = a[ini];
        a[ini] = null; // Evita el desperdicio de memoria
        ini = (ini + 1) % tamano; // Avanza frente circularmente
        count--;
        
        // Reduce el tamaño a la mitad si es muy grande y contiene pocos elementos
        if (count > 0 && count == tamano / 4) {
            redimensionar(tamano / 2);
        }
        
        return elemento;
    }

    /**
     * Devuelve el elemento al frente de la cola sin eliminarlo.
     *
     * @return Elemento al frente de la cola
     */
    public Item mirar() {
        if (estaVacia()) {
            System.out.println("Advertencia: La cola esta vacia.");
            return null;
        }
        return a[ini];
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return count == 0;
    }

    /**
     * Devuelve el número de elementos en la cola.
     *
     * @return Número de elementos en la cola
     */
    public int cantidad() {
        return count;
    }
    
     /**
     * Devuelve la capacidad actual de la Lista.
     *
     * @return Capacidad actual del arreglo interno
     */
    public int tamano() {
        return tamano;
    }

    /**
     * Implementación de la interfaz Iterable para recorrer la cola con for-each.
     *
     * @return Un iterador que recorre la cola de frente a final.
     */
    @Override
    public Iterator<Item> iterator() {
        return new IteradorCola();
    }

    /**
     * Clase interna que implementa Iterador para recorrer la cola.
     */
    private class IteradorCola implements Iterator<Item> {
        private int i = 0; // Comenzamos en el frente de la cola

        @Override
        public boolean hasNext() {
            return i < count;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                System.out.println("No hay mas elementos en la cola.");
            }
            // Obtiene el elemento actual (considerando la estructura circular)
            Item elemento = a[(ini + i) % tamano];
            i++;
            return elemento;
        }
    }
}
