# Especificación técnica — Unidad 4: Pilas y Colas con Arreglos

## 1. Objetivo

Desarrollar diez ejercicios introductorios de pilas y colas en Java 21 utilizando arreglos como estructura interna. En cada ejercicio el alumno debe razonar primero y entregar un prompt claro para OpenCode antes de generar o implementar la solución. La carpeta de esta guía es independiente de las unidades anteriores: `guias/pilas-colas-con-arreglo/`.

Cada ejercicio tendrá una clase Java ejecutable y autónoma. La estructura de la guía deberá seguir el modelo de `guias/recursividad/`: `README.md`, `ESPECIFICACION.md`, `PROMPTS.md` y archivos independientes bajo `src/`.

## 2. Requisitos comunes

- Lenguaje y versión: Java 21.
- Sin frameworks, bibliotecas externas ni dependencias.
- La interacción será por consola mediante un menú que permita repetir operaciones y elegir salir.
- La capacidad del arreglo se solicita al iniciar cada programa y debe ser un entero no negativo. Capacidad cero es válida: la estructura comienza vacía y llena; no admite inserciones y las consultas/eliminaciones por vacío producen el error definido más abajo.
- Las clases de datos no genéricas se implementan con arreglos de capacidad fija; no se redimensionan ni desplazan elementos para ocultar los límites del ejercicio.
- Los métodos de operación deben estar separados de la interacción del menú, tener nombres descriptivos y estar documentados con Javadoc.
- Al intentar agregar en una estructura llena o quitar/consultar un elemento cuando está vacía, los métodos lanzan `IllegalStateException` con un mensaje claro. El menú captura el error de cada operación, lo comunica y continúa ejecutándose.
- Capacidad negativa, texto no numérico donde se espera un número y opciones inexistentes se informan claramente. No deben corromperse índices ni estado interno.
- Cada archivo fuente debe comenzar con un comentario que contenga íntegro el prompt inicial de OpenCode de ese ejercicio. Al final debe indicar si el prompt se ajustó y resumir el ajuste o indicar que no hubo cambios.
- El `PROMPTS.md` debe contener esos diez prompts completos, listos para usar. El texto de cada prompt inicial copiado al archivo fuente debe coincidir con la sección correspondiente de `PROMPTS.md`.
- Cada clase debe tener Javadoc con consigna, objetivo, elección/representación de la estructura, operaciones, razonamiento, datos de entrada y resultados, errores, casos límite y complejidades pertinentes. Debe incluir un ejemplo de ejecución reproducible con datos representativos.
- Entregables obligatorios por ejercicio, según el cierre del práctico:
	1. El archivo fuente Java de la solución.
	2. El prompt inicial completo de OpenCode como comentario al comienzo del fuente y en la sección correspondiente de `PROMPTS.md`.
	3. Una nota explícita al final del fuente que diga si el prompt fue ajustado; si hubo ajustes, enumerarlos brevemente y explicar el motivo; si no, escribir que no hubo cambios.
	4. Una prueba de ejecución con datos de ejemplo, documentando los datos ingresados y el resultado observado o esperado en el Javadoc de clase.
- La prueba documentada debe incluir al menos una secuencia normal que muestre las operaciones principales del ejercicio. Los casos límite adicionales se detallan en los requisitos de cada ejercicio y en esta especificación.
- Los métodos públicos deben documentar parámetros, resultados, efectos y excepciones.
- No crear un menú general compartido ni dependencias entre clases de ejercicios. Cada clase se compila y ejecuta de forma independiente.

## 3. Requisitos por ejercicio

### Ejercicio 1 — Pila de enteros

- Clase sugerida: `PilasColasConArreglo01`.
- Implementar `PilaEnteros` con un `int[]` de capacidad fija y las operaciones `push`, `pop`, `peek`, `isEmpty`, `isFull` y `size`.
- Definir `top` como índice del elemento superior: empieza en `-1`; `push` aumenta el índice y luego almacena, `pop` recupera y elimina lógicamente el elemento superior y reduce el índice. `peek` no modifica la pila.
- Invariante: `size == top + 1`; vacía si `top == -1`; llena si `top == capacidad - 1` (también vacía y llena con capacidad cero, dado que no puede almacenarse ningún elemento).
- El menú debe permitir ejecutar las seis operaciones, ingresar el valor al hacer `push` y consultar la condición de lleno/vacío y tamaño.
- Incluir ejemplo reproducible de apilar, consultar, desapilar, y errores al apilar llena o consultar/desapilar vacía.
- Complejidad: todas las operaciones $O(1)$; espacio $O(c)$ por la capacidad $c$.

