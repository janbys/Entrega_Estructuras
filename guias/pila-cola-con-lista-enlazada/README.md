# Guía — PilaColaConListaEnlazada

Práctico de pilas y colas implementadas con nodos enlazados en Java 21 usando OpenCode. La guía contiene diez ejercicios independientes con demostraciones de datos fijos. Consultá [ESPECIFICACION.md](ESPECIFICACION.md), los prompts de [PROMPTS.md](PROMPTS.md) y las entradas/salidas probadas de [PRUEBAS.md](PRUEBAS.md).

## Ejercicios

1. Pila enlazada de enteros.
2. Cola enlazada de enteros.
3. Pila genérica.
4. Cola genérica.
5. Historial de navegación con pila.
6. Cola de atención de clientes.
7. Paréntesis balanceados.
8. Invertir palabra con pila.
9. Cola de impresión.
10. Lista doblemente enlazada genérica.

## Requisitos

- JDK 21 (`java`, `javac` y `javadoc`).
- No se requieren dependencias externas.

## Compilar y ejecutar

Desde esta carpeta, compilá las clases en `out/`:

```sh
mkdir -p out
javac --release 21 -d out src/*.java
```

Ejecutá individualmente la clase que quieras probar:

```sh
java -cp out PilaColaConListaEnlazada01
```

| Ejercicio | Clase |
|---|---|
| 1 | `PilaColaConListaEnlazada01` |
| 2 | `PilaColaConListaEnlazada02` |
| 3 | `PilaColaConListaEnlazada03` |
| 4 | `PilaColaConListaEnlazada04` |
| 5 | `PilaColaConListaEnlazada05` |
| 6 | `PilaColaConListaEnlazada06` |
| 7 | `PilaColaConListaEnlazada07` |
| 8 | `PilaColaConListaEnlazada08` |
| 9 | `PilaColaConListaEnlazada09` |
| 10 | `PilaColaConListaEnlazada10` |

Cada `main` usa entradas predefinidas e incluye una demostración ejecutable; no requiere interacción ni menú.

## Javadoc y pruebas

Generá documentación de API con:

```sh
javadoc --release 21 -d docs src/*.java
```

Las pruebas reproducibles y los resultados observados están en [PRUEBAS.md](PRUEBAS.md). `out/` y `docs/` son artefactos generados y no deben versionarse.
