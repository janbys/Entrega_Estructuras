/*
Prompt inicial utilizado:
Creá en Java 21 la clase autónoma `PilaColaConListaEnlazada01` que ofrezca una pila de enteros apoyada en nodos enlazados de implementación propia. Cada nodo guarda un int junto con la referencia al nodo siguiente. Tomá `head` como cima: `push` genera un nodo que apunta a la cabeza anterior y después pasa a ser `head`; `pop` retorna el valor y desplaza `head` al sucesor. Fundamentá por qué push y pop quedan en O(1) y por qué la búsqueda y la impresión, al recorrer los enlaces, quedan en O(n). Ofrecé los métodos `push`, `pop`, `peek`, `isEmpty`, `contains` e `imprimir`. Si la pila está vacía, pop y peek deben arrojar `IllegalStateException` con mensaje claro. No recurras a colecciones ni a otras clases del práctico. En `main` mostrá cómo se apilan 10, 20 y 30, cómo el tope consultado es 30, cómo se busca un valor presente y otro ausente, cómo se imprime en sentido tope→fondo, cómo se desapila respetando LIFO y cómo se capturan los errores de pop/peek en vacío. Añadí Javadoc con invariantes. Reproducí este prompt entero en el comentario inicial bajo “Prompt inicial utilizado:” y a continuación agregá “Ajustes realizados luego de la primera respuesta de OpenCode:” con los cambios efectivos o “No hubo ajustes.”
Implementá en Java 21 una clase independiente `PilaColaConListaEnlazada01` con una pila de enteros basada en nodos enlazados propios. Cada nodo contiene un int y una referencia al siguiente. Usa `head` como tope: `push` crea el nodo apuntando a la cabeza previa y luego actualiza `head`; `pop` devuelve el dato y avanza `head`. Explicá que así push y pop son O(1), mientras buscar e imprimir recorren la lista y son O(n). Incluí `push`, `pop`, `peek`, `isEmpty`, `contains` e `imprimir`. Sobre una pila vacía, pop y peek lanzan `IllegalStateException` clara. No uses colecciones ni otra clase del práctico. En `main` demuestra apilar 10,20,30, consultar tope 30, buscar existente/ausente, imprimir orden tope→fondo, desapilar en orden LIFO y capturar pop/peek vacío. Documentá Javadoc e invariantes. Copiá este prompt completo en el comentario inicial bajo “Prompt inicial utilizado:” y después incluí “Ajustes realizados luego de la primera respuesta de OpenCode:” con los cambios reales o “No hubo ajustes.”
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 1 — Pila enlazada de enteros.
 * <p>La cabeza {@code head} es el tope; por eso push y pop modifican una sola referencia en O(1).
 * Con 10,20,30 apilados, peek devuelve 30 y los pop producen 30,20,10. Buscar e imprimir O(n);
 * espacio total O(n). Una consulta/desapilado vacío lanza {@link IllegalStateException}.</p>
 */
public class PilaColaConListaEnlazada01 {
    private static final class Nodo { private final int dato; private final Nodo siguiente; Nodo(int d, Nodo s) { dato = d; siguiente = s; } }
    private Nodo head;
    private int size;

    /** Construye una pila vacía. */
    public PilaColaConListaEnlazada01() { }

    /** Apila un valor en la cabeza.
     * @param dato valor a apilar
     */
    public void push(int dato) { head = new Nodo(dato, head); size++; }
    /** Desapila el tope.
     * @return dato retirado
     * @throws IllegalStateException si la pila está vacía
     */
    public int pop() { validarNoVacia(); int dato = head.dato; head = head.siguiente; size--; return dato; }
    /** Consulta el tope sin retirarlo.
     * @return dato del tope
     * @throws IllegalStateException si está vacía
     */
    public int peek() { validarNoVacia(); return head.dato; }
    /** Indica si está vacía.
     * @return true si no hay nodos
     */
    public boolean isEmpty() { return head == null; }
    /** Busca un entero mediante recorrido secuencial.
     * @param dato objetivo
     * @return true si aparece
     */
    public boolean contains(int dato) { for (Nodo n = head; n != null; n = n.siguiente) if (n.dato == dato) return true; return false; }
    /** Imprime desde el tope hacia el fondo.
     * @return contenido de la pila
     */
    public String imprimir() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Devuelve cantidad de elementos.
     * @return size actual
     */
    public int size() { return size; }
    private void validarNoVacia() { if (isEmpty()) throw new IllegalStateException("La pila está vacía."); }

    /** Demuestra operaciones LIFO, búsqueda y errores de pila vacía.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 1 — pila enlazada");
        PilaColaConListaEnlazada01 p = new PilaColaConListaEnlazada01();
        for (int v : new int[]{10, 20, 30}) p.push(v);
        System.out.println("Contenido tope→fondo: " + p.imprimir());
        System.out.println("peek=" + p.peek() + ", contiene 20=" + p.contains(20) + ", contiene 99=" + p.contains(99));
        System.out.println("pop: " + p.pop() + ", " + p.pop() + ", " + p.pop() + "; vacía=" + p.isEmpty());
        try { p.pop(); } catch (IllegalStateException e) { System.out.println("pop vacío: " + e.getMessage()); }
        try { p.peek(); } catch (IllegalStateException e) { System.out.println("peek vacío: " + e.getMessage()); }
    }
}
