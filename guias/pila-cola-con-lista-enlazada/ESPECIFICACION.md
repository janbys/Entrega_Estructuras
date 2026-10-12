# Especificación técnica — PilaColaConListaEnlazada

## 1. Objetivo

Desarrollar diez ejercicios académicos sobre pilas y colas implementadas mediante listas enlazadas en Java 21. Los prompts para OpenCode deben evidenciar comprensión de la estructura elegida, su comportamiento LIFO/FIFO, sus referencias y operaciones, los casos límite y las complejidades esperadas.

La guía debe mantenerse independiente en `guias/pila-cola-con-lista-enlazada/`, junto a las guías existentes y sin modificar su código. Las demostraciones usarán datos definidos de antemano en `main`, no entrada interactiva, siguiendo las preferencias confirmadas.

## 2. Entregables por ejercicio

Para cada ejercicio se deberá incluir:

1. Una clase fuente Java independiente, con la solución y una demostración determinista.
2. Un prompt inicial completo en `PROMPTS.md`, listo para OpenCode.
3. El mismo prompt inicial, íntegro y en un comentario al comienzo del archivo fuente, con este formato dentro de un único comentario:
   - `Prompt inicial utilizado:`
   - texto íntegro del prompt;
   - `Ajustes realizados luego de la primera respuesta de OpenCode:`
   - resumen veraz de los ajustes, o `No hubo ajustes.`
4. Javadoc de clase que documente la consigna, la estructura y su razonamiento, ejemplo de datos/resultados, casos límite y complejidad.
5. Javadoc de métodos públicos con propósito, parámetros, retorno, efectos y excepciones relevantes.
6. Una prueba ejecutable con datos de ejemplo en cada `main`, registrada con entradas y salidas observadas en `PRUEBAS.md`.

El contenido del comentario de prompt de cada fuente deberá coincidir con su sección de `PROMPTS.md`, excluyendo las líneas de formato/notas que no pertenecen al prompt.

## 3. Restricciones y requisitos comunes

- Lenguaje: Java 21.
- No agregar frameworks, bibliotecas ni dependencias externas.
- Implementar nodos enlazados propios. No utilizar `ArrayList`, `LinkedList`, `Stack`, `Queue` ni otras colecciones para resolver los ejercicios.
- Cada ejercicio debe tener una clase pública y un `main` propios, compilar y ejecutarse independientemente, sin requerir otra clase de ejercicio.
- Los ejemplos se definen previamente en cada `main`; no usar `Scanner` ni pedir entrada interactiva.
- Separar métodos de la estructura/algoritmo de la demostración en `main`.
- Usar `IllegalStateException` con un mensaje claro cuando se intenta desapilar/desencolar o consultar el tope/frente de una estructura vacía. En las demostraciones, capturar el error para que no impida ejecutar los demás casos.
- Para operaciones de búsqueda o eliminación genéricas, comparar mediante igualdad de objetos (`Objects.equals`) para admitir tipos distintos y valores nulos si la estructura los acepta.
- Documentar los efectos de insertar o retirar elementos y mantener correctamente los enlaces y, si se agrega un contador `size`, su coherencia con los nodos.
- Incluir comentarios que expliquen decisiones de referencias, no comentarios mecánicos línea por línea.
- No agregar funcionalidades no pedidas ni modificar guías anteriores.

## 4. Requisitos funcionales por ejercicio

### Ejercicio 1 — Pila enlazada de enteros

- Clase sugerida: `PilaColaConListaEnlazada01`.
- Implementar una pila propia de enteros mediante nodos enlazados simples. Cada nodo contiene el dato y referencia al siguiente.
- Usar `head` como tope de la pila: `push` crea un nodo que apunta a la cabeza actual y luego lo convierte en `head`; `pop` guarda el dato del nodo superior y avanza `head` al siguiente. Esto da O(1) para ambas operaciones.
- Operaciones públicas: `push`/apilar, `pop`/desapilar, `peek`/consultar tope, `isEmpty`, `contains`/buscar y `print`/imprimir.
- `contains` recorre la cadena de nodos desde `head` hasta hallar el entero o `null`: O(n). Imprimir también recorre O(n). Push, pop, peek y isEmpty son O(1). Espacio total O(n).
- Demostrar LIFO, búsqueda presente/ausente y errores de pop/peek en pila vacía.

