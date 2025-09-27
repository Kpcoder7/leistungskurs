package blatt01;

public class Zinssatz {
    public static void main(String[] args) {
        //Initialisierung der Variablen
        double altes_Kapital = 1220.0;
        double zinssatz = 2.25;

        //Ausgabe der Zahlen, mit denen gerechnet wird
        System.out.printf("Altes Kapital: %.2f", altes_Kapital);
        System.out.print(" €\n");
        System.out.printf("Zinssatz: %.2f", zinssatz);
        System.out.print(" %\n\n");

        //Zinsberechnung
        double zinsen = altes_Kapital * zinssatz / 100;

        //Neues Kapital
        double neues_Kapital = altes_Kapital + zinsen;
        System.out.println("Zinsen: "+ zinsen + " €");
        System.out.println("Neues Kapital: " + neues_Kapital + " €");
    }
}
