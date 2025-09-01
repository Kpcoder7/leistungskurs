package blatt02;

import java.util.Scanner;

public class Multiplikation {
    public static void main(String[] args) {
        Scanner scannerName = new Scanner(System.in);

        System.out.println("Nenne die erste (ganze) Zahl");
        int zahl1 = scannerName.nextInt();
        System.out.println("Nenne die zweite (ganze) Zahl");
        int zahl2 = scannerName.nextInt();

        int ergebnis = zahl1 * zahl2;
        System.out.println(zahl1 + " * " + zahl2 + " = " + ergebnis);
    }
}
