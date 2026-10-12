/*
Prompt inicial utilizado:
En Java 21 creá la clase autónoma `ListasEnlazadasSimples07` con su propia lista enlazada de enteros y el método modificar(int posicion, int nuevoDato). Controlá que 0 <= posicion < size antes de recorrer y si no se cumple lanzá IndexOutOfBoundsException dejando la lista intacta. Avanzá desde head hasta el nodo buscado, reemplazá solamente su dato y preservá head, siguiente y size. Diferenciá entre cambiar el dato y cambiar la referencia al siguiente. En main presentá una modificación válida y los intentos con -1 y con size, exponiendo el estado previo y posterior. Sin colecciones; O(n) temporal y O(1) espacial adicional. Documentá con Javadoc; colocá este prompt textual al inicio y anotá los ajustes reales al cierre.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 7. Modifica el dato del nodo sin cambiar sus enlaces.
 * <p>Con [10,20,30], modificar(1,25) produce [10,25,30] y mantiene size=3. La validación
 * precede al recorrido; índices inválidos no alteran lista. Tiempo O(n), espacio adicional O(1).</p>
 */
public class ListasEnlazadasSimples07 {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int d) { dato = d; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public ListasEnlazadasSimples07() { }
    private void agregar(int d) { Nodo n = new Nodo(d); if (head == null) head = n; else { Nodo a = head; while (a.siguiente != null) a = a.siguiente; a.siguiente = n; } size++; }
    /** Reemplaza solo el dato almacenado en la posición.
     * @param posicion índice desde cero
     * @param nuevoDato valor nuevo
     * @throws IndexOutOfBoundsException si la posición no existe
     */
    public void modificar(int posicion, int nuevoDato) {
        if (posicion < 0 || posicion >= size) throw new IndexOutOfBoundsException("Posición " + posicion + " inválida para size=" + size + ".");
        Nodo actual = head; for (int i = 0; i < posicion; i++) actual = actual.siguiente;
        actual.dato = nuevoDato; // Cambia el contenido, no la referencia al nodo siguiente.
    }
    private String mostrar() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Demuestra una modificación válida y el rechazo de índices inválidos.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        ListasEnlazadasSimples07 l = new ListasEnlazadasSimples07(); for (int v : new int[]{10, 20, 30}) l.agregar(v);
        System.out.println("Ejercicio 7 — antes: " + l.mostrar() + ", size=" + l.size); l.modificar(1, 25);
        System.out.println("modificar(1,25): " + l.mostrar() + ", size=" + l.size);
        for (int p : new int[]{-1, l.size}) try { l.modificar(p, 99); } catch (IndexOutOfBoundsException e) { System.out.println("Rechazada: " + e.getMessage()); }
        System.out.println("Tras errores: " + l.mostrar() + ", size=" + l.size);
    }
}
