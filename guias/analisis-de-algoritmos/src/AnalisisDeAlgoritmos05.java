import java.util.Arrays;

/**
 * Ejercicio 5 — Contar ocurrencias.
 * <p>Consigna: Construí un prompt para OpenCode que solicite un algoritmo Java que cuente las apariciones de un valor en un vector, justifique por qué debe recorrerlo completo y analice su complejidad.</p>
 * <p>Estrategia: inspeccionar todas las posiciones e incrementar el contador en cada coincidencia. No alcanza con detenerse en la primera porque pueden existir más apariciones. Complejidad: tiempo O(n), espacio adicional O(1).</p>
 */
public class AnalisisDeAlgoritmos05 {

    /** Evita instancias; los algoritmos de esta clase son estáticos. */
    private AnalisisDeAlgoritmos05() { }

    /**
     * Cuenta todas las apariciones del objetivo en el vector.
     *
     * @param vector arreglo que se recorrerá
     * @param objetivo valor cuyas ocurrencias se cuentan
     * @return cantidad de apariciones; cero para un arreglo vacío
     * @throws IllegalArgumentException si el vector es nulo
     */
    public static int contar(int[] vector, int objetivo) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser nulo.");
        }

        int cantidad = 0;
        for (int valor : vector) {
            if (valor == objetivo) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /** Demuestra el conteo con repeticiones, valor ausente y vector vacío.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        int[] valores = {5, 2, 5, -1, 5, 8};
        System.out.println("Vector: " + Arrays.toString(valores));
        System.out.println("Ocurrencias de 5: " + contar(valores, 5));
        System.out.println("Ocurrencias de 3: " + contar(valores, 3));
        System.out.println("Ocurrencias en vector vacío: " + contar(new int[0], 5));
    }
}
