package blatt02;

import  java.util.Scanner;

public class Haendler {
    public static void main(String[] args) {
        double preise_normale = 5.0;
        double preise_mini = 8.0;
        double preise_micro = 12.0;

        //Initialisierung des Scanners
        Scanner scannerName = new Scanner(System.in);
        //anzahl
        System.out.println("Wie viele normale SD-Karten 32 GB möchten sie bestellen (5€ pro Stück)");
        int anzahl_normale = scannerName.nextInt();

        System.out.println("Wie viele mini SD-Karten 32 GB möchten sie bestellen (8€ pro Stück)");
        int  anzahl_mini = scannerName.nextInt();

        System.out.println("Wie viele micro SD-Karten 32 GB möchten sie bestellen (12€ pro Stück)");
        int anzahl_micro = scannerName.nextInt();

        //Berechnung
        double endpreise_normale = preise_normale*anzahl_normale;
        double endpreise_mini = preise_mini*anzahl_mini;
        double endpreise_micro = preise_micro*anzahl_micro;

        double endpreis = endpreise_normale+endpreise_mini+endpreise_micro;

        System.out.println("Der Preis für...");
        System.out.println(anzahl_normale + " normale SD Karten");
        System.out.println(anzahl_mini + " mini SD Karten");
        System.out.println(anzahl_micro + " microSD Karten");
        System.out.println("...lautet " + endpreis + " €");
    }
}
