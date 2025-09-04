# Estructuras de Datos y Algoritmos - IUA 2025

Este repositorio contiene implementaciones de estructuras de datos básicas y algoritmos de ordenamiento en Java, desarrollados para el curso de la Universidad IUA. Incluye una interfaz de usuario interactiva para probar todas las funcionalidades.

## Contenido del Proyecto

### Estructuras de Datos
- `Stack<T>`: Implementación genérica de pila
- `Queue<T>`: Implementación genérica de cola circular
- `Orders`: Implementación de algoritmos de ordenamiento

### Características Principales
- Implementaciones genéricas que permiten cualquier tipo de dato comparable
- Manejo robusto de errores con excepciones
- Interfaz de usuario interactiva con validación de entrada
- Documentación completa con JavaDoc

## Estructuras Implementadas

### Stack (Pila)
Implementación genérica de pila con tamaño fijo usando un array.

#### Características
- Estructura LIFO (Last In, First Out)
- Tamaño fijo definido en la construcción
- Manejo de excepciones para operaciones inválidas
- Métodos `push`, `pop`, `top`, `isEmpty`, `isFull`

### Queue (Cola)
Implementación genérica de cola circular con tamaño fijo.

#### Características
- Estructura FIFO (First In, First Out)
- Implementación circular para uso eficiente del espacio
- Tamaño configurable con valor por defecto
- Manejo de excepciones para operaciones inválidas
- Métodos `enqueue`, `dequeue`, `front`, `isEmpty`, `isFull`

### Algoritmos de Ordenamiento
Implementación de tres algoritmos clásicos de ordenamiento:

#### Insertion Sort
- Mejor para arrays pequeños o casi ordenados
- Complejidad temporal: O(n²)
- Complejidad espacial: O(1)

#### Shell Sort
- Mejora del Insertion Sort
- Complejidad temporal: O(n log² n)
- Complejidad espacial: O(1)

#### Quick Sort
- Algoritmo eficiente para grandes conjuntos de datos
- Complejidad temporal promedio: O(n log n)
- Complejidad espacial: O(log n)

## Interfaz de Usuario

El proyecto incluye un menú interactivo (`Main.java`) que permite:

### Operaciones con Stack
- Crear una nueva pila con tamaño personalizado
- Realizar operaciones push/pop
- Consultar el elemento superior
- Verificar estado (vacía/llena)

### Operaciones con Queue
- Crear una nueva cola con tamaño personalizado
- Realizar operaciones enqueue/dequeue
- Consultar el elemento frontal
- Verificar estado (vacía/llena)

### Pruebas de Ordenamiento
- Ingresar arrays de números
- Elegir el algoritmo de ordenamiento
- Visualizar el resultado antes y después

### Manejo de Errores
- Validación robusta de entrada de datos
- Mensajes de error descriptivos
- Reintentos automáticos para entradas inválidas
- Manejo de excepciones para operaciones inválidas

## Ejemplos de Uso

### Stack
```java
Stack<Integer> stack = new Stack<>(3);
stack.push(1);    // [1]
stack.push(2);    // [1, 2]
stack.push(3);    // [1, 2, 3]
stack.pop();      // Retorna 3, queda [1, 2]
stack.top();      // Retorna 2 sin modificar la pila
```

### Queue
```java
Queue<String> queue = new Queue<>(3);
queue.enqueue("A");    // [A]
queue.enqueue("B");    // [A, B]
queue.enqueue("C");    // [A, B, C]
queue.dequeue();       // Retorna "A", queda [B, C]
queue.front();         // Retorna "B" sin modificar la cola
```

### Ordenamiento
```java
Integer[] arr = {5, 2, 8, 1, 9};
Orders.quickSort(arr);     // [1, 2, 5, 8, 9]
Orders.insertionSort(arr); // [1, 2, 5, 8, 9]
Orders.shellSort(arr);     // [1, 2, 5, 8, 9]
```

## Manejo de Errores
```java
Stack<Integer> stack = new Stack<>(2);
stack.push(1);
stack.push(2);
stack.push(3);    // Lanza IllegalStateException: "Stack is full"
stack.pop();      // OK
stack.pop();      // OK
stack.pop();      // Lanza IllegalStateException: "Stack is empty"
```

Este repositorio contiene implementaciones de estructuras de datos básicas en Java, desarrolladas para el curso de la Universidad IUA.

## Estructuras Implementadas

### Stack (Pila)
Una implementación genérica de pila con tamaño fijo usando un array.

#### Características
- Estructura LIFO (Last In, First Out)
- Tamaño fijo definido en la construcción
- Implementación genérica que permite cualquier tipo de dato
- Manejo de excepciones para estados inválidos

#### Métodos
- `push(T value)`: Agrega un elemento al tope de la pila
- `pop()`: Remueve y retorna el elemento del tope
- `top()`: Retorna el elemento del tope sin removerlo
- `isEmpty()`: Verifica si la pila está vacía
- `isFull()`: Verifica si la pila está llena

### Queue (Cola)
Una implementación genérica de cola circular con tamaño fijo usando un array.

#### Características
- Estructura FIFO (First In, First Out)
- Implementación circular para uso eficiente del espacio
- Tamaño fijo con valor por defecto de 10
- Manejo de excepciones para operaciones inválidas
- Implementación genérica

#### Métodos
- `enqueue(T value)`: Agrega un elemento al final de la cola
- `dequeue()`: Remueve y retorna el elemento del frente
- `front()`: Retorna el elemento del frente sin removerlo
- `isEmpty()`: Verifica si la cola está vacía
- `isFull()`: Verifica si la cola está llena

## Ejemplos de Uso

### Stack
```java
Stack<Integer> stack = new Stack<>(5);
stack.push(1);
stack.push(2);
stack.push(3);

System.out.println(stack.pop());  // Imprime: 3
System.out.println(stack.top());  // Imprime: 2
```

### Queue
```java
Queue<String> queue = new Queue<>(3);
queue.enqueue("Primero");
queue.enqueue("Segundo");
queue.enqueue("Tercero");

System.out.println(queue.dequeue());  // Imprime: "Primero"
System.out.println(queue.front());    // Imprime: "Segundo"
```

## Manejo de Errores
Ambas estructuras lanzan `IllegalStateException` en los siguientes casos:
- Intentar agregar elementos cuando la estructura está llena
- Intentar remover elementos cuando la estructura está vacía
- Intentar acceder al elemento superior/frontal cuando la estructura está vacía