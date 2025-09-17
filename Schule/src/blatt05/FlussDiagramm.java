package blatt05;

import java.util.Scanner;

public class FlussDiagramm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Zahl 1:");
        int A = input.nextInt();

        System.out.println("Zahl 2:");
        int B = input.nextInt();

        int H = A;

        while (true) {
            if (A == B) {
                System.out.println(A);
                break;
            }
            else if (A > B) {
                A = A - B;
            }
            else {
                H = A;
                A = B;
                B = H;

                A = A - B;
            }

        }
    }
}
