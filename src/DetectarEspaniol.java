package net.codejava.io;

public class DetectarEspaniol {
    char ESPACIO = ' ';
    boolean isSpanish (String lineaTest, int clave)  {
        // detecta presencia de idioma español sin utilizar palabras
        // ACLARACION: esto funciona bien, desencripta textos con claves bajas y
        // altas, gracias a que hay muchos caracteres que no son alfabeticos
        for (int i=0; i<lineaTest.length()-1; i++)
            // el -1 es porque no voy a testear el ultimo caracter
            if (lineaTest.charAt(i+1) == ESPACIO)  {
                if (lineaTest.charAt(i)=='a' || lineaTest.charAt(i) =='o'
                        || lineaTest.charAt(i) =='s' || lineaTest.charAt(i) =='.')
                    // PUEDE METERSE ESO EN UN HASHSET
                    // vale para otros idiomas que pongan espacio luego de esas letras
                    // es decir, ante final de palabra junto a espacio, se da por encontrado
                    return true;
            }  // end if hubo espacio
        return false;  // si recorrió toda la linea y no hubo nada de eso, no es Spanish
        // lo cual puede no ser cierto y se puede mejorar, pero siempre va a haber fallas
        // se le puede añadir que el ultimo caracter sea punto o el primero mayuscula.
    }  // detectarEspaniol method
}  // end class
