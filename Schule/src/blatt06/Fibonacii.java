package blatt06;

import  java.util.Scanner;

public class Fibonacii {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Geben Sie eine Zahl n ein");
        int zahl = input.nextInt();

        int[] fibonacci = new int[zahl];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < zahl; i++){
            fibonacci[i] = (fibonacci[i-1]) + (fibonacci[i-2]);
        }

        /* Falls eine Ausgabe gefordert wird:
        for (int i = 0; i < zahl; i++){
            System.out.println(fibonacci[i]);
        }
        */

        //Quotient
        double quotient = (double) fibonacci[zahl-1] / fibonacci[zahl-2];
        System.out.println("Quotient = " + quotient);

        //c Goldener Schnitt
    }
}
