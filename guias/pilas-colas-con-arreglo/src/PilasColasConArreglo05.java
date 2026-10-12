/*
Prompt inicial de OpenCode:
Creá en Java 21 la clase autónoma `PilasColasConArreglo05`, con una clase `Pila<T>` de tope fijo que guarde los datos en un `Object[]`, dado que Java impide instanciar `new T[]` por el borrado de tipos. Brindá `push`, `pop`, `peek`, `isEmpty`, `isFull` y `size`, lanzando `IllegalStateException` si se apila llena o se toca vacía, sin mutar nada. Argumentá que el genérico reutiliza un mismo código con control estático para Integer, String y objetos, a diferencia de una pila atada a enteros. En el main solicitá la capacidad y dejá optar por una demo tipada de Integer, de String o del record `Producto(nombre, precio)`; no se pide combinar tipos en una sola pila ni fabricar objetos libres por consola. La capacidad cero debe aceptarse. Explicá la conversión vigilada de `Object` a `T`, el límite del borrado, la operatoria y los costos O(1)/O(c), con casos y ensayo repetible. Reproducí esta consigna íntegra en la cabecera y cerrá con una nota fiel sobre retoques a la consigna.
*/
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 5 — Pila genérica.
 * <p>La misma API trabaja con Integer, String o Producto y mantiene el tipo estático; una pila de
 * int solo serviría para enteros. Java no permite {@code new T[]}, por borrado de tipos, así que el
 * almacenamiento usa Object[] y una conversión comprobada por el tipo parametrizado. Ejemplo:
* {@code Pila<String>} de capacidad 2, push("A"), push("B"), pop() devuelve B. Operaciones O(1), espacio O(c).</p>
 */
public class PilasColasConArreglo05 {
    /** Producto simple usado como tercer ejemplo de tipo genérico.
     * @param nombre nombre del producto
     * @param precio precio no negativo
     */
    public record Producto(String nombre, double precio) { }

    /** Pila genérica de capacidad fija.
     * @param <T> tipo de elementos almacenados
     */
    public static final class Pila<T> {
        private final Object[] elementos;
        private int top = -1;
        /** Construye la pila.
         * @param capacidad capacidad no negativa
         * @throws IllegalArgumentException si es negativa
         */
        public Pila(int capacidad) {
            if (capacidad < 0) throw new IllegalArgumentException("La capacidad no puede ser negativa.");
            elementos = new Object[capacidad];
        }
        /** Apila un valor.
         * @param valor objeto compatible con T
         * @throws IllegalStateException si está llena
         */
        public void push(T valor) {
            if (isFull()) throw new IllegalStateException("La pila está llena.");
            elementos[++top] = valor;
        }
        /** Retira el superior.
         * @return valor retirado
         * @throws IllegalStateException si está vacía
         */
        @SuppressWarnings("unchecked")
        public T pop() {
            if (isEmpty()) throw new IllegalStateException("La pila está vacía.");
            T valor = (T) elementos[top]; elementos[top--] = null; return valor;
        }
        /** Consulta el superior.
         * @return elemento superior
         * @throws IllegalStateException si está vacía
         */
        @SuppressWarnings("unchecked")
        public T peek() {
            if (isEmpty()) throw new IllegalStateException("La pila está vacía.");
            return (T) elementos[top];
        }
        /** Indica si no hay elementos.
         * @return true si está vacía
         */
        public boolean isEmpty() { return top == -1; }
        /** Indica si alcanzó la capacidad.
         * @return true si está llena
         */
        public boolean isFull() { return top == elementos.length - 1; }
        /** Devuelve la cantidad almacenada.
         * @return tamaño de la pila
         */
        public int size() { return top + 1; }
        @Override public String toString() { return Arrays.toString(Arrays.copyOf(elementos, size())); }
    }

    private PilasColasConArreglo05() { }
    /** Permite seleccionar una demostración tipada.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer c = leerEntero(sc, "Capacidad: "); if (c == null) return;
            if (c < 0) { System.out.println("La capacidad debe ser no negativa."); return; }
            System.out.println("Tipo de demo: 1 Integer | 2 String | 3 Producto");
            Integer tipo = leerEntero(sc, "Opción: "); if (tipo == null) return;
            switch (tipo) {
                case 1 -> menu(new Pila<Integer>(c), new Integer[]{10, 20, 30}, sc);
                case 2 -> menu(new Pila<String>(c), new String[]{"primero", "segundo", "tercero"}, sc);
                case 3 -> menu(new Pila<Producto>(c), new Producto[]{new Producto("Cuaderno", 3.5), new Producto("Lápiz", 1.25)}, sc);
                default -> System.out.println("Opción inexistente.");
            }
        }
    }
    private static <T> void menu(Pila<T> pila, T[] ejemplos, Scanner sc) {
        int siguienteEjemplo = 0;
        boolean salir = false;
        while (!salir && sc.hasNextLine()) {
            System.out.println("\n1 push siguiente ejemplo | 2 pop | 3 peek | 4 isEmpty | 5 isFull | 6 size | 7 mostrar | 0 salir");
            Integer op = leerEntero(sc, "Opción: "); if (op == null) break;
            try {
                switch (op) {
                    case 1 -> {
                        if (ejemplos.length == 0) { System.out.println("No hay ejemplos definidos."); break; }
                        T valor = ejemplos[siguienteEjemplo % ejemplos.length]; siguienteEjemplo++;
                        pila.push(valor); System.out.println("Apilado: " + valor);
                    }
                    case 2 -> System.out.println("Desapilado: " + pila.pop());
                    case 3 -> System.out.println("Superior: " + pila.peek());
                    case 4 -> System.out.println("Vacía: " + pila.isEmpty());
                    case 5 -> System.out.println("Llena: " + pila.isFull());
                    case 6 -> System.out.println("Tamaño: " + pila.size());
                    case 7 -> System.out.println("Fondo → superior: " + pila);
                    case 0 -> salir = true;
                    default -> System.out.println("Opción inexistente.");
                }
            } catch (IllegalStateException e) { System.out.println("Operación no realizada: " + e.getMessage()); }
        }
    }
    private static Integer leerEntero(Scanner sc, String mensaje) {
        while (sc.hasNextLine()) { System.out.print(mensaje); try { return Integer.valueOf(sc.nextLine().trim()); } catch (NumberFormatException e) { System.out.println("Ingresá un entero válido."); } }
        return null;
    }
}
// Prompt sin cambios.
