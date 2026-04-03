# Sistema de Gestión de Actividades y Análisis de Procrastinación

## Autores

- Sebastian Andres Gonzalez Rossi  
- Javier Ignacio Ossandon Calderon  

Carrera: Ingeniería Civil Industrial  

---

## Descripción del problema

El presente proyecto tiene como objetivo desarrollar un sistema que permita la gestión de actividades realizadas por distintos usuarios, junto con el análisis de dicha información.

El sistema permite autenticar usuarios, registrar actividades con fecha, duración y tipo, modificar o eliminar registros existentes y analizar los datos almacenados para obtener información relevante sobre el uso del tiempo.

---

## Archivos utilizados

El sistema utiliza dos archivos de texto para almacenar la información:

- `Usuarios.txt`  
  Contiene los usuarios y sus contraseñas en el siguiente formato:
  ```
  usuario;contraseña
  ```

- `Registros.txt`  
  Contiene las actividades registradas en el siguiente formato:
  ```
  usuario;fecha;horas;actividad
  ```

---

## Funcionalidades

### Menú de Usuarios

- Autenticación mediante usuario y contraseña  
- Registro de nuevas actividades  
- Modificación de actividades existentes (fecha, duración o tipo)  
- Eliminación de actividades  
- Cambio de contraseña  

### Menú de Análisis

- Determinación de la actividad con mayor cantidad de horas a nivel global  
- Identificación de la actividad más realizada por cada usuario  
- Cálculo del usuario con mayor cantidad total de horas  
- Visualización de todas las actividades registradas  

---

## Tecnologías utilizadas

- Lenguaje de programación: Java  
- Manejo de archivos: File, Scanner, BufferedWriter  
- Entorno de desarrollo: Eclipse y para subir los commits Visual Studio Code   

---

## Ejecución del programa

1. Clonar el repositorio:
   ```
   git clone https://github.com/tu-usuario/tu-repositorio.git
   ```

2. Asegurarse de que los archivos `Usuarios.txt` y `Registros.txt` se encuentren en el directorio del proyecto.

3. Abrir el proyecto en el entorno de desarrollo.

4. Ejecutar la clase `Main`.

---

## Ejemplo de uso

Archivo `Usuarios.txt`:
```
sebastian;1234
javier;abcd
```

Archivo `Registros.txt`:
```
sebastian;01/04/2026;2;Estudiar
sebastian;01/04/2026;3;Jugar
javier;02/04/2026;5;Ver series
```

Ejemplo de salida:
```
La Actividad Con Mas Horas Es Jugar Con 3 Horas
El Usuario Con Mayor Procrastinacion Es: javier CON UN TOTAL DE: 5 HORAS
```

---

## Descripción de la solución

El programa utiliza arreglos de tamaño fijo para almacenar la información de usuarios y actividades. Al iniciar, los datos se cargan desde archivos de texto hacia memoria.

El sistema funciona mediante menús interactivos que permiten realizar operaciones de creación, lectura, actualización y eliminación sobre las actividades registradas.

Para el análisis de datos, se implementan algoritmos que recorren los arreglos, acumulando horas y comparando resultados para determinar máximos y frecuencias.

Los cambios realizados durante la ejecución se guardan en los archivos correspondientes, asegurando la persistencia de los datos.

---

## Validaciones implementadas

- Verificación del formato de fecha (DD/MM/AAAA)  
- Validación de que la duración sea un número entero  
- Validación de credenciales de usuario  
- Manejo básico de errores en la lectura de archivos  

---

## Licencia

Proyecto desarrollado con fines académicos.
Saludos Cordiales.
