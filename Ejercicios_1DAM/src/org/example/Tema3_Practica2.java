package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Tema3_Practica2 {
    static void main() {

        Scanner teclado = new Scanner(System.in);
        Random random = new Random();
        boolean estado = true;
        int contador = 0;//esta variable va a servir para contar los números que coinciden entre el número del jugador y los generados aleatoriamente

        System.out.println("Introduce los números de tu loteria (formato N-N-N-N-N-N/R)");//El programa comienza pidiendote números que cumplan este formato
        String numero_propio = teclado.next();

        boolean numero_propio_string = numero_propio.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}/\\d");//El .matches sirve para comprobar que lo cumples
        if (numero_propio_string){//Si lo cumples se ejecuta el if (que es el programa entero) y si no te pone el mensaje del else
            String vector_numero_propio[] = numero_propio.split("[-/]");//Esto sirve para separar la combinación de números con este formato
            int numero_propio_int[] = new int[6];//creamos un int para pasar la combinación de números en string a enteros ya que el boolean .matches solo funciona con string
            for (int i =0; i< numero_propio_int.length;i++){//el for para ir recorriendo el vector creado y pasarlo a int
                numero_propio_int[i] = Integer.parseInt(vector_numero_propio[i]);
            }
            int reintegro_propio = Integer.parseInt(vector_numero_propio[6]);//el reintegro es el último número por lo que se coje la última posición directamente

            int numero_ganador[]=new int[6];//creamos un vector para la combinación ganadora generada automáticamente
            int reintegro = random.nextInt(10);//generamos un reintegro entre 0 y 10
            int complementario = random.nextInt(49)+1;;//generamos un número complementario entre 0 y 49
            while (estado) {//este while sirve para generar otro número si se repite algún número
                estado = false;
                Arrays.sort(numero_ganador);
                for (int i = 0; i < numero_ganador.length; i++) {
                    numero_ganador[i] = random.nextInt(49) + 1;//Se va generando el vector conforme se recorre el for
                    if (i !=numero_ganador.length-1 && numero_ganador[i]==numero_ganador[i + 1]) {//este if es para generar otro número distinto en caso de que se repita
                        numero_ganador[i] = random.nextInt(49) + 1;
                        estado = true;
                    }
                    if (numero_ganador[i]==complementario||numero_ganador[i]==reintegro||complementario==reintegro){//este if es para generar un nuevo reintegro o un nuevo complementario si coinciden con algún número
                        //de la combinación ganadora
                        reintegro =random.nextInt(10);
                        complementario = random.nextInt(49)+1;
                        estado =true;
                    }
                }
            }
            Arrays.sort(numero_ganador);//se ordena el número ganador
            Arrays.sort(numero_propio_int);//se ordena el número del jugador una vez cogido el reintegro

            System.out.println("El número del premio es: "+ Arrays.toString(numero_ganador));
            System.out.println("Complementario : "+complementario);
            System.out.println("Reintegro: "+reintegro);

            for (int i = 0;i<numero_ganador.length;i++){
                for (int n = 0;n<numero_ganador.length;n++){//los dos for sirven para poder recorrer las variables del número del jugador y el generado
                    if (numero_propio_int[i]==numero_ganador[n]){
                        contador++;//si coinciden los números el contador aumenta en 1
                    }
                }
            }
            System.out.println(contador);

            int acierto_complementario = 0;//esta variable es para ver si se ha acertado el número complementario
            for(int i=0;i<numero_propio_int.length;i++){//se recorre el vector del jugador para ver si coincide el complementario o no
                if (numero_propio_int[i]==complementario){
                    acierto_complementario++;//si el complementario se suma es que ha coincidido con algún número del jugador
                }
            }

            if (contador==6 && reintegro_propio==reintegro ){//si se aciertan los 6 números y el reintegro es categoría especial
                System.out.println("Categoría especial");
            }else if (contador==6){//si se aciertan los 6 números pero no el reintegro es 1a categoría
                System.out.println("1ª categoría");
            }else if (contador == 5 && acierto_complementario==1){//Si se aciertan 5 números y el complementario es 2a categoría
                System.out.println("2ª categoría");
            } else if (contador==5) {//si se aciertan 5 números solo es 3a categoría
                System.out.println("3ª categoría");
            } else if (contador==4){//si se aciertan 4 números es 4a categoría
                System.out.println("4ª categoría");
            } else if (contador==3) {//si se aciertan 3 números es 5a categoría
                System.out.println("5ª categoría");
            }else if (reintegro_propio==reintegro){//si se aciertan menos de 3 números y el reintegro te devuelven el dinero
                System.out.println("Reintegro");
            }else {//Si se aciertan menos de 3 números y no el reintegro no se te devuelve nada
                System.out.println("Has perdido");
            }
        }else {
            System.out.println("Este no es un formato válido");
        }

    }
}