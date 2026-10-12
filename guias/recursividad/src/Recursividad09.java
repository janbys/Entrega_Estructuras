/* Prompt inicial utilizado: Creá una clase independiente de Java 21 llamada `Recursividad09` que resuelva recursivamente si una palabra o frase resulta palíndroma. Anteponé el texto completo de este prompt como comentario al Javadoc de la clase. Pasá por alto las diferencias de mayúsculas y minúsculas y salteá los espacios en blanco al cotejar. Mantené la puntuación y los tildes: no los quites ni los conviertas. Cotejá los extremos del fragmento vigente; ante una disparidad devolvé falso; ante coincidencia, acortá el fragmento suprimiendo ambos extremos. Con cero o un carácter remanente, devolvé verdadero. Rechazá `null` con un error nítido y admití la cadena vacía. Documentá consigna, normalización exacta, reducción, parámetros, resultado, error y costos temporal O(n) y espacial O(n) por las invocaciones recursivas. Sumá ensayos con una palabra palíndroma, una frase palíndroma con espacios y mayúsculas, una palabra no palíndroma y la cadena vacía. No suprimas puntuación ni tildes para imponer un resultado. Si alterás este prompt, añadí al cierre del archivo un comentario que aclare la enmienda y su causa. */

/**
 * Ejercicio 9 — Palíndromo.
 * <p>Consigna: determinar recursivamente si una palabra o frase se lee igual de izquierda a derecha y de derecha a izquierda.</p>
 * <p>La comparación ignora mayúsculas/minúsculas y omite espacios en blanco, pero conserva puntuación y acentos. Se comparan los extremos; ante una diferencia se devuelve falso y, si coinciden, se reduce el intervalo hacia el centro. Cero o un carácter restante es el caso base verdadero.</p>
 * <p>Complejidad: tiempo O(n) y espacio O(n) por las llamadas recursivas, donde n es la longitud UTF-16 de la cadena.</p>
 */
public class Recursividad09 {

    private Recursividad09() { }

    /**
     * Determina recursivamente si el texto es palíndromo, ignorando espacios y diferencias de mayúsculas.
     *
     * @param texto palabra o frase a comprobar; se permiten cadenas vacías
     * @return true si es palíndromo bajo las reglas de comparación, false en caso contrario
     * @throws IllegalArgumentException si texto es null
     */
    public static boolean esPalindromo(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("La cadena no puede ser null.");
        }
        return compararExtremos(texto, 0, texto.length() - 1);
    }

    /**
     * Compara recursivamente extremos de la porción activa, omitiendo espacios.
     *
     * @param texto cadena examinada
     * @param inicio índice inicial de la porción
     * @param fin índice final de la porción
     * @return true si la porción satisface la condición de palíndromo
     */
    private static boolean compararExtremos(String texto, int inicio, int fin) {
        if (inicio >= fin) {
            return true;
        }
        if (Character.isWhitespace(texto.charAt(inicio))) {
            return compararExtremos(texto, inicio + 1, fin);
        }
        if (Character.isWhitespace(texto.charAt(fin))) {
            return compararExtremos(texto, inicio, fin - 1);
        }

        char izquierda = Character.toLowerCase(texto.charAt(inicio));
        char derecha = Character.toLowerCase(texto.charAt(fin));
        if (izquierda != derecha) {
            return false;
        }

        // Los extremos coinciden; se resuelve recursivamente la parte interior.
        return compararExtremos(texto, inicio + 1, fin - 1);
    }

    /**
     * Muestra ejemplos de palíndromos y no-palíndromos con las reglas indicadas.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 9 — Palíndromo");
        System.out.println("'radar': " + esPalindromo("radar"));
        System.out.println("'Anita lava la tina': " + esPalindromo("Anita lava la tina"));
        System.out.println("'casa': " + esPalindromo("casa"));
        System.out.println("Cadena vacía: " + esPalindromo(""));
        System.out.println("'a,ba' (se conserva la coma): " + esPalindromo("a,ba"));
        try {
            esPalindromo(null);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
