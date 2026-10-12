import java.util.Arrays;

/**
 * Ejercicio 2 — Buscar un elemento en un vector desordenado.
 * <p>Consigna: Construí un prompt para OpenCode que solicite la implementación en Java de un algoritmo que busque un elemento dentro de un vector desordenado. El prompt debe indicar la estrategia, justificarla, solicitar el análisis del mejor, peor y caso promedio, y pedir que se informe cuántas posiciones se recorrieron hasta encontrar el elemento o determinar que no existe.</p>
 * <p>Estrategia: búsqueda lineal, porque el arreglo no está ordenado y no se puede descartar ninguna región de antemano. Mejor caso O(1); peor caso O(n); promedio O(n), suponiendo que la posición de éxito es uniforme. Espacio adicional O(1).</p>
 */
public class AnalisisDeAlgoritmos02 {

    /** Resultado de una búsqueda lineal, incluyendo su cantidad de inspecciones.
     * @param indice índice encontrado o -1 cuando no existe
     * @param posicionesRecorridas posiciones inspeccionadas durante la búsqueda
     */
    public record ResultadoBusqueda(int indice, int posicionesRecorridas) {
        /** Devuelve el índice encontrado o -1 cuando el elemento no existe.
         * @return índice de la coincidencia o -1
         */
        public int indice() { return indice; }

        /** Devuelve la cantidad de posiciones efectivamente examinadas.
         * @return número de posiciones examinadas
         */
        public int posicionesRecorridas() { return posicionesRecorridas; }
    }

    /** Evita instancias; los algoritmos de esta clase son estáticos. */
    private AnalisisDeAlgoritmos02() { }

    /**
     * Busca el objetivo desde el principio y se detiene en la primera coincidencia.
     *
     * @param vector arreglo desordenado que se va a recorrer
     * @param objetivo valor buscado
     * @return índice de la primera coincidencia (o -1) y cantidad de posiciones inspeccionadas
     * @throws IllegalArgumentException si el vector es nulo
     */
    public static ResultadoBusqueda buscar(int[] vector, int objetivo) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser nulo.");
        }

        int recorridas = 0;
        for (int i = 0; i < vector.length; i++) {
            recorridas++;
            if (vector[i] == objetivo) {
                return new ResultadoBusqueda(i, recorridas);
            }
        }
        return new ResultadoBusqueda(-1, recorridas);
    }

    /** Demuestra búsqueda al inicio, al final y de un valor ausente.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        int[] valores = {14, 3, 27, 9, 18};
        System.out.println("Vector: " + Arrays.toString(valores));
        mostrarResultado(buscar(valores, 14), 14);
        mostrarResultado(buscar(valores, 18), 18);
        mostrarResultado(buscar(valores, 5), 5);
        mostrarResultado(buscar(new int[0], 5), 5);
    }

    /** Imprime en formato legible el resultado de una demostración. */
    private static void mostrarResultado(ResultadoBusqueda resultado, int objetivo) {
        String ubicacion = resultado.indice() >= 0
                ? "en el índice " + resultado.indice()
                : "no encontrado";
        System.out.println("Objetivo " + objetivo + ": " + ubicacion
                + "; posiciones recorridas: " + resultado.posicionesRecorridas());
    }
}
