/**
 * Ejercicio 9 — Encontrar el mayor elemento de una matriz.
 * <p>Consigna: Construí un prompt para OpenCode que solicite un algoritmo Java que encuentre el mayor elemento de una matriz, justifique por qué es necesario recorrer todos los elementos y analice complejidad temporal y espacial.</p>
 * <p>Estrategia: inicializar el máximo con el primer elemento existente y comparar todos los restantes. Sin información adicional no se puede descartar ningún elemento. Para f filas y c columnas rectangulares, tiempo O(f·c) y espacio adicional O(1).</p>
 */
public class AnalisisDeAlgoritmos09 {

    /** Evita instancias; los algoritmos de esta clase son estáticos. */
    private AnalisisDeAlgoritmos09() { }

    /**
     * Encuentra el máximo de la matriz recorriendo todos sus elementos.
     * Las filas pueden tener longitudes distintas.
     *
     * @param matriz matriz que contiene al menos un elemento
     * @return mayor valor encontrado
     * @throws IllegalArgumentException si la matriz es nula o no contiene elementos
     */
    public static int encontrarMayor(int[][] matriz) {
        if (matriz == null) {
            throw new IllegalArgumentException("La matriz no puede ser nula.");
        }

        boolean encontrado = false;
        int mayor = 0;
        for (int[] fila : matriz) {
            if (fila == null) {
                throw new IllegalArgumentException("Las filas de la matriz no pueden ser nulas.");
            }
            for (int valor : fila) {
                if (!encontrado || valor > mayor) {
                    mayor = valor;
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            throw new IllegalArgumentException("La matriz debe contener al menos un elemento.");
        }
        return mayor;
    }

    /** Demuestra la búsqueda del máximo con valores negativos y el caso vacío.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        int[][] matriz = {{-9, -2}, {-15, -4}};
        System.out.println("Mayor de la matriz: " + encontrarMayor(matriz));
        try {
            encontrarMayor(new int[][]{{}, {}});
        } catch (IllegalArgumentException error) {
            System.out.println("Caso sin elementos: " + error.getMessage());
        }
    }
}
