package blatt08;

import java.util.Arrays;

public class Palindrom {
    public static int[] umdrehen (int[] zeichenfolge) {
        int[] umgedreht = new int[zeichenfolge.length];

        for (int i = 0; i < zeichenfolge.length; i++) {
            umgedreht[i] = zeichenfolge[zeichenfolge.length - i - 1];
        }

        return umgedreht;
    }

    public static boolean istPalindrom (int[] zeichenfolge, int[] umgedreht) {
        boolean ergebnis = true;

        for (int i = 0; i < umgedreht.length; i++) {
            if (umgedreht[i] != zeichenfolge[i]) {
                ergebnis = false;
            }
        }

        return ergebnis;
    }

    public static void main(String[] args) {
        int[] zeichenfolge = new int []{1,4,3,4,2,4,3,4,1};


        int[] umgedreht = umdrehen(zeichenfolge);
        boolean ergebnis = istPalindrom(zeichenfolge, umgedreht);
        if (ergebnis ==  true) {
            System.out.println("Die Zeichenfolge " + Arrays.toString(zeichenfolge) + " ist ein Palindrom");
        }
        else {
            System.out.println("Die Zeichenfolge " + Arrays.toString(zeichenfolge) + " ist kein Palindrom");
        }
    }
}
