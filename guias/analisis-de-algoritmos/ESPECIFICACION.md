# Especificación técnica — Guía de ejercicios de algoritmos

## 1. Objetivo del proyecto

Completar los diez ejercicios de la guía sobre vectores, matrices y ordenamiento en Java 21. Para cada ejercicio se debe entregar una implementación independiente, documentada y acompañada por un prompt listo para solicitar su desarrollo a OpenCode. Cada solución debe poder leerse, compilarse y ejecutarse de manera independiente.

## 2. Requisitos funcionales

### Ejercicio 1 — Encontrar el mínimo de un vector
- Implementar un algoritmo que encuentre el menor entero de un vector.
- Usar un recorrido lineal, mantener el mínimo encontrado y actualizarlo al hallar un valor menor.
- Explicar en la documentación por qué ordenar el vector no es necesario.
- Complejidad esperada: tiempo $O(n)$ y espacio adicional $O(1)$.
- Definir y demostrar un comportamiento explícito ante un vector vacío; se debe informar el error sin intentar acceder a una posición inexistente.

### Ejercicio 2 — Buscar un elemento en un vector desordenado
- Implementar búsqueda lineal de un entero en un vector sin ordenar.
- Informar si el valor fue encontrado y cuántas posiciones se inspeccionaron hasta hallarlo o concluir que no existe. La cuenta debe incluir cada elemento efectivamente examinado; si no se encuentra, debe ser el largo del vector.
- Explicar la estrategia y analizar mejor, peor y caso promedio. Indicar las condiciones usadas para el análisis promedio.
- Complejidad esperada: mejor caso $O(1)$; peor caso $O(n)$; promedio $O(n)$ bajo una distribución uniforme de la posición del elemento buscado. Espacio adicional $O(1)$.

### Ejercicio 3 — Buscar un elemento en un vector ordenado
- Implementar búsqueda binaria iterativa sobre un vector ordenado ascendentemente.
- Mostrar en cada iteración los límites de búsqueda, el índice central y la decisión tomada para actualizar el intervalo.
- Explicar por qué la búsqueda binaria es más eficiente que la lineal cuando los datos están ordenados.
- Complejidad esperada: tiempo $O(\log n)$ y espacio adicional $O(1)$.
- Indicar como precondición que el vector de entrada está ordenado; el algoritmo no necesita ordenarlo.

### Ejercicio 4 — Detectar elementos duplicados
- Implementar dos soluciones que determinen e informen si existe al menos un valor repetido:
  1. Comparación de pares mediante dos ciclos anidados, sin comparar una posición consigo misma.
  2. Recorrido con una estructura `HashSet`, detectando cuando un valor ya fue agregado.
- Ambas soluciones deben dar resultados equivalentes.
- Comparar complejidad temporal y espacial.
- Complejidad esperada: ciclos anidados $O(n^2)$ en peor caso y $O(1)$ de espacio adicional; `HashSet` $O(n)$ esperado en tiempo y $O(n)$ de espacio adicional.

### Ejercicio 5 — Contar ocurrencias
- Contar cuántas veces aparece un entero determinado en un vector.
- Recorrer el vector completo, ya que para conocer el total no alcanza con encontrar la primera coincidencia.
- Informar el conteo. Un vector vacío produce conteo cero.
- Complejidad esperada: tiempo $O(n)$ y espacio adicional $O(1)$.

### Ejercicio 6 — Comparar dos vectores
- Determinar si dos vectores de enteros son iguales: deben tener la misma longitud y los mismos valores en las posiciones correspondientes.
- Finalizar inmediatamente al encontrar una diferencia, incluso cuando la diferencia sea que sus longitudes no coinciden.
- Analizar mejor, peor y caso promedio, explicitando las condiciones del caso promedio.
- Complejidad esperada: mejor caso $O(1)$; peor caso $O(n)$; espacio adicional $O(1)$, donde $n$ es la longitud comparable.

### Ejercicio 7 — Invertir un vector
- Implementar dos versiones que inviertan el orden de los elementos:
  1. Crear y devolver un vector auxiliar con los elementos en orden inverso, sin modificar el original.
  2. Invertir el mismo vector intercambiando extremos hacia el centro, sin crear otra estructura proporcional a la entrada.
- Comparar ventajas, desventajas y complejidades.
- Complejidad esperada de ambas versiones: tiempo $O(n)$; espacio adicional $O(n)$ para la versión auxiliar y $O(1)$ para la versión in-place.
- La versión in-place modifica el vector recibido.

