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

    private Steckfigur[][] mFeld;
    private Pruefsteinfigur[][] mPFeld;
    private Steckfigur[] zielCode;
    private static int anzahlSpielbloecke;
    private Kontrolspieler mKontrolspieler;

    public Spielfeld(int anzahlSpielbloecke, int anzahlanSteckfigurTypen) {
        this.mPFeld = new Pruefsteinfigur[anzahlSpielbloecke][4];
        Spielfeld.anzahlSpielbloecke = anzahlSpielbloecke;
        this.mFeld = new Steckfigur[anzahlSpielbloecke][4];
        this.zielCode = new Steckfigur[4];
        befuelleSpielfeld();
    }

    public Steckfigur[][] getmFeld() {
        return mFeld;

    }

    public Steckfigur[] getZielCode() {
        return zielCode;
    }

    public Pruefsteinfigur[][] getmPFeld() {
        return mPFeld;
    }

    /**
     * Sortiert die Spielfigur im Spielfeld an der entsprechenden Position ein.
     *
     * @param blockNummer Gibt die Position des Blockes an. Natuerliche Zahl 0
     * bis 9. 0 ist im Spielfeld links.
     * @param position Gibt die Position im Block an. Natuerliche Zahl 0 bis 3.
     * 0 ist im Spilfeld unten
     * @param steckfigur einzusetzende Spielfigur.
     */
    public void setzeSteckfigur(int blockNummer, int position, Steckfigur steckfigur) {
        mFeld[blockNummer][position] = steckfigur;
    }

    /**
     * Setzt eine Spielfigur in den Loesungscode.
     *
     * @param position Position der Spielfigur im Loesungscode.
     * @param steckfigur
     */
    public void setzeSteckfigur(int position, Steckfigur steckfigur) {
        zielCode[position] = steckfigur;
        System.out.println(steckfigur.getTyp());
    }

    /**
     *
     * @param blockNummer
     * @param position
     * @param pruefsteinfigur
     */
    public void setzePruefsteinfigur(int blockNummer, int position, Pruefsteinfigur pruefsteinfigur) {
        mPFeld[blockNummer][position] = pruefsteinfigur;
    }

    /**
     * Überprueft den angegebenen Block und setzt die Pruefsteinfiguren.
     *
     * @param block Nummerr des zu ueberpruefenden Blockes.Natuerliche Zahl
     * zwischen 0 bis 9
     */
    public void kontroliereBlock(int block) {
        Steckfigur[] blockkopie;
        blockkopie = new Steckfigur[4];
        for (int i = 0; i < 4; i++) {
            blockkopie[i] = mFeld[block][i];
        }
        int koreckterTypundStelle = mKontrolspieler.koreckterTypundStelle(blockkopie, zielCode);
        int koreckterTyp = mKontrolspieler.korreckterTyp(blockkopie,zielCode) - koreckterTypundStelle;
        
        
    }

    private void befuelleSpielfeld() {
        for (int i = 0; i < anzahlSpielbloecke; i++) {
            for (int j = 0; j < 4; j++) {
                mFeld[i][j] = new Steckfigur(-1);
                mPFeld[i][j] = new Pruefsteinfigur(-1);
            }
        }

    }
}
