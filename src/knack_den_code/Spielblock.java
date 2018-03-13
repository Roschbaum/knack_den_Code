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

    public Spielblock() {
        this.versuchsFeld = new Steckfigur[4];
        this.kontrollFeld = new Prüfsteinfigur[4];
    }

    public Steckfigur[] getVersuchsfeld() {
        return versuchsFeld;
    }

    public Prüfsteinfigur[] getLösung() {
        return kontrollFeld;
    }

    public void setzeSteckfigur(int position,Steckfigur steckfigur){
        versuchsFeld[position] = steckfigur;
    }
}
