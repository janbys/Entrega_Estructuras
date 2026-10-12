/*
Prompt inicial de OpenCode:
Creá en Java 21 la clase autónoma `PilasColasConArreglo09`, con una cola lineal de enteros en vector fijo, sin resto ni reacomodo automático. Pedí la capacidad y mostrá un menú cíclico de enqueue, dequeue, ver estado y salir. Tras cada encolado/desencolado exhibí el vector físico (con celdas libres), `front`, `rear`, `size` y posiciones desocupadas. Explicá y evidenciá que al sacar del frente quedan huecos sin reusar; cuando `rear` pisa el último índice, el enqueue se niega aunque size siga debajo de la capacidad. Recién al vaciarse por completo se restablecen los índices. Lo lleno/vacío arroja `IllegalStateException` y el menú prosigue. Traé una corrida repetible de capacidad 3: meter 10, 20, 30; sacar uno; probar meter 40 y evidenciar que se niega pese al lugar libre en el índice 0. Aclarár que ese tope justifica la cola circular, sin resolverla aquí. Cubrí capacidades 0/1, entradas y salidas, Javadoc y O(1) por operación. Copiá esta consigna en la apertura y al final declará los retoques reales o que no los hubo.
*/
import java.util.Scanner;

/**
 * Ejercicio 9 — Desperdicio de espacio en cola lineal.
 * <p>Demostración reproducible, capacidad 3: enqueue 10,20,30; dequeue; enqueue 40 falla aunque
 * el índice 0 quedó libre, porque rear ya llegó al final. Se reinician índices al vaciar totalmente.
 * No hay módulo ni corrimiento. Cada operación O(1), espacio O(c).</p>
 */
public class PilasColasConArreglo09 {
    private final int[] datos;
    private int front = 0, rear = -1, size = 0;
    private PilasColasConArreglo09(int capacidad) { datos = new int[capacidad]; }
    /** Encola al final físico sin reciclar huecos iniciales.
     * @param valor entero a encolar
     * @throws IllegalStateException si rear alcanzó el final del arreglo
     */
    public void enqueue(int valor) {
        if (rear == datos.length - 1) throw new IllegalStateException("rear llegó al final; los huecos iniciales no se reutilizan.");
        if (size == 0) front = 0;
        datos[++rear] = valor; size++;
    }
    /** Retira el frente.
     * @return valor retirado
     * @throws IllegalStateException si está vacía
     */
    public int dequeue() {
        if (size == 0) throw new IllegalStateException("La cola está vacía.");
        int valor = datos[front++]; size--;
        if (size == 0) { front = 0; rear = -1; }
        return valor;
    }
    /** Muestra cada celda física e índices de estado.
     * @return estado del arreglo y huecos
     */
    public String estado() {
        StringBuilder celdas = new StringBuilder("[");
        for (int i = 0; i < datos.length; i++) {
            if (i > 0) celdas.append(", ");
            if (size > 0 && i >= front && i <= rear) celdas.append(datos[i]); else celdas.append("_");
        }
        celdas.append(']');
        StringBuilder libres = new StringBuilder("["); boolean primero = true;
        for (int i = 0; i < datos.length; i++) if (size == 0 || i < front || i > rear) {
            if (!primero) libres.append(", "); libres.append(i); primero = false;
        }
        libres.append(']');
        return "arreglo=" + celdas + ", huecos=" + libres + ", front=" + front + ", rear=" + rear + ", size=" + size;
    }

    /** Ejecuta operaciones y enseña el arreglo físico después de cada cambio.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer c = leerEntero(sc, "Capacidad: "); if (c == null) return;
            if (c < 0) { System.out.println("La capacidad debe ser no negativa."); return; }
            PilasColasConArreglo09 q = new PilasColasConArreglo09(c); boolean salir = false;
            System.out.println("Estado inicial: " + q.estado());
            while (!salir) {
                System.out.println("\n1 enqueue | 2 dequeue | 3 mostrar estado | 0 salir");
                Integer op = leerEntero(sc, "Opción: "); if (op == null) break;
                try {
                    switch (op) {
                        case 1 -> { Integer v = leerEntero(sc, "Entero: "); if (v == null) return; q.enqueue(v); System.out.println("Encolado. " + q.estado()); }
                        case 2 -> System.out.println("Retirado " + q.dequeue() + ". " + q.estado());
                        case 3 -> System.out.println(q.estado());
                        case 0 -> salir = true;
                        default -> System.out.println("Opción inexistente.");
                    }
                } catch (IllegalStateException e) { System.out.println("Operación no realizada: " + e.getMessage() + " | " + q.estado()); }
            }
        }
    }
    private static Integer leerEntero(Scanner sc, String m) {
        while (sc.hasNextLine()) { System.out.print(m); try { return Integer.valueOf(sc.nextLine().trim()); } catch (NumberFormatException e) { System.out.println("Ingresá un entero válido."); } }
        return null;
    }
}
// Prompt sin cambios.
