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
public class Kontrolspieler {

    private static int anzahlanSteckfigurTypen;

    public Kontrolspieler(int anzahlanSteckfigurTypen) {
        Kontrolspieler.anzahlanSteckfigurTypen = anzahlanSteckfigurTypen;

    }

    /**
     * Bestimt die Anzahl der richtigen Steckfiguren.
     *
     * @param Loesung
     * @return Anzahl der richtigen Seckfiguren.(natürliche Zahl 0 bis 4)
     */
    public int koreckterTypundStelle(Steckfigur[] zielCode, Steckfigur[] versuchsFeld) {
        int z = 0;
        for (int i = 0; i < 4; i++) {
            if (zielCode[i].getTyp() == versuchsFeld[i].getTyp()) {
                z++;
            }
        }
        return z;
    }

    /**
     * Bestmt die Anzahl der Steckfiguren deren Typ korreckt ist
     *
     * @param zielCode Loesung
     * @return Natürliche Zahl zwischen 0-4
     */
    public int korreckterTyp(Steckfigur[] zielCode, Steckfigur[] versuchsFeld) {
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