### Ejercicio 2 — Simulador de torre de platos

- Clase sugerida: `PilasColasConArreglo02`.
- Representar platos con `String` (nombre o descripción) y guardarlos en un arreglo fijo como una pila.
- Menú: agregar plato superior (`push`), retirar plato superior (`pop`), consultar plato superior (`peek`), mostrar estado y salir.
- Explicar que una torre se comporta LIFO: el último plato colocado es el primero accesible para retirar. Una cola FIFO retiraría el plato que se colocó primero y no representa el acceso natural a la parte superior.
- Mostrar estado actualizado tras agregar o retirar platos y cubrir pila vacía y pila llena con excepciones manejadas.
- Complejidad de las operaciones de extremo: $O(1)$; espacio $O(c)$.

### Ejercicio 3 — Validar paréntesis balanceados

- Clase sugerida: `PilasColasConArreglo03`.
- Leer una expresión matemática completa por línea y determinar si los paréntesis `(` y `)` están balanceados. Otros caracteres no alteran el balance.
- Usar una pila de capacidad suficiente para la expresión, sin una estructura externa ni dependencia de la pila del ejercicio 1.
- Ante `(`, apilarlo. Ante `)`, si no hay un abierto disponible la expresión es inválida; de lo contrario, desapilar el abierto correspondiente.
- Al final, es válida solo si no se detectó un cierre sobrante y la pila quedó vacía.
- Demostrar las expresiones de ejemplo: `(5 + 3) * (2 + 1)` válida y `(5 + 3)) * (2 + 1` inválida. Añadir cadena vacía, paréntesis anidados y casos con cierres/aperturas faltantes.
- Aclarar que se valida exclusivamente el balance de paréntesis, no la sintaxis completa de la expresión. Complejidad: tiempo $O(n)$, espacio máximo $O(n)$ para una expresión de longitud $n$.

### Ejercicio 4 — Historial de navegación

- Clase sugerida: `PilasColasConArreglo04`.
- Guardar URLs (`String`) visitadas en una pila de capacidad fija; apilar cada visita nueva.
- Menú: visitar URL, volver a la página anterior mediante `pop`, consultar la página actual mediante `peek`, mostrar historial almacenado y salir.
- Interpretación del alcance: cada visita apila una URL y `pop` la quita y regresa a la URL anterior, si existe. No se requiere una segunda pila de avance ni navegación hacia adelante.
- Explicar LIFO: la última página visitada es la primera que se retira al volver.
- Informar cuando no haya página actual/anterior y al superar capacidad; capturar `IllegalStateException` y continuar.
- Complejidad por operación de pila $O(1)$; espacio $O(c)$.

### Ejercicio 5 — Pila genérica

- Clase sugerida: `PilasColasConArreglo05`.
- Implementar una clase interna o auxiliar `Pila<T>` basada en un `Object[]` fijo, con `push`, `pop`, `peek`, `isEmpty`, `isFull` y `size`.
- No intentar crear directamente `new T[]`, que Java no permite por borrado de tipos. Al recuperar elementos, realizar una conversión controlada a `T` y documentar la advertencia de tipos inherente al arreglo interno.
- La API genérica debe conservar el tipo estático para el usuario; no se permiten mezclar tipos dentro de una instancia como medio para eludir el genérico.
- El menú de demostración debe permitir elegir una prueba concreta para `Pila<Integer>`, `Pila<String>` y un objeto simple definido en la clase, por ejemplo `Producto` con nombre y precio. No se requiere un editor interactivo de objetos.
- Explicar qué resuelve el genérico: reutiliza la misma implementación para distintos tipos con comprobación estática, frente a una pila específica para `int` que solo almacena enteros primitivos/valores enteros.
- Aplicar los mismos límites, excepciones e invariantes de la pila del ejercicio 1. Operaciones $O(1)$, almacenamiento $O(c)$.

### Ejercicio 6 — Cola simple de enteros

