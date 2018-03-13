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
public class Steckfigur {

    private int Typ;

    /**
     * Erstellt eine Spielfigur
     * @param Typ natürliche Zahl von 1 bis 5 
     */
    public Steckfigur(int Typ) {
        this.Typ = Typ;
    }

    public int getTyp() {
        return Typ;
    }

}
