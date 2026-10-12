/* Prompt inicial utilizado: Creá una clase autónoma de Java 21 de nombre `Recursividad07` que adicione recursivamente los dígitos de un entero positivo. Prependé como comentario el contenido total de este prompt antes del Javadoc de la clase. Extraé el último dígito con módulo 10 y acortá el número con división entera entre 10. Tomá como caso base el número de un único dígito y retorná dicho dígito; en la rama recursiva, adicioná el último dígito a lo calculado para el resto del número. Recibí solo valores positivos y objetá con un error preciso el 0 o los negativos. El método retorna `int`. Documentá consigna, estrategia, parámetros, resultado, errores y costos temporal O(d) y espacial O(d) por la pila. Agregá ensayos con un dígito, con varios dígitos y con ceros interiores. Comentá el modo en que se fusionan los parciales durante el retorno; evitá ciclos para sumar. Si cambiás este prompt, incorporá al final del archivo un comentario que señale la variación y su motivo. */

/**
 * Ejercicio 7 — Sumar dígitos.
 * <p>Consigna: sumar recursivamente los dígitos de un entero positivo.</p>
 * <p>El caso base ocurre cuando queda un solo dígito y devuelve ese valor. En los demás casos, el módulo 10 obtiene el último dígito, la división entera por 10 reduce el número y, al retornar, se suman ambos resultados.</p>
 * <p>Complejidad para un número de d dígitos: tiempo O(d) y espacio O(d) debido a la pila de llamadas.</p>
 */
public class Recursividad07 {

    private Recursividad07() { }

    /**
     * Suma los dígitos de un entero positivo mediante recursión.
     *
     * @param numero entero positivo
     * @return suma de sus dígitos decimales
     * @throws IllegalArgumentException si numero es cero o negativo
     */
    public static int sumar(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El número debe ser un entero positivo.");
        }
        if (numero < 10) {
            return numero;
        }

        int ultimoDigito = numero % 10;
        int restoDelNumero = numero / 10;
        // Al retornar, se agrega el dígito separado a la suma del resto.
        return ultimoDigito + sumar(restoDelNumero);
    }

    /**
     * Muestra ejemplos con un dígito, varios dígitos y ceros internos.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 7 — Sumar dígitos");
        System.out.println("Suma de dígitos de 8: " + sumar(8));
        System.out.println("Suma de dígitos de 48321: " + sumar(48321));
        System.out.println("Suma de dígitos de 40506: " + sumar(40506));
        try {
            sumar(0);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
        try {
            sumar(-24);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
