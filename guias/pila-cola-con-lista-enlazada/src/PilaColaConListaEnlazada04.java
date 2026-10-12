/*
Prompt inicial utilizado:
Creá en Java 21 la clase autónoma `PilaColaConListaEnlazada04` que defina una `Cola<T>` enlazada genérica con su nodo genérico y las referencias `head` y `tail`. Ofrecé `enqueue`, `dequeue`, `front`, `isEmpty`, búsqueda e impresión. El encolado incorpora por tail y el desencolado extrae por head; cuando se vacía, ambos extremos quedan en null. Razoná que el orden FIFO se mantiene para cualquier T, con enqueue/dequeue/front en O(1) y búsqueda/impresión en O(n). `dequeue` y `front` en vacío arrojan `IllegalStateException`. En main ensayá una cola de nombres `String` y otra de objetos `Cliente` manteniendo juntos sus atributos; consultá y retirá en secuencia FIFO, buscá elementos y capturá el caso vacío. Construí la clase sin ayuda de colecciones ni del ejercicio 2. Añadí Javadoc y copiá este prompt entero al principio con la nota auténtica de ajustes cerrando el mismo comentario.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
import java.util.Objects;

/**
 * Ejercicio 4 — Cola enlazada genérica.
 * <p>La cola mantiene head y tail para asegurar enqueue/dequeue O(1) sin depender del tipo.
 * Nombres Ana, Luis salen Ana y luego Luis. Una Cola&lt;Cliente&gt; preserva todos sus campos.
 * contains/imprimir O(n), espacio O(n).</p>
 */
public class PilaColaConListaEnlazada04 {
    /** Nodo genérico enlazado.
     * @param <T> tipo almacenado
     */
    public static final class Nodo<T> { private final T dato; private Nodo<T> siguiente; private Nodo(T d) { dato = d; } }
    /** Cola FIFO genérica con extremos head y tail.
     * @param <T> tipo de los elementos
     */
    public static final class Cola<T> {
        private Nodo<T> head, tail; private int size;
        /** Construye una cola genérica vacía. */
        public Cola() { }
        /** Agrega al final.
         * @param dato valor a encolar
         */
        public void enqueue(T dato) { Nodo<T> n = new Nodo<>(dato); if (isEmpty()) head = tail = n; else { tail.siguiente = n; tail = n; } size++; }
        /** Retira el frente.
         * @return dato retirado
         * @throws IllegalStateException si está vacía
         */
        public T dequeue() { validar(); T dato = head.dato; head = head.siguiente; size--; if (head == null) tail = null; return dato; }
        /** Consulta el frente.
         * @return dato más antiguo
         * @throws IllegalStateException si está vacía
         */
        public T front() { validar(); return head.dato; }
        /** Indica si está vacía.
         * @return true si head y tail no apuntan a nodos
         */
        public boolean isEmpty() { return head == null; }
        /** Busca por igualdad.
         * @param dato elemento buscado
         * @return true si aparece
         */
        public boolean contains(T dato) { for (Nodo<T> n = head; n != null; n = n.siguiente) if (Objects.equals(n.dato, dato)) return true; return false; }
        /** Representa el contenido del frente al final.
         * @return elementos en orden FIFO
         */
        public String imprimir() { StringBuilder s = new StringBuilder(); for (Nodo<T> n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
        /** Devuelve el número de elementos en espera.
         * @return tamaño de la cola
         */
        public int size() { return size; }
        private void validar() { if (isEmpty()) throw new IllegalStateException("La cola está vacía."); }
    }
    /** Objeto propio con datos asociados.
     * @param nombre nombre del cliente
     * @param categoria motivo/categoría de atención
     */
    public record Cliente(String nombre, String categoria) { }
    private PilaColaConListaEnlazada04() { }

    /** Prueba colas de String y Cliente.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 4 — cola genérica");
        Cola<String> nombres = new Cola<>(); nombres.enqueue("Ana"); nombres.enqueue("Luis"); System.out.println("Nombres: " + nombres.imprimir() + ", front=" + nombres.front() + ", dequeue=" + nombres.dequeue());
        Cola<Cliente> clientes = new Cola<>(); clientes.enqueue(new Cliente("Marta", "Caja")); clientes.enqueue(new Cliente("Pablo", "Tarjeta"));
        System.out.println("Clientes: " + clientes.imprimir() + ", contiene Pablo=" + clientes.contains(new Cliente("Pablo", "Tarjeta")) + ", primero atendido=" + clientes.dequeue());
        Cola<String> vacia = new Cola<>(); try { vacia.dequeue(); } catch (IllegalStateException e) { System.out.println("dequeue vacío: " + e.getMessage()); }
    }
}
