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
public class Controller {

    private View view;
    private Spielfeld mSpielfeld;
    private static final int anzahlSpielboecke = 10;
    private static final int anzahlStecksteinfiguren = 5;
    private int[] mPruefsteine = new int[2];
    private int[] steckfiguren = new int[anzahlStecksteinfiguren];

    public Controller() {
        this.mSpielfeld = new Spielfeld(anzahlSpielboecke, anzahlStecksteinfiguren);
        erzeugefiguren();
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.spiele("setztSteckfigurLoesung 1 1 1 1");
        controller.spiele("zeigeLoesung");
        controller.spiele("setztSteckfigur 1 2 1");
        controller.spiele("zeigeFeld");
        controller.spiele("setzePruefsteinfigur 1 1 1");
        controller.spiele("zeigeFeld");

    }

    public void spiele(String befehl) {
        Scanner scanner = new Scanner(System.in);
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
            case "loescheFeld":
                loescheFeld();
                break;
            case "kontroliereBlock":
                kontroliereBlock();
                break;
        }
    }

    private void erzeugefiguren() {
//        for (int i : mPruefsteine) {
//            i = 20;
//        }
        
        for (int i = 0; i < anzahlStecksteinfiguren; i++) {
            steckfiguren[i] = 19;
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
        System.out.print(s);
    }

    private void kontroliereBlock() {
        mKontrolspieler.
    }

    private void loescheFeld() {
        for (int i = 0; i < 100; i++) {
            ausgeben(" ");
        }
    }

    private void zeigeFeld() {
        Steckfigur[][] mFeld = mSpielfeld.getmFeld();
        String m = "";
        String g = "";
        Pruefsteinfigur[][] mpFeld = mSpielfeld.getmPFeld();
        for (int i = 0; i < anzahlSpielboecke; i++) {
            for (int j = 0; j < 4; j++) {
                m += mFeld[i][j].getTyp() + " ";
                g += mpFeld[i][j].getTyp() + " ";
            }
            ausgeben(m + "x" + g + "\n");
            m = "";
            g = "";
        }
        ausgeben("\n");
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
