package org.example;

public class practica_examen_teorico {
    static void main() {
        int a = 1, b = 2, c = 3;
        int resultado = 0;

        if (a++ == b && b == c-a){
            resultado = c-= a;
        }else if (a == b && a++ == c){
            resultado = a;
        }else if (c == a){
           resultado = a--;
        }else{
            resultado = b;
        }

        System.out.println("resultado = "+resultado);
        System.out.println("a ="+a);
    }

}