### Ejercicio 8 — Sumar todos los elementos de una matriz
- Calcular la suma de todos los elementos de una matriz de enteros recorriendo fila por fila y columna por columna.
- Mostrar el resultado y un contador de operaciones.
- Para que el contador sea reproducible, definir una operación contabilizada como cada suma de un elemento de la matriz al acumulador; por lo tanto, equivale a la cantidad de elementos procesados.
- Complejidad esperada: tiempo $O(f \cdot c)$ y espacio adicional $O(1)$ para una matriz de $f$ filas y $c$ columnas.

### Ejercicio 9 — Encontrar el mayor elemento de una matriz
- Encontrar el mayor entero de una matriz mediante un recorrido completo de sus elementos.
- Explicar que, sin información adicional sobre los valores, no se puede asegurar el máximo sin examinar todos los elementos.
- Complejidad esperada: tiempo $O(f \cdot c)$ y espacio adicional $O(1)$.
- Definir un comportamiento explícito ante una matriz sin elementos e informar el error de manera segura.

### Ejercicio 10 — Ordenamiento burbuja
- Implementar Bubble Sort para ordenar un vector de enteros en orden ascendente.
- Contabilizar e informar comparaciones e intercambios.
- Explicar que es principalmente adecuado para enseñar ordenamiento o para conjuntos pequeños, debido a su crecimiento cuadrático en los casos promedio y peor.
- Usar una variante con finalización anticipada cuando una pasada completa no realiza intercambios; documentar que, con esta optimización, el mejor caso es $O(n)$ y los casos promedio y peor son $O(n^2)$. Espacio adicional $O(1)$.

## 3. Requisitos no funcionales

- Usar Java 21, sin frameworks ni bibliotecas externas.
- Mantener soluciones sencillas, apropiadas para una guía académica introductoria.
- Utilizar nombres descriptivos para clases, métodos y variables.
- Mostrar por consola los resultados y las trazas solicitadas por cada ejercicio.
- Evitar que una salida de ejemplo sea necesaria para entender el algoritmo: los algoritmos principales deben estar en métodos separados del código de demostración.

## 4. Restricciones

- Usar arreglos de Java (`int[]` para vectores y `int[][]` para matrices); no reemplazarlos por colecciones, excepto `HashSet` en la segunda solución del ejercicio 4.
- No ordenar los datos como paso previo en los ejercicios 1, 2, 5, 6, 8 o 9.
- La búsqueda binaria del ejercicio 3 recibe un arreglo previamente ordenado.
- En el ejercicio 7, solo la primera versión debe usar un arreglo auxiliar proporcional al tamaño de entrada.
- No incorporar funcionalidades o dependencias fuera de lo requerido por la guía.

## 5. Lenguaje y versión

- Lenguaje: Java.
- Versión: Java 21.
- Interacción: demostraciones con datos de ejemplo declarados en el `main` y resultados por consola; no solicitar datos interactivos al usuario.

## 6. Estructura general del proyecto

Crear una clase pública independiente para cada ejercicio dentro de `guias/analisis-de-algoritmos/src/`, con nombres descriptivos, por ejemplo `AnalisisDeAlgoritmos01`, `AnalisisDeAlgoritmos02`, hasta `AnalisisDeAlgoritmos10`. Cada archivo debe poder compilarse y ejecutarse individualmente, sin requerir un menú central.

Mantener `ESPECIFICACION.md` y `PROMPTS.md` dentro de `guias/analisis-de-algoritmos/`. El archivo `PROMPTS.md` tendrá diez secciones, una por ejercicio, con los prompts completos para OpenCode. No duplicar los prompts en esta especificación ni insertarlos como bloques extensos dentro de los archivos Java.

## 7. Clases y responsabilidades

Cada clase de ejercicio debe:
- Contener el algoritmo o las variantes requeridas para ese ejercicio.
- Separar el algoritmo principal de la demostración con ejemplos.
- Incluir un `main` que ejecute ejemplos representativos y muestre los resultados exigidos.
- Incluir la consigna original del ejercicio en su documentación Javadoc de clase.
- Documentar con Javadoc la clase y cada método público, indicando propósito, parámetros, resultado, efectos laterales y condiciones de error cuando correspondan.
- Documentar estrategia y complejidad temporal y espacial. En los ejercicios con variantes, documentar cada variante por separado.
- Incluir comentarios explicativos en las partes relevantes del algoritmo; los comentarios deben explicar decisiones y no limitarse a repetir cada instrucción.

## 8. Relaciones entre componentes

Los diez ejercicios son independientes. No deben compartir estado ni depender de la ejecución de otro ejercicio. El `PROMPTS.md` de esta guía documenta las instrucciones de generación; sus clases Java contienen las consignas y soluciones documentadas.

