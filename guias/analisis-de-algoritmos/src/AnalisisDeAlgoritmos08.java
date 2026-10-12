/**
 * Ejercicio 8 — Sumar todos los elementos de una matriz.
 * <p>Consigna: Construí un prompt para OpenCode que solicite un algoritmo Java que sume todos los elementos de una matriz, indique cómo recorrerla, analice la complejidad y contabilice las operaciones realizadas.</p>
 * <p>Estrategia: recorrer filas y columnas, acumulando cada elemento. Se cuenta una operación por cada suma de un elemento al acumulador. Para f filas y c columnas rectangulares: tiempo O(f·c), espacio adicional O(1).</p>
 */
public class AnalisisDeAlgoritmos08 {

    /** Resultado de la suma y del conteo de elementos acumulados.
     * @param suma suma total de los valores
     * @param operaciones cantidad de elementos sumados al acumulador
     */
    public record ResultadoSuma(long suma, long operaciones) {
        /** Devuelve la suma de los elementos de la matriz.
         * @return suma total
         */
        public long suma() { return suma; }

        /** Devuelve la cantidad de sumas de elementos efectuadas.
         * @return número de operaciones contabilizadas
         */
        public long operaciones() { return operaciones; }
    }

    /** Evita instancias; los algoritmos de esta clase son estáticos. */
    private AnalisisDeAlgoritmos08() { }

    /**
     * Suma los elementos recorriendo cada fila y cuenta una operación por elemento.
     * Las filas pueden tener longitudes distintas; una fila nula se rechaza.
     *
     * @param matriz matriz de enteros
     * @return suma total y cantidad de elementos acumulados
     * @throws IllegalArgumentException si la matriz o alguna fila es nula
     */
    public static ResultadoSuma sumar(int[][] matriz) {
        if (matriz == null) {
            throw new IllegalArgumentException("La matriz no puede ser nula.");
        }

        long suma = 0;
        long operaciones = 0;
        for (int[] fila : matriz) {
            if (fila == null) {
                throw new IllegalArgumentException("Las filas de la matriz no pueden ser nulas.");
            }
            for (int valor : fila) {
                suma += valor;
                operaciones++;
            }
        }
        return new ResultadoSuma(suma, operaciones);
    }

    /** Demuestra la suma y el número de operaciones también para una matriz vacía.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {-4, 5, 6}};
        mostrarResultado(sumar(matriz));
        mostrarResultado(sumar(new int[0][]));
        mostrarResultado(sumar(new int[][]{{}, {}}));
    }

    /** Imprime la suma y el contador de operaciones de un resultado. */
    private static void mostrarResultado(ResultadoSuma resultado) {
        System.out.println("Suma: " + resultado.suma()
                + "; sumas de elementos realizadas: " + resultado.operaciones());
    }
}
