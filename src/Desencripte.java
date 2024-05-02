package net.codejava.io;

// en esta clase se desencripta una linea

public class Desencripte {
    // CUIDADO!! VUELVO A PONER LAS MISMAS CONSTANTES PORQUE LA CLASE NO LAS RECONOCE
    public static final int RANGO_EXCEDIDO = -1;
    public static final int minCharNum = 10;  // primera letra del rango ascii utilizado
    public static final int maxCharNum = 254;  // incluye el abecedario en inglés y español
    // en la tabla ascii hay 256 caracteres. Se puede hacer variar minCharNum y maxCharNum
    public static final int rangoClaves = maxCharNum - minCharNum;

    int fuerzaBruta (String linea)  {
        // aplica Cesar cambiando las claves hasta que se vuelva español
        int claveBruta = 0;
        boolean esEspaniol = false;
        ManejarLinea manejarLinea = new ManejarLinea();
        DetectarEspaniol detectarEspaniol = new DetectarEspaniol();
        // ahora recorro la linea cambiando hasta rangoClaves veces las posiciones de letras
        while ( ! esEspaniol && claveBruta <= rangoClaves)  {
            claveBruta++;
            linea = manejarLinea.desencriptar(linea,claveBruta);
            esEspaniol = detectarEspaniol.isSpanish(linea,claveBruta);
        }  // end while
        if (claveBruta > rangoClaves) return RANGO_EXCEDIDO;
        else return claveBruta;
    }  // fuerza bruta method
}  // class
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

