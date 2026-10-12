/*
Prompt inicial utilizado:
En Java 21 creá la clase autónoma `ListasEnlazadasSimples05` con su propia lista enlazada de enteros. Proveé boolean eliminar(int dato) que quite únicamente la primera coincidencia retornando true, o devuelva false si no está. Cubrí lista vacía, eliminación en head, en el medio, al final, con duplicados y con valor inexistente. Si coincide head avanzá head; si es otro nodo hacé que el anterior apunte al siguiente del borrado. Restá size solamente cuando se elimina. Aclarás que en Java no se libera el objeto a mano: al volverse inalcanzable, el Garbage Collector podrá recuperarlo si no subsisten referencias. En main ilustrá cada situación con valores fijos mostrando contenido y tamaño. Sin colecciones. Documentá el recorrido O(n) y O(1) de espacio extra. Pegá el prompt completo al principio bajo el rótulo pedido y al final consigná los ajustes verdaderos.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 5. Elimina por valor solo la primera coincidencia.
 * <p>En [10,20,10], eliminar(10) deja [20,10] y size 2; el nodo se desconecta y queda
 * elegible para Garbage Collector cuando no haya otras referencias. Vacía/ausente devuelve false.
 * Tiempo O(n), espacio adicional O(1).</p>
*/
public class ListasEnlazadasSimples05 {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int d) { dato = d; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public ListasEnlazadasSimples05() { }
    private void agregar(int d) { Nodo n = new Nodo(d); if (head == null) head = n; else { Nodo a = head; while (a.siguiente != null) a = a.siguiente; a.siguiente = n; } size++; }
    /** Quita la primera aparición del dato.
     * @param dato valor a quitar
     * @return true si fue eliminado
     */
    public boolean eliminar(int dato) {
        if (head == null) return false;
        if (head.dato == dato) { head = head.siguiente; size--; return true; }
        Nodo anterior = head;
        while (anterior.siguiente != null && anterior.siguiente.dato != dato) anterior = anterior.siguiente;
        if (anterior.siguiente == null) return false;
        anterior.siguiente = anterior.siguiente.siguiente; size--; return true;
    }
    private String mostrar() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Prueba cabeza, medio, cola, duplicado, ausente y vacía.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        ListasEnlazadasSimples05 l = new ListasEnlazadasSimples05();
        System.out.println("Ejercicio 5 — vacía: eliminar(1)=" + l.eliminar(1));
        for (int v : new int[]{10, 20, 30, 20, 40}) l.agregar(v);
        System.out.println("Inicial: " + l.mostrar() + ", size=" + l.size);
        for (int v : new int[]{10, 30, 40, 20, 99}) System.out.println("eliminar(" + v + ")=" + l.eliminar(v) + " → " + l.mostrar() + ", size=" + l.size);
    }
}
