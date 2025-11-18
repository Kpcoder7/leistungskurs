package blatt09;

import java.util.Arrays;

public class Teiler {
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
     * Gibt alle natürlichen Teiler einer Zahl aus.
     * @param zahl3 die Zahl, deren Teiler ausgegeben werden
     */
    public static void alleTeiler(int zahl3) {
        int zahl1 = zahl3;
        System.out.println("Alle natürlichen Teiler von " + zahl1 + " sind: ");
        for (int i = 0; i < zahl3; i++) {
            int zahl2 = i + 1;
            if (istTeiler(zahl1, zahl2)) {
                System.out.print(zahl2 + " ");
            }
        }
    }

    /**
     * Zählt die Anzahl der natürlichen Teiler einer Zahl.
     * @param zahl4 die Zahl, deren Teiler gezählt werden
     * @return Anzahl der Teiler
     */
    public static int anzahlTeiler(int zahl4) {
        int zahl1 = zahl4;
        int teilerCount = 0;
        for (int i = 0; i < zahl4; i++) {
            int zahl2 = i + 1;
            if (istTeiler(zahl1, zahl2)) {
                teilerCount++;
            }
        }
        return teilerCount;
    }

    /**
     * Gibt ein Array mit allen Teilern einer Zahl zurück.
     * @param zahl5 die Zahl, deren Teiler im Array zurückgegeben werden
     * @return Array mit allen Teilern der Zahl
     */
    public static int[] teiler(int zahl5) {
        int zahl1 = zahl5;
        int[] teilerListe = new int[anzahlTeiler(zahl1)];
        int teilerCount = 0;
        for (int i = 0; i < zahl5; i++) {
            int zahl2 = i + 1;
            if (istTeiler(zahl1, zahl2)) {
                teilerListe[teilerCount] = zahl2;
                teilerCount++;
            }
        }
        return teilerListe;
    }

    public static void main(String[] args) {
        //a Prüfung ob zahl2 Teiler von zahl1 ist
        int zahl1 = 8;
        int zahl2 = 2;
        System.out.println(istTeiler(zahl1, zahl2));

        //b Ermittlung aller Teiler der zahl3
        int zahl3 = 623;
        alleTeiler(zahl3);

        //c Ausgabe der Anzahl aller Teiler von zahl4
        int zahl4 = 4578;
        System.out.println("\nDie Zahl " + zahl4 + " hat " + anzahlTeiler(zahl4) + " natürliche Teiler");

        //d Ausgabe einer Liste aller Teiler von zahl5
        int zahl5 = 3723;
        System.out.println("Liste aller Teiler der Zahl " + zahl5 + ": " + Arrays.toString(teiler(zahl5)));



        //Arbeiten mit nur einer globalen Zahl
        int zahl6 = 73245; //Hauptzahl
        int zahl7 = 5; //Zahl für die erste Funktion
        System.out.println("\n\nAlles mit nur einer Zahl. Zahl: " + zahl6);
        System.out.println(istTeiler(zahl6, zahl7));

        alleTeiler(zahl6);

        System.out.println("\nDie Zahl " + zahl6 + " hat " + anzahlTeiler(zahl6) + " natürliche Teiler");

        System.out.println("Liste aller Teiler der Zahl " + zahl6 + ": " + Arrays.toString(teiler(zahl6)));
    }
}
