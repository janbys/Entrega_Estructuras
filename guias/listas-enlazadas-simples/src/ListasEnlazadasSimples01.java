/*
Prompt inicial utilizado:
En Java 21 creá la clase autónoma `ListasEnlazadasSimples01` que modele su propia lista de enteros sin apoyarte en colecciones. Definí un Nodo con dato y enlace al siguiente; mantené head hacia el primer nodo o null y size con la cantidad de nodos. Añadí los métodos insertarAlInicio, insertarAlFinal, imprimir, estaVacia y getSize. Detallá la actualización de head, enlaces y size; la inserción inicial es O(1) mientras que la final debe recorrer hasta el último y resulta O(n). En main empleá valores fijos para exhibir la lista vacía, inserciones por ambos extremos, su contenido y tamaño. Sumá Javadoc y comentarios sobre las referencias. Pegá este prompt completo al inicio del fuente con el título “Prompt inicial utilizado:” y cerrá con “Ajustes realizados luego de la primera respuesta de OpenCode:” aclarando si no hubo cambios o cuáles fueron.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 1. Lista enlazada simple de enteros creada desde cero.
 * <p>Ejemplo: lista vacía; insertar inicio 20, final 30, inicio 10 produce
 * {@code 10 -> 20 -> 30 -> null}, tamaño 3. Cada nodo guarda un entero y su enlace;
 * head señala el primero. Inserción inicial O(1), final O(n), consultas O(1), memoria O(n).</p>
 */
public class ListasEnlazadasSimples01 {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int dato) { this.dato = dato; } }
    private Nodo head;
    private int size;

    /** Construye una lista inicialmente vacía.
     */
    public ListasEnlazadasSimples01() { }

    /** Inserta al inicio.
     * @param dato valor a agregar
     */
    public void insertarAlInicio(int dato) { Nodo nuevo = new Nodo(dato); nuevo.siguiente = head; head = nuevo; size++; }
    /** Inserta al final.
     * @param dato valor a agregar
     */
    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) head = nuevo;
        else { Nodo actual = head; while (actual.siguiente != null) actual = actual.siguiente; actual.siguiente = nuevo; }
        size++;
    }
    /** Imprime todos los nodos desde head.
     */
    public void imprimir() {
        System.out.println(representacion());
    }
    private String representacion() {
        StringBuilder texto = new StringBuilder(); Nodo actual = head;
        while (actual != null) { texto.append(actual.dato).append(" -> "); actual = actual.siguiente; }
        return texto.append("null").toString();
    }
    /** Indica si la lista no tiene nodos.
     * @return true si head es null
     */
    public boolean estaVacia() { return head == null; }
    /** Devuelve el número de nodos almacenados.
     * @return cantidad actual
     */
    public int getSize() { return size; }

    /** Demuestra inserción, impresión y tamaño con datos deterministas.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        ListasEnlazadasSimples01 lista = new ListasEnlazadasSimples01();
        System.out.println("Ejercicio 1 — Lista desde cero");
        System.out.print("Inicial: "); lista.imprimir(); System.out.println("vacía=" + lista.estaVacia() + ", size=" + lista.getSize());
        lista.insertarAlInicio(20); lista.insertarAlFinal(30); lista.insertarAlInicio(10);
        System.out.print("Tras insertar: "); lista.imprimir(); System.out.println("vacía=" + lista.estaVacia() + ", size=" + lista.getSize());
    }
}
