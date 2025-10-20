package blatt08;

public class Klammernsprache {
    public static boolean istKlammerwort(String folge) {
        int zaehler = 0;
        for (int i = 0; i < folge.length(); i++) {
            char zeichen = folge.charAt(i);

            if (zeichen == '(') {
                zaehler++;
            }
            if (zeichen == ')') {
                zaehler--;
            }
            if (zaehler < 0) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String klammerwort = "())()(())";
        boolean ergebnis = istKlammerwort(klammerwort);
        if (ergebnis) {
            System.out.println(klammerwort + " ist ein Klammerwort");
        }
        else {
            System.out.println(klammerwort + " ist kein Klammerwort");
        }
    }
}
