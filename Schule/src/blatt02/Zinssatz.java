package blatt02;

import java.util.Scanner;

public class Zinssatz {
    public static void main(String[] args) {

        Scanner scannerName = new Scanner(System.in);

        System.out.println("Bitte geben Sie Ihr Kapital ein: ");
        double altes_Kapital = scannerName.nextDouble();

        System.out.println("Bitte geben Sie Ihren Zinssatz ein: ");
        double zinssatz = scannerName.nextDouble();
        //Todo: negatives Kapital führt zu verzehrten Ergebnissen, sowie negative Zinsen

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
        //Todo: Einreichen -> Volle Punktzahl
    }
}
