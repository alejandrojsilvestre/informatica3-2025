# Estructuras de Datos - IUA 2025

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