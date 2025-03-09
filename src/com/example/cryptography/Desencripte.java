package com.example.cryptography;

import java.io.*;

public class Desencripte  {

    static int negativizar(int clave) {
        // al negativizar desaplica cesar
        return clave * -1;
    }  // method

    static int fuerzaBruta (String rutaEntrada) {
        // aplica Cesar cambiando las claves hasta que se vuelva español
        String linea;
        try  {
            BufferedReader buffReader = new BufferedReader(new FileReader(rutaEntrada));
            linea = buffReader.readLine();
            buffReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } // try
        int clave = Ajustes.minCharNum - 1;
        boolean esEspaniol = false;
        Espaniol espaniol = new Espaniol();
        // ahora recorro la linea cambiando hasta maxCharNum veces las posiciones de letras
        while ( ! esEspaniol && clave <= Ajustes.maxCharNum)  {
            clave++;
            int claveBruta = negativizar(clave);
            esEspaniol = espaniol.detectar(linea,claveBruta);
        }  // end while
        if (clave > Ajustes.maxCharNum)
            return Ajustes.RANGO_EXCEDIDO;
        else
            return clave;
    }  // fuerza bruta method

} // class

/*
    int AplicarAnalisis (String linea)  {
        // TODAVIA ANDA MAL, NO ME DIO TIEMPO A CORREGIRLO
        // estudia una línea para ver dónde hay un blanco oculto
        // toma de a dos chars juntos en sospecha de que son vocal o s + blanco
        // y para saberlo mide la distancia asccí que hay entre ellos.
        final int ESPACIO = 32;
        final int asciiDISTANCIAespacio_a = 65; // 97-ESPACIO
        final int asciiDISTANCIAespacio_o = 79; // 111-ESPACIO
        final int asciiDISTANCIAespacio_s = 83; // 115-ESPACIO
        //
        int letra1 = 0; int letra2 = 0;
        int claveDescubierta;
        for (int i=7; i<linea.length(); i++) {
            // no desde cero porque no va a haber un punto luego de las primeras letras
            letra1 = linea.charAt(i-1);
            letra2 = linea.charAt(i);
            if ((letra1-letra2) == asciiDISTANCIAespacio_a ||
                    (letra1-letra2) == asciiDISTANCIAespacio_o ||
                    (letra1-letra2) == asciiDISTANCIAespacio_s)  {
                if (letra2 < ESPACIO)
                    claveDescubierta = (maxCharNum-ESPACIO) + (minCharNum+letra2);
                else claveDescubierta = (letra2 - ESPACIO);
                // a continuación confirma que esa línea está en español
                ManejarLineas manejarLineas = new ManejarLineas();
                linea = manejarLineas.desencriptar(linea,claveDescubierta);

                if (isSpanish (linea,claveDescubierta))
                    //  OJO ESTA EN BOOLEAN
                    return claveDescubierta;
            }  // if
        }  // for
        return RANGO_EXCEDIDO;
    }  // analisis method
 */
