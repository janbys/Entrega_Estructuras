import java.util.Arrays;
import java.util.Scanner;

/**
 * Ordenamiento01 — Burbuja paso a paso.
 * <p>Paráfrasis de la consigna: exhibir el arreglo inicial y su evolución tras cada pasada
 * completa de Bubble Sort básico, sin corte anticipado, hasta dejarlo creciente.</p>
 * <p>Solo se permutan vecinos desordenados, de modo que el máximo pendiente migra al fondo
 * en cada pasada. Costos: tiempo O(n²), memoria extra O(1).</p>
 * <p>Dato de entrada: cantidad no negativa más enteros por consola. Producto: original,
 * estados por pasada y ordenado final. Con cero o un elemento no se imprimen pasadas.</p>
 */
public class Ordenamiento01 {
    private Ordenamiento01() { }

    /** Ordena in-place e imprime el estado después de cada pasada completa.
     * @param valores arreglo de enteros; no puede ser null
     * @throws IllegalArgumentException si el arreglo es null
     */
    public static void ordenar(int[] valores) {
        if (valores == null) throw new IllegalArgumentException("El arreglo no puede ser null.");
        System.out.println("Original: " + Arrays.toString(valores));
        for (int fin = valores.length - 1, pasada = 1; fin > 0; fin--, pasada++) {
            for (int i = 0; i < fin; i++) {
                if (valores[i] > valores[i + 1]) {
                    int temporal = valores[i];
                    valores[i] = valores[i + 1];
                    valores[i + 1] = temporal;
                }
            }
            System.out.println("Pasada " + pasada + ": " + Arrays.toString(valores));
        }
        System.out.println("Ordenado: " + Arrays.toString(valores));
    }

    /** Lee y ordena un arreglo ingresado por consola.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Cantidad de enteros: ");
            int cantidad = entrada.nextInt();
            if (cantidad < 0) throw new IllegalArgumentException("La cantidad no puede ser negativa.");
            int[] valores = new int[cantidad];
            for (int i = 0; i < cantidad; i++) {
                System.out.print("Valor " + (i + 1) + ": ");
                valores[i] = entrada.nextInt();
            }
            ordenar(valores);
        } catch (java.util.InputMismatchException error) {
            System.out.println("Entrada inválida: ingresá únicamente números enteros.");
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
