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
        //primero inicializo las variables
        String ISBN = "";
        System.out.println("-----------------");
        System.out.println("****BIENVENIDO AL COMPROBADOR AL ISBN****");
        System.out.println("-----------------");
        System.out.println("¿Qué quieres hacer?");
        System.out.println("[1]-Validar el ISBN");
        System.out.println("[2]-Reparar el ISBN");
        System.out.println("[X]-Salir");
        System.out.println("-----------------");
        //aquí hago un pequeño menú para ver la opción que quieres hacer
        String opcion = teclado.next().toLowerCase();//aquí pregunto la opción que quieres hacer de las 3
        if (opcion.equals("1") || opcion.equals("2")) {//este if es para que te pregunte el ISBN si haces la opción 1 o 2
            System.out.println("Introduce un ISBN");
            ISBN = teclado.next().toLowerCase();//aquí introduces el ISBN
            tamanyo_ISBN = ISBN.length();//aquí miras el tamaño ISBN
            if (tamanyo_ISBN!=10){//esto es para que te salga un mensaje por si introduces un ISBN incorrecto.
                System.out.println("ISBN incorrecto, por favor, introduce un ISBN válido (el ISBN está compuesto por 10 números, el último puede ser una X)");
                return;
                //este return sirve para parar el programa si introduces un ISBN incorrecto.
            }
        }
        if (tamanyo_ISBN == 10 || opcion.equals("x")) {
            switch (opcion) {//aqui haces un switch-case para las distintas opciones.
                case "1"://en el primer caso lo que hace es comprobar si el ISBN introducido es un ISBN válido o no
                    for (int i = tamanyo_ISBN - 1; i >= 0; i--) {//este for actúa como un bucle para ir revisando todos los números del ISBN uno por uno.
                        UltimoNumero = ISBN.charAt(i);//esta variable sirve para mirar cuál es el último número.
                        if (UltimoNumero == 'x' || UltimoNumero == 'X') {//este if sorve para ver si el último número es una X.
                            UltimaPosicion = 10;//si el último número es una x la última posición tendrá el valor de 10.
                        } else {
                            UltimaPosicion = Integer.parseInt(String.valueOf(UltimoNumero));//si el último número no es una X haces que el úlitmo número adquiera el valor del número que haya en ese lugar
                            //que hayas puesto.
                        }
                        PruebaISBN = PruebaISBN + (UltimaPosicion * n);//esta variable sirve para ir sumando el valor de PruebaISBN al resultado de UltimaPosicion múltiplicado por el contador
                        n = n + 1;//esto sirve para que el contador vaya aumentando en 1 cada vez que pase el for
                    }
                    if (PruebaISBN % 11 == 0) {//esto es para calcular que el resultado final del ISBN sea divisble por 11, y si lo es es válido y si no no lo es
                        System.out.println("El ISBN es válido");
                    } else {
                        System.out.println("El ISBN no es válido");
                    }
                    break;
                case "2"://en el segundo caso lo que hace es mirar que número te falta y si te falta alguno comprobar cuál es y decirtelo
                    for (int i = tamanyo_ISBN - 1; i >= 0; i--) {//este for hace lo mismo que el de la primera opción
                        UltimoNumero = ISBN.charAt(i);//esta variable es la misma que la de arriba tambiñen (es decir, para mirar si el último número es un número o una X)
                        if (UltimoNumero == 'x') {
                            UltimaPosicion = 10;//si el último número es X actua cómo valor 10
                        } else if (UltimoNumero == '?') {//este if es para ver el caso de que sea una interrogación (que quiere decir que el número no se sabe cuál es)
                            posicion = n;//en esta variable el último número mirará la posición en la que está el número mirando el contador
                            UltimaPosicion = 0;//la última posición se convertirá en 0
                        } else {//si no ocurre ninguna de las dos condiciones
                            UltimaPosicion = Integer.parseInt(String.valueOf(UltimoNumero));//la última posición tomará el valor del número que haya en su lugar
                        }
                        PruebaISBN = PruebaISBN + (UltimaPosicion * n);//hacemos que PruebaISBN se vaya sumando al resultado del contador y de UltimaPosicion
                        n = n + 1;//el contador va sumando en 1 el contador del for
                    }
                    if (PruebaISBN % 11 == 0) {//este if para comprobar que el ISBN esté completo
                        System.out.println("No falta ningún número");//Si al ISBN no le falta ningún número imprimirá este mensaje
                    } else {//en cambio, si al ISBN le falta algun número hará este camino
                        for (Numero_faltante = 0; Numero_faltante <= 10; Numero_faltante++) {//este for es un bucle, ya que mientras Numero_faltante sea menor que 10 irá sumando 1 cada turno para comprobar
                            // cual es el número que le falta al ISBN
                            int PruebaISBN2 = PruebaISBN + Numero_faltante * posicion;//esta variable sirve para guardar el resultado del ISBN con el número faltante
                            if (PruebaISBN2 % 11 == 0) {//aquí ya con el número descubierto hace la comprobación del resultado para ver que es divisible entre 11
                                //pero este no te dirá si es válido o no, si no que te dara el resultado que te falta.
                                if (Numero_faltante == 10) {//esto es para comprobar si el número que falta es 10 o no
                                    System.out.println("El número que falta es X");//si es 10 pondrá X
                                } else
                                    System.out.println("El número que falta es " + Numero_faltante);//si no es 10 te pondrá el número que falta
                                break;
                            }
                        }
                    }
                    break;
                case "x"://en caso de que quieras salir te pondrá el mensaje de bajo
                    System.out.println("Muchas gracias por utilizar nuestros servicios");
                    break;
            }
        }else {//si introduces una operación diferente a las permitidas te pondrá este mensaje.
            System.out.println("Por favor introduce una operación válida");
        }
    }
}