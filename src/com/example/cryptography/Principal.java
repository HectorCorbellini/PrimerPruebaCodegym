package com.example.cryptography;

import java.util.Scanner;
import java.util.InputMismatchException;
import com.example.cryptography.Archivo;
import com.example.cryptography.Ajustes;

public class Principal {
    // aqui se lee un archivo y se lo copia a otro

    public static void main(String[] args) {
        if (args.length > 0) {
            // Automated testing mode
            try {
                byte opcionElegida = Byte.parseByte(args[0]);
                Archivo.manejar(opcionElegida);
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
        } else {
            // Interactive mode
            Scanner scanner = new Scanner(System.in);
            System.out.println ("Bienvenido a encriptacion de archivos. Elija procedimiento:");
            System.out.println ("digite "+Ajustes.ENCRIPTAR+" - para encriptar su archivo");
            System.out.println ("digite "+Ajustes.DESENCRIPTAR+" - para desencriptar su archivo");
            System.out.println ("digite "+Ajustes.FUERZABRUTA+" - para desencriptar por fuerza bruta");
            System.out.println ("digite "+Ajustes.ANALISIS+" - para desencriptar por analisis criptográfico");
            System.out.println("Por favor, ingrese su opción:");
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                try {
                    byte opcionElegida = Byte.parseByte(input);
                    Archivo.manejar(opcionElegida);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número válido.");
                }
            } else {
                System.out.println("Error: No se recibió ninguna entrada.");
            }
        }
    }  // main
}  // class