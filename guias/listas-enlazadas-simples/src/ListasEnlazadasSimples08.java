/*
Prompt inicial utilizado:
En Java 21 creá la clase autónoma `ListasEnlazadasSimples08` con su propia lista simple de enteros y el método int contarOcurrencias(int dato). Atravesá desde head hasta null acumulando cada coincidencia; no te detengas en la primera porque se pide el total. En main trabajá con la secuencia 10 -> 20 -> 10 -> 30 -> 10 y verificá que contar 10 retorne 3; sumá además un valor ausente y la lista vacía. Sin colecciones. Detallá en el Javadoc el recorrido total, los casos y el costo O(n) en tiempo con O(1) de espacio extra. Copiá este prompt sin recortes al comienzo y añadí al final la nota veraz de ajustes.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 8. Cuenta todas las apariciones de un entero.
 * <p>En {@code 10 -> 20 -> 10 -> 30 -> 10 -> null}, contar 10 devuelve 3; contar 99 y
 * contar en lista vacía devuelven 0. No se detiene en la primera coincidencia. Tiempo O(n),
 * espacio adicional O(1).</p>
 */
public class ListasEnlazadasSimples08 {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int d) { dato = d; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public ListasEnlazadasSimples08() { }
    private void agregar(int d) { Nodo n = new Nodo(d); if (head == null) head = n; else { Nodo a = head; while (a.siguiente != null) a = a.siguiente; a.siguiente = n; } size++; }
    /** Cuenta todas las coincidencias recorriendo la lista completa.
     * @param dato valor que se contará
     * @return número de apariciones
     */
    public int contarOcurrencias(int dato) { int cuenta = 0; for (Nodo n = head; n != null; n = n.siguiente) if (n.dato == dato) cuenta++; return cuenta; }
    private String mostrar() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Ejecuta conteo para repetidos, ausentes y lista vacía.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        ListasEnlazadasSimples08 l = new ListasEnlazadasSimples08(); for (int v : new int[]{10, 20, 10, 30, 10}) l.agregar(v);
        System.out.println("Ejercicio 8 — " + l.mostrar() + ", size=" + l.size); System.out.println("contarOcurrencias(10) = " + l.contarOcurrencias(10));
        System.out.println("contarOcurrencias(99) = " + l.contarOcurrencias(99));
        System.out.println("En lista vacía: " + new ListasEnlazadasSimples08().contarOcurrencias(10));
    }
}
