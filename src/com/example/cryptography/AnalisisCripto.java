package com.example.cryptography;

import java.io.*;
import java.util.*;

public class AnalisisCripto {
    // Frecuencias aproximadas de letras en español (en porcentaje)
    private static final Map<Character, Double> FRECUENCIAS_ESPANOL = new HashMap<Character, Double>() {{
        put('e', 13.68); put('a', 12.53); put('o', 8.68); put('s', 7.98);
        put('r', 6.87); put('n', 6.71); put('i', 6.25); put('d', 5.86);
        put('l', 4.97); put('c', 4.68); put('t', 4.63); put('u', 3.93);
        put('m', 3.15); put('p', 2.51); put('b', 1.42); put('g', 1.01);
        put('v', 0.90); put('y', 0.90); put('q', 0.88); put('h', 0.70);
        put('f', 0.69); put('z', 0.52); put('j', 0.44); put('ñ', 0.31);
        put('x', 0.22); put('w', 0.02); put('k', 0.01);
    }};

    public static int analizarTexto(String rutaArchivo) {
        try {
            // Leer el contenido del archivo
            BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = lector.readLine()) != null) {
                contenido.append(linea.toLowerCase());
            }
            lector.close();

            String texto = contenido.toString();
            
            // Probar cada posible clave
            double mejorPuntuacion = Double.NEGATIVE_INFINITY;
            int mejorClave = 0;

            for (int clave = 0; clave < 26; clave++) {
                String textoDescifrado = descifrarPrueba(texto, clave);
                double puntuacion = evaluarTexto(textoDescifrado);
                
                if (puntuacion > mejorPuntuacion) {
                    mejorPuntuacion = puntuacion;
                    mejorClave = clave;
                }
            }

            return mejorClave;

        } catch (IOException e) {
            e.printStackTrace();
            return Ajustes.RANGO_EXCEDIDO;
        }
    }

    private static String descifrarPrueba(String texto, int clave) {
        StringBuilder resultado = new StringBuilder();
        for (char c : texto.toCharArray()) {
            if (Character.isLetter(c)) {
                // Convertir a minúsculas para simplificar
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int valorOriginal = c - base;
                int valorNuevo = (valorOriginal - clave + 26) % 26;
                resultado.append((char)(base + valorNuevo));
            } else {
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

    private static double evaluarTexto(String texto) {
        // Calcular frecuencias en el texto descifrado
        Map<Character, Integer> frecuencias = new HashMap<>();
        int totalLetras = 0;

        for (char c : texto.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                frecuencias.put(c, frecuencias.getOrDefault(c, 0) + 1);
                totalLetras++;
            }
        }

        // Calcular puntuación basada en la diferencia con las frecuencias esperadas
        double puntuacion = 0.0;
        for (Map.Entry<Character, Integer> entry : frecuencias.entrySet()) {
            char letra = entry.getKey();
            double frecuenciaObservada = (double) entry.getValue() / totalLetras * 100;
            double frecuenciaEsperada = FRECUENCIAS_ESPANOL.getOrDefault(letra, 0.0);
            
            // Penalizar más las diferencias grandes
            puntuacion -= Math.pow(frecuenciaObservada - frecuenciaEsperada, 2);
        }

        // Bonus por caracteres especiales del español
        String textoNormalizado = texto.toLowerCase()
            .replaceAll("[áàäâ]", "a")
            .replaceAll("[éèëê]", "e")
            .replaceAll("[íìïî]", "i")
            .replaceAll("[óòöô]", "o")
            .replaceAll("[úùüû]", "u");
        
        if (textoNormalizado.contains("que") || 
            textoNormalizado.contains("de") ||
            textoNormalizado.contains("la") ||
            textoNormalizado.contains("el")) {
            puntuacion += 1000;  // Bonus por palabras comunes en español
        }

        return puntuacion;
    }
}
