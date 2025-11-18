package blatt10;

import java.util.Arrays;

public class DNA {
    /**
     * Prüft, ob ein gegebener String nur gültige Nukleotide (A, T, G, C) enthält.
     *
     * @param s DNA-Sequenz als String
     * @return true, wenn nur A, T, G, C enthalten sind, sonst false
     */
    public static boolean istDNA(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != 'A' && c != 'T' && c != 'G' && c != 'C') {
                return false;
            }
        }
        return true;
    }

    /**
     * Wandelt einen DNA-String in ein byte-Array um.
     * A=0, T=1, G=2, C=3
     *
     * @param s DNA-Sequenz als String
     * @return byte-Array mit numerischer Darstellung
     */
    public static byte[] zuDNA(String s) {
        byte[] arr = new byte[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') arr[i] = 0;
            else if (c == 'T') arr[i] = 1;
            else if (c == 'G') arr[i] = 2;
            else if (c == 'C') arr[i] = 3;
        }
        return arr;
    }

    /**
     * Wandelt ein byte-Array wieder in einen DNA-String um.
     *
     * @param arr byte-Array mit numerischer Darstellung
     * @return DNA-Sequenz als String
     */
    public static String zuDNA(byte[] arr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : arr) {
            if (b == 0) sb.append('A');
            else if (b == 1) sb.append('T');
            else if (b == 2) sb.append('G');
            else if (b == 3) sb.append('C');
        }
        return sb.toString();
    }

    /**
     * Wandelt einen DNA-String in ein boolean-Array um.
     * Jede Base = 2 Bits:
     * A=00, T=01, G=10, C=11
     *
     * @param s DNA-Sequenz als String
     * @return boolean-Array mit binärer Darstellung
     */
    public static boolean[] zuDNA_Bool(String s) {
        boolean[] arr = new boolean[s.length() * 2];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') { arr[2*i] = false; arr[2*i+1] = false; }
            else if (c == 'T') { arr[2*i] = false; arr[2*i+1] = true; }
            else if (c == 'G') { arr[2*i] = true;  arr[2*i+1] = false; }
            else if (c == 'C') { arr[2*i] = true;  arr[2*i+1] = true; }
        }
        return arr;
    }

    /**
     * Wandelt ein boolean-Array wieder in einen DNA-String um.
     *
     * @param arr boolean-Array mit binärer Darstellung
     * @return DNA-Sequenz als String
     */
    public static String zuDNA_Bool(boolean[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i += 2) {
            if (!arr[i] && !arr[i+1]) sb.append('A');
            else if (!arr[i] && arr[i+1]) sb.append('T');
            else if (arr[i] && !arr[i+1]) sb.append('G');
            else sb.append('C');
        }
        return sb.toString();
    }

    /**
     * Wandelt einen DNA-String in ein byte-Array um (4 Nukleotide pro Byte, effizient).
     *
     * @param s DNA-Sequenz als String
     * @return byte-Array mit komprimierter Darstellung
     */
    public static byte[] zuDNA_effizient(String s) {
        int n = (s.length() + 3) / 4; // Aufrunden auf volle Bytes
        byte[] arr = new byte[n];
        for (int i = 0; i < s.length(); i++) {
            byte val = 0;
            char c = s.charAt(i);
            if (c == 'A') val = 0;
            else if (c == 'T') val = 1;
            else if (c == 'G') val = 2;
            else if (c == 'C') val = 3;
            arr[i / 4] |= val << ((i % 4) * 2);
        }
        return arr;
    }

    /**
     * Wandelt ein komprimiertes byte-Array wieder in einen DNA-String um.
     *
     * @param arr byte-Array mit komprimierter Darstellung
     * @param originalLength ursprüngliche Länge der DNA-Sequenz
     * @return DNA-Sequenz als String
     */
    public static String zuDNA_effizient(byte[] arr, int originalLength) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < originalLength; i++) {
            int val = (arr[i / 4] >> ((i % 4) * 2)) & 0b11;
            if (val == 0) sb.append('A');
            else if (val == 1) sb.append('T');
            else if (val == 2) sb.append('G');
            else if (val == 3) sb.append('C');
        }
        return sb.toString();
    }

    /** Testfunktionen */
    public static void main(String[] args) {
        String dna = "ATGCAGCT";
        System.out.println("istDNA: " + istDNA(dna));

        byte[] b = zuDNA(dna);
        System.out.println("zuDNA -> byte: " + Arrays.toString(b));
        System.out.println("byte -> String: " + zuDNA(b));

        boolean[] boolArr = zuDNA_Bool(dna);
        System.out.println("zuDNA_Bool -> boolean: " + Arrays.toString(boolArr));
        System.out.println("boolean -> String: " + zuDNA_Bool(boolArr));

        byte[] bEff = zuDNA_effizient(dna);
        System.out.println("zuDNA_effizient -> byte: " + Arrays.toString(bEff));
        System.out.println("byte effizient -> String: " + zuDNA_effizient(bEff, dna.length()));
    }
    /*
     a) Erklärung byte:
     Ein byte hat 8 Bit → 2^8 = 256 Werte.
     Wertebereich: -128 bis 127, da Java Zweierkomplement verwendet.
     */
}