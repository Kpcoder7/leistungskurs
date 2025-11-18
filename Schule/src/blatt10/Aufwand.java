package blatt10;

public class Aufwand {

    public static int zahlDerUmbrueche(char[] charr, int z, int b, int o, int sp) {
        int count = 0;
        sp += 32;
        z++;
        z++;
        sp += 32;
        for (int i = 0; i < charr.length-1; i++) {
            b++; o++; o++; z++;
            b++;
            if (charr[i] == '.') {
                b++; o++;
                if (charr[i+1] == ' ') {
                    count++;
                    o++; z++;
                }
            }
        }
        return count;
    }

    public static char[] umbrueche(String s, int z, int b, int o, int sp) {
        char[] charr = s.toCharArray();
        sp += charr.length * 16;
        z++;
        int c = zahlDerUmbrueche(charr, z, b, o, sp);
        sp += 32;
        z++;
        int k = 0;
        sp += 32;
        z++;
        char[] charr2 = new char[charr.length+c];
        sp += charr.length * 16;
        z++;
        o++;
        while (c > 0) {
            b++;
            z++; //i nur einmal auf 0
            sp += 32;
            for (int i = 0; i < charr.length-1; i++) {
                b++; o++; o++; z++;
                b++;
                if (charr[i] == '.') {
                    o++; b++;
                    if (charr[i+1] == ' ') {
                        charr2[i] = charr[i];
                        z++;
                        charr2[i+1] = '\n';
                        o++; z++;
                        k++;
                        o++;
                        z++;
                        c--;
                        o++;
                        z++;
                    } else {
                        charr2[i+k] = charr[i];
                        z++; o++;
                    }
                } else {
                    b++; b++; b++; o++;
                    if (charr[i] == ' ' && charr[i-1] == '.') {

                    } else {
                        charr2[i] = charr[i];
                        z++;
                    }
                }
            }
        }
        System.out.println("Z: " + z + " \nB: " + b + " \nO: " + o);
        return charr2;

    }

    public static void main(String[] args) {
        int z = 0;
        int b = 0;
        int o = 0;

        int sp = 0;

        String eingabe = "Nussecken (1 Blech). Teig: 300g Mehl, 1 TL Backpulver, 130g Zucker, 1 Pkg Vanillezucker, 2 EL Leinsamen, 6 EL Wasser, 130g Margarine/Butter. Belag: 200g Margarine/Butter, 6 EL Wasser, 200g Zucker, 1 Pkg Vanillezucker, 400g gemahlene Haselnüsse/Mandeln. Außerdem: Erdbeer-/Himbeermarmelade, 100g Zartbitterschokolade. Schritte: Die Leinsamen in 6 EL Wasser aufquellen lassen. Alle Zutaten für den Teig vermischen und zu einem relativ weichen Teig zerkneten, dann auf einem mit Backpapier ausgelegten Backbleck dünn drücken. Marmelade dünn auf dem Teig verteilen. Margarine, Wasser, Zucker und Vanillezucker in einem Topf schmelzen und kurz aufkochen lassen, dann Nüsse dazugeben und alles vermischen. Belag auf der Marmelade verteilen. Im vorgeheizten Backofen bei 180° C Ober/Unterhitze oder 160° C Umluft ca. 30 Minuten backen. Glasur erwärmen und mit einem Löffel über das Blech sprenkeln (so wird es gleichmäßiger und geht schneller als die Ecken in Schokolade zu tunken), abkühlen lassen. Zu Ecken schneiden.";
        sp += eingabe.length() * 16;
        z++;
        z++; // Für untendrunter
        char[] ausgabe = umbrueche(eingabe, z, b, o, sp);
        sp += ausgabe.length * 16;
        System.out.println(eingabe);
        System.out.println(ausgabe);

        System.out.println("Speicher: " + sp);
    }
}
/*
a)
Zwei Ausgaben: Einmal wird der String ganz normal ausgegeben. In der Ausgabekonsole erscheint dieser auch als ganz lange Zeile.
Die zweite Ausgabefunktion fügt Umbrüche hinzu. Nach jedem Punkt mit darauf folgendem Leerzeichen wird ein Umbruch eingefügt.
Kurzgesagt formatiert das Programm Strings um und fügt Umbrüche ein.
*/

// d) Programm ist stabil

// e) Worst-Case ist, wenn alle Schleifen, die es gibt, oft getriggert werden; Best-Case ist, wenn die Schleifen nur wenige
// bis gar keine Durchläufe haben. Also kurzgesagt: bei einem sehr kurzen Text Best-Case, bei sehr langem Text Worst-Case.