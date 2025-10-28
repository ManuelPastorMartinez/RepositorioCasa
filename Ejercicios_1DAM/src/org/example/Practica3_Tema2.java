package org.example;

import java.util.Scanner;

public class Practica3_Tema2 {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        int posicion = 0;
        char UltimoNumero = 0;
        int UltimaPosicion = 0;
        int PruebaISBN = 0;
        int n = 1;
        int Numero_faltante = 0;
        int tamanyo_ISBN = 0;
        String ISBN = "";
        System.out.println("-----------------");
        System.out.println("****BIENVENIDO AL COMPROBADOR AL ISBN****");
        System.out.println("-----------------");
        System.out.println("¿Qué quieres hacer?");
        System.out.println("[1]-Validar el ISBN");
        System.out.println("[2]-Reparar el ISBN");
        System.out.println("[X]-Salir");
        System.out.println("-----------------");
        String opcion = teclado.next().toLowerCase();
        if (opcion.equals("1") || opcion.equals("2")) {
            System.out.println("Introduce un ISBN");
            ISBN = teclado.next().toLowerCase();
            tamanyo_ISBN = ISBN.length();
            if (tamanyo_ISBN!=10){
                System.out.println("ISBN incorrecto, por favor, introduce un ISBN válido (el ISBN está compuesto por 10 números, el último puede ser una X)");
                return;
            }
        }
        if (tamanyo_ISBN == 10 || opcion.equals("x")) {
            switch (opcion) {
                case "1":
                    for (int i = tamanyo_ISBN - 1; i >= 0; i--) {
                        UltimoNumero = ISBN.charAt(i);
                        if (UltimoNumero == 'x' || UltimoNumero == 'X') {
                            UltimaPosicion = 10;
                        } else {
                            UltimaPosicion = Integer.parseInt(String.valueOf(UltimoNumero));
                        }
                        PruebaISBN += UltimaPosicion * n;
                        n = n + 1;
                    }
                    if (PruebaISBN % 11 == 0) {
                        System.out.println("El ISBN es válido");
                    } else {
                        System.out.println("El ISBN no es válido");
                    }
                    break;
                case "2":
                    for (int i = tamanyo_ISBN - 1; i >= 0; i--) {
                        UltimoNumero = ISBN.charAt(i);
                        if (UltimoNumero == 'x') {
                            UltimaPosicion = 10;
                        } else if (UltimoNumero == '?') {
                            posicion = n;
                            UltimaPosicion = 0;
                        } else {
                            UltimaPosicion = Integer.parseInt(String.valueOf(UltimoNumero));
                        }
                        PruebaISBN += UltimaPosicion * n;
                        n = n + 1;
                    }
                    if (PruebaISBN % 11 == 0) {
                        System.out.println("El numero que falta es 0");
                    } else {
                        for (Numero_faltante = 0; Numero_faltante <= 10; Numero_faltante++) {
                            int PruebaISBN2 = PruebaISBN + Numero_faltante * posicion;
                            if (PruebaISBN2 % 11 == 0) {
                                if (Numero_faltante == 10) {
                                    System.out.println("El número que falta es X");
                                } else
                                    System.out.println("El número que falta es " + Numero_faltante);
                                break;
                            }
                        }
                    }
                    break;
                case "x":
                    System.out.println("Muchas gracias por utilizar nuestros servicios");
                    break;
                default:
                    System.out.println("Por favor introduce una operación válida");
                    break;
            }
        }else {
            System.out.println("Por favor introduce una operación válida");
        }
    }
}