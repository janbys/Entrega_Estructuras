import java.util.Arrays;
import java.util.Scanner;

/**
 * Ordenamiento07 — Escenario desfavorable de Quicksort.
 * <p>Paráfrasis de la consigna: ejemplo ascendente más opción manual, pivote inicial con
 * Lomuto adaptado, conteo de cada ingreso recursivo (incluidas ramas base vacías/unitarias
 * invocadas en ambas ramas). En datos ascendentes surgen bloques de 0 y n-1: O(n²) tiempo
 * y O(n) profundidad.</p>
 */
public class Ordenamiento07 {
    private Ordenamiento07() { }

    /** Ordena in-place y devuelve cuántas veces se invocó el método recursivo.
     * @param arreglo arreglo a ordenar; no puede ser null
     * @return número de llamadas, incluyendo inicial y casos base
     * @throws IllegalArgumentException si arreglo es null
     */
    public static long ordenarYContarLlamadas(int[] arreglo) {
        if (arreglo == null) throw new IllegalArgumentException("El arreglo no puede ser null.");
        long[] llamadas = {0};
        quickSort(arreglo, 0, arreglo.length - 1, llamadas);
        return llamadas[0];
    }

    private static void quickSort(int[] arreglo, int inicio, int fin, long[] llamadas) {
        llamadas[0]++;
        if (inicio >= fin) return;
        int posicion = particionar(arreglo, inicio, fin);
        // Se invocan las dos ramas incluso si una partición queda vacía para contar también su caso base.
        quickSort(arreglo, inicio, posicion - 1, llamadas);
        quickSort(arreglo, posicion + 1, fin, llamadas);
    }

    private static int particionar(int[] arreglo, int inicio, int fin) {
        int pivote = arreglo[inicio], temporal = arreglo[inicio];
        arreglo[inicio] = arreglo[fin]; arreglo[fin] = temporal;
        int frontera = inicio;
        for (int i = inicio; i < fin; i++) {
            if (arreglo[i] <= pivote) {
                temporal = arreglo[i]; arreglo[i] = arreglo[frontera]; arreglo[frontera] = temporal;
                frontera++;
            }
        }
        temporal = arreglo[frontera]; arreglo[frontera] = arreglo[fin]; arreglo[fin] = temporal;
        return frontera;
    }

    /** Permite usar el ejemplo ascendente o ingresar un arreglo propio.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("¿Usar el caso ascendente {1, 2, 3, 4, 5, 6, 7}? (s/n): ");
            int[] arreglo;
            if (entrada.nextLine().trim().equalsIgnoreCase("s")) {
                arreglo = new int[]{1, 2, 3, 4, 5, 6, 7};
            } else {
                System.out.print("Cantidad de enteros: ");
                int n = Integer.parseInt(entrada.nextLine().trim());
                if (n < 0) throw new IllegalArgumentException("La cantidad no puede ser negativa.");
                arreglo = new int[n];
                for (int i = 0; i < n; i++) {
                    System.out.print("Valor " + (i + 1) + ": ");
                    arreglo[i] = Integer.parseInt(entrada.nextLine().trim());
                }
            }
            System.out.println("Original: " + Arrays.toString(arreglo));
            long llamadas = ordenarYContarLlamadas(arreglo);
            System.out.println("Ordenado: " + Arrays.toString(arreglo));
            System.out.println("Invocaciones recursivas: " + llamadas);
        } catch (NumberFormatException error) {
            System.out.println("Entrada inválida: ingresá números enteros.");
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
