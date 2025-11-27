package org.example;

import javax.swing.text.Style;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class practica_examen_practico_tema3 {
    static void main() {
        Scanner teclado =new Scanner(System.in);
        Random aleatorio = new Random();
        boolean comprobacion = true;
        String filas = "";

        System.out.println("***BIENVENIDO AL BINGO CANTÁBRICO***");
        int bolas[] = new int[aleatorio.nextInt(30)+10];
        int numeros_bingo[] = new int[bolas.length];

            for (int i = 0; i < bolas.length; i++) {
                numeros_bingo[i] = aleatorio.nextInt(90) + 1;
            }

        while (comprobacion) {

            comprobacion=false;
            Arrays.sort(numeros_bingo);

            for (int i = 0; i < bolas.length; i++) {
                if (i != bolas.length - 1 && numeros_bingo[i] == numeros_bingo[i + 1]) {
                    numeros_bingo[i] = aleatorio.nextInt(90) + 1;
                    comprobacion = true;
                }
            }
        }


        System.out.println(bolas.length+" extraidas hasta ahora: "+ Arrays.toString(numeros_bingo));

        System.out.println("*** Introduce los datos de tu cartón ***");
        String carton_usuario[][] = new String[3][3];

        for (int i = 0; i < carton_usuario.length; i++) {
            System.out.println("Fila "+(i+1));
            filas = teclado.next();
            boolean formato_filas = filas.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}");
            if (!formato_filas){
                System.out.println("Formato incorrecto, cerrando programa...");
                return;
            }
            String formato_filas_vector[] = filas.split("-");

            for (int j = 0; j < carton_usuario[i].length; j++) {
                carton_usuario[i][j] = formato_filas_vector[j];

            }


        }

        System.out.println("Datos del cartón introducido: ");

        for (String fila[]: carton_usuario){
            System.out.println(Arrays.toString(fila));
        }


        System.out.println("PREMIOS:");




    }
}
