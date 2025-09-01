package blatt02;

import java.util.Scanner;

public class AmiiboKostenRechner {
    public static void main(String[] args) {

        Scanner scannerName = new Scanner(System.in);

        System.out.println("Guten Tag, wie viele Amiibo-Figuren möchten sie bestellen? Eine Kostet 15€");
        int figurenAnzahl = scannerName.nextInt();

        double kosten = figurenAnzahl * 15;

        System.out.println("Preis der Bestellung: " + kosten + "€");
    }
}
