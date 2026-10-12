# Especificación técnica — Guía de recursividad

## 1. Objetivo del proyecto

Desarrollar diez ejercicios introductorios sobre recursividad en Java 21. Cada ejercicio debe contar con una solución independiente, una demostración ejecutable y documentación que haga visible el razonamiento recursivo. Además de implementar el algoritmo, se debe redactar un prompt para OpenCode antes de solicitar su generación: el prompt debe explicar el caso base, el caso recursivo y cómo se reduce el problema.

## 2. Requisitos funcionales

### Ejercicio 1 — Factorial
- Calcular recursivamente el factorial de un entero no negativo.
- Definir el caso base para `n == 0` o `n == 1`, cuyo resultado es 1.
- Para `n > 1`, reducir el problema calculando `n` por el factorial de `n - 1`.
- Rechazar entradas negativas con un error claro.
- Usar ejemplos que no excedan la capacidad del tipo numérico elegido.

### Ejercicio 2 — Suma de los primeros N números
- Calcular recursivamente la suma de los enteros desde `n` hasta 1.
- Definir que la suma para `n == 0` es 0.
- Para `n > 0`, combinar `n` con el resultado de sumar desde `n - 1`.
- Rechazar entradas negativas, ya que no pertenecen al rango definido por la consigna.
- Validar al menos los casos 0, 1 y un valor positivo mayor.

### Ejercicio 3 — Multiplicación mediante sumas
- Calcular el producto de dos factores enteros no negativos sin utilizar el operador de multiplicación en el algoritmo recursivo.
- Representar el producto como sumas repetidas, reduciendo en uno el segundo factor en cada llamada.
- Usar como caso base que el factor que se reduce vale 0; el resultado debe ser 0.
- La función debe devolver el producto.
- Rechazar factores negativos para mantener el dominio introductorio definido.
- Probar un factor igual a 0, un factor igual a 1 y dos factores positivos.

### Ejercicio 4 — Potencia
- Calcular recursivamente una potencia sin utilizar `Math.pow`.
- Admitir una base entera y un exponente entero no negativo.
- Definir el caso base como exponente 0, cuyo resultado es 1.
- Para exponentes positivos, reducir el exponente en uno y combinar la base con la potencia del exponente reducido.
- Rechazar exponentes negativos.
- Validar exponente 0, exponente 1, base 0 con exponente positivo y una potencia positiva cuyo resultado quepa en el tipo elegido. Con la definición del caso base, la llamada con base 0 y exponente 0 devuelve 1.

### Ejercicio 5 — Conteo regresivo
- Imprimir recursivamente los valores desde `n` hasta 0, inclusive.
- La operación es de impresión y no necesita devolver un valor; debe modelarse como procedimiento.
- Usar 0 como caso base y reducir `n` en uno en cada llamada.
- Rechazar valores negativos para evitar una recursión que no alcance el caso base.
- Imprimir cada valor antes de realizar la llamada recursiva para obtener el orden descendente esperado.
- Explicar en la documentación que reemplazar la reducción `n - 1` por `n + 1` alejaría la ejecución del caso base y provocaría recursión sin terminación normal; no ejecutar deliberadamente esa variante.
- Probar con 0 y con un valor positivo pequeño.

### Ejercicio 6 — Contar dígitos
- Contar recursivamente los dígitos de un entero positivo.
- Reducir el número mediante división entera por 10.
- Definir el caso base para un valor menor que 10: tiene un dígito.
- Cada llamada debe devolver 1 más que el conteo del número reducido.
- Aceptar solamente valores positivos, de acuerdo con la consigna, e informar claramente si se recibe 0 o un número negativo.
- Probar valores de un dígito, de varios dígitos y valores que contengan ceros internos.

### Ejercicio 7 — Sumar dígitos
- Sumar recursivamente los dígitos de un entero positivo.
- Obtener el último dígito con el operador módulo y reducir el número mediante división entera por 10.
- Definir el caso base cuando el número tiene un solo dígito; la llamada devuelve ese dígito.
- Combinar el último dígito con la suma recursiva del resto.
- Aceptar solamente valores positivos e informar claramente si se recibe 0 o un número negativo.
- Probar valores de un dígito, de varios dígitos y valores que contengan ceros internos.

