package blatt08;

import java.util.Scanner;

public class SuchenUndErsetzen {
    /**
     * Ersetzen funktion in kurzer Variante. Benutzung von text.replace um die Buchstaben zu ersetzen
     * @param text text, welcher bearbeitet wird
     * @param suchen char, welches ersetzt werden soll
     * @param ersetzen char, welches zum ersetzen benutzt wird
     * @return rückgabe des Textes in ersetzter Variante
     */
    public static String ersetzen(String text, char suchen,char ersetzen) {
        return text.replace(suchen, ersetzen);
    }

    /**
     * Ersetzen funktion in langer Variante. Benutzung einer for Schleife um die Buchstaben zu ersetzen
     * @param text text, welcher bearbeitet wird
     * @param suchen char, welches ersetzt werden soll
     * @param ersetzen char, welches zum ersetzen benutzt wird
     * @return rückgabe des Textes in ersetzter Variante
     */
    public static String ersetzen2(String text, char suchen, char ersetzen) {
        String ergebnis = "";
        for (int i = 0; i < text.length(); i++) {
            char aktuell = text.charAt(i);
            if (suchen == aktuell) {
                ergebnis += ersetzen;
            }
            else {
                ergebnis += aktuell;
            }
        }
        return ergebnis;
    }

    public static void main(String[] args) {
        //Scanner initialisierung
        Scanner input = new Scanner(System.in);

        //Eingabe der Zeichen
        System.out.println("Welches Zeichen willst du ersetzen lassen?");
        char suchen = input.next().charAt(0);
        System.out.println("Durch welches Zeichen möchtest du es ersetzen lassen?");
        char ersetzen = input.next().charAt(0);

        //Text, der bearbeitet wird
        String text = "Dies hier ist ein Beispiel text 1234567890";

        //Trigger für die kurze Variante
        System.out.println("Kurze Variante:");
        System.out.println(ersetzen(text, suchen, ersetzen));

        //Trigger für die lange Variante
        System.out.println("\nLange Variante:");
        System.out.println(ersetzen2(text, suchen, ersetzen));

    }
}
