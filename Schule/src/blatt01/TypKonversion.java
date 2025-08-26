package blatt01;

public class TypKonversion {
    public static void main(String[] args) {
        int a = 14;
        double b = -21.25;

        int c = (int) b;
        double d = (double) a;

        System.out.println(c);
        System.out.println(d);

        char e = 'a';
        int f= 65;

        int g = (int) e;
        char h = (char)f;

        //boolean t = true;
        //h = (char) t;

        System.out.println(g);
        System.out.println(h);



        //Es wird -21 ausgegeben erwartet -21.25?
        //Es wird 14.0 ausgegeben erwartet 14?
        //Es wird 97 ausgegeben erwartet e?
        //Es wird A ausgegeben erwartet 65?

        //ich vermute, dass an dieser stelle der Wert von double in ein Int konvertiert wird und Int in double, sodass
        //die kommazahlen gestrichen werden an der einen Stelle und an der anderen welche hinzugefügt werden
        //unten ist es das gleiche (17,18), nur dass es an dieser Stelle mit Zahlenwert zu Buchstabe (char) passiert,
        //sowie Buchstabe (char) zu Zahlenwert. Konvertierung an der Stelle nach ASCII Tabelle

        //Aufgabenstellung nicht ganz klar... Beide speichern einen Zahlenwert?

        //Aufgabenstellung nicht ganz klar... ASCII Tabelle? Zahl 65 = A innerhalb der Tabelle? e = 97 innerhalb der Tabelle?
        //Art übersetzung von Zahl zu Buchstabe und Buchstabe zu Zahl

        //Inconvertible types; cannot cast 'boolean' to 'char'? Funktioniert nicht

    }
}
