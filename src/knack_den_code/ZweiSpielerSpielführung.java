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
    Scanner scanner = new Scanner(System.in);
    int anzahlDerVersuche;
    int anzhlSpielfigurTypen;

    public ZweiSpielerSpielführung() {
        ausgeben("Spiel Knack den Code\n"
                + "Ziel des Spiels ist es den Code als Codekanacker zu erraten. "
                + "Wenn es einem in den Maximal möglichen Spiel Zügen gelingt hat man gewonnen.\n "
                + "Unter der Eingabe help erhalten Sie eien Liste mit allen möglichen Eingaben\n"
                + "zunachst mus die Anzahl der Versuche des Codebrechers und die Anzahl der "
                + "Steckfigurentypen bestimt werden");

        eingabederFeldParameter();
        loesungeingeben();
        for (int i = 0; i < anzahlDerVersuche; i++) {
            blockeingeben();
            kontolierenlassen();
//            erraten();
        }
//        starteSpiel();
    }

    private void blockeingeben() {
        ausgeben("setzen sie nun die einzelnen Steckfiguren nach einander (Eingabesyntaks ist setztSteckfigur Zahl Zahl Zahl");
        for (int i = 0; i < 4; i++) {
            figureingeben();
        }
    }

    private void figureingeben() {
        String s = scanner.nextLine();
        if (!controller.spieleZug(s) || !s.contains("setztSteckfigur")) {
            figureingeben();
        }
    }

    private void eingabederFeldParameter() {
        ausgeben("geben Sie jetzt die Anzahl der Versuche des Codebrechers ein:");
        anzahlDerVersuche = scanner.nextInt();
        ausgeben("geben Sie jetzt die Anzahl an SpielfigurTypen ein:");
        anzhlSpielfigurTypen = scanner.nextInt();
        scanner.nextLine();
        this.controller = new Controller(anzahlDerVersuche, anzhlSpielfigurTypen);
    }

    public void starteSpiel() {
        int codelange = 4;

//        "Der Code Kontrolierer soll nun den Code festlegen"
        for (int i = 0; i < codelange; i++) {
            controller.spieleZug(scanner.nextLine());
        }
        controller.spieleZug("loescheFeld");
        for (int i = 0; i < 10; i++) {
            manageVersuch(codelange);
        }

    }

    private void erraten() {
    }

    private void kontolierenlassen() {
        ausgeben("beben sie die Kontrollfiguren nach einnander ein (Eingabesyntaks setzePruefsteinfigur Zahl Zahl Zahl");
        controller.spieleZug("zeigeLoesung");
        setzePrüfsteinfigur();
        controller.spieleZug("loescheFeld");
    }

    private void loesungeingeben() {
        ausgeben("Geben Sie nun bitte den Lösungscode ein (Eingabesyntaks setztSteckfigurLoesung Zahl Zahl Zahl Zahl:");
        String s = scanner.nextLine();
        if (!controller.spieleZug(s) || !s.contains("setztSteckfigurLoesung")) {
            loesungeingeben();
        }
    }

    private void manageVersuch(int codelange) {

        ausgeben("Der Codebrecher soll einen Versuch starten");
        for (int j = 0; j < codelange; j++) {
            überprüfeunspieleZug(scanner.nextLine());
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

    private void setzePrüfsteinfigur() {
        String s = scanner.nextLine();
        if (!controller.spieleZug(s) || (!s.contains("setzePruefsteinfigur") && !s.contains("kontorliereBlock"))) {
            setzePrüfsteinfigur();
        }
    }

    private void überprüfeunspieleZug(String nextLine) {
        if (nextLine.contains("setztSteckfigur") && !nextLine.contains("setztSteckfigurLoesung")) {
            if (!controller.spieleZug(nextLine)) {
                überprüfeunspieleZug(scanner.nextLine());
            }
        }
        String x = "";
//        switch (nextLine.contains(x)){
//            case "setztSteckfigurLoesung":
//        }
    }
}