### Ejercicio 2 — Cola enlazada de enteros

- Clase sugerida: `PilaColaConListaEnlazada02`.
- Implementar una cola FIFO propia con nodos enlazados simples y referencias `head` (frente) y `tail` (final).
- Al encolar en una cola no vacía, enlazar `tail.siguiente` con el nodo nuevo y actualizar `tail`. En vacío, ambos extremos pasan a señalar al nodo nuevo.
- Al desencolar, devolver el dato de `head` y avanzar `head`; si se retira el último nodo, establecer también `tail` en `null`.
- Explicar que con solo `head` el encolado al final tendría que recorrer todos los nodos y costaría O(n); `tail` permite encolar O(1).
- Operaciones públicas: `enqueue`/encolar, `dequeue`/desencolar, `front`/consultar frente, `isEmpty`, `contains`/buscar e `imprimir`.
- Enqueue, dequeue, front e isEmpty O(1); búsqueda e impresión O(n); espacio O(n).
- Demostrar FIFO, cola vacía, una sola entrada/salida que vuelve a vaciarla, y búsqueda presente/ausente.

### Ejercicio 3 — Pila genérica

- Clase sugerida: `PilaColaConListaEnlazada03`.
- Generalizar la implementación de pila enlazada mediante `Pila<T>` y nodos `Nodo<T>`.
- Conservar la interfaz y comportamiento del ejercicio 1, incluidos apilar, desapilar, consultar tope, comprobar vacío, buscar e imprimir.
- Explicar que `T` permite reutilizar la estructura para diferentes tipos con comprobación estática; los enlaces y la lógica LIFO no dependen del tipo del dato.
- Demostrar instancias separadas `Pila<Integer>`, `Pila<String>` y una pila de un objeto propio simple, sin mezclar tipos en una instancia.
- Mantener O(1) en operaciones de extremo/estado y O(n) en búsqueda/impresión; espacio O(n).

### Ejercicio 4 — Cola genérica

- Clase sugerida: `PilaColaConListaEnlazada04`.
- Generalizar la cola enlazada con `Cola<T>` y nodos `Nodo<T>`; mantener referencias `head` y `tail`.
- Conservar las operaciones del ejercicio 2, incluyendo búsqueda e impresión genéricas.
- Explicar que FIFO se conserva porque se inserta en `tail` y se retira de `head`, independientemente del tipo almacenado.
- Demostrar una cola de nombres (`Cola<String>`) y una cola de objetos `Cliente` propios; mantener los campos de cada cliente asociados como un solo objeto.
- Enqueue/dequeue/front O(1), búsqueda/impresión O(n), espacio O(n).

### Ejercicio 5 — Historial de navegación con pila

- Clase sugerida: `PilaColaConListaEnlazada05`.
- Usar una pila enlazada de URLs (`String`) para registrar páginas visitadas.
- Operaciones de demostración: visitar una página (push), volver atrás (pop), consultar página actual (peek) e imprimir el historial.
- Explicar LIFO: la última URL visitada es la primera que se quita al volver. La página actual es el tope mientras el historial no esté vacío.
- No implementar una pila secundaria para avanzar ni funcionalidades de navegador real.
- Demostrar dos o más visitas, retroceso a la URL anterior, impresión y retroceso/consulta cuando el historial está vacío; capturar `IllegalStateException` donde corresponda.
- Operaciones de extremo O(1), impresión O(n), espacio O(n).

### Ejercicio 6 — Cola de atención de clientes

