package blatt13;

public class Umgebung {
    public static int findeExponent(double basis, double grenze) {
        int exponent = 0;
        while (true) {
            if (Math.pow(basis, exponent) <= grenze) {
                return exponent;
            }
            else {
                exponent++;
            }
        }

    }
    public static void main(String[] args) {
        double basis = 0.5;

        //Grenzprüfung ob 0 < b < 1 ist
        if (basis > 1) {
            System.out.println("Basis muss zwischen 0 und 1 liegen");
        } else if (basis < 0) {
            System.out.println("Basis muss zwischen 0 und 1 liegen");
        }
        else {
            System.out.println(findeExponent(basis, 0.001));
        }
    }
}
