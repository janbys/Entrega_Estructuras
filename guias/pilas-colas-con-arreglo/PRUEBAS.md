# Pruebas de ejecución — Unidad 4

Este documento registra pruebas realizadas con las clases de la guía. Los programas son interactivos: las entradas de abajo representan las respuestas ingresadas en cada menú, en el orden indicado; se omiten los textos de solicitud del menú para resaltar resultados. Las pruebas se pueden repetir compilando con Java 21 desde esta carpeta.

## Compilación y documentación

Se compilaron las diez clases con:

```sh
javac --release 21 -Xlint:all -d /tmp/pilas-colas-classes src/*.java
```

**Resultado:** compilación exitosa, sin errores ni advertencias.

También se generó y validó Javadoc:

```sh
javadoc --release 21 -quiet -Xdoclint:all -d /tmp/pilas-colas-docs src/*.java
```

**Resultado:** generación exitosa.

Para repetir localmente y mantener los artefactos fuera de los fuentes, se puede sustituir `/tmp/pilas-colas-classes` por `out` y `/tmp/pilas-colas-docs` por `docs`; ambas carpetas están excluidas de Git.

## Ejercicio 1 — Pila de enteros

**Entrada de consola:** capacidad `2`; `push 7`; `push 4`; `peek`; `pop`; `size`; salir.

**Salida relevante observada:**

```text
Apilado: 7
Apilado: 4
Superior: 4
Desapilado: 4
Tamaño: 1
```

Confirma que la cima es el último valor agregado (LIFO).

## Ejercicio 2 — Torre de platos

**Entrada de consola:** capacidad `2`; agregar `Llano`; agregar `Hondo`; consultar superior; retirar superior; salir.

**Salida relevante observada:**

```text
Agregado: Llano | [Llano] (base → cima)
Agregado: Hondo | [Llano, Hondo] (base → cima)
Arriba está: Hondo
Retirado: Hondo | [Llano] (base → cima)
```

## Ejercicio 3 — Paréntesis balanceados

**Entrada de consola:** elegir la opción de probar ejemplos.

**Salida observada:**

```text
"(5 + 3) * (2 + 1)" → válida
"(5 + 3)) * (2 + 1" → inválida
"" → válida
"((x + 1) * (y))" → válida
")x(" → inválida
"(x + 1" → inválida
```

La validación se limita al balance de paréntesis, no a la sintaxis de las expresiones.

## Ejercicio 4 — Historial de navegación

**Entrada de consola:** capacidad `3`; visitar `https://a.test`; visitar `https://b.test`; volver; consultar página actual; salir.

**Salida relevante observada:**

```text
Visitada. [https://a.test] (base → actual)
Visitada. [https://a.test, https://b.test] (base → actual)
Se volvió desde https://b.test; página actual: https://a.test.
Página actual: https://a.test
```

## Ejercicio 5 — Pila genérica

**Entrada de consola:** capacidad `2`; seleccionar `Integer`; `push` del siguiente ejemplo dos veces; mostrar; `pop` dos veces; salir.

**Salida relevante observada:**

```text
Apilado: 10
Apilado: 20
Fondo → superior: [10, 20]
Desapilado: 20
Desapilado: 10
```

La misma clase genérica también compila con las opciones de demostración `String` y `Producto`.

## Ejercicio 6 — Cola simple de enteros

**Entrada de consola:** capacidad `3`; `enqueue 4`; `enqueue 8`; `dequeue`; `front`; salir.

**Salida relevante observada:**

```text
Encolado. front→rear [4]
Encolado. front→rear [4, 8]
Retirado: 4 | front→rear [8]
Frente: 8
```

Confirma FIFO y las referencias de frente/rear.

## Ejercicio 7 — Sistema de turnos

**Entrada de consola:** capacidad `3`; registrar `Ana`; registrar `Luis`; atender siguiente; salir.

**Salida relevante observada:**

```text
Registrada. Fila (primero → último): [Ana]
Registrada. Fila (primero → último): [Ana, Luis]
Atendida: Ana. Fila (primero → último): [Luis]
```

## Ejercicio 8 — Cola de impresión

**Entrada de consola:** capacidad `3`; agregar `Informe` de `3` páginas; agregar `Notas` de `2` páginas; imprimir siguiente; salir.

**Salida relevante observada:**

```text
Agregado. Cola: [Documento[nombre=Informe, paginas=3]]
Agregado. Cola: [Documento[nombre=Informe, paginas=3], Documento[nombre=Notas, paginas=2]]
Enviado a imprimir: Documento[nombre=Informe, paginas=3] | Cola: [Documento[nombre=Notas, paginas=2]]
```

## Ejercicio 9 — Desperdicio de espacio en cola simple

**Entrada de consola:** capacidad `3`; `enqueue 10`; `enqueue 20`; `enqueue 30`; `dequeue`; intentar `enqueue 40`; salir.

**Salida relevante observada:**

```text
Encolado. arreglo=[10, 20, 30], huecos=[], front=0, rear=2, size=3
Retirado 10. arreglo=[_, 20, 30], huecos=[0], front=1, rear=2, size=2
Operación no realizada: rear llegó al final; los huecos iniciales no se reutilizan. | arreglo=[_, 20, 30], huecos=[0], front=1, rear=2, size=2
```

## Ejercicio 10 — Cola circular

**Entrada de consola:** capacidad `3`; `enqueue 10`, `enqueue 20`, `enqueue 30`; `dequeue` dos veces; `enqueue 40`, `enqueue 50`; mostrar estado; salir.

**Salida relevante observada:**

```text
Encolado. arreglo=[10, 20, 30], cola=[10, 20, 30], front=0, rear=2, size=3
Retirado: 10 | arreglo=[_, 20, 30], cola=[20, 30], front=1, rear=2, size=2
Retirado: 20 | arreglo=[_, _, 30], cola=[30], front=2, rear=2, size=1
Encolado. arreglo=[40, _, 30], cola=[30, 40], front=2, rear=0, size=2
Encolado. arreglo=[40, 50, 30], cola=[30, 40, 50], front=2, rear=1, size=3
```

Muestra el wrap-around de `rear` y la reutilización de celdas al inicio del arreglo.

## Límites verificados

- Se ejecutó una prueba de capacidad `0` para cada una de las diez clases. Las estructuras no admiten inserciones; se verificaron los mensajes para consultas o retiros en vacío, y las consultas `isEmpty`/`isFull` en las estructuras que las ofrecen.
- Se verificó capacidad `1` en la cola circular: admite un elemento, rechaza el siguiente, lo retira y luego permite volver a encolar.
- Se verificaron los casos balanceados y desbalanceados de paréntesis, incluyendo cadena vacía, anidamiento, cierre sobrante y apertura sobrante.
- En cola simple, intentar insertar con huecos iniciales disponibles falla cuando `rear` está en la última posición; en cola circular, esos huecos sí se reutilizan.
