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
public class Spielfeld {

    private Spielblock[] mFeld;
    private Steckfigur[] zielCode;
    private static int anzahlSpielblöcke;
    public Spielfeld(int  anzahlSpielblöcke,int anzahlanSteckfigurTypen) {
        Spielfeld.anzahlSpielblöcke = anzahlSpielblöcke;
        this.mFeld = new Spielblock[anzahlSpielblöcke];
        this.zielCode = new Steckfigur[4];
        inizalisiereMFeld(anzahlanSteckfigurTypen);
    }
    private  void inizalisiereMFeld(int anzahlanSteckfigurTypen){
        for (int i = 0; i < anzahlSpielblöcke; i++) {
            mFeld[i]= new Spielblock(anzahlanSteckfigurTypen);
        }
    }

    /**
     * Sortiert die Spielfigur im Spielfeld an der entsprechenden Position ein.
     *
     * @param blockNummer Gibt die Position des Blockes an. Natürliche Zahl 0
     * bis 9. 0 ist im Spielfeld links.
     * @param position Gibt die Position im Block an. Natürliche Zahl 0 bis 3. 0
     * ist im Spilfeld unten
     * @param steckfigur einzusetzende Spielfigur.
     */
    public void setzeSteckfigur(int blockNummer, int position, Steckfigur steckfigur) {
        mFeld[blockNummer].setzeSteckfigur(position, steckfigur);
    }

    /**
     * Setzt eine Spielfigur in den Lösungscode.
     * @param position Position der Spielfigur im Lösungscode.
     * @param steckfigur
     */
    public void setzeSteckfigur(int position,Steckfigur steckfigur){
        zielCode[position] = steckfigur;
    }

    /**
     *  Überprüft den angegebenen Block und setzt die Prüfsteinfiguren.
     * @param block Nummerr des zu überprüfenden Blockes.Natürliche Zahl zwischen 0 bis 9
     */
    public void kontroliereBlock(int block){
        int koreckterTypundStelle = mFeld[block].koreckterTypundStelle(zielCode);
        int koreckterTyp = mFeld[block].korreckterTyp(zielCode)-koreckterTypundStelle;
    }
}
