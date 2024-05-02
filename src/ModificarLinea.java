package net.codejava.io;

// en esta clase se llevan las letras a char y alli se sustituyen

import java.io.IOException;
import java.io.StringReader;

public class ModificarLinea {

     String sustituirLinea (String linea, int clave) {
        // pone la linea string en un array de caracteres para poder trabajarla
        char[] charsLinea = new char[linea.length()];
        // hay seguridad de que el tamaño del array no será necesario modificarlo
        StringReader input = new StringReader(linea);
        try {
            input.read(charsLinea);  // aqui pongo la linea string en el array de caracteres
        } catch (IOException e) {
            throw new RuntimeException(e); }
        CesarLetras cesarLetras = new CesarLetras(); // modifica la linea usando criterio Cesar
        charsLinea = cesarLetras.cesarCodLinea(charsLinea,clave);  // recorre la linea entera
        linea = String.valueOf(charsLinea);
        return linea;
    } // metodo modificar linea

}  // end class
