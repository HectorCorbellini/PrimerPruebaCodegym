package com.example.cryptography;

public class Espaniol {
    // aqui se detecta presencia de idioma español sin utilizar palabras
    // esto funciona bien gracias a que hay muchos caracteres que no son alfabeticos
    boolean detectar (String lineaTest,int clave)  {
        lineaTest = new Recorrer(lineaTest,clave).getLinea();
        char letraSiguiente;
        for (int i=0; i<lineaTest.length()-1; i++)  {
            // el -1 es porque no debe testearse el ultimo caracter
            letraSiguiente = lineaTest.charAt(i+1);
            if (letraSiguiente == Ajustes.ESPACIO || letraSiguiente == Ajustes.finDeLinea)
                if (Ajustes.finDePalabra.contains(lineaTest.charAt(i)))
                    return true;
                    // vale para otros idiomas que pongan espacio luego de esas letras
                    // es decir, ante final de palabra junto a espacio, se da por encontrado
        }  // for
        return false;  // si recorrió toda la linea y no hubo nada de eso, no es espaniol
        // se le puede añadir que el ultimo caracter sea punto o el primero mayuscula.
    }  // method
} // class
