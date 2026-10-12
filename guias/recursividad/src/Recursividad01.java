/* Prompt inicial utilizado: Creá una clase autónoma de Java 21 denominada `Recursividad01` que obtenga el factorial de un entero no negativo usando recursividad. Colocá el texto íntegro de este prompt como comentario delante del Javadoc de la clase. En dicho Javadoc incluí la consigna, el motivo por el cual el problema admite una solución recursiva, el caso base (si `n` vale 0 o 1 se retorna 1), el caso recursivo (`n` multiplicado por el factorial de `n - 1`) y los costos temporal O(n) y espacial O(n) debidos a la pila de llamadas. El método público ha de retornar `int`, llevar documentación de sus parámetros y de su valor de retorno, y lanzar un error claro frente a valores negativos. Mantené el cómputo fuera de `main`; verificá con 0, con 1 y con un número chico cuyo factorial entre en un `int`. Agregá comentarios que aclaren cómo se achica el problema y cómo se devuelven las llamadas, evitando ciclos y cualquier librería de factorial. Si alterás este prompt, dejá al cierre del archivo un comentario señalando qué modificaste y por qué. */

/**
 * Ejercicio 1 — Factorial.
 * <p>Consigna: implementar una función recursiva que calcule el factorial de un entero no negativo.</p>
 * <p>El problema es recursivo porque el factorial de n se define usando el factorial de n - 1. Los casos base n == 0 y n == 1 devuelven 1; para n mayor, el caso recursivo devuelve n multiplicado por factorial(n - 1).</p>
 * <p>Complejidad: tiempo O(n) y espacio O(n) debido a la pila de llamadas. El rango de int limita los resultados representables (12! es el mayor factorial positivo que cabe en int); la profundidad de pila también limita entradas grandes.</p>
 */
public class Recursividad01 {

    private Recursividad01() { }

    /**
     * Calcula el factorial de un entero no negativo de forma recursiva.
     *
     * @param n entero no negativo cuyo factorial se calculará
     * @return el factorial de n
     * @throws IllegalArgumentException si n es negativo
     */
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para enteros negativos en este ejercicio.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }

        // Cada llamada reduce n hasta llegar a 1; al retornar se combinan los productos pendientes.
        return n * factorial(n - 1);
    }

    /**
     * Muestra ejemplos de factorial dentro del rango de int y el rechazo de negativos.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 1 — Factorial");
        System.out.println("0! = " + factorial(0));
        System.out.println("1! = " + factorial(1));
        System.out.println("5! = " + factorial(5));
        try {
            factorial(-1);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
