package blatt09;

import java.util.Arrays;

public class Primzahlen {
    /**
     * Prüft, ob zahl2 ein Teiler von zahl1 ist.
     * @param zahl1 die Zahl, die geteilt werden soll
     * @param zahl2 die Zahl, durch die geteilt wird
     * @return true, wenn zahl2 zahl1 teilt, sonst false
     */
    public static boolean istTeiler(int zahl1, int zahl2) {
        if (zahl1 % zahl2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Zählt die Anzahl der Teiler einer Zahl.
     * @param zahl die Zahl, deren Teiler gezählt werden
     * @return Anzahl der Teiler
     */
    public static int anzahlTeiler(int zahl) {
        int zahl1 = zahl;
        int teilerCount = 0;
        for (int i = 0; i < zahl; i++) {
            int zahl2 = i + 1;
            if (istTeiler(zahl1, zahl2)) {
                teilerCount++;
            }
        }
        return teilerCount;
    }

    /**
     * Prüft, ob eine Zahl eine Primzahl ist.
     * @param zahl die zu prüfende Zahl
     * @return true, wenn die Zahl prim ist, sonst false
     */
    public static boolean istPrim(int zahl) {
        int teilerCount = anzahlTeiler(zahl);
        if (teilerCount == 2)  {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Gibt alle Primzahlen innerhalb eines Grenzbereiches aus.
     * @param lGrenze linke Grenze des Bereichs
     * @param rGrenze rechte Grenze des Bereichs
     */
    public static void printPrim(int lGrenze, int rGrenze) {
        System.out.print("Innerhalb des Grenzbereiches [" + lGrenze + ", " + rGrenze + "] liegen die Primzahlen: ");
        for (int i = 0; i <= (rGrenze - lGrenze); i++) {
            int zahl = lGrenze + i;
            if (istPrim(zahl)) {
                System.out.print(zahl + ", ");
            }
        }
    }

    /**
     * Generiert ein Array mit den ersten n Primzahlen.
     * @param anzahl die Anzahl der Primzahlen
     * @return Array mit den ersten n Primzahlen
     */
    public static int[] generierePrimzahlen(int anzahl) {
        int[] primzahlen = new int[anzahl];
        int counter = 0;
        while (counter < anzahl) {
            for (int i = 2; i > 0; i++) {
                if (istPrim(i)) {
                    primzahlen[counter] = i;
                    counter++;
                }
                if (counter == anzahl) {
                    break;
                }
            }
        }
        return primzahlen;
    }

    /**
     * Gibt eine Liste aller Primzahlen bis zu einer Obergrenze zurück.
     * @param zahlGrenze die Obergrenze
     * @return Array aller Primzahlen bis zahlGrenze
     */
    public static int[] primListe(int zahlGrenze) {
        // Liste aller Primzahlen bis zahlGrenze erstellen
        int[] temp = new int[zahlGrenze]; // temporäres Array (max. zahlGrenze Primzahlen)
        int counter = 0;
        for (int i = 2; i <= zahlGrenze; i++) {
            if (istPrim(i)) {
                temp[counter] = i;
                counter++;
            }
        }
        // Genaues Array zurückgeben (ohne leere Elemente)
        int[] primzahlen = new int[counter];
        for (int i = 0; i < counter; i++) {
            primzahlen[i] = temp[i];
        }
        return primzahlen;
    }

    /**
     * Zerlegt eine Zahl in ihre Primfaktoren und gibt die Zerlegung aus.
     * @param zahl die zu zerlegende Zahl
     */
    public static void primfaktorzerlegung(int zahl) {
        int[] primzahlen = primListe(zahl);
        System.out.print("Primfaktorzerlegung von " + zahl + ": ");

        boolean first = true; // für das korrekte Setzen von '*'

        for (int i = 0; i < primzahlen.length; i++) {
            int p = primzahlen[i];
            while (zahl % p == 0) { // solange Primzahl teilt
                zahl /= p;
                if (!first) {
                    System.out.print(" * ");
                }
                System.out.print(p);
                first = false;
            }
            if (zahl == 1) break; // fertig, wenn Zahl vollständig zerlegt
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int zahl = 7;
        System.out.print("Die Zahl " + zahl);
        if (istPrim(zahl)) {
            System.out.println(" ist prim.");
        }
        else {
            System.out.println(" ist nicht prim.");
        }

        //b
        /* Ich bin mir an der Stelle nicht sicher gewesen, ob mit Grenze gemeint ist alles von 0 bis zu einer
        bestimmten Grenze, oder wie ich in dem Fall in einem Grenzbereich zwischen lGrenze und rGrenze alles Primzahlen.
         */
        int lGrenze = 7;
        int rGrenze = 307;
        printPrim(lGrenze, rGrenze);

        //c
        int n = 10;
        System.out.println("\n\nDie ersten " + n + " Primzahlen lauten: ");
        System.out.println(Arrays.toString(generierePrimzahlen(n)));

        //d
        int faktorZerlegungZahl = 2424;
        primfaktorzerlegung(faktorZerlegungZahl);
    }
}
