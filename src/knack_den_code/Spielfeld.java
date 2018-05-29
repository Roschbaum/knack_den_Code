package knack_den_code;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Friedrich
 */
public class Spielfeld {

    private Steckfigur[][] mFeld;
    private Pruefsteinfigur[][] mPFeld;
    private Steckfigur[] zielCode;
    private static int anzahlSpielbloecke;
    private Kontrolspieler kontrolspieler;

    public Spielfeld(int anzahlSpielbloecke, int anzahlanSteckfigurTypen) {
        this.mPFeld = new Pruefsteinfigur[anzahlSpielbloecke][4];
        Spielfeld.anzahlSpielbloecke = anzahlSpielbloecke;
        this.mFeld = new Steckfigur[anzahlSpielbloecke][4];
        this.zielCode = new Steckfigur[4];
        kontrolspieler = new Kontrolspieler(anzahlanSteckfigurTypen);
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
     * Ãœberprueft den angegebenen Block und setzt die Pruefsteinfiguren.
     *
     * @param block Nummer des zu ueberpruefenden Blockes. Natuerliche Zahl.
     */
    public void kontroliereBlock(int block) {
        Steckfigur[] blockArr = kopiereBlock(block);
        int koreckterTypundStelle = kontrolspieler.koreckterTypundStelle(zielCode, blockArr);
        int koreckterTyp = kontrolspieler.korreckterTyp(zielCode, blockArr) - koreckterTypundStelle;
            for (int i = 0; i < koreckterTypundStelle; i++) {
                mPFeld[block][i ] = new Pruefsteinfigur(2);
            }
        
        for (int i = koreckterTypundStelle; i < koreckterTyp + koreckterTypundStelle; i++) {
            mPFeld[block][i] = new Pruefsteinfigur(1);
        }
    }

    private void befuelleSpielfeld() {
        for (int i = 0; i < anzahlSpielbloecke; i++) {
            for (int j = 0; j < 4; j++) {
                mFeld[i][j] = new Steckfigur(-1);
                mPFeld[i][j] = new Pruefsteinfigur(-1);
            }
        }

    }

    private Steckfigur[] kopiereBlock(int block) {
        Steckfigur[] blockArr = new Steckfigur[4];
        for (int i = 0; i < 4; i++) {
            blockArr[i] = mFeld[block][i];
        }
        return blockArr;
    }
}
