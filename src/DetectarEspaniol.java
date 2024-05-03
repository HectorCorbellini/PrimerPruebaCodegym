package net.codejava.io;

import java.util.HashSet;

public class DetectarEspaniol {

    boolean isSpanish (String lineaTest, int clave)  {
        // detecta presencia de idioma español sin utilizar palabras
        // esto funciona bien gracias a que hay muchos caracteres que no son alfabeticos
        char ESPACIO = ' ';
        HashSet <Character> finDePalabra = new HashSet<>();
        finDePalabra.add('a'); finDePalabra.add('o'); finDePalabra.add('s');
        finDePalabra.add('.');  // caso particular de fin de palabra que tambien puede ser fin de linea

        ManejarLinea manejarLinea = new ManejarLinea();
        lineaTest = manejarLinea.desencriptar(lineaTest,clave);
        // IMPORTANTE: para que isSpanish tuviera responsabilidad única, intenté llevar estas dos
        // líneas a la clase Desencripte. Pero al hacerlo dejó de funcionar, da RuntimeException

        for (int i=0; i<lineaTest.length()-1; i++)
            // el -1 es porque no voy a testear el ultimo caracter
            if (lineaTest.charAt(i+1) == ESPACIO)  {
                if (finDePalabra.contains(lineaTest.charAt(i)))
                    // vale para otros idiomas que pongan espacio luego de esas letras
                    // es decir, ante final de palabra junto a espacio, se da por encontrado
                    return true;
            }  // end if hubo espacio
        return false;  // si recorrió toda la linea y no hubo nada de eso, no es Spanish
        // lo cual puede no ser cierto y se puede mejorar, pero siempre va a haber fallas
        // se le puede añadir que el ultimo caracter sea punto o el primero mayuscula.
    }  // detectarEspaniol method
}  // end class
