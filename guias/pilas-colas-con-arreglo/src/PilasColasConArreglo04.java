/*
Prompt inicial de OpenCode:
Desarrollá en Java 21 la clase autónoma `PilasColasConArreglo04`, que guarde URLs en una pila de `String` sobre un vector fijo con capacidad pedida por consola. Presentá un menú cíclico para visitar una dirección (push), retroceder (pop), ver la página vigente (peek), listar lo guardado y terminar. Cada visita se apila; retroceder descarta la vigente y deja al frente la previa cuando la hay. No agregues avance hacia adelante ni una segunda pila. Justificá el LIFO: lo último visitado es lo primero que se abandona. Si la pila rebalsa o está sin elementos, lanzá `IllegalStateException`; mostrala en el menú y continuá sin dañar el historial. Aceptá capacidad cero. Sumá Javadoc con fundamento, entradas y salidas, bordes y O(1) por operación con O(c) de memoria, más una corrida de ensayo repetible. Transcribí esta consigna entera como encabezado del fuente y al pie indicá si la modificaste o no.
*/
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 4 — Historial de navegación basado en pila LIFO.
 * <p>Una visita apila la URL y volver la desapila. Por ejemplo, visitar A y luego B deja B actual;
 * volver quita B y A vuelve a ser actual. No se implementa avanzar. Operaciones O(1), espacio O(c).</p>
 */
public class PilasColasConArreglo04 {
    private final String[] urls;
    private int top = -1;
    private PilasColasConArreglo04(int capacidad) { urls = new String[capacidad]; }
    /** Registra una visita.
     * @param url dirección visitada
     * @throws IllegalStateException si el historial está lleno
     */
    public void visitar(String url) {
        if (top == urls.length - 1) throw new IllegalStateException("El historial está lleno.");
        urls[++top] = url;
    }
    /** Vuelve quitando la página actual.
     * @return URL que se abandonó
     * @throws IllegalStateException si no hay página actual
     */
    public String volver() {
        if (top < 0) throw new IllegalStateException("No hay página para volver.");
        String url = urls[top]; urls[top--] = null; return url;
    }
    /** Consulta la página actual.
     * @return URL actual
     * @throws IllegalStateException si el historial está vacío
     */
    public String actual() {
        if (top < 0) throw new IllegalStateException("El historial está vacío.");
        return urls[top];
    }
    private String estado() { return Arrays.toString(Arrays.copyOf(urls, top + 1)) + " (base → actual)"; }

    /** Inicia el menú del historial.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer c = leerEntero(sc, "Capacidad del historial: "); if (c == null) return;
            if (c < 0) { System.out.println("La capacidad debe ser no negativa."); return; }
            PilasColasConArreglo04 historial = new PilasColasConArreglo04(c);
            boolean salir = false;
            while (!salir) {
                System.out.println("\n1 visitar URL | 2 volver | 3 página actual | 4 mostrar historial | 0 salir");
                Integer op = leerEntero(sc, "Opción: "); if (op == null) break;
                try {
                    switch (op) {
                        case 1 -> { System.out.print("URL: "); if (!sc.hasNextLine()) return; String url = sc.nextLine(); historial.visitar(url); System.out.println("Visitada. " + historial.estado()); }
                        case 2 -> { String anterior = historial.volver(); System.out.println("Se volvió desde " + anterior + (historial.top >= 0 ? "; página actual: " + historial.actual() : "; no quedan páginas") + "."); }
                        case 3 -> System.out.println("Página actual: " + historial.actual());
                        case 4 -> System.out.println("Historial: " + historial.estado());
                        case 0 -> salir = true;
                        default -> System.out.println("Opción inexistente.");
                    }
                } catch (IllegalStateException e) { System.out.println("Operación no realizada: " + e.getMessage()); }
            }
        }
    }
    private static Integer leerEntero(Scanner sc, String mensaje) {
        while (sc.hasNextLine()) { System.out.print(mensaje); try { return Integer.valueOf(sc.nextLine().trim()); } catch (NumberFormatException e) { System.out.println("Ingresá un entero válido."); } }
        return null;
    }
}
// Prompt sin cambios.
