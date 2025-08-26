package blatt01;

public class Haendler {
    public static void main(String[] args) {
        //preise
        double preise_normale = 5.0;
        double preise_mini = 8.0;
        double preise_micro = 12.0;

        //anzahl
        int anzahl_normale = 4;
        int anzahl_mini = 2;
        int anzahl_micro = 0;

        //Berechnung
        double endpreise_normale = preise_normale*anzahl_normale;
        double endpreise_mini = preise_mini*anzahl_mini;
        double endpreise_micro = preise_micro*anzahl_micro;

        double endpreis = endpreise_normale+endpreise_mini+endpreise_micro;

        System.out.println("Der Preis für...");
        System.out.println(anzahl_normale + " normale SD Karten");
        System.out.println(anzahl_mini + " mini SD Karten");
        System.out.println(anzahl_micro + " microSD Karten");
        System.out.println("...lautet " + endpreis + " €");

        //minimal 10 variablen -> 3 für preise, 3 für Anzahl, 3 für den Preis, und eine endsumme, wenn man allerdings
        //sehr will, kann man durch kompliziertes coden noch einige wegstreichen

        //double für den Preis, wobei man in dem Fall auch int verwenden könnten, da es keine cent Angaben
        // gibt, jedoch ist es eleganter bei Geldbeträgen double zu verwenden und int für die Anzahl, es gibt
        //nämlich keine halben Karten

        //Mein Programm funktioniert so gut, es gibt hier nichts zu befürchten und somit keine Probleme :)
    }
}
