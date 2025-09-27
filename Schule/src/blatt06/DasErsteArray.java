package blatt06;

public class DasErsteArray {
    public static void main(String[] args) {
        int[] zahlen = new int[990];

        for (int i = 0; i < zahlen.length; i++) {
            int zahl = i + 10;
            zahlen[i] = zahl;
        }

        for (int i = 0; i < zahlen.length; i++) {
            System.out.print(zahlen[i] + " ");
        }
        System.out.println();
        for (int i = 989; i >= 0; i--) {
            System.out.print(zahlen[i] + " ");
        }
    }
}
