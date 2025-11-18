package blatt08;

public class Klammernsprache {
    /**
     * Prüfung wie viele öffnende(zaehler++) und schließende (zaehler--) Klammern ein String hat und speichern im Zähler dieses Wertes. Ende soll der Zähler 0 sein.
     * @param folge Der String, welcher die Klammern enthält
     * @return von true oder false, jenachdem ob Zähler 0 oder nicht
     */
    public static boolean istKlammerwort(String folge) {
        int zaehler = 0;
        for (int i = 0; i < folge.length(); i++) {
            char zeichen = folge.charAt(i);

            if (zeichen == '(') {
                zaehler++;
            } else if (zeichen == ')') {
                zaehler--;
            }

            if (zaehler < 0) {
                return false; // zu viele schließende Klammern
            }
        }

        return zaehler == 0;
    }
    public static void main(String[] args) {
        String klammerwort = "())()(())";
        boolean ergebnis = istKlammerwort(klammerwort);
        if (ergebnis) {
            System.out.println(klammerwort + " ist ein Klammerwort");
        }
        else {
            System.out.println(klammerwort + " ist kein Klammerwort");
        }
    }
}
