# Herramienta de Encriptación de Archivos

Una herramienta de línea de comandos basada en Java para encriptar y desencriptar archivos de texto usando el algoritmo de cifrado César. Este proyecto proporciona múltiples enfoques para manejar archivos encriptados, incluyendo encriptación/desencriptación manual, ataque por fuerza bruta y análisis criptográfico.

## Información del Repositorio

**URL del Repositorio**: https://github.com/HectorCorbellini/PrimerPruebaCodegym

*Nota: El token de acceso se encuentra almacenado de forma segura localmente.*

## Características

- **Encriptación de Archivos**: Encripta archivos de texto usando el cifrado César con una clave especificada por el usuario
- **Desencriptación de Archivos**: Desencripta archivos usando la clave correcta
- **Ataque por Fuerza Bruta**: Prueba automáticamente diferentes claves para desencriptar un archivo
- **Análisis Criptográfico**: Intenta desencriptar un archivo usando análisis de frecuencia
- **Detección de Idioma**: Detecta automáticamente si el texto desencriptado es legible (Español/Inglés)

## Estructura del Proyecto

```
encrip/
├── src/
│   └── com/
│       └── example/
│           └── cryptography/
│               ├── Ajustes.java      # Configuraciones y constantes
│               ├── Archivo.java      # Operaciones con archivos
│               ├── Cesar.java        # Implementación del cifrado César
│               ├── Consola.java      # Interfaz de consola
│               ├── AnalisisCripto.java # Análisis criptográfico
│               ├── Desencripte.java  # Operaciones de desencriptación
│               ├── Espaniol.java     # Detección de idioma
│               ├── Principal.java    # Entrada principal del programa
│               ├── Recorrer.java     # Procesamiento de texto
│               └── EjecutorPruebas.java # Suite de pruebas
├── bin/                             # Archivos compilados
└── README.md                        # Este archivo
```

## Requisitos

- Kit de Desarrollo de Java (JDK) 8 o superior
- Terminal de línea de comandos

## Compilación del Proyecto

1. Crear el directorio bin:
   ```bash
   mkdir -p bin
   ```

2. Compilar los archivos fuente:
   ```bash
   javac -d bin src/com/example/cryptography/*.java
   ```

## Uso

Ejecutar el programa usando:
```bash
java -cp bin com.example.cryptography.Principal
```

### Opciones Disponibles

1. **Encriptar un Archivo** (Opción 1)
   - Ingresar la ruta del archivo de entrada
   - Ingresar la ruta del archivo de salida
   - Ingresar una clave de encriptación (1-255)

2. **Desencriptar un Archivo** (Opción 2)
   - Ingresar la ruta del archivo encriptado
   - Ingresar la ruta del archivo de salida
   - Ingresar la misma clave usada para encriptación

3. **Desencriptación por Fuerza Bruta** (Opción 3)
   - Ingresar la ruta del archivo encriptado
   - Ingresar la ruta del archivo de salida
   - El programa probará todas las claves posibles hasta encontrar texto legible

4. **Análisis Criptográfico** (Opción 4)
   - Ingresar la ruta del archivo encriptado
   - Ingresar la ruta del archivo de salida
   - El programa analizará las frecuencias de caracteres para determinar la clave

### Ejemplos de Uso

1. **Encriptar un archivo**:
   ```bash
   java -cp bin com.example.cryptography.Principal 1
   # Ingresar archivo de entrada: texto_entrada.txt
   # Ingresar archivo de salida: encriptado.txt
   # Ingresar clave: 3
   ```

2. **Desencriptar un archivo**:
   ```bash
   java -cp bin com.example.cryptography.Principal 2
   # Ingresar archivo de entrada: encriptado.txt
   # Ingresar archivo de salida: desencriptado.txt
   # Ingresar clave: 3
   ```

3. **Desencriptación por Fuerza Bruta**:
   ```bash
   java -cp bin com.example.cryptography.Principal 3
   # Ingresar archivo de entrada: encriptado.txt
   # Ingresar archivo de salida: resultado_fuerzabruta.txt
   ```

4. **Análisis Criptográfico**:
   ```bash
   java -cp bin com.example.cryptography.Principal 4
   # Ingresar archivo de entrada: encriptado.txt
   # Ingresar archivo de salida: resultado_analisis.txt
   ```

## Formato de Archivo

- El programa trabaja con archivos de texto (.txt)
- Los archivos de entrada deben contener texto legible
- Los caracteres especiales y caracteres no ASCII pueden no ser manejados correctamente

## Limitaciones

- El cifrado César es un método de encriptación básico y no debe usarse para datos sensibles
- El análisis criptográfico funciona mejor con textos más largos
- La detección de idioma está optimizada para textos en español e inglés
- El valor máximo de la clave de encriptación es 255

## Pruebas

El proyecto incluye una clase EjecutorPruebas que puede usarse para verificar la funcionalidad:
```bash
java -cp bin com.example.cryptography.EjecutorPruebas
```

## Contribuir

¡Siéntase libre de enviar problemas y solicitudes de mejoras!
