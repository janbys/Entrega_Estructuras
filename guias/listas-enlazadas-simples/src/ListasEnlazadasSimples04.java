/*
Prompt inicial utilizado:
En Java 21 creá la clase autónoma `ListasEnlazadasSimples04` con su propia lista simple de enteros. Implementá void insertarEnPosicion(int dato, int posicion) aceptando 0 <= posicion <= size, donde 0 significa inicio, size significa final y los valores intermedios quedan entre nodos. Comprobá la validez antes de tocar el estado y lanzá IndexOutOfBoundsException si no corresponde. En el caso intermedio conservá los enlaces en este orden: primero nuevo.siguiente = actual.siguiente y recién después actual.siguiente = nuevo. Justificá que modificar antes el enlace previo sin resguardar el siguiente deja inaccesible el resto. Aumentá size una única vez. En main mostrá inserción en lista vacía, al inicio, en el medio, al final y ejemplos inválidos que no modifican nada. Sin colecciones; documentá el costo O(n). Reproducí este prompt íntegro al inicio y al final comunicá los ajustes reales o la ausencia de ellos.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 4. Inserción en una posición válida de la lista.
 * <p>Partiendo de [20, 40], insertar(10,0), insertar(30,2), insertar(50,4) produce
 * [10, 20, 30, 40, 50]. Se conserva primero el enlace siguiente del nodo actual antes de
 * conectarlo al nuevo. Índices inválidos no alteran estado. Recorrido O(n), enlace O(1).</p>
 */
public class ListasEnlazadasSimples04 {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int d) { dato = d; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public ListasEnlazadasSimples04() { }
    /** Inserta antes de la posición especificada.
     * @param dato dato nuevo
     * @param posicion índice entre cero y size inclusive
     * @throws IndexOutOfBoundsException si posición no pertenece a [0,size]
     */
    public void insertarEnPosicion(int dato, int posicion) {
        if (posicion < 0 || posicion > size) throw new IndexOutOfBoundsException("Posición " + posicion + " fuera de [0, " + size + "].");
        Nodo nuevo = new Nodo(dato);
        if (posicion == 0) { nuevo.siguiente = head; head = nuevo; }
        else { Nodo actual = head; for (int i = 0; i < posicion - 1; i++) actual = actual.siguiente;
            // Primero se conserva la cadena restante; luego el anterior queda enlazado al nuevo.
            nuevo.siguiente = actual.siguiente; actual.siguiente = nuevo;
        }
        size++;
    }
    private String mostrar() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Demuestra inserciones al inicio, medio, final y errores de índice.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        ListasEnlazadasSimples04 l = new ListasEnlazadasSimples04(); l.insertarEnPosicion(20, 0); l.insertarEnPosicion(40, 1);
        l.insertarEnPosicion(10, 0); l.insertarEnPosicion(30, 2); l.insertarEnPosicion(50, l.size);
        System.out.println("Ejercicio 4 — " + l.mostrar() + ", size=" + l.size);
        for (int p : new int[]{-1, l.size + 1}) try { l.insertarEnPosicion(99, p); } catch (IndexOutOfBoundsException e) { System.out.println("Inserción rechazada: " + e.getMessage()); }
        System.out.println("Sin cambios: " + l.mostrar() + ", size=" + l.size);
    }
}
