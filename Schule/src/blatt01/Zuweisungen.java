package blatt01;

public class Zuweisungen {
    public static void main(String[] args) {
        int a = 7;
        int b = 7;

        a = a + 3;
        a = a * 4;
        a = a - 8;
        a = a / 2;
        a = a - b * 2;
        System.out.println(a);

        // 5 Rechenoperatoren
        // Es ist stets 2, da es jedes mal durch das zusammenspiel von Multiplikation, Divison, Addition und Subtraktion
        // auf einen Wert um 2 höher als das doppelte vom ursprünglichen Wert gebracht wird und dann um das doppelte des
        // ursprungswertes abgezogen wird.
    }
}
