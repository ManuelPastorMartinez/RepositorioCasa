package org.example;

import java.util.Scanner;
import java.util.stream.StreamSupport;

public class Practica2_Tema2 {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        boolean seguir = true;
        double operando = 0;
        double operando2 = 0;
        double resultado = 0;
        //primero se inicializan todas las variables necesarias
        System.out.println("**** BIENVENIDO A LA CALCULADORA RÁPIDA****");

        System.out.println("> Introduce un operando: ");//primero te pide que pongas el primer operando
        if (teclado.hasNextDouble()){//este hasNext actua como try catch, para que no puedas poner nada que no sea un número
            operando = teclado.nextInt();
        }else {
            System.out.println("Por favor introduce un número correcto");//mensaje que salta si intentas poner otra cosa que no sea un número
            seguir = false;//esto es para parar el programa en caso de que salte el try catch
        }

        if (seguir){//si no salta el try catch seguirá funcionando.
            System.out.println("----------------------------------------------");
            System.out.println("[+] -> sumar");
            System.out.println("[-] -> restar");
            System.out.println("[x] -> multiplicar");
            System.out.println("[/] -> dividir");
            System.out.println("[R] -> Raíz Cuadrada");
            System.out.println("----------------------------------------------");
            //primero te pide que eligas la operación que quieres hacer
            System.out.println("Introduce la operación que quieres hacer");
            teclado.nextLine();
            String operacion = teclado.next().toLowerCase();
            //aqui debes poner la operación que quieres hacer
            if (operacion.equals("r")){//este if es para controlar que en el caso que quieras hacer la raíz cuadrada que no te pida el segundo número
                System.out.println("Raíz Cuadrada");
            }else if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x") || operacion.equals("/") ) {//en caso de que eligas otra operación que no sea la raíz cuadrada hará este camino y
                // te pedirá un segundo número
                System.out.println("Introduce el segundo operando");
                if (teclado.hasNextDouble()){//otro hasNext para controlar que no intentes poner otra cosa que no sea un número
                    operando2 = teclado.nextDouble();
                }else{
                    System.out.println("Por favor introduce un operando válido");
                }
            }

            switch (operacion) {//el switch sirve para tener varios casos dependiendo de la operación que quieras hacer.
                case "+"://en caso de que quieras hacer una suma
                    resultado = operando + operando2;

                    System.out.println("El resultado de la suma de " + operando + " y de " + operando2 + " es " + resultado);

                    break;//el break sirve para que no continue con otros casos cuando termine este
                case "-"://en caso de que quieras hacer una resta

                    resultado = operando - operando2;
                    System.out.println("El resultado de la resta de " + operando + " y de " + operando2 + " es " + resultado);
                    break;
                case "x"://en caso de que quieras hacer una multiplicación

                    resultado = operando * operando2;
                    System.out.println("El resultado de la multiplicación de " + operando + " y de " + operando2 + " es " + resultado);
                    break;
                case "/"://en caso de que quieras hacer una división
                    if (operando2 == 0){//este if actúa para que no se pueda dividir entre 0, ya que no se puede
                        System.out.println("No se puede dividir entre 0");
                    }else {
                        resultado = operando/operando2;
                        System.out.println("El resultado de la división de " + operando + " y de " + operando2 + " es " + resultado);
                    }
                    break;
                case "r"://en caso de que quieras hacer una raíz cuadrada
                    if(operando<0){//este if sirve para que no puedas poner un número negativo, ya que la raíz de números negativos cuentan como números irreales lo que no se puede
                        //en una calculadora normal.
                        System.out.println("Por favor pon un número real");
                    }else {
                        resultado = Math.sqrt(operando);
                        System.out.println("El resultado de la raíz cuadrada de "+operando+" es "+resultado);
                    }
                    break;
                default://en caso de que pongas otra cosa que no sea una operación de las que muestra arriba
                    System.out.println("Por favor introduce una operación válida");
                    break;
            }

        }

    }
}