package blatt13;

public class QuadratApproximation {
    public static double flaecheQuadrat(double a) {
        return a*a;
    }

    public static double sucheSeitenlaenge(double a) {
        double seitenlaenge = 0;

        while (true) {
            seitenlaenge += 0.000001;
            if (Math.abs(flaecheQuadrat(seitenlaenge) - a) < 0.00001) {
                return seitenlaenge;
            }
        }
    }

    public static void main(String[] Args) {
        double seitenlaenge = 5;
        double flaeche = 72;
        System.out.println("Der Flächeninhalt des Quadrates mit der Seitenlänge von: " + seitenlaenge + ", beträgt: " + flaecheQuadrat(seitenlaenge) + ".");

        System.out.println(sucheSeitenlaenge(flaeche));
    }
}
