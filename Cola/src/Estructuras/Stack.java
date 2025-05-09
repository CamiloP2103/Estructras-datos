/**
 * Package que contiene la implementación de la estructura de datos Stack.
 */

package Estructuras;

import java.util.Iterator;

/**
 * Implementación de una pila (Stack) genérica en Java.
 * La pila se redimensiona automáticamente cuando alcanza su capacidad máxima.
 *
 * @param <Item> Tipo de elementos que almacenará la pila.
 * 
 * @author Juan Peña
 * @author Camilo Prieto
 * @author Rodrigo Bueno
 */

public class Stack<Item> implements Iterable <Item> {
    private Item a[];// Arreglo para almacenar los elementos de la pila
    private int count;// Número de elementos en la pila
    
    /**
     * Constructor que inicializa la pila con una capacidad dada.
     *
     * @param initialCapacity Capacidad inicial de la pila
     */
    
    public Stack(int initialCapacity) {
        a = (Item[]) new Object[initialCapacity];
        count = 0;
    }
    
    /**
     * Redimensiona el arreglo interno de la pila.
     *
     * @param newCapacity Nueva capacidad del arreglo
     */
    private void resize(int newCapacity) {
        Item[] temp = (Item[]) new Object[newCapacity];
        for (int i = 0; i < count; i++) {
            temp[i] = a[i];
        }
        a = temp; // Actualizar la referencia del arreglo
    }
    
     /**
     * Agrega un elemento a la pila.
     * Si la pila está llena, su tamaño se duplica automáticamente.
     *
     * @param item Elemento a agregar
     */
    public void push(Item item) {
        if (count == a.length) {
            resize(2 * a.length); // Duplica la capacidad si es necesario
        }
        a[count++] = item;
    }
    
    /**
     * Extrae y devuelve el elemento en la cima de la pila.
     *
     * @return Elemento en la cima de la pila
     * @throws RuntimeException Si la pila está vacía
     */
    public Item pop() {
        if (isEmpty()) {
            System.out.println("Advertencia: La pila esta vacia.");
            return null; // Devuelve null si la pila esta vacia
        }
        Item item = a[--count];
        a[count] = null; // Evita el desperdicio de memoria
        
        // Reduce el tamaño a la mitad si es muy grande y contiene pocos elementos
        if (count > 0 && count == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }
    
    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     *
     * @return Elemento en la cima de la pila
     * @throws RuntimeException Si la pila está vacía
     */
    public Item peek() {
        if (isEmpty()) {
            System.out.println("Advertencia: La pila esta vacia.");
            return null; // Devuelve null si la pila esta vacia
        }
        return a[count - 1];
    }
    
    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /**
     * Devuelve el número de elementos en la pila.
     *
     * @return Número de elementos en la pila
     */
    public int size() {
        return count;
    }
    
    /**
     * Inserta un elemento en una posición específica de la pila.
     *
     * @param index Posición donde insertar el elemento.
     * @param item Elemento a insertar.
     */
    public void insertAt(int index, Item item) {
        if (index < 0 || index > count) {
            System.out.println("Error: Posición fuera de rango.");
            return;
        }
        if (count == a.length) {
            resize(2 * a.length);
        }
        for (int i = count; i > index; i--) {
            a[i] = a[i - 1];
        }
        a[index] = item;
        count++;
        System.out.println("Elemento insertado en la posición " + index);
    }

    /**
     * Elimina un elemento en una posición específica de la pila.
     *
     * @param index Posición del elemento a eliminar.
     */
    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            System.out.println("Error: Posición fuera de rango.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            a[i] = a[i + 1];
        }
        a[--count] = null;
        System.out.println("Elemento eliminado en la posición " + index);
    }
    
    /**
     * Implementación de la interfaz Iterable para recorrer la pila con for-each.
     *
     * @return Un iterador que recorre la pila de arriba hacia abajo.
     */
    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }
    
    /**
     * Clase interna que implementa Iterator para recorrer la pila.
     */
    private class StackIterator implements Iterator<Item> {
        private int current = count - 1; // Comenzamos en la cima de la pila

        @Override
        public boolean hasNext() {
            return current >= 0; // Mientras haya elementos en la pila
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                System.out.println("No hay más elementos en la pila.");
            }
            return a[current--]; // Retorna el elemento y disminuye el índice
        }
    
    }
}
