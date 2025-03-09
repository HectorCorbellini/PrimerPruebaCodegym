package com.example.cryptography;

import java.util.Arrays;
import java.util.HashSet;

public class Ajustes {
    static final int maxCharNum = 256;
    static final int minCharNum = 1;
    // en la tabla ascii hay 256 caracteres.
    // Se puede hacer variar minCharNum y maxCharNum
    // no se utilizan caracteres fuera de ese rango ascii, por lo que si se hacen cambian
    // las constantes minCharNum y maxCharNum, debe cuidarse que quede incluido el alfabeto
    static final char ESPACIO = ' ';
    static final char finDeLinea = '\n';  // TODAVIA NO ANDA
    public static final int RANGO_EXCEDIDO = -1;
    //constante para indicar que el recorrido del rango terminó
  //  public static final int POCAS_LETRAS = 20;
    static final HashSet<Character> finDePalabra = new HashSet<>(Arrays.asList('a','o','n','s','.'));
    public static final byte ENCRIPTAR = 1;
    public static final byte DESENCRIPTAR = 2;
    public static final byte FUERZABRUTA = 3;
    public static final byte ANALISIS = 4;
} // class
