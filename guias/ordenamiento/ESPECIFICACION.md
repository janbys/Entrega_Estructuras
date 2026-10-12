# Especificación técnica — Guía 3: Ordenamiento

## 1. Objetivo del proyecto

Desarrollar una guía académica independiente sobre algoritmos de ordenamiento en Java 21. La guía debe permitir que el alumno prepare primero un prompt completo para OpenCode, genere o desarrolle la solución, la ejecute con datos ingresados por consola y compruebe tanto el orden obtenido como las trazas y métricas solicitadas.

La guía se mantendrá separada de las guías existentes. La carpeta prevista para los materiales de esta guía es `guias/ordenamiento/`; no se deben modificar las guías anteriores.

## 2. Requisitos funcionales por ejercicio

### Ejercicio 1 — Ordenamiento Burbuja paso a paso

- Ordenar un arreglo de enteros en orden ascendente mediante Bubble Sort.
- Mostrar el arreglo ingresado y su estado después de cada pasada completa del algoritmo.
- Explicar en la documentación y en los prompts que los elementos adyacentes se comparan e intercambian cuando están en el orden incorrecto; por ello, el mayor valor pendiente se desplaza hacia el final en cada pasada.
- Si el arreglo tiene cero o un elemento, mostrarlo como original y ordenado; no hay pasadas que mostrar.
- Complejidad esperada para la variante básica sin finalización anticipada: tiempo $O(n^2)$ y espacio adicional $O(1)$.

### Ejercicio 2 — Comparación entre Burbuja y Selección

- Implementar Bubble Sort y Selection Sort como métodos separados.
- Aplicar ambos algoritmos al mismo contenido inicial. Cada método debe recibir su propia copia para que la primera ordenación no altere la entrada de la segunda.
- Mostrar el resultado de cada algoritmo y sus cantidades de comparaciones e intercambios.
- Una comparación contabilizada es una comparación entre dos valores del arreglo para decidir el orden. No se cuentan comparaciones de índices, condiciones de bucle ni verificaciones de límites.
- Un intercambio contabilizado es un cambio real de posición entre dos elementos. No contar una asignación/intercambio cuando Selection Sort ya encontró el mínimo en la posición actual.
- Explicar la diferencia entre comparar vecinos (Bubble Sort) y buscar el mínimo del segmento restante (Selection Sort).
- Complejidad temporal de ambos: $O(n^2)$; espacio adicional: $O(1)$.

### Ejercicio 3 — Ordenamiento por Inserción con arreglo casi ordenado

- Implementar Insertion Sort ascendente y demostrarlo con un caso casi ordenado. Incluir el ejemplo de la consigna `{1, 2, 3, 5, 4, 6, 7}` en los casos de prueba, además de permitir el ingreso de otros valores.
- Mostrar el arreglo antes y después del ordenamiento, y el total de desplazamientos.
- Un desplazamiento es mover un elemento ya ubicado hacia la derecha para abrir espacio a la clave. No contar como desplazamiento la escritura final de la clave en su posición.
- Explicar que, cuando hay pocas inversiones, se realizan pocos desplazamientos y el algoritmo puede aproximarse al caso lineal.
- Complejidad: mejor caso $O(n)$; promedio y peor caso $O(n^2)$; espacio adicional $O(1)$.

### Ejercicio 4 — Ordenamiento de nombres con Selection Sort

- Ordenar un arreglo de nombres ascendentemente mediante Selection Sort.
- Recibir nombres ingresados por consola y mostrar el orden anterior y posterior.
- Comparar los textos sin distinguir mayúsculas, usando el orden natural de Java como base y sin agregar reglas regionales especiales. Documentar este criterio en el programa y en la guía.
- Explicar que se selecciona repetidamente el menor nombre del segmento aún no ordenado y que la comparación se hace entre cadenas, no valores numéricos.
- Complejidad temporal $O(n^2)$ y espacio adicional $O(1)$, sin contar el almacenamiento del arreglo recibido.

### Ejercicio 5 — ShellSort explicando los gaps

- Implementar ShellSort ascendente.
- Usar gaps inicializados en la mitad entera del tamaño (`n / 2`) y reducirlos a la mitad entera hasta llegar a 1; procesar el gap 1. Si el arreglo tiene menos de dos elementos, no hay etapas.
- Para cada gap, mostrar el valor del gap y el estado del arreglo una vez finalizada la pasada completa de inserciones con ese gap. Una pasada completa procesa todos los subgrupos intercalados de ese gap.
- Explicar que los saltos permiten mover elementos a distancias mayores que uno antes de la pasada final de inserción, reduciendo desorden distante.
- Documentar que el rendimiento depende de la secuencia de gaps; para esta secuencia, indicar el peor caso de referencia $O(n^2)$ y espacio adicional $O(1)$.

