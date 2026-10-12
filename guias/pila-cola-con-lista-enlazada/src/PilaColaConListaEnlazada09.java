/*
Prompt inicial utilizado:
Creá en Java 21 la clase autónoma `PilaColaConListaEnlazada09` con el record `TrabajoImpresion(nombreArchivo, paginas, usuario)` y una cola FIFO enlazada de confección propia. Conservá nodos enlazados con `head`/`tail`; cada trabajo mantiene unidos sus datos. Brindá agregar/encolar, imprimir siguiente/desencolar, consultar el archivo siguiente y exhibir los pendientes. Requerí páginas > 0 y rechazá con `IllegalArgumentException` claro todo trabajo con cantidad no positiva antes de encolarlo. No emules impresora ni tiempos de impresión. En vacío, imprimir o consultar debe arrojar `IllegalStateException`. En main encolá `informe.pdf` (3 páginas, Ana) y `tarea.docx` (5, Luis), consultá el siguiente, enseñá la cola, retirá el primero y volvé a exhibirla; ejercitá un trabajo inválido y la cola sin elementos capturando sus excepciones. Razoná el orden FIFO con enqueue/dequeue/front en O(1), impresión en O(n) y espacio en O(n). Documentá casos y Javadoc, y copiá el prompt entero al comienzo con la nota veraz de ajustes.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 9 — Cola FIFO de impresión.
 * <p>Se encolan informe.pdf (3 páginas, Ana) y tarea.docx (5, Luis); sale primero informe.pdf.
 * El trabajo conserva nombre, páginas y usuario unidos. Páginas debe ser positivo. Operaciones
 * de extremo O(1), impresión O(n), espacio O(n).</p>
 */
public class PilaColaConListaEnlazada09 {
    /** Trabajo completo enviado a la impresora.
     * @param nombreArchivo archivo a imprimir
     * @param paginas cantidad positiva de páginas
     * @param usuario remitente
     */
    public record TrabajoImpresion(String nombreArchivo, int paginas, String usuario) {
        /** Valida datos obligatorios.
         * @throws IllegalArgumentException si falta texto o páginas no es positiva
         */
        public TrabajoImpresion {
            if (nombreArchivo == null || nombreArchivo.isBlank() || usuario == null || usuario.isBlank()) throw new IllegalArgumentException("Nombre de archivo y usuario son obligatorios.");
            if (paginas <= 0) throw new IllegalArgumentException("La cantidad de páginas debe ser positiva.");
        }
    }
    private static final class Nodo { private final TrabajoImpresion trabajo; private Nodo siguiente; private Nodo(TrabajoImpresion t) { trabajo = t; } }
    private Nodo head, tail;
    /** Construye una cola de impresión vacía. */
    public PilaColaConListaEnlazada09() { }
    /** Añade un trabajo al final FIFO.
     * @param trabajo trabajo válido
     * @throws IllegalArgumentException si es null
     */
    public void agregar(TrabajoImpresion trabajo) { if (trabajo == null) throw new IllegalArgumentException("El trabajo no puede ser null."); Nodo n = new Nodo(trabajo); if (head == null) head = tail = n; else { tail.siguiente = n; tail = n; } }
    /** Retira el próximo trabajo.
     * @return trabajo procesado
     * @throws IllegalStateException si no hay trabajos
     */
    public TrabajoImpresion imprimirProximo() { validar(); TrabajoImpresion t = head.trabajo; head = head.siguiente; if (head == null) tail = null; return t; }
    /** Consulta el archivo siguiente sin retirarlo.
     * @return nombre de archivo
     * @throws IllegalStateException si está vacía
     */
    public String proximoArchivo() { validar(); return head.trabajo.nombreArchivo(); }
    /** Muestra trabajos pendientes desde el más antiguo.
     * @return representación de la cola
     */
    public String mostrarPendientes() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.trabajo).append(" -> "); return s.append("null").toString(); }
    private void validar() { if (head == null) throw new IllegalStateException("No hay trabajos pendientes."); }
    /** Demuestra orden de trabajos, datos inválidos y cola vacía.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 9 — impresión FIFO"); PilaColaConListaEnlazada09 q = new PilaColaConListaEnlazada09();
        q.agregar(new TrabajoImpresion("informe.pdf", 3, "Ana")); q.agregar(new TrabajoImpresion("tarea.docx", 5, "Luis"));
        System.out.println("Pendientes: " + q.mostrarPendientes() + "; próximo=" + q.proximoArchivo()); System.out.println("Impreso: " + q.imprimirProximo()); System.out.println("Pendientes: " + q.mostrarPendientes());
        try { new TrabajoImpresion("vacio.pdf", 0, "Ana"); } catch (IllegalArgumentException e) { System.out.println("Trabajo inválido: " + e.getMessage()); }
        q.imprimirProximo(); try { q.proximoArchivo(); } catch (IllegalStateException e) { System.out.println("Consulta vacía: " + e.getMessage()); }
    }
}
