package com.example.cryptography;

public class Cesar {
    private char letraModificada;

    public Cesar (char letra,int clave) {
        if (letra >= Ajustes.minCharNum && letra <= Ajustes.maxCharNum)
            letraModificada = recorrer(letra,clave);
        else System.out.println("letra inválida");
    } // constructor

    public char getLetra() {
        return letraModificada;
    } // get

    private char recorrer(char letra,int clave)  {
        // corro clave lugares el codigo de la letra a encriptar
        int codigoLetraModificada = (int)letra + clave;
        if (codigoLetraModificada > Ajustes.maxCharNum)  // rango excedido hacia adelante
            // entonces sumo al comienzo del rango
            codigoLetraModificada = Ajustes.minCharNum + (codigoLetraModificada - Ajustes.maxCharNum);
        else if (codigoLetraModificada < Ajustes.minCharNum)   // rango excedido hacia ajtras
            // entonces resto desde el final del rango
            codigoLetraModificada = Ajustes.maxCharNum - (Ajustes.minCharNum - codigoLetraModificada);
        return (char)codigoLetraModificada;
    } // method

} // class
