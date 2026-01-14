package blatt13;

import java.util.Scanner;

public class PenAndPaper {
    public static int wuerfel(int n, int x, boolean vorteil, boolean nachteil) {
        //Variablen
        int ergebnis = 0;
        int ergebnis2 = 0;

        //Vorteils/Nachteils initialisierung
        if ((vorteil && n <= 1) || (nachteil && n <= 1)) {
            n++;
        }

        //Würfel prozess
        for (int i = 0; i <= n-1; i++) {
            System.out.println(i);
            ergebnis += blatt13.Zufall.zufallGanz(x);
            if (vorteil || nachteil) {
                ergebnis2 += ergebnis;
                if(i< 1) {
                    ergebnis = 0;
                }
            }
        }

        //Vorteilsmechanik
        ergebnis2 -= ergebnis; //Wiederherstellung, der beiden einzelnen Ergebnisse beim Würfeln


        //Kritische Ergebnisse
        if(check(ergebnis, ergebnis2, x, vorteil, nachteil) [0] == 0) {
            System.out.println("Kein Check, falscher Würfel!");
        }
        else if(check(ergebnis, ergebnis2, x, vorteil, nachteil) [0] == 1) {
            System.out.println("Kritischer Treffer!");
        }
        else if(check(ergebnis, ergebnis2, x, vorteil, nachteil) [0] == 2){
            System.out.println("Kritischer Fehlschlag!");
        }

        //Zurückgabe des Ergebnisses
        return check(ergebnis, ergebnis2, x, vorteil, nachteil) [1];
    }

    public static int[] check(int ergebnis, int ergebnis2, int x, boolean vorteil, boolean nachteil) {
        int[] ergebnisArray = new int[2];

        //Vorteils und Nachteilsmechanik
        if(vorteil) {
            if (ergebnis2 >= ergebnis) {
                ergebnis = ergebnis2;
                ergebnisArray[1] = ergebnis2;
            }
            else {
                ergebnisArray[1] = ergebnis;
            }
        } else if (nachteil) {
            if (ergebnis2 <= ergebnis) {
                ergebnis = ergebnis2;
                ergebnisArray[1] = ergebnis2;
            }
            else {
                ergebnisArray[1] = ergebnis;
            }
        }

        //Überprüfung, ob es ein kritisches Ergebnis gibt
        if(x == 20) {
            if(ergebnis >= 20) {
                ergebnisArray[0] = 1; //Code für kritischer Treffer
            }
            else if(ergebnis <= 1) {
                ergebnisArray[0] = 2; //Code für kritischer Fehlschlag
            }
            else {
                ergebnisArray[0] = 3; //Code für nichts davon
            }
        }
        else {
            ergebnisArray[0] = 0; //Code für kein 1d20 Würfel
        }

        return ergebnisArray;
    }

    public static int angriff(int ruestungsklasse, int n, int x, int bonus, boolean vorteil, boolean nachteil) {
        //schaden am Gegner
        int angriff = wuerfel(n, x, false, false);
        angriff += bonus;

        //treffer ermittlung
        if (wuerfel(1, 20, vorteil, nachteil) > ruestungsklasse) {
            return angriff;
        }
        else if((wuerfel(1, 20, vorteil, nachteil) <= ruestungsklasse)) {
            return 0;
        }
        else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Eingabe des Würfels
        System.out.println("Wie oft wird gewürfelt?");
        int n = input.nextInt();
        System.out.println("Wie viele Seiten hat der Würfel");
        int x = input.nextInt();

        //Vorteilsmechanik abfrage
        System.out.println("Gibt es eine Vorteilsmechanik? (y/n)");
        char vorteilYN = input.next().charAt(0);
        boolean vorteilsmechanik = false;
        if(vorteilYN == 'y') {
           vorteilsmechanik = true;
        }

        //Nachteilsmechanik abfrage
        boolean nachteilsmechanik = false;
        if(!vorteilsmechanik) {
            System.out.println("Gibt es eine Vorteilsmechanik? (y/n)");
            char nachteilYN = input.next().charAt(0);
            if(nachteilYN == 'y') {
                nachteilsmechanik = true;
            }
        }


        //Prüfungssystem für Würfelart
        if(!((n == 2 && x == 6) || (n == 1 && x == 20))) {
            System.out.println("Ungültige Würfel eingabe! Es sind nur 1d20 und 2d6 Würfel zugelassen");
            System.out.println("Neuen Würfel hinzufügen? Beachte das dabei einige Funktionen eingeschränkt sein könnten! y/n");
            char yn = input.next().charAt(0);
            if(yn == 'y') {
                System.out.println("Neuer Würfel hinzugefügt: " + n + "d" + x + " Würfel");
                wuerfel(n, x, vorteilsmechanik, nachteilsmechanik);
            }
            else if(yn == 'n') {
                System.exit(0);
            }
        }
        else {
            //Ausgabe
            System.out.println("Ergebnis: " + wuerfel(n,x, vorteilsmechanik, nachteilsmechanik));
        }



        //Angriff
        System.out.println("Angriff!!!! " + angriff(6, n, x, 2, vorteilsmechanik, nachteilsmechanik));
    }
}
