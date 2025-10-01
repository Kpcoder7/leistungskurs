package blatt07;

public class Rechner {
    /**
     * Berechnung und direkte Ausgabe von Summe, Differenz, Produkt, Quotient
     * @param a
     * @param b
     */
    public static void operation(double a, double b) {

        System.out.println("Addition: " + (a+b));

        if (a-b < 0) {
            System.out.println("Differenz: " + ((a-b)*-1));;
        }
        else {
            System.out.println("Differenz: " + (a-b));
        }

        System.out.println("Produkt: " + (a*b));

        System.out.println("Quotient: " + (a/b));
    }

    /**
     * Funktionen für Additon, Differenz, Produkt, Quotient von double a und double b
     * @param a
     * @param b
     * @return
     */
    public static double add(double a, double b) {
        return a+b;
    }
    public static double sub(double a, double b) {
        return a-b;
    }
    public static double mult(double a, double b) {
        return a*b;
    }
    public static double div(double a, double b) {
        return a/b;
    }

    public static void main(String[] args) {
        operation(7.0, 3.0);

        double a = 7.0;
        double b = 3.0;

        System.out.println();
        System.out.println("Addition: " + add(a, b));
        System.out.println("Differenz: " + sub(a, b));
        System.out.println("Produkt: " + mult(a, b));
        System.out.println("Quotient: " + div(a, b));
    }
}
