# Especificación técnica — Listas enlazadas simples

## 1. Objetivo

Desarrollar diez ejercicios académicos sobre listas enlazadas simples en Java 21, con apoyo de OpenCode. La prioridad es razonar y explicar nodos, referencias, `head`, recorrido secuencial, inserción, eliminación, modificación y actualización de enlaces; no solo entregar código funcional.

La guía se mantiene independiente en `guias/listas-enlazadas-simples/`, según la organización del repositorio. Cada ejercicio tendrá una clase ejecutable propia y utilizará demostraciones deterministas en `main` con datos previamente definidos, de acuerdo con la aclaración del alumno.

## 2. Entregables por ejercicio

Para cada uno de los diez ejercicios se entregará:

1. Una solución Java independiente en `src/`.
2. Un prompt inicial completo para OpenCode, en su sección de `PROMPTS.md` y copiado sin alteraciones en un comentario inicial del archivo Java, respetando el formato pedido por la consigna:
   - `Prompt inicial utilizado:`
   - contenido completo del prompt;
   - `Ajustes realizados luego de la primera respuesta de OpenCode:`
   - breve explicación de ajustes, o indicación explícita de que no hubo ajustes.
3. Una prueba de ejecución reproducible con los valores de entrada definidos y los resultados esperados/observados, documentada en `PRUEBAS.md` y resumida en el Javadoc de clase.

Los prompts deben evidenciar comprensión del problema, razonamiento, casos a contemplar y estructura de clases necesaria. Deben explicar la lógica de lista enlazada específica del ejercicio.

## 3. Lenguaje, herramientas y restricciones comunes

- Lenguaje y versión: Java 21.
- Herramienta de asistencia indicada: OpenCode. Los prompts se documentan para uso independiente, uno por ejercicio.
- No agregar dependencias externas, frameworks, `ArrayList`, `LinkedList` ni estructuras equivalentes para implementar los ejercicios 1 a 9.
- Usar nodos enlazados definidos en el proyecto; no simular una lista enlazada mediante un arreglo.
- Cada ejercicio debe compilar y ejecutarse independientemente y no debe depender de otra clase de ejercicio.
- La solución separa las operaciones de lista de la demostración en `main`. No se requiere lectura interactiva: los ejemplos se definen previamente en `main`.
- Se permiten ciclos para recorrer los nodos. No se requiere recursión.
- Usar nombres descriptivos y documentar con Javadoc la consigna, propósito, estructura, algoritmo, parámetros, resultados, efectos laterales, límites, excepciones y complejidad temporal/espacial cuando corresponda.
- Agregar comentarios explicativos donde se modifican referencias; no escribir comentarios que solo repitan las instrucciones del código.
- La salida de cada `main` debe identificar el ejercicio, los datos iniciales y los resultados clave, de modo que la ejecución pueda usarse como evidencia de prueba.
- Mantener datos de prueba pequeños y deterministas, incluyendo las situaciones límite pertinentes.

## 4. Modelo general de lista y errores

### 4.1 Nodo y cabeza

- Cada nodo enlazado contiene un dato y una referencia al nodo siguiente.
- `head` referencia al primer nodo o es `null` si la lista está vacía.
- Los nodos se recorren desde `head` siguiendo sucesivamente `siguiente` hasta encontrar el objetivo o llegar a `null`.
- La lista mantiene un atributo `size` coherente con el número de nodos alcanzables desde `head`.
- La lista vacía cumple `head == null` y `size == 0`; el último nodo tiene `siguiente == null`.

### 4.2 Posiciones inválidas

- Los métodos que reciben posiciones deben validar la posición antes de recorrer o modificar nodos.
- Para obtener, modificar o eliminar por posición, son válidas solamente las posiciones $0 \le p < size$.
- Para insertar en una posición, son válidas las posiciones $0 \le p \le size$: `0` inserta al inicio, `size` al final y valores intermedios insertan entre nodos.
- Una posición inválida lanza `IndexOutOfBoundsException` con mensaje claro. La operación inválida no modifica `head`, enlaces, datos ni `size`.
- Las listas vacías se admiten: búsqueda devuelve `false`, conteo devuelve `0`, impresión muestra una representación vacía; obtener/modificar/eliminar por posición fallan por índice inválido. Insertar en posición `0` es válido.

### 4.3 Igualdad en el ejercicio genérico

