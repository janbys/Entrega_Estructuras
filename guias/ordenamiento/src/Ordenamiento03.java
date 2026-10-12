import java.util.Arrays;
import java.util.Scanner;

/**
 * Ordenamiento03 — Inserción sobre datos casi ordenados.
 * <p>Paráfrasis de la consigna: permitir el ejemplo {1, 2, 3, 5, 4, 6, 7} o un arreglo propio,
 * ordenar con Insertion Sort y exhibir desplazamientos a la derecha (sin contar la escritura
 * final de la clave). Con pocas inversiones el costo se acerca al lineal. Mejor O(n),
 * medio/peor O(n²), memoria extra O(1).</p>
 */
public class Ordenamiento03 {
    /** Resultado del ordenamiento.
     * @param desplazamientos cantidad de elementos movidos una posición a la derecha
     */
    public record Estadisticas(long desplazamientos) { }
    private Ordenamiento03() { }

    /** Ordena in-place y cuenta desplazamientos; la escritura final de la clave no se cuenta.
     * @param arreglo arreglo de enteros a ordenar; no puede ser null
     * @return total de desplazamientos
     * @throws IllegalArgumentException si arreglo es null
     */
    public static Estadisticas ordenar(int[] arreglo) {
        if (arreglo == null) throw new IllegalArgumentException("El arreglo no puede ser null.");
        long desplazamientos = 0;
        for (int i = 1; i < arreglo.length; i++) {
            int clave = arreglo[i], j = i - 1;
            while (j >= 0 && arreglo[j] > clave) {
                arreglo[j + 1] = arreglo[j];
                desplazamientos++;
                j--;
            }
            arreglo[j + 1] = clave;
        }
        return new Estadisticas(desplazamientos);
    }

    /** Permite usar el caso de la consigna o ingresar valores propios.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("¿Usar el ejemplo {1, 2, 3, 5, 4, 6, 7}? (s/n): ");
            String respuesta = entrada.nextLine().trim();
            int[] arreglo;
            if (respuesta.equalsIgnoreCase("s")) {
                arreglo = new int[]{1, 2, 3, 5, 4, 6, 7};
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
            Estadisticas estadisticas = ordenar(arreglo);
            System.out.println("Ordenado: " + Arrays.toString(arreglo));
            System.out.println("Desplazamientos: " + estadisticas.desplazamientos());
        } catch (NumberFormatException error) {
            System.out.println("Entrada inválida: ingresá números enteros.");
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