### Ejercicio 8 — Invertir una palabra
- Devolver un `String` con los caracteres de la palabra en orden inverso, usando recursión.
- Considerar como casos base la cadena vacía y la cadena de un solo carácter; ambas deben resolverse sin llamadas que reduzcan una cadena inexistente.
- Separar el primer carácter del resto, resolver recursivamente el resto y reconstruir el resultado al retornar de la recursión.
- La operación debe preservar todos los caracteres tal como se recibieron; no normalizar espacios, mayúsculas ni signos.
- Rechazar una referencia nula con un error claro; admitir la cadena vacía.
- Probar una palabra de un carácter, una palabra de varios caracteres y la cadena vacía.
- Documentar tiempo O(n²) para la concatenación recursiva de cadenas y espacio O(n) de pila, además de las cadenas temporales creadas durante la reconstrucción.

### Ejercicio 9 — Palíndromo
- Determinar recursivamente si una palabra o frase es palíndromo.
- Comparar el primer y el último carácter de la porción que se está evaluando. Si son distintos, devolver falso; si coinciden, reducir el problema eliminando ambos extremos.
- Considerar como caso base que la porción restante tenga cero o un carácter; en ambos casos devuelve verdadero.
- Antes de comparar, ignorar diferencias entre mayúsculas y minúsculas y omitir los espacios en blanco. Conservar y comparar la puntuación y los acentos: no eliminarlos ni transformarlos.
- Rechazar una referencia nula con un error claro.
- Probar un palíndromo simple, una frase palíndroma con espacios y mayúsculas, una palabra que no sea palíndroma y una cadena vacía.

### Ejercicio 10 — Buscar un elemento en un arreglo
- Buscar recursivamente un entero en un arreglo, sin ciclos en el algoritmo de búsqueda.
- Comenzar en la posición 0 y avanzar una posición por llamada recursiva.
- Devolver el índice de la primera coincidencia; devolver -1 si se alcanza el final sin encontrar el valor.
- Definir como casos base tanto la coincidencia con el valor buscado como el índice fuera de los límites del arreglo.
- Admitir un arreglo vacío, cuyo resultado es -1; rechazar una referencia nula con un error claro.
- Probar elemento al comienzo, elemento al final, valor ausente, arreglo vacío y presencia de valores duplicados para verificar que se informa la primera coincidencia.

## 3. Requisitos no funcionales

- Usar Java 21, sin frameworks ni dependencias externas.
- Mantener los algoritmos simples y apropiados para una guía académica introductoria.
- Separar el algoritmo recursivo de la demostración de consola.
- Usar nombres descriptivos para clases, métodos y variables.
- Incluir ejemplos deterministas en cada `main`; no solicitar datos interactivos.
- Los comentarios y la documentación deben explicar el razonamiento y las decisiones, no repetir mecánicamente cada instrucción.
- Usar `int` para entradas y resultados enteros de los ejercicios, salvo el conteo regresivo y la cadena invertida, que no devuelven resultado numérico. Los ejemplos deben mantenerse dentro del rango representable y evitar desbordamientos.
- No se exige optimización para entradas grandes: la profundidad de recursión está limitada por la pila de ejecución de Java. Los ejemplos deben ser pequeños y la documentación debe advertir que los métodos no son adecuados para valores que produzcan una profundidad excesiva.
- Ante un argumento que incumpla el dominio requerido (incluidas referencias nulas cuando se prohíben), los métodos deben lanzar `IllegalArgumentException` con un mensaje claro.

## 4. Restricciones

- Implementar los diez algoritmos mediante recursión; no sustituirlos por ciclos, streams o bibliotecas que resuelvan el ejercicio.
- En el ejercicio 3, no utilizar el operador `*` dentro del algoritmo de multiplicación recursiva; se permite describir el producto mediante sumas repetidas.
- En el ejercicio 4, no utilizar `Math.pow`.
- En el ejercicio 10, no usar `for`, `while`, streams ni otra iteración para recorrer el arreglo desde el algoritmo de búsqueda.
- No agregar menús centrales, lectura interactiva, archivos de datos ni funcionalidades ajenas a la consigna.
- Los ejercicios deben ser independientes: una clase no debe depender de otra clase de ejercicio.
- Los prompts iniciales usados para generar las soluciones deben documentarse en el propio archivo fuente como comentario al comienzo. Si se modifica un prompt durante el desarrollo, se debe agregar al final del archivo un comentario que describa qué se cambió y por qué.

