import java.util.Arrays;

/**
 * Ejercicio 7 — Invertir un vector.
 * <p>Consigna: Construí un prompt para OpenCode que solicite dos versiones Java para invertir un vector: una con vector auxiliar y otra sobre el mismo vector sin memoria adicional significativa. Pedí comparar ventajas, desventajas y complejidades temporal y espacial.</p>
 * <p>Estrategia auxiliar: copiar desde el final hacia un nuevo arreglo; tiempo O(n), espacio O(n), preserva el original. Estrategia in-place: intercambiar extremos hasta el centro; tiempo O(n), espacio O(1), modifica el original.</p>
 */
public class AnalisisDeAlgoritmos07 {

    /** Evita instancias; los algoritmos de esta clase son estáticos. */
    private AnalisisDeAlgoritmos07() { }

    /**
     * Crea y devuelve una copia de los elementos en orden inverso.
     *
     * @param vector arreglo original, que no se modifica
     * @return nuevo arreglo invertido
     * @throws IllegalArgumentException si el vector es nulo
     */
    public static int[] invertirConAuxiliar(int[] vector) {
        validar(vector);
        int[] invertido = new int[vector.length];
        for (int i = 0; i < vector.length; i++) {
            invertido[i] = vector[vector.length - 1 - i];
        }
        return invertido;
    }

    /**
     * Invierte el arreglo recibido mediante intercambios in-place.
     *
     * @param vector arreglo que se modificará directamente
     * @throws IllegalArgumentException si el vector es nulo
     */
    public static void invertirInPlace(int[] vector) {
        validar(vector);
        int izquierda = 0;
        int derecha = vector.length - 1;
        while (izquierda < derecha) {
            int temporal = vector[izquierda];
            vector[izquierda] = vector[derecha];
            vector[derecha] = temporal;
            izquierda++;
            derecha--;
        }
    }

    /** Compara las dos estrategias con vectores de longitud par e impar.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        demostrar(new int[]{1, 2, 3, 4});
        demostrar(new int[]{5, 6, 7});
        demostrar(new int[0]);
        System.out.println("Auxiliar: preserva el original, pero usa O(n) espacio.");
        System.out.println("In-place: modifica el original y usa O(1) espacio adicional.");
    }

    /** Muestra ambas salidas sin reutilizar el arreglo mutado. */
    private static void demostrar(int[] entrada) {
        int[] copia = Arrays.copyOf(entrada, entrada.length);
        int[] auxiliar = invertirConAuxiliar(entrada);
        invertirInPlace(copia);
        System.out.println("Entrada: " + Arrays.toString(entrada)
                + " | auxiliar: " + Arrays.toString(auxiliar)
                + " | in-place: " + Arrays.toString(copia));
    }

    /** Valida las entradas compartidas por los dos métodos de inversión. */
    private static void validar(int[] vector) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser nulo.");
        }
    }
}
