import java.util.Arrays;
import java.util.Scanner;

/**
 * Ordenamiento08 — MergeSort detallado.
 * <p>Paráfrasis de la consigna: exponer particiones recursivas, marcar el corte en tramos de
 * cero o un elemento, y mostrar ambas mitades más su fusión ordenada. Partir fracciona el
 * problema; fusionar reúne soluciones. Tiempo O(n log n), auxiliar O(n).</p>
 */
public class Ordenamiento08 {
    private Ordenamiento08() { }

    /** Ordena in-place e imprime divisiones, casos base y fusiones.
     * @param arreglo enteros a ordenar; no puede ser null
     * @throws IllegalArgumentException si arreglo es null
     */
    public static void ordenar(int[] arreglo) {
        if (arreglo == null) throw new IllegalArgumentException("El arreglo no puede ser null.");
        mergeSort(arreglo, new int[arreglo.length], 0, arreglo.length - 1, 0);
    }

    private static void mergeSort(int[] arreglo, int[] auxiliar, int inicio, int fin, int nivel) {
        String sangria = "  ".repeat(nivel);
        if (inicio >= fin) {
            System.out.println(sangria + "Corte: " + segmento(arreglo, inicio, fin));
            return;
        }
        int medio = inicio + (fin - inicio) / 2;
        System.out.println(sangria + "Dividir " + Arrays.toString(Arrays.copyOfRange(arreglo, inicio, fin + 1))
                + " en " + Arrays.toString(Arrays.copyOfRange(arreglo, inicio, medio + 1))
                + " y " + Arrays.toString(Arrays.copyOfRange(arreglo, medio + 1, fin + 1)));
        mergeSort(arreglo, auxiliar, inicio, medio, nivel + 1);
        mergeSort(arreglo, auxiliar, medio + 1, fin, nivel + 1);
        System.out.println(sangria + "Fusionar " + Arrays.toString(Arrays.copyOfRange(arreglo, inicio, medio + 1))
                + " y " + Arrays.toString(Arrays.copyOfRange(arreglo, medio + 1, fin + 1)));
        fusionar(arreglo, auxiliar, inicio, medio, fin);
        System.out.println(sangria + "Resultado de fusión: " + Arrays.toString(Arrays.copyOfRange(arreglo, inicio, fin + 1)));
    }

    private static String segmento(int[] arreglo, int inicio, int fin) {
        if (inicio > fin) return "[]";
        return Arrays.toString(Arrays.copyOfRange(arreglo, inicio, fin + 1));
    }

    private static void fusionar(int[] arreglo, int[] auxiliar, int inicio, int medio, int fin) {
        int i = inicio, j = medio + 1, k = inicio;
        while (i <= medio && j <= fin) auxiliar[k++] = arreglo[i] <= arreglo[j] ? arreglo[i++] : arreglo[j++];
        while (i <= medio) auxiliar[k++] = arreglo[i++];
        while (j <= fin) auxiliar[k++] = arreglo[j++];
        for (int indice = inicio; indice <= fin; indice++) arreglo[indice] = auxiliar[indice];
    }

    /** Lee el arreglo desde consola y muestra el proceso de ordenamiento.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Cantidad de enteros: "); int n = entrada.nextInt();
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