### Ejercicio 6 — Quicksort con primer elemento como pivote

- Implementar Quicksort ascendente y seleccionar siempre el primer elemento del subarreglo como pivote.
- Para cada subarreglo que se particiona, mostrar el pivote y los subarreglos izquierdo y derecho resultantes de la partición; al terminar, mostrar el arreglo ordenado.
- Para fijar el comportamiento de la partición, usar el esquema de Lomuto adaptado al primer elemento: los valores menores o iguales al pivote quedan a su izquierda y los mayores a su derecha. El pivote ocupa su posición definitiva antes de continuar recursivamente.
- Explicar la relación con divide y vencerás y las llamadas recursivas que ordenan las particiones.
- No iniciar particiones adicionales cuando el segmento tiene cero o un elemento.
- Complejidad temporal promedio $O(n \log n)$ y peor caso $O(n^2)$; espacio de pila promedio $O(\log n)$ y peor caso $O(n)$.

### Ejercicio 7 — Peor caso de Quicksort

- Ejecutar Quicksort sobre el arreglo ascendente de ejemplo `{1, 2, 3, 4, 5, 6, 7}` y permitir también ingresar otro arreglo.
- Usar exactamente la regla de pivote y partición del ejercicio 6: primer elemento como pivote y Lomuto adaptado.
- Mostrar el arreglo ordenado y la cantidad de invocaciones del método recursivo.
- Contar cada entrada al método, incluida la invocación inicial y las invocaciones que reciben segmentos vacíos o unitarios. Para que la cuenta sea reproducible, invocar las dos ramas tras cada partición y aplicar el caso base al ingresar a cada rama.
- Explicar que, sobre datos ascendentes, el primer elemento es el mínimo de cada segmento y genera una partición vacía y otra de tamaño $n-1$, por lo que la profundidad y el tiempo pueden alcanzar $O(n)$ y $O(n^2)$, respectivamente.

### Ejercicio 8 — MergeSort paso a paso

- Implementar MergeSort ascendente.
- Mostrar las divisiones recursivas, indicar cuándo cada segmento alcanza la condición de corte de cero o un elemento y mostrar cada fusión y el resultado combinado.
- Mantener explícita la diferencia entre dividir (descomponer el problema hasta segmentos base) y fusionar (combinar ordenadamente los resultados).
- Mostrar también el arreglo final.
- Complejidad temporal $O(n \log n)$ y espacio auxiliar $O(n)$.

### Ejercicio 9 — Comparación de algoritmos simples

- Implementar Bubble Sort, Selection Sort e Insertion Sort para enteros en orden ascendente.
- Aplicar cada método a una copia del mismo arreglo ingresado y mostrar el arreglo ordenado y las métricas de cada algoritmo.
- Contar comparaciones de valores según la definición del ejercicio 2. Informar intercambios para Bubble Sort y Selection Sort, y desplazamientos para Insertion Sort. Aplicar las definiciones de intercambios y desplazamientos de los ejercicios 2 y 3.
- Explicar y comparar las estrategias, sin limitar el análisis al resultado final.
- Complejidades temporales: Bubble Sort $O(n^2)$ en mejor, promedio y peor caso para la versión básica sin salida anticipada; Selection Sort $O(n^2)$; Insertion Sort $O(n)$ en el mejor caso y $O(n^2)$ en promedio y peor caso. Espacio adicional $O(1)$ para cada algoritmo.

### Ejercicio 10 — Sistema de ranking de puntajes

- Recibir por consola una cantidad de jugadores y, para cada jugador, su nombre y puntaje entero.
- Representar cada jugador con nombre y puntaje asociados, sin separar los datos durante los intercambios o fusiones.
- Ordenar el ranking por puntaje descendente.
- Elegir MergeSort estable, entre los algoritmos de la guía, para ofrecer tiempo $O(n \log n)$ y mantener el orden de entrada entre jugadores con puntajes iguales. Documentar la justificación de la elección.
- Mostrar el ranking antes y después del ordenamiento, conservando nombre y puntaje de cada registro.
- Contemplar cero jugadores: el ranking debe mostrarse vacío, sin intentar acceder a un elemento inexistente.

## 3. Requisitos no funcionales

