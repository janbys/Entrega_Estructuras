/*
Prompt inicial utilizado:
En Java 21 creá la clase autónoma `ListasEnlazadasSimples06` con su propia lista simple de enteros y el método void eliminarEnPosicion(int posicion). Verificá primero que 0 <= posicion < size y ante un valor inválido lanzá IndexOutOfBoundsException descriptiva sin tocar nada. Si la posición es cero actualizá head; en otro caso avanzá hasta el nodo previo y conectá anterior.siguiente con eliminado.siguiente. Descontá size exactamente una vez. Describí cómo se ubica el anterior y se omite el nodo. En main eliminá al inicio, en el medio y al final, y ensayá -1 y size como índices inválidos demostrando que no provocan cambios. Sin colecciones; costo O(n) en tiempo y O(1) en espacio extra. Agregá Javadoc, este prompt entero como comentario inicial y la nota sincera de ajustes al final.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 6. Elimina un nodo por posición actualizando la referencia anterior.
 * <p>Con [10,20,30,40], eliminarEnPosicion(0) da [20,30,40]; eliminarEnPosicion(1)
 * da [20,40]; eliminarEnPosicion(1) da [20]. Índices inválidos no cambian lista ni size.
 * Tiempo O(n), espacio adicional O(1).</p>
 */
public class ListasEnlazadasSimples06 {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int d) { dato = d; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public ListasEnlazadasSimples06() { }
    private void agregar(int d) { Nodo n = new Nodo(d); if (head == null) head = n; else { Nodo a = head; while (a.siguiente != null) a = a.siguiente; a.siguiente = n; } size++; }
    /** Elimina el nodo de la posición.
     * @param posicion índice desde cero
     * @throws IndexOutOfBoundsException si no está en [0,size)
     */
    public void eliminarEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= size) throw new IndexOutOfBoundsException("Posición " + posicion + " inválida para size=" + size + ".");
        if (posicion == 0) head = head.siguiente;
        else { Nodo anterior = head; for (int i = 0; i < posicion - 1; i++) anterior = anterior.siguiente;
            Nodo eliminado = anterior.siguiente; anterior.siguiente = eliminado.siguiente;
        }
        size--;
    }
    private String mostrar() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Prueba posiciones válidas e inválidas.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        ListasEnlazadasSimples06 l = new ListasEnlazadasSimples06(); for (int v : new int[]{10, 20, 30, 40}) l.agregar(v);
        System.out.println("Ejercicio 6 — inicial: " + l.mostrar());
        for (int p : new int[]{0, 1, 1}) { l.eliminarEnPosicion(p); System.out.println("eliminarEnPosicion(" + p + "): " + l.mostrar() + ", size=" + l.size); }
        for (int p : new int[]{-1, l.size}) try { l.eliminarEnPosicion(p); } catch (IndexOutOfBoundsException e) { System.out.println("Rechazada: " + e.getMessage()); }
        System.out.println("Tras errores: " + l.mostrar() + ", size=" + l.size);
    }
}
