package blatt07;

public class ArbeitMitArrays {

    /**
     * Ausgabe eines Arrays in Form von [ | | ]
     * @param zahlen zahlen Array
     */
    public static void printArray(int[] zahlen) {
        System.out.print("[ ");
        for (int i = 0; i < zahlen.length; i++) {
            System.out.print(zahlen[i]);
            if (i < zahlen.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.print(" ]");
    }

    /**
     * Übergabe eines double Arrays und anschließende Ausgabe nach [ | | ] Format
     * @param doubleArray Array mit double Zahlen
     */
    public static void printArray(double[] doubleArray) {
        System.out.print("[ ");
        for (int i = 0; i < doubleArray.length; i++) {
            System.out.print(doubleArray[i]);
            if (i < doubleArray.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.print(" ]");
    }

    /**
     * Übergabe eines boolean Arrays und anschließende Ausgabe nach [ | | ] Format
     * @param booleanArray Array mit boolean Werten
     */
    public static void printArray(boolean[] booleanArray) {
        System.out.print("[ ");
        for (int i = 0; i < booleanArray.length; i++) {
            System.out.print(booleanArray[i]);
            if (i < booleanArray.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.print(" ]");
    }

    /**
     * Übergabe eines char Arrays und anschließende Ausgabe nach [ | | ] Format
     * @param charArray Array mit char Werten
     */
    public static void printArray(char[] charArray) {
        System.out.print("[ ");
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]);
            if (i < charArray.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.print(" ]");
    }

    /**
     * Übergabe eines string Arrays und anschließende Ausgabe nach [ | | ] Format
     * @param stringArray Array mit Strings
     */
    public static void printArray(String[] stringArray) {
        System.out.print("[ ");
        for (int i = 0; i < stringArray.length; i++) {
            System.out.print(stringArray[i]);
            if (i < stringArray.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.print(" ]");
    }

    /**
     * Überprüfung, ob das Array sortiert ist (aufsteigend)
     * @param sortiertArray Array mit int Zahlen
     * @return true wenn sortiert, false wenn unsortiert
     */
    public static boolean istSortiert(int[] sortiertArray) {
        boolean ergebnis = true;
        for (int i = 0; i < sortiertArray.length - 1; i++) {
            if (sortiertArray[i] > sortiertArray[i + 1]) {
                ergebnis = false;
            }
        }
        return ergebnis;
    }

    /**
     * Addierung der beiden Arrays arr1 und arr2
     * Bei unterschiedlichen Längen wird bis zur kürzeren Länge addiert,
     * die übrigen Werte werden übernommen
     * @param arr1 Array 1
     * @param arr2 Array 2
     * @return neues Ergebnisarray
     */
    public static int[] addieren(int[] arr1, int[] arr2) {
        int laenge = Math.max(arr1.length, arr2.length);
        int[] ergebnis = new int[laenge];

        for (int i = 0; i < laenge; i++) {
            int wert1 = (i < arr1.length) ? arr1[i] : 0;
            int wert2 = (i < arr2.length) ? arr2[i] : 0;
            ergebnis[i] = wert1 + wert2;
        }

        return ergebnis;
    }

    /**
     * Verschiebung aller Array Werte um eine Stelle nach links
     * Das erste Element wird hinten wieder eingefügt
     * @param arr1 Array mit Zahlen
     */
    public static void shiftLeft(int[] arr1) {
        int temp = arr1[0];
        for (int i = 0; i < arr1.length - 1; i++) {
            arr1[i] = arr1[i + 1];
        }
        arr1[arr1.length - 1] = temp;
        printArray(arr1);
    }

    /**
     * Verschiebung aller Array Werte um eine Stelle nach rechts
     * Das letzte Element wird vorne wieder eingefügt
     * @param arr1 Array mit Zahlen
     */
    public static void shiftRight(int[] arr1) {
        int temp = arr1[arr1.length - 1];
        for (int i = arr1.length - 1; i > 0; i--) {
            arr1[i] = arr1[i - 1];
        }
        arr1[0] = temp;
        printArray(arr1);
    }

    /**
     * Verschiebung um eine Stelle nach links
     * herausgeschobenes Element wird durch 0 ersetzt
     * @param arr Array mit Zahlen
     */
    public static void shiftLeftAbsolute(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
        printArray(arr);
    }

    /**
     * Verschiebung um eine Stelle nach rechts
     * herausgeschobenes Element wird durch 0 ersetzt
     * @param arr Array mit Zahlen
     */
    public static void shiftRightAbsolute(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = 0;
        printArray(arr);
    }

    public static void main(String[] args) {
        int[] zahlen = new int[]{1, 31, 4, -6};
        double[] doubleArray = new double[]{2.0, 5.6, 8.3, 6.5, 9.1, 7.7};
        boolean[] booleanArray = new boolean[]{true, true, true, false, true, false, false, true};
        char[] charArray = new char[]{'a', 'h', 'u', 'k', 'm'};
        String[] stringArray = new String[]{"apfel", "hund", "unten", "kartoffel", "manuellson"};

        // a
        System.out.println("Aufgabe a:");
        printArray(zahlen);
        System.out.println();

        // b
        System.out.println("\nAufgabe b:");
        printArray(doubleArray);
        System.out.println();
        printArray(booleanArray);
        System.out.println();
        printArray(charArray);
        System.out.println();
        printArray(stringArray);

        // c
        System.out.println("\n\nAufgabe c:");
        int[] SortiertArray = new int[]{1, 3, 7, 9, 40, 89};
        System.out.println("Ist das Array sortiert?: " + istSortiert(SortiertArray));

        // d
        System.out.println("\nAufgabe d:");
        int[] arr1 = new int[]{1, -2, 8, 9, 13, 4}; // auch für e verwendet
        int[] arr2 = new int[]{0, 9, -4, 11, -1, 6};
        printArray(addieren(arr1, arr2));

        // e
        System.out.println("\n\nAufgabe e:");
        printArray(arr1);
        System.out.println();
        shiftLeft(arr1);
        System.out.println();
        shiftRight(arr1);

        // f
        System.out.println("\n\nAufgabe f:");
        int[] arr3 = new int[]{4, 9, 7, 2, 6};
        printArray(arr3);
        System.out.println();
        shiftLeftAbsolute(arr3);
        System.out.println();
        shiftRightAbsolute(arr3);
    }
}
