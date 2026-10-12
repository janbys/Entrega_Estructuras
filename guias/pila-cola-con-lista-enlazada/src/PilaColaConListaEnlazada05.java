/*
Prompt inicial utilizado:
Creá en Java 21 la clase autónoma `PilaColaConListaEnlazada05` que represente el historial de navegación mediante una pila enlazada de URLs `String`, sin apelar a colecciones de Java. Disponé operaciones para visitar (push), volver (pop), ver la página actual (peek) e imprimir el historial. La última página visitada ocupa la cima y abandona primero la estructura al retroceder (LIFO); dos retrocesos consecutivos devuelven las páginas previas en su orden. No añadas pila de avanzar ni comportamiento propio de un navegador real. Con historial sin elementos, volver y consultar la página actual arrojan `IllegalStateException` con mensaje claro. En main visitá `https://inicio.test`, `https://busqueda.test` y `https://articulo.test`, imprimí, retrocedé una vez, consultá la página vigente e imprimí de nuevo; además ejercitá el retroceso y la consulta en vacío capturando sus excepciones. Dejá constancia de operaciones en O(1), impresión en O(n), Javadoc y casos borde. Reproducí el prompt completo como comentario inicial y sumá en ese comentario la nota fiel de ajustes.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 5 — Historial con pila enlazada.
 * <p>Visitar inicio, búsqueda y artículo deja el artículo actual; volver lo quita y revela la
 * búsqueda anterior. LIFO representa correctamente volver atrás. Visitar/volver/actual O(1),
 * imprimir O(n), almacenamiento O(n).</p>
 */
public class PilaColaConListaEnlazada05 {
    private static final class Nodo { private final String url; private final Nodo siguiente; private Nodo(String u, Nodo s) { url = u; siguiente = s; } }
    private Nodo head;
    /** Construye un historial vacío. */
    public PilaColaConListaEnlazada05() { }
    /** Apila una URL visitada.
     * @param url página visitada
     */
    public void visitar(String url) { if (url == null) throw new IllegalArgumentException("La URL no puede ser null."); head = new Nodo(url, head); }
    /** Retrocede retirando la página actual.
     * @return URL retirada
     * @throws IllegalStateException si el historial está vacío
     */
    public String volver() { validar(); String url = head.url; head = head.siguiente; return url; }
    /** Consulta la página actual.
     * @return URL de la cima
     * @throws IllegalStateException si no hay páginas
     */
    public String paginaActual() { validar(); return head.url; }
    /** Imprime el historial desde actual a la más antigua.
     * @return URLs apiladas
     */
    public String imprimir() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.url).append(" -> "); return s.append("null").toString(); }
    private void validar() { if (head == null) throw new IllegalStateException("El historial está vacío."); }
    /** Prueba visitar, consultar y retroceder hasta vacío.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 5 — historial web"); PilaColaConListaEnlazada05 h = new PilaColaConListaEnlazada05();
        h.visitar("https://inicio.test"); h.visitar("https://busqueda.test"); h.visitar("https://articulo.test");
        System.out.println("Historial actual→anterior: " + h.imprimir()); System.out.println("Página actual: " + h.paginaActual());
        System.out.println("Volver desde: " + h.volver() + "; ahora: " + h.paginaActual()); System.out.println("Historial: " + h.imprimir());
        h.volver(); h.volver();
        try { h.volver(); } catch (IllegalStateException e) { System.out.println("Volver sin páginas: " + e.getMessage()); }
        try { h.paginaActual(); } catch (IllegalStateException e) { System.out.println("Consultar vacío: " + e.getMessage()); }
    }
}
