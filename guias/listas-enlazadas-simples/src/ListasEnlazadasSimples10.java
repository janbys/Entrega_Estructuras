/*
Prompt inicial utilizado:
En Java 21 creá la clase autónoma `ListasEnlazadasSimples10` que contenga Nodo<T> y ListaEnlazada<T>, sin recurrir a colecciones. Reuní todas las operaciones de la guía: inserción al inicio y al final, impresión, consulta de vacía y tamaño, búsqueda, obtención por posición, inserción en posición, borrado de la primera coincidencia, borrado por posición, modificación, conteo de ocurrencias e inversión. Conservá head, enlaces y size; chequeá las posiciones y lanzá IndexOutOfBoundsException antes de mutar. Cotejá datos mediante Objects.equals. Aclarás que el tipo del dato y del nodo se abstrae a T, aunque recorrido e invariantes siguen iguales sin importar el tipo. En main presentá instancias independientes de Integer, String y Alumno (record) con salidas pautadas, sin combinar tipos. Sumá Javadoc con errores, casos y complejidades. Transcribí este prompt completo al inicio y asentá los ajustes reales al final.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
import java.util.Objects;

/**
 * Ejercicio 10. Generalización de la lista enlazada simple.
 * <p>ListaEnlazada&lt;T&gt; conserva head, enlaces y size, pero Nodo&lt;T&gt; admite distintos tipos.
 * En main se prueban Integer, String y Alumno. Las operaciones de posición recorren secuencialmente;
 * igualdad usa Objects.equals. Tiempo de recorrido O(n), inversión O(n) y espacio adicional O(1).</p>
 */
public class ListasEnlazadasSimples10 {
    /** Nodo genérico con valor y enlace al siguiente.
     * @param <T> tipo guardado
     */
    public static final class Nodo<T> {
        private T dato; private Nodo<T> siguiente;
        private Nodo(T dato) { this.dato = dato; }
    }
    /** Lista enlazada simple genérica, implementada únicamente con nodos.
     * @param <T> tipo de elementos
     */
    public static final class ListaEnlazada<T> {
        private Nodo<T> head; private int size;
        /** Construye una lista vacía del tipo T. */
        public ListaEnlazada() { }
        /** Inserta un valor al inicio.
         * @param dato dato que se agrega
         */
        public void insertarAlInicio(T dato) { Nodo<T> n = new Nodo<>(dato); n.siguiente = head; head = n; size++; }
        /** Inserta un valor al final.
         * @param dato dato que se agrega
         */
        public void insertarAlFinal(T dato) { Nodo<T> n = new Nodo<>(dato); if (head == null) head = n; else { Nodo<T> a = head; while (a.siguiente != null) a = a.siguiente; a.siguiente = n; } size++; }
        /** Indica si está vacía.
         * @return true si head es null
         */
        public boolean estaVacia() { return head == null; }
        /** Devuelve el número de nodos.
         * @return tamaño
         */
        public int getSize() { return size; }
        /** Busca por igualdad de objetos.
         * @param dato valor buscado
         * @return true si se encuentra
         */
        public boolean buscar(T dato) { for (Nodo<T> a = head; a != null; a = a.siguiente) if (Objects.equals(a.dato, dato)) return true; return false; }
        /** Obtiene el valor de una posición recorriendo desde head.
         * @param posicion índice desde cero
         * @return dato en posición
         * @throws IndexOutOfBoundsException si el índice no existe
         */
        public T obtener(int posicion) { validarNodo(posicion); Nodo<T> a = nodoEn(posicion); return a.dato; }
        /** Inserta antes de una posición válida de 0 a size inclusive.
         * @param dato dato nuevo
         * @param posicion índice de inserción
         * @throws IndexOutOfBoundsException si está fuera de [0,size]
         */
        public void insertarEnPosicion(T dato, int posicion) {
            if (posicion < 0 || posicion > size) throw new IndexOutOfBoundsException("Posición " + posicion + " inválida para size=" + size + ".");
            if (posicion == 0) insertarAlInicio(dato);
            else { Nodo<T> previo = nodoEn(posicion - 1); Nodo<T> nuevo = new Nodo<>(dato); nuevo.siguiente = previo.siguiente; previo.siguiente = nuevo; size++; }
        }
        /** Elimina la primera coincidencia.
         * @param dato valor a eliminar
         * @return true si se quitó un nodo
         */
        public boolean eliminar(T dato) {
            if (head == null) return false;
            if (Objects.equals(head.dato, dato)) { head = head.siguiente; size--; return true; }
            Nodo<T> previo = head; while (previo.siguiente != null && !Objects.equals(previo.siguiente.dato, dato)) previo = previo.siguiente;
            if (previo.siguiente == null) return false; previo.siguiente = previo.siguiente.siguiente; size--; return true;
        }
        /** Elimina una posición existente.
         * @param posicion índice desde cero
         * @throws IndexOutOfBoundsException si no existe
         */
        public void eliminarEnPosicion(int posicion) {
            validarNodo(posicion);
            if (posicion == 0) head = head.siguiente;
            else { Nodo<T> previo = nodoEn(posicion - 1); previo.siguiente = previo.siguiente.siguiente; }
            size--;
        }
        /** Cambia solo el dato guardado en la posición.
         * @param posicion índice desde cero
         * @param nuevoDato nuevo valor
         * @throws IndexOutOfBoundsException si no existe
         */
        public void modificar(int posicion, T nuevoDato) { validarNodo(posicion); nodoEn(posicion).dato = nuevoDato; }
        /** Cuenta todas las coincidencias.
         * @param dato valor a contar
         * @return cantidad de nodos iguales
         */
        public int contarOcurrencias(T dato) { int total = 0; for (Nodo<T> a = head; a != null; a = a.siguiente) if (Objects.equals(a.dato, dato)) total++; return total; }
        /** Invierte enlaces in-place sin modificar el tamaño.
         */
        public void invertir() { Nodo<T> anterior = null, actual = head; while (actual != null) { Nodo<T> siguiente = actual.siguiente; actual.siguiente = anterior; anterior = actual; actual = siguiente; } head = anterior; }
        /** Devuelve la lista en formato de flechas.
         * @return nodos desde head hasta null
         */
        public String imprimir() { StringBuilder s = new StringBuilder(); for (Nodo<T> a = head; a != null; a = a.siguiente) s.append(a.dato).append(" -> "); return s.append("null").toString(); }
        private void validarNodo(int posicion) { if (posicion < 0 || posicion >= size) throw new IndexOutOfBoundsException("Posición " + posicion + " inválida para size=" + size + "."); }
        private Nodo<T> nodoEn(int posicion) { Nodo<T> a = head; for (int i = 0; i < posicion; i++) a = a.siguiente; return a; }
    }
    /** Alumno usado para demostrar el tipo genérico.
     * @param legajo identificador
     * @param nombre nombre
     */
    public record Alumno(int legajo, String nombre) { }
    private ListasEnlazadasSimples10() { }

