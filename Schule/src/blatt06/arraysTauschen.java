package blatt06;

public class arraysTauschen {
    public static void main(String[] args) {
        int[] auftraege = new int[]{9000, 23000, 41000, 6000, 13000, 22000, 38000, 16000, 7000, 14000, 12000, 5000, 17000};
        System.out.println("Der Gesamtbetrag aller Aufträge beträgt: " + (auftraege[0] + auftraege[1] + auftraege[2] + auftraege[3] + auftraege[4] + auftraege[5] + auftraege[6] + auftraege[7] + auftraege[8] + auftraege[9] + auftraege[10] + auftraege[11] + auftraege[12]) + " €");
        System.out.println("Folgende Aufträge betragen mehr als 15000 €:");

        for (int i = 0; i < auftraege.length; i++) {
            int x = 0;
            int y = 0;

            int speicherX = auftraege[x];
            int speicherY = auftraege[y];


            auftraege[x] = 0;
            auftraege[y] = 0;
        }


        for (int i = 0; i < auftraege.length; i++) {
            if (auftraege[i] >= 15000) {
                System.out.println(auftraege[i]);
            }
        }
    }
}