- Lenguaje: Java, versión objetivo 21.
- No incorporar frameworks, bibliotecas externas ni dependencias. Se permite la biblioteca estándar de Java, incluida `Scanner` para la entrada por consola.
- Mantener soluciones introductorias, nombres descriptivos y comentarios que expliquen decisiones y razonamiento, no cada instrucción mecánicamente.
- Separar el algoritmo de la lectura y demostración por consola mediante métodos con responsabilidades claras.
- Incluir Javadoc en las clases y métodos relevantes: consigna, propósito, estrategia, parámetros/entradas, resultados, efectos laterales, errores posibles y complejidades cuando correspondan.
- Las soluciones de ejercicios distintos deben ser independientes; no crear un menú central ni exigir ejecutar otros ejercicios.
- Los algoritmos de ordenamiento deben poder verificarse de manera determinista con los casos de prueba de esta especificación.

## 4. Restricciones

- Crear una carpeta propia para la guía, prevista como `guias/ordenamiento/`, sin modificar las guías existentes.
- La estructura de entrega de la guía deberá incluir `README.md`, `ESPECIFICACION.md`, `PROMPTS.md` y `src/` con diez clases independientes.
- Nombres de clase propuestos: `Ordenamiento01`, `Ordenamiento02`, `Ordenamiento03`, `Ordenamiento04`, `Ordenamiento05`, `Ordenamiento06`, `Ordenamiento07`, `Ordenamiento08`, `Ordenamiento09` y `Ordenamiento10`.
- Cada clase ejecutable tendrá su propio `main` para solicitar sus datos y mostrar los resultados del ejercicio. No se deben sustituir las entradas solicitadas por datos fijos; los ejemplos de esta especificación deben incluirse también en las pruebas reproducibles y en los ejemplos documentados.
- Aceptar tamaños cero cuando el ejercicio lo permita; rechazar tamaños negativos e informar claramente entradas numéricas inválidas. No acceder a posiciones de arreglos vacíos.
- Los ejemplos, contadores y trazas deben respetar las definiciones de conteo fijadas en esta especificación.
- No agregar funciones fuera de la consigna, ni cambiar documentación o código de otras guías.

## 5. Lenguaje y versión

- Java 21.
- Entrada: consola interactiva; el usuario ingresa cantidad de elementos y luego los valores necesarios. En el ejercicio 4 se ingresan nombres; en el ejercicio 10, nombre y puntaje por jugador.
- Salida: mensajes legibles por consola. Cada programa independiente identifica el ejercicio, sus datos y los resultados solicitados.

## 6. Estructura general prevista

- `guias/ordenamiento/README.md`: consigna, instrucciones para compilar y ejecutar cada ejercicio, ejemplos de uso y forma de verificar resultados.
- `guias/ordenamiento/ESPECIFICACION.md`: esta especificación funcional y técnica.
- `guias/ordenamiento/PROMPTS.md`: diez prompts independientes, completos y listos para usar en OpenCode, uno por ejercicio.
- `guias/ordenamiento/src/`: diez archivos Java, uno por ejercicio, con los nombres propuestos en la sección 4.
- Sin sistema de construcción adicional: cada fuente debe poder compilarse en Java 21 sin dependencias externas.

## 7. Responsabilidades de las clases

Cada clase debe:
- Implementar únicamente el algoritmo o comparación correspondiente al ejercicio.
- Separar el método de ordenamiento/estadística de `main` y de la interacción por consola.
- Mostrar las trazas y métricas propias del ejercicio.
- Documentar la consigna, razonamiento, entrada, salida, comportamiento ante casos límite y complejidad.
- Evitar alterar datos de entrada de forma inadvertida. Cuando se comparen algoritmos, operar sobre copias equivalentes. Cuando el ejercicio requiere modificación in-place, documentar ese efecto.
- Para el ranking, mantener los atributos de cada jugador vinculados durante el ordenamiento y preservar la secuencia original de jugadores empatados.

## 8. Relaciones entre componentes

Los diez ejercicios son independientes y cada uno debe compilarse y ejecutarse sin depender de otra clase de la guía. El ejercicio 7 usa las mismas reglas de Quicksort definidas en el ejercicio 6, pero conserva su propia clase ejecutable. El ejercicio 9 compara implementaciones del 1 al 3 en su propia clase; no debe depender de que esas otras clases se hayan ejecutado. El ejercicio 10 ordena registros de jugadores y no depende de los ejercicios anteriores.

## 9. Estructuras de datos

- Ejercicios 1 a 3 y 5 a 9: arreglos de enteros (`int[]`).
- Ejercicio 4: arreglo de cadenas (`String[]`).
- Ejercicio 10: arreglo de registros de jugador que mantiene asociados nombre y puntaje.
- Las copias temporales deben limitarse a los ejercicios que comparan varias ordenaciones o que requieren un algoritmo no in-place, como MergeSort.
- No usar colecciones como reemplazo del arreglo en ejercicios 1 a 9.

