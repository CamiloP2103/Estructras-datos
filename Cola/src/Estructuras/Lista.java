/**
 * Paquete que contiene la implementación de la estructura de datos Lista.
 */
package Estructuras;

import java.util.Iterator;

/**
 * Implementación de una lista genérica en Java.
 * Permite agregar, insertar, eliminar y consultar elementos.
 *
 * @param <Item> Tipo de elementos que almacenará la lista.
 * 
 * @author Juan Peña
 * @author Camilo Prieto
 * @author Rodrigo Bueno
 * 
 */
public class Lista<Item> implements Iterable<Item> {
    private Item[] a;
    private int count;
    private int tamano;

    /**
     * Constructor que inicializa la lista con capacidad inicial.
     * @param capacidadInicial Capacidad inicial del arreglo interno.
     */
    public Lista(int capacidadInicial) {
        if (capacidadInicial <= 0) {
            System.out.println("Advertencia: Capacidad invalida");
            capacidadInicial = 0;
        }
        this.tamano = capacidadInicial;
        this.a = (Item[]) new Object[tamano];
        this.count = 0;
    }

    /**
     * Redimensiona el arreglo interno cuando es necesario.
     * @param nuevaCapacidad Nueva capacidad del arreglo.
     */
    private void redimensionar(int nuevaCapacidad) {
        Item[] nuevoArreglo = (Item[]) new Object[nuevaCapacidad];
        for (int i = 0; i < count; i++) {
            nuevoArreglo[i] = a[i];
        }
        a = nuevoArreglo;
        tamano = nuevaCapacidad;
    }

    /**
     * Agrega un elemento al final de la lista.
     * @param elemento Elemento a agregar.
     */
    public void agregarAlFinal(Item elemento) {
        if (count == tamano) {
            redimensionar(tamano * 2);
        }
        a[count++] = elemento;
    }

    /**
     * Agrega un elemento al inicio de la lista.
     * @param elemento Elemento a agregar.
     */
    public void agregarAlInicio(Item elemento) {
        if (count == tamano) {
            redimensionar(tamano * 2);
        }
        
        for (int i = count; i > 0; i--) {
            a[i] = a[i - 1];
        }
        
        a[0] = elemento;
        count++;
    }

    /**
     * Inserta un elemento en la posición especificada.
     * @param posicion Posición donde insertar el elemento.
     * @param elemento Elemento a insertar.
     * @return true si la inserción fue exitosa, false si la posición es inválida.
     */
    public boolean insertarEn(int posicion, Item elemento) {
        if (posicion < 0 || posicion > count) {
            System.out.println("Error: Posición inválida.");
            return false;
        }
        
        if (count == tamano) {
            redimensionar(tamano * 2);
        }
        
        if (posicion == count) {
            agregarAlFinal(elemento);
        } else {
            for (int i = count; i > posicion; i--) {
                a[i] = a[i - 1];
            }
            a[posicion] = elemento;
            count++;
        }
        return true;
    }

    /**
     * Elimina y retorna el elemento en la posición especificada.
     * @param posicion Posición del elemento a eliminar.
     * @return Elemento eliminado o null si la posición es inválida.
     */
    public Item eliminarDe(int posicion) {
        if (posicion < 0 || posicion >= count) {
            System.out.println("Error: Posición inválida.");
            return null;
        }
        
        Item elemento = a[posicion];
        
        for (int i = posicion; i < count - 1; i++) {
            a[i] = a[i + 1];
        }
        
        a[--count] = null;
        
        if (count > 0 && count == tamano / 4) {
            redimensionar(tamano / 2);
        }
        
        return elemento;
    }

    /**
     * Obtiene el elemento en la posición especificada sin eliminarlo.
     * @param posicion Posición del elemento a obtener.
     * @return Elemento en la posición o null si es inválida.
     */
    public Item obtenerDe(int posicion) {
        if (posicion < 0 || posicion >= count) {
            System.out.println("Error: Posicion invalida.");
            return null;
        }
        return a[posicion];
    }

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean estaVacia() {
        return count == 0;
    }

    /**
     * Obtiene la cantidad de elementos en la lista.
     * @return Número de elementos en la lista.
     */
    public int tamano() {
        return count;
    }
    
     /**
     * Devuelve la capacidad actual de la Lista.
     *
     * @return Capacidad actual del arreglo interno
     */
    public int capacidadActual() {
        return tamano;
    }

    /**
     * Muestra el contenido de la lista en la consola.
     */
    public void mostrarContenido() {
        System.out.println("\nContenido de la lista:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + a[i]);
        }
        if (count == 0) {
            System.out.println("La lista esta vacia.");
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new IteradorLista();
    }

    /**
     * Clase interna que implementa el iterador para la lista.
     */
    private class IteradorLista implements Iterator<Item> {
        private int posicionActual = 0;

        @Override
        public boolean hasNext() {
            return posicionActual < count;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                System.out.println("Advertencia: No hay más elementos.");
                return null;
            }
            return a[posicionActual++];
        }
    }
}