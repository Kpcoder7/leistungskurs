package blatt03;

import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {
        Scanner scannerName = new Scanner(System.in);

        System.out.println("Nenne mir eine (ganze) Zahl");
        int ersteZahl = scannerName.nextInt();

        System.out.println("Nenne mir noch eine (ganze) Zahl");
        int zweiteZahl = scannerName.nextInt();

        System.out.println("Nenne mir eine letzte (ganze) Zahl");
        int dritteZahl = scannerName.nextInt();


        if (ersteZahl > zweiteZahl) {
            if (ersteZahl > dritteZahl) {
                System.out.println("Die größte Zahl lautet " + ersteZahl);
            }
            else {
                System.out.println("Die größte Zahl lautet " + dritteZahl);
            }
        }
        else if (ersteZahl < zweiteZahl) {
            if (zweiteZahl > dritteZahl) {
                System.out.println("Die größte Zahl lautet " + zweiteZahl);
            }
            else {
                System.out.println("Die größte Zahl lautet " + dritteZahl);
            }
        } //TODO: Fall verarbeiten, wenn zwei Zahlen gleich groß sind
        //TODO: Kleinste Zahl mit ausgeben
    }
}
