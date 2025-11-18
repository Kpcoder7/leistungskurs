package blatt11;

import java.util.Arrays;

public class BubbleSort {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
        System.out.println(Arrays.toString(arr));
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
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

        swap(arr, a, b);
        bubbleSort(arr);
    }
}
