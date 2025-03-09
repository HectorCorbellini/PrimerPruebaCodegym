package com.example.cryptography;

import java.util.Arrays;
import java.util.HashSet;

public class Ajustes {
    public static final byte ENCRIPTAR = 1;
    public static final byte DESENCRIPTAR = 2;
    public static final byte FUERZABRUTA = 3;
    public static final byte ANALISIS = 4;
    public static final int RANGO_EXCEDIDO = -1;
    public static final int minCharNum = 32;  // espacio
    public static final int maxCharNum = 65535;  // máximo valor Unicode BMP
    public static final char ESPACIO = ' ';
    public static final char finDeLinea = '\n';
    public static final HashSet<Character> finDePalabra = new HashSet<Character>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'n', 'l', 'r', 's', 'y')
    );
} // class
