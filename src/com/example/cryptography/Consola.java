package com.example.cryptography;

import java.util.Objects;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Consola {
    private static boolean autoTest = false;
    private static int autoTestKey = 3;
    private static String autoTestInputPath = "test_input.txt";
    private static String autoTestOutputPath = "test_output.txt";
    private static final Scanner scanner = new Scanner(System.in);

    public static void setAutoTest(boolean value, int key) {
        autoTest = value;
        autoTestKey = key;
    }

    public static int obtenerClaveSegunOpcion(byte nroElegido, String rutaEntrada) {
        int clave;
        if (nroElegido == Ajustes.ENCRIPTAR || nroElegido == Ajustes.DESENCRIPTAR) {
            clave = leerClave();
            if (nroElegido == Ajustes.DESENCRIPTAR)
                clave = Desencripte.negativizar(clave);
        } else if (nroElegido == Ajustes.FUERZABRUTA) {
            clave = Desencripte.fuerzaBruta(rutaEntrada);
            clave = Desencripte.negativizar(clave);
        } else if (nroElegido == Ajustes.ANALISIS) {
            clave = AnalisisCripto.analizarTexto(rutaEntrada);
            if (clave != Ajustes.RANGO_EXCEDIDO) {
                System.out.println("Clave encontrada mediante análisis de frecuencia: " + clave);
                clave = Desencripte.negativizar(clave);
            }
        } else clave = Ajustes.RANGO_EXCEDIDO;
        return clave;
    }

    public static int leerClave() {
        if (autoTest) {
            return autoTestKey;
        }
        int clave = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.println("Ingrese clave de encriptación: ");
                clave = scanner.nextInt();
                if (clave > Ajustes.maxCharNum || clave < 1) {
                    System.out.println("Numero debe estar entre 01 y " + Ajustes.maxCharNum + ". Ingrese nuevamente:");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.next(); // Clear the invalid input
            }
        }
        return clave;
    }

    public static String ruta(boolean entrada) {
        if (autoTest) {
            return entrada ? autoTestInputPath : autoTestOutputPath;
        }
        String mensaje;
        String rutaPorDefecto;
        if (entrada) {
            mensaje = "Ingrese ruta y archivo (Enter para ruta por defecto): ";
            rutaPorDefecto = "/home/uko/Documentos/prueba.txt";
        } else {
            mensaje = "Ingrese ruta y archivo donde estará el resultado (Enter para ruta por defecto): ";
            rutaPorDefecto = "/home/uko/Documentos/unResultado.txt";
        }
        System.out.print(mensaje);
        String ruta = scanner.nextLine();
        return ruta.isEmpty() ? rutaPorDefecto : ruta;
    }
}