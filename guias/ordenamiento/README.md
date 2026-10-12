# Guía 3 — Algoritmos de Ordenamiento

Práctico de algoritmos de ordenamiento con Java 21 y OpenCode. Cada ejercicio es un programa independiente: primero se puede redactar/usar su prompt de [PROMPTS.md](PROMPTS.md), y luego compilar y ejecutar su clase.

La especificación detallada está en [ESPECIFICACION.md](ESPECIFICACION.md). Los programas leen los datos desde la consola, salvo el ejercicio 3, que ofrece usar el caso casi ordenado de la consigna.

## Ejercicios

1. Bubble Sort paso a paso.
2. Comparación entre Bubble Sort y Selection Sort.
3. Insertion Sort con arreglo casi ordenado y conteo de desplazamientos.
4. Selection Sort de nombres.
5. ShellSort mostrando los gaps.
6. Quicksort con el primer elemento como pivote.
7. Peor caso de Quicksort y conteo de llamadas.
8. MergeSort paso a paso.
9. Comparación de Bubble, Selection e Insertion Sort.
10. Ranking estable de jugadores por puntaje.

## Requisitos

- JDK 21 instalado y disponible como `java` y `javac`.
- No se requieren dependencias externas ni sistema de construcción.

## Compilar y ejecutar

Desde esta carpeta, compilar el ejercicio deseado y ejecutar la clase correspondiente:

```sh
javac -d out src/Ordenamiento01.java
java -cp out Ordenamiento01
```

Sustituí el nombre de clase por el que quieras ejecutar:

| Ejercicio | Clase |
|---|---|
| 1 | `Ordenamiento01` |
| 2 | `Ordenamiento02` |
| 3 | `Ordenamiento03` |
| 4 | `Ordenamiento04` |
| 5 | `Ordenamiento05` |
| 6 | `Ordenamiento06` |
| 7 | `Ordenamiento07` |
| 8 | `Ordenamiento08` |
| 9 | `Ordenamiento09` |
| 10 | `Ordenamiento10` |

Para limpiar los archivos compilados, eliminá la carpeta `out`. También se puede compilar cada archivo directamente en `src` con `javac src/NombreDeClase.java` y ejecutar desde allí; el comando con `-d out` mantiene separados los fuentes y `.class`.

## Pruebas y verificación

Los algoritmos se encuentran en métodos separados de la interacción por consola. Para probar los casos límite, ejecutá cada programa e ingresá, según corresponda:

- cero elementos y un elemento;
- valores ya ordenados, en orden inverso, negativos y repetidos;
- para el ejercicio 3, el caso `{1, 2, 3, 5, 4, 6, 7}`;
- para el ejercicio 7, `{1, 2, 3, 4, 5, 6, 7}`;
- para el ejercicio 10, jugadores con puntajes iguales y cero jugadores.

Verificá que las salidas numéricas estén en el orden indicado y que las trazas/métricas correspondan a la definición de [ESPECIFICACION.md](ESPECIFICACION.md). En el ejercicio 10, los jugadores empatados deben conservar el orden de ingreso.

Los tamaños negativos y los datos que no sean enteros se rechazan con un mensaje claro. Nombres con espacios se leen por línea completa.
