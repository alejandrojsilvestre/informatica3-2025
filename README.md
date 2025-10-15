# Estructuras de Datos y Algoritmos - IUA 2025

Este repositorio contiene implementaciones de estructuras de datos básicas y algoritmos de ordenamiento en Java, desarrollados para el curso de la Universidad IUA. Incluye una interfaz de usuario interactiva para probar todas las funcionalidades.

## Contenido del Proyecto

### Estructuras de Datos
- `Stack<T>`: Implementación genérica de pila
- `Queue<T>`: Implementación genérica de cola circular
- `Orders`: Implementación de algoritmos de ordenamiento
- `AVLTree<T>`: Implementación de árbol AVL
- `BinaryHeap<T>`: Implementación de montículo binario (Max Heap / Min Heap)

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

### AVLTree (Árbol AVL)
Implementación de árbol binario de búsqueda auto-balanceado (AVL).

#### Características
- Inserción y búsqueda en tiempo O(log n)
- Balance automático mediante rotaciones
- Almacena datos genéricos comparables
- Recorridos in-order disponibles
- Visualización jerárquica del árbol

#### Métodos
- `insert(T data)`: Inserta un dato en el árbol
- `search(T data)`: Busca un dato y retorna true/false
- `remove(T data)`: Elimina un dato del árbol
- `inOrder()`: Retorna lista con recorrido in-order
- `getHeight()`: Retorna la altura del árbol
- `printTree()`: Visualiza la estructura del árbol

### BinaryHeap (Montículo Binario)
Implementación genérica de montículo binario con soporte para Max Heap y Min Heap.

#### Características
- Inserción en tiempo O(log n)
- Extracción de raíz en tiempo O(log n)
- Soporte para Max Heap (elemento máximo en la raíz)
- Soporte para Min Heap (elemento mínimo en la raíz)
- Visualización jerárquica del montículo
- Estructura eficiente basada en array

#### Métodos
- `insert(T data)`: Inserta un elemento en el montículo
- `extract()`: Extrae y retorna el elemento raíz
- `peek()`: Retorna el elemento raíz sin eliminarlo
- `isEmpty()`: Verifica si el montículo está vacío
- `size()`: Retorna la cantidad de elementos
- `getElements()`: Retorna lista con todos los elementos
- `printHeap()`: Visualiza la estructura del montículo

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

### AVLTree
```java
AVLTree avl = new AVLTree();
avl.insert(10, "A");
avl.insert(20, "B");
avl.insert(5, "C");
avl.insert(4, "D");
avl.insert(15, "E");

System.out.println(avl.search(15)); // Imprime: E
System.out.println(avl.getHeight()); // Imprime la altura del árbol
avl.inOrder(); // Imprime recorrido in-order: 4:D, 5:C, 10:A, 15:E, 20:B
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

### AVLTree (Árbol AVL)
Una implementación de árbol binario de búsqueda auto-balanceado (AVL).

#### Características
- Inserción y búsqueda en tiempo O(log n)
- Balance automático mediante rotaciones
- Almacena pares clave-valor
- Recorridos in-order disponibles
- Manejo robusto de nodos duplicados (actualiza valor)

#### Métodos
- `insert(int key, Object value)`: Inserta o actualiza un nodo
- `search(int key)`: Busca y retorna el valor asociado a la clave
- `inOrder()`: Imprime recorrido in-order (clave: valor)
- `getHeight()`: Retorna la altura del árbol

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

### Ordenamiento
```java
Integer[] arr = {5, 2, 8, 1, 9};
Orders.quickSort(arr);     // [1, 2, 5, 8, 9]
Orders.insertionSort(arr); // [1, 2, 5, 8, 9]
Orders.shellSort(arr);     // [1, 2, 5, 8, 9]
```

### AVLTree
```java
AVLTree avl = new AVLTree();
avl.insert(10, "A");
avl.insert(20, "B");
avl.insert(5, "C");
avl.insert(4, "D");
avl.insert(15, "E");

System.out.println(avl.search(15)); // Imprime: E
System.out.println(avl.getHeight()); // Imprime la altura del árbol
avl.inOrder(); // Imprime recorrido in-order: 4:D, 5:C, 10:A, 15:E, 20:B
```

## Manejo de Errores
Ambas estructuras lanzan `IllegalStateException` en los siguientes casos:
- Intentar agregar elementos cuando la estructura está llena
- Intentar remover elementos cuando la estructura está vacía
- Intentar acceder al elemento superior/frontal cuando la estructura está vacía