package blatt05;

import java.util.Scanner;

public class Bowling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int frame = 1;
        int wuerfe = 0;
        int punkte = 0;
        int multiplikator1 = 1;
        int multiplikator2 = 1;

        while (frame <= 10) {
            System.out.println("Wie viele Pins wurde umgeworfen?");
            int uPin = input.nextInt();
            if (uPin == 10) {
                System.out.println("STRIKE!!!");
                multiplikator1++;
            }
            else {
                System.out.println("Wie viele Pins hast du beim zweiten Wurf umgeworfen?");
                uPin = uPin + input.nextInt();
                if (uPin == 10) {
                    System.out.println("SPARE");
                    if (multiplikator2 > 1) {
                        uPin *= multiplikator2;
                    }
                    multiplikator2++;
                }
            }
            if (multiplikator1 > 1) {
                uPin *= multiplikator1;
            }

            frame++;
        }
    }
}
