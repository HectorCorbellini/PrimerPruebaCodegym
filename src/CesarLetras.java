package net.codejava.io;

// en esta clase se mueven caracteres hacia izquierda o derecha usando el criterio Cesar

public class CesarLetras {
    public static final int minCharNum = Solution.minCharNum;  // primera letra, podria ser mas grande
    public static final int maxCharNum = Solution.maxCharNum;  // incluye el abecedario en inglés y español
    // en la tabla ascii hay 256 caracteres. No estoy incluyendo el 0 que es caracter NULL.
    public static final int CARACTER_CENSURADO = 42; // asterisco, censura en whatsap

    int cesarCodLetra (int codLetraAEncriptar, int clave)  {
        //  muevo una sola letra clave lugares
        // ver la posibilidad de convertir este metodo en un constructor
        if (codLetraAEncriptar < minCharNum || codLetraAEncriptar > maxCharNum)
            // es una validación, si ese numero no esta entre el rango min-max, se reemplaza
            // se puede prescindir de esta validación si se vuelve imposible errarle
            codLetraAEncriptar = CARACTER_CENSURADO;
        codLetraAEncriptar += clave; // corro clave lugares codLetraAEncriptar, eso es Cesar
        if (codLetraAEncriptar > maxCharNum)  // rango excedido hacia adelante
            // entonces sumo al comienzo del rango
            codLetraAEncriptar = minCharNum + (codLetraAEncriptar - maxCharNum);
        else if (codLetraAEncriptar < minCharNum)   // rango excedido hacia atras
            // entonces resto al final del rango
            codLetraAEncriptar = maxCharNum - (minCharNum - codLetraAEncriptar);
        return codLetraAEncriptar;
    } // end método

    char[] cesarCodLinea (char[] charsLinea, int clave)  {
        // recorro la línea de caracteres para aplicarle César
        for (int i= 0; i < charsLinea.length; i++)  {
            // recorro el array letra por letra para modificar cada letra
            int codLetraAEncriptar = charsLinea[i];  // converts to ascii value
            charsLinea[i] = (char) cesarCodLetra(codLetraAEncriptar,clave);
            // reemplaza vieja letra por nueva
        }  //  for
        return charsLinea;
    }  //  cesarCodLinea

}  // end class