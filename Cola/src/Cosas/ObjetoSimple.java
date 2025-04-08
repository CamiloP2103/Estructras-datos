/**
 * Paquete que contiene clases de ejemplo para usar con las estructuras de datos.
 */
package Cosas;

/**
 * Clase simple que puede ser almacenada en cualquier estructura de datos.
 */
public class ObjetoSimple {
    private String nombre;
    private String referencia;

    public ObjetoSimple(String nombre, String referencia) {
        this.nombre = nombre;
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    @Override
    public String toString() {
        return nombre + " (Ref: " + referencia + ")";
    }
}