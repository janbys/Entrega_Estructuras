/*
Prompt inicial utilizado:
Creá en Java 21 la clase autónoma `PilaColaConListaEnlazada08` que dé vuelta un `String` valiéndose de una pila enlazada propia de caracteres. Apilá cada símbolo de izquierda a derecha y desapilá para armar el resultado. Mantené mayúsculas, espacios y signos tal cual. Fundamentá que el orden LIFO provoca que el último carácter ingresado sea el primero en emerger. En main comprobá `"algoritmo"` → `"omtirogla"`, la cadena sin caracteres, una de un solo carácter y un texto con mayúsculas o espacios. Mantené el método de inversión separado del main y no uses `Stack`, colecciones ni arreglos para emular la pila. Registrá O(n) en tiempo y O(n) en espacio para longitud n además de los casos. Sumá Javadoc y colocá este prompt entero en el comentario inicial con la nota fiel de ajustes a continuación.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 8 — Invertir palabra usando LIFO.
 * <p>Apilar de izquierda a derecha y desapilar devuelve los caracteres al revés: algoritmo →
 * omtirogla. Cadena vacía retorna vacía; una letra no cambia. Tiempo O(n), espacio O(n).</p>
 */
public class PilaColaConListaEnlazada08 {
    private static final class Nodo { private final char dato; private final Nodo siguiente; private Nodo(char d, Nodo s) { dato = d; siguiente = s; } }
    private static final class PilaCaracteres {
        private Nodo top;
        private boolean isEmpty() { return top == null; }
        private void push(char c) { top = new Nodo(c, top); }
        private char pop() { if (isEmpty()) throw new IllegalStateException("La pila está vacía."); char c = top.dato; top = top.siguiente; return c; }
    }
    private PilaColaConListaEnlazada08() { }
    /** Invierte los caracteres usando una pila enlazada.
     * @param texto texto a invertir
     * @return caracteres en orden inverso
     * @throws IllegalArgumentException si texto es null
     */
    public static String invertir(String texto) {
        if (texto == null) throw new IllegalArgumentException("El texto no puede ser null.");
        PilaCaracteres pila = new PilaCaracteres(); for (int i = 0; i < texto.length(); i++) pila.push(texto.charAt(i));
        StringBuilder resultado = new StringBuilder(); while (!pila.isEmpty()) resultado.append(pila.pop()); return resultado.toString();
    }
    /** Demuestra palabra del enunciado y casos límite.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 8 — invertir con pila");
        for (String texto : new String[]{"algoritmo", "", "A", "Hola Mundo"}) System.out.println("\"" + texto + "\" → \"" + invertir(texto) + "\"");
    }
}
