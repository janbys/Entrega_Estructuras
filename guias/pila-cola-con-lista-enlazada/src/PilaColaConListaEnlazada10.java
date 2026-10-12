/*
Prompt inicial utilizado:
Creá en Java 21 la clase autónoma `PilaColaConListaEnlazada10` que aporte `ListaDoblementeEnlazada<T>` y `Nodo<T>`. Cada nodo conserva `anterior` y `siguiente`; la lista sostiene `head`, `tail` y `size`. Brindá inserción al comienzo, inserción al final, borrado de la primera coincidencia por igualdad con `Objects.equals` (retorna boolean), impresión hacia adelante desde head e impresión hacia atrás desde tail. Detallá el doble enlace y las situaciones de borrado: cabeza, cola, nodo intermedio, ejemplar único y dato inexistente. Preservá invariantes: el anterior de head en null y el siguiente de tail en null; sin elementos, head y tail en null; al quitar el nodo solitario actualizá ambos extremos. Complejidad: inserción en bordes O(1), borrado por valor O(n), recorridos O(n), espacio O(n). En main ensayá la lista vacía, Integer y String en instancias genéricas distintas, recorridos en las dos direcciones, borrado al inicio/en el medio/al final, valor ausente y borrado del último nodo. No uses colecciones. Añadí Javadoc y este prompt entero en un comentario inicial con la nota auténtica de ajustes después.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
import java.util.Objects;

/**
 * Ejercicio 10 — Lista doblemente enlazada genérica.
 * <p>Cada nodo enlaza al anterior y al siguiente; head/tail permiten recorridos en ambos sentidos.
 * Se demuestra con Integer y String.
 * Se prueban eliminaciones en extremos, medio, único nodo y dato ausente. Insertar en extremos
 * O(1), buscar/eliminar por dato e imprimir O(n), espacio O(n).</p>
 */
public class PilaColaConListaEnlazada10 {
    /** Nodo genérico con referencias bidireccionales.
     * @param <T> tipo del dato
     */
    public static final class Nodo<T> {
        private final T dato; private Nodo<T> anterior, siguiente;
        private Nodo(T dato) { this.dato = dato; }
    }
    /** Lista doblemente enlazada genérica.
     * @param <T> tipo almacenado
     */
    public static final class ListaDoblementeEnlazada<T> {
        private Nodo<T> head, tail; private int size;
        /** Construye una lista doblemente enlazada vacía. */
        public ListaDoblementeEnlazada() { }
        /** Inserta un valor como primer nodo.
         * @param dato elemento nuevo
         */
        public void insertarAlInicio(T dato) {
            Nodo<T> n = new Nodo<>(dato); n.siguiente = head;
            if (head == null) tail = n; else head.anterior = n;
            head = n; size++;
        }
        /** Inserta un valor como último nodo.
         * @param dato elemento nuevo
         */
        public void insertarAlFinal(T dato) {
            Nodo<T> n = new Nodo<>(dato); n.anterior = tail;
            if (tail == null) head = n; else tail.siguiente = n;
            tail = n; size++;
        }
        /** Elimina la primera coincidencia.
         * @param dato valor que se busca
         * @return true si se encontró y eliminó
         */
        public boolean eliminar(T dato) {
            Nodo<T> actual = head;
            while (actual != null && !Objects.equals(actual.dato, dato)) actual = actual.siguiente;
            if (actual == null) return false;
            if (actual.anterior == null) head = actual.siguiente; else actual.anterior.siguiente = actual.siguiente;
            if (actual.siguiente == null) tail = actual.anterior; else actual.siguiente.anterior = actual.anterior;
            size--; return true;
        }
        /** Imprime desde head hasta tail.
         * @return datos hacia adelante
         */
        public String imprimirHaciaAdelante() { StringBuilder s = new StringBuilder(); for (Nodo<T> n = head; n != null; n = n.siguiente) s.append(n.dato).append(" <-> "); return s.append("null").toString(); }
        /** Imprime desde tail hasta head.
         * @return datos hacia atrás
         */
        public String imprimirHaciaAtras() { StringBuilder s = new StringBuilder(); for (Nodo<T> n = tail; n != null; n = n.anterior) s.append(n.dato).append(" <-> "); return s.append("null").toString(); }
        /** Indica si la lista está vacía.
         * @return true si ambos extremos están vacíos
         */
        public boolean isEmpty() { return head == null; }
        /** Devuelve el número de nodos.
         * @return tamaño actual
         */
        public int size() { return size; }
    }
    private PilaColaConListaEnlazada10() { }

    /** Demuestra recorridos y eliminación de todos los casos estructurales.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 10 — lista doblemente enlazada");
        ListaDoblementeEnlazada<Integer> l = new ListaDoblementeEnlazada<>();
        System.out.println("Vacía: " + l.isEmpty() + ", adelante=" + l.imprimirHaciaAdelante() + ", atrás=" + l.imprimirHaciaAtras());
        l.insertarAlFinal(20); System.out.println("Único: " + l.imprimirHaciaAdelante() + "; eliminar único=" + l.eliminar(20) + ", vacía=" + l.isEmpty());
        l.insertarAlInicio(20); l.insertarAlInicio(10); l.insertarAlFinal(30); l.insertarAlFinal(40);
        System.out.println("Lista: " + l.imprimirHaciaAdelante()); System.out.println("Reversa: " + l.imprimirHaciaAtras());
        System.out.println("Eliminar cabeza 10=" + l.eliminar(10) + ": " + l.imprimirHaciaAdelante());
        System.out.println("Eliminar medio 30=" + l.eliminar(30) + ": " + l.imprimirHaciaAdelante());
        System.out.println("Eliminar cola 40=" + l.eliminar(40) + ": " + l.imprimirHaciaAdelante());
        System.out.println("Eliminar ausente 99=" + l.eliminar(99) + "; size=" + l.size());
        System.out.println("Eliminar último nodo 20=" + l.eliminar(20) + "; vacía=" + l.isEmpty() + ", size=" + l.size());
        ListaDoblementeEnlazada<String> nombres = new ListaDoblementeEnlazada<>(); nombres.insertarAlInicio("Ana"); nombres.insertarAlFinal("Luis");
        System.out.println("String adelante: " + nombres.imprimirHaciaAdelante() + "; atrás: " + nombres.imprimirHaciaAtras());
    }
}
