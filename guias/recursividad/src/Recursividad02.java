/* Prompt inicial utilizado: Creá en Java 21 una clase autocontenida de nombre `Recursividad02` que acumule de forma recursiva los enteros comprendidos entre `n` y 1. Poné este prompt completo como comentario previo al Javadoc de la clase. En el Javadoc describí la consigna, la razón por la que `suma(n)` equivale a `n + suma(n - 1)`, el caso base `n == 0` con retorno 0 y los costos temporal O(n) y espacial O(n) originados en la pila. El método público tiene que retornar `int`, contar con documentación de parámetros y de resultado, y rechazar con un error claro las entradas negativas. Mantené un `main` aparte que ejercite 0, 1 y un positivo chico. Detallá con comentarios de qué modo cada invocación achica el problema y de qué forma se unen los parciales; no resuelvas la suma con ciclos. Si modificás este prompt, añadí al final del archivo un comentario que registre el cambio y su razón. */

/**
 * Ejercicio 2 — Suma de los primeros N números.
 * <p>Consigna: sumar recursivamente los enteros desde n hasta 1.</p>
 * <p>El caso base es n == 0, que devuelve 0. Para n positivo, suma(n) es n + suma(n - 1): cada llamada reduce n y, al regresar, agrega su valor a la suma parcial.</p>
 * <p>Complejidad: tiempo O(n) y espacio O(n) por la pila de llamadas. El resultado debe caber en int y una entrada grande puede exceder la profundidad disponible.</p>
 */
public class Recursividad02 {

    private Recursividad02() { }

    /**
     * Suma todos los enteros desde n hasta 1 mediante recursión.
     *
     * @param n límite superior no negativo
     * @return suma de los enteros desde n hasta 1, o 0 si n es 0
     * @throws IllegalArgumentException si n es negativo
     */
    public static int sumarHastaUno(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El límite debe ser un entero no negativo.");
        }
        if (n == 0) {
            return 0;
        }

        // La suma parcial se completa al retornar desde sumaHastaUno(n - 1).
        return n + sumarHastaUno(n - 1);
    }

    /**
     * Muestra ejemplos de suma y el rechazo de un valor negativo.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 2 — Suma de los primeros N números");
        System.out.println("Suma hasta 0: " + sumarHastaUno(0));
        System.out.println("Suma hasta 1: " + sumarHastaUno(1));
        System.out.println("Suma hasta 5: " + sumarHastaUno(5));
        try {
            sumarHastaUno(-2);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
