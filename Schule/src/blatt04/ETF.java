package blatt04;

import java.util.Random;

public class ETF {
    public static void main(String[] args) {

        Random rnd = new Random();

        double sparbetrag = 0.0;
        double einzahlung = 50;
        double gesamtBetrag = 0.0;
        double wertsteigerung = 1.0;
        double wert = 3578.89;
        double anteil = 0.0;

        int monat = 0;
        int Jahr = 0;

        while (Jahr < 4) {
            Jahr += 1;
            if (Jahr == 1) {
                einzahlung = 50;
            }
            else if (Jahr == 2) {
                einzahlung = 70;
            }
            else if (Jahr == 3) {
                einzahlung = 90;
            }

            while (monat < 12) {
                monat += 1;
                
                sparbetrag += einzahlung;
                anteil = sparbetrag / wert;
                gesamtBetrag += wert * anteil;


                double zinssatz = rnd.nextDouble();
                zinssatz = 6 * (zinssatz + 1);
                zinssatz = zinssatz * 0.01;
                wertsteigerung = wertsteigerung + zinssatz;

                wert = wert * wertsteigerung;

                System.out.println("Wertsteigerung: " + wertsteigerung);
                System.out.println("Monat: " + monat);
                System.out.println("Sparbetrag: " + sparbetrag);
                System.out.println("Anteil: " + anteil);
                System.out.println("gesamtBetrag: " + gesamtBetrag);
                System.out.println("Wert: " + wert);
                System.out.println();

            }
        }


    }
}
