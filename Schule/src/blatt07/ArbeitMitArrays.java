package blatt07;

public class ArbeitMitArrays {

    /**
     * Ausgabe eines Arrays in Form von [|]
     * @param zahlen zahlen Array
     */
    public static void printArray(int[] zahlen) {
        for (int i = 0; i < zahlen.length; i++) {
            if (i == 0) {
                System.out.print("[" + zahlen[0] + "|");
            } else if (i == zahlen.length - 1) {
                System.out.print(zahlen[zahlen.length-1] + "]");
            }
            else {
                System.out.print(zahlen[i] + "|");
            }
        }
    }

    /**
     * Übergabe eines double Arrays und anschließende Ausgabe nach [|] Format
     * @param doubleArray Array mit double Zahlen
     */
    public static void printArray(double[] doubleArray) {
        for (int i = 0; i < doubleArray.length; i++) {
            if (i == 0) {
                System.out.print("[" + doubleArray[0] + "|");
            } else if (i == doubleArray.length - 1) {
                System.out.print(doubleArray[doubleArray.length-1] + "]");
            }
            else {
                System.out.print(doubleArray[i] + "|");
            }
        }
    }

    /**
     * Übergabe eines boolean Arrays und anschließende Ausgabe nach [|] Format
     * @param booleanArray Array mit boolean Werten
     */
    public static void printArray(boolean[] booleanArray) {
        for (int i = 0; i < booleanArray.length; i++) {
            if (i == 0) {
                System.out.print("[" + booleanArray[0] + "|");
            } else if (i == booleanArray.length - 1) {
                System.out.print( booleanArray[booleanArray.length-1] + "]");
            }
            else {
                System.out.print(booleanArray[i] + "|");
            }
        }
    }

    /**
     * Übergabe eines char Arrays und anschließende Ausgabe nach [|] Format
     * @param charArray Array mit char Werten
     */
    public static void printArray(char[] charArray) {
        for (int i = 0; i < charArray.length; i++) {
            if (i == 0) {
                System.out.print("[" + charArray[0] + "|");
            } else if (i == charArray.length - 1) {
                System.out.print(charArray[charArray.length-1] + "]");
            }
            else {
                System.out.print(charArray[i] + "|");
            }
        }
    }

    /**
     * Übergabe eines string Arrays und anschließende Ausgabe nach [|] Format
     * @param stringArray Array mit Strings
     */
    public static void printArray(String[] stringArray) {
        for (int i = 0; i < stringArray.length; i++) {
            if (i == 0) {
                System.out.print("[" + stringArray[0] + "|");
            } else if (i == stringArray.length - 1) {
                System.out.print( stringArray[stringArray.length-1] + "]");
            }
            else {
                System.out.print(stringArray[i] + "|");
            }
        }
    }

    /**
     * Überprüfung, ob das Array sortiertArray nach < sortiert ist
     * @param sortiertArray Array welches int Zahlen hat, die sortiert oder unsortiert sind
     * @return zurück geben des Ergebnisses
     */
    public static boolean istSortiert(int[] sortiertArray) {
        boolean ergebnis = true;
        for (int i = 0; i < sortiertArray.length -1; i++) {
            if (sortiertArray[i] > sortiertArray[i+1]) {
                ergebnis = false;
            }
        }

        return ergebnis;
    }

    /**
     * Addierung der beiden Arrays arr1 und arr2, bei überschuss übernehmung der Werte, speicherung in err
     * @param arr1 Array 1 mit zahlen
     * @param arr2 Array 2 mit zahlen
     * @return zurückgabe des Ergebniss Arrays
     */
    public static int[] addieren(int[] arr1, int[] arr2) {
        if(arr1.length > arr2.length){
            int[] ergebnis = arr1;

            for(int i = 0; i < arr1.length; i++){
                ergebnis[i] = (arr1[i] + arr2[i]);
            }
            return ergebnis;
        }
        else {
            int[] ergebnis = arr2;

            for(int i = 0; i < arr2.length; i++){
                ergebnis[i] = (arr1[i] + arr2[i]);
            }
            return ergebnis;
        }
    }

    /**
     * Verschiebung aller Array Werte um eine Stelle nach links
     * @param arr1 Array mit Zahlen, welche verschoben werden
     */
    public static void shiftleft(int[] arr1) {
        int temp = arr1[0];
        for (int i = 0; i < arr1.length - 1; i++) {
            arr1[i] = arr1[i+1];
        }
        arr1[arr1.length-1] = temp;
        printArray(arr1);
    }

    /**
     * Verschiebung aller Array Werte um eine Stelle nach rechts
     * @param arr1 Array mit Zahlen, welche verschoben werden
     */
    public static void shiftRight(int[] arr1) {
        int temp = arr1[arr1.length-1];
        for (int i = 0; i > 0; i--) {
            arr1[i] = arr1[i+1];
        }
        arr1[arr1.length-1] = temp;
        printArray(arr1);
    }

    public static void main(String[] args) {
        int[] zahlen = new int[]{1, 31, 4, -6};


        double[] doubleArray = new double[]{2.0,5.6,8.3,6.5,9.1,7.7};
        boolean[] booleanArray = new boolean[]{true,true,true,false,true,false,false,true};
        char[] charArray = new char[]{'a','h','u','k','m'};
        String[] stringArray = new String[]{"apfel","hund","unten","kartoffel","manuellson"};


        //a
        printArray(zahlen);
        System.out.println();
        //b
        printArray(doubleArray);
        System.out.println();
        printArray(booleanArray);
        System.out.println();
        printArray(charArray);
        System.out.println();
        printArray(stringArray);


        //c
        int[] SortiertArray = new int[]{1,3,7,9,40,89};

        System.out.println();
        System.out.println("Ist das Array Sortiert?: " + istSortiert(SortiertArray));



        //d
        int[] arr1 = new int[]{1,-2,8,9,13,4}; //auch für e verwendet
        int[] arr2 = new int[]{0,9,-4,11,-1,6};

        printArray(addieren(arr1, arr2));


        //e
        System.out.println();
        printArray(arr1);
        System.out.println();
        shiftleft(arr1);
        System.out.println();
        shiftRight(arr1);

    }
}
