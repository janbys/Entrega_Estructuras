import java.util.Arrays;
import java.util.Scanner;

/**
 * Ordenamiento06 — Quicksort con pivote inicial.
 * <p>Paráfrasis de la consigna: divide y vencerás con el primer valor como pivote y Lomuto
 * adaptado (menores o iguales a la izquierda, mayores a la derecha). Tras cada partición se
 * informa pivote e hijos izquierdo/derecho. Tiempo medio O(n log n), peor O(n²);
 * pila media O(log n), peor O(n).</p>
 */
public class Ordenamiento06 {
    private Ordenamiento06() { }

    /** Ordena un arreglo in-place e imprime cada pivote y las particiones resultantes.
     * @param arreglo enteros a ordenar; no puede ser null
     * @throws IllegalArgumentException si arreglo es null
     */
    public static void ordenar(int[] arreglo) {
        if (arreglo == null) throw new IllegalArgumentException("El arreglo no puede ser null.");
        quickSort(arreglo, 0, arreglo.length - 1);
    }

    private static void quickSort(int[] arreglo, int inicio, int fin) {
        if (inicio >= fin) return;
        int posicion = particionar(arreglo, inicio, fin);
        System.out.println("Pivote " + arreglo[posicion]
                + " | izquierda=" + Arrays.toString(Arrays.copyOfRange(arreglo, inicio, posicion))
                + " | derecha=" + Arrays.toString(Arrays.copyOfRange(arreglo, posicion + 1, fin + 1)));
        quickSort(arreglo, inicio, posicion - 1);
        quickSort(arreglo, posicion + 1, fin);
    }

    /** Coloca el primer elemento en su posición definitiva.
     * @param arreglo arreglo que contiene el segmento
     * @param inicio primer índice del segmento
     * @param fin último índice del segmento
     * @return índice final del pivote
     */
    private static int particionar(int[] arreglo, int inicio, int fin) {
        int pivote = arreglo[inicio];
        int temporal = arreglo[inicio]; arreglo[inicio] = arreglo[fin]; arreglo[fin] = temporal;
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

    /** Lee y ordena valores desde la consola.
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
