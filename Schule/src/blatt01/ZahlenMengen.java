package blatt01;

public class ZahlenMengen {
    public static void main(String[] args) {
        int a = 5;
        double b = 5.0;

        a = a / 2;
        b = b / 2;

        System.out.println(a);
        System.out.println(b);

        // Bei a kommt 2 raus, bei b kommt 2.5 raus
        // Grund: Int (a) hat keine Option Nachkommazahlen anzuzeigen, double (b) schon
    }
}