En la lista genérica, las operaciones que comparan datos (`buscar`, `eliminar` y `contarOcurrencias`) usan igualdad de objetos mediante `Objects.equals`. Esto permite comparar valores genéricos y soporta referencias `null`; las comparaciones de `Alumno` usan igualdad de valor del tipo elegido para la demostración (por ejemplo, un `record`).

## 5. Requisitos funcionales por ejercicio

### Ejercicio 1 — Crear lista enlazada simple desde cero

- Clase sugerida: `ListasEnlazadasSimples01`.
- Implementar una lista propia de enteros con nodo que guarda `int dato` y referencia al siguiente, sin colecciones de Java.
- Operaciones públicas: `insertarAlInicio(int dato)`, `insertarAlFinal(int dato)`, `imprimir()`, `estaVacia()` y `getSize()`.
- Al insertar al inicio, el nodo nuevo pasa a ser `head` y apunta a la antigua cabeza.
- Al insertar al final, recorrer hasta el nodo cuyo siguiente sea `null`; si estaba vacía, el nodo nuevo pasa a ser `head`.
- Actualizar `size` exactamente una vez por inserción.
- Demostrar lista vacía, inserción inicial y final, impresión de una secuencia y tamaño. `insertarAlFinal` es $O(n)$; inserción al inicio, consultas de vacío y tamaño son $O(1)$; espacio total $O(n)$.

### Ejercicio 2 — Buscar elementos

- Clase sugerida: `ListasEnlazadasSimples02`.
- Implementar `boolean buscar(int dato)` sobre una lista simple de enteros.
- Empezar en `head` y avanzar nodo por nodo hasta encontrar el valor (devolver `true`) o llegar a `null` (devolver `false`).
- Explicar que no existe acceso directo por índice como en un arreglo: para alcanzar un nodo hay que seguir enlaces secuencialmente.
- Demostrar búsqueda exitosa al inicio y en un nodo posterior, valor ausente y lista vacía. Tiempo $O(n)$, espacio adicional $O(1)$.

### Ejercicio 3 — Obtener un elemento por posición

- Clase sugerida: `ListasEnlazadasSimples03`.
- Implementar `int obtener(int posicion)` en la lista de enteros.
- Validar previamente que $0 \le posicion < size$; si no se cumple, lanzar `IndexOutOfBoundsException` sin recorrer ni cambiar la lista.
- Para una posición válida, iniciar en `head` y avanzar exactamente `posicion` enlaces; devolver el dato del nodo alcanzado.
- Explicar que el número de posición no implica acceso directo: la lista se recorre desde el inicio.
- Demostrar primera, intermedia y última posición, además de posiciones `-1` y `size` inválidas. Tiempo $O(n)$ en el peor caso, espacio adicional $O(1)$.

### Ejercicio 4 — Insertar en una posición

- Clase sugerida: `ListasEnlazadasSimples04`.
- Implementar `void insertarEnPosicion(int dato, int posicion)`.
- Validar que $0 \le posicion \le size$ antes de modificar.
- Si `posicion == 0`, enlazar el nuevo nodo antes de la cabeza y actualizar `head`.
- Si `posicion == size`, insertar al final.
- Para inserción intermedia, recorrer hasta el nodo previo a la posición y preservar el resto de la lista en este orden: primero `nuevo.siguiente = actual.siguiente`; luego `actual.siguiente = nuevo`.
- Explicar que actualizar primero el enlace del nodo anterior sin guardar el enlace original puede desconectar y perder acceso al resto de la lista.
- Incrementar `size` una sola vez después de una inserción correcta.
- Demostrar inicio, medio y final, lista inicialmente vacía y posiciones inválidas `-1` y `size + 1`. Búsqueda de previo $O(n)$, enlace $O(1)$; espacio total $O(n)$.

### Ejercicio 5 — Eliminar por valor

- Clase sugerida: `ListasEnlazadasSimples05`.
- Implementar `boolean eliminar(int dato)` que quite la primera aparición y devuelva `true`; devolver `false` si la lista está vacía o no aparece.
- Si coincide `head`, avanzar `head` al siguiente nodo.
- En otro caso, recorrer manteniendo referencia al nodo anterior; al hallar el objetivo, enlazar el anterior directamente con el siguiente del nodo eliminado.
- Decrementar `size` exactamente una vez si se eliminó un nodo; no modificarla si el dato no existe.
- Explicar que Java no requiere liberar manualmente un nodo: al dejarlo inaccesible desde la lista, el Garbage Collector podrá recuperarlo cuando ya no existan referencias alcanzables.
- Demostrar lista vacía, eliminar cabeza, nodo intermedio y cola, y dato inexistente. Tiempo $O(n)$, espacio adicional $O(1)$.