## 10. Flujo principal

1. El usuario ejecuta directamente la clase correspondiente.
2. El programa solicita los datos requeridos por el ejercicio y valida el tamaño y los valores numéricos ingresados.
3. `main` conserva o prepara copias de los datos cuando se comparan algoritmos.
4. El método del algoritmo realiza el ordenamiento y, cuando se requiere, produce trazas o métricas.
5. El programa muestra los datos originales, estados intermedios y resultados definidos por la consigna.
6. Los casos vacíos o unitarios se procesan sin errores de índice; las entradas inválidas se informan sin mostrar un resultado engañoso.

## 11. Errores y casos límite

- Rechazar una cantidad de elementos negativa y entradas que no puedan interpretarse como números donde se esperan enteros.
- Permitir un arreglo vacío cuando el algoritmo lo admita; devolver/mostrar el arreglo vacío y contadores cero cuando no se realizan operaciones.
- Probar arreglos vacíos, unitarios, ya ordenados, en orden inverso, con elementos repetidos y con valores negativos, según aplique.
- No realizar operaciones de ordenamiento sobre índices inexistentes.
- Para nombres, usar el criterio de comparación sin distinguir mayúsculas definido en el ejercicio 4.
- Para el ranking, admitir cero jugadores y puntajes negativos, cero o positivos; los empates conservan el orden de entrada.
- Los ejemplos no deben depender del orden de ejecución de otras clases.

## 12. Entrada y salida

- Los programas leen los datos desde consola, sin archivos, base de datos ni interfaz gráfica.
- Los algoritmos deben aceptar los arreglos mediante parámetros de métodos separados de la interacción.
- Salidas mínimas por ejercicio:
  1. Arreglo original y arreglo tras cada pasada.
  2. Orden resultante y comparaciones/intercambios de ambos algoritmos.
  3. Arreglo antes/después y desplazamientos.
  4. Nombres antes/después.
  5. Gap y arreglo tras cada etapa completa.
  6. Pivote y particiones por llamada de partición, además del resultado final.
  7. Resultado final y número de invocaciones recursivas con la definición fijada.
  8. Divisiones, condiciones de corte, fusiones y resultado final.
  9. Resultado, comparaciones e intercambios/desplazamientos de cada algoritmo.
  10. Jugadores antes/después, ordenados por puntaje descendente.

## 13. Orden recomendado de desarrollo

1. Crear la estructura propia de la guía y redactar la consigna y comandos de uso en `README.md`.
2. Completar esta especificación con reglas comunes de entrada, conteo y comparación.
3. Escribir los diez prompts completos en `PROMPTS.md`, siguiendo el formato de las guías existentes y detallando algoritmo, razonamiento, entrada, salida, comentarios y verificación.
4. Implementar los ejercicios 1 a 5 para Bubble, Selection, Insertion y ShellSort.
5. Implementar Quicksort y sus trazas/contador en los ejercicios 6 y 7.
6. Implementar MergeSort con trazas en el ejercicio 8.
7. Implementar comparación de métricas en el ejercicio 9 y ranking estable en el ejercicio 10.
8. Compilar cada clase con Java 21, ejecutar los casos representativos y comprobar las salidas y contadores.
9. Revisar documentación, entradas vacías e inválidas, y asegurar que no haya cambios fuera de `guias/ordenamiento/`.

## 14. Criterios de aceptación

- La guía queda separada de las guías existentes y contiene los cuatro elementos previstos: README, especificación, prompts y fuentes independientes.
- Existen diez programas Java 21 independientes que compilan y pueden ejecutarse por separado.
- Cada programa acepta los datos definidos desde consola y muestra todas las salidas requeridas para su ejercicio.
- Las diez implementaciones usan los algoritmos solicitados, incluyendo la secuencia de gaps, el pivote/partición de Quicksort y las trazas de MergeSort aquí definidos.
- Los contadores corresponden a las definiciones de comparación, intercambio, desplazamiento e invocación establecidas en esta especificación.
- Los algoritmos comparados reciben datos iniciales equivalentes; la ordenación no produce efectos cruzados por compartir un arreglo ya modificado.
- El ranking está ordenado de mayor a menor puntaje, conserva nombre y puntaje unidos y mantiene el orden de entrada en empates.
- Los casos vacíos, unitarios, ordenados, inversos, repetidos y con negativos se resuelven correctamente cuando son aplicables.
- README contiene instrucciones de compilación, ejecución y pruebas; PROMPTS contiene un prompt completo por ejercicio, listo para OpenCode.
- No se incorporan dependencias, funcionalidades adicionales ni cambios a las guías anteriores.
