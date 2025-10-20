package blatt07;

public class Rechner {
    /**
     * Berechnung und direkte Ausgabe von Summe, Differenz, Produkt, Quotient
     * @param a Zahl 1
     * @param b Zahl 2
     */
    public static void operation(double a, double b) {
        System.out.println("Addition: " + add(a,b));
        System.out.println("Subtraktion: " + sub(a,b));
        System.out.println("Multiplikation: " + mult(a,b));
        System.out.println("Division: " + div(a,b));
    }

    /**
     * Funktion für Additon von double a und double b
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Rückgabe der Additon von a und b
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * Funktion für Subtraktion von double a und double b
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Rückgabe der Subtraktion von a und b
     */
    public static double sub(double a, double b) {
        return a - b;
    }

    /**
     * Funktion für Multiplikation von double a und double b
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Rückgabe der Multiplikation von a und b
     */
    public static double mult(double a, double b) {
        return a * b;
    }

    /**
     * Funktion für Division von double a und double b
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Rückgabe der Division von a und b
     */
    public static double div(double a, double b) {
        if (b == 0) {
            System.out.println("Fehler: Division durch 0 nicht definiert!");
            return Double.NaN;
        }
        return a / b;
    }

    public static void main(String[] args) {
        //Triggern der Methode operation mit den Werten a und b
        operation(7.0, 289.0);
    }
}
