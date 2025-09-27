package blatt06;

import java.util.Scanner;

public class notenliste {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Bitte geben Sie die Anzahl der Noten ein:");
        int notenAnzahl = input.nextInt();

        int[] notenListe = new int[notenAnzahl];
        for (int i = 0; i < notenAnzahl; i++) {
            System.out.println("Bitte geben Sie Note " + (i + 1) + " ein:");
            notenListe[i] = input.nextInt();
        }

        for (int i = 0; i < notenAnzahl; i++) {
            System.out.println((notenListe[i]));
        }
    }
}
