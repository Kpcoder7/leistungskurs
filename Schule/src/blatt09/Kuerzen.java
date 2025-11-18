package blatt09;

public class Kuerzen {
    /**
     * Prüft, ob zahl2 ein Teiler von zahl1 ist.
     * @param zahl1 die Zahl, die geteilt werden soll
     * @param zahl2 die Zahl, durch die geteilt wird
     * @return true, wenn zahl2 zahl1 teilt, sonst false
     */
    public static boolean istTeiler(int zahl1, int zahl2) {
        if (zahl1 % zahl2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Berechnet den größten gemeinsamen Teiler (ggT) von zwei Zahlen a und b.
     * @param a erste Zahl
     * @param b zweite Zahl
     * @return der größte gemeinsame Teiler von a und b
     */
    public static int ggT(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    /**
     * Prüft, ob ein Bruch kürzbar ist (ggT > 1).
     * @param zaehler der Zähler des Bruchs
     * @param nenner der Nenner des Bruchs
     * @return true, wenn der Bruch kürzbar ist, sonst false
     */
    public static boolean istKuerzbar(int zaehler, int nenner) {
        return ggT(zaehler, nenner) > 1;
    }

    /**
     * Kürzt einen Bruch vollständig und gibt das Ergebnis aus.
     * @param zaehler der Zähler des Bruchs
     * @param nenner der Nenner des Bruchs
     */
    public static void kuerzen(int zaehler, int nenner) {
        int min = Math.min(zaehler, nenner); // kleinere Zahl bestimmen
        for (int i = 2; i <= min; i++) {
            while (zaehler % i == 0 && nenner % i == 0) { // solange i beide teilt
                zaehler /= i;
                nenner /= i;
                min = Math.min(zaehler, nenner); // neue Grenze für weitere Kürzungen
            }
        }
        System.out.println("\nDer vollkommen gekürzte Bruch lautet nun: " + zaehler + "/" + nenner);
    }

    public static void main(String[] args) {
        /*Ich war mir an der Stelle nicht sicher, ob ich von hier aus auf Teiler.java zugreifen soll und die funktionen
        von dort verwenden soll, oder ob ich nur das Wissen von den Aufgaben hier verwenden soll. Ich habe mich an der
        Stelle für den zweiten Fall entschieden und verwende das gelernte aus Teiler.java in Kuerzen.java, da es mir
        rationaler erscheint
         */

        //Bruch
        int zaehler = 12;
        int nenner = 18;

        //a
        System.out.print("Der Bruch " + zaehler + "/" + nenner);
        if  (istKuerzbar(zaehler, nenner)) {
            System.out.print(" ist kürzbar");
        }
        else {
            System.out.print(" ist nicht kürzbar");
        }

        //b
        kuerzen(zaehler, nenner);
    }
}
