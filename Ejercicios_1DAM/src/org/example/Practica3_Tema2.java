package org.example;

import java.util.Scanner;

public class Practica3_Tema2 {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        String ISBN = "";
        int tamanyo_ISBN = 0;
        int SumaISBN = 0;
        int UltimoNumero = 0;
        System.out.println("****BIENVENIDO AL COMPROBADOR AL ISBN****");
        System.out.println("---------------------------------");
        System.out.println("¿Que quieres hacer?");
        System.out.println("[1]-Validar el ISBN");
        System.out.println("[2]-Reparar el ISBN");
        System.out.println("[X]-Salir");
        System.out.println("---------------------------------");

        String opcion = teclado.next().toLowerCase();
        teclado.nextLine();
        switch (opcion){
            case "1":

                System.out.println("Has escogido validar el ISBN");
                System.out.println("Primero por favor introduce tu ISBN");
                ISBN = teclado.next();
                tamanyo_ISBN = ISBN.length();
                SumaISBN = 0;

                if (tamanyo_ISBN == 10){
                    for (int i = 0; i >= 10  ; i++){
                        String trozo_10 = String.valueOf(ISBN.charAt(9));
                        UltimoNumero = 0;

                        if (trozo_10 == "X" || trozo_10 == "x"){
                            UltimoNumero = 10;
                        }else if (trozo_10 != "X" || trozo_10 != "x"){
                            UltimoNumero = 9;
                        }else {
                            System.out.println("El último número debe ser un número o la letra X");
                        }
                    }
                    SumaISBN += UltimoNumero * 10;

                    if (SumaISBN % 11 == 0){
                        System.out.println("El ISBN es válido");
                    }else {
                        System.out.println("EL ISBN no es válido");
                    }
                }else {
                    System.out.println("Tamaño incorrecto, por favor introduce un ISBN válido");
                }

                break;
            case "2":
                break;
            case "x":
                break;
            default:
                System.out.println("Introduce una opción válida que quieras hacer");
                break;
        }


    }
}