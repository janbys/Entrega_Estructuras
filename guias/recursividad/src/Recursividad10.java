/* Prompt inicial utilizado: Creá en Java 21 una clase separada de nombre `Recursividad10` que localice un entero dentro de un arreglo `int[]` sin ciclos en la rutina de búsqueda. Ubicá este prompt entero como comentario antes del Javadoc de la clase. Partí del índice 0 y desplazate una posición por invocación recursiva. Retorná el índice del primer hallazgo; retorná -1 al arribar al final sin éxito. Adoptá como casos base tanto el encuentro del valor como la llegada a un índice fuera de rango. Tolerá arreglos vacíos e invalidá la referencia `null` con un error preciso. Detallá en Javadoc la consigna, el avance del índice, los parámetros, el resultado, el error y los costos temporal O(n) y espacial O(n) por la pila. Desligá la búsqueda de `main`; comprobá coincidencia inicial, coincidencia final, elemento faltante, arreglo vacío y repetidos para constatar que se informa la primera posición. No emplees `for`, `while`, streams ni rastreo iterativo. Si modificás este prompt, agregá al final del archivo un comentario que describa el cambio y su porqué. */

/**
 * Ejercicio 10 — Buscar un elemento en un arreglo.
 * <p>Consigna: buscar recursivamente un entero en un arreglo sin ciclos y devolver el índice de la primera coincidencia.</p>
 * <p>La búsqueda empieza en el índice 0. Cada llamada examina una posición y avanza al índice siguiente; encontrar el valor devuelve su índice y alcanzar la longitud devuelve -1.</p>
 * <p>Complejidad: tiempo O(n) y espacio O(n) por la pila en el peor caso. Un arreglo vacío devuelve -1. La profundidad de pila limita arreglos extremadamente grandes.</p>
 */
public class Recursividad10 {

    private Recursividad10() { }

    /**
     * Busca la primera aparición del objetivo, comenzando desde el índice cero.
     *
     * @param arreglo arreglo donde se realiza la búsqueda; puede estar vacío
     * @param objetivo entero buscado
     * @return índice de la primera coincidencia o -1 si no se encuentra
     * @throws IllegalArgumentException si arreglo es null
     */
    public static int buscar(int[] arreglo, int objetivo) {
        if (arreglo == null) {
            throw new IllegalArgumentException("El arreglo no puede ser null.");
        }
        return buscarDesde(arreglo, objetivo, 0);
    }

    /**
     * Busca a partir de una posición y retorna la primera coincidencia.
     *
     * @param arreglo arreglo donde se busca
     * @param objetivo valor buscado
     * @param indice posición que se examinará
     * @return primera posición coincidente desde indice o -1
     */
    private static int buscarDesde(int[] arreglo, int objetivo, int indice) {
        if (indice == arreglo.length) {
            return -1;
        }
        if (arreglo[indice] == objetivo) {
            return indice;
        }

        // Si esta posición no coincide, la llamada siguiente examina exactamente la posición posterior.
        return buscarDesde(arreglo, objetivo, indice + 1);
    }

    /**
     * Muestra búsquedas al inicio y final, ausencia, arreglo vacío y duplicados.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[] valores = {4, 8, 8, 12, 19};
        System.out.println("Ejercicio 10 — Búsqueda recursiva");
        System.out.println("Índice de 4 (inicio): " + buscar(valores, 4));
        System.out.println("Índice de 19 (final): " + buscar(valores, 19));
        System.out.println("Índice de 7 (ausente): " + buscar(valores, 7));
        System.out.println("Índice en arreglo vacío: " + buscar(new int[0], 7));
        System.out.println("Primera aparición de 8: " + buscar(valores, 8));
        try {
            buscar(null, 4);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
