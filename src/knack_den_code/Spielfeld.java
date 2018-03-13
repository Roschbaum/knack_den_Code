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
    
    public Spielfeld() {
        this.mFeld = new Spielblock[10];
        this.zielCode = new Steckfigur[4];
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
        int i = 0;
        while (i != blockNummer) {            
            i++;
            if (i >= 9) {
                return;
            }
        }
        mFeld[i].setzeSteckfigur(position, steckfigur);
        
    }

    /**
     * Setzt eine Spielfigur in den Lösungscode.
     * @param position Position der Spielfigur im Lösungscode.
     * @param steckfigur
     */
    public void setzeSteckfigur(int position,Steckfigur steckfigur){
        zielCode[position] = steckfigur;
    }
}
