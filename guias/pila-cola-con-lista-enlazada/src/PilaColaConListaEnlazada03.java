/*
Prompt inicial utilizado:
Creá en Java 21 la clase autónoma `PilaColaConListaEnlazada03` que contenga una pila enlazada `Pila<T>` junto con sus nodos `Nodo<T>`, todo declarado en el mismo archivo. Brindá `push`, `pop`, `peek`, `isEmpty`, búsqueda e impresión. La cabeza actúa como cima y cada push/pop cuesta O(1); la búsqueda y la impresión cuestan O(n). Ante una pila vacía, la consulta o el desapilado arrojan `IllegalStateException`. Argumentá que los genéricos dejan reutilizar la misma lógica LIFO con verificación estática de tipos y que los nodos y enlaces resultan independientes del dato guardado. En main instanciá por separado `Pila<Integer>`, `Pila<String>` y `Pila<Producto>` con un tipo propio `Producto`; no combines tipos distintos en una misma instancia. Probá tope, búsqueda e impresión. No te bases en el ejercicio 1 ni uses colecciones. Agregá Javadoc y un comentario inicial con este prompt reproducido de forma íntegra y la nota fiel de ajustes a continuación.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
import java.util.Objects;

/**
 * Ejercicio 3 — Pila enlazada genérica.
 * <p>Una misma implementación LIFO sirve para Integer, String y Producto. El tipo T asegura
 * comprobación estática y no altera las referencias. Ejemplo: push(10), push(20), peek()=20,
 * pop()=20. Push/pop O(1), contains/imprimir O(n), almacenamiento O(n).</p>
 */
public class PilaColaConListaEnlazada03 {
    /** Nodo enlazado con dato de tipo T.
     * @param <T> tipo de valor
     */
    public static final class Nodo<T> { private final T dato; private final Nodo<T> siguiente; private Nodo(T d, Nodo<T> s) { dato = d; siguiente = s; } }
    /** Pila LIFO enlazada genérica.
     * @param <T> tipo almacenado
     */
    public static final class Pila<T> {
        private Nodo<T> head; private int size;
        /** Construye una pila genérica vacía. */
        public Pila() { }
        /** Apila un dato.
         * @param dato valor que pasa al tope
         */
        public void push(T dato) { head = new Nodo<>(dato, head); size++; }
        /** Retira el tope.
         * @return valor retirado
         * @throws IllegalStateException si está vacía
         */
        public T pop() { validar(); T dato = head.dato; head = head.siguiente; size--; return dato; }
        /** Consulta el tope sin retirarlo.
         * @return valor superior
         * @throws IllegalStateException si está vacía
         */
        public T peek() { validar(); return head.dato; }
        /** Comprueba si no contiene nodos.
         * @return true si está vacía
         */
        public boolean isEmpty() { return head == null; }
        /** Busca por igualdad de objetos.
         * @param dato valor objetivo
         * @return true si se encuentra
         */
        public boolean contains(T dato) { for (Nodo<T> n = head; n != null; n = n.siguiente) if (Objects.equals(n.dato, dato)) return true; return false; }
        /** Representa la pila de tope a fondo.
         * @return cadena con sus datos
         */
        public String imprimir() { StringBuilder s = new StringBuilder(); for (Nodo<T> n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
        /** Devuelve el número de elementos apilados.
         * @return tamaño de la pila
         */
        public int size() { return size; }
        private void validar() { if (isEmpty()) throw new IllegalStateException("La pila está vacía."); }
    }
    /** Tipo de referencia propio usado en la demostración.
     * @param nombre nombre del producto
     */
    public record Producto(String nombre) { }
    private PilaColaConListaEnlazada03() { }

    /** Demuestra pilas de tres tipos sin mezclarlos.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 3 — pila genérica");
        Pila<Integer> enteros = new Pila<>(); enteros.push(10); enteros.push(20); System.out.println("Integer: " + enteros.imprimir() + ", peek=" + enteros.peek() + ", contiene10=" + enteros.contains(10));
        Pila<String> textos = new Pila<>(); textos.push("primero"); textos.push("segundo"); System.out.println("String: " + textos.imprimir() + ", pop=" + textos.pop());
        Pila<Producto> productos = new Pila<>(); Producto cuaderno = new Producto("Cuaderno"); productos.push(cuaderno); System.out.println("Producto: " + productos.imprimir() + ", contiene=" + productos.contains(new Producto("Cuaderno")));
        Pila<Integer> vacia = new Pila<>(); try { vacia.peek(); } catch (IllegalStateException e) { System.out.println("peek vacío: " + e.getMessage()); }
    }
}
