/*
Prompt inicial de OpenCode:
Creá en Java 21 la clase autónoma `PilasColasConArreglo10`, con una cola circular de enteros en `int[]` fijo cuya capacidad se pide por consola. Brindá `enqueue`, `dequeue`, `front`, `isEmpty`, `isFull` y `size`, sosteniendo `front`, `rear` y el contador `size`. Partí del vacío con `front=0`, `rear=-1`, `size=0`; con el primer ingreso quedan rear=0 y front=0. Al encolar desplazá rear con `(rear + 1) % capacidad` y al desencolar desplazá front con `(front + 1) % capacidad`; al quitar el último, reponé los índices. Verificá lleno/vacío antes del resto para no dividir por cero. Con contador, el vacío es `size==0` y lo lleno `size==capacidad`; la capacidad cero figura vacía y llena a la vez y bloquea toda operatoria con elementos. Ofrecé un menú de operaciones con vista del vector y los índices. Lo lleno/vacío arroja `IllegalStateException`, se avisa y se sigue sin tocar el estado. Evidenciá completar la cola, quitar elementos del frente y volver a encolar aprovechando las celdas liberadas (wrap-around). Explicá en Javadoc el resto, invariantes, casos 0/1/habitual, O(1)/O(c) y corrida de muestra. Reproducí esta consigna íntegra como comentario de apertura y al final indicá si la retocaste.
*/
import java.util.Scanner;

/**
 * Ejercicio 10 — Cola circular de enteros.
 * <p>front/rear recorren un arreglo circular mediante módulo y size distingue estados lleno/vacío.
 * Ejemplo capacidad 3: enqueue 1,2,3; dequeue dos veces; enqueue 4 y 5 reutiliza índices liberados.
 * Las operaciones son O(1), espacio O(c). Se verifica lleno/vacío antes del módulo para capacidad 0.</p>
 */
public class PilasColasConArreglo10 {
    private final int[] datos;
    private int front = 0, rear = -1, size = 0;
    private PilasColasConArreglo10(int capacidad) {
        if (capacidad < 0) throw new IllegalArgumentException("La capacidad no puede ser negativa.");
        datos = new int[capacidad];
    }
    /** Encola en la siguiente posición circular.
     * @param valor valor a agregar
     * @throws IllegalStateException si está llena
     */
    public void enqueue(int valor) {
        if (isFull()) throw new IllegalStateException("La cola circular está llena.");
        if (size == 0) { front = 0; rear = 0; }
        else rear = (rear + 1) % datos.length;
        datos[rear] = valor; size++;
    }
    /** Desencola el elemento más antiguo.
     * @return valor retirado
     * @throws IllegalStateException si está vacía
     */
    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("La cola circular está vacía.");
        int valor = datos[front]; size--;
        if (size == 0) { front = 0; rear = -1; }
        else front = (front + 1) % datos.length;
        return valor;
    }
    /** Consulta el elemento más antiguo.
     * @return elemento del frente
     * @throws IllegalStateException si está vacía
     */
    public int front() { if (isEmpty()) throw new IllegalStateException("La cola circular está vacía."); return datos[front]; }
    /** Indica si no hay elementos.
     * @return true si size es cero
     */
    public boolean isEmpty() { return size == 0; }
    /** Indica si se alcanzó la capacidad máxima.
     * @return true si size coincide con capacidad, incluso para capacidad cero
     */
    public boolean isFull() { return size == datos.length; }
    /** Devuelve la cantidad almacenada.
     * @return tamaño actual
     */
    public int size() { return size; }
    /** Describe celdas ocupadas, índices y orden lógico desde front.
     * @return estado de la cola
     */
    public String estado() {
        StringBuilder fisico = new StringBuilder("[");
        for (int i = 0; i < datos.length; i++) {
            if (i > 0) fisico.append(", ");
            fisico.append(ocupado(i) ? Integer.toString(datos[i]) : "_");
        }
        fisico.append(']');
        StringBuilder logico = new StringBuilder("[");
        for (int k = 0; k < size; k++) { if (k > 0) logico.append(", "); logico.append(datos[(front + k) % datos.length]); }
        logico.append(']');
        return "arreglo=" + fisico + ", cola=" + logico + ", front=" + front + ", rear=" + rear + ", size=" + size;
    }
    private boolean ocupado(int indice) {
        for (int k = 0; k < size; k++) if ((front + k) % datos.length == indice) return true;
        return false;
    }

    /** Ejecuta un menú interactivo para la cola circular.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer c = leerEntero(sc, "Capacidad: "); if (c == null) return;
            if (c < 0) { System.out.println("La capacidad debe ser no negativa."); return; }
            PilasColasConArreglo10 q = new PilasColasConArreglo10(c); boolean salir = false;
            while (!salir) {
                System.out.println("\n1 enqueue | 2 dequeue | 3 front | 4 isEmpty | 5 isFull | 6 size | 7 mostrar | 0 salir");
                Integer op = leerEntero(sc, "Opción: "); if (op == null) break;
                try {
                    switch (op) {
                        case 1 -> { Integer v = leerEntero(sc, "Entero: "); if (v == null) return; q.enqueue(v); System.out.println("Encolado. " + q.estado()); }
                        case 2 -> System.out.println("Retirado: " + q.dequeue() + " | " + q.estado());
                        case 3 -> System.out.println("Frente: " + q.front());
                        case 4 -> System.out.println("Vacía: " + q.isEmpty());
                        case 5 -> System.out.println("Llena: " + q.isFull());
                        case 6 -> System.out.println("Tamaño: " + q.size());
                        case 7 -> System.out.println(q.estado());
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
