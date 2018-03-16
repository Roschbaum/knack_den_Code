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
public class Prüfsteinfigur {

    private int Typ;

    /**
     *  Prüfstein in der Realität
     * @param Typ Art des Steins zwischen 0-2
     */
    public Prüfsteinfigur(int Typ) {
        this.Typ = Typ;
    }

    public int getTyp() {
        return Typ;
    }
    
}
