/*
Prompt inicial utilizado:
En Java 21 creá la clase autónoma `ListasEnlazadasSimples02` con Nodo y lista simple de enteros definidos por vos, sin colecciones. Agregá boolean buscar(int dato) que parta de head y siga los enlaces siguiente hasta hallar el valor o llegar a null. Fundamentá por qué no existe acceso directo por índice como en los arreglos y por qué la búsqueda resulta secuencial O(n) con O(1) de espacio extra. En main cargá valores fijos y probá el primer elemento, uno posterior, uno ausente y la lista vacía, imprimiendo cada resultado. Documentá con Javadoc el recorrido y los casos. Reproducí este prompt entero al inicio bajo “Prompt inicial utilizado:” y al final sumá “Ajustes realizados luego de la primera respuesta de OpenCode:” con “No hubo ajustes” o el detalle real.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 2. Búsqueda secuencial en lista enlazada propia.
 * <p>En {@code 10 -> 20 -> 30}, buscar 10 y 30 da true; buscar 8 o buscar en la
 * lista vacía da false. No hay índice de acceso directo: se siguen referencias desde head.
 * Tiempo O(n), espacio adicional O(1).</p>
 */
public class ListasEnlazadasSimples02 {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int dato) { this.dato = dato; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public ListasEnlazadasSimples02() { }
    private void agregar(int dato) { Nodo n = new Nodo(dato); if (head == null) head = n; else { Nodo a = head; while (a.siguiente != null) a = a.siguiente; a.siguiente = n; } size++; }
    /** Busca un valor recorriendo los enlaces desde head.
     * @param dato valor objetivo
     * @return true si se encuentra
     */
    public boolean buscar(int dato) { for (Nodo a = head; a != null; a = a.siguiente) if (a.dato == dato) return true; return false; }
    private String imprimir() { StringBuilder s = new StringBuilder(); for (Nodo a = head; a != null; a = a.siguiente) s.append(a.dato).append(" -> "); return s.append("null").toString(); }
    /** Ejecuta pruebas de búsqueda exitosas, ausentes y lista vacía.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        ListasEnlazadasSimples02 lista = new ListasEnlazadasSimples02(); lista.agregar(10); lista.agregar(20); lista.agregar(30);
        System.out.println("Ejercicio 2 — Lista: " + lista.imprimir() + ", size=" + lista.size);
        System.out.println("buscar(10): " + lista.buscar(10)); System.out.println("buscar(30): " + lista.buscar(30)); System.out.println("buscar(8): " + lista.buscar(8));
        System.out.println("buscar(10) en lista vacía: " + new ListasEnlazadasSimples02().buscar(10));
    }
}
