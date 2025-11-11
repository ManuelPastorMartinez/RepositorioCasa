package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Practica1_Tema3 {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();//ponemos un random al principio para utilizarlo más adelante
        String equipo ="";
        int suma = 0;
        final int PODER = 30;
        int equipo_actual = 1;
        boolean estado = true;
        int equipo1[]= new int[7];
        int equipo2[]= new int[7];
        int ronda = 0;
        //inicializamos todas las variables necesarias para utilizarlas mas adelante

        do{//Este bucle sirve para que te pida el poder de los equipos mientras no tengan la potencia adecuada
            suma = 0;
            System.out.println("Equipo "+ equipo_actual);//Esto es para indicar el equipo en el que se encuentra el bucle
            System.out.print("Introduce la potencia de los samurais: ");
            equipo= teclado.nextLine();//Aquí se introducen las 7 potencias de los samurais
            String cadena_equipo[] = equipo.split(" ");//Esto es para que separar los números introducidos de esta manera específica

            int vector[] = new int[cadena_equipo.length];//Este vector sirve para controlar que no pongas más o menos samurais de los necesarios
            for (int i=0;i<cadena_equipo.length;i++){//este for sirve para sumar todos los números de los samurais y ver si la potencia esta bien
                vector[i] = Integer.parseInt(cadena_equipo[i]);
                suma += vector[i];
            }
            if (vector.length != 7){//Si pones más o menos samurais de los necesarios te salta este mensaje
                System.out.println("ERROR. Introduce 7 samurais");
            }else {
                if (suma != PODER ) {//Si la suma de todas las potencias de cada samurai da otro número que no es 30 te salta este error
                    System.out.println("ERROR. La potencia total no suma 30");

                }else {
                    if (equipo_actual == 1){//este if es para indicar que si estás en el equipo 1 haga las acciones
                        equipo1 = vector.clone();//Esto sirve para copiar la potencia del vector introducido arriba al equipo 1
                        equipo_actual++;
                    }else{//En cambio si el equipo es el 2o se acabará el bucle
                        equipo2 = vector.clone();//Esto sirve para lo mismo que el if de arriba pero con las potencias introducidas en la segunda vuelta
                        break;
                    }
                    System.out.println("Equipo completado");
                }
            }
        }while (true);

        System.out.println("Empieza la batalla!");
        int samurai_equipos = random.nextInt(7);//Aquí se utiliza el random para ver en cuál samurai se comienza y que así sea a suerte y no puedas
        //enviar el samurai más fuerte primero
        System.out.println("La batalla inicia con el samurai "+samurai_equipos);
        int muertes_equipo1 = 0;
        int muertes_equipo2 = 0;
        //Creo estas dos variables que se van a ir sumando conforme gane un equipo u otro
        for (int i = 0;i<7;i++){//Utilizo un for para controlar la batalla entera
            int bucle = (samurai_equipos + i) % 7;//Este bucle sirve para que si llega al último samurai y aun no ha acabado la batalla que
            //pase al samurai del principio del, es decir, que el bucle sea circular.

            System.out.println("Samurai " + (bucle + 1) + ".");//Aqui se indica el samurai que inicia
            if (equipo1[bucle]>equipo2[bucle]){//Si el samurai del equipo 1 tiene más poder que el del equipo 2 hace esta acción
                System.out.println("Gana el equipo 1. "+equipo1[bucle] +" vs "+equipo2[bucle]);
                muertes_equipo2++;//Suma una muerte al equipo 2
            }else if (equipo2[bucle]>equipo1[bucle]){//En cambio si el samurai del equipo 2 tiene más poder que el del 1 hace esta otra
                System.out.println("Gana el equipo 2. "+equipo1[bucle] +" vs "+equipo2[bucle]);
                muertes_equipo1++;//Suma una muerte al equipo 1
            }else {//Si los dos tienen el mismo poder quedan empate
                System.out.println("Empate " +equipo1[bucle] + " vs " +equipo2[bucle]);
            }
        }

        if (muertes_equipo1>muertes_equipo2){//Si el equipo 1 tiene más muertes gana el equipo 2 y muestra este mensaje
            System.out.println("Equipo 2 GANA! El equipo 1 ha tenido "+muertes_equipo1 + " bajas.");
        }else if (muertes_equipo2>muertes_equipo1){//En cambio, si el equipo 2 tiene más muertes muestra este otro mensaje
            System.out.println("Equipo 1 GANA! El equipo 2 ha tenido "+muertes_equipo2 + " bajas.");
        }else{//Y si tienen las mismas muertes muestra este mensaje de empate
            System.out.println("Empate! Ambos equipos han tenido "+muertes_equipo1 + " bajas.");
        }



    }
}