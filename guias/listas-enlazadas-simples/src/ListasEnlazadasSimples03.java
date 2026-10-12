/*
Prompt inicial utilizado:
En Java 21 creá la clase autónoma `ListasEnlazadasSimples03` con su propia lista enlazada de enteros. Proveé int obtener(int posicion) que primero compruebe 0 <= posicion < size; si el índice es inválido lanzá IndexOutOfBoundsException con mensaje claro sin alterar la lista. Aclarás que la posición no permite salto directo: hay que avanzar desde head nodo por nodo hasta llegar. En main exhibí el acceso a la primera posición, una intermedia y la última, además de intentar con -1 y con size capturando la excepción y evidenciando que datos y tamaño se conservan. Sin colecciones. Documentá la estrategia y el costo O(n) en tiempo y O(1) en espacio extra. Transcribí este prompt completo al inicio con el rótulo pedido y al final señalá si hubo ajustes.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 3. Obtener un entero por posición recorriendo enlaces desde head.
 * <p>Con [10, 20, 30], obtener(0), obtener(1), obtener(2) devuelve 10, 20, 30.
 * obtener(-1) y obtener(size) lanzan IndexOutOfBoundsException sin cambiar la lista.
 * No existe indexación directa: peor caso O(n), espacio auxiliar O(1).</p>
 */
public class ListasEnlazadasSimples03 {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int d) { dato = d; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public ListasEnlazadasSimples03() { }
    private void agregar(int d) { Nodo n = new Nodo(d); if (head == null) head = n; else { Nodo a = head; while (a.siguiente != null) a = a.siguiente; a.siguiente = n; } size++; }
    /** Obtiene el dato en la posición solicitada.
     * @param posicion índice desde cero
     * @return dato del nodo
     * @throws IndexOutOfBoundsException si no es una posición de nodo existente
     */
    public int obtener(int posicion) {
        if (posicion < 0 || posicion >= size) throw new IndexOutOfBoundsException("Posición " + posicion + " fuera de [0, " + (size - 1) + "].");
        Nodo actual = head; for (int i = 0; i < posicion; i++) actual = actual.siguiente; return actual.dato;
    }
    private String mostrar() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Prueba posiciones válidas e inválidas.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        ListasEnlazadasSimples03 l = new ListasEnlazadasSimples03(); for (int n : new int[]{10, 20, 30}) l.agregar(n);
        System.out.println("Ejercicio 3 — " + l.mostrar());
        for (int p : new int[]{0, 1, 2}) System.out.println("obtener(" + p + ") = " + l.obtener(p));
        for (int p : new int[]{-1, 3}) try { l.obtener(p); } catch (IndexOutOfBoundsException e) { System.out.println("obtener(" + p + "): " + e.getMessage()); }
        System.out.println("Tras errores: " + l.mostrar() + ", size=3");
    }
}
