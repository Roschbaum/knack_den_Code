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
    private static final int anzahlSpielboecke = 10;
    private static final int anzahlStecksteinfiguren = 5;
    private int[] mPruefsteine = new int[2];
    private int[] steckfiguren = new int[anzahlStecksteinfiguren];

    public Controler() {
        this.mSpielfeld = new Spielfeld(anzahlSpielboecke, anzahlStecksteinfiguren);
        erzeugefiguren();
    }

    public void spiele(String befehl) {
        Scanner scanner = new Scanner(befehl);
        switch (scanner.next()) {
            case "setztSteckfigur":
                setztSteckfigur(scanner);
                break;
            case "setztSteckfigurLoesung":
                setztSteckfigurLoesung(scanner);
                break;
            case "setzePruefsteinfigur":
                setzePruefsteinfigur(scanner);
                break;
            case "zeigeLoesung":
                zeigeLoesung();
                break;
            case "zeigeFeld":
                zeigeFeld();
                break;
        }
    }

    private void erzeugefiguren() {
        for (int i : mPruefsteine) {
            i = 20;
        }
        for (int i : steckfiguren) {
            i = 19;
        }

    }

    private Steckfigur getSteckfigur(int typ) {
        if (steckfiguren[typ] > 0) {
            steckfiguren[typ]--;
            return new Steckfigur(typ);
        }
        return null;
    }

    private Pruefsteinfigur getPruefsteinfigur(int typ) {
        if (steckfiguren[typ] > 0) {
            steckfiguren[typ]--;
            return new Pruefsteinfigur(typ);
        }
        return null;
    }

    private void setzePruefsteinfigur(Scanner scanner) {
        mSpielfeld.setzePruefsteinfigur(scanner.nextInt(), scanner.nextInt(), getPruefsteinfigur(scanner.nextInt()));
    }

    private void setztSteckfigur(Scanner scanner) {
        mSpielfeld.setzeSteckfigur(scanner.nextInt(), scanner.nextInt(), getSteckfigur(scanner.nextInt()));
    }

    private void setztSteckfigurLoesung(Scanner scanner) {
        for (int i = 0; i < 4; i++) {
            mSpielfeld.setzeSteckfigur(i, getSteckfigur(scanner.nextInt()));
            
        }
    }

    public void ausgeben(String s) {
        System.out.println(s);
    }

    private void zeigeFeld() {
        Steckfigur[][] mFeld = mSpielfeld.getmFeld();
        String m = "";
        String g = "";
        Pruefsteinfigur[][] mpFeld = mSpielfeld.getmPFeld();
        for (int i = 0; i < anzahlSpielboecke; i++) {
            for (int j = 0; j < anzahlStecksteinfiguren; j++) {
                m += mFeld[i][j].getTyp() + " ";
                g += mpFeld[i][j].getTyp() + " ";
            }
            ausgeben(m + "x" + g + "/n");
            m = "";
            g = "";
        }
    }

    private void zeigeLoesung() {
        Steckfigur[] zielCode = mSpielfeld.getZielCode();
        String s = "";
        for (int i = 0; i < 4; i++) {
            s += zielCode[i].getTyp() + " ";
        }
        ausgeben(s);
    }
}
