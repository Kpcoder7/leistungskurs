package blatt04;

import java.util.Scanner;

public class Rechenuebung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Geben Sie die erste Zahl (Gleitkommazahl) ein:");
        double a = input.nextDouble();

        System.out.println("Geben Sie die zweite Zahl (Gleitkommazahl) ein:");
        double b = input.nextDouble();

        boolean ergebnis = false;

        while (ergebnis != true) {
            System.out.println("Gebe die Lösung von " + a + " * " + b + " ein");
            double zahl = input.nextDouble();
            if (zahl == (a * b)) {
                ergebnis = true;
            }
        }
        System.out.println("Gut! Die Lösung ist " + (a * b) + "!");
    }
}
