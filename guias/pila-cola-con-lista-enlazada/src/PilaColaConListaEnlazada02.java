/*
Prompt inicial utilizado:
Creá en Java 21 la clase autónoma `PilaColaConListaEnlazada02` que brinde una cola FIFO de enteros con nodos propios y dos referencias: `head` para el frente y `tail` para el final. Proveé `enqueue`, `dequeue`, `front`, `isEmpty`, `contains` e `imprimir`. En una cola sin elementos, los dos extremos valen null. Al encolar el primer nodo, head y tail apuntan a él; en adelante se conecta `tail.siguiente` al nodo nuevo y se traslada tail. Al desencolar se corre head y, cuando sale el último nodo, tail también se lleva a null. Justificá que `tail` evita recorrer la cola entera para agregar: enqueue/dequeue/front/isEmpty en O(1), mientras buscar e imprimir cuestan O(n). `dequeue` y `front` sobre vacía arrojan `IllegalStateException`. Mostrá el orden FIFO, la búsqueda, el trabajo con varios elementos, el caso de una cola de un solo elemento que termina vacía y los errores sobre vacía. No emplees colecciones ni te apoyes en otra clase. Sumá Javadoc, el prompt inicial completo y, dentro del mismo comentario, la nota final con los ajustes reales.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 2 — Cola enlazada de enteros.
 * <p>head apunta al frente y tail al último, permitiendo enqueue y dequeue en O(1). Insertar
 * 10,20,30 y retirar produce 10,20,30 (FIFO). Una cola vacía tiene ambos extremos null; retirar
 * su único elemento restablece ambos. Búsqueda e impresión O(n), espacio O(n).</p>
 */
public class PilaColaConListaEnlazada02 {
    private static final class Nodo { private final int dato; private Nodo siguiente; Nodo(int d) { dato = d; } }
    private Nodo head, tail;
    private int size;

    /** Construye una cola inicialmente vacía. */
    public PilaColaConListaEnlazada02() { }

    /** Agrega al final de la cola.
     * @param dato valor que se encola
     */
    public void enqueue(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) head = tail = nuevo;
        else { tail.siguiente = nuevo; tail = nuevo; }
        size++;
    }
    /** Retira el elemento del frente.
     * @return valor retirado
     * @throws IllegalStateException si está vacía
     */
    public int dequeue() {
        validarNoVacia(); int dato = head.dato; head = head.siguiente; size--;
        if (head == null) tail = null;
        return dato;
    }
    /** Consulta el frente.
     * @return dato del frente
     * @throws IllegalStateException si está vacía
     */
    public int front() { validarNoVacia(); return head.dato; }
    /** Indica si la cola no contiene elementos.
     * @return true si está vacía
     */
    public boolean isEmpty() { return head == null; }
    /** Busca un valor secuencialmente.
     * @param dato valor buscado
     * @return true si se encuentra
     */
    public boolean contains(int dato) { for (Nodo n = head; n != null; n = n.siguiente) if (n.dato == dato) return true; return false; }
    /** Imprime desde el frente hasta tail.
     * @return contenido FIFO
     */
    public String imprimir() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Devuelve la cantidad de elementos.
     * @return tamaño actual
     */
    public int size() { return size; }
    private void validarNoVacia() { if (isEmpty()) throw new IllegalStateException("La cola está vacía."); }

    /** Prueba FIFO, búsqueda, estado vacío y transición con un único nodo.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 2 — cola enlazada");
        PilaColaConListaEnlazada02 q = new PilaColaConListaEnlazada02();
        for (int v : new int[]{10, 20, 30}) q.enqueue(v);
        System.out.println("Cola: " + q.imprimir() + ", front=" + q.front());
        System.out.println("contains(20)=" + q.contains(20) + ", contains(99)=" + q.contains(99));
        System.out.println("dequeue: " + q.dequeue() + ", " + q.dequeue() + ", " + q.dequeue() + "; vacía=" + q.isEmpty());
        q.enqueue(7); System.out.println("Único elemento: " + q.dequeue() + "; vacía=" + q.isEmpty() + ", contenido=" + q.imprimir());
        try { q.dequeue(); } catch (IllegalStateException e) { System.out.println("dequeue vacío: " + e.getMessage()); }
        try { q.front(); } catch (IllegalStateException e) { System.out.println("front vacío: " + e.getMessage()); }
    }
}
