# Guía: Recursividad

Especificación para diez ejercicios introductorios de recursividad en Java 21.

## Contenido

- [Especificación](ESPECIFICACION.md): requisitos funcionales, criterios y estructura esperada.
- [Prompts para OpenCode](PROMPTS.md): un prompt independiente por ejercicio.
- `src/`: diez soluciones Java independientes, con Javadoc y ejemplos en `main`.

## Compilar y ejecutar

Desde esta carpeta, compilar las clases en un directorio de salida:

```sh
mkdir -p out
javac --release 21 -d out src/*.java
```

Ejecutar individualmente la clase del ejercicio deseado, por ejemplo:

```sh
java -cp out Recursividad01
```

Cada clase tiene su propio `main`; no se requiere un menú central.

## Generar Javadoc

```sh
javadoc --release 21 -d docs src/*.java
```

Los directorios `out/` y `docs/` son artefactos generados y no deben versionarse.
