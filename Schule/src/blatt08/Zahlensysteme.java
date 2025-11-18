package blatt08;

public class Zahlensysteme {
    /**
     * Prüft, ob die übergebene Zahl im Binärsystem vorliegt.
     * Erwartet Format: (Ziffern 0 und 1)2, z. B. "(1011 0111 1100)2"
     * @param zahl die Zahl als String
     * @return true, wenn Binärzahl korrekt formatiert, sonst false
     */
    public static boolean istBinaer(String zahl) {
        return zahl.matches("\\([01 ]+\\)2");
    }

    /**
     * Prüft, ob die übergebene Zahl im Hexadezimalsystem vorliegt.
     * Erwartet Format: (Ziffern 0-9 und Buchstaben A-F)16, z. B. "(B7C)16"
     * @param zahl die Zahl als String
     * @return true, wenn Hexadezimalzahl korrekt formatiert, sonst false
     */
    public static boolean istHexadezimal(String zahl) {
        return zahl.matches("\\([0-9A-Fa-f]+\\)16");
    }

    /**
     * Prüft, ob die übergebene Zahl im Dezimalsystem vorliegt.
     * @param zahl die Zahl als String
     * @return true, wenn nur Ziffern enthalten, sonst false
     */
    public static boolean istDezimal(String zahl) {
        return zahl.matches("[0-9]+");
    }

    /**
     * Wandelt die übergebene Zahl (Binär, Hexadezimal oder Dezimal) in eine Dezimalzahl um.
     * @param zahl die Zahl als String
     * @return die Zahl als int im Dezimalsystem
     * @throws IllegalArgumentException wenn die Eingabe ungültig ist
     */
    public static int zuDezimal(String zahl) {
        int dezi = 0;
        int potenz = 1;
        //Binärfall
        if (istBinaer(zahl)) {
            // Klammern und Leerzeichen entfernen
            String binaer = zahl.substring(1, zahl.indexOf(')')).replace(" ", "");
            dezi = 0;
            potenz = 1;
            // Von rechts nach links durch die Ziffern gehen
            for (int i = binaer.length() - 1; i >= 0; i--) {
                char c = binaer.charAt(i);
                if (c == '1') {
                    dezi += potenz; // Wert addieren
                }
                // '0' ignorieren
                potenz *= 2; // nächste Potenz
            }
            return dezi;
        }
        //Hexadezimalfall
        else if (istHexadezimal(zahl)) {
            String hex = zahl.substring(1, zahl.indexOf(')')); // Klammern entfernen
            dezi = 0;
            potenz = 1;
            // Von rechts nach links durch die Ziffern gehen
            for (int i = hex.length() - 1; i >= 0; i--) {
                char c = hex.charAt(i);
                int wert;

                if (c >= '0' && c <= '9') {
                    wert = c - '0'; // Ziffer 0-9
                } else {
                    c = Character.toUpperCase(c); // Buchstaben groß
                    wert = 10 + (c - 'A'); // A-F → 10-15
                }

                dezi += wert * potenz;
                potenz *= 16; // nächste Potenz
            }

            return dezi;
        }

        //Dezimalfall
        else if (istDezimal(zahl)) {
            return Integer.parseInt(zahl);
        }

        // Ungültige Eingabe
        else {
            throw new IllegalArgumentException("Ungültige Eingabe: " + zahl);
        }
    }

    public static void main(String[] args) {
        String zahlen1 = "2940";
        String zahlen2 = "(1011 0111 1100)2";
        String zahlen3 = "(B7C)16";

        System.out.println("Zahl 1: " + zahlen1 + " zu Hexadezimal:");
        System.out.println(zuDezimal(zahlen1));

        System.out.println("\nZahl 2: " + zahlen2 + " zu Hexadezimal:");
        System.out.println(zuDezimal(zahlen2));

        System.out.println("\nZahl 3: " + zahlen3 + " zu Hexadezimal:");
        System.out.println(zuDezimal(zahlen3));
    }
}
