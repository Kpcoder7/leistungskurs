package blatt08;

public class Kalender {
    /**
     * Übergabe eines Datums im Format TT.MM.JJJJ und Rückgabe des Tages
     * @param datum Datum als String, z.B. "24.12.2025"
     * @return Tag als ganze Zahl
     */
    public static int getTag(String datum) {
        String tagString = datum.substring(0, 2);
        return Integer.parseInt(tagString);
    }

    /**
     * Übergabe eines Datums im Format TT.MM.JJJJ und Rückgabe des Monats
     * @param datum Datum als String, z.B. "24.12.2025"
     * @return Monat als ganze Zahl
     */
    public static int getMonat(String datum) {
        String monatString = datum.substring(3, 5);
        return Integer.parseInt(monatString);
    }

    /**
     * Übergabe eines Datums im Format TT.MM.JJJJ und Rückgabe des Jahres
     * @param datum Datum als String, z.B. "24.12.2025"
     * @return Jahr als ganze Zahl
     */
    public static int getJahr(String datum) {
        String jahrString = datum.substring(6);
        return Integer.parseInt(jahrString);
    }

    /**
     * Überprüfung, ob ein Jahr ein Schaltjahr ist
     * @param jahr Jahr als ganze Zahl
     * @return true wenn Schaltjahr, sonst false
     */
    public static boolean istSchaltjahr(int jahr) {
        if (jahr % 400 == 0) {
            return true;
        } else if (jahr % 4 == 0 && jahr % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Übergabe von Tag, Monat und Jahr
     * Rückgabe im europäischen Format TT.MM.JJJJ
     * @param tag Tag
     * @param monat Monat
     * @param jahr Jahr
     * @return zusammengesetztes Datum als String
     */
    public static String zuDatum(int tag, int monat, int jahr) {
        // führende Nullen ergänzen
        String tagString = (tag < 10 ? "0" + tag : "" + tag);
        String monatString = (monat < 10 ? "0" + monat : "" + monat);
        return tagString + "." + monatString + "." + jahr;
    }

    /**
     * Berechnet das Datum des nächsten Tages
     * @param datum Datum im Format TT.MM.JJJJ
     * @return Datum des Folgetages im Format TT.MM.JJJJ
     */
    public static String naechsterTag(String datum) {
        int tag = getTag(datum);
        int monat = getMonat(datum);
        int jahr = getJahr(datum);

        // maximale Tage pro Monat bestimmen
        int tageImMonat;

        if (monat == 1 || monat == 3 || monat == 5 || monat == 7 || monat == 8 || monat == 10 || monat == 12) {
            tageImMonat = 31;
        } else if (monat == 4 || monat == 6 || monat == 9 || monat == 11) {
            tageImMonat = 30;
        } else {
            // Februar
            if (istSchaltjahr(jahr)) {
                tageImMonat = 29;
            } else {
                tageImMonat = 28;
            }
        }

        // Tag erhöhen
        tag++;

        // prüfen, ob der Monat weiterläuft
        if (tag > tageImMonat) {
            tag = 1;
            monat++;
        }

        // prüfen, ob das Jahr weiterläuft
        if (monat > 12) {
            monat = 1;
            jahr++;
        }

        return zuDatum(tag, monat, jahr);
    }

    public static void main(String[] args) {
        String datum1 = "28.02.2024";
        String datum2 = "31.12.2025";
        String datum3 = "30.04.2023";

        System.out.println("Datum: " + datum1);
        System.out.println("Nächster Tag: " + naechsterTag(datum1));

        System.out.println("\nDatum: " + datum2);
        System.out.println("Nächster Tag: " + naechsterTag(datum2));

        System.out.println("\nDatum: " + datum3);
        System.out.println("Nächster Tag: " + naechsterTag(datum3));

        System.out.println("\nIst 2024 ein Schaltjahr? " + istSchaltjahr(2024));
        System.out.println("Ist 2025 ein Schaltjahr? " + istSchaltjahr(2025));
    }
}