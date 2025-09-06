package blatt03;

import java.util.Scanner;

public class PQ {
    public static void main(String[] args) {
        //Initialisierung des Scanners
        Scanner scannerName = new Scanner(System.in);

        //Information
        System.out.println("Willkommen im pq Lösungstool!");
        System.out.println("Befolgen Sie den Anweisungen und geben sie Gleitkommazahlen ein.");
        System.out.println("Erwartete Form der gleichung ist die Normalform (x^2 + p * x + q = 0)");
        //Eingabe
        System.out.println("Bitte geben sie nun p ein:");
        double p = scannerName.nextDouble();
        System.out.println("Bitte geben sie nun q ein:");
        double q = scannerName.nextDouble();

        if (((p/2)*(p/2) - q) < 0) {
            System.out.println("Der Wert unter der Wurzel ist negativ! Bitte überprüfen Sie nochmal p und q!");
            System.exit(0);
        }

        //Rechnung
        double x1 = -(p/2) + Math.sqrt((p/2)*(p/2) - q);
        double x2 = -(p/2) - Math.sqrt((p/2)*(p/2) - q);

        if (((p/2)*(p/2) - q) == 0) {
            System.out.println("In diesem Fall hier gibt es nur eine Lösung. x = 0");
        }
        else {
            //Ausgabe der Ergebnisse
            System.out.println("Lösungen für x: 2");
            System.out.println("X1: " + x1);
            System.out.println("X2: " + x2);
        }
    }
}
