/* Prompt inicial utilizado: Creá una clase separada de Java 21 llamada `Recursividad03` que efectúe la multiplicación de dos enteros no negativos de manera recursiva, sin emplear el operador `*` dentro del algoritmo. Ubicá el contenido total de este prompt como comentario anterior al Javadoc de la clase. Planteá el producto como adiciones sucesivas: en cada invocación decrementá el segundo factor en uno y adicioná el primer factor al valor recursivo. Tomá como caso base el segundo factor igual a 0, con retorno 0. El método debe retornar `int`, impedir factores negativos y documentar consigna, parámetros, resultado, situaciones de error y costo temporal O(b) más costo espacial O(b), donde `b` designa al segundo factor y el espacio alude a la pila. Dejá el cómputo separado de `main`; ensayá con cero en ambas posiciones, con un factor igual a 1 y con dos positivos chicos. Añadí comentarios que describan la reducción. Si retocás este prompt, sumá al final del archivo un comentario que precise la alteración y su causa. */

/**
 * Ejercicio 3 — Multiplicación mediante sumas.
 * <p>Consigna: calcular el producto de dos enteros no negativos sin usar el operador de multiplicación en el algoritmo, representándolo como sumas repetidas.</p>
 * <p>Se reduce el segundo factor b en cada llamada. El caso base b == 0 devuelve 0; en los demás casos se suma a al resultado de multiplicar recursivamente a por b - 1.</p>
 * <p>Complejidad: tiempo O(b) y espacio O(b) por la pila. El resultado debe caber en int y b debe ser suficientemente pequeño para la pila.</p>
 */
public class Recursividad03 {

    private Recursividad03() { }

    /**
     * Calcula el producto como sumas repetidas, sin usar multiplicación en el algoritmo.
     *
     * @param primerFactor primer factor no negativo que se suma repetidamente
     * @param segundoFactor cantidad no negativa de sumas y parámetro que se reduce
     * @return el producto de los factores
     * @throws IllegalArgumentException si cualquiera de los factores es negativo
     */
    public static int multiplicar(int primerFactor, int segundoFactor) {
        if (primerFactor < 0 || segundoFactor < 0) {
            throw new IllegalArgumentException("Ambos factores deben ser enteros no negativos.");
        }
        if (segundoFactor == 0) {
            return 0;
        }

        // Una suma por llamada equivale a repetir el primer factor segundoFactor veces.
        return primerFactor + multiplicar(primerFactor, segundoFactor - 1);
    }

    /**
     * Muestra casos con cero, uno y factores positivos.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 3 — Multiplicación mediante sumas");
        System.out.println("0 por 7 = " + multiplicar(0, 7));
        System.out.println("7 por 0 = " + multiplicar(7, 0));
        System.out.println("6 por 1 = " + multiplicar(6, 1));
        System.out.println("4 por 3 = " + multiplicar(4, 3));
        try {
            multiplicar(-2, 3);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
