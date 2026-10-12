/*
Prompt inicial de OpenCode:
Desarrollá en Java 21 la clase autónoma `PilasColasConArreglo08`. Definí un record simple `Documento(nombre, paginas)` y una cola lineal simple de esos registros sobre un vector de tope fijo pedido por consola. Ofrecé un menú para sumar un documento, mandar a imprimir el próximo, ver el siguiente, listar la cola y salir. Leé cada nombre como línea entera y pedí páginas como entero mayor que cero. Cada documento tiene que mantener juntos su nombre y sus páginas, y salir en el mismo orden de arribo (FIFO). No emules una impresora física ni tiempos de impresión. Encolar sin lugar al fondo, o consultar/retirar sin elementos, debe lanzar `IllegalStateException`; el menú lo avisa y continúa sin mutar nada. Mientras queden elementos, no recicles huecos delanteros. Admití capacidad cero. Documentá en Javadoc la razón FIFO, entradas y salidas, fallos, el caso de páginas inválidas, una corrida habitual y el costo O(1) por operación con O(c) de memoria. Transcribí esta consigna íntegra al tope y al pie señalá si hubo retoques.
*/
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 8 — Cola FIFO de impresión.
 * <p>Los registros Documento se guardan completos para no separar nombre y páginas. FIFO garantiza
 * el orden de llegada. Ejemplo: encolar informe(3) y notas(2); el próximo a imprimir es informe.
 * Encolar, retirar y consultar frente O(1), espacio O(c). No se controla impresora física.</p>
 */
public class PilasColasConArreglo08 {
    /** Documento pendiente de impresión.
     * @param nombre título o nombre del archivo
     * @param paginas cantidad positiva de páginas
     */
    public record Documento(String nombre, int paginas) {
        /** Valida los componentes del documento.
         * @throws IllegalArgumentException si el nombre es null o páginas no es positiva
         */
        public Documento { if (nombre == null || paginas <= 0) throw new IllegalArgumentException("Nombre requerido y páginas positivas."); }
    }
    private final Documento[] cola;
    private int front = 0, rear = -1, size = 0;
    private PilasColasConArreglo08(int capacidad) { cola = new Documento[capacidad]; }
    /** Agrega un documento al final disponible.
     * @param documento registro completo
     * @throws IllegalStateException si no cabe al final
     */
    public void enqueue(Documento documento) {
        if (rear == cola.length - 1) throw new IllegalStateException("No hay espacio al final de la cola simple.");
        if (size == 0) front = 0;
        cola[++rear] = documento; size++;
    }
    /** Retira el documento siguiente.
     * @return documento enviado a impresión
     * @throws IllegalStateException si la cola está vacía
     */
    public Documento dequeue() {
        if (size == 0) throw new IllegalStateException("No hay documentos pendientes.");
        Documento d = cola[front]; cola[front++] = null; size--;
        if (size == 0) { front = 0; rear = -1; }
        return d;
    }
    /** Consulta el siguiente documento sin retirarlo.
     * @return documento al frente
     * @throws IllegalStateException si la cola está vacía
     */
    public Documento peek() { if (size == 0) throw new IllegalStateException("No hay documentos pendientes."); return cola[front]; }
    private String estado() { return size == 0 ? "[]" : Arrays.toString(Arrays.copyOfRange(cola, front, rear + 1)); }

    /** Ejecuta menú de cola de impresión.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer c = leerEntero(sc, "Capacidad de la cola: "); if (c == null) return;
            if (c < 0) { System.out.println("La capacidad debe ser no negativa."); return; }
            PilasColasConArreglo08 q = new PilasColasConArreglo08(c); boolean salir = false;
            while (!salir) {
                System.out.println("\n1 agregar documento | 2 imprimir siguiente | 3 consultar siguiente | 4 mostrar cola | 0 salir");
                Integer op = leerEntero(sc, "Opción: "); if (op == null) break;
                try {
                    switch (op) {
                        case 1 -> {
                            System.out.print("Nombre del documento: "); if (!sc.hasNextLine()) return; String nombre = sc.nextLine();
                            Integer paginas = leerEntero(sc, "Cantidad de páginas (positiva): "); if (paginas == null) return;
                            if (paginas <= 0) { System.out.println("Las páginas deben ser positivas."); break; }
                            q.enqueue(new Documento(nombre, paginas)); System.out.println("Agregado. Cola: " + q.estado());
                        }
                        case 2 -> System.out.println("Enviado a imprimir: " + q.dequeue() + " | Cola: " + q.estado());
                        case 3 -> System.out.println("Siguiente: " + q.peek());
                        case 4 -> System.out.println("Cola FIFO: " + q.estado());
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