## 9. Estructuras de datos

- Vectores: arreglos `int[]`.
- Matrices: arreglos bidimensionales `int[][]` con filas rectangulares en los ejemplos.
- Detección de duplicados con hashing: `HashSet<Integer>`.
- Contadores: variables enteras suficientes para los ejemplos académicos; el contador de operaciones de matriz registra una suma por elemento procesado.

## 10. Flujo principal del sistema

1. Ejecutar de forma independiente la clase del ejercicio que se desea probar.
2. El método `main` prepara datos de ejemplo representativos.
3. Invoca el método del algoritmo correspondiente.
4. Imprime el resultado, los contadores y/o la traza requeridos.
5. Si la entrada incumple una condición necesaria, el programa informa el error claramente y no produce un resultado engañoso.

## 11. Manejo de errores y excepciones

- Ejercicio 1: vector vacío debe rechazarse explícitamente al solicitar el mínimo.
- Ejercicio 3: documentar la precondición de orden ascendente. No hace falta verificar el orden del vector en cada ejecución.
- Ejercicio 9: matriz vacía o sin elementos debe rechazarse explícitamente al solicitar el máximo.
- Ejercicios 2, 5 y 6: vectores vacíos son válidos; producen, respectivamente, búsqueda sin coincidencia con cero posiciones recorridas, cero ocurrencias y resultado de igualdad según longitudes y contenido.
- Los ejemplos deben evitar entradas inválidas salvo cuando se esté demostrando el manejo de errores.

## 12. Casos límite a demostrar o contemplar

- Vectores vacíos, de un solo elemento, con valores negativos y con valores repetidos, en los ejercicios donde corresponda.
- Búsqueda: elemento en la primera posición, en la última y ausente.
- Búsqueda binaria: vector vacío, elemento en los extremos, elemento ausente y vector de un elemento.
- Comparación: vectores idénticos, longitudes distintas y primera diferencia al inicio o al final.
- Inversión: vector vacío, unitario y con cantidad par e impar de elementos.
- Matrices: varios elementos, todos negativos para la búsqueda del mayor y, para la suma, matriz sin elementos cuyo resultado sea cero.
- Bubble Sort: vector vacío, unitario, ordenado, inverso y con valores repetidos.

## 13. Entrada y salida

- Entrada: arreglos de ejemplo definidos en cada `main`; no se requiere lectura por `Scanner`, archivos ni base de datos.
- Salida: resultados legibles en consola.
- El ejercicio 2 muestra resultado de búsqueda y cantidad de posiciones examinadas.
- El ejercicio 3 muestra las variables del intervalo y el índice central en cada paso.
- El ejercicio 4 muestra el resultado de cada implementación.
- El ejercicio 8 muestra suma y operaciones contabilizadas.
- El ejercicio 10 muestra vector ordenado, comparaciones e intercambios.

## 14. Orden recomendado de implementación

1. Crear la estructura de diez clases independientes y documentar consignas con Javadoc.
2. Implementar ejercicios 1, 2 y 5 para practicar recorridos lineales.
3. Implementar ejercicios 3, 6 y 9 para búsqueda y comparación con salida anticipada o recorrido completo.
4. Implementar ejercicio 4 en ambas variantes y el ejercicio 7 con ambas estrategias.
5. Implementar recorrido de matriz y contador en el ejercicio 8.
6. Implementar Bubble Sort y sus contadores en el ejercicio 10.
7. Completar el `PROMPTS.md` de esta guía con un prompt verificable por ejercicio.
8. Compilar y ejecutar cada clase, revisar resultados, trazas, contadores y Javadocs.

## 15. Criterios de aceptación

- Existen diez clases Java separadas, una por ejercicio, y cada una compila y se puede ejecutar independientemente en Java 21.
- Cada clase incluye la consigna correspondiente y documentación Javadoc de clase y métodos públicos; la documentación explica qué hace el algoritmo, su estrategia y complejidad.
- Las soluciones cumplen exactamente los comportamientos descritos en la sección de requisitos funcionales.
- Las salidas incluyen las trazas o contadores solicitados y estos coinciden con el trabajo efectivamente realizado.
- Las variantes del ejercicio 4 y del ejercicio 7 se pueden comparar y producen resultados consistentes para los mismos datos.
- `guias/analisis-de-algoritmos/PROMPTS.md` contiene diez prompts independientes, listos para OpenCode, que describen estrategia, justificación, complejidades, requisitos de comentarios y salidas específicos de cada ejercicio.
- No se agregan dependencias, frameworks, entrada interactiva ni cambios de alcance no pedidos.
