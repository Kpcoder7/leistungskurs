package blatt13;

import java.util.Arrays;

public class Zufall {
    /**
     * Zufällige Gleitkommazahl zwischen 0 und b
     * @param b grenzwert zwischen dem die Zahl fällt
     * @return rückgabe des Zufallwertes
     */
    public static double zufall(int b) {
        double zufallsZahl = Math.random() * b;

        return zufallsZahl;
    }

    /**
     * Zufällige Gleitkommazahl zwischen a und b
     * @param a Grenzwert links
     * @param b Grenzwert rechts
     * @return rückgabe des Zufallwertes
     */
    public static double zufall(int a, int b) {
        b -= a;
        double zufallsZahl = (Math.random() * b) + a;
        return zufallsZahl;
    }

    /**
     * Zufällige Integer Zahl zwischen 0 und b
     * @param b grenze zwischen dem die Zahl fällt
     * @return rückgabe des Zufallwertes
     */
    public static int zufallGanz(int b) {
        double zufallsZahl = Math.random() * b;
        return (int) zufallsZahl;
    }

    /**
     * Zufällige Integer Zahl zwischen a und b
     * @param b Grenzwert links
     * @param a Grenzwert rechts
     * @return rückgabe des Zufallwertes
     */
    public static int zufallGanz(int b, int a) {
        b -= a;
        double zufallsZahl = (Math.random() * b) + a;
        return (int) zufallsZahl;
    }

    /**
     * Zufälliges Int Array der Länge l und grenzen
     * @param l Längenangabe des Arrays
     * @param a Grenzwert links
     * @param b Grenzwert rechts
     * @return Rückgabe des Int Arrays
     */
    public static int[] zufallArray(int l, int a, int b) {
        int[] zufallArray = new int[l];
        for (int i = 0; i <= l-1; i++) {
            zufallArray[i] = zufallGanz(a,b);
        }
        return zufallArray;
    }

    public static void main(String[] Args) {
        int grenze = 7;
        grenze += 1; //Kleiner Fix, dass die 7 doch fällt ;)
        int grenzeLinks = 3;
        int laenge = 20;
        System.out.println("0-b double:" + zufall(grenze));

        System.out.println("a-b double:" + zufall(grenze, grenzeLinks));


        System.out.println("0-b int:" + zufallGanz(grenze));

        System.out.println("a-b int:" + zufallGanz(grenze, grenzeLinks));

        System.out.println("ZufallsArray a-b länge l:" + Arrays.toString(zufallArray(laenge, grenze, grenzeLinks)));
    }
}
