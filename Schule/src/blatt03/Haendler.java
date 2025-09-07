package blatt03;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Haendler {
    public static void main(String[] args) {

        double preise_normale = 5.0;
        double preise_mini = 8.0;
        double preise_micro = 12.0;

        //Initialisierung des Scanners
        Scanner scannerName = new Scanner(System.in);

        //Anzahl Eingabe
        System.out.println("Wie viele normale SD-Karten 32 GB möchten Sie bestellen? (5 € pro Stück)");
        int anzahl_normale = scannerName.nextInt();
        if (anzahl_normale < 0) {
            System.out.println("Der Wert muss 0 oder mehr Betragen!");
            System.exit(0);
        }
        else if (anzahl_normale > 50) {
            anzahl_normale = 50;
            System.out.println("Es dürfen höchstens 50 Karten je Art bestellt werden! Wir haben Ihnen automatisch die Anzahl auf 50 angepasst.");
        }


        System.out.println("Wie viele MiniSD-Karten 32 GB möchten Sie bestellen? (8 € pro Stück)");
        int  anzahl_mini = scannerName.nextInt();
        if (anzahl_mini < 0) {
            System.out.println("Der Wert muss 0 oder mehr Betragen!");
            System.exit(0);
        }
        else if (anzahl_mini > 50) {
            anzahl_mini = 50;
            System.out.println("Es dürfen höchstens 50 Karten je Art bestellt werden! Wir haben Ihnen automatisch die Anzahl auf 50 angepasst.");
        }


        System.out.println("Wie viele MicroSD-Karten 32 GB möchten Sie bestellen? (12 € pro Stück)");
        int anzahl_micro = scannerName.nextInt();
        if (anzahl_micro < 0) {
            System.out.println("Der Wert muss 0 oder mehr Betragen!");
            System.exit(0);
        }
        else if (anzahl_micro > 50) {
            anzahl_micro = 50;
            System.out.println("Es dürfen höchstens 50 Karten je Art bestellt werden! Wir haben Ihnen automatisch die Anzahl auf 50 angepasst.");
        }


        //Berechnung
        double endpreise_normale = preise_normale*anzahl_normale;
        double endpreise_mini = preise_mini*anzahl_mini;
        double endpreise_micro = preise_micro*anzahl_micro;

        double endpreis = endpreise_normale+endpreise_mini+endpreise_micro;

        //Rabatt + Ausgabe
        if (anzahl_normale + anzahl_mini + anzahl_micro > 15) {
            double rabatt = endpreis * 0.15;
            double rabattPreis = endpreis - rabatt;
            System.out.println("Da Sie mehr als 15 Produkte bestellt haben, erhalten Sie unseren Mengenrabatt!");
            System.out.println("Sie sparen " + rabatt + " €" + ". Somit zahlen Sie anstatt von " + endpreis + " €" + " nur noch " + rabattPreis + " €" + "!");
            endpreis = rabattPreis;
            System.out.println();
        }
        System.out.println("Der Preis für...");
        System.out.println(anzahl_normale + " normale SD-Karten");
        System.out.println(anzahl_mini + " MiniSD-Karten");
        System.out.println(anzahl_micro + " MicroSD-Karten");
        System.out.println("...lautet " + endpreis + " €");

    }
}
