import java.util.Arrays;

/**
 * Ejercicio 3 — Buscar un elemento en un vector ordenado.
 * <p>Consigna: Construí un prompt para OpenCode que solicite la implementación en Java de un algoritmo de búsqueda binaria. El prompt debe explicar por qué es más eficiente que la búsqueda lineal con datos ordenados, indicar la complejidad y solicitar una demostración paso a paso de las variables de búsqueda.</p>
 * <p>Estrategia: comparar el objetivo con el elemento central y descartar la mitad imposible en cada iteración. Frente a la búsqueda lineal O(n), reduce el intervalo a la mitad, por lo que tarda O(log n). Espacio adicional O(1). El arreglo debe estar ordenado ascendentemente.</p>
 */
public class AnalisisDeAlgoritmos03 {

    /** Evita instancias; los algoritmos de esta clase son estáticos. */
    private AnalisisDeAlgoritmos03() { }

    /**
     * Busca un valor en un arreglo ascendente e imprime la evolución del intervalo.
     *
     * @param vector arreglo ordenado ascendentemente (precondición)
     * @param objetivo valor que se desea localizar
     * @return índice de una coincidencia o -1 si no existe
     * @throws IllegalArgumentException si el arreglo es nulo
     */
    public static int buscar(int[] vector, int objetivo) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser nulo.");
        }

        int izquierda = 0;
        int derecha = vector.length - 1;
        int paso = 1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            System.out.printf("Paso %d: izquierda=%d, derecha=%d, medio=%d, valor=%d%n",
                    paso++, izquierda, derecha, medio, vector[medio]);

            if (vector[medio] == objetivo) {
                System.out.println("Coincidencia encontrada en el índice " + medio + ".");
                return medio;
            } else if (vector[medio] < objetivo) {
                System.out.println("El objetivo es mayor; se descarta la mitad izquierda.");
                izquierda = medio + 1;
            } else {
                System.out.println("El objetivo es menor; se descarta la mitad derecha.");
                derecha = medio - 1;
            }
        }

        System.out.println("El intervalo quedó vacío; el objetivo no está presente.");
        return -1;
    }

    /** Demuestra búsqueda binaria en vector vacío, con éxitos y sin coincidencia.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        int[] valores = {-8, -2, 0, 5, 11, 19, 24, 31};
        System.out.println("Vector ordenado: " + Arrays.toString(valores));
        System.out.println("Buscar -8:");
        buscar(valores, -8);
        System.out.println("Buscar 24:");
        buscar(valores, 24);
        System.out.println("Buscar 7:");
        buscar(valores, 7);
        System.out.println("Buscar en vector vacío:");
        buscar(new int[0], 1);
    }
}
