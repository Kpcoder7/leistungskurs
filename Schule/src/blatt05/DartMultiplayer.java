package blatt05;

import java.util.Scanner;

public class DartMultiplayer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counter_punkte = 501;

        System.out.println("Wie viele Spieler gibt es?");
        int spielerAnzahl = input.nextInt();

        int[] spieler = new int[spielerAnzahl - 1];
        for (int i = 0; i < spieler.length; i++) {
            spieler[i] = 501;
        }

            outer: //Das lässt uns beide Schleifen mit einem break outer; Befehl stoppen
            while (true) {
                for (int i = 0; i < spielerAnzahl; i++) {
                    int counter_temp = counter_punkte;
                    int anzahl_wuerfe = 0;
                    while (anzahl_wuerfe < 3) {
                        System.out.println("Gebe deine Punktzahl ein (0-60)");
                        int wurf = input.nextInt();
                        counter_temp = counter_temp - wurf;
                        if (counter_temp == 0){
                            System.out.println("0 Punkte! Du hast gewonnen.");
                            break outer;
                        }
                        else if (counter_temp < 0) {
                            System.out.println("Überworfen! Du hast noch " + counter_punkte + " Punkte Rest.");
                            break;
                        }
                        if (anzahl_wuerfe == 2) {
                            counter_punkte = counter_temp;
                        }
                        System.out.println("Die aktuelle Punktzahl ist: " + counter_temp);
                        anzahl_wuerfe++;
                    }
                    System.out.println("Runde beendet.");
                }
        }
    }
}
