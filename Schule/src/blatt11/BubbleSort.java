package blatt11;

import java.util.Arrays;

public class BubbleSort {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        //array
        int[] arr = new int[] {4, 2, 3, 4, 4, 6, 9, 2, 8, 0};

        //Stellen zum tauschen
        int a = 0;
        int b = 1;

        //swap(arr, a, b);
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        if(blatt07.ArbeitMitArrays.istSortiert(arr)){
            System.out.println("Sortiert");
        }
        else{
            System.out.println("Nicht Sortiert!");
        }
    }

    //O: N^2

    //Wenn man wirklich weiß, dass zwei Elemente im Array direkt nebeneinander sind,
    //welche man direkt tauschen kann, dann macht es tatsächlich Sinn. Sonst nicht.
}
