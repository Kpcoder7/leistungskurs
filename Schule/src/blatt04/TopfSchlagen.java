package blatt04;

import java.util.Scanner;
import java.util.Random;

public class TopfSchlagen {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int topfx = rand.nextInt(5) + 1;
        int topfy = rand.nextInt(5) + 1;

        int playerx = 0;
        int playery = 0;

        while(true) {
            System.out.println("Steuerung (w,a,s,d)");
            char steuerung = input.next().toLowerCase().charAt(0);

            if (steuerung != 'w' && steuerung != 'a' && steuerung != 's' && steuerung != 'd') {
                System.out.println("Keine gültige eingabe");
            }
            else {
                if (steuerung == 'w') {
                    playery += 1;
                }
                if (steuerung == 'a') {
                    playerx -= 1;
                }
                if (steuerung == 's') {
                    playery -= 1;
                }
                if (steuerung == 'd') {
                    playerx += 1;
                }
            }

            double entfernung = Math.sqrt(
                    (playerx - topfx) * (playerx - topfx) + (playery - topfy) * (playery - topfy)
            );

            String temperatur = "warm";

            if (entfernung >= 5) {
                temperatur = "kalt";
            }
            else if (entfernung >= 2) {
                temperatur = "lauwarm";
            }
            else if (entfernung >= 1) {
                temperatur = "warm";
            }
            else if (entfernung >= 0.5) {
                temperatur = "heiß";
            }

            System.out.println("Entfernung: " + temperatur);



            if (topfx == playerx && topfy == playery) {
                System.out.println("Herzlichen Glückwunsch, Du hast gewonnen!");
                break;
            }
            System.out.println("Deine Position gerade:");
            System.out.println("X: " + playerx);
            System.out.println("Y: " + playery);
            System.out.println();
        }
    }
}
