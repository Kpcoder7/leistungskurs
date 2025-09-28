package blatt05;

import java.util.Random;
import java.util.Scanner;

public class auftraege {
    public static void main(String[] args) {
        int[] auftraege = new int[]{9000, 23000, 41000, 6000, 13000, 22000, 38000, 16000, 7000, 14000, 12000, 5000, 17000};
        System.out.println("Der Gesamtbetrag aller Aufträge beträgt: " + (auftraege[0] + auftraege[1] + auftraege[2] + auftraege[3] + auftraege[4] + auftraege[5] + auftraege[6] + auftraege[7] + auftraege[8] + auftraege[9] + auftraege[10] + auftraege[11] + auftraege[12]) + " €");
        System.out.println("Folgende Aufträge betragen mehr als 15000 €:");
        for (int i = 0; i < auftraege.length; i++) {
            if (auftraege[i] >= 15000) {
                System.out.println(auftraege[i]);
            }
        }

        Random rnd = new Random();
        Scanner input = new Scanner(System.in);

        System.out.println("Wie lang soll das Array werden?");
        int laenge = input.nextInt();

        int[] randomAuftraege = new int[laenge];

        for (int i = 0; i < auftraege.length - 1; i++) {
            int kosten = (rnd.nextInt(16) + 4) * 1000;
            randomAuftraege[i] = kosten;
        }

    }
}
