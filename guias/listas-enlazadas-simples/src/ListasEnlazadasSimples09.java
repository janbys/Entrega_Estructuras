/*
Prompt inicial utilizado:
En Java 21 creá la clase autónoma `ListasEnlazadasSimples09` con su propia lista de enteros y el método invertir() in-place. Manejá las referencias anterior, actual y siguiente: resguardá siguiente antes de reescribir actual.siguiente, redirigí el enlace y avanzá; al terminar asigná head a la nueva cabeza. Fundamentá que sobrescribir el enlace sin haber guardado siguiente hace perder el resto del recorrido. No generes otra lista; size queda igual. En main exponé la lista vacía, la de un nodo y el caso 10 -> 20 -> 30 -> 40 -> null convertido en 40 -> 30 -> 20 -> 10 -> null. Sin colecciones; O(n) en tiempo y O(1) en espacio adicional. Incluí Javadoc con los casos. Reproducí el prompt entero al inicio y declará los ajustes auténticos al final.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 9. Invierte los enlaces in-place usando anterior, actual y siguiente.
 * <p>{@code 10 -> 20 -> 30 -> 40 -> null} se vuelve
 * {@code 40 -> 30 -> 20 -> 10 -> null}; lista vacía y un nodo no cambian. Guardar siguiente
 * antes de invertir actual.siguiente evita perder el resto. size no cambia; O(n) tiempo/O(1) espacio.</p>
 */
public class ListasEnlazadasSimples09 {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int d) { dato = d; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public ListasEnlazadasSimples09() { }
    private void agregar(int d) { Nodo n = new Nodo(d); if (head == null) head = n; else { Nodo a = head; while (a.siguiente != null) a = a.siguiente; a.siguiente = n; } size++; }
    /** Invierte los enlaces sin crear otra lista.
     */
    public void invertir() {
        Nodo anterior = null, actual = head;
        while (actual != null) {
            Nodo siguiente = actual.siguiente; // Guardar el resto antes de cambiar el enlace.
            actual.siguiente = anterior;
            anterior = actual; actual = siguiente;
        }
        head = anterior;
    }
    private String mostrar() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Demuestra inversión en listas vacía, un nodo y varios nodos.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        ListasEnlazadasSimples09 vacia = new ListasEnlazadasSimples09(); vacia.invertir(); System.out.println("Ejercicio 9 — vacía: " + vacia.mostrar());
        ListasEnlazadasSimples09 una = new ListasEnlazadasSimples09(); una.agregar(5); una.invertir(); System.out.println("Un nodo: " + una.mostrar());
        ListasEnlazadasSimples09 dos = new ListasEnlazadasSimples09(); dos.agregar(10); dos.agregar(20); dos.invertir(); System.out.println("Dos nodos: " + dos.mostrar());
        ListasEnlazadasSimples09 l = new ListasEnlazadasSimples09(); for (int v : new int[]{10, 20, 30, 40}) l.agregar(v);
        System.out.println("Antes: " + l.mostrar() + ", size=" + l.size); l.invertir(); System.out.println("Después: " + l.mostrar() + ", size=" + l.size);
    }
}
