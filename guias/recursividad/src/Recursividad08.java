/* Prompt inicial utilizado: Creá en Java 21 una clase aislada denominada `Recursividad08` que dé vuelta un `String` mediante recursión. Colocá este prompt íntegro como comentario previo al Javadoc de la clase. Tratá a la cadena vacía y a la de un solo carácter como casos base. En la rama recursiva, desprendé el primer carácter del resto, dalo vuelta recursivamente al resto y reubicá el primer carácter al cierre del resultado por concatenación. Respetá tal cual los caracteres de entrada; no uniformes espacios, mayúsculas ni signos. Impugnás `null` con `IllegalArgumentException` y tolerá la cadena vacía. El método entrega el `String` invertido. Consigná en Javadoc consigna, estrategia, parámetros, resultado, error, tiempo O(n²) por la concatenación reiterada y espacio O(n) de pila, junto con las cadenas provisorias generadas al reconstruir. Apartá la demostración en `main` y verificá cadena vacía, un carácter y una palabra de varios caracteres. Comentá la reconstrucción de la respuesta durante el retorno. Si retocás este prompt, dejá al final del archivo un comentario que indique lo cambiado y por qué. */

/**
 * Ejercicio 8 — Invertir una palabra.
 * <p>Consigna: devolver recursivamente un String con los caracteres de la palabra en orden inverso, preservando exactamente su contenido.</p>
 * <p>La cadena vacía y la de un carácter son casos base. En otro caso se invierte recursivamente el resto y, al retornar, se agrega al final el primer carácter.</p>
 * <p>Para n caracteres, el tiempo es O(n²) por las concatenaciones sucesivas; la pila ocupa O(n). La reconstrucción también crea cadenas temporales. Una cadena extremadamente larga puede consumir demasiada pila y memoria.</p>
 */
public class Recursividad08 {

    private Recursividad08() { }

    /**
     * Devuelve la cadena recibida con sus caracteres en orden inverso.
     *
     * @param texto cadena que se desea invertir, sin normalizar sus caracteres
     * @return cadena invertida; si texto es vacía, devuelve la cadena vacía
     * @throws IllegalArgumentException si texto es null
     */
    public static String invertir(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("La cadena no puede ser null.");
        }
        if (texto.length() <= 1) {
            return texto;
        }

        char primerCaracter = texto.charAt(0);
        String restoInvertido = invertir(texto.substring(1));
        // La llamada resuelve primero el resto; al retornar se mueve el primer carácter al final.
        return restoInvertido + primerCaracter;
    }

    /**
     * Muestra los casos de cadena vacía, un carácter y una palabra.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 8 — Invertir una palabra");
        System.out.println("Cadena vacía -> [" + invertir("") + "]");
        System.out.println("'A' -> " + invertir("A"));
        System.out.println("'recursion' -> " + invertir("recursion"));
        try {
            invertir(null);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
