package blatt03;

import java.util.Scanner;

public class PQAllgemein {
    public static void main(String[] args) {
        Scanner scannerName = new Scanner(System.in);

        System.out.println("Willkommen im pq Lösungstool!");
        System.out.println("Befolgen Sie den Anweisungen und geben Sie Gleitkommazahlen ein.");
        System.out.println("Erwartete Form der Gleichung ist die Normalform (a * x^2 + b * x + c = d)");

        //Einholung der Variablen
        System.out.println("Bitte geben Sie nun a ein:");
        double a = scannerName.nextDouble();

        System.out.println("Bitte geben Sie nun b ein:");
        double b = scannerName.nextDouble();

        System.out.println("Bitte geben Sie nun c ein:");
        double c = scannerName.nextDouble();

        System.out.println("Bitte geben Sie nun d ein:");
        double d = scannerName.nextDouble();

        //Normalisierung der quadratischen Gleichung
        //Normalisierung von a zu 1
        if (a < 1) {
            b = b * (-1);
            c = c * (-1);
            d = d * (-1);
            a = a * (-1);
        }
        if (a > 1) {
            b = b / a;
            c = c / a;
            d = d / a;
            a = 1.0; //a = a / a
        }

        //Normalisierung von d zu 0
        if (a == 1) {
            if (d > 0) {
                c = c - d;
                d = 0.0; //d = d - d
            }
            else if (d < 0) {
                c = c + (d *(-1));
                d = 0.0; //d = d + (d *(-1))
            }
        }

        //Ausgabe der Variablen
        System.out.println("Die Variablen lauten nun: a = " + a + ", b = " + b + ", c = " + c + ", d = " + d);

        //initialisierung von p und q zur übersicht
        double p = b;
        double q = c;

        double wurzel = (p/2)*(p/2) - q;

        if (wurzel < 0) {
            System.out.println("Der Wert unter der Wurzel ist negativ! Bitte überprüfen Sie nochmal p und q!");
            System.exit(0);
        }

        //Rechnung
        double x1 = -(p/2) + Math.sqrt(wurzel);
        double x2 = -(p/2) - Math.sqrt(wurzel);

        if (wurzel == 0) {
            System.out.println("In diesem Fall hier gibt es nur eine Lösung. x = 0");
        }
        else {
            //Ausgabe der Ergebnisse
            System.out.println("Lösungen für x: 2");
            System.out.printf("X1: %.3f \n", x1);
            System.out.printf("X2: %.3f", x2);
        }
    }
}