- Clase sugerida: `PilaColaConListaEnlazada06`.
- Definir `Cliente` con nombre, número de turno y motivo de consulta; almacenar objetos completos en una cola enlazada genérica o especializada, manteniendo los campos asociados.
- Operaciones de demostración: encolar cliente, atender y retirar al siguiente, consultar quién sigue e imprimir la fila.
- Explicar FIFO: la persona que llegó primero se atiende primero; el frente representa el próximo cliente y la cola conserva el orden de llegada.
- Demostrar dos o más clientes, primera atención y consulta posterior, fila vacía y error de atención/consulta vacía.
- Enqueue/dequeue/front O(1), imprimir O(n), espacio O(n).

### Ejercicio 7 — Paréntesis balanceados

- Clase sugerida: `PilaColaConListaEnlazada07`.
- Leer del conjunto de cadenas de ejemplo fijadas en `main` y decidir si los paréntesis `(` y `)` están balanceados usando una pila enlazada de caracteres o contadores almacenados en una pila enlazada definida en la clase.
- Cada apertura se apila; un cierre requiere una apertura previa y realiza pop; al final la expresión es válida si no hubo cierres sobrantes y la pila quedó vacía.
- Validar solo paréntesis; otros caracteres no afectan el resultado y no se pretende validar la sintaxis completa de la expresión.
- Incluir los ejemplos dados: `(2 + 3) * (5 - 1)` y `((a + b) * c)` válidos; `(2 + 3` y `())(` inválidos. Agregar cadena vacía y anidamiento profundo representativo.
- Explicar LIFO y por qué cada cierre corresponde a la apertura más reciente sin cerrar. Para longitud n, tiempo O(n), espacio O(n).

### Ejercicio 8 — Invertir una palabra con pila

- Clase sugerida: `PilaColaConListaEnlazada08`.
- Almacenar los caracteres de una cadena en una pila enlazada de caracteres y luego desapilarlos para formar la salida invertida.
- Conservar todos los caracteres recibidos y su capitalización; no quitar espacios ni signos.
- Demostrar `"algoritmo"` que produce `"omtirogla"`, palabra vacía y un carácter.
- Explicar que la salida invierte el orden porque el último carácter apilado es el primero que se desapila (LIFO). Para longitud n, tiempo O(n), espacio O(n).

### Ejercicio 9 — Cola de impresión

- Clase sugerida: `PilaColaConListaEnlazada09`.
- Definir `TrabajoImpresion` con nombre del archivo, cantidad de páginas y usuario que lo envió; almacenar el registro completo como elemento de una cola enlazada.
- Operaciones de demostración: agregar trabajo, imprimir/retirar próximo, consultar próximo archivo y mostrar los trabajos pendientes.
- Procesar en orden FIFO; no simular duración, spooler real ni dispositivo de impresión.
- La cantidad de páginas debe ser positiva; las pruebas deben cubrir dato válido y rechazar/ignorar explícitamente un valor no positivo de acuerdo con el contrato elegido del constructor/método, sin encolar un trabajo incorrecto.
- Demostrar varios trabajos y comprobar que sale primero el que entró primero; manejar impresión/consulta en cola vacía mediante `IllegalStateException`.
- Enqueue/dequeue/front O(1), impresión O(n), espacio O(n).

### Ejercicio 10 — Lista doblemente enlazada genérica

- Clase sugerida: `PilaColaConListaEnlazada10`.
- Implementar `ListaDoblementeEnlazada<T>` y `Nodo<T>` con referencias `anterior` y `siguiente`, y referencias de extremos `head` y `tail`.
- Operaciones públicas: insertar al inicio, insertar al final, eliminar la primera coincidencia del dato (devolver si se encontró), imprimir desde `head` hacia adelante e imprimir desde `tail` hacia atrás.
- Comparar elementos mediante `Objects.equals`. La eliminación de cabeza y cola debe actualizar el extremo correspondiente; si el elemento era el único, ambos extremos quedan `null`. En eliminación intermedia, el previo debe enlazar al siguiente y viceversa.
- Mantener coherente `size` si se expone/usa. Conservar los invariantes: `head.anterior == null`, `tail.siguiente == null`; una lista vacía tiene ambos extremos null.
- Demostrar lista vacía, un nodo, varios nodos, recorridos en ambos sentidos, eliminación al inicio, en medio, al final, valor ausente y eliminación del único nodo.
- Inserciones y eliminación local O(1) una vez ubicado el nodo; eliminación por valor O(n); recorridos O(n); espacio O(n).

