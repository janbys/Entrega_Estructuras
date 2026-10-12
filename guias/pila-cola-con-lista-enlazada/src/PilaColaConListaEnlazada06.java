/*
Prompt inicial utilizado:
Creá en Java 21 la clase autónoma `PilaColaConListaEnlazada06` con un record/clase `Cliente` compuesto por nombre, número de turno y motivo de consulta. Guardá objetos completos dentro de una cola enlazada propia provista de `head` y `tail`, sin colecciones. Ofrecé registro/encolado, atención/desencolado, consulta del próximo e impresión de la fila. Respetá FIFO: quien arribó primero recibe atención primero. En vacío, atender y consultar arrojan `IllegalStateException`; al atender al único integrante, head y tail terminan en null. En main registrá a Ana (turno 101, depósitos) y a Bruno (102, tarjeta), consultá, atendé al primero, mostrá la fila, atendé al restante e intentá atender sin nadie en espera. Verificá que los atributos viajen juntos y que se preserve el orden de arribo. Enqueue/dequeue/front en O(1), impresión en O(n). Sumá Javadoc, trabajá sin dependencias, copiá el prompt inicial entero y cerrá con la nota veraz de ajustes.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 6 — Cola FIFO de atención bancaria.
 * <p>Ana turno 101 se registra antes que Bruno 102; consultar muestra Ana y atenderla conserva
 * Bruno al frente. Cada Cliente mantiene nombre, turno y motivo juntos. Operaciones de extremo O(1),
 * impresión O(n), espacio O(n). Vacío al retirar/consultar lanza IllegalStateException.</p>
 */
public class PilaColaConListaEnlazada06 {
    /** Datos asociados de cada cliente.
     * @param nombre nombre de la persona
     * @param turno número asignado
     * @param motivo motivo de consulta
     */
    public record Cliente(String nombre, int turno, String motivo) { }
    private static final class Nodo { private final Cliente cliente; private Nodo siguiente; private Nodo(Cliente c) { cliente = c; } }
    private Nodo head, tail; private int size;
    /** Construye una fila de atención vacía. */
    public PilaColaConListaEnlazada06() { }
    /** Registra un cliente al final.
     * @param cliente cliente completo
     * @throws IllegalArgumentException si es null
     */
    public void registrar(Cliente cliente) { if (cliente == null) throw new IllegalArgumentException("El cliente no puede ser null."); Nodo n = new Nodo(cliente); if (head == null) head = tail = n; else { tail.siguiente = n; tail = n; } size++; }
    /** Atiende y retira el primero.
     * @return cliente atendido
     * @throws IllegalStateException si la fila está vacía
     */
    public Cliente atender() { validar(); Cliente c = head.cliente; head = head.siguiente; size--; if (head == null) tail = null; return c; }
    /** Consulta al próximo cliente.
     * @return cliente al frente
     * @throws IllegalStateException si la fila está vacía
     */
    public Cliente quienSigue() { validar(); return head.cliente; }
    /** Imprime la fila en orden de llegada.
     * @return cadena de clientes
     */
    public String imprimir() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.cliente).append(" -> "); return s.append("null").toString(); }
    private void validar() { if (head == null) throw new IllegalStateException("No hay clientes en espera."); }
    /** Prueba orden, campos asociados y fila vacía.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 6 — atención bancaria"); PilaColaConListaEnlazada06 q = new PilaColaConListaEnlazada06();
        q.registrar(new Cliente("Ana", 101, "Depósitos")); q.registrar(new Cliente("Bruno", 102, "Tarjeta"));
        System.out.println("Fila: " + q.imprimir()); System.out.println("Sigue: " + q.quienSigue()); System.out.println("Atendido: " + q.atender());
        System.out.println("Fila restante: " + q.imprimir()); System.out.println("Atendido: " + q.atender() + "; vacía=" + (q.size == 0));
        try { q.atender(); } catch (IllegalStateException e) { System.out.println("Atención vacía: " + e.getMessage()); }
        try { q.quienSigue(); } catch (IllegalStateException e) { System.out.println("Consulta vacía: " + e.getMessage()); }
    }
}
