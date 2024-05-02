package net.codejava.io;

/*
 * Este programa encripta un archivo de formato .txt en cifrado Cesar
 * lo cual hace linea por linea y luego puede desencriptarlo por varios métodos
 * @author Hector Corbellini

   NOTA: Este código lo testié en Linux con distintas claves y todas funcionan bien.
   Sin embargo al llevarlo a Windows no me reconoció el cambio a path C:\
   MEJORAS QUE PUEDEN HACERSE:
   - Poner en HashSet los caracteres chequeados en if
   - Ponerle un constructor a la clase Cesar
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    // aqui se lee un archivo y se lo copia a otro
    public static final int minCharNum = 10;  // primera letra del rango ascii utilizado
    public static final int maxCharNum = 254;  // incluye el abecedario en inglés y español
    // en la tabla ascii hay 256 caracteres. Se puede hacer variar minCharNum y maxCharNum
    public static final int rangoClaves = maxCharNum - minCharNum;
    // no se utilizaran caracteres fuera de ese rango ascii, por lo que si se hacen cambian
    // las constantes minCharNum y maxCharNum, debe cuidarse que quede incluido el alfabeto
    public static final int RANGO_EXCEDIDO = -1;
    //constante para indicar que el recorrido del rango terminó
    public static final int POCAS_LETRAS = 20;
    public static final byte ENCRIPTAR = 1;
    public static final byte DESENCRIPTAR = 2;
    public static final byte FUERZABRUTA = 3;
    public static final byte ANALISIS = 4;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println ("Bienvenido a encriptacion de archivos. Elija procedimiento:");
        System.out.println ("digite "+ENCRIPTAR+" - para encriptar su archivo");
        System.out.println ("digite "+DESENCRIPTAR+" - para desencriptar su archivo");
        System.out.println ("digite "+FUERZABRUTA+" - para desencriptar por fuerza bruta");
        System.out.println ("digite "+ANALISIS+" - para desencriptar por analisis criptográfico");
        int opcion = scanner.nextInt();
        switch (opcion)   {
            case 1 : ManejarArchivos(ENCRIPTAR); break;
            case 2 : ManejarArchivos(DESENCRIPTAR); break;
            case 3 : ManejarArchivos(FUERZABRUTA); break;
            case 4 : ManejarArchivos(ANALISIS); break;
            default:  System.out.println ("Opcion debe estar entre 1 y 4");
        } // switch
    }  // main

    public static void ManejarArchivos(byte nroElegido) {
        // aqui se cuidan las IOexcepciones en archivos
        //   posibilidad: System.out.println ("Ingrese ruta del archivo:");
        //                String ruta = scanner.nextLine();
        try {
            FileReader reader = new FileReader("/home/uko/Documentos/prueba.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            FileWriter writer = new FileWriter("/home/uko/Documentos/resultado.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            int clave = 0;  // la clave que se usará para trabajar el texto
            String linea = null;  // sobre esta linea string se hará casi toda la tarea
            if (nroElegido == ENCRIPTAR || nroElegido == DESENCRIPTAR)
                clave = RecibirClave();  // recibe la clave de encriptacion
            // aqui comienza lectura linea por linea del archivo
            while ((linea = bufferedReader.readLine()) != null) {
                if (nroElegido == ENCRIPTAR)  {
                    ManejarLinea manejarLinea = new ManejarLinea();
                    linea = manejarLinea.encriptar(linea,clave);
                    }  //  if encriptar
                else if (nroElegido == DESENCRIPTAR)  {
                    ManejarLinea manejarLinea = new ManejarLinea();
                    linea = manejarLinea.desencriptar(linea,clave);
                }  //  if desencriptar
                else if (nroElegido == FUERZABRUTA)  {
                    // si es la primer linea del archivo, escudriñarla
                    // solo esa linea porque se volveria lento y complejo testear varias lineas
                    // inconveniente: si es una linea corta tendrá dificultad. Habría que agregar:
                   //     if (linea.length() > POCAS_LETRAS)  donde POCAS_LETRAS = 20 o 30 aproximadamente
                   //  es decir habría que considerar que la primera linea puede ser una sola palabra,
                   //  por ejemplo un titulo. Entonces no funcionará, y la solucion es volver a leer otra linea
                   //  y esa segunda linea debe quedar unida a la primera en una sola linea. Esa rutina queda
                   //  para implementar a futuro.
                    if (clave == 0)  // en clave 0 escudriño el texto
                        {
                          Desencripte desencripte = new Desencripte();
                          clave = desencripte.fuerzaBruta(linea);  // encuentra clave escondida
                        } // if
                    // la class FuerzaBruta se llama una sola vez
                    // en el resto del archivo desencripto con la clave ya encontrada:
                    if (clave != RANGO_EXCEDIDO)  {
                        ManejarLinea manejarLinea = new ManejarLinea();
                        linea = manejarLinea.desencriptar(linea,clave);
                        } // if not rango excedido
                    // con la clave encontrada se procesa todo el archivo debido al while
                } // if fuerza bruta
                /*  LA OPCION ANALISIS FALTA AJUSTARLA
                else if (nroElegido == ANALISIS)
                    if (clave == 0)  // si la clave no fue usada, o sea solo leera una linea
                        if (linea.length() > POCAS_LETRAS)
                            // porque si la línea es solo una palabra no arrojará datos suficientes
                          Desencripte desencripte = new Desencripte();
                          clave = desencripte.aplicarAnalisis(linea);  // encuentra clave escondida
                if (clave != RANGO_EXCEDIDO)
                        ManejarLineas manejarLineas = new ManejarLineas();
                        linea = manejarLineas.desencriptar(linea,clave);
                */
                bufferedWriter.write(linea);  // añado al archivo la linea modificada
                bufferedWriter.newLine();
            } // while
            bufferedWriter.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace(); }
    }  // metodo manejar archivos

    private static int RecibirClave()  {
        System.out.println ("Ingrese numero de encriptación: ");
        int clave = 0;  // cero no encriptará
        clave = scanner.nextInt();
        while (clave > rangoClaves || clave < 1) { // validacion de la clave
            System.out.println ("Numero debe estar entre 01 y "+ rangoClaves +". Ingrese nuevamente:");
            clave = scanner.nextInt();
        }  // while
        return clave;
    }  // metodo recibir clave

}  // class
