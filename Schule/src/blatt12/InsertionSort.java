package blatt12;

public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int einzusortierender_wert = arr[i];
            int j = 1;
            while (j>0 && arr[j-1] > einzusortierender_wert) {
                arr[j] = arr[j-1];
                j = j-1;
            }
        }
        return arr;
    }
    public static void main(String[] args) {

    }
}
