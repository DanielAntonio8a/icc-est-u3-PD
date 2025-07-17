# Proyecto Java: Ejercicios de Programación Dinámica & Laberinto

Este README describe cómo está organizado el proyecto, cómo compilarlo y ejecutarlo, y qué salida esperar.

---

## 📂 Estructura de carpetas



```bash

src/
├── App.java
├── Cell.java
├── EjerciciosPd.java
├── Maze.java
├── MazeSolver.java
├── MazeSolverRecursivo.java
├── MazeSolverRecursivoCompleto.java
├── MazeSolverBFS.java
└── MazeSolverDFS.java
```

![alt text](image.png)

![alt text](image-1.png)



---

## 🛠️ Prerrequisitos

- JDK 11+ instalado y en tu `PATH`
- Git (opcional, para clonar el repo)

---

## ⚙️ Compilar

Desde la raíz del proyecto, corre:

```bash
javac -d bin src/**/*.java
```
---
## Configuración de solvers de laberinto

En App.java, modifica la lista de solvers:
```java
List<MazeSolver> solvers = Arrays.asList(
    new MazeSolverRecursivo(),
    new MazeSolverRecursivoCompleto(),
    new MazeSolverBFS(),
    new MazeSolverDFS()
);
```


