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

<img width="660" height="273" alt="image" src="https://github.com/user-attachments/assets/3ccc09de-49d0-4c57-a9b7-8a88611888d1" />



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