- Clase sugerida: `PilasColasConArreglo06`.
- Implementar `ColaEnteros` en un arreglo lineal de capacidad fija con `enqueue`, `dequeue`, `front`, `isEmpty`, `isFull` y `size`.
- `front` señala la posición del elemento más antiguo; `rear` señala la posición del último elemento agregado. La cola almacena en el intervalo lineal desde `front` hasta `rear` cuando no está vacía.
- Especificar invariantes de índices para cola vacía, primer `enqueue`, posteriores `enqueue` y eliminación del último elemento. No desplazar datos automáticamente ni reutilizar huecos liberados al inicio: esa limitación es el tema del ejercicio 9.
- Para hacer las operaciones básicas $O(1)$ sin corrimiento, mantener también un contador `size`. `enqueue` avanza `rear` una posición si hay capacidad física; `dequeue` avanza `front`; al quedar vacía, restaurar estado vacío de manera consistente.
- El menú permite insertar, retirar, consultar frente, estado lleno/vacío y tamaño. Errores de cola llena/vacía se manejan con `IllegalStateException`.
- Complejidad $O(1)$ por operación, espacio $O(c)$.

### Ejercicio 7 — Sistema de turnos

- Clase sugerida: `PilasColasConArreglo07`.
- Usar una cola lineal de capacidad fija que almacene nombres de personas (`String`). Cada persona que llega se agrega al final; se atiende y retira a la persona del frente.
- Menú: registrar persona, atender siguiente, consultar quién está primero, mostrar fila y salir.
- Explicar FIFO: la primera persona que llega es la primera atendida. LIFO atendería a la última llegada y alteraría la prioridad de espera.
- Mostrar la fila tras registros/atenciones. Manejar cola vacía/llena; no asignar folios numéricos, ya que no forman parte de la consigna.
- Usar las reglas de cola simple y documentar que puede ocurrir desperdicio de huecos iniciales.
- Complejidad $O(1)$ por operación; espacio $O(c)$.

### Ejercicio 8 — Cola de impresión

- Clase sugerida: `PilasColasConArreglo08`.
- Definir un documento con nombre (`String`) y cantidad de páginas (`int`); almacenar registros completos en una cola simple de capacidad fija.
- Menú: agregar documento a la cola, imprimir/retirar el documento del frente, consultar el próximo documento, mostrar cola y salir.
- Validar cantidad de páginas como entero positivo. Conservar nombre y páginas asociados en todas las operaciones.
- Explicar que FIFO garantiza impresión en el mismo orden en que se agregaron los documentos.
- Manejar cola llena/vacía con las excepciones comunes. No simular duración real ni realizar impresión en una impresora.
- Complejidad de encolar/desencolar/consultar frente $O(1)$, espacio $O(c)$.

### Ejercicio 9 — Desperdicio de espacio en una cola simple

- Clase sugerida: `PilasColasConArreglo09`.
- Implementar una cola lineal de enteros basada en arreglo, sin wrap-around ni corrimiento automático.
- Mostrar el contenido físico del arreglo, posiciones libres, `front`, `rear` y tamaño luego de cada operación `enqueue` y `dequeue`.
- Demostrar que, tras retirar elementos iniciales, quedan celdas libres al inicio que una cola lineal simple no reutiliza; al llegar `rear` al último índice ya no puede insertar aunque `size < capacidad`.
- El menú permite insertar, retirar, mostrar estado y salir para poder reproducir el caso. Documentar una secuencia de demostración con capacidad de al menos 3: llenar, retirar al menos un elemento y luego intentar encolar hasta el límite físico.
- La inserción falla cuando no queda posición al final del arreglo, aunque existan huecos iniciales; debe informarse como límite del diseño, no tratarse como bug. `dequeue` falla al estar vacía.
- Explicar que el ejercicio muestra una limitación de la cola lineal que resuelve la circular del ejercicio 10, no implementar la solución circular aquí.

### Ejercicio 10 — Cola circular

- Clase sugerida: `PilasColasConArreglo10`.
- Implementar una cola circular de enteros en un arreglo de capacidad fija, con `enqueue`, `dequeue`, `front`, `isEmpty`, `isFull` y `size`.
- Mantener `front`, `rear` y `size`; definir y documentar los valores iniciales y el estado luego de encolar el primer elemento, al avanzar y al retirar el último. Con contador de tamaño, `isEmpty` equivale a `size == 0` e `isFull` a `size == capacidad`.
- Tras encolar, avanzar `rear` mediante `(rear + 1) % capacidad`; tras desencolar, avanzar `front` mediante `(front + 1) % capacidad`. Comprobar llena/vacía antes de aplicar módulo para evitar división por cero con capacidad cero.
- El menú permite las operaciones, mostrar arreglo y estado de índices, y salir. Incluir secuencia que llene, retire elementos iniciales y vuelva a encolar para demostrar reutilización de espacios liberados.
- Manejar errores llena/vacía sin modificar el estado. Para capacidad cero, `isEmpty` y `isFull` son verdaderas; no se permiten inserciones ni consultas/eliminaciones de elementos.
- Complejidad $O(1)$ por operación, espacio $O(c)$.

