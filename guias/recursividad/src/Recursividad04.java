/* Prompt inicial utilizado: Creá en Java 21 una clase aislada de nombre `Recursividad04` destinada a elevar un entero a una potencia usando recursividad y sin recurrir a `Math.pow`. Situá este prompt íntegro como comentario antes del Javadoc de la clase. Aceptá una base `int` cualquiera junto con un exponente no negativo. Establecé como caso base el exponente 0 con retorno 1; de ahí que, para esta función, `0` elevado a `0` también retorne 1. En la rama recursiva, decrementá el exponente en uno y combiná la base con lo obtenido. El método retorna `int`; desestimá exponentes negativos y elegí muestras cuyos valores entren en un `int`. En el Javadoc dejá constancia de consigna, estrategia, parámetros, resultado, error y costos temporal O(e) y espacial O(e) por la pila. Dentro de `main` ensayá exponente 0, exponente 1, base 0 con exponente positivo, base negativa con exponente positivo y una potencia positiva chica. Explicá con comentarios el caso base y el retorno recursivo. Si tocás este prompt, agregá al cierre del archivo un comentario que detalle la modificación y su motivo. */

/**
 * Ejercicio 4 — Potencia.
 * <p>Consigna: calcular recursivamente una potencia entera sin usar Math.pow.</p>
 * <p>El caso base es exponente 0 y devuelve 1, también para 0 elevado a 0. Para un exponente positivo, se reduce en uno y se combina la base con el resultado de la llamada siguiente.</p>
 * <p>Complejidad: tiempo O(e) y espacio O(e) por la pila de llamadas. Se admiten resultados representables en int; la recursión no está pensada para exponentes grandes.</p>
 */
public class Recursividad04 {

    private Recursividad04() { }

    /**
     * Calcula base elevada a exponente mediante multiplicaciones recursivas.
     *
     * @param base base entera de la potencia
     * @param exponente exponente no negativo
     * @return base elevada a exponente; devuelve 1 si el exponente es 0
     * @throws IllegalArgumentException si el exponente es negativo
     */
    public static int potencia(int base, int exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente debe ser no negativo.");
        }
        if (exponente == 0) {
            return 1;
        }

        // Se reduce el exponente; la base se combina al retornar de la llamada más pequeña.
        return base * potencia(base, exponente - 1);
    }

    /**
     * Muestra casos límite y una potencia positiva pequeña.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 4 — Potencia");
        System.out.println("0^0 = " + potencia(0, 0));
        System.out.println("5^0 = " + potencia(5, 0));
        System.out.println("5^1 = " + potencia(5, 1));
        System.out.println("0^4 = " + potencia(0, 4));
        System.out.println("(-2)^3 = " + potencia(-2, 3));
        System.out.println("3^4 = " + potencia(3, 4));
        try {
            potencia(2, -1);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
