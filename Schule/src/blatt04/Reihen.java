package blatt04;

import java.util.Scanner;

public class Reihen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Wie viele Zahlen möchten Sie je Reihe ausgegeben bekommen?");
        int anzahl = input.nextInt(); //initialisierung der Anzahl
        if (anzahl <= 0 || anzahl >= 10000) { //abfangen von negativen Zahlen und zu großen Zahlen
            System.out.println("Die Zahl muss größer als 0, oder kleiner gleich 10000 sein!");
            System.exit(0);
        }

        int repeats = 1; //Wiederholungsvariable; Verwendung auch zur Ausgabe

        //repeats + 1 Schleife
        System.out.println("Reihe 1:");
        while (true) {
            System.out.print(repeats + " "); //Ausgabe
            if (repeats == anzahl) { //Breakbedingung
                repeats = 1;
                break;
            }
            repeats++; //Erhöhung von repeats
        }
        System.out.println(); //Zeilenabstand

        //2er Schleife (repeats * 2)
        System.out.println("Reihe 2:");
        while (true) {
            System.out.print((repeats * 2) + " ");//Ausgabe
            if (repeats == anzahl) { //Breakbedingung
                repeats = 1;
                break;
            }
            repeats++; //Erhöhung von repeats
        }
        System.out.println();//Zeilenabstand

        //Quadratzahl Schleife (repeats * repeats)
        System.out.println("Reihe 3:");
        while (true) {
            System.out.print((repeats * repeats) + " ");//Ausgabe
            if (repeats == anzahl) { //Breakbedingung
                repeats = 1;
                break;
            }
            repeats++; //Erhöhung von repeats
        }
        System.out.println();//Zeilenabstand

        //positiv negativ Schleife
        System.out.println("Reihe 4:");
        while (repeats <= anzahl) { //Breakbedingung
            if (repeats % 2 == 0) {
                System.out.print((-repeats / 2) + " ");//Ausgabe
            } else {
                System.out.print(((repeats + 1) / 2) + " ");//Ausgabe
            }
            repeats++; //Erhöhung von repeats
        }
        System.out.println();//Zeilenabstand

        /*
        Mit for-Schleifen würde es so aussehen:
        System.out.println("Reihe 1:");
        for (int i = 1;i <= anzahl; i++) {
            System.out.print(i + " ");
        }
         */
    }
}
