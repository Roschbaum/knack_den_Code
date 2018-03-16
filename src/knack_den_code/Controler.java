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
public class Controler {

    private Spielfeld mSpielfeld;
    private static final int anzahlSpielböcke = 10;
    private static final int anzahlStecksteinfiguren = 5;
    private int[] mPrüfsteine = new int[2];
    private int[] steckfiguren = new int[anzahlStecksteinfiguren];

    public Controler() {
        this.mSpielfeld = new Spielfeld(anzahlSpielböcke, anzahlStecksteinfiguren);
        erzeugefiguren();
    }

    public void spiele(String befehl) {
        Scanner scanner = new Scanner(befehl);
        switch (scanner.next()) {
            case "setztSteckfigur":
                setztSteckfigur(scanner);
                break;
            case "setztSteckfigurLösung":
                setztSteckfigurLösung(scanner);
            case "setzePrüfsteinfigur":
                setzePrüfsteinfigur(scanner);
                break;
            case "zeigeLösung":
                zeigeLösung();
                break;
            case "zeigeFeld":
                zeigeFeld();
                break;
        }
    }

    private void erzeugefiguren() {
        for (int i : mPrüfsteine) {
            i = 20;
        }
        for (int i : steckfiguren) {
            i = 19;
        }

    }

    private Steckfigur getSteckfigur(int typ) {
        return null;
    }

    private Prüfsteinfigur getPrüfsteinfigur(int typ) {
        return null;
    }

    private void setzePrüfsteinfigur(Scanner scanner) {
        mSpielfeld.setzePrüfsteinfigur(scanner.nextInt(), scanner.nextInt(), getPrüfsteinfigur(scanner.nextInt()));
    }

    private void setztSteckfigur(Scanner scanner) {
        mSpielfeld.setzeSteckfigur(scanner.nextInt(), scanner.nextInt(), getSteckfigur(scanner.nextInt()));
    }

    private void setztSteckfigurLösung(Scanner scanner) {
        for (int i = 0; i < 4; i++) {
            mSpielfeld.setzeSteckfigur(i, getSteckfigur(scanner.nextInt()));

        }
    }

    public void ausgeben(String s) {

    }

    private void zeigeFeld() {
        Steckfigur[][] mFeld = mSpielfeld.getmFeld();
        String m = "";
        String g = "";
        Prüfsteinfigur[][] mpFeld = mSpielfeld.getmPFeld();
        for (int i = 0; i < anzahlSpielböcke; i++) {
            for (int j = 0; j < anzahlStecksteinfiguren; j++) {
                m += mFeld[i][j].getTyp() + " ";
                g += mpFeld[i][j].getTyp() + " ";
            }
            ausgeben(m + "x" + g + "/n");
            m = "";
            g = "";
        }
    }

    private void zeigeLösung() {
        Steckfigur[] zielCode = mSpielfeld.getZielCode();
        String s = "";
        for (int i = 0; i < 4; i++) {
            s += zielCode[i].getTyp() + " ";
        }
        ausgeben(s);
    }
}
