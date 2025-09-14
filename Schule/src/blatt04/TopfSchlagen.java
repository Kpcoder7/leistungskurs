package blatt04;

import java.util.Scanner;
import java.util.Random;

public class TopfSchlagen {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        //Random Topf Koordinaten
        int topfx = rand.nextInt(5) + 1;
        int topfy = rand.nextInt(5) + 1;

        //Player Koordinaten
        int playerx = 0;
        int playery = 0;

        //Spiel Prozess
        while(true) {
            System.out.println("Steuerung (w,a,s,d)");
            char steuerung = input.next().toLowerCase().charAt(0); //Eingabe

            //Abfangen von Fehleingaben
            if (steuerung != 'w' && steuerung != 'a' && steuerung != 's' && steuerung != 'd') {
                System.out.println("Keine gültige eingabe");
            }
            else {
                if (steuerung == 'w') {
                    playery += 1;
                    //Spielgrenze Einhalten
                    if (playery < 0 || playery > 5) {
                        playery -= 1;
                        System.out.println("Du kannst das Feld nicht verlassen!");
                    }
                }
                if (steuerung == 'a') {
                    playerx -= 1;
                    //Spielgrenze Einhalten
                    if (playerx < 0 || playerx > 5) {
                        playerx += 1;
                        System.out.println("Du kannst das Feld nicht verlassen!");
                    }
                }
                if (steuerung == 's') {
                    playery -= 1;
                    //Spielgrenze Einhalten
                    if (playery < 0 || playery > 5) {
                        playery += 1;
                        System.out.println("Du kannst das Feld nicht verlassen!");
                    }
                }
                if (steuerung == 'd') {
                    playerx += 1;
                    //Spielgrenze Einhalten
                    if (playerx < 0 || playerx > 5) {
                        playerx -= 1;
                        System.out.println("Du kannst das Feld nicht verlassen!");
                    }
                }
            }

            //Entfernung Berechnung nach wie viele Felder gelaufen werden müssen
            double entfernung = Math.abs(playerx - topfx) + Math.abs(playery - topfy);

            //Ausgabe Warm / Kalt
            String temperatur = "heiß";

            if (entfernung > 4) {
                temperatur = "eiskalt"; // Spieler ist ganz weit weg
            }
            else if (entfernung > 3) {
                temperatur = "kalt";
            }
            else if (entfernung > 2) {
                temperatur = "lauwarm";
            }
            else if (entfernung > 1) {
                temperatur = "warm";
            }
            else if (entfernung > 0) {  // Spieler steht direkt neben dem Topf
                temperatur = "heiß";
            }

            System.out.println("Entfernung: " + temperatur);

            //Gewonnen Ausgabe und Prüfung
            if (topfx == playerx && topfy == playery) {
                System.out.println("Herzlichen Glückwunsch, Du hast gewonnen!");
                break;
            }
            //Position Ausgabe
            System.out.println("Deine Position gerade:");
            System.out.println("X: " + playerx);
            System.out.println("Y: " + playery);
            System.out.println();
        }
    }
}
