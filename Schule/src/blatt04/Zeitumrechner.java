package blatt04;

import java.util.Scanner;

public class Zeitumrechner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Bitte geben Sie eine Sekunden-Zahl ein, welche umgerechnet werden soll:");
        long sekunden = input.nextLong();

        //Berechnung
        long tage = sekunden / (24 * 60 * 60); //Sekunden zu Tage
        sekunden = sekunden % (24 * 60 * 60); //Rest wieder in Sekunden

        long stunden = sekunden / (60 * 60); //Sekunden zu Stunden
        sekunden = sekunden % (60 * 60); //Rest wieder zu Sekunden

        long minuten = sekunden / 60; //Sekunden zu Minuten
        sekunden = sekunden % 60; //Rest zu Sekunden

        //Ausgabe
        System.out.println("Tage: " + tage + ", Stunden: " + stunden + ", Minuten: " + minuten + ", Sekunden: " + sekunden);
    }
}
