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
- **Interfaz Gráfica**: Nueva interfaz de usuario para una experiencia más amigable
- **Vista Previa**: Muestra las primeras 5 líneas del texto procesado

## Estructura del Proyecto

```
encrip/
├── src/
│   └── com/
│       └── example/
│           └── cryptography/
│               ├── Ajustes.java        # Configuraciones y constantes
│               ├── Archivo.java        # Operaciones con archivos
│               ├── Cesar.java          # Implementación del cifrado César
│               ├── Consola.java        # Interfaz de consola
│               ├── AnalisisCripto.java # Análisis criptográfico
│               ├── Desencripte.java    # Operaciones de desencriptación
│               ├── Espaniol.java       # Detección de idioma
│               ├── Principal.java      # Entrada principal del programa
│               ├── Recorrer.java       # Procesamiento de texto
│               ├── InterfazGrafica.java # Nueva interfaz gráfica
│               ├── EjecutorPruebas.java # Suite de pruebas
│               └── servicio/           # Capa de servicios
│                   ├── ServicioCifrado.java
│                   ├── TipoOperacion.java
│                   └── ResultadoProcesamiento.java
├── bin/                               # Archivos compilados
└── README.md                          # Este archivo
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
   find src/com/example/cryptography/ -name "*.java" -exec javac -d bin {} +
   ```

## Pruebas del Proyecto

El proyecto puede ser probado de dos maneras:

### 1. Pruebas Automatizadas

Ejecutar la suite de pruebas automatizadas:
```bash
java -cp bin com.example.cryptography.EjecutorPruebas
```

La suite de pruebas:
- Crea un archivo de prueba automáticamente
- Prueba todas las operaciones en secuencia:
  1. Encriptación (clave = 3)
  2. Desencriptación (clave = 3)
  3. Fuerza Bruta
  4. Análisis Criptográfico
- Muestra los resultados de cada operación
- Guarda los resultados en test_output.txt

### 2. Interfaz Gráfica

Ejecutar la interfaz gráfica:
```bash
java -cp bin com.example.cryptography.Principal
```

La interfaz gráfica permite:
- Seleccionar archivos mediante un diálogo de archivos
- Ver una vista previa del contenido (5 líneas)
- Ingresar la clave de encriptación
- Realizar todas las operaciones con botones
- Ver los resultados inmediatamente

### 3. Modo Consola

Ejecutar en modo consola con argumentos:
```bash
java -cp bin com.example.cryptography.Principal 1  # Para encriptar
java -cp bin com.example.cryptography.Principal 2  # Para desencriptar
java -cp bin com.example.cryptography.Principal 3  # Para fuerza bruta
java -cp bin com.example.cryptography.Principal 4  # Para análisis
```

## Verificación de Resultados

Para verificar que el programa funciona correctamente:

1. **Encriptación**:
   - El texto encriptado debe ser diferente al original
   - Todos los caracteres deben mantenerse en el rango ASCII válido

2. **Desencriptación**:
   - El texto desencriptado debe ser idéntico al original
   - La clave debe ser la misma usada para encriptar

3. **Fuerza Bruta**:
   - Debe encontrar la clave correcta automáticamente
   - El texto resultante debe ser legible

4. **Análisis Criptográfico**:
   - Debe identificar la clave mediante análisis de frecuencia
   - El texto resultante debe ser legible

## Limitaciones

- El cifrado César es un método de encriptación básico y no debe usarse para datos sensibles
- El análisis criptográfico funciona mejor con textos más largos
- La detección de idioma está optimizada para textos en español e inglés
- El valor máximo de la clave de encriptación es 255

## Contribuir

¡Siéntase libre de enviar problemas y solicitudes de mejoras!
