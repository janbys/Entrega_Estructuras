import java.util.Arrays;

/**
 * Ejercicio 10 — Ordenamiento burbuja.
 * <p>Consigna: Construí un prompt para OpenCode que solicite Bubble Sort en Java, explique por qué es adecuado principalmente para fines didácticos o conjuntos pequeños y contabilice comparaciones e intercambios.</p>
 * <p>Estrategia: comparar elementos adyacentes e intercambiarlos cuando están en orden incorrecto. La finalización anticipada detiene el algoritmo tras una pasada sin intercambios. Complejidad: mejor caso O(n), promedio y peor caso O(n²), espacio adicional O(1). Es didáctico, pero para datos grandes resulta ineficiente frente a algoritmos O(n log n).</p>
 */
public class AnalisisDeAlgoritmos10 {

    /** Contadores de las operaciones principales del ordenamiento.
     * @param comparaciones cantidad de comparaciones entre elementos adyacentes
     * @param intercambios cantidad de intercambios efectuados
     */
    public record Estadisticas(long comparaciones, long intercambios) {
        /** Devuelve la cantidad de comparaciones entre elementos adyacentes.
         * @return número de comparaciones
         */
        public long comparaciones() { return comparaciones; }

        /** Devuelve la cantidad de intercambios realizados.
         * @return número de intercambios
         */
        public long intercambios() { return intercambios; }
    }

    /** Evita instancias; los algoritmos de esta clase son estáticos. */
    private AnalisisDeAlgoritmos10() { }

    /**
     * Ordena el vector ascendentemente en el mismo arreglo y cuenta operaciones.
     * La rutina termina antes si una pasada no necesita intercambios.
     *
     * @param vector arreglo que se ordenará in-place
     * @return estadísticas de comparaciones e intercambios
     * @throws IllegalArgumentException si el vector es nulo
     */
    public static Estadisticas ordenar(int[] vector) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser nulo.");
        }

        long comparaciones = 0;
        long intercambios = 0;
        for (int fin = vector.length - 1; fin > 0; fin--) {
            boolean huboIntercambio = false;
            for (int i = 0; i < fin; i++) {
                comparaciones++;
                if (vector[i] > vector[i + 1]) {
                    int temporal = vector[i];
                    vector[i] = vector[i + 1];
                    vector[i + 1] = temporal;
                    intercambios++;
                    huboIntercambio = true;
                }
            }
            // Una pasada sin intercambios demuestra que el arreglo ya está ordenado.
            if (!huboIntercambio) {
                break;
            }
        }
        return new Estadisticas(comparaciones, intercambios);
    }

    /** Demuestra el ordenamiento y los contadores en entradas representativas.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        demostrar(new int[]{5, 1, 4, 2, 8});
        demostrar(new int[]{1, 2, 3, 4});
        demostrar(new int[]{4, 3, 2, 1});
        demostrar(new int[]{3, 1, 3, 2, 1});
        demostrar(new int[0]);
    }

    /** Ejecuta una demostración de ordenamiento y muestra las estadísticas. */
    private static void demostrar(int[] vector) {
        System.out.println("Entrada: " + Arrays.toString(vector));
        Estadisticas estadisticas = ordenar(vector);
        System.out.println("Ordenado: " + Arrays.toString(vector)
                + "; comparaciones: " + estadisticas.comparaciones()
                + "; intercambios: " + estadisticas.intercambios());
    }
}
