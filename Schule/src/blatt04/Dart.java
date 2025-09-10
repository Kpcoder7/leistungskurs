package blatt04;

import java.util.Scanner;
/*
|-----------------------------------------------------------------------------------|
Aufgabe:
Du kennst sicherlich die Sportart Dart. Falls nicht ist das gar kein Problem,
denn hier sind die nochmal die Regeln (verkürtzt):
1. Ein Dartspiel beginnt bei 501 Punkten.
2. Ein Spieler kann in jeder Runde eine Punktzahl zwischen 0-180.
3. Die geworfenen Punkte werden in jeder Runde von der Gesamtpunktzahl abgezogen.
4. Das Spiel endet, wenn man exakt 0 Punkte erreicht. Sollte man ins negative geraten,
wird man auf den Wert von der vorherigen Runde zurückgesetzt.

Implementiere nun einen automatischen Dartzähler, damit der Spieler seine Punkte nicht
selbst im Kopf rechnen muss.
 |-----------------------------------------------------------------------------------|
 */
public class Dart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Erzeuge Scanner

        int punkte = 501; //Variable "punkte" mit 501 initialisiert -->Startwert

        System.out.println("Gebe deine Punktzahl ein (0-180)");
        int wurf = scanner.nextInt(); //Setzt die Variable "wurf" auf den eingegebenen Wert (Es kann angenommen, dass nur gültige Werte eingegeben werden)



    }
}