package blatt01;

public class Haendler {
    public static void main(String[] args) {
        //preise
        double preise_normale = 5.0;
        double preise_mini = 8.0;
        double preise_micro = 12.0;

        //anzahl
        int anzahl_normale = 9;
        int anzahl_mini = 5;
        int anzahl_micro = 0;

        //Berechnung
        double endpreise_normale = preise_normale*anzahl_normale;
        double endpreise_mini = preise_mini*anzahl_mini;
        double endpreise_micro = preise_micro*anzahl_micro;

        double endpreis = endpreise_normale+endpreise_mini+endpreise_micro;

        //Ausgabe
        System.out.println("Der Preis für...");
        System.out.println(anzahl_normale + " normale SD-Karten");
        System.out.println(anzahl_mini + " MiniSD-Karten");
        System.out.println(anzahl_micro + " MicroSD-Karten");
        System.out.println("...lautet " + endpreis + " €");

        /*
        Einfacher Fall: 10 variablen → 3 für preise, 3 für Anzahl, 3 für den Preis, und eine endsumme
        Mittelschwer: 3 Anzahl variablen. Danach berechnet man in einer langen Kette den Endpreis so:
        die Anzahl * Preis + Anzahl * Preis + Anzahl * Preis.
        Für die einzelnen Preise reicht Anzahl * Preis.
        Schwer: 0. Man legt es direkt in der Printausgabe fest: System.out.println(9 + " normale SD-Karten");
        System.out.println("...lautet " + ((9*5) + (5*8) + (0*0) + ".0 €"));
        */

        //double für den Preis, wobei man in dem Fall auch int verwenden könnten, da es keine cent Angaben
        //gibt, jedoch ist es eleganter bei Geldbeträgen double zu verwenden und int für die Anzahl, es gibt
        //nämlich keine halben Karten

        //Mein Programm funktioniert so gut, es gibt hier nichts zu befürchten und somit keine Probleme :)
        //theoretisch könnte es bei bestimmten Anzahlen zu langen Nachkommastellen kommen → Runden
    }
}
