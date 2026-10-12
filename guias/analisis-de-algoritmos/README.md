# Guía: Análisis de algoritmos

Implementación en Java 21 de diez ejercicios sobre vectores, matrices y ordenamiento.

## Contenido

- [Especificación](ESPECIFICACION.md): requisitos funcionales y técnicos.
- [Prompts para OpenCode](PROMPTS.md): un prompt por ejercicio.
- `src/`: soluciones Java independientes, con Javadoc y ejemplos en `main`.

## Compilar y ejecutar

Desde esta carpeta, compilar las clases en un directorio temporal o de salida:

```sh
mkdir -p out
javac --release 21 -d out src/*.java
```

Ejecutar individualmente la clase deseada, por ejemplo:

```sh
java -cp out AnalisisDeAlgoritmos01
```

Las demás clases se llaman `AnalisisDeAlgoritmos02` hasta `AnalisisDeAlgoritmos10`. Cada una contiene su propio `main`; no hace falta ejecutar un menú central.

Para generar la documentación Javadoc:

```sh
javadoc --release 21 -d docs src/*.java
```

Los directorios `out/` y `docs/` son artefactos generados y no deben versionarse.
