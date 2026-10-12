import java.util.Arrays;

/**
 * Ejercicio 6 — Comparar dos vectores.
 * <p>Consigna: Construí un prompt para OpenCode que solicite un algoritmo Java que determine si dos vectores son iguales, que finalice apenas detecte una diferencia y analice mejor, peor y caso promedio.</p>
 * <p>Estrategia: primero comparar longitudes; luego comparar elementos en el mismo índice y retornar en la primera diferencia. Mejor caso O(1), peor caso O(n); promedio O(n) si las entradas suelen coincidir hasta una fracción significativa. Espacio adicional O(1).</p>
 */
public class AnalisisDeAlgoritmos06 {

    /** Evita instancias; los algoritmos de esta clase son estáticos. */
    private AnalisisDeAlgoritmos06() { }

    /**
     * Compara longitud y valores correspondientes con finalización anticipada.
     *
     * @param primero primer arreglo
     * @param segundo segundo arreglo
     * @return true si tienen igual longitud y todos sus elementos coinciden
     * @throws IllegalArgumentException si alguno de los arreglos es nulo
     */
    public static boolean sonIguales(int[] primero, int[] segundo) {
        if (primero == null || segundo == null) {
            throw new IllegalArgumentException("Los vectores no pueden ser nulos.");
        }
        if (primero.length != segundo.length) {
            return false;
        }
        for (int i = 0; i < primero.length; i++) {
            if (primero[i] != segundo[i]) {
                return false;
            }
        }
        return true;
    }

    /** Demuestra igualdad, longitudes distintas y diferencias en posiciones distintas.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        int[] base = {3, 6, 9, 12};
        int[][] ejemplos = {{3, 6, 9, 12}, {3, 6, 10, 12}, {3, 6, 9}, {4, 6, 9, 12}, {}};
        System.out.println("Vector base: " + Arrays.toString(base));
        for (int[] ejemplo : ejemplos) {
            System.out.println(Arrays.toString(ejemplo) + " -> " + sonIguales(base, ejemplo));
        }
        System.out.println("Dos vectores vacíos -> " + sonIguales(new int[0], new int[0]));
    }
}