### Ejercicio 6 — Eliminar por posición

- Clase sugerida: `ListasEnlazadasSimples06`.
- Implementar `void eliminarEnPosicion(int posicion)`.
- Validar $0 \le posicion < size$ antes del recorrido.
- Para posición cero, actualizar `head` al nodo siguiente. Para las restantes, recorrer hasta el nodo anterior y hacer que su enlace saltee el nodo eliminado: `anterior.siguiente = eliminado.siguiente`.
- Actualizar `size` una sola vez tras eliminar. La posición inválida lanza `IndexOutOfBoundsException` y no cambia la lista.
- Demostrar eliminación de la cabeza, un nodo intermedio y el último, más índice negativo y `size` inválido. Tiempo $O(n)$, espacio adicional $O(1)$.

### Ejercicio 7 — Modificar un elemento

- Clase sugerida: `ListasEnlazadasSimples07`.
- Implementar `void modificar(int posicion, int nuevoDato)`.
- Validar la posición antes de iniciar el recorrido; posiciones válidas $0 \le posicion < size$.
- Recorrer desde `head` hasta el nodo indicado y reemplazar solamente su campo de dato.
- No cambiar la referencia `siguiente`, `head` ni `size` al modificar.
- Demostrar actualización en primera, intermedia o última posición y rechazo de `-1` y `size`. Tiempo $O(n)$, espacio adicional $O(1)$.

### Ejercicio 8 — Contar ocurrencias

- Clase sugerida: `ListasEnlazadasSimples08`.
- Implementar `int contarOcurrencias(int dato)` recorriendo desde `head` hasta `null` y aumentando un contador por cada coincidencia.
- No terminar en la primera coincidencia porque se requiere el total de apariciones.
- Para la lista `10 -> 20 -> 10 -> 30 -> 10 -> null`, consultar `10` debe devolver `3`.
- Demostrar múltiples apariciones, un dato ausente y lista vacía. Tiempo $O(n)$, espacio adicional $O(1)$.

### Ejercicio 9 — Invertir una lista

- Clase sugerida: `ListasEnlazadasSimples09`.
- Implementar `void invertir()` in-place, sin crear una segunda lista ni perder nodos.
- Usar referencias auxiliares `anterior`, `actual` y `siguiente`: guardar el siguiente nodo antes de cambiar el enlace actual, apuntar actual hacia anterior, avanzar anterior y actual usando el enlace guardado; al finalizar actualizar `head` a la nueva cabeza.
- Explicar que el orden es esencial: si se sobreescribe `actual.siguiente` antes de guardar el siguiente nodo original, se pierde acceso al resto del recorrido.
- La operación no cambia `size`. Lista vacía y de un nodo permanecen sin cambios.
- Demostrar lista vacía, un nodo, y `10 -> 20 -> 30 -> 40 -> null` que se transforma en `40 -> 30 -> 20 -> 10 -> null`. Tiempo $O(n)$, espacio adicional $O(1)$.

### Ejercicio 10 — Versión genérica

- Clase sugerida: `ListasEnlazadasSimples10`.
- Implementar clases genéricas `ListaEnlazada<T>` y `Nodo<T>`, con referencias tipadas al dato y al siguiente nodo.
- Transformar la lista de enteros en una estructura genérica que ofrece las mismas operaciones desarrolladas previamente: insertar al inicio/final, imprimir, consultar vacío/tamaño, buscar, obtener por posición, insertar en posición, eliminar primera aparición, eliminar por posición, modificar dato, contar ocurrencias e invertir.
- Mantener las reglas de posiciones, `size`, enlaces, casos límites y complejidades que se especifican para los ejercicios anteriores.
- Comparar valores con `Objects.equals` en búsqueda, eliminación por dato y conteo. La igualdad de `Alumno` será la igualdad del tipo (por ejemplo, por datos de un `record`).
- Demostrar instancias separadas `ListaEnlazada<Integer>`, `ListaEnlazada<String>` y `ListaEnlazada<Alumno>`; no mezclar tipos en una instancia.
- Explicar qué cambia: el tipo del dato y del nodo pasa a `T`, y operaciones comparativas usan igualdad de objetos. Qué se mantiene: enlaces, `head`, recorrido secuencial, orden de actualización, `size` e invariantes no dependen del tipo almacenado.
- Complejidades por operación conservan el orden de los ejercicios 1–9; la inversión es $O(n)$ temporal y $O(1)$ adicional.

