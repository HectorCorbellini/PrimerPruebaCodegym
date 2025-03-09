package com.example.cryptography;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class Recorrer {
    private final String linea;
    Recorrer(String linea,int clave){
 //       if (linea != null)
            this.linea = recorrerLetrasDeLinea(linea,clave);
  //      else System.out.println("excepcion de linea nula");
    }  // constructor
    String getLinea() {
        return linea;
    } // get

    String recorrerLetrasDeLinea(String linea,int clave)  {
        StringBuilder builder = new StringBuilder(0);
        CharacterIterator it = new StringCharacterIterator(linea);
        while (it.current() != CharacterIterator.DONE) {
            Cesar letraCorridaDePosicion = new Cesar(it.current(),clave);
            builder.append(letraCorridaDePosicion.getLetra());
            it.next();
        } // while
        return builder.toString();
    }  // method

}  // class
