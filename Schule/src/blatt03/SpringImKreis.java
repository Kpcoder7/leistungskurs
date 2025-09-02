package blatt03;

import java.util.Scanner;

public class SpringImKreis {
    public static void main(String[] args) {
        Scanner scannerName = new Scanner(System.in);

        double kreisRadius = 100;

        System.out.println("Nenne mir eine beliebige x-Koordinate");
        double xKoordinate = scannerName.nextDouble();

        System.out.println("Nenne mir eine beliebige y-Koordinate");
        double yKoordinate = scannerName.nextDouble();

        double koordinateNachP = xKoordinate * xKoordinate + yKoordinate * yKoordinate;

        //Pythagoras Berechnung
        if (koordinateNachP <= kreisRadius) {
            System.out.println("Es ist im Kreis");
        }
        else if (koordinateNachP == kreisRadius) {
            System.out.println("Es auf dem Kreisrand");
        }
        else {
            System.out.println("Es ist nicht im Kreis");
        }


    }
}
