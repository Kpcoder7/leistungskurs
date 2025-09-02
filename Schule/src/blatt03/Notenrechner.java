package blatt03;

import java.util.Scanner;

public class Notenrechner {
    public static void main(String[] args) {
        //Initialisierung des Scanners
        Scanner scannerName = new Scanner(System.in);

        //Infotext
        System.out.println("Willkommen im Notenberechnungstool!");
        System.out.println("Bitte geben Sie ganz Zahlen im positiven Bereich ein");


        //Einholung der benötigten Informationen
        System.out.println("Bitte geben Sie die maximal zu erreichende Anzahl der Punkte, der ersten Aufgabe ein");
        int aufgabe1MaxPunkte = scannerName.nextInt();
        System.out.println("Bitte geben Sie die erreichte Anzahl der Punkte aus der ersten Aufgabe ein");
        int aufgabe1Punkte = scannerName.nextInt();
        if (aufgabe1MaxPunkte <= 0 || aufgabe1Punkte <= 0) {
            System.out.println("Die Zahl muss größer als Null sein und somit im positiven Bereich liegen!");
            System.exit(0);
        }
        else if (aufgabe1Punkte > aufgabe1MaxPunkte) {
            System.out.println("Es gab nur " + aufgabe1MaxPunkte + " Punkte zu erreichen!");
            System.exit(0);
        }

        System.out.println("Bitte geben Sie die maximal zu erreichende Anzahl der Punkte, der zweiten Aufgabe ein");
        int aufgabe2MaxPunkte = scannerName.nextInt();
        System.out.println("Bitte geben Sie die erreichte Anzahl der Punkte aus der zweiten Aufgabe ein");
        int aufgabe2Punkte = scannerName.nextInt();
        if (aufgabe2MaxPunkte <= 0 || aufgabe2Punkte <= 0) {
            System.out.println("Die Zahl muss größer als Null sein und somit im positiven Bereich liegen!");
            System.exit(0);
        }
        else if (aufgabe2Punkte > aufgabe2MaxPunkte) {
            System.out.println("Es gab nur " + aufgabe2MaxPunkte + " Punkte zu erreichen!");
            System.exit(0);
        }

        System.out.println("Bitte geben Sie die maximal zu erreichende Anzahl der Punkte, der dritten Aufgabe ein");
        int aufgabe3MaxPunkte = scannerName.nextInt();
        System.out.println("Bitte geben Sie die erreichte Anzahl der Punkte aus der dritten Aufgabe ein");
        int aufgabe3Punkte = scannerName.nextInt();
        if (aufgabe3MaxPunkte <= 0 || aufgabe3Punkte <= 0) {
            System.out.println("Die Zahl muss größer als Null sein und somit im positiven Bereich liegen!");
            System.exit(0);
        }
        else if (aufgabe3Punkte > aufgabe3MaxPunkte) {
            System.out.println("Es gab nur " + aufgabe3MaxPunkte + " Punkte zu erreichen!");
            System.exit(0);
        }

        System.out.println("Bitte geben Sie die maximal zu erreichende Anzahl der Punkte, der vierten Aufgabe ein");
        int aufgabe4MaxPunkte = scannerName.nextInt();
        System.out.println("Bitte geben Sie die erreichte Anzahl der Punkte aus der vierten Aufgabe ein");
        int aufgabe4Punkte = scannerName.nextInt();
        if (aufgabe4MaxPunkte <= 0 || aufgabe4Punkte <= 0) {
            System.out.println("Die Zahl muss größer als Null sein und somit im positiven Bereich liegen!");
            System.exit(0);
        }
        else if (aufgabe4Punkte > aufgabe4MaxPunkte) {
            System.out.println("Es gab nur " + aufgabe4MaxPunkte + " Punkte zu erreichen!");
            System.exit(0);
        }

        System.out.println("Bitte geben Sie die maximal zu erreichende Anzahl der Punkte, der fünften Aufgabe ein");
        int aufgabe5MaxPunkte = scannerName.nextInt();
        System.out.println("Bitte geben Sie die erreichte Anzahl der Punkte aus der fünften Aufgabe ein");
        int aufgabe5Punkte = scannerName.nextInt();
        if (aufgabe5MaxPunkte <= 0 || aufgabe5Punkte <= 0) {
            System.out.println("Die Zahl muss größer als Null sein und somit im positiven Bereich liegen!");
            System.exit(0);
        }
        else if (aufgabe5Punkte > aufgabe5MaxPunkte) {
            System.out.println("Es gab nur " + aufgabe5MaxPunkte + " Punkte zu erreichen!");
            System.exit(0);
        }

        double hoechstPunktzahl = aufgabe1MaxPunkte + aufgabe2MaxPunkte + aufgabe3MaxPunkte + aufgabe4MaxPunkte + aufgabe5MaxPunkte;
        double gesamtPunktzahl = aufgabe1Punkte + aufgabe2Punkte + aufgabe3Punkte + aufgabe4Punkte + aufgabe5Punkte;

        double prozentZahl = gesamtPunktzahl / hoechstPunktzahl * 100.0;
        System.out.println("Gesamte Punktzahl: " + gesamtPunktzahl + " von " + hoechstPunktzahl + " Punkten");
        System.out.println("Prozent: " + prozentZahl + " %");

        if (prozentZahl >= 85.0) {
            System.out.println("Somit wurde nach MSS Tabelle die Note 1 erreicht");
        }
        else if (prozentZahl >= 70.0) {
            System.out.println("Somit wurde nach MSS Tabelle die Note 2 erreicht");
        }
        else if (prozentZahl >= 55.0) {
            System.out.println("Somit wurde nach MSS Tabelle die Note 3 erreicht");
        }
        else if (prozentZahl >= 39.0) {
            System.out.println("Somit wurde nach MSS Tabelle die Note 4 erreicht");
        }
        else if (prozentZahl >= 17.0) {
            System.out.println("Somit wurde nach MSS Tabelle die Note 5 erreicht");
        }
        else if (prozentZahl < 17.0) {
            System.out.println("Somit wurde nach MSS Tabelle die Note 6 erreicht");
        }

        if (prozentZahl == 100.0) {
            System.out.println("Herzlichen Glückwunsch, es wurde volle Punktzahl erreicht");
        }

        /*
        //Infotext
        System.out.println("Willkommen im Notenberechnungstool!");
        System.out.println("So gehen sie vor:");
        System.out.println("Schritt 1: Geben Sie die Anzahl der Aufgaben ein");
        System.out.println("Schritt 2: Geben sie nach und nach von Aufgabe 1 - Aufgabe x die Punktzahl der Aufgabe ein");
        System.out.println();
        //Einholung der benötigten Informationen
        System.out.println("Bitte geben Sie die Anzahl der Aufgaben ein");
            //Berechnung der einzelnen Aufgaben anzahlen
            int aufgabenAnzahl = scannerName.nextInt();


        System.out.println("Bitte geben Sie hier die Punktzahl der ersten Aufgabe ein: ");


        //Berechnung der Note


        //Ausgabe der Note
        */
    }
}