    /** Demuestra listas independientes de Integer, String y Alumno.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 10 — Lista genérica");
        ListaEnlazada<Integer> enteros = new ListaEnlazada<>(); enteros.insertarAlFinal(10); enteros.insertarAlFinal(20); enteros.insertarAlFinal(30);
        System.out.println("Integer: " + enteros.imprimir() + ", buscar(20)=" + enteros.buscar(20) + ", contar(10)=" + enteros.contarOcurrencias(10));
        enteros.invertir(); System.out.println("Invertida: " + enteros.imprimir() + ", obtener(0)=" + enteros.obtener(0));
        ListaEnlazada<String> textos = new ListaEnlazada<>(); textos.insertarAlInicio("sur"); textos.insertarAlFinal("norte"); textos.insertarEnPosicion("centro", 1);
        System.out.println("String: " + textos.imprimir() + ", buscar(centro)=" + textos.buscar("centro"));
        ListaEnlazada<Alumno> alumnos = new ListaEnlazada<>(); Alumno ana = new Alumno(1, "Ana"); alumnos.insertarAlFinal(ana); alumnos.insertarAlFinal(new Alumno(2, "Luis"));
        System.out.println("Alumno: " + alumnos.imprimir() + ", buscar Ana por valor=" + alumnos.buscar(new Alumno(1, "Ana")));
        alumnos.modificar(1, new Alumno(2, "Lucía")); alumnos.eliminarEnPosicion(0);
        System.out.println("Tras modificar y eliminar: " + alumnos.imprimir() + ", size=" + alumnos.getSize());
        System.out.println("Eliminar dato inexistente: " + alumnos.eliminar(new Alumno(9, "Nadie")));
    }
}
