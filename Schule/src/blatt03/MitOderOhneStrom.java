package blatt03;

import java.util.Scanner;

public class MitOderOhneStrom {
    public static void main(String[] args) {
        //Initialisierung des Scanners
        Scanner scannerName = new Scanner(System.in);

        //Gatter-typ Auswahl
        System.out.println("Bitte wählen Sie eines dieser Gatter aus: NOT, OR, AND, XOR");
        String gatterTyp = scannerName.next();

        //Abfangen von falschen Eingaben
        if  (!gatterTyp.equals("NOT") && !gatterTyp.equals("OR") && !gatterTyp.equals("AND") && !gatterTyp.equals("XOR")) {
            System.out.println("Fehlerhafte Eingabe");
            System.exit(0);
        }

        //Info
        System.out.println("Das " + gatterTyp + "-Gatter:");
        //Initialisierung von A und B
        boolean A = true;
        boolean B = true;

        //Filter ob NOT oder Rest → NOT nur eine Eingabe
        if (gatterTyp.equals("NOT")) {
            System.out.println("Das Gatter verfügt über 1 Eingang und einen Ausgang");

            System.out.println("Befindet sich auf dem ersten Eingang Strom? (true/false)");
            A = scannerName.nextBoolean();
        }
        else {
            System.out.println("Das Gatter verfügt über 2 Eingänge und einen Ausgang");

            System.out.println("Befindet sich auf dem ersten Eingang Strom? (true/false)");
            A = scannerName.nextBoolean();

            System.out.println("Befindet sich auf dem zweiten Eingang Strom? (true/false)");
            B = scannerName.nextBoolean();
        }

        //initialisierung ausgabe
        boolean ausgabe = false;

        //Auswertung
        if (gatterTyp.equals("AND")) {
            ausgabe = A && B;
            //System.out.println("1");
        }
        else if (gatterTyp.equals("NOT")) {
            ausgabe = !A;
            //System.out.println("2");
            System.out.println(A + " = " + ausgabe);
        }
        else if (gatterTyp.equals("OR")) {
            ausgabe = A || B;
            //System.out.println("3");
        }
        else if (gatterTyp.equals("XOR")) {
            ausgabe = A ^ B;
            //System.out.println("4");
        }

        //Ausgabe
        if (gatterTyp.equals("AND") || gatterTyp.equals("OR") || gatterTyp.equals("XOR")) {
            System.out.println(A + " " + gatterTyp + " " + B + " = " + ausgabe);
        }

    }
}
