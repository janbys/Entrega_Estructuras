import java.util.Arrays;
import java.util.Scanner;

/**
 * Ordenamiento10 — Tabla de posiciones con estabilidad.
 * <p>Paráfrasis de la consigna: registros completos ordenados por puntaje descendente con
 * MergeSort estable, que preserva el ingreso en empates y nunca separa nombre de puntaje.
 * Tiempo O(n log n), espacio O(n). Muestra tabla previa y posterior; admite cero jugadores.</p>
 */
public class Ordenamiento10 {
    /** Registro inmutable que mantiene asociado el nombre con su puntaje.
     * @param nombre nombre del jugador
     * @param puntaje puntaje del jugador
     */
    public record Jugador(String nombre, int puntaje) {
        /** Texto legible del registro.
         * @return nombre y puntaje
         */
        @Override public String toString() { return nombre + " (" + puntaje + ")"; }
    }

    private Ordenamiento10() { }

    /** Ordena in-place por puntaje descendente con MergeSort estable.
     * @param jugadores registros a ordenar; no puede ser null ni contener null
     * @throws IllegalArgumentException si la referencia o un registro es null
     */
    public static void ordenar(Jugador[] jugadores) {
        if (jugadores == null) throw new IllegalArgumentException("El arreglo no puede ser null.");
        for (Jugador jugador : jugadores) if (jugador == null) throw new IllegalArgumentException("Los jugadores no pueden ser null.");
        mergeSort(jugadores, new Jugador[jugadores.length], 0, jugadores.length - 1);
    }

    private static void mergeSort(Jugador[] jugadores, Jugador[] auxiliar, int inicio, int fin) {
        if (inicio >= fin) return;
        int medio = inicio + (fin - inicio) / 2;
        mergeSort(jugadores, auxiliar, inicio, medio);
        mergeSort(jugadores, auxiliar, medio + 1, fin);
        int i = inicio, j = medio + 1, k = inicio;
        while (i <= medio && j <= fin) {
            // En empate se toma primero el registro de la mitad izquierda para preservar estabilidad.
            if (jugadores[i].puntaje() >= jugadores[j].puntaje()) auxiliar[k++] = jugadores[i++];
            else auxiliar[k++] = jugadores[j++];
        }
        while (i <= medio) auxiliar[k++] = jugadores[i++];
        while (j <= fin) auxiliar[k++] = jugadores[j++];
        for (int indice = inicio; indice <= fin; indice++) jugadores[indice] = auxiliar[indice];
    }

    /** Lee jugadores y muestra el ranking antes y después de ordenar.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Cantidad de jugadores: ");
            int cantidad = Integer.parseInt(entrada.nextLine().trim());
            if (cantidad < 0) throw new IllegalArgumentException("La cantidad no puede ser negativa.");
            Jugador[] jugadores = new Jugador[cantidad];
            for (int i = 0; i < cantidad; i++) {
                System.out.print("Nombre del jugador " + (i + 1) + ": ");
                String nombre = entrada.nextLine();
                System.out.print("Puntaje de " + nombre + ": ");
                int puntaje = Integer.parseInt(entrada.nextLine().trim());
                jugadores[i] = new Jugador(nombre, puntaje);
            }
            System.out.println("Ranking original: " + Arrays.toString(jugadores));
            ordenar(jugadores);
            System.out.println("Ranking ordenado: " + Arrays.toString(jugadores));
        } catch (NumberFormatException error) {
            System.out.println("Entrada inválida: la cantidad y los puntajes deben ser enteros.");
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
