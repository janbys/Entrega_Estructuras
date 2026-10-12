import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Ejercicio 4 — Detectar elementos duplicados.
 * <p>Consigna: Construí un prompt para OpenCode que solicite dos soluciones en Java para detectar duplicados en un vector: una con dos ciclos anidados y otra con HashSet, incluyendo una comparación de complejidad temporal y espacial.</p>
 * <p>Estrategia 1 compara cada par: O(n^2) en el peor caso y O(1) de espacio adicional. Estrategia 2 registra valores vistos en un HashSet: O(n) esperado y O(n) de espacio adicional. Ambas detienen el recorrido al encontrar un duplicado.</p>
 */
public class AnalisisDeAlgoritmos04 {

    /** Evita instancias; los algoritmos de esta clase son estáticos. */
    private AnalisisDeAlgoritmos04() { }

    /**
     * Detecta duplicados comparando pares de posiciones distintas.
     *
     * @param vector arreglo que se examinará
     * @return true si hay al menos dos valores iguales
     * @throws IllegalArgumentException si el arreglo es nulo
     */
    public static boolean tieneDuplicadosConCiclos(int[] vector) {
        validar(vector);
        for (int i = 0; i < vector.length; i++) {
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[i] == vector[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Detecta duplicados guardando los valores previamente encontrados en un conjunto.
     *
     * @param vector arreglo que se examinará
     * @return true si hay al menos dos valores iguales
     * @throws IllegalArgumentException si el arreglo es nulo
     */
    public static boolean tieneDuplicadosConHashSet(int[] vector) {
        validar(vector);
        Set<Integer> vistos = new HashSet<>();
        for (int valor : vector) {
            if (!vistos.add(valor)) {
                return true;
            }
        }
        return false;
    }

    /** Ejecuta las dos implementaciones sobre datos con y sin duplicados.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        int[][] ejemplos = {{4, 1, 8, 1}, {2, 5, 7}, {}, {9}};
        for (int[] ejemplo : ejemplos) {
            boolean ciclos = tieneDuplicadosConCiclos(ejemplo);
            boolean hashSet = tieneDuplicadosConHashSet(ejemplo);
            System.out.println(Arrays.toString(ejemplo) + " -> ciclos: " + ciclos
                    + ", HashSet: " + hashSet);
        }
        System.out.println("Comparación: ciclos O(n²), espacio O(1); "
            + "HashSet O(n) esperado, espacio O(n).");
    }

    /** Rechaza entradas nulas antes de comenzar cualquiera de los recorridos. */
    private static void validar(int[] vector) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser nulo.");
        }
    }
}
