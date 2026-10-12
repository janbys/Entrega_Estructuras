/* Prompt inicial utilizado: Creá una clase individual de Java 21 denominada `Recursividad05` que muestre en forma recursiva los números desde un entero no negativo `n` hasta 0, ambos incluidos. Anteponé a modo de comentario el texto entero de este prompt al Javadoc de la clase. La operación solo exhibe la secuencia y no requiere retornar nada. Adoptá 0 como caso base; mostrá el valor vigente y luego invocá recursivamente con `n - 1`. Invalidá los valores negativos para no perder el caso base. En el Javadoc registrá la consigna, los casos base y recursivo y los costos temporal O(n) y espacial O(n) por la pila. En `main` ejercitá 0 y un positivo chico. Aclarás en un comentario que sustituir `n - 1` por `n + 1` aparta la ejecución del caso base; esa variante no debe correrse porque no finaliza con normalidad y puede desbordar la pila. Si reformulás este prompt, sumá al final del archivo un comentario que consigne el retoque y su justificación. */

/**
 * Ejercicio 5 — Conteo regresivo.
 * <p>Consigna: imprimir recursivamente los valores desde n hasta 0, inclusive. Es un procedimiento de impresión, por lo que no devuelve un resultado.</p>
 * <p>El caso base es 0. En el caso recursivo se imprime el valor actual y se llama con n - 1, acercándose al caso base. Usar n + 1 en su lugar alejaría la llamada del caso base y causaría recursión sin terminación normal; esa variante no se ejecuta.</p>
 * <p>Complejidad para n >= 0: tiempo O(n) y espacio O(n) por la pila de llamadas.</p>
 */
public class Recursividad05 {

    private Recursividad05() { }

    /**
     * Imprime n, n - 1, ... hasta 0 mediante recursión.
     *
     * @param n valor inicial no negativo
     * @throws IllegalArgumentException si n es negativo
     */
    public static void imprimirHastaCero(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El conteo inicial debe ser no negativo.");
        }

        System.out.println(n);
        if (n == 0) {
            return;
        }

        // n - 1 avanza hacia el caso base; n + 1 se alejaría de él y no se utiliza.
        imprimirHastaCero(n - 1);
    }

    /**
     * Ejecuta ejemplos de conteo desde cero y desde un valor positivo pequeño.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 5 — Conteo regresivo desde 0:");
        imprimirHastaCero(0);
        System.out.println("Conteo regresivo desde 4:");
        imprimirHastaCero(4);
        try {
            imprimirHastaCero(-1);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
