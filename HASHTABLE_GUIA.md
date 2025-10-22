# Tabla Hash - Guía Completa

## 📚 ¿Qué es una Tabla Hash?

Una **Tabla Hash** (Hash Table) es una estructura de datos que implementa un **diccionario** o **mapa asociativo**. Permite almacenar pares **clave-valor** con operaciones muy eficientes:

- **Inserción**: O(1) en promedio
- **Búsqueda**: O(1) en promedio  
- **Eliminación**: O(1) en promedio

### Analogía cotidiana
Piensa en una **biblioteca organizada por temas**:
- La **clave** es el tema (ej: "Historia", "Ciencia")
- El **valor** es la estantería donde están los libros de ese tema
- La **función hash** es el sistema que te dice: "los libros de Historia van en la estantería 5"

---

## 🧮 Componentes Principales

### 1. Array interno (`table`)
Es un array que guarda las entradas. Cada posición se llama **bucket** o **cubeta**.

### 2. Función Hash (`hash()`)
Convierte una clave en un índice del array:

```java
private int hash(K key) {
    return Math.abs(key.hashCode()) % capacity;
}
```

**Ejemplo:**
- Clave: "manzana"
- hashCode(): 103145980
- Si capacity = 16: 103145980 % 16 = **4**
- Se guarda en `table[4]`

### 3. Entradas (`HashEntry`)
Cada entrada guarda:
- **key**: La clave única
- **value**: El valor asociado
- **next**: Referencia al siguiente nodo (para colisiones)

---

## ⚡ Colisiones

Una **colisión** ocurre cuando dos claves diferentes generan el mismo índice.

### Ejemplo de colisión:
```
hash("manzana") = 4
hash("pera") = 4  ← ¡Colisión!
```

### Resolución: Encadenamiento (Chaining)
En cada posición del array guardamos una **lista enlazada**:

```
table[4] -> {manzana: 10} -> {pera: 12} -> null
```

Si buscamos "pera", vamos a `table[4]` y recorremos la lista hasta encontrarla.

---

## 📊 Factor de Carga

El **factor de carga** mide qué tan llena está la tabla:

```
Factor de carga = tamaño / capacidad
```

**Ejemplo:**
- Si tienes 12 elementos en un array de 16 posiciones:
- Factor de carga = 12 / 16 = **0.75**

### ¿Por qué es importante?
- **Factor alto** (> 0.75): Más colisiones, búsquedas más lentas
- **Factor bajo** (< 0.5): Desperdicio de memoria

### Redimensionamiento
Cuando el factor supera 0.75, la tabla:
1. Duplica su capacidad (16 → 32)
2. Rehashea todos los elementos (porque los índices cambian)

---

## 🎯 Operaciones Principales

### 1. Inserción (`put`)

```java
tabla.put("manzana", 10);
```

**Pasos:**
1. Calcular índice: `hash("manzana") = 4`
2. Si `table[4]` está vacío: insertar directamente
3. Si hay colisión: recorrer lista y agregar al final
4. Si la clave ya existe: actualizar el valor

### 2. Búsqueda (`get`)

```java
Integer valor = tabla.get("manzana");
```

**Pasos:**
1. Calcular índice: `hash("manzana") = 4`
2. Ir a `table[4]`
3. Recorrer la lista hasta encontrar la clave
4. Retornar el valor (o null si no existe)

### 3. Eliminación (`remove`)

```java
tabla.remove("manzana");
```

**Pasos:**
1. Calcular índice
2. Recorrer lista
3. Eliminar el nodo (ajustando punteros)
4. Retornar el valor eliminado

---

## 📈 Complejidad Temporal

| Operación | Caso Promedio | Peor Caso |
|-----------|---------------|-----------|
| Inserción | O(1)          | O(n)      |
| Búsqueda  | O(1)          | O(n)      |
| Eliminación | O(1)        | O(n)      |

**Nota:** El peor caso O(n) ocurre cuando todas las claves colisionan en el mismo bucket (muy raro con una buena función hash).

---

## 🔍 Ejemplos Prácticos

### 1. Conteo de Frecuencias

**Problema:** Contar cuántas veces aparece cada palabra en un texto.

