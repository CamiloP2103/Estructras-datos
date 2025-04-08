/**
 * Paquete que contiene la implementación de la estructura de datos Maleta.
 */
package Estructuras;

import java.util.Iterator;

/**
 * Implementación de una maleta genérica en Java.
 * La maleta es similar a una cola pero sin operaciones de eliminación.
 * Se redimensiona automáticamente cuando alcanza su capacidad máxima.
 *
 * @param <Item> Tipo de elementos que almacenará la maleta.
 * 
 * @author Juan Peña
 * @author Camilo Prieto
 * @author Rodrigo Bueno
 */
public class Maleta<Item> implements Iterable<Item> {
    private Item[] elementos;   // Arreglo para almacenar los elementos
    private int cantidad;       // Número de elementos en la maleta
    private int capacidad;      // Capacidad actual del arreglo

    /**
     * Constructor que inicializa la maleta con una capacidad dada.
     *
     * @param capacidadInicial Capacidad inicial de la maleta
     */
    public Maleta(int capacidadInicial) {
        capacidad = capacidadInicial;
        elementos = (Item[]) new Object[capacidad];
        cantidad = 0;
    }

    /**
     * Redimensiona el arreglo interno de la maleta.
     *
     * @param nuevaCapacidad Nueva capacidad del arreglo
     */
    private void redimensionar(int nuevaCapacidad) {
        Item[] temporal = (Item[]) new Object[nuevaCapacidad];
        
        // Copia los elementos
        for (int i = 0; i < cantidad; i++) {
            temporal[i] = elementos[i];
        }
        
        elementos = temporal;
        capacidad = nuevaCapacidad;
    }

    /**
     * Agrega un elemento a la maleta.
     * Si la maleta está llena, su tamaño se duplica automáticamente.
     *
     * @param elemento Elemento a agregar
     */
    public void agregar(Item elemento) {
        if (cantidad == capacidad) {
            redimensionar(2 * capacidad); // Duplica la capacidad si es necesario
        }
        
        elementos[cantidad++] = elemento;
    }

    /**
     * Verifica si la maleta está vacía.
     *
     * @return true si la maleta está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return cantidad == 0;
    }

    /**
     * Devuelve el número de elementos en la maleta.
     *
     * @return Número de elementos en la maleta
     */
    public int tamano() {
        return cantidad;
    }
    
        /**
     * Devuelve la capacidad actual de la Maleta.
     *
     * @return Capacidad actual del arreglo interno
     */
    public int capacidadActual() {
        return capacidad;
    }

    /**
     * Implementación de la interfaz Iterable para recorrer la maleta con for-each.
     *
     * @return Un iterador que recorre la maleta
     */
    @Override
    public Iterator<Item> iterator() {
        return new IteradorMaleta();
    }

    /**
     * Clase interna que implementa Iterador para recorrer la maleta.
     */
    private class IteradorMaleta implements Iterator<Item> {
        private int actual = 0; // Comenzamos en el primer elemento

        @Override
        public boolean hasNext() {
            return actual < cantidad;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                System.out.println("No hay mas elementos en la maleta.");
            }
            return elementos[actual++];
        }
    }
}
