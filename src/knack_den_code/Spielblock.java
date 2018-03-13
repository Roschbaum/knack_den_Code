/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knack_den_code;

/**
 *
 * @author Friedrich
 */
public class Spielblock {

    private Steckfigur[] versuchsFeld;
    private Prüfsteinfigur[] kontrollFeld;
    private static int anzahlanSteckfigurTypen;

    public Spielblock(int anzahlanSteckfigurTypen) {
        Spielblock.anzahlanSteckfigurTypen = anzahlanSteckfigurTypen;
        this.versuchsFeld = new Steckfigur[4];
        this.kontrollFeld = new Prüfsteinfigur[4];
    }

    public Steckfigur[] getVersuchsfeld() {
        return versuchsFeld;
    }

    public Prüfsteinfigur[] getLösung() {
        return kontrollFeld;
    }

    /**
     * Setzt die Spielfigur an die angegebenen Stelle
     *
     * @param position Stelle, natürliche Zahl von 0 bis 3
     * @param steckfigur zu setzende Steckfigur
     */
    public void setzeSteckfigur(int position, Steckfigur steckfigur) {
        versuchsFeld[position] = steckfigur;
    }

    /**
     * Bestimt die Anzahl der richtigen Steckfiguren.
     *
     * @param Lösung
     * @return Anzahl der richtigen Seckfiguren.(natürliche Zahl 0 bis 4)
     */
    public int koreckterTypundStelle(Steckfigur[] zielCode) {
        int z = 0;
        for (int i = 0; i < 4; i++) {
            if (zielCode[i].getTyp() == versuchsFeld[i].getTyp()) {
                z++;
            }
        }
        return z;
    }

    public int korreckterTyp(Steckfigur[] zielCode) {
        int z = 0;
        int code;
        int versuch;
        for (int i = 0; i < anzahlanSteckfigurTypen; i++) {
            code = zähleTyp(i, zielCode);
            versuch = zähleTyp(i, versuchsFeld);
            if (code <= versuch) {
                z += code;
            } else {
                z += versuch;

            }
        }
        return z;
    }

    /**
     * Zählt die Spielfiguren des angegebenen Types in der Liste
     *
     * @param typ Typ der zu zählenden Spielfigurenart
     * @param liste Array aus dem Gezahählt werden soll
     * @return Anzahl der Steckfiguren des entsprechenden Types. Natürlichhe
     * Zahl
     */
    private int zähleTyp(int typ, Steckfigur[] liste) {
        int i = 0;
        for (Steckfigur steckfigur : liste) {
            if (steckfigur.getTyp() == typ) {
                i++;
            }
        }
        return i;
    }
}
