/*
Prompt inicial de OpenCode:
Desarrollá en Java 21 la clase autónoma `PilasColasConArreglo07`, que conserve nombres de personas en una cola lineal simple de `String[]` con tope fijo pedido por consola. Incluí un menú cíclico para dar de alta a alguien (enqueue), atender al siguiente (dequeue), ver quién va primero (front), listar la fila y salir. Justificá el FIFO: se atiende antes a quien arribó antes; con LIFO se atendería al recién llegado y se rompería la espera. No entregues números de turno. Sostené `front`, `rear` y `size`; no corras datos ni reusen huecos del frente, salvo el reinicio de índices cuando la cola se vacía del todo. Cuando rear toque el fondo, encolar debe fallar incluso con huecos libres adelante, como corresponde a una cola simple. Lo lleno/vacío genera `IllegalStateException`; el menú lo avisa y prosigue intacto. Admití capacidad cero. Sumá Javadoc, muestra de arribos y atenciones, bordes y costo O(1)/O(c). Pegá la consigna entera como comentario de apertura y al final consigná si varió.
*/
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 7 — Sistema de turnos FIFO.
 * <p>La primera persona que llega se atiende primero; una pila LIFO invertiría la prioridad.
 * Ejemplo: Ana, luego Luis; atender devuelve Ana y front pasa a Luis. Cola simple O(1) por
 * operación y O(c) de espacio; huecos iniciales no se reutilizan hasta vaciarla.</p>
 */
public class PilasColasConArreglo07 {
    private final String[] fila;
    private int front = 0, rear = -1, size = 0;
    private PilasColasConArreglo07(int capacidad) { fila = new String[capacidad]; }
    /** Registra persona al final de la cola.
     * @param persona nombre
     * @throws IllegalStateException si no hay espacio físico al final
     */
    public void registrar(String persona) {
        if (rear == fila.length - 1) throw new IllegalStateException("La cola simple no tiene espacio al final.");
        if (size == 0) front = 0;
        fila[++rear] = persona; size++;
    }
    /** Atiende y retira a la primera persona.
     * @return persona atendida
     * @throws IllegalStateException si no hay personas esperando
     */
    public String atender() {
        if (size == 0) throw new IllegalStateException("No hay personas esperando.");
        String persona = fila[front]; fila[front++] = null; size--;
        if (size == 0) { front = 0; rear = -1; }
        return persona;
    }
    /** Consulta la primera persona sin retirarla.
     * @return nombre al frente
     * @throws IllegalStateException si la fila está vacía
     */
    public String primero() { if (size == 0) throw new IllegalStateException("No hay personas esperando."); return fila[front]; }
    private String estado() { return "Fila (primero → último): " + (size == 0 ? "[]" : Arrays.toString(Arrays.copyOfRange(fila, front, rear + 1))); }

    /** Ejecuta el menú de atención.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer c = leerEntero(sc, "Capacidad de la fila: "); if (c == null) return;
            if (c < 0) { System.out.println("La capacidad debe ser no negativa."); return; }
            PilasColasConArreglo07 sistema = new PilasColasConArreglo07(c); boolean salir = false;
            while (!salir) {
                System.out.println("\n1 registrar persona | 2 atender siguiente | 3 consultar primero | 4 mostrar fila | 0 salir");
                Integer op = leerEntero(sc, "Opción: "); if (op == null) break;
                try {
                    switch (op) {
                        case 1 -> { System.out.print("Nombre: "); if (!sc.hasNextLine()) return; String p = sc.nextLine(); sistema.registrar(p); System.out.println("Registrada. " + sistema.estado()); }
                        case 2 -> System.out.println("Atendida: " + sistema.atender() + ". " + sistema.estado());
                        case 3 -> System.out.println("Primera: " + sistema.primero());
                        case 4 -> System.out.println(sistema.estado());
                        case 0 -> salir = true;
                        default -> System.out.println("Opción inexistente.");
                    }
                } catch (IllegalStateException e) { System.out.println("Operación no realizada: " + e.getMessage()); }
            }
        }
    }
    private static Integer leerEntero(Scanner sc, String m) {
        while (sc.hasNextLine()) { System.out.print(m); try { return Integer.valueOf(sc.nextLine().trim()); } catch (NumberFormatException e) { System.out.println("Ingresá un entero válido."); } }
        return null;
    }
}
// Prompt sin cambios.
