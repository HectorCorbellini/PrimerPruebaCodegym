package com.example.cryptography;

import java.io.*;

public class Archivo {

public static void manejar (byte nroElegido) {
        String rutaEntrada = Consola.ruta(true);
        String rutaSalida = Consola.ruta(false);
        int clave = Consola.obtenerClaveSegunOpcion(nroElegido,rutaEntrada);
        // a continuación lectura y escritura linea por linea del archivo
    try {
        BufferedReader buffReader = new BufferedReader(new FileReader(rutaEntrada));
        BufferedWriter buffWriter = new BufferedWriter(new FileWriter(rutaSalida, true));
        String linea = null;
        if (clave != Ajustes.RANGO_EXCEDIDO)
            while ((linea = buffReader.readLine()) != null)  {
                linea = new Recorrer(linea,clave).getLinea();
                buffWriter.write(linea);  // añado al archivo la linea modificada
                buffWriter.newLine();
            } // while
        else System.out.println("no hay clave que desencripte ese archivo");
        buffWriter.close();
        buffReader.close();
      } catch (IOException e) {
        e.printStackTrace(); }
  }  // method

} // class