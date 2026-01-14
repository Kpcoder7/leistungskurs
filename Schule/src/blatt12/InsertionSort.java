package blatt12;

import java.util.Arrays;

public class InsertionSort {
    public static int[] insertionSortInPlace(int[] arr) {
        return arr;
    }

    /**
     * Sortieralgorithmus nach dem Prinzip der Suche eines Elementes und verschiebung nach rechts,
     * solange bis es nicht mehr größer ist als das rechte Element von ihm
     * @param arr zu sortierender Array
     * @return
     */
    public static int[] insertionSort(int[] arr) {
        int[] arr2 = arr.clone();
        for (int i = 1; i < arr.length; i++) {
            int einzusortierender_wert = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] > einzusortierender_wert) {
                arr2[j] = arr2[j-1];
                j = j-1;
            }
            arr2[j] = einzusortierender_wert;
        }
        return arr2;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 10, 8, 1, 3, 4};
        int[] arr2 = insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));


    }
}
