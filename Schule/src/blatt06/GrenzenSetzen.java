package blatt06;

import java.util.Scanner;

public class GrenzenSetzen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Geben Sie eine Obergrenze ein:");
        int o = input.nextInt();
        System.out.println("Geben Sie eine Untergrenze ein:");
        int u = input.nextInt();

        int[] zahlen = new int[o - u + 1];
        for (int i = 0; i < zahlen.length; i++) {
            zahlen[i] = i + u;
        }

        for (int i = 0; i < zahlen.length; i++) {
            System.out.print(zahlen[i] + " ");
        }

    }
}
