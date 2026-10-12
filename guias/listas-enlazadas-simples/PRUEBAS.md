# Pruebas de ejecución — Listas enlazadas simples

Pruebas repetibles con valores deterministas incluidos en cada `main`. Se ejecutaron con OpenJDK 21.0.11.

## Compilación y Javadoc

Comandos ejecutados desde esta carpeta:

```sh
javac --release 21 -Xlint:all -d /tmp/listas-enlazadas-classes src/*.java
javadoc --release 21 -quiet -Xdoclint:all -d /tmp/listas-enlazadas-docs src/*.java
```

**Resultado:** las diez clases compilaron sin errores ni advertencias; Javadoc se generó con validación estricta.

Para repetir la compilación localmente, se puede usar `out` en lugar de `/tmp/listas-enlazadas-classes`.

## Ejercicio 1 — Crear lista

**Datos en `main`:** insertar inicio 20, final 30, inicio 10.

**Salida observada:**

```text
Inicial: null
vacía=true, size=0
Tras insertar: 10 -> 20 -> 30 -> null
vacía=false, size=3
```

## Ejercicio 2 — Buscar

**Lista:** `10 -> 20 -> 30 -> null`, tamaño 3. Pruebas: `buscar(10)`, `buscar(30)`, `buscar(8)` y buscar en lista vacía.

**Resultado observado:**

```text
buscar(10): true
buscar(30): true
buscar(8): false
buscar(10) en lista vacía: false
```

## Ejercicio 3 — Obtener por posición

**Lista:** `10 -> 20 -> 30 -> null`. Se consultan posiciones 0, 1, 2, -1 y 3.

**Salida observada:**

```text
obtener(0) = 10
obtener(1) = 20
obtener(2) = 30
obtener(-1): Posición -1 fuera de [0, 2].
obtener(3): Posición 3 fuera de [0, 2].
Tras errores: 10 -> 20 -> 30 -> null, size=3
```

Los índices inválidos producen `IndexOutOfBoundsException` y no cambian el estado.

## Ejercicio 4 — Insertar en posición

**Operaciones:** construir `[20, 40]`, insertar `10` en 0, `30` en 2 y `50` al final; intentar -1 y 6.

**Salida observada:**

```text
Ejercicio 4 — 10 -> 20 -> 30 -> 40 -> 50 -> null, size=5
Inserción rechazada: Posición -1 fuera de [0, 5].
Inserción rechazada: Posición 6 fuera de [0, 5].
Sin cambios: 10 -> 20 -> 30 -> 40 -> 50 -> null, size=5
```

## Ejercicio 5 — Eliminar por valor

**Lista inicial:** `10 -> 20 -> 30 -> 20 -> 40 -> null`. Se elimina cabeza 10, nodo intermedio 30, cola 40, primera aparición de 20 y se intenta 99; también se prueba lista vacía.

**Salida observada:**

```text
Ejercicio 5 — vacía: eliminar(1)=false
Inicial: 10 -> 20 -> 30 -> 20 -> 40 -> null, size=5
eliminar(10)=true → 20 -> 30 -> 20 -> 40 -> null, size=4
eliminar(30)=true → 20 -> 20 -> 40 -> null, size=3
eliminar(40)=true → 20 -> 20 -> null, size=2
eliminar(20)=true → 20 -> null, size=1
eliminar(99)=false → 20 -> null, size=1
```

## Ejercicio 6 — Eliminar por posición

**Lista inicial:** `10 -> 20 -> 30 -> 40 -> null`; eliminar posiciones 0, 1 y 1; probar luego -1 y `size`.

**Salida observada:**

```text
eliminarEnPosicion(0): 20 -> 30 -> 40 -> null, size=3
eliminarEnPosicion(1): 20 -> 40 -> null, size=2
eliminarEnPosicion(1): 20 -> null, size=1
Rechazada: Posición -1 inválida para size=1.
Rechazada: Posición 1 inválida para size=1.
Tras errores: 20 -> null, size=1
```

## Ejercicio 7 — Modificar

**Lista inicial:** `10 -> 20 -> 30 -> null`; modificar posición 1 por 25; probar -1 y `size`.

**Salida observada:**

```text
modificar(1,25): 10 -> 25 -> 30 -> null, size=3
Rechazada: Posición -1 inválida para size=3.
Rechazada: Posición 3 inválida para size=3.
Tras errores: 10 -> 25 -> 30 -> null, size=3
```

## Ejercicio 8 — Contar ocurrencias

**Lista:** `10 -> 20 -> 10 -> 30 -> 10 -> null`, tamaño 5.

**Resultados observados:**

```text
contarOcurrencias(10) = 3
contarOcurrencias(99) = 0
En lista vacía: 0
```

## Ejercicio 9 — Invertir

**Pruebas:** lista vacía, un nodo 5, dos nodos `10 -> 20 -> null` y `10 -> 20 -> 30 -> 40 -> null`.

**Salida observada:**

```text
Ejercicio 9 — vacía: null
Un nodo: 5 -> null
Dos nodos: 20 -> 10 -> null
Antes: 10 -> 20 -> 30 -> 40 -> null, size=4
Después: 40 -> 30 -> 20 -> 10 -> null, size=4
```

## Ejercicio 10 — Lista genérica

**Pruebas:** una lista `Integer`, una `String` y una `Alumno`; búsqueda por igualdad, conteo, inversión, modificación y eliminación por posición.

**Salida observada:**

```text
Integer: 10 -> 20 -> 30 -> null, buscar(20)=true, contar(10)=1
Invertida: 30 -> 20 -> 10 -> null, obtener(0)=30
String: sur -> centro -> norte -> null, buscar(centro)=true
Alumno: Alumno[legajo=1, nombre=Ana] -> Alumno[legajo=2, nombre=Luis] -> null, buscar Ana por valor=true
Tras modificar y eliminar: Alumno[legajo=2, nombre=Lucía] -> null, size=1
Eliminar dato inexistente: false
```

## Verificaciones adicionales

- En los ejercicios 3, 4, 6 y 7, los índices inválidos se validaron antes de modificar la lista; la impresión y el tamaño se mantuvieron iguales tras las excepciones.
- El ejercicio 5 elimina solo la primera coincidencia de un valor repetido.
- El ejercicio 8 recorre y cuenta las tres apariciones del valor 10.
- El ejercicio 9 conserva todos los nodos al invertir y mantiene `size`.
- Los diez comentarios de prompt inicial se compararon con sus respectivas secciones de `PROMPTS.md`; coincidieron.