## 5. Lenguaje y versión

- Lenguaje: Java.
- Versión objetivo: Java 21.
- Interacción: ejemplos predefinidos en `main`, con resultados impresos por consola.
- Plataforma: ejecución estándar de Java; no se requiere interfaz gráfica ni persistencia.

## 6. Estructura general del proyecto

Crear una clase pública independiente por ejercicio dentro de `guias/recursividad/src/`, con estos nombres propuestos:

1. `Recursividad01`
2. `Recursividad02`
3. `Recursividad03`
4. `Recursividad04`
5. `Recursividad05`
6. `Recursividad06`
7. `Recursividad07`
8. `Recursividad08`
9. `Recursividad09`
10. `Recursividad10`

Mantener `ESPECIFICACION.md` y `PROMPTS.md` en `guias/recursividad/`. Cada clase debe compilarse y ejecutarse de forma independiente, sin requerir un menú central.

## 7. Clases y responsabilidades

Cada clase de ejercicio debe:
- Contener el algoritmo recursivo del ejercicio y, si hace falta, un método auxiliar privado para conservar el estado de la recursión.
- Separar el cálculo o búsqueda principal de la demostración en `main`.
- Incluir un `main` con los casos de prueba representativos indicados en esta especificación y mostrar resultados legibles.
- Incluir Javadoc de clase con la consigna correspondiente, propósito, estrategia recursiva y complejidad temporal y espacial cuando corresponda.
- Documentar con Javadoc cada método público, incluidos propósito, parámetros, valor devuelto, efectos laterales y condiciones de error.
- Explicar explícitamente el caso base, el caso recursivo, cómo se reduce el problema y cómo se combinan los resultados.
- Incluir comentarios que expliquen la pila de llamadas o el retorno de la recursión, especialmente en los ejercicios de inversión de palabra, suma de dígitos, palíndromo y búsqueda.
- Tener al comienzo un comentario con el prompt inicial completo utilizado para solicitar la generación de esa clase. Ese comentario debe permitir reconocer el prompt evaluado en la consigna.
- Si el prompt se modifica durante la resolución, cerrar el archivo con un comentario que enumere el cambio realizado y su motivo. Si no se modifica, no inventar una modificación.

## 8. Relaciones entre componentes

Las diez clases son independientes y no comparten estado. `PROMPTS.md` contiene los diez prompts completos, uno por ejercicio, listos para copiar y usar en OpenCode. Los prompts deben coincidir con los nombres de clase, restricciones y casos de prueba de esta especificación. Cada archivo Java conserva en un comentario el prompt inicial realmente utilizado; el contenido de ese comentario debe coincidir con el prompt correspondiente salvo que el archivo documente al final las modificaciones efectuadas.

## 9. Estructuras de datos

- Ejercicios 1–7: valores enteros primitivos (`int`).
- Ejercicios 8–9: cadenas (`String`) y posiciones de caracteres.
- Ejercicio 10: arreglo de enteros (`int[]`) y un índice que avanza recursivamente.
- No introducir colecciones u otras estructuras de datos para reemplazar el razonamiento recursivo requerido.

## 10. Flujo principal del sistema

1. Elegir una clase de ejercicio y ejecutar su `main`.
2. El `main` prepara entradas pequeñas y representativas.
3. El programa invoca el método recursivo separado de la demostración.
4. El método resuelve los casos base y reduce cada caso recursivo hasta alcanzarlos.
5. El resultado se muestra en consola; el conteo regresivo imprime la secuencia durante su ejecución.
6. Las entradas fuera del dominio especificado se rechazan de manera clara y segura.

## 11. Manejo de errores y excepciones

