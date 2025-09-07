package blatt03;

import java.util.Scanner; //Importieren des Scanners aus der Java Bibliothek

public class MinMax {
    public static void main(String[] args) {
        Scanner scannerName = new Scanner(System.in); //Initialisierung des Scanners

        //Eingabe der Zahlen
        System.out.println("Nennen Sie mir eine (ganze) Zahl");
        int ersteZahl = scannerName.nextInt();

        System.out.println("Nennen Sie mir noch eine (ganze) Zahl");
        int zweiteZahl = scannerName.nextInt();

        System.out.println("Nennen Sie mir eine letzte (ganze) Zahl");
        int dritteZahl = scannerName.nextInt();

        //Berechnung größte / kleinste Zahl
        if (ersteZahl >= zweiteZahl && ersteZahl >= dritteZahl) {
            // ersteZahl ist die größte
            System.out.println("Die größte Zahl lautet " + ersteZahl);

            if (zweiteZahl <= dritteZahl) {
                System.out.println("Die kleinste Zahl lautet " + zweiteZahl);
            } else {
                System.out.println("Die kleinste Zahl lautet " + dritteZahl);
            }
        }
        else if (zweiteZahl >= ersteZahl && zweiteZahl >= dritteZahl) {
            // zweiteZahl ist die größte
            System.out.println("Die größte Zahl lautet " + zweiteZahl);

            if (ersteZahl <= dritteZahl) {
                System.out.println("Die kleinste Zahl lautet " + ersteZahl);
            } else {
                System.out.println("Die kleinste Zahl lautet " + dritteZahl);
            }
        }
        else {
            // dritteZahl ist die größte
            System.out.println("Die größte Zahl lautet " + dritteZahl);

            if (ersteZahl <= zweiteZahl) {
                System.out.println("Die kleinste Zahl lautet " + ersteZahl);
            } else {
                System.out.println("Die kleinste Zahl lautet " + zweiteZahl);
            }
        }

        /*
        Vorgehensweise:
        Prüfung welches die größte Zahl ist durch x >= y && x >= z etc.
        Danach wir schnell geprüft, welches die kleinste ist.
         */
    }
}
