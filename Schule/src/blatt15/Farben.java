package blatt15;

import schisch_visualizer. *;
import java.util.List;
import java.util.ArrayList;

public class Farben {

    //Globale Variablen
    static char[][] spielfeld;
    static int[] spielerPosX = new int[8];
    static int[] spielerPosY  = new int[8];
    static int[] reihenfolge;

    static int laenge = 40;
    static int breite = 40;

    static int[][] teamHeatmap = new int[laenge][breite];
    static boolean flaechePushen = true;
    static boolean gegnerJagen = false;
    static boolean search = false;

    static int searchCount = 0;
    static int gegegnerJagenCount = 0;
    static int flaechePushenCount = 0;


    //Standard logik
    /**
     * Erstellung eines Spielfelds mit längen und breiten Angaben
     * @param l Int variable für die Länge des Spielfelds
     * @param b Int variable für die Breite des Spielfelds
     */
    public static void initialisiereSpielfeld(int l, int b) {
        spielfeld = new char[l][b];
        for (int i = 0; i < l; i++) {
            spielfeld[i][b-1] = '8';
            spielfeld[i][0] = '8';
        }
        for (int i = 0; i < b; i++) {
            spielfeld[0][i] = '8';
            spielfeld[l-1][i] = '8';
        }
        startPosition(b,l);
    }

    /**
     * Random spawn Punkte von jeweils 4 Spielern in 2 Teams aufgeteilt auf zwei hälften des Feldes rechts und links aus der Mitte
     * @param b Int variable für die Länge des Spielfelds
     * @param l Int variable für die Breite des Spielfelds
     */
    public static void startPosition(int b, int l) {
        for (int i = 0; i < 4; i++) {
            int x = blatt13.Zufall.zufallGanz(l/2, 1);
            int y = blatt13.Zufall.zufallGanz(b-2, 1);
            spielfeld[x][y] = 'P';
            spielerPosX[i] = x;
            spielerPosY[i] = y;
        }

        for (int i = 0; i < 4; i++) {
            int x = blatt13.Zufall.zufallGanz(l-2, l/2);
            int y = blatt13.Zufall.zufallGanz(b-2, 1);
            if (spielfeld[x][y] == 0) {
                spielfeld[x][y] = 'O';

                spielerPosX[i+4] = x;
                spielerPosY[i+4] = y;
            }
            else if(spielfeld[x][y] != 0) {
                i--;
                System.out.println("I--");
            }
        }
    }

