package blatt06;

import java.util.Scanner;

public class Wertetabelle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Grad Abfrage
        System.out.println("Geben Sie den Grad des Polynoms ein:");
        int grad = input.nextInt();

        int[] koeff = new int[grad + 1];

        //Koeffizienten Abfrage
        for (int i = 0; i < koeff.length; i++) {
            System.out.println("Geben Sie den Koeffizenten a" + i + " ein");
            koeff[i] = input.nextInt();
        }

        //Ober und Untergrenze der Wertetabelle
        System.out.println("Geben Sie die Ober und Untergrenze für die Wertetabelle ein:");
        int o = input.nextInt();
        int u = input.nextInt();

        //Tauschen falls Untergranze größer als Obergrenze
        if (u > o) {
            int tmp = u;
            u = o;
            o = tmp;
        }

        //Schrittweite
        System.out.println("Geben Sie bitte die Schrittweite der Wertetabelle ein:");
        double schrittweite = input.nextDouble();
        if (schrittweite > o - u) {
            System.out.println("Schrittweite ist größer als die Wertetabelle!");
            System.exit(0);
        } else if (schrittweite <= 0) {
            System.out.println("Schrittweite muss größer als 0 sein!");
            System.exit(0);
        } else {
            // Wertetabelle ausgeben
            System.out.println("\nWertetabelle:");
            System.out.println("x\tf(x)");
            for (double x = u; x <= o; x += schrittweite) {
                double fx = 0;
                for (int i = 0; i < koeff.length; i++) {
                    fx += koeff[i] * Math.pow(x, i);
                }
                System.out.printf("%.2f\t%.2f%n", x, fx);
            }
        }
    }
}
