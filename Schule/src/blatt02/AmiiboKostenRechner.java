package blatt02;

import java.util.Scanner;

public class AmiiboKostenRechner {
    public static void main(String[] args) {

        Scanner scannerName = new Scanner(System.in);

        System.out.println("Guten Tag, wie viele Amiibo-Figuren möchten Sie bestellen? Eine Kostet 15 €");
        int figurenAnzahl = scannerName.nextInt();
        if  (figurenAnzahl == 0) {
            System.out.println("Sie müssen mindestens eine Figur bestellen");
            System.exit(0);
        }
        else if  (figurenAnzahl < 0) {
            System.out.println("Sie können doch nicht negativ viele Figuren bestellen wollen?!");
            System.exit(0);
        }

        double kosten = figurenAnzahl * 15;

        System.out.println("Preis der Bestellung: " + kosten + " €");
        //Todo: Einreichen und volle Punktzahl abholen
    }
}
