/* Prompt inicial utilizado: Creá en Java 21 una clase independiente llamada `Recursividad06` orientada a contar por recursión los dígitos de un entero positivo. Insertá este prompt completo como comentario delante del Javadoc de la clase. Achicá el número con división entera entre 10. Considerá caso base a todo valor menor que 10, que posee un dígito; cada invocación recursiva aporta 1 más el conteo del número ya reducido. Admití únicamente valores positivos y señalá con un error nítido el 0 o los negativos. El método retorna `int`. Dejá en Javadoc la consigna, la reducción, los parámetros, el resultado, el error y los costos temporal O(d) y espacial O(d), donde `d` es la cantidad de dígitos. Conservá el método separado de `main` y comprobá un dígito, varios dígitos y un número con ceros interiores. No contabilices con ciclos. Si enmendás este prompt, agregá al final del archivo un comentario que exponga el ajuste y su razón. */

/**
 * Ejercicio 6 — Contar dígitos.
 * <p>Consigna: contar recursivamente los dígitos de un entero positivo.</p>
 * <p>El caso base es un valor menor que 10, que contiene un dígito. En cada caso recursivo la división entera por 10 elimina el último dígito y la llamada suma 1 al conteo restante.</p>
 * <p>Complejidad para un número de d dígitos: tiempo O(d) y espacio O(d) por la pila. La recursión no es adecuada para profundidades excesivas.</p>
 */
public class Recursividad06 {

    private Recursividad06() { }

    /**
     * Cuenta los dígitos de un entero positivo mediante división recursiva por 10.
     *
     * @param numero entero positivo
     * @return cantidad de dígitos decimales de numero
     * @throws IllegalArgumentException si numero es cero o negativo
     */
    public static int contar(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El número debe ser un entero positivo.");
        }
        if (numero < 10) {
            return 1;
        }

        // La división entera elimina el dígito final y reduce el problema.
        return 1 + contar(numero / 10);
    }

    /**
     * Muestra ejemplos de uno y varios dígitos, incluidos ceros internos.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 6 — Contar dígitos");
        System.out.println("7 tiene " + contar(7) + " dígito(s).");
        System.out.println("48321 tiene " + contar(48321) + " dígitos.");
        System.out.println("40506 tiene " + contar(40506) + " dígitos.");
        try {
            contar(0);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
        try {
            contar(-24);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
