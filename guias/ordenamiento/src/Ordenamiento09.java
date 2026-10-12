import java.util.Arrays;
import java.util.Scanner;

/**
 * Ordenamiento09 — Burbuja, Selección e Inserción frente a frente.
 * <p>Paráfrasis de la consigna: cada método trabaja sobre su clon y reporta cotejos entre
 * valores; Burbuja/Selección agregan intercambios reales e Inserción corrimientos a la
 * derecha (sin la colocación final). Burbuja básica y Selección O(n²) siempre; Inserción
 * mejor O(n), resto O(n²); todos O(1) extra.</p>
 */
public class Ordenamiento09 {
    /** Métricas adecuadas para las tres estrategias.
     * @param comparaciones comparaciones entre valores
     * @param intercambios intercambios reales
     * @param desplazamientos movimientos hacia la derecha
     */
    public record Estadisticas(long comparaciones, long intercambios, long desplazamientos) { }
    private Ordenamiento09() { }

    /** Ordena una copia con Bubble Sort básico.
     * @param arreglo arreglo a modificar, no nulo
     * @return métricas del algoritmo
     */
    public static Estadisticas bubbleSort(int[] arreglo) {
        validar(arreglo); long comp = 0, swaps = 0;
        for (int fin = arreglo.length - 1; fin > 0; fin--) for (int i = 0; i < fin; i++) {
            comp++;
            if (arreglo[i] > arreglo[i + 1]) { intercambiar(arreglo, i, i + 1); swaps++; }
        }
        return new Estadisticas(comp, swaps, 0);
    }

    /** Ordena una copia con Selection Sort.
     * @param arreglo arreglo a modificar, no nulo
     * @return métricas del algoritmo
     */
    public static Estadisticas selectionSort(int[] arreglo) {
        validar(arreglo); long comp = 0, swaps = 0;
        for (int inicio = 0; inicio < arreglo.length - 1; inicio++) {
            int menor = inicio;
            for (int i = inicio + 1; i < arreglo.length; i++) { comp++; if (arreglo[i] < arreglo[menor]) menor = i; }
            if (menor != inicio) { intercambiar(arreglo, inicio, menor); swaps++; }
        }
        return new Estadisticas(comp, swaps, 0);
    }

    /** Ordena una copia con Insertion Sort.
     * @param arreglo arreglo a modificar, no nulo
     * @return comparaciones efectivas y desplazamientos; la escritura final de la clave no cuenta
     */
    public static Estadisticas insertionSort(int[] arreglo) {
        validar(arreglo); long comp = 0, shifts = 0;
        for (int i = 1; i < arreglo.length; i++) {
            int clave = arreglo[i], j = i - 1;
            while (j >= 0) {
                comp++;
                if (arreglo[j] <= clave) break;
                arreglo[j + 1] = arreglo[j]; shifts++; j--;
            }
            arreglo[j + 1] = clave;
        }
        return new Estadisticas(comp, 0, shifts);
    }

    private static void validar(int[] arreglo) { if (arreglo == null) throw new IllegalArgumentException("El arreglo no puede ser null."); }
    private static void intercambiar(int[] a, int i, int j) { int t = a[i]; a[i] = a[j]; a[j] = t; }

    /** Lee datos y ejecuta las tres estrategias sobre copias idénticas.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Cantidad de enteros: "); int n = entrada.nextInt();
            if (n < 0) throw new IllegalArgumentException("La cantidad no puede ser negativa.");
            int[] original = new int[n];
            for (int i = 0; i < n; i++) { System.out.print("Valor " + (i + 1) + ": "); original[i] = entrada.nextInt(); }
            int[] b = original.clone(), s = original.clone(), ins = original.clone();
            Estadisticas eb = bubbleSort(b), es = selectionSort(s), ei = insertionSort(ins);
            System.out.println("Original: " + Arrays.toString(original));
            mostrar("Bubble Sort", b, eb, "intercambios");
            mostrar("Selection Sort", s, es, "intercambios");
            mostrar("Insertion Sort", ins, ei, "desplazamientos");
        } catch (java.util.InputMismatchException error) {
            System.out.println("Entrada inválida: ingresá únicamente números enteros.");
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }

    private static void mostrar(String nombre, int[] arreglo, Estadisticas e, String tipoMovimiento) {
        long movimientos = tipoMovimiento.equals("intercambios") ? e.intercambios() : e.desplazamientos();
        System.out.println(nombre + ": " + Arrays.toString(arreglo) + " | comparaciones=" + e.comparaciones()
                + ", " + tipoMovimiento + "=" + movimientos);
    }
}
