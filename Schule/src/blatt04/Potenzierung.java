package blatt04;

import java.util.Scanner;

public class Potenzierung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Bitte geben Sie die Basis an:");
        int a = input.nextInt(); //basis
        int b = a; // zweite Zahl
        System.out.println("Bitte geben Sie den natürlichen Exponenten an:");
        int n = input.nextInt(); //exponent

        int repeats = 1; //repeats initialisierung

        if (n > 0) { //erster Fall: positiv normal
            while (repeats < n) {
                a = b * a;
                repeats++;
            }
            System.out.println("Ergebnis: " + a);
        }
        else if (n == 0) { //zweiter Fall: hoch 0 immer 1
            System.out.println("Ergebnis: 1");
        }
        else if (n < 0){ //dritter Fall: negativ normal
            n *= -1; //zurücksetzung auf positiv für die´Rechnung
            double c = a; //Initialisierung double
            while (repeats < n) {
                c = b * c;
                repeats++;
            }
            System.out.println("Ergebnis: " + (1.0 / c)); //Ausgabe und verrechnung des negativen Aspektes
        }
    }
}