- Factorial y suma de los primeros N: rechazar entradas negativas.
- Multiplicación: rechazar factores negativos.
- Potencia: rechazar exponentes negativos.
- Conteo regresivo: rechazar valores negativos.
- Conteo y suma de dígitos: rechazar cero y valores negativos porque la consigna define un entero positivo.
- Inversión de palabra y palíndromo: rechazar `null`; aceptar cadenas vacías según los resultados descritos.
- Búsqueda: rechazar arreglo `null`; aceptar arreglo vacío con resultado -1.
- No se requieren recuperaciones silenciosas ni resultados sustitutos ante datos inválidos.
- El mecanismo uniforme para señalar un argumento inválido es `IllegalArgumentException` con un mensaje descriptivo.
- Los ejemplos ordinarios no deben provocar desbordamiento aritmético ni agotar la pila. Las limitaciones de rango y profundidad deben documentarse.

## 12. Casos límite

- Factorial: 0, 1, valor pequeño positivo y negativo rechazado.
- Suma: 0, 1, valor positivo pequeño y negativo rechazado.
- Multiplicación: factor cero en cada posición, factor uno, factores positivos y negativo rechazado.
- Potencia: exponente 0, exponente 1, base 0 con exponente positivo, base negativa con exponente positivo y exponente negativo rechazado.
- Conteo regresivo: 0, valor positivo pequeño y negativo rechazado.
- Conteo/suma de dígitos: un dígito, varios dígitos, cero interno, cero y negativo rechazados.
- Inversión: cadena vacía, un carácter y varios caracteres.
- Palíndromo: cadena vacía, un carácter, palíndromo con espacios y diferencias de mayúsculas, texto no palíndromo y puntuación conservada al comparar.
- Búsqueda: arreglo vacío, coincidencia inicial, coincidencia final, elemento ausente, repetidos y arreglo nulo rechazado.

## 13. Entrada y salida

- Entrada: ejemplos declarados en cada `main`; no se requiere `Scanner`, archivos ni base de datos.
- Salida: texto claro por consola que identifique ejercicio, datos de prueba y resultado.
- Ejercicio 5 imprime desde el valor inicial hasta 0, en orden descendente e incluyendo ambos extremos.
- Ejercicio 10 muestra el índice de la primera coincidencia o -1.
- En los ejercicios que prueben entradas inválidas, el ejemplo debe capturar o demostrar el error sin impedir que se ejecuten los demás casos.

## 14. Orden recomendado de implementación

1. Crear las diez clases independientes y agregar a cada una el prompt inicial como comentario, la consigna como Javadoc y una demostración en `main`.
2. Implementar factorial y suma de los primeros N para establecer el patrón de caso base y reducción.
3. Implementar multiplicación y potencia, verificando que la llamada recursiva reduzca el parámetro acordado.
4. Implementar conteo regresivo, conteo de dígitos y suma de dígitos.
5. Implementar inversión de palabra y palíndromo, documentando la reducción de cadenas y la reconstrucción al retornar.
6. Implementar búsqueda recursiva con posición inicial y condición de fin del arreglo.
7. Completar `PROMPTS.md` con los diez prompts alineados con el alcance, los nombres de clase y las pruebas.
8. Compilar cada clase con Java 21, ejecutar los casos válidos y verificar el manejo de entradas inválidas.
9. Revisar Javadocs y confirmar que cualquier modificación del prompt se describa al final del archivo fuente.

## 15. Criterios de aceptación

- Hay diez clases independientes con los nombres definidos en esta especificación; cada una compila y se puede ejecutar con Java 21.
- Cada ejercicio usa recursión de forma efectiva y cumple su caso base, reducción y resultado establecidos.
- Se respetan las restricciones de no usar `*` en la multiplicación recursiva, no usar `Math.pow` y no usar ciclos para la búsqueda del arreglo.
- Se demuestran los casos ordinarios y límites especificados sin desbordamientos ni profundidades excesivas.
- Los datos fuera del dominio se rechazan según las reglas documentadas.
- Cada fuente Java incluye la consigna en Javadoc, documentación de los métodos públicos y comentarios explicativos de la recursión.
- El comentario inicial de cada archivo contiene el prompt utilizado para generar la solución; toda modificación de ese prompt queda explicada en un comentario al final.
- `PROMPTS.md` contiene diez prompts completos e independientes para OpenCode, consistentes con esta especificación.
- No se agregan frameworks, dependencias, entrada interactiva ni funcionalidades no solicitadas.
