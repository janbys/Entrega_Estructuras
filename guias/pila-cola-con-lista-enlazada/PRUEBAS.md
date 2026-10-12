# Pruebas de ejecución — PilaColaConListaEnlazada

Pruebas con demostraciones deterministas de los diez `main`, ejecutadas con Java 21. Las salidas se muestran como líneas relevantes, omitiendo solo etiquetas de contexto repetitivas.

## Compilación y Javadoc

Desde esta carpeta se ejecutaron:

```sh
javac --release 21 -Xlint:all -d /tmp/pila-cola-lista-classes src/*.java
javadoc --release 21 -quiet -Xdoclint:all -d /tmp/pila-cola-lista-docs src/*.java
```

**Resultado esperado/observado:** compilación sin errores ni advertencias; documentación Javadoc generada con doclint estricto.

## Ejercicio 1 — Pila enlazada de enteros

**Datos:** apilar 10, 20, 30; consultar tope, buscar 20 y 99, imprimir y desapilar todo.

```text
Contenido tope→fondo: 30 -> 20 -> 10 -> null
peek=30, contiene 20=true, contiene 99=false
pop: 30, 20, 10; vacía=true
pop vacío: La pila está vacía.
peek vacío: La pila está vacía.
```

## Ejercicio 2 — Cola enlazada de enteros

**Datos:** encolar 10, 20, 30; consultar frente; buscar 20/99; retirar todos; probar transición de un elemento y errores vacíos.

```text
Cola: 10 -> 20 -> 30 -> null, front=10
contains(20)=true, contains(99)=false
dequeue: 10, 20, 30; vacía=true
Único elemento: 7; vacía=true, contenido=null
dequeue vacío: La cola está vacía.
front vacío: La cola está vacía.
```

## Ejercicio 3 — Pila genérica

**Datos:** pila de Integer (10,20), pila String (primero, segundo) y pila Producto (Cuaderno).

```text
Integer: 20 -> 10 -> null, peek=20, contiene10=true
String: segundo -> primero -> null, pop=segundo
Producto: Producto[nombre=Cuaderno] -> null, contiene=true
peek vacío: La pila está vacía.
```

## Ejercicio 4 — Cola genérica

**Datos:** cola de nombres Ana/Luis y cola de Cliente Marta/Caja, Pablo/Tarjeta.

```text
Nombres: Ana -> Luis -> null, front=Ana, dequeue=Ana
Clientes: Cliente[nombre=Marta, categoria=Caja] -> Cliente[nombre=Pablo, categoria=Tarjeta] -> null, contiene Pablo=true, primero atendido=Cliente[nombre=Marta, categoria=Caja]
dequeue vacío: La cola está vacía.
```

## Ejercicio 5 — Historial

**Datos:** visitar inicio, búsqueda y artículo; imprimir, volver, consultar y agotar historial.

```text
Historial actual→anterior: https://articulo.test -> https://busqueda.test -> https://inicio.test -> null
Página actual: https://articulo.test
Volver desde: https://articulo.test; ahora: https://busqueda.test
Volver sin páginas: El historial está vacío.
Consultar vacío: El historial está vacío.
```

## Ejercicio 6 — Cola de atención

**Datos:** Ana (101, Depósitos), Bruno (102, Tarjeta); consultar, atender ambos y volver a atender vacío.

```text
Fila: Cliente[nombre=Ana, turno=101, motivo=Depósitos] -> Cliente[nombre=Bruno, turno=102, motivo=Tarjeta] -> null
Sigue: Cliente[nombre=Ana, turno=101, motivo=Depósitos]
Atendido: Cliente[nombre=Ana, turno=101, motivo=Depósitos]
Fila restante: Cliente[nombre=Bruno, turno=102, motivo=Tarjeta] -> null
Atendido: Cliente[nombre=Bruno, turno=102, motivo=Tarjeta]; vacía=true
Atención vacía: No hay clientes en espera.
```

## Ejercicio 7 — Paréntesis balanceados

```text
"(2 + 3) * (5 - 1)" → válida
"((a + b) * c)" → válida
"(2 + 3" → inválida
"())(" → inválida
"" → válida
"(x+(y*z))" → válida
```

## Ejercicio 8 — Invertir palabra

```text
"algoritmo" → "omtirogla"
"" → ""
"A" → "A"
"Hola Mundo" → "odnuM aloH"
```

## Ejercicio 9 — Cola de impresión

**Datos:** informe.pdf/3 páginas/Ana y tarea.docx/5 páginas/Luis; después se prueba un documento de cero páginas.

```text
Pendientes: TrabajoImpresion[nombreArchivo=informe.pdf, paginas=3, usuario=Ana] -> TrabajoImpresion[nombreArchivo=tarea.docx, paginas=5, usuario=Luis] -> null; próximo=informe.pdf
Impreso: TrabajoImpresion[nombreArchivo=informe.pdf, paginas=3, usuario=Ana]
Trabajo inválido: La cantidad de páginas debe ser positiva.
Consulta vacía: No hay trabajos pendientes.
```

## Ejercicio 10 — Lista doblemente enlazada genérica

**Datos:** probar lista vacía, nodo único 20, luego lista 10,20,30,40; recorridos en ambos sentidos; eliminar cabeza, medio, cola, ausente y último nodo.

```text
Vacía: true, adelante=null, atrás=null
Único: 20 <-> null; eliminar único=true, vacía=true
Lista: 10 <-> 20 <-> 30 <-> 40 <-> null
Reversa: 40 <-> 30 <-> 20 <-> 10 <-> null
Eliminar cabeza 10=true: 20 <-> 30 <-> 40 <-> null
Eliminar medio 30=true: 20 <-> 40 <-> null
Eliminar cola 40=true: 20 <-> null
Eliminar ausente 99=false; size=1
Eliminar último nodo 20=true; vacía=true, size=0
String adelante: Ana <-> Luis <-> null; atrás: Luis <-> Ana <-> null
```

Los casos vacíos de pila/cola, transición de un elemento a vacía, valores inválidos de páginas, FIFO/LIFO y ambos recorridos de la lista doble se verificaron.
