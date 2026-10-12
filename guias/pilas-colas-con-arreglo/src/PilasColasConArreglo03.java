/*
Prompt inicial de OpenCode:
Desarrollá en Java 21 la clase autónoma `PilasColasConArreglo03`, que tome expresiones enteras por línea y controle solamente si los `(` y `)` están equilibrados. Trabajá con un `char[]` del largo de la expresión a modo de pila local, sin apoyarte en otras clases del práctico. Cada `(` se apila; cada `)`, si no queda ningún abierto, declara la expresión inválida, y si queda alguno lo desapila; al terminar, solo es válida cuando no sobró ningún cierre y la pila terminó sin restos. Omití el resto de los símbolos y no valides la gramática matemática. Armá un menú para ensayar expresiones y para salir, y exhibí `(5 + 3) * (2 + 1)` como caso válido frente a `(5 + 3)) * (2 + 1` como caso inválido, sumando vacío, anidamientos, cierre de más y apertura sin cerrar. Explicá en Javadoc el criterio, input/output, costo O(n) en tiempo con O(n) en memoria y ejemplos. Reproducí esta consigna íntegra al tope y al final declará si la retocaste o no.
*/
import java.util.Scanner;

/**
 * Ejercicio 3 — Validación de paréntesis balanceados.
 * <p>Una pila char[] guarda los abiertos; cada cierre desapila uno. Solo se evalúan '(' y ')', no
 * toda la gramática matemática. Ejemplos: "(5 + 3) * (2 + 1)" válido; "(5 + 3)) * (2 + 1" inválido.
 * La cadena vacía y "((x))" son válidas. Tiempo O(n), espacio O(n).</p>
 */
public class PilasColasConArreglo03 {
    private PilasColasConArreglo03() { }
    /** Determina si los paréntesis están balanceados.
     * @param expresion texto que se analizará
     * @return true si cada cierre tiene apertura previa y no quedan aperturas
     * @throws IllegalArgumentException si expresion es null
     */
    public static boolean estaBalanceada(String expresion) {
        if (expresion == null) throw new IllegalArgumentException("La expresión no puede ser null.");
        char[] pila = new char[expresion.length()];
        int top = -1;
        for (int i = 0; i < expresion.length(); i++) {
            char actual = expresion.charAt(i);
            if (actual == '(') pila[++top] = actual;
            else if (actual == ')') {
                if (top == -1) return false;
                top--; // El cierre actual consume la apertura más reciente (LIFO).
            }
        }
        return top == -1;
    }
    /** Menú para validar expresiones completas.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean salir = false;
            while (!salir) {
                System.out.println("\n1 validar expresión | 2 probar ejemplos | 0 salir");
                System.out.print("Opción: "); if (!sc.hasNextLine()) break;
                String linea = sc.nextLine().trim();
                switch (linea) {
                    case "1" -> { System.out.print("Expresión: "); if (!sc.hasNextLine()) return; mostrar(sc.nextLine()); }
                    case "2" -> {
                        mostrar("(5 + 3) * (2 + 1)"); mostrar("(5 + 3)) * (2 + 1");
                        mostrar(""); mostrar("((x + 1) * (y))"); mostrar(")x("); mostrar("(x + 1");
                    }
                    case "0" -> salir = true;
                    default -> System.out.println("Opción inexistente.");
                }
            }
        }
    }
    private static void mostrar(String expresion) { System.out.println('"' + expresion + "\" → " + (estaBalanceada(expresion) ? "válida" : "inválida")); }
}
// Prompt sin cambios.
