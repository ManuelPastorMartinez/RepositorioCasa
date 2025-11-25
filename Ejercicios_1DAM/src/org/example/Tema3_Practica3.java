package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Tema3_Practica3 {
    static void main() {

        Scanner teclado =new Scanner(System.in);


        System.out.println("******* VALIDADOR DE COMPATIBILIDAD ZX SPECTRUM *******");
        System.out.println("Introduce la resolución de tu pantalla (ancho x alto)...");//Comienzo pidiendo la anchura y la altura
        System.out.println("Ancho:");
        int anchura = teclado.nextInt();
        System.out.println("Alto: ");
        int altura = teclado.nextInt();

        if (altura % 8 == 0 && anchura % 8 == 0 && altura<=48 && anchura<=48){//Si la altura y la anchura son múltiplos de 8 y son menos de 48 corre el programa
            String matriz[][]= new String[altura][anchura];//Creo una matriz nueva que tenga las medidas de la altura y la anchura

            System.out.println("Introduce (línea a línea) los colores de tu imagen para píxel: ");
            for (int i = 0; i < matriz.length; i++  ) {//El for que sirve para recorrer la matríz
                String letras = teclado.next();//Creo esta variable para ir introduciendo las letras que quiero poner
                String vector[] = letras.split("");//Aquí creo un vector que separe las letras como quiero
                if (letras.matches("[a-oA-O]+") && vector.length==anchura){//Este if sirve para controlar que solo se pueda hasta la o
                    for (int j = 0; j < matriz[i].length; j++) {//Si el formato es correcto se introducen los valores de la matríz
                        matriz[i][j] = vector[j];
                    }
                }else{//Si el formato no es el correcto te hace este camino y te lo vuelve a pedir
                    System.out.println("Has introducido un valor de píxel incorrecto (A-O)");
                    i--;//Esto es para que el se pueda volver a introducir el for sin avanzar ninguna línea
                }
            }

            for (String fila[]:matriz){//Se imprime la matríz
                System.out.println(Arrays.toString(fila));
            }
            //Ahora toca la parte de validación
            int contador = 0;//Primero se crea un contador para controlar cuantas letras hay, cuando se crea una letra, el contador aumentará en 1

            String colores[] = new String[2];//Creo un nuevo array que guarde las nuevas letras que se vayan añadiendo y que solo tenga capacidad para 2 letras

            for (int i = 0; i < matriz.length; i++) {//Recorro la matríz de nuevo
                for (int j = 0; j < matriz[i].length; j++) {
                    String letra = matriz[i][j];//Creo una variable que se llama letra que lo que hace es ver cual es la letra que está guardada en esa posición

                    //Distintos casos

                    if (contador == 0) {// Si no hay ninguna letra guardada aún
                        colores[0] = letra;//Guardo la primera letra que me encuentro en la primera posición de colores (color 1)
                        contador++;//Cambio el contador a 1 (que indica que hay una letra)
                    }

                    else if (contador == 1) { // Si hay una letra guardada
                        if (!letra.equals(colores[0])) {//Si la letra no es la misma que me he guardado anteriormente
                            colores[1] = letra;//Meto esta letra en la ssegunda posicion de colores (el color 2)
                            contador++;//Cambio el contador a 2 (que indica que hay dos letras)
                        }
                    }

                    else { // Si ya hay dos letras guardadas
                        if (!letra.equals(colores[0]) && !letra.equals(colores[1])) {//Si la letra no es la misma que ninguna de las dos que tengo guardadas
                            contador++; //Sumo el contador a 3 (indicando que hay más de 2 letras distintas)
                        }
                    }
                }
            }

            if (contador <= 2) {//Finalmente si el contador es 2 o menos será compatible (ya que hay menos de dos letras)
                System.out.println("Es compatible con ZX Spectrum");
            } else {//Si no significará que hay más de 2 letras y no será compatible
                System.out.println("No es compatible con ZX Spectrum");
            }

        }else {
            System.out.println("Resolución incorrecta (tiene que ser múltiplo de 8 y como máximo de 48)");
        }//En cambio, si la altura y la anchura no son múltiplos de 8 o son más de 48 el programa muestra este mensaje
    }
}