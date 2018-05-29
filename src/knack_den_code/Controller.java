package knack_den_code;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Friedrich
 */
public class Controller {

    private Spielfeld mSpielfeld;
    private final int anzahlSpielboecke;
    private final int anzahlStecksteinfiguren;

    Controller(int anzahlDerVersuche, int anzahlSpielfigurTypen) {
        anzahlSpielboecke = anzahlDerVersuche;
        anzahlStecksteinfiguren = anzahlSpielfigurTypen;
        this.mSpielfeld = new Spielfeld(anzahlSpielboecke, anzahlStecksteinfiguren);

    }

    public void spiele() {
        Scanner scanner = new Scanner(System.in);
        spieleZug(scanner.nextLine());
        spieleZug("zeigeFeld");
        spiele();
    }

    /**
     * Eingabe eines Befehls.
     *
     * @param befehl
     * @return true befehl wurde ordnungsgemäs ausgeführt. false Befehl enthält
     * einen Fehler. Falls ein eingabe Fehler vorliegt, wird dies ausgegeben.
     */
    public boolean spieleZug(String befehl) {
        Scanner scanner = new Scanner(befehl);
        try {
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
                case "kontorliereBlock":
                    kontroliereBlock(scanner);
                    break;
                default:
                    ausgeben("Befehl ist nicht vorhanden");
                    return false;

            }
        } catch (NoSuchElementException e) {
            ausgeben("Eingabe war fehlerhaft überprüfen Sie die Eingabesyntax");
            return false;
        }
        return true;

    }

    private void setzePruefsteinfigur(Scanner scanner) {
        mSpielfeld.setzePruefsteinfigur(scanner.nextInt(), scanner.nextInt(), new Pruefsteinfigur(scanner.nextInt()));
    }

    private void setztSteckfigur(Scanner scanner) {
        mSpielfeld.setzeSteckfigur(scanner.nextInt(), scanner.nextInt(), new Steckfigur(scanner.nextInt()));
    }

    private void setztSteckfigurLoesung(Scanner scanner) {
        for (int i = 0; i < 4; i++) {
            mSpielfeld.setzeSteckfigur(i, new Steckfigur(scanner.nextInt()));
        }
    }

    public void ausgeben(String s) {
        System.out.print(s);
    }

    private void kontroliereBlock(Scanner scanner) {
        mSpielfeld.kontroliereBlock(scanner.nextInt());
    }

    private void loescheFeld() {
        for (int i = 0; i < 100; i++) {
            ausgeben("\n ");
        }
    }

    private void zeigeFeld() {
        Steckfigur[][] mFeld = mSpielfeld.getmFeld();
        String m = "";
        String g = "";
        Pruefsteinfigur[][] mpFeld = mSpielfeld.getmPFeld();
        ausgeben("Hier sind die     |      Hier sind die "
                + "\nVersuche des      |      Kontrollfiguren: "
                + "\nCodeknackess:     |\n");
        for (int i = 0; i < anzahlSpielboecke; i++) {
            for (int j = 0; j < 4; j++) {
                m += mFeld[i][j].getTyp() + " ";
                g += mpFeld[i][j].getTyp() + " ";
            }
            ausgeben(m + "      |      " + g + "\n");
            m = "";
            g = "";

        }
        ausgeben("\n");
    }

    private void zeigeLoesung() {
        Steckfigur[] zielCode = mSpielfeld.getZielCode();
        String s = "Hier ist der zuknackende Code:\n ";
        for (int i = 0; i < 4; i++) {
            s += zielCode[i].getTyp() + " ";
        }
        ausgeben(s);
    }
}