## 5. Estructura de archivos

Dentro de `guias/pila-cola-con-lista-enlazada/`:

- `README.md`: descripción de los ejercicios, requisito Java 21, comandos para compilar/ejecutar clases y generar Javadoc.
- `ESPECIFICACION.md`: este documento.
- `PROMPTS.md`: diez prompts completos, uno por ejercicio, listos para OpenCode.
- `PRUEBAS.md`: casos de demostración, instrucciones, entradas definidas y salidas observadas.
- `src/`: diez fuentes Java independientes con estos nombres sugeridos:
  1. `PilaColaConListaEnlazada01.java`
  2. `PilaColaConListaEnlazada02.java`
  3. `PilaColaConListaEnlazada03.java`
  4. `PilaColaConListaEnlazada04.java`
  5. `PilaColaConListaEnlazada05.java`
  6. `PilaColaConListaEnlazada06.java`
  7. `PilaColaConListaEnlazada07.java`
  8. `PilaColaConListaEnlazada08.java`
  9. `PilaColaConListaEnlazada09.java`
  10. `PilaColaConListaEnlazada10.java`

Cada fuente debe tener una solución autosuficiente, un `main` determinista, su prompt inicial y nota de ajustes. No se debe requerir ejecutar los ejercicios 1–2 para que 3–4 compilen o funcionen.

## 6. Casos límite comunes

- Pila o cola vacía: `isEmpty()` verdadero; consulta o retirada lanza `IllegalStateException` sin cambiar estado.
- Pila o cola con un nodo: añadir y retirar produce el estado vacío y restablece extremos coherentemente.
- Buscar valores: primero, último, presente repetido y ausente.
- Historial: una visita, varios retrocesos y retroceso sin página disponible.
- Balanceo: vacío, aperturas anidadas, cierre sin apertura, aperturas sin cerrar y expresión válida.
- Inversión: cadena vacía, un carácter y varios caracteres.
- Cliente/trabajo: objetos completos conservan todos sus atributos al encolar/desencolar; orden FIFO.
- Lista doble: vacío, un nodo, cabeza, centro, cola, ausente y direcciones de impresión; tras cada modificación los enlaces reversos y directos deben seguir consistentes.

## 7. Criterios de aceptación

- La guía se mantiene aislada en su carpeta y contiene README, especificación, prompts, pruebas y diez fuentes.
- Las diez clases compilan y se ejecutan individualmente en Java 21, sin librerías externas ni colecciones como implementación de las estructuras.
- Cada clase usa los nodos/referencias apropiados y satisface las operaciones y casos descritos por su ejercicio.
- La pila cumple LIFO, la cola cumple FIFO; la cola enlazada usa head y tail para enqueue O(1).
- Las estructuras genéricas funcionan con tipos primitivos encapsulados, cadenas y objetos propios sin cambiar su comportamiento algorítmico.
- Los casos vacíos y de un único nodo no dejan head/tail/referencias incoherentes; las operaciones que requieren un elemento informan los errores acordados.
- Cada prompt completo coincide entre `PROMPTS.md` y el comentario inicial de su fuente, seguido en el mismo bloque por la nota veraz de ajustes.
- Los diez `main` demuestran las operaciones principales con datos fijos y las salidas quedan registradas en `PRUEBAS.md`.
- Los documentos explican el razonamiento y complejidades pedidos por el práctico; no se cambian otras unidades.