    /**
     * Hilfsfunktion zur Ermittlung der Anzahl von Gefärbtenfeldern des übergebenen Teams
     * @param team Char Variable des Teams dessen Felder gezählt werden sollen
     * @return rückgabe der Anzahl der gefärbten Felder des Teams als Int
     */
    public static int zaehle(char team) {
        int counter = 0;
        if(team == 'P') {
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    if (spielfeld[i][j] == '7' || spielfeld[i][j] == 'P') {
                        counter++;
                    }
                }
            }
        }
        if  (team == 'O') {
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    if (spielfeld[i][j] == '9' || spielfeld[i][j] == 'O') {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    /**
     * Respawn funktion für die gestorbenen Spieler universal anwendbar auf beide Teams dank Team ermittlungssystems und flexible Spawnmethode
     * @param spieler Spieler der respawnt werden soll
     * @param l Int variable für die Länge des Spielfelds
     * @param b Int variable für die Breite des Spielfelds
     */
    public static void respawn(int spieler, int l, int b) {
        // Team erkennen
        char team = (spieler < 4) ? 'P' : 'O';

        // Alle möglichen Team-Felder sammeln
        List<int[]> felder = new ArrayList<>();

        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                if ((team == 'P' && (spielfeld[i][j] == '7' || spielfeld[i][j] == '9')) ||
                        (team == 'O' && (spielfeld[i][j] == '3' || spielfeld[i][j] == '9'))) {
                    felder.add(new int[]{i, j});
                }
            }
        }

        // Wenn Team-Felder vorhanden sind, wähle eines zufällig
        if (!felder.isEmpty()) {
            int spawnIndex = blatt13.Zufall.zufallGanz(felder.size() - 1, 0); // 0 bis felder.size()-1
            int[] spawn = felder.get(spawnIndex);
            spielerPosX[spieler] = spawn[0];
            spielerPosY[spieler] = spawn[1];
        } else {
            // Fallback: zufälliges Feld auf dem Spielfeld
            int rx = blatt13.Zufall.zufallGanz(l - 2, 1);
            int ry = blatt13.Zufall.zufallGanz(b - 2, 1);
            spielfeld[rx][ry] = team;
            spielerPosX[spieler] = rx;
            spielerPosY[spieler] = ry;
        }
    }

    //Spiellogik
    /**
     * Reihenfolgen Festlege funktion für die zufällige Zugreihenfolge der Spieler.
     * @return Zurückgabe des Strings mit der Reihenfolge als Zahlen in Form von "12345667"
     */
    public static String reihenfolge() {
        int[] reihenfolgeArr = new int[8];

        // Initial Array 0..7
        for (int i = 0; i < 8; i++) {
            reihenfolgeArr[i] = i;
        }

        // Fisher-Yates Shuffle
        for (int i = 7; i > 0; i--) {
            int j = blatt13.Zufall.zufallGanz(0, i + 1); // zufälliger Index zwischen 0..i
            // tausche reihenfolgeArr[i] und reihenfolgeArr[j]
            int temp = reihenfolgeArr[i];
            reihenfolgeArr[i] = reihenfolgeArr[j];
            reihenfolgeArr[j] = temp;
        }

        // Array zu String
        StringBuilder sb = new StringBuilder();
        for (int i : reihenfolgeArr) sb.append(i);

        String reihenfolgeString = sb.toString();
        System.out.println("Reihenfolge: " + reihenfolgeString);
        return reihenfolgeString;
    }

    /**
     * Spieleralgorithmus für Team P
     * @param spielerNummer
     */
    public static void zugEins(int spielerNummer) {
// Konfiguration: Sichtbarkeit der Feldfarben im 2-Block-Radius
        boolean feldfarbenSichtbar = true;

// Team-Zugehörigkeit ermitteln
        char eigenesTeam = (spielerNummer < 4) ? 'P' : 'O';
        char eigenesFarbe = (spielerNummer < 4) ? '7' : '9';
        char gegnerTeam = (spielerNummer < 4) ? 'O' : 'P';
        char gegnerFarbe = (spielerNummer < 4) ? '9' : '7';

// Aktuelle Position des Spielers
        int meinX = spielerPosX[spielerNummer];
        int meinY = spielerPosY[spielerNummer];

// Sichtbare Gegner für das gesamte Team ermitteln
        int[] sichtbareGegner = new int[4];
        int anzahlSichtbareGegner = 0;

        for (int verbündeter = (spielerNummer < 4 ? 0 : 4); verbündeter < (spielerNummer < 4 ? 4 : 8); verbündeter++) {
            int vX = spielerPosX[verbündeter];
            int vY = spielerPosY[verbündeter];

            for (int gegner = (spielerNummer < 4 ? 4 : 0); gegner < (spielerNummer < 4 ? 8 : 4); gegner++) {
                int gX = spielerPosX[gegner];
                int gY = spielerPosY[gegner];

                int dist = Math.max(Math.abs(vX - gX), Math.abs(vY - gY));

                if (dist <= 2) {
                    boolean bereitsGefunden = false;
                    for (int k = 0; k < anzahlSichtbareGegner; k++) {
                        if (sichtbareGegner[k] == gegner) {
                            bereitsGefunden = true;
                            break;
                        }
                    }
                    if (!bereitsGefunden) {
                        sichtbareGegner[anzahlSichtbareGegner++] = gegner;
                    }
                }
            }
        }

// Nächsten sichtbaren Gegner für diesen Spieler finden
        int zielGegner = -1;
        int minDistanz = Integer.MAX_VALUE;

        for (int i = 0; i < anzahlSichtbareGegner; i++) {
            int gegner = sichtbareGegner[i];
            int dist = Math.max(Math.abs(meinX - spielerPosX[gegner]), Math.abs(meinY - spielerPosY[gegner]));
            if (dist < minDistanz) {
                minDistanz = dist;
                zielGegner = gegner;
            }
        }

// Entscheidung: Angriff oder Färben?
        boolean angriffsModus = false;

        if (zielGegner != -1) {
            // Zähle wie viele Verbündete bereits näher am Gegner sind
            int nähereDran = 0;
            for (int verbündeter = (spielerNummer < 4 ? 0 : 4); verbündeter < (spielerNummer < 4 ? 4 : 8); verbündeter++) {
                if (verbündeter == spielerNummer) continue;
                int vDist = Math.max(Math.abs(spielerPosX[verbündeter] - spielerPosX[zielGegner]),
                        Math.abs(spielerPosY[verbündeter] - spielerPosY[zielGegner]));
                if (vDist < minDistanz) {
                    nähereDran++;
                }
            }

            // Maximal 2 Spieler greifen an
            if (nähereDran < 2) {
                angriffsModus = true;
            }
        }

// Bewegungsrichtungen: [dx, dy]
        int[][] richtungen = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int besteDx = 0, besteDy = 0;
        int besteBewertung = Integer.MIN_VALUE;

        for (int[] richtung : richtungen) {
            int neuesX = meinX + richtung[0];
            int neuesY = meinY + richtung[1];

            // Prüfe ob Feld gültig ist
            if (neuesX < 0 || neuesX >= spielfeld.length || neuesY < 0 || neuesY >= spielfeld[0].length) {
                continue;
            }

            char feld = spielfeld[neuesX][neuesY];

            // Wand oder Mitspieler blockieren
            if (feld == '8' || feld == eigenesTeam) {
                continue;
            }

            int bewertung = 0;

            if (angriffsModus && zielGegner != -1) {
                // Bewertung basierend auf Distanz zum Gegner
                int neueDist = Math.max(Math.abs(neuesX - spielerPosX[zielGegner]),
                        Math.abs(neuesY - spielerPosY[zielGegner]));
                bewertung = 1000 - neueDist * 100;

                // Bonus für Gegner-Treffer
                if (feld == gegnerTeam) {
                    bewertung += 5000;
                }
            } else {
                // Färbe-Modus
                if (feldfarbenSichtbar) {
                    // Bevorzuge ungefärbte oder Gegner-Felder
                    if (feld == 0 || feld == '\u0000') {
                        bewertung = 500;
                    } else if (feld == gegnerFarbe || feld == gegnerTeam) {
                        bewertung = 600;
                    } else if (feld == eigenesFarbe) {
                        bewertung = 50; // Vermeide eigene Felder, aber akzeptiere sie notfalls
                    }
                } else {
                    // Ohne Feldfarben-Sichtbarkeit: gleichmäßige Bewertung
                    if (feld != eigenesFarbe && feld != eigenesTeam) {
                        bewertung = 400;
                    } else {
                        bewertung = 100;
                    }
                }

                // Bonus für Gegner-Treffer auch im Färbe-Modus
                if (feld == gegnerTeam) {
                    bewertung += 3000;
                }

                // Zähle freie/Gegner-Felder in der Umgebung des Zielfelds
                int freieFelder = 0;
                for (int dx = -2; dx <= 2; dx++) {
                    for (int dy = -2; dy <= 2; dy++) {
                        int checkX = neuesX + dx;
                        int checkY = neuesY + dy;
                        if (checkX >= 0 && checkX < spielfeld.length &&
                                checkY >= 0 && checkY < spielfeld[0].length) {
                            char checkFeld = spielfeld[checkX][checkY];
                            if (checkFeld == 0 || checkFeld == '\u0000' ||
                                    checkFeld == gegnerFarbe || checkFeld == gegnerTeam) {
                                freieFelder++;
                            }
                        }
                    }
                }
                bewertung += freieFelder * 10;
            }

            if (bewertung > besteBewertung) {
                besteBewertung = bewertung;
                besteDx = richtung[0];
                besteDy = richtung[1];
            }
        }

// Bewegung ausführen
        if (besteBewertung > Integer.MIN_VALUE) {
            int neuesX = meinX + besteDx;
            int neuesY = meinY + besteDy;

            // Prüfe auf Gegner-Treffer
            for (int gegner = (spielerNummer < 4 ? 4 : 0); gegner < (spielerNummer < 4 ? 8 : 4); gegner++) {
                if (spielerPosX[gegner] == neuesX && spielerPosY[gegner] == neuesY) {
                    respawn(gegner, spielfeld.length, spielfeld[0].length);
                }
            }

            // Altes Feld färben (falls nicht bereits gefärbt)
            if (spielfeld[meinX][meinY] == eigenesTeam) {
                spielfeld[meinX][meinY] = eigenesFarbe;
            }

            // Position aktualisieren
            spielerPosX[spielerNummer] = neuesX;
            spielerPosY[spielerNummer] = neuesY;
            spielfeld[neuesX][neuesY] = eigenesTeam;
        }


    }

    /**
     * Spieleralgorithmus für Team O
     * @param spielerNummer
     */
    public static void zugZwei(int spielerNummer) {
        //Variablen

        //Feldwerte Gewichtung (Standard kann verändert werden bei Taktiken)
        int wand = 0;
        int mate = 0;
        int mateFarbe = 1;
        int gegnerFarbe = 4;
        int gegner = 5;
        int leer = 7;
        int unbekannt = 2;

        //Bewegungslogik
        int distanz = 1000;


        //Taktik Bonus rechnung
        if (flaechePushen) {
            leer += 2;
            gegnerFarbe += 6;
            gegner -= 2;
        }
        else if (gegnerJagen) {
            leer --;
            gegnerFarbe += 1;
            gegner += 3;
        }
        else if (search) { //Nicht fertig
            gegner ++;
            gegnerFarbe ++;
        }

        /*
        Übersetzungen:
        10 höchste Priorität
        0 Auslassen
         */
        int[][] sichtfeld = new int[5][5];

        int spielerX = spielerPosX[spielerNummer];
        int spielerY = spielerPosY[spielerNummer];

        int wert;

        //Erstellung von Heatmap und Sichtfeld
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                int feldX = spielerX + i - 2;
                int feldY = spielerY + j - 2;

                if (feldX >= 0 && feldX < spielfeld.length &&
                        feldY >= 0 && feldY < spielfeld[0].length) {

                    char c = spielfeld[feldX][feldY];

                    // Mapping
                    if (c == '8') {          // Wand
                        wert = wand;
                    } else if (c == 'O') {   // Spieler Team O (Eigener Spieler)
                        wert = mate;
                    } else if (c == '9') {   // Farbe Team O
                        wert = mateFarbe;
                    } else if (c == 'P') {   // Spieler Team P (Gegnerischer Spieler)
                        wert = gegner;
                    } else if (c == '7') {   // Farbe Team P
                        wert = gegnerFarbe;
                    } else {                 // leer / unbekannt
                        wert = leer;
                    }
                    sichtfeld[i][j] = wert;

                    teamHeatmap[feldX][feldY] = wert;

                } else {
                    sichtfeld[i][j] = 0;
                }
            }
        }


        if (flaechePushen) {
            //Lokale best places
            int[] lokaleFelderX = new int[25];
            int[] lokaleFelderY = new int[25];

            int counter = 0;

            int bestDist = Integer.MAX_VALUE;
            int bestX = -1;
            int bestY = -1;

            //Sichtfeld basiert
            for (int i = 0; i < sichtfeld.length; i++) {
                for (int j = 0; j < sichtfeld[0].length; j++) {

                    int index = i * sichtfeld[0].length + j;

                    if (sichtfeld[i][j] == 10) {
                        int d = Math.abs(i - 2) + Math.abs(j - 2);

                        if (d < distanz && d > 0) {
                            distanz = d;

                            bestX = i - 2;
                            bestY = j - 2;

                            lokaleFelderX[index] = i - 2;
                            lokaleFelderY[index] = j - 2;

                            System.out.println("Gegner Feld");
                            counter++;
                        }
                    } else {
                        lokaleFelderX[index] = 0;
                        lokaleFelderY[index] = 0;
                    }
                }
            }

            if (counter == 0) {
                for (int i = 0; i < sichtfeld.length; i++) {
                    for (int j = 0; j < sichtfeld[0].length; j++) {

                        int index = i * sichtfeld[0].length + j;

                        if (sichtfeld[i][j] == 9) {
                            int d = Math.abs(i - 2) + Math.abs(j - 2);

                            if (d < distanz && d > 0) {
                                distanz = d;

                                bestX = i - 2;
                                bestY = j - 2;

                                lokaleFelderX[index] = i - 2;
                                lokaleFelderY[index] = j - 2;

                                System.out.println("Leeres Feld");
                                counter++;
                            }
                        } else {
                            lokaleFelderX[index] = 0;
                            lokaleFelderY[index] = 0;
                        }
                    }
                }
            }

            if (counter == 0) {
                for (int i = 0; i < sichtfeld.length; i++) {
                    for (int j = 0; j < sichtfeld[0].length; j++) {

                        int index = i * sichtfeld[0].length + j;

                        if (sichtfeld[i][j] == 3) {
                            int d = Math.abs(i - 2) + Math.abs(j - 2);

                            if (d < distanz && d > 0) {
                                distanz = d;

                                bestX = i - 2;
                                bestY = j - 2;

                                lokaleFelderX[index] = i - 2;
                                lokaleFelderY[index] = j - 2;

                                System.out.println("Gegner");
                                counter++;
                            }
                        } else {
                            lokaleFelderX[index] = 0;
                            lokaleFelderY[index] = 0;
                        }
                    }
                }
            }

            //Teamheatmap Fallback
            if (counter == 0) {
                int[] heatFelderX = new int[teamHeatmap.length * teamHeatmap[0].length];
                int[] heatFelderY = new int[teamHeatmap.length * teamHeatmap[0].length];

                for (int i = 0; i < teamHeatmap.length; i++) {
                    for (int j = 0; j < teamHeatmap[0].length; j++) {

                        int index = i * teamHeatmap[0].length + j;

                        if (teamHeatmap[i][j] == 9) {
                            int d = Math.abs(i) + Math.abs(j);

                            if (d < distanz && d > 0) {
                                distanz = d;

                                bestX = i;
                                bestY = j;

                                heatFelderX[index] = i;
                                heatFelderY[index] = j;

                                System.out.println("Leeres Feld Teamheatmap");
                                counter++;
                            }
                        } else {
                            heatFelderX[index] = 0;
                            heatFelderY[index] = 0;
                        }
                    }
                }

                if (counter == 0) {
                    for (int i = 0; i < teamHeatmap.length; i++) {
                        for (int j = 0; j < teamHeatmap[0].length; j++) {

                            int index = i * teamHeatmap[0].length + j;

                            if (teamHeatmap[i][j] == 6) {
                                int d = Math.abs(i) + Math.abs(j);

                                if (d < distanz && d > 0) {
                                    distanz = d;

                                    bestX = i;
                                    bestY = j;

                                    heatFelderY[index] = i;
                                    heatFelderY[index] = j;

                                    System.out.println("Gegner Feld Teamheatmap");
                                    counter++;
                                }
                            } else {
                                heatFelderX[index] = 0;
                                heatFelderY[index] = 0;
                            }
                        }
                    }
                }
                if (counter == 0) {
                    for (int i = 0; i < teamHeatmap.length; i++) {
                        for (int j = 0; j < teamHeatmap[0].length; j++) {

                            int index = i * teamHeatmap[0].length + j;

                            if (teamHeatmap[i][j] == 3) {
                                int d = Math.abs(i) + Math.abs(j);

                                if (d < distanz && d > 0) {
                                    distanz = d;

                                    bestX = i;
                                    bestY = j;

                                    heatFelderX[index] = i;
                                    heatFelderY[index] = j;

                                    System.out.println("Gegner Teamheatmap");
                                    counter++;
                                }
                            } else {
                                heatFelderX[index] = 0;
                                heatFelderY[index] = 0;
                            }
                        }
                    }
                }

                //Bewegung Teamheatmap art
                if (bestX >= 0 && bestY >= 0) {
                    // Alte Position leeren
                    int altX = spielerPosX[spielerNummer];
                    int altY = spielerPosY[spielerNummer];
                    spielfeld[altX][altY] = '9';

                    if (spielfeld[bestX][bestY] == '8') {
                    }else {
                    // Spieler verschieben
                    spielerPosX[spielerNummer] = bestX;
                    spielerPosY[spielerNummer] = bestY;
                    spielfeld[bestX][bestY] = 'O';
                    }
                } else {
                    System.out.println("Kein gültiges Teamheatmap-Ziel gefunden, Bewegung übersprungen.");
                }


            }
            //Normale Bewegung
            else{
                if (spielfeld[spielerPosX[spielerNummer] + bestX][spielerPosY[spielerNummer] + bestY] == '8') {
                }
                else {
                    int altX = spielerPosX[spielerNummer];
                    int altY = spielerPosY[spielerNummer];

                    spielerPosX[spielerNummer] += bestX;
                    spielerPosY[spielerNummer] += bestY;

                    spielfeld[spielerPosX[spielerNummer]][spielerPosY[spielerNummer]] = 'O';

                    spielfeld[altX][altY] = '9';
                }
            }

        }
        else if (gegnerJagen) {
            int[] lokaleFelderX = new int[25];
            int[] lokaleFelderY = new int[25];

            int counter = 0;

            int bestDist = Integer.MAX_VALUE;
            int bestX = -1;
            int bestY = -1;

            //Sichtfeld suche
            for (int i = 0; i < sichtfeld.length; i++) {
                for (int j = 0; j < sichtfeld[0].length; j++) {

                    int index = i * sichtfeld[0].length + j;

                    if (sichtfeld[i][j] == 8) {
                        int d = Math.abs(i - 2) + Math.abs(j - 2);

                        if (d < distanz && d > 0) {
                            distanz = d;

                            bestX = i - 2;
                            bestY = j - 2;

                            lokaleFelderX[index] = i - 2;
                            lokaleFelderY[index] = j - 2;

                            System.out.println("Gegner");
                            counter++;
                        }
                    } else {
                        lokaleFelderX[index] = 0;
                        lokaleFelderY[index] = 0;
                    }
                }
            }

            if (counter == 0) {
                for (int i = 0; i < sichtfeld.length; i++) {
                    for (int j = 0; j < sichtfeld[0].length; j++) {

                        int index = i * sichtfeld[0].length + j;

                        if (sichtfeld[i][j] == 5) {
                            int d = Math.abs(i - 2) + Math.abs(j - 2);

                            if (d < distanz && d > 0) {
                                distanz = d;

                                bestX = i - 2;
                                bestY = j - 2;

                                lokaleFelderX[index] = i - 2;
                                lokaleFelderY[index] = j - 2;

                                System.out.println("Gegner Farbe");
                                counter++;
                            }
                        } else {
                            lokaleFelderX[index] = 0;
                            lokaleFelderY[index] = 0;
                        }
                    }
                }
            }

            //Teamheatmap Fallback
            if (counter == 0) {
                int[] heatFelderX = new int[teamHeatmap.length * teamHeatmap[0].length];
                int[] heatFelderY = new int[teamHeatmap.length * teamHeatmap[0].length];

                for (int i = 0; i < teamHeatmap.length; i++) {
                    for (int j = 0; j < teamHeatmap[0].length; j++) {

                        int index = i * teamHeatmap[0].length + j;

                        if (teamHeatmap[i][j] == 8) {
                            int d = Math.abs(i) + Math.abs(j);

                            if (d < distanz && d > 0) {
                                distanz = d;

                                bestX = i;
                                bestY = j;

                                heatFelderX[index] = i;
                                heatFelderY[index] = j;

                                System.out.println("Gegner Teamheatmap");
                                counter++;
                            }
                        } else {
                            heatFelderX[index] = 0;
                            heatFelderY[index] = 0;
                        }
                    }
                }

                if (counter == 0) {
                    for (int i = 0; i < teamHeatmap.length; i++) {
                        for (int j = 0; j < teamHeatmap[0].length; j++) {

                            int index = i * teamHeatmap[0].length + j;

                            if (teamHeatmap[i][j] == 5) {
                                int d = Math.abs(i) + Math.abs(j);

                                if (d < distanz && d > 0) {
                                    distanz = d;

                                    bestX = i;
                                    bestY = j;

                                    heatFelderX[index] = i;
                                    heatFelderY[index] = j;

                                    System.out.println("Gegner Farbe Teamheatmap");
                                    counter++;
                                }
                            } else {
                                heatFelderX[index] = 0;
                                heatFelderY[index] = 0;
                            }
                        }
                    }
                }

                //Bewegung Teamheatmap art
                if (bestX >= 0 && bestY >= 0) {
                    if (spielfeld[bestX][bestY] == '8') {

                    }
                    else {
                        // Alte Position leeren
                        int altX = spielerPosX[spielerNummer];
                        int altY = spielerPosY[spielerNummer];
                        spielfeld[altX][altY] = '9';

                        // Spieler verschieben
                        spielerPosX[spielerNummer] = bestX;
                        spielerPosY[spielerNummer] = bestY;
                        spielfeld[bestX][bestY] = 'O';
                    }
                } else {
                    System.out.println("Kein gültiges Teamheatmap-Ziel gefunden, Bewegung übersprungen.");
                }


            }
            //Normale Bewegung nach Sichtfeld
            else{
                if (spielfeld[spielerPosX[spielerNummer] + bestX][spielerPosY[spielerNummer] + bestY] == '8') {

                }
                int altX = spielerPosX[spielerNummer];
                int altY = spielerPosY[spielerNummer];

                spielerPosX[spielerNummer] += bestX;
                spielerPosY[spielerNummer] += bestY;

                spielfeld[spielerPosX[spielerNummer]][spielerPosY[spielerNummer]] = 'O';

                spielfeld[altX][altY] = '9';
            }
        }

        else if (search) {
            int besterDist = Integer.MAX_VALUE;
            int moveX = 0;
            int moveY = 0;

            // Durchs 5x5-Sichtfeld schauen
            for (int i = -2; i <= 2; i++) {
                for (int j = -2; j <= 2; j++) {
                    int x = spielerPosX[spielerNummer] + i;
                    int y = spielerPosY[spielerNummer] + j;

                    if (x >= 0 && x < teamHeatmap.length && y >= 0 && y < teamHeatmap[0].length) {
                        int wert3 = teamHeatmap[x][y];

                        // Suche nach nicht-eigenen Feldern
                        if (wert3 != 9 && wert3 != 6) {
                            int dist = Math.abs(i) + Math.abs(j); // Manhattan-Distanz
                            if (dist < besterDist && dist > 0) {
                                besterDist = dist;
                                moveX = i;
                                moveY = j;
                            }
                        }
                    }
                }
            }

            // Bewegung durchführen
            if (spielfeld[spielerPosX[spielerNummer] + moveX][spielerPosY[spielerNummer] + moveY] == '8') {
            }
            else {
                int altX = spielerPosX[spielerNummer];
                int altY = spielerPosY[spielerNummer];

                spielerPosX[spielerNummer] += moveX;
                spielerPosY[spielerNummer] += moveY;

                spielfeld[spielerPosX[spielerNummer]][spielerPosY[spielerNummer]] = 'O';
                spielfeld[altX][altY] = '9'; // vorheriges Feld wieder als eigene Farbe markieren
            }
        }

        //Taktik switchen
        int eigeneFelderHeat = 0;
        int gegnerFelderHeat = 0;
        int leereFelder = 0;

        for (int i = 0; i < breite; i++) {
            for (int j = 0; j < laenge; j++) {
                if (teamHeatmap[i][j] == 8 || teamHeatmap[i][j] == 5) {
                    gegnerFelderHeat ++;
                }
                else if (teamHeatmap[i][j] == 9 || teamHeatmap[i][j] == 6) {
                    eigeneFelderHeat ++;
                }
                else if (teamHeatmap[i][j] == 3) {}
                else {
                    leereFelder ++;
                }
            }
        }

        // Prozentwerte berechnen
        // Für jeden Spieler:
        int sichtRadius = 2; // 5x5 Sichtfeld
        int eigeneFelder = 0;
        int gegnerFelder = 0;
        int leerFelder = 0;

        int meinX = spielerPosX[spielerNummer];
        int meinY = spielerPosY[spielerNummer];

        for (int i = -sichtRadius; i <= sichtRadius; i++) {
            for (int j = -sichtRadius; j <= sichtRadius; j++) {
                int x = meinX + i;
                int y = meinY + j;

                if (x >= 0 && x < teamHeatmap.length && y >= 0 && y < teamHeatmap[0].length) {
                    int wert2 = teamHeatmap[x][y];

                    if (wert2 == 9 || wert2 == 6) eigeneFelder++;
                    else if (wert2 == 8 || wert2 == 5 || wert2 == 3) gegnerFelder++;
                    else leerFelder++;
                }
            }
        }

        int gesamt = eigeneFelder + gegnerFelder + leerFelder;

        double eigeneProzent = (eigeneFelder / (double) gesamt) * 100.0;
        double gegnerProzent = (gegnerFelder / (double) gesamt) * 100.0;
        double leereProzent = (leerFelder / (double) gesamt) * 100.0;

        System.out.println("Lokale Sichtfeldwerte:");
        System.out.println("Eigene: " + eigeneProzent + "%");
        System.out.println("Gegner: " + gegnerProzent + "%");
        System.out.println("Leer: " + leereProzent + "%");


        // Taktik basierend auf Anteilen
        if (eigeneProzent > 50) {
            search = true;
            flaechePushen = false;
            gegnerJagen = false;
            System.out.println("SEARCH aktiv!");
            System.out.print("\n\n\n\n\n\n");
            searchCount ++;
            System.out.println("SC " +  searchCount);
        } else if (gegnerProzent > 20) {
            gegnerJagen = true;
            flaechePushen = false;
            search = false;
            System.out.println("GEGNER JAGEN!");
            System.out.print("\n\n\n\n\n\n");
            gegegnerJagenCount ++;
            System.out.println("GC " +  gegegnerJagenCount);
        } else if (leereProzent > 50) {
            flaechePushen = true;
            gegnerJagen = false;
            search = false;
            System.out.println("FLÄCHE PUSHEN!");
            System.out.print("\n\n\n\n\n\n");
            flaechePushenCount ++;
            System.out.println("FC" + flaechePushenCount);
        }



        if (flaechePushen) {
            System.out.println("fläche pushen!");
        } else if (gegnerJagen) {
            System.out.println("gegner jagen!");
        } else if (search) {
            System.out.println("search!");
        }


    }

    public static void schritt() {
        //Heatmap reset
        teamHeatmap = new int[laenge][breite];

        // Reihenfolge für diesen Spielschritt generieren
        String reihenfolgeString = reihenfolge();

        // Jeden Spieler in der generierten Reihenfolge ziehen lassen
        for (int i = 0; i < 8; i++) {
            int spielerNummer = Character.getNumericValue(reihenfolgeString.charAt(i));

            // Prüfe ob Spieler noch am Leben ist (nicht in diesem Schritt getötet wurde)
            // Falls der Spieler existiert, führe seinen Zug aus
            if (spielerNummer < 4) {
                zugEins(spielerNummer);
            } else {
                zugZwei(spielerNummer);
            }
        }
    }

    /**
     * Auswertung des Gewinners der Spielpartie und Ausgabe der prozentualen Anteile jedes Teams des Spielfeldes
     */
    public static void auswertung() {
        //speicher
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;

        //zählmechanismus - KORRIGIERT: < statt <=
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                if (spielfeld[i][j] == 'P' || spielfeld[i][j] == '7') {
                    counter1++;
                }
                else if (spielfeld[i][j] == 'O' || spielfeld[i][j] == '9') {
                    counter2++;
                }
                else if (spielfeld[i][j] == '8') {}
                else{
                    counter3++;
                }
            }
        }

        //prozentuale berechnung
        int spielfeldgroeße = laenge * breite;

        int prozent1 = (counter1 * 100) / spielfeldgroeße;
        int prozent2 = (counter2 * 100) / spielfeldgroeße;
        int prozent3 = (counter3 * 100) / spielfeldgroeße;

        //Verkündung des gewinners
        if (prozent1 > prozent2) {
            System.out.println("Team 1 hat gewonnen");
        }
        else if (prozent1 < prozent2) {
            System.out.println("Team 2 hat gewonnen");
        }
        else {
            System.out.println("Unentschieden");
        }

        //Größen ausgabe:
        System.out.println("Feldgröße Team 1: " + prozent1 + "%");
        System.out.println("Feldgröße Team 2: " + prozent2 + "%");
        System.out.println("Freie Felder: " + prozent3 + "%");
    }

    public static void simulation(int anzahlSchritte) {
        SchischVisualizer sv = new SchischVisualizer();

        // Spielfeld initialisieren
        initialisiereSpielfeld(laenge, breite);

        // Startposition visualisieren
        sv.step(spielfeld);

        // Angegebene Anzahl an Spielschritten durchführen
        for (int i = 0; i < anzahlSchritte; i++) {
            schritt();
            sv.step(spielfeld);

            // Optional: Verzögerung für bessere Sichtbarkeit
            try {
                Thread.sleep(100); // 100ms Pause zwischen Schritten
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Visualizer starten
        sv.start();

        // Auswertung ausgeben
        auswertung();
    }

    public static void main(String[] args) {
        /*
        SchischVisualizer sv = new SchischVisualizer();

        initialisiereSpielfeld(laenge,breite);

        sv.step(spielfeld);
        sv.start();
        */

        simulation(500); // Führt 50 Spielschritte durch


        for (int i = 0; i < laenge; i++) {
            for (int j = 0; j < breite; j++) {
                System.out.printf("%2d ", teamHeatmap[i][j]);
            }
            System.out.println();
        }
    }

}