```java
HashTable<String, Integer> frecuencias = new HashTable<>();
String[] palabras = {"java", "es", "genial", "java", "es"};

for (String palabra : palabras) {
    Integer cuenta = frecuencias.get(palabra);
    if (cuenta == null) {
        frecuencias.put(palabra, 1);
    } else {
        frecuencias.put(palabra, cuenta + 1);
    }
}

// Resultado:
// java: 2
// es: 2
// genial: 1
```

### 2. Caché de Resultados

**Problema:** Evitar recalcular valores de Fibonacci.

```java
HashTable<Integer, Long> cache = new HashTable<>();

long fibonacci(int n, HashTable<Integer, Long> cache) {
    Long cacheado = cache.get(n);
    if (cacheado != null) return cacheado; // Ya lo calculamos
    
    if (n <= 1) return n;
    
    long resultado = fibonacci(n-1, cache) + fibonacci(n-2, cache);
    cache.put(n, resultado); // Guardar en caché
    return resultado;
}
```

**Ventaja:** Sin caché, calcular fib(40) toma segundos. Con caché, es instantáneo.

### 3. Índice de Estudiantes

```java
HashTable<String, Integer> notas = new HashTable<>();
notas.put("Juan", 85);
notas.put("María", 92);
notas.put("Pedro", 78);

// Buscar nota de María: O(1)
System.out.println(notas.get("María")); // 92
```

---

## 🆚 Comparación con otras estructuras

| Estructura | Búsqueda | Inserción | Ordenada | Duplicados |
|------------|----------|-----------|----------|------------|
| **Tabla Hash** | O(1) | O(1) | ❌ No | ❌ No (claves únicas) |
| Lista Enlazada | O(n) | O(1) | ❌ No | ✅ Sí |
| Árbol AVL | O(log n) | O(log n) | ✅ Sí | Depende |
| Array ordenado | O(log n) | O(n) | ✅ Sí | Depende |

**Usa Tabla Hash cuando:**
- Necesitas búsquedas/inserciones muy rápidas
- No te importa el orden
- Las claves son únicas

---

## ⚠️ Consideraciones Importantes

### 1. Buena función hash
Una mala función hash causa muchas colisiones:
```java
// ❌ MAL: Todos van al índice 0
int hash(String s) { return 0; }

// ✅ BIEN: Distribución uniforme
int hash(String s) { return Math.abs(s.hashCode()) % capacity; }
```

### 2. Claves inmutables
Las claves NO deben cambiar después de insertarse:
```java
// ❌ PELIGRO
StringBuilder sb = new StringBuilder("clave");
tabla.put(sb.toString(), 10);
sb.append("X"); // ¡Cambió el hashCode!
```

### 3. Claves nulas
Nuestra implementación NO permite claves nulas (lanza excepción).

---

## 🎓 Conceptos de Informática III

### Relación con la teoría

1. **Hashing**: Técnica para mapear datos de tamaño variable a valores de tamaño fijo
2. **Colisiones**: Problema inevitable que requiere estrategias de resolución
3. **Amortización**: El redimensionamiento es O(n) pero ocurre raramente, por lo que el costo promedio es O(1)

### Aplicaciones reales
- **Bases de datos**: Índices hash para búsquedas rápidas
- **Compiladores**: Tabla de símbolos
- **Criptografía**: Funciones hash (MD5, SHA)
- **Cache**: Memorización de resultados
- **DNS**: Resolución de nombres de dominio

---

## 🚀 Ejercicios Propuestos

1. **Básico**: Implementar un sistema de inventario (producto → cantidad)
2. **Intermedio**: Detectar palabras duplicadas en un texto
3. **Avanzado**: Implementar un sistema de cache LRU (Least Recently Used)
4. **Desafío**: Comparar rendimiento de tabla hash vs árbol AVL con 10,000 elementos

---

## 📝 Resumen

- **Tabla Hash**: Estructura que mapea claves → valores
- **Función Hash**: Convierte claves en índices
- **Colisiones**: Se resuelven con encadenamiento (listas enlazadas)
- **Redimensionamiento**: Cuando factor de carga > 0.75
- **Complejidad**: O(1) promedio para inserción, búsqueda y eliminación
- **Uso principal**: Cuando necesitas búsquedas rápidas por clave

**Recuerda:** La tabla hash es una de las estructuras más importantes en programación. ¡Dominarla te hará un mejor programador!