## 6. Estructura prevista

En `guias/listas-enlazadas-simples/`:

- `README.md`: descripción de la guía, herramientas y comandos Java 21 para compilar/ejecutar cada clase y generar Javadoc.
- `ESPECIFICACION.md`: este documento.
- `PROMPTS.md`: diez prompts independientes, completos y listos para OpenCode.
- `PRUEBAS.md`: datos previamente definidos por clase, pasos de ejecución, resultados observados y validaciones de límites.
- `src/`: diez archivos fuente independientes, con nombres propuestos:
  1. `ListasEnlazadasSimples01.java`
  2. `ListasEnlazadasSimples02.java`
  3. `ListasEnlazadasSimples03.java`
  4. `ListasEnlazadasSimples04.java`
  5. `ListasEnlazadasSimples05.java`
  6. `ListasEnlazadasSimples06.java`
  7. `ListasEnlazadasSimples07.java`
  8. `ListasEnlazadasSimples08.java`
  9. `ListasEnlazadasSimples09.java`
  10. `ListasEnlazadasSimples10.java`

Cada clase contiene su propia implementación necesaria y `main` determinista; no centralizar nodos o listas en otro ejercicio de modo que las clases pierdan independencia.

## 7. Casos límite transversales

- Lista vacía: operaciones de inserción y consultas de estado correctas; búsquedas false; ocurrencias cero; impresión vacía; índices inválidos rechazados.
- Un solo nodo: insertar/eliminar/obtener/modificar/invertir y tamaño consistentes.
- Inserción en posición: cero, medio, `size` (fin), negativo y mayor que `size`.
- Eliminación: cabeza, medio, cola, primer duplicado, elemento inexistente, lista vacía, índice negativo y `size` como índice inválido.
- Búsqueda/conteo: primer nodo, último, duplicados y ausencia.
- Inversión: lista vacía, un nodo, dos nodos y varios nodos.
- Genéricos: listas separadas de Integer, String y Alumno; valores repetidos para comprobar equality; no mezclar tipos en una lista.
- Después de toda operación válida, el número de nodos alcanzables debe ser igual a `size`, y el último nodo debe terminar en `null`.
- Toda operación inválida debe dejar la secuencia y el tamaño sin modificaciones.

## 8. Complejidad esperada

Sea $n$ el tamaño de la lista:

- insertar al inicio, vacío y tamaño: $O(1)$.
- insertar al final, búsqueda, obtener, inserción por posición, eliminar por dato/posición, modificación y conteo: $O(n)$ en el peor caso por recorrido.
- imprimir: $O(n)$.
- invertir in-place: $O(n)$ tiempo y $O(1)$ espacio adicional.
- La lista ocupa $O(n)$ espacio por sus nodos; el ejercicio genérico tiene el mismo costo estructural.

## 9. Criterios de aceptación

- Existe una guía independiente en `guias/listas-enlazadas-simples/` con README, especificación, prompts, pruebas y diez fuentes Java.
- Las diez clases compilan con Java 21 y se ejecutan sin requerir la ejecución de otros ejercicios.
- No se utilizan `ArrayList`, `LinkedList`, arreglos para emular la secuencia enlazada ni bibliotecas externas.
- Los comentarios iniciales con prompts coinciden con sus secciones en `PROMPTS.md` y respetan el formato requerido de ajustes realizados.
- Cada ejemplo en `main` es determinista, documentado y cubierto en `PRUEBAS.md` con valores y resultados.
- Las operaciones mantienen correctamente `head`, enlaces y `size`; las posiciones inválidas producen `IndexOutOfBoundsException` antes de alterar la lista.
- Búsqueda y conteo recorren la lista completa cuando deben hacerlo; eliminación por valor quita solo la primera ocurrencia; inversión conserva todos los nodos en orden inverso.
- La lista genérica funciona de forma independiente para `Integer`, `String` y `Alumno` y mantiene el mismo comportamiento algorítmico.
- README contiene instrucciones para compilar, ejecutar y probar; no se modifican otras guías ni se agregan requisitos no derivados de la consigna o de las aclaraciones acordadas.
