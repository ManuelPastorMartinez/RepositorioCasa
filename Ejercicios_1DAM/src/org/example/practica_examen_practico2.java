package org.example;

import java.util.Random;
import java.util.Scanner;

public class practica_examen_practico2 {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        double numero_a_adivinar = 0;

        Random random = new Random();
        int numero = random.nextInt(100)+0;

        System.out.println("Intenta adivinar el número del programa en 10 intentos");
        for (int i = 1; i<=10; i++){
            System.out.println("Intento "+i+". Introduce un número");
            if (teclado.hasNextInt()) {
                numero_a_adivinar = teclado.nextDouble();
            }else {
                System.out.println("Por favor introduce un número válido.");
                return;
            }

            if (numero_a_adivinar>100 || numero_a_adivinar < 0){
                System.out.println("El número está entre 0 y 100");
            }

            if (numero_a_adivinar > numero){
                System.out.println("Tu número es mayor que el del programa");
            }else if(numero_a_adivinar<numero){
                System.out.println("Tu número es menor que el del programa");
            }else{
                System.out.println("Has acertado! EL número es "+numero);
                return;
            }
        }
        System.out.println("Has fallado, el número era "+(int)numero);
    }
}