## 4. Estructura de archivos

Dentro de `guias/pilas-colas-con-arreglo/`:

- `README.md`: consigna resumida, lista de ejercicios, Java 21 y comandos para compilar, ejecutar individualmente, probar y generar Javadoc.
- `ESPECIFICACION.md`: este documento.
- `PROMPTS.md`: prompt independiente completo para OpenCode por ejercicio, que incluya estructura, razonamiento, operaciones, índices internos, entradas/salidas, errores, casos límite, comentarios requeridos y verificación.
- `src/PilasColasConArreglo01.java` hasta `src/PilasColasConArreglo10.java`: clases independientes.

Los nombres sugeridos completos son:

1. `PilasColasConArreglo01`
2. `PilasColasConArreglo02`
3. `PilasColasConArreglo03`
4. `PilasColasConArreglo04`
5. `PilasColasConArreglo05`
6. `PilasColasConArreglo06`
7. `PilasColasConArreglo07`
8. `PilasColasConArreglo08`
9. `PilasColasConArreglo09`
10. `PilasColasConArreglo10`

## 5. Flujo esperado

1. El alumno selecciona la clase del ejercicio.
2. Lee/usa primero el prompt de OpenCode en `PROMPTS.md` y conserva el prompt inicial en un comentario al comienzo del fuente.
3. Ejecuta el programa, ingresa capacidad y usa el menú para probar operaciones.
4. Comprueba la salida con una secuencia válida y con casos límite.
5. Si ajusta el prompt para corregir la solución, deja constancia breve del cambio al final del fuente; si no lo ajusta, indica explícitamente que no hubo modificaciones.

## 6. Manejo de errores y casos límite transversales

- Tamaño negativo o cantidad inválida: informar error; no construir la estructura con datos incorrectos.
- Capacidad cero: estructura vacía e incapaz de aceptar elementos; `isEmpty()` y `isFull()` ambas verdaderas.
- Pila llena: `push` no altera el contenido ni `top`.
- Pila vacía: `pop` y `peek` no alteran estado y lanzan `IllegalStateException`.
- Cola llena: `enqueue` no altera arreglo, índices ni tamaño.
- Cola vacía: `dequeue` y `front` no alteran estado y lanzan `IllegalStateException`.
- Menú: operaciones no válidas producen mensaje y permiten continuar; salir termina normalmente.
- Paréntesis: expresión vacía válida; cierre antes de apertura, apertura sobrante y profundidad anidada; únicamente se valida `(`/`)`.
- Torre e historial: elementos de texto, límite de capacidad y consultas cuando no hay elementos.
- Cola de impresión: validar páginas > 0, mantener registros completos y orden FIFO.
- Cola simple: mostrar huecos inutilizables de inicio aunque `size < capacidad`.
- Cola circular: wrap-around de `front` y `rear`, arreglo lleno, cola vacía, capacidad uno y capacidad cero.

## 7. Criterios de aceptación

- La guía queda organizada bajo `guias/pilas-colas-con-arreglo/`, separada de las guías anteriores.
- Hay diez fuentes Java 21 independientes, sin dependencias de clases de otros ejercicios.
- Cada fuente comienza con el prompt inicial completo que coincide con su sección de `PROMPTS.md` y termina con una nota veraz sobre cambios al prompt.
- Cada clase tiene un menú interactivo, operaciones solicitadas, salida legible y una demostración reproducible documentada.
- Las pilas respetan LIFO, las colas FIFO, el límite fijo del arreglo y sus respectivos índices/invariantes.
- El ejercicio 3 reconoce correctamente paréntesis balanceados y desequilibrados sin pretender validar el resto de la sintaxis.
- El ejercicio 5 permite demostrar uso tipado con Integer, String y un objeto simple usando arreglo interno `Object[]`.
- El ejercicio 9 muestra el desperdicio de espacios iniciales de una cola lineal y el límite del índice `rear`.
- El ejercicio 10 reutiliza celdas con aritmética modular y distingue correctamente lleno/vacío.
- Lleno/vacío generan excepciones claras sin corromper el estado; los menús capturan esos errores y siguen funcionando.
- Se prueban límites relevantes, incluyendo capacidades 0, 1 y varias posiciones, y se muestra al menos una secuencia normal por ejercicio.
- `README.md` da comandos reproducibles para compilar y ejecutar con Java 21; no se agregan dependencias externas ni cambios a guías existentes.
