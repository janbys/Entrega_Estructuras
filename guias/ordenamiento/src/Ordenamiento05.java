import java.util.Arrays;
import java.util.Scanner;

/**
 * Ordenamiento05 — ShellSort con gaps visibles.
 * <p>Paráfrasis de la consigna: gaps n/2, n/4, ... hasta 1, con inserciones por subgrupos
 * y publicación del gap y del arreglo tras cada fase. Los saltos acercan valores lejanos
 * antes de la pasada final. Peor caso de referencia O(n²) para esta serie, espacio O(1).</p>
 */
public class Ordenamiento05 {
    private Ordenamiento05() { }

    /** Ordena in-place y muestra el estado después de cada pasada completa de un gap.
     * @param arreglo arreglo a ordenar; no puede ser null
     * @throws IllegalArgumentException si arreglo es null
     */
    public static void ordenar(int[] arreglo) {
        if (arreglo == null) throw new IllegalArgumentException("El arreglo no puede ser null.");
        for (int gap = arreglo.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arreglo.length; i++) {
                int clave = arreglo[i], j = i;
                while (j >= gap && arreglo[j - gap] > clave) {
                    arreglo[j] = arreglo[j - gap];
                    j -= gap;
                }
                arreglo[j] = clave;
            }
            System.out.println("Gap " + gap + ": " + Arrays.toString(arreglo));
        }
    }

    /** Lee un arreglo y presenta las etapas de ShellSort.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Cantidad de enteros: ");
            int n = entrada.nextInt();
            if (n < 0) throw new IllegalArgumentException("La cantidad no puede ser negativa.");
            int[] arreglo = new int[n];
            for (int i = 0; i < n; i++) { System.out.print("Valor " + (i + 1) + ": "); arreglo[i] = entrada.nextInt(); }
            System.out.println("Original: " + Arrays.toString(arreglo));
            ordenar(arreglo);
            System.out.println("Ordenado: " + Arrays.toString(arreglo));
        } catch (java.util.InputMismatchException error) {
            System.out.println("Entrada inválida: ingresá únicamente números enteros.");
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
