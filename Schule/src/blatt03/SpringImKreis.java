package blatt03;

import java.util.Scanner;

public class SpringImKreis {
    public static void main(String[] args) {
        Scanner scannerName = new Scanner(System.in);

        double kreisRadius = 7;

        System.out.println("Nennen Sie eine beliebige x-Koordinate");
        double xKoordinate = scannerName.nextDouble();

        System.out.println("Nennen Sie eine beliebige y-Koordinate");
        double yKoordinate = scannerName.nextDouble();

        double koordinateNachP = xKoordinate * xKoordinate + yKoordinate * yKoordinate;
        double radius = Math.sqrt(koordinateNachP);

        //Pythagoras Berechnung
        if (radius <= kreisRadius) {
            System.out.println("Der Punkt liegt im Kreis");
        }
        else if (radius == kreisRadius) {
            System.out.println("Der Punkt liegt auf dem Kreisrand");
        }
        else {
            System.out.println("Der Punkt liegt nicht im Kreis");
        }
    }
}