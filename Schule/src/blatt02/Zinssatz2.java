package blatt02;

import java.util.Scanner;
import blatt01.Zinssatz;

public class Zinssatz2 {
    public static void main(String[] args) {

        Scanner scannerName = new Scanner(System.in);
        Zinssatz zinssatzNeu = new Zinssatz();

        System.out.println("Bitte geben sie Ihr Kapital ein: ");
        double altes_Kapital = scannerName.nextDouble();

        System.out.println("Bitte geben sie Ihren Zinssatz ein: ");
        double zinssatz = scannerName.nextDouble();


    }
}
