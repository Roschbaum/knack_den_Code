/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knack_den_code;

import java.util.Scanner;

/**
 *
 * @author Friedrich
 */
public class ZweiSpielerSpielführung {

    Controller controller;

    public ZweiSpielerSpielführung() {
        this.controller = new Controller();
        starteSpiel();
    }

    public void starteSpiel() {
        int codelange = 4;
        ausgeben("Spiel Knack den Code\n"
                + "Ziel des Spiels ist es den Code als Codekanacker zu erraten. "
                + "Wenn es einem in den Maximal möglichen Spiel Zügen gelingt hat man gewonnen.\n "
                + "Unter der Eingabe help erhalten Sie eien Liste mit allen möglichen Eingaben\n"
                + "Der Code Kontrolierer soll nun den Code festlegen");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < codelange; i++) {
            controller.spieleZug(scanner.nextLine());
        }
        controller.spieleZug("loescheFeld");
        for (int i = 0; i < 10; i++) {
            manageVersuch(codelange);
        }

    }

    private void manageVersuch(int codelange) {
        Scanner scanner = new Scanner(System.in);

        ausgeben("Der Codebrecher soll einen Versuch starten");
        for (int j = 0; j < codelange; j++) {
            controller.spieleZug(scanner.nextLine());
        }
        ausgeben("Der Codeprüfer soll den Code überprüfen un die Steine setzen ");
        controller.spieleZug("zeigeLoesung");
        for (int j = 0; j < codelange; j++) {
            controller.spieleZug(scanner.nextLine());
        }
        controller.spieleZug("loescheFeld");

    }

    private void ausgeben(String ausgabe) {
        System.out.println(ausgabe);
    }

    public static void main(String[] args) {
        new ZweiSpielerSpielführung();
    }
}
