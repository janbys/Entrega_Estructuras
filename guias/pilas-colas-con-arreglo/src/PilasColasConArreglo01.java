/*
Prompt inicial de OpenCode:
Creá en Java 21 la clase autónoma `PilasColasConArreglo01`, que contenga una clase `PilaEnteros` apoyada en un `int[]` de tamaño fijo leído desde consola. Brindá las operaciones `push`, `pop`, `peek`, `isEmpty`, `isFull` y `size`. Dejá constancia de que `top` señala la posición de la cima, arranca en -1, se incrementa al apilar y se decrementa al desapilar, de modo que el tamaño equivale a `top + 1`. Respetá el orden LIFO. Si se apila con la pila completa o se consulta/retira con la pila sin elementos, lanzá `IllegalStateException` dejando todo como estaba. Aceptá capacidad cero, tratándola a la vez como vacía y como llena. Presentá un menú que se repita para cada operación más la salida; ante fallos operativos mostrá el aviso y seguí. Adjuntá Javadoc con costo O(1) por operación y O(c) de memoria, un ejemplo de corrida y los casos de pila colmada y sin datos. Reproducí esta consigna completa como comentario de cabecera y al pie dejá constancia de que no se tocó la consigna, o detallá la modificación real si existió.
*/
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 1 — Pila de enteros de capacidad fija.
 * <p>Usa un arreglo y el índice {@code top}, que vale -1 cuando está vacía. Push incrementa top;
 * pop devuelve el elemento y decrementa top. Es LIFO. Todas las operaciones son O(1), con O(c)
 * espacio para capacidad c. Ejemplo: capacidad 2, push(7), push(4), peek()=4, pop()=4, size()=1.</p>
 */
public class PilasColasConArreglo01 {
    /** Pila de enteros implementada con un arreglo fijo. */
    public static final class PilaEnteros {
        private final int[] elementos;
        private int top = -1;

        /** Construye una pila con capacidad fija.
         * @param capacidad cantidad máxima de elementos; debe ser no negativa
         * @throws IllegalArgumentException si capacidad es negativa
         */
        public PilaEnteros(int capacidad) {
            if (capacidad < 0) throw new IllegalArgumentException("La capacidad no puede ser negativa.");
            elementos = new int[capacidad];
        }
        /** Apila un entero.
         * @param valor valor a guardar
         * @throws IllegalStateException si la pila está llena
         */
        public void push(int valor) {
            if (isFull()) throw new IllegalStateException("La pila está llena.");
            elementos[++top] = valor;
        }
        /** Retira y devuelve el elemento superior.
         * @return elemento retirado
         * @throws IllegalStateException si está vacía
         */
        public int pop() {
            if (isEmpty()) throw new IllegalStateException("La pila está vacía.");
            return elementos[top--];
        }
        /** Consulta el elemento superior sin retirarlo.
         * @return elemento superior
         * @throws IllegalStateException si está vacía
         */
        public int peek() {
            if (isEmpty()) throw new IllegalStateException("La pila está vacía.");
            return elementos[top];
        }
        /** Indica si no contiene elementos.
         * @return true si está vacía
         */
        public boolean isEmpty() { return top == -1; }
        /** Indica si no puede aceptar más elementos.
         * @return true si está llena; también true con capacidad cero
         */
        public boolean isFull() { return top == elementos.length - 1; }
        /** Devuelve la cantidad actual de elementos.
         * @return tamaño
         */
        public int size() { return top + 1; }
        /** Devuelve la capacidad máxima.
         * @return capacidad del arreglo
         */
        public int capacity() { return elementos.length; }
        /** @return representación del segmento ocupado, desde el fondo hasta top */
        @Override public String toString() { return Arrays.toString(Arrays.copyOf(elementos, size())); }
    }

    private PilasColasConArreglo01() { }

    /** Ejecuta el menú interactivo.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Integer capacidad = leerEntero(scanner, "Capacidad: ");
            if (capacidad == null) return;
            if (capacidad < 0) { System.out.println("La capacidad debe ser no negativa."); return; }
            PilaEnteros pila = new PilaEnteros(capacidad);
            boolean salir = false;
            while (!salir) {
                System.out.println("\n1 push | 2 pop | 3 peek | 4 isEmpty | 5 isFull | 6 size | 7 mostrar | 0 salir");
                Integer opcion = leerEntero(scanner, "Opción: ");
                if (opcion == null) break;
                try {
                    switch (opcion) {
                        case 1 -> { Integer valor = leerEntero(scanner, "Entero: "); if (valor == null) return; pila.push(valor); System.out.println("Apilado: " + valor); }
                        case 2 -> System.out.println("Desapilado: " + pila.pop());
                        case 3 -> System.out.println("Superior: " + pila.peek());
                        case 4 -> System.out.println("Vacía: " + pila.isEmpty());
                        case 5 -> System.out.println("Llena: " + pila.isFull());
                        case 6 -> System.out.println("Tamaño: " + pila.size());
                        case 7 -> System.out.println("Fondo → superior: " + pila);
                        case 0 -> salir = true;
                        default -> System.out.println("Opción inexistente.");
                    }
                } catch (IllegalStateException error) { System.out.println("Operación no realizada: " + error.getMessage()); }
            }
        }
    }

    private static Integer leerEntero(Scanner scanner, String mensaje) {
        while (scanner.hasNextLine()) {
            System.out.print(mensaje);
            String linea = scanner.nextLine().trim();
            try { return Integer.valueOf(linea); }
            catch (NumberFormatException error) { System.out.println("Ingresá un número entero válido."); }
        }
        return null;
    }
}

// Prompt sin cambios.
