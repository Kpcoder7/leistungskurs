package blatt03;

import java.util.Scanner;

public class MitOderOhneStrom {
    public static void main(String[] args) {
        //Initialisierung des Scanners
        Scanner scannerName = new Scanner(System.in);

        System.out.println("Bitte wählen sie eines dieser Gatter aus: NOT, OR, AND, XOR");
        String gatterTyp = scannerName.next();

        if  (!gatterTyp.equals("NOT") && !gatterTyp.equals("OR") && !gatterTyp.equals("AND") && !gatterTyp.equals("XOR")) {
            System.out.println("Fehlerhafte eingabe");
            System.exit(0);
        }


        System.out.println("Das " + gatterTyp + " Gatter:");
        boolean A = true;
        boolean B = true;

        if (gatterTyp.equals("NOT")) {
            System.out.println("Das Gatter verfügt über 1 Eingänge und einen Ausgang");

            System.out.println("Bitte geben Sie nun Eingang 1 ein (true/false)");
            A = scannerName.nextBoolean();
        }
        else {
            System.out.println("Das Gatter verfügt über 2 Eingänge und einen Ausgang");

            System.out.println("Bitte geben Sie nun Eingang 1 ein (true/false)");
            A = scannerName.nextBoolean();

            System.out.println("Bitte geben Sie nun Eingang 2 ein (true/false)");
            B = scannerName.nextBoolean();
        }

        boolean ausgabe = false;

        if (gatterTyp.equals("AND")) {
            ausgabe = A && B;
            System.out.println("1");
        }
        else if (gatterTyp.equals("NOT")) {
            ausgabe = !A;
            System.out.println("2");
        }
        else if (gatterTyp.equals("OR")) {
            ausgabe = A || B;
            System.out.println("3");
        }
        else if (gatterTyp.equals("XOR")) {
            ausgabe = A ^ B;
            System.out.println("4");
        }

        System.out.println("Ergebnis: " + ausgabe);
    }
}
