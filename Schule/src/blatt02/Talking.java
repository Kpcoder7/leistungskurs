package blatt02; //Package

import java.util.Scanner; //Importieren des Scanners aus der Java Bibliothek

public class Talking { //Klasse
    public static void main(String[] args) {

        Scanner scannerName = new Scanner(System.in); //Initialisierung des Scanners

        System.out.println("Guten Tag, wie heißen Sie?"); //Stringfrage nach dem Namen
        String name = scannerName.nextLine(); //Eingabe + speicherung für den Namen

        System.out.println("Hallo " + name + "!"); //Begrüßungsausgabe
    }
}
