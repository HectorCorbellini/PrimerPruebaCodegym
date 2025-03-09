package com.example.cryptography;

public class Cesar {
    private char letraModificada;

    Cesar(char letra, int clave) {
        // Convert character to its code point
        int codePoint = (int)letra;
        
        // If it's a control character (0-31), keep it unchanged
        if (codePoint < Ajustes.minCharNum) {
            letraModificada = letra;
            return;
        }
        
        // If it's within the Basic Multilingual Plane, apply the cipher
        if (codePoint <= Ajustes.maxCharNum) {
            letraModificada = recorrer(letra, clave);
        } else {
            // For characters outside BMP, keep them unchanged
            letraModificada = letra;
        }
    }

    char getLetra() {
        return letraModificada;
    }

    char recorrer(char letra, int clave) {
        int codigoLetraModificada = (int)letra + clave;
        
        // Handle wrapping within the valid range
        if (codigoLetraModificada > Ajustes.maxCharNum) {
            int exceso = codigoLetraModificada - Ajustes.maxCharNum;
            codigoLetraModificada = Ajustes.minCharNum + (exceso - 1);
        } else if (codigoLetraModificada < Ajustes.minCharNum) {
            int defecto = Ajustes.minCharNum - codigoLetraModificada;
            codigoLetraModificada = Ajustes.maxCharNum - (defecto - 1);
        }
        
        return (char)codigoLetraModificada;
    }
}
