package blatt12;

import blatt11.BubbleSort;

import java.util.Arrays;

public class SelectionSort {
    /**
     * Sortieralgorithmus nach dem Prinzip der Suche des kleinsten/größten
     * Element und platzierung an der zugehörigen Grenze
     * @param arr zu sortierendes Array
     * @param bMax boolean Wert, der bestimmt, ob nach min oder max sortiert wird
     * @return
     */
    public static int[] selectionSort(int[] arr, boolean bMax) {
        if (bMax) {
            for (int i = 0; i < arr.length - 1; i++) {
                int max = arr.length-1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > arr[max]) {
                        max = j;
                    }
                }
                BubbleSort.swap(arr, i, max);
            }
            return arr;
        }
        else {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            BubbleSort.swap(arr, i, min);
        }
        return arr;
        }
    }

    public static void main(String[] args) {
        boolean max = false;
        int[] arr = new int[] {1,3,4,2,8,47,2,63,1,9,2};
        int[] arr2 = selectionSort(arr, max);
        System.out.println("Sortierter Array: " + Arrays.toString(arr2));
    }
}
