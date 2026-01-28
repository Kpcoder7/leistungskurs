package blatt15;

import schisch_visualizer. *;

public class Farben {

    //Globale Variablen
    static char[][] spielfeld;
    static int[] spielerPosX = new int[8];
    static int[] spielerPosY  = new int[8];
    static int[] reihenfolge;

    static int laenge = 20;
    static int breite = 20;

    static int[][] teamHeatmap = new int[laenge][breite];
    static boolean heatmapFertig = false;




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
        //Team erkennung
        char team = '0';
        if (spieler >= 0 && spieler < 4) {
            team = 'P';
        }
        else if (spieler >= 4 && spieler < 8) {
            team = 'O';
        }

        //Prüfung, ob das Team noch Felder hat
        if((zaehle(team) - 4) > 0) {
            int feld = blatt13.Zufall.zufallGanz(zaehle(team), 0);
            int[] x = new int[feld];
            int[] y = new int[feld];
            int counter = 0;
            if(team == 'P') {
                for (int i = 0; i < spielfeld.length; i++) {
                    for (int j = 0; j < spielfeld[i].length; j++) {
                        if (spielfeld[i][j] == '7' || spielfeld[i][j] == '9') {
                            x[counter] = i;
                            y[counter] = j;
                        }
                    }
                }
            }

            int spawnFeld = blatt13.Zufall.zufallGanz(counter, 0);
            spielerPosX[spieler] = x[spawnFeld];
            spielerPosY[spieler] = y[spawnFeld];
        }
        else {
            int x = blatt13.Zufall.zufallGanz(l-2, 1);
            int y = blatt13.Zufall.zufallGanz(b-2, 1);
            spielfeld[x][y] = team;
            spielerPosX[spieler] = x;
            spielerPosY[spieler] = y;
        }

    }

    //Spiellogik
    /**
     * Reihenfolgen Festlege funktion für die zufällige Zugreihenfolge der Spieler.
     * @return Zurückgabe des Strings mit der Reihenfolge als Zahlen in Form von "12345667"
     */
    public static String reihenfolge() {
        String reihenfolgeString = "";

        //Variablen
        int zahlspeicher = 0;
        int reihenfolgeArr[] = new int[8];

        //Zufalls Reihenfolge generierung
        for (int i = 0; i < 7; i++) {
            zahlspeicher = blatt13.Zufall.zufallGanz(0, 8);
            for (int j = 0; j < 7; j++) {
                if (reihenfolgeArr[j] != zahlspeicher) {
                    reihenfolgeArr[j] = zahlspeicher;
                } else if (reihenfolgeArr[j] == zahlspeicher) {
                    i--;
                    break;
                }
            }
        }

        //Konvertierung für int[] zu ""
        for (int i : reihenfolgeArr) {
            reihenfolgeString += i;
        }

        //rückgabe des Strings
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
        int importanceScore = 0; //Wichtigkeit einen Gegner anzugreifen oder Feld + gleich Feld - gleich Gegner
        boolean sichtbareGegner = false; // Gegner da -> ja nein?
        boolean sichtbareFarbe = false; // Andere Farbe sichtbar -> ja nein?

        //Taktiken
        boolean flaechePushen = false;
        boolean gegnerJagen = false;
        boolean swat = false;

        // Aktuelle Position des Spielers
        int meinX = spielerPosX[spielerNummer];
        int meinY = spielerPosY[spielerNummer];

        /*
        Übersetzungen:
        10 Höchste Priorität
        0 Auslassen
         */
        int[][] sichtfeld = new int[5][5];

        int spielerX = spielerPosX[spielerNummer];
        int spielerY = spielerPosY[spielerNummer];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                // Offset: -2 bis +2
                int feldX = spielerX + i - 2;
                int feldY = spielerY + j - 2;

                // Bounds-Check
                if (feldX >= 0 && feldX < spielfeld.length &&
                        feldY >= 0 && feldY < spielfeld[0].length) {

                    sichtfeld[i][j] = mapCharToInt(spielfeld[feldX][feldY]);
                    teamHeatmap[feldX][feldY] += mapCharToInt(spielfeld[feldX][feldY]);

                } else {
                    sichtfeld[i][j] = 0; // außerhalb des Spielfelds
                }
            }
        }

        if (heatmapFertig != true) {
            return;
        }


    }

    private static int mapCharToInt(char c) {
        return switch (c) {
            case '8' -> 0;
            case 'P' -> 1;
            case '7' -> 3;
            case '9' -> 8;
            case 'O' -> 6;
            default  -> 0; // außerhalb / leer
        };
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

        simulation(50); // Führt 50 Spielschritte durch
    }

}
