/*
Prompt inicial de OpenCode:
Desarrollá en Java 21 la clase autónoma `PilasColasConArreglo02`, que represente una torre de platos mediante una pila de `String` sobre un vector fijo cuya capacidad se pide por consola. Presentá un menú cíclico con opciones para colocar un plato en la cima (`push`), sacar el de arriba (`pop`), ver el de arriba (`peek`), listar la torre y terminar. Fundamentá la elección de la pila: los platos siguen LIFO, lo último apoyado queda encima y es lo primero que se puede sacar; con una cola saldría antes el plato más viejo. Ante pila colmada o sin platos, lanzá `IllegalStateException`, informala desde el menú y proseguí sin mutar el estado. Admití capacidad cero. Exhibí siempre el contenido vigente. Añadí Javadoc con entradas y salidas, criterios adoptados, bordes y costo O(1) por operación con O(c) de memoria, junto a un ensayo repetible. Transcribí esta consigna entera al inicio del fuente y al cierre aclará si sufrió retoques o no.
*/
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 2 — Simulador de torre de platos.
 * <p>Se usa una pila LIFO: al apilar Plato A y luego Plato B, B queda arriba y es el primero que
 * puede retirarse. Una cola atendería el plato más antiguo, contrario al acceso a la cima.
 * Ejemplo: capacidad 2; agregar "Llano", "Hondo"; peek muestra Hondo y pop retira Hondo.
 * Operaciones de cima O(1), espacio O(c).</p>
 */
public class PilasColasConArreglo02 {
    private final String[] platos;
    private int top = -1;
    private PilasColasConArreglo02(int capacidad) { platos = new String[capacidad]; }
    /** Agrega un plato a la cima.
     * @param plato nombre del plato
     * @throws IllegalStateException si la torre está llena
     */
    public void push(String plato) {
        if (top == platos.length - 1) throw new IllegalStateException("La torre está llena.");
        platos[++top] = plato;
    }
    /** Retira el plato superior.
     * @return plato retirado
     * @throws IllegalStateException si está vacía
     */
    public String pop() {
        if (top == -1) throw new IllegalStateException("No hay platos en la torre.");
        String resultado = platos[top]; platos[top--] = null; return resultado;
    }
    /** Consulta el plato superior sin retirarlo.
     * @return plato superior
     * @throws IllegalStateException si está vacía
     */
    public String peek() {
        if (top == -1) throw new IllegalStateException("No hay platos en la torre.");
        return platos[top];
    }
    private String estado() { return Arrays.toString(Arrays.copyOf(platos, top + 1)) + " (base → cima)"; }

    /** Inicia el simulador de torre.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer c = leerEntero(sc, "Capacidad de la torre: ");
            if (c == null) return;
            if (c < 0) { System.out.println("La capacidad debe ser no negativa."); return; }
            PilasColasConArreglo02 torre = new PilasColasConArreglo02(c);
            boolean salir = false;
            while (!salir) {
                System.out.println("\n1 agregar plato | 2 retirar superior | 3 consultar superior | 4 mostrar torre | 0 salir");
                Integer op = leerEntero(sc, "Opción: "); if (op == null) break;
                try {
                    switch (op) {
                        case 1 -> { System.out.print("Nombre del plato: "); if (!sc.hasNextLine()) return; String p = sc.nextLine(); torre.push(p); System.out.println("Agregado: " + p + " | " + torre.estado()); }
                        case 2 -> System.out.println("Retirado: " + torre.pop() + " | " + torre.estado());
                        case 3 -> System.out.println("Arriba está: " + torre.peek());
                        case 4 -> System.out.println("Torre: " + torre.estado());
                        case 0 -> salir = true;
                        default -> System.out.println("Opción inexistente.");
                    }
                } catch (IllegalStateException error) { System.out.println("Operación no realizada: " + error.getMessage()); }
            }
        }
    }
    private static Integer leerEntero(Scanner sc, String mensaje) {
        while (sc.hasNextLine()) { System.out.print(mensaje); try { return Integer.valueOf(sc.nextLine().trim()); } catch (NumberFormatException e) { System.out.println("Ingresá un entero válido."); } }
        return null;
    }
}
// Prompt sin cambios.
