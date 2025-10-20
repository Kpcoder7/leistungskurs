package blatt07;

public class Stein {
    /**
     * Nutzung des Stein Algorithmus um den ggT von a und b zu ermitteln
     * @param a int Zahl
     * @param b int Zahl
     * @return rückgabe, des ggT
     */
    public static int steinGGT (int a, int b) {
        int k = 0;

        //falls eine Zahl 0 ist
        if (a == 0) return b;
        if (b == 0) return a;

        while (a != 0 && b != 0) {
            //wenn beide Zahlen gerade sind
            if (a % 2 == 0 && b % 2 == 0) {
                a /= 2;
                b /= 2;
                k++;
            }

            //wenn nur eine Zahl gerade ist
            else if (a % 2 == 0) {
                a /= 2;
            }
            else if (b % 2 == 0) {
                b /= 2;
            }

            //wenn keine der beiden Zahlen gerade ist
            else {
                if (a >= b) {
                    a = (a - b) / 2;
                }
                else {
                    b = (b - a) / 2;
                }
            }
        }

        //rückgabe
        int result;
        if (a == 0)
            result = b;
        else
            result = a;

        return result * (int)Math.pow(2, k);
    }

    public static void main(String[] args) {
        int a = 36;
        int b = 20;

        System.out.println("Das ggT von " + a + " und " + b + " ist " + steinGGT(a, b) + ".");
    }
}
