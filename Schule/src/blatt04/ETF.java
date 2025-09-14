package blatt04;

import java.util.Random;
import java.util.Scanner;

public class ETF {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();

        //Variablen
        double sparbetrag = 0.0;
        double gesamtBetrag = 0.0;
        double wertsteigerung = 1.0;
        double wert = 3578.89;
        double anteil = 0.0;

        int monat = 0;
        int jahr = 1;

        System.out.println("Für wie viele Jahre wollen Sie den Markt simulieren?");
        int jahrAnzahl = input.nextInt();

        while (jahr <= jahrAnzahl) {
            System.out.println("\nBitte geben Sie einen Beliebigen Sparbetrag für dieses Jahr ein:");
            sparbetrag = input.nextDouble();
            System.out.println("Jahr " + jahr); //Jahrescounter
            System.out.println("Monat\tSparrate\tZinsen\t\tKapital\t\tAnteil\t\tETF-Wert"); //Tabelle
            while(monat < 12) {
                monat++;

                //Zinsberechnung
                double zinssatz = rnd.nextDouble();
                zinssatz = 6 * (zinssatz + 1) * 0.01;
                wertsteigerung = 1 + zinssatz;

                //Gesamtbetrag
                gesamtBetrag = gesamtBetrag * wertsteigerung;

                //Kaufbare Anteile
                anteil = sparbetrag / wert;

                gesamtBetrag += anteil * wert;

                //ETF Wertsteigerung
                wert = wert * wertsteigerung;

                //Tabellen Inhalt
                System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.4f\t\t%.2f\n", monat, sparbetrag, wertsteigerung, gesamtBetrag, anteil, wert);
            }
            jahr++;
            monat = 0;
        }
    }
}
