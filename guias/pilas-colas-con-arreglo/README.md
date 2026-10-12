# Unidad 4 — Pilas y Colas con Arreglos

Práctico de implementación de pilas y colas en Java 21 con arreglos fijos y OpenCode. Cada ejercicio es autónomo y tiene su propio menú. Antes de implementar, redactá/usá el prompt de [PROMPTS.md](PROMPTS.md); la especificación completa está en [ESPECIFICACION.md](ESPECIFICACION.md).

Las pruebas ejecutadas, sus entradas y los resultados principales están registradas en [PRUEBAS.md](PRUEBAS.md).

## Ejercicios

1. Pila de enteros.
2. Torre de platos (pila LIFO).
3. Paréntesis balanceados.
4. Historial de navegación (pila LIFO).
5. Pila genérica con `Object[]`.
6. Cola simple de enteros.
7. Sistema de turnos (cola FIFO).
8. Cola de impresión.
9. Desperdicio de espacio en una cola simple.
10. Cola circular.

## Requisitos

- JDK 21 (`java`, `javac` y `javadoc`).
- No se requieren dependencias externas.

## Compilar y ejecutar

Desde esta carpeta, compilá todas las clases:

```sh
mkdir -p out
javac --release 21 -d out src/*.java
```

Ejecutá solo el ejercicio deseado, por ejemplo:

```sh
java -cp out PilasColasConArreglo01
```

| Ejercicio | Clase |
|---|---|
| 1 | `PilasColasConArreglo01` |
| 2 | `PilasColasConArreglo02` |
| 3 | `PilasColasConArreglo03` |
| 4 | `PilasColasConArreglo04` |
| 5 | `PilasColasConArreglo05` |
| 6 | `PilasColasConArreglo06` |
| 7 | `PilasColasConArreglo07` |
| 8 | `PilasColasConArreglo08` |
| 9 | `PilasColasConArreglo09` |
| 10 | `PilasColasConArreglo10` |

Cada simulador solicita la capacidad al iniciarse cuando corresponde y permite repetir operaciones hasta elegir salir. Capacidad cero es admitida. Las acciones sobre estructuras llenas/vacías informan el error y el menú continúa.

## Pruebas y Javadoc

Probá cada estructura con capacidad 0, 1 y varias posiciones; verificá operaciones normales, límite lleno/vacío, orden LIFO/FIFO y que los errores no cambien el estado. Para el ejercicio 3, verificá expresiones balanceadas, anidadas, vacías, con cierre extra y apertura sobrante. Para el 9, usa la demostración de capacidad 3 que deja una celda vacía al inicio y `rear` al final. Para el 10, llená, quitá elementos y encolá otra vez para observar el wrap-around.

Generá la documentación de API con:

```sh
javadoc --release 21 -d docs src/*.java
```

`out/` y `docs/` son artefactos generados, no fuentes del práctico.
