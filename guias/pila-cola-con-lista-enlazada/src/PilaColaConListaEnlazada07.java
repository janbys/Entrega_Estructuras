/*
Prompt inicial utilizado:
Creá en Java 21 la clase autónoma `PilaColaConListaEnlazada07` que determine si los paréntesis `(` y `)` están equilibrados apoyándose en una pila enlazada propia de caracteres. Ante cada apertura, apilá; ante cada cierre, si la pila no tiene elementos devolvé falso y en caso contrario aplicá pop. Al terminar, considerá válida la cadena solamente cuando la pila terminó vacía. Desestimá los caracteres que no sean paréntesis y no pretendas validar la gramática entera. Fundamentá que el esquema LIFO asocia cada cierre con la apertura pendiente más reciente. En main ensayá `(2 + 3) * (5 - 1)` y `((a + b) * c)` como válidas; `(2 + 3` y `())(` como inválidas; sumá la expresión vacía y otra con anidamiento. Para n caracteres dejá registrado O(n) en tiempo y O(n) en espacio. No emplees arreglos ni colecciones a modo de pila. Añadí Javadoc y un comentario inicial que traiga el prompt entero con la nota auténtica de ajustes.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 7 — Verificador de paréntesis.
 * <p>Cada '(' se apila; ')' consume la apertura más reciente. Válidos: (2 + 3) * (5 - 1),
 * ((a + b) * c), vacío y (x+(y*z)); inválidos: (2 + 3 y ())(. Valida solo paréntesis.
 * Para n caracteres: O(n) tiempo y O(n) espacio en el peor caso.</p>
 */
public class PilaColaConListaEnlazada07 {
    private static final class Nodo { private final char dato; private final Nodo siguiente; private Nodo(char d, Nodo s) { dato = d; siguiente = s; } }
    private static final class PilaCaracteres {
        private Nodo top;
        private boolean isEmpty() { return top == null; }
        private void push(char c) { top = new Nodo(c, top); }
        private char pop() { if (isEmpty()) throw new IllegalStateException("Pila de aperturas vacía."); char c = top.dato; top = top.siguiente; return c; }
    }
    private PilaColaConListaEnlazada07() { }
    /** Comprueba el balance de paréntesis, ignorando los demás caracteres.
     * @param expresion texto analizado
     * @return true si no hay cierres sobrantes y quedan cero aperturas
     * @throws IllegalArgumentException si la referencia es null
     */
    public static boolean estaBalanceada(String expresion) {
        if (expresion == null) throw new IllegalArgumentException("La expresión no puede ser null.");
        PilaCaracteres aperturas = new PilaCaracteres();
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (c == '(') aperturas.push(c);
            else if (c == ')') { if (aperturas.isEmpty()) return false; aperturas.pop(); }
        }
        return aperturas.isEmpty();
    }
    /** Ejecuta los casos de la consigna y límites.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 7 — paréntesis balanceados");
        for (String e : new String[]{"(2 + 3) * (5 - 1)", "((a + b) * c)", "(2 + 3", "())(", "", "(x+(y*z))"})
            System.out.println("\"" + e + "\" → " + (estaBalanceada(e) ? "válida" : "inválida"));
    }
}
