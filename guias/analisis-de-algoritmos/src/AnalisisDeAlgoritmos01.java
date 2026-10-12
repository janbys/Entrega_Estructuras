import java.util.Arrays;

/**
 * Ejercicio 1 — Encontrar el mínimo de un vector.
 * <p>Consigna: Construí un prompt para OpenCode que solicite la implementación en Java de un algoritmo que encuentre el valor mínimo de un vector de números enteros. Antes de pedir el código, el prompt debe explicar la estrategia más adecuada, justificarla e indicar las complejidades temporal y espacial esperadas. También debe solicitar código comentado y explicar por qué no es necesario ordenar el vector.</p>
 * <p>Estrategia: recorrer el vector una sola vez y conservar el mínimo visto. Ordenar sería trabajo adicional innecesario: basta comparar cada valor con el mínimo actual.</p>
 * <p>Complejidad: tiempo O(n), espacio adicional O(1).</p>
 */
public class AnalisisDeAlgoritmos01 {

    /** Evita instancias; los algoritmos de esta clase son estáticos. */
    private AnalisisDeAlgoritmos01() { }

    /**
     * Devuelve el menor valor de un vector mediante un recorrido lineal.
     *
     * @param vector arreglo no vacío de enteros
     * @return el menor entero del arreglo
     * @throws IllegalArgumentException si el vector es nulo o vacío
     */
    public static int encontrarMinimo(int[] vector) {
        if (vector == null || vector.length == 0) {
            throw new IllegalArgumentException("El vector debe contener al menos un elemento.");
        }

        int minimo = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < minimo) {
                minimo = vector[i];
            }
        }
        return minimo;
    }

    /** Ejecuta ejemplos de uso, incluido el caso de vector vacío.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        int[] valores = {8, -3, 12, 0, -7, 4};
        System.out.println("Vector: " + Arrays.toString(valores));
        System.out.println("Mínimo: " + encontrarMinimo(valores));

        try {
            encontrarMinimo(new int[0]);
        } catch (IllegalArgumentException error) {
            System.out.println("Caso vacío: " + error.getMessage());
        }
    }
}